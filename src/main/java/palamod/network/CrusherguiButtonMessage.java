package palamod.network;

import palamod.procedures.*;

import palamod.PalamodMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

@EventBusSubscriber
public record CrusherguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<CrusherguiButtonMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PalamodMod.MODID, "crushergui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CrusherguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CrusherguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CrusherguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<CrusherguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final CrusherguiButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			Crusherluncherv2titaneProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			Crusherluncherv2endiumProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			Crusherluncherv2amethystProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			Crusherluncherv2paladiumProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			ChangecrushershowpctgProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			ChangecrusherpromodeProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			ConnectpalahelpcrushercraftProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(CrusherguiButtonMessage.TYPE, CrusherguiButtonMessage.STREAM_CODEC, CrusherguiButtonMessage::handleData);
	}
}
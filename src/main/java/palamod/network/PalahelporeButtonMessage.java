package palamod.network;

import palamod.procedures.CloseguiProcedure;
import palamod.procedures.BlockbackProcedure;
import palamod.procedures.BackpalahelpProcedure;

import palamod.PalamodMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

@EventBusSubscriber
public record PalahelporeButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<PalahelporeButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "palahelpore_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PalahelporeButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PalahelporeButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PalahelporeButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<PalahelporeButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PalahelporeButtonMessage message, final IPayloadContext context) {
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

			BackpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			BlockbackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			CloseguiProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(PalahelporeButtonMessage.TYPE, PalahelporeButtonMessage.STREAM_CODEC, PalahelporeButtonMessage::handleData);
	}
}
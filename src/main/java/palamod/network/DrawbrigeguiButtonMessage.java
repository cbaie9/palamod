package palamod.network;

import palamod.procedures.SetblockwestProcedure;
import palamod.procedures.SetblocksouthProcedure;
import palamod.procedures.SetblocknorthProcedure;
import palamod.procedures.SetblockeastProcedure;

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
import net.minecraft.core.BlockPos;

@EventBusSubscriber
public record DrawbrigeguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<DrawbrigeguiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "drawbrigegui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, DrawbrigeguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, DrawbrigeguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new DrawbrigeguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<DrawbrigeguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final DrawbrigeguiButtonMessage message, final IPayloadContext context) {
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
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetblocksouthProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			SetblockeastProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			SetblocknorthProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			SetblockwestProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(DrawbrigeguiButtonMessage.TYPE, DrawbrigeguiButtonMessage.STREAM_CODEC, DrawbrigeguiButtonMessage::handleData);
	}
}
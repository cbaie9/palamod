package palamod.network;

import palamod.procedures.*;

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
public record CrushercraftpalahelpguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<CrushercraftpalahelpguiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "crushercraftpalahelpgui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CrushercraftpalahelpguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CrushercraftpalahelpguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new CrushercraftpalahelpguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<CrushercraftpalahelpguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final CrushercraftpalahelpguiButtonMessage message, final IPayloadContext context) {
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

			CrushercraftpaladiumProcedure.execute(entity);
		}
		if (buttonID == 1) {

			CrushercraftamethystProcedure.execute(entity);
		}
		if (buttonID == 2) {

			CrushercrafttitaneProcedure.execute(entity);
		}
		if (buttonID == 3) {

			CrushercraftendiumProcedure.execute(entity);
		}
		if (buttonID == 4) {

			ConnectpalahelpcrusherProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			CloseguiProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(CrushercraftpalahelpguiButtonMessage.TYPE, CrushercraftpalahelpguiButtonMessage.STREAM_CODEC, CrushercraftpalahelpguiButtonMessage::handleData);
	}
}
package palamod.network;

import palamod.procedures.OpenexamplegrinderProcedure;
import palamod.procedures.ConnectNewPalahelpProcedure;
import palamod.procedures.ConnectNewPalahelpCommandProcedure;

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
public record GrinderpalahelpguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<GrinderpalahelpguiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "grinderpalahelpgui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GrinderpalahelpguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GrinderpalahelpguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new GrinderpalahelpguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<GrinderpalahelpguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final GrinderpalahelpguiButtonMessage message, final IPayloadContext context) {
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

			ConnectNewPalahelpCommandProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			OpenexamplegrinderProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectNewPalahelpProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(GrinderpalahelpguiButtonMessage.TYPE, GrinderpalahelpguiButtonMessage.STREAM_CODEC, GrinderpalahelpguiButtonMessage::handleData);
	}
}
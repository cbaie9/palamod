package palamod.network;

import palamod.procedures.ConnectPalahelpTreeProcedure;
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
public record PalahelpneworeliquidButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<PalahelpneworeliquidButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "palahelpneworeliquid_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PalahelpneworeliquidButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PalahelpneworeliquidButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PalahelpneworeliquidButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<PalahelpneworeliquidButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PalahelpneworeliquidButtonMessage message, final IPayloadContext context) {
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

			ConnectNewPalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectPalahelpTreeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectNewPalahelpCommandProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(PalahelpneworeliquidButtonMessage.TYPE, PalahelpneworeliquidButtonMessage.STREAM_CODEC, PalahelpneworeliquidButtonMessage::handleData);
	}
}
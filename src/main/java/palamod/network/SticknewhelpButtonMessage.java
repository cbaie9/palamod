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
public record SticknewhelpButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<SticknewhelpButtonMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PalamodMod.MODID, "sticknewhelp_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, SticknewhelpButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SticknewhelpButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new SticknewhelpButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<SticknewhelpButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final SticknewhelpButtonMessage message, final IPayloadContext context) {
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

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ConnectitemmenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BackpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			PalahelpstickmodespeedProcedure.execute(world, entity);
		}
		if (buttonID == 4) {

			PalahelpstickmodejumpProcedure.execute(world, entity);
		}
		if (buttonID == 5) {

			PalahelpstickmodehyperjumpProcedure.execute(world, entity);
		}
		if (buttonID == 6) {

			PalahelpstickmodehealProcedure.execute(world, entity);
		}
		if (buttonID == 7) {

			PalahelpstickmodedamageProcedure.execute(world, entity);
		}
		if (buttonID == 8) {

			PalahelpstickmodestrenghtProcedure.execute(world, entity);
		}
		if (buttonID == 9) {

			PalahelpstickmodesogProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(SticknewhelpButtonMessage.TYPE, SticknewhelpButtonMessage.STREAM_CODEC, SticknewhelpButtonMessage::handleData);
	}
}
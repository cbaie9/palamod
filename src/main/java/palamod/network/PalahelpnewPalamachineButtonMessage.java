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
import net.minecraft.core.SectionPos;

@EventBusSubscriber
public record PalahelpnewPalamachineButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<PalahelpnewPalamachineButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "palahelpnew_palamachine_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, PalahelpnewPalamachineButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PalahelpnewPalamachineButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new PalahelpnewPalamachineButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<PalahelpnewPalamachineButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final PalahelpnewPalamachineButtonMessage message, final IPayloadContext context) {
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

			PalahelpstickmodespeedProcedure.execute(entity);
		}
		if (buttonID == 4) {

			PalahelpstickmodejumpProcedure.execute(entity);
		}
		if (buttonID == 5) {

			PalahelpstickmodehyperjumpProcedure.execute(entity);
		}
		if (buttonID == 6) {

			PalahelpstickmodehealProcedure.execute(entity);
		}
		if (buttonID == 7) {

			PalahelpstickmodedamageProcedure.execute(entity);
		}
		if (buttonID == 8) {

			PalahelpstickmodestrenghtProcedure.execute(entity);
		}
		if (buttonID == 9) {

			PalahelpstickmodesogProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(PalahelpnewPalamachineButtonMessage.TYPE, PalahelpnewPalamachineButtonMessage.STREAM_CODEC, PalahelpnewPalamachineButtonMessage::handleData);
	}
}
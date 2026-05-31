package palamod.network;

import palamod.procedures.TrixiumdepositprocessProcedure;
import palamod.procedures.CloseguiProcedure;

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
public record TrixiumdepositButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<TrixiumdepositButtonMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PalamodMod.MODID, "trixiumdeposit_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, TrixiumdepositButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, TrixiumdepositButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new TrixiumdepositButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<TrixiumdepositButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final TrixiumdepositButtonMessage message, final IPayloadContext context) {
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

			TrixiumdepositprocessProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			CloseguiProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(TrixiumdepositButtonMessage.TYPE, TrixiumdepositButtonMessage.STREAM_CODEC, TrixiumdepositButtonMessage::handleData);
	}
}
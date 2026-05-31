package palamod.network;

import palamod.procedures.Adminshop_openProcedure;

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
public record AdminshopkeyblindingMessage(int eventType, int pressedms) implements CustomPacketPayload {
	public static final Type<AdminshopkeyblindingMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "key_adminshopkeyblinding"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AdminshopkeyblindingMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AdminshopkeyblindingMessage message) -> {
		buffer.writeInt(message.eventType);
		buffer.writeInt(message.pressedms);
	}, (RegistryFriendlyByteBuf buffer) -> new AdminshopkeyblindingMessage(buffer.readInt(), buffer.readInt()));

	@Override
	public Type<AdminshopkeyblindingMessage> type() {
		return TYPE;
	}

	public static void handleData(final AdminshopkeyblindingMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				pressAction(context.player(), message.eventType, message.pressedms);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (type == 0) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshopkeyblindingMessage.TYPE, AdminshopkeyblindingMessage.STREAM_CODEC, AdminshopkeyblindingMessage::handleData);
	}
}
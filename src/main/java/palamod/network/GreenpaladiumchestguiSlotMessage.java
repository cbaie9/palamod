package palamod.network;

import palamod.procedures.Rustinechests1Procedure;
import palamod.procedures.RingchestprocessProcedure;

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
public record GreenpaladiumchestguiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {

	public static final Type<GreenpaladiumchestguiSlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "greenpaladiumchestgui_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GreenpaladiumchestguiSlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GreenpaladiumchestguiSlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new GreenpaladiumchestguiSlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<GreenpaladiumchestguiSlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final GreenpaladiumchestguiSlotMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleSlotAction(context.player(), message.slotID, message.changeType, message.meta, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 5 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 7 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 8 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 9 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 10 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 11 && changeType == 0) {

			RingchestprocessProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 109 && changeType == 0) {

			Rustinechests1Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(GreenpaladiumchestguiSlotMessage.TYPE, GreenpaladiumchestguiSlotMessage.STREAM_CODEC, GreenpaladiumchestguiSlotMessage::handleData);
	}
}
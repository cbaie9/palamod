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
public record CobblebreakerguiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {
	public static final Type<CobblebreakerguiSlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "cobblebreakergui_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, CobblebreakerguiSlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, CobblebreakerguiSlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new CobblebreakerguiSlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<CobblebreakerguiSlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final CobblebreakerguiSlotMessage message, final IPayloadContext context) {
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
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (slot == 1 && changeType == 1) {
			int amount = meta;

			CobblebreakergivexpironProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpironProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 1) {
			int amount = meta;

			CobblebreakergivexpgoldProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpgoldProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 1) {
			int amount = meta;

			CobblebreakergivexpdiamondProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpdiamondProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 1) {
			int amount = meta;

			CobblebreakergivexpamethystProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpamethystProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 5 && changeType == 1) {
			int amount = meta;

			CobblebreakergivexptitaneProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 5 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexptitaneProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 1) {
			int amount = meta;

			CobblebreakergivexppaladiumProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexppaladiumProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 7 && changeType == 1) {
			int amount = meta;

			CobblebreakergivexpgreenpaladiumProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 7 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpgreenpaladiumProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(CobblebreakerguiSlotMessage.TYPE, CobblebreakerguiSlotMessage.STREAM_CODEC, CobblebreakerguiSlotMessage::handleData);
	}
}
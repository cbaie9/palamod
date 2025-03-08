
package palamod.network;

import palamod.world.inventory.GodvillagerguiMenu;

import palamod.procedures.UsecraftgodvillagerProcedure;
import palamod.procedures.GodvillagercheckpalaProcedure;

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

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record GodvillagerguiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) implements CustomPacketPayload {

	public static final Type<GodvillagerguiSlotMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "godvillagergui_slots"));
	public static final StreamCodec<RegistryFriendlyByteBuf, GodvillagerguiSlotMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, GodvillagerguiSlotMessage message) -> {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}, (RegistryFriendlyByteBuf buffer) -> new GodvillagerguiSlotMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<GodvillagerguiSlotMessage> type() {
		return TYPE;
	}

	public static void handleData(final GodvillagerguiSlotMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int slotID = message.slotID;
				int changeType = message.changeType;
				int meta = message.meta;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleSlotAction(entity, slotID, changeType, meta, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = GodvillagerguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 0 && changeType == 0) {

			GodvillagercheckpalaProcedure.execute(entity);
		}
		if (slot == 0 && changeType == 1) {

			GodvillagercheckpalaProcedure.execute(entity);
		}
		if (slot == 0 && changeType == 2) {
			int amount = meta;

			GodvillagercheckpalaProcedure.execute(entity);
		}
		if (slot == 3 && changeType == 1) {

			UsecraftgodvillagerProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 0) {

			UsecraftgodvillagerProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 1) {

			UsecraftgodvillagerProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 2) {
			int amount = meta;

			UsecraftgodvillagerProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(GodvillagerguiSlotMessage.TYPE, GodvillagerguiSlotMessage.STREAM_CODEC, GodvillagerguiSlotMessage::handleData);
	}
}

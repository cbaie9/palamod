
package palamod.network;

import palamod.world.inventory.CobblebreakerguiMenu;

import palamod.procedures.CobblebreakergivexptitaneProcedure;
import palamod.procedures.CobblebreakergivexppaladiumProcedure;
import palamod.procedures.CobblebreakergivexpironProcedure;
import palamod.procedures.CobblebreakergivexpgreenpaladiumProcedure;
import palamod.procedures.CobblebreakergivexpgoldProcedure;
import palamod.procedures.CobblebreakergivexpdiamondProcedure;
import palamod.procedures.CobblebreakergivexpamethystProcedure;

import palamod.PalamodMod;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CobblebreakerguiSlotMessage {
	private final int slotID, x, y, z, changeType, meta;

	public CobblebreakerguiSlotMessage(int slotID, int x, int y, int z, int changeType, int meta) {
		this.slotID = slotID;
		this.x = x;
		this.y = y;
		this.z = z;
		this.changeType = changeType;
		this.meta = meta;
	}

	public CobblebreakerguiSlotMessage(FriendlyByteBuf buffer) {
		this.slotID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
		this.changeType = buffer.readInt();
		this.meta = buffer.readInt();
	}

	public static void buffer(CobblebreakerguiSlotMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.slotID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
		buffer.writeInt(message.changeType);
		buffer.writeInt(message.meta);
	}

	public static void handler(CobblebreakerguiSlotMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int slotID = message.slotID;
			int changeType = message.changeType;
			int meta = message.meta;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleSlotAction(entity, slotID, changeType, meta, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleSlotAction(Player entity, int slot, int changeType, int meta, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = CobblebreakerguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (slot == 1 && changeType == 1) {

			CobblebreakergivexpironProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 1 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpironProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 1) {

			CobblebreakergivexpgoldProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 2 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpgoldProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 1) {

			CobblebreakergivexpdiamondProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 3 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpdiamondProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 1) {

			CobblebreakergivexpamethystProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 4 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpamethystProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 5 && changeType == 1) {

			CobblebreakergivexptitaneProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 5 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexptitaneProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 1) {

			CobblebreakergivexppaladiumProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 6 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexppaladiumProcedure.execute(world, x, y, z, entity);
		}
		if (slot == 7 && changeType == 2) {
			int amount = meta;

			CobblebreakergivexpgreenpaladiumProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(CobblebreakerguiSlotMessage.class, CobblebreakerguiSlotMessage::buffer, CobblebreakerguiSlotMessage::new, CobblebreakerguiSlotMessage::handler);
	}
}

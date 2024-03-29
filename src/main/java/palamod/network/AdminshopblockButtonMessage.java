
package palamod.network;

import palamod.world.inventory.AdminshopblockMenu;

import palamod.procedures.ConnectadhblkstoneProcedure;
import palamod.procedures.ConnectadhblksoulsandProcedure;
import palamod.procedures.ConnectadhblksandProcedure;
import palamod.procedures.ConnectadhblkoakwoodProcedure;
import palamod.procedures.ConnectadhblknetherrackProcedure;
import palamod.procedures.ConnectadhblkgravelProcedure;
import palamod.procedures.ConnectadhblkgrassProcedure;
import palamod.procedures.ConnectadhblkglowstoneProcedure;
import palamod.procedures.ConnectadhblkdirtProcedure;
import palamod.procedures.ConnectadhblkblackstoneProcedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.Adminshop_openProcedure;

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
public class AdminshopblockButtonMessage {
	private final int buttonID, x, y, z;

	public AdminshopblockButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdminshopblockButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdminshopblockButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdminshopblockButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = AdminshopblockMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectadhblkdirtProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectadhblkgrassProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectadhblkstoneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadhblknetherrackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadhblksoulsandProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadhblksandProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectadhblkgravelProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectadhblkglowstoneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectadhblkoakwoodProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ConnectadhblkblackstoneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 11) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshopblockButtonMessage.class, AdminshopblockButtonMessage::buffer, AdminshopblockButtonMessage::new, AdminshopblockButtonMessage::handler);
	}
}

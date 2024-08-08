
package palamod.network;

import palamod.world.inventory.AdminshopmenuMenu;

import palamod.procedures.ConnectadminshoputilitiesProcedure;
import palamod.procedures.ConnectadminshopplantProcedure;
import palamod.procedures.ConnectadminshopmobsProcedure;
import palamod.procedures.ConnectadhoreProcedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.AdminshopblockconnectProcedure;

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
public class AdminshopmenuButtonMessage {
	private final int buttonID, x, y, z;

	public AdminshopmenuButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdminshopmenuButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdminshopmenuButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdminshopmenuButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AdminshopmenuMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ConnectadhoreProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			AdminshopblockconnectProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadminshopplantProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadminshopmobsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadminshoputilitiesProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshopmenuButtonMessage.class, AdminshopmenuButtonMessage::buffer, AdminshopmenuButtonMessage::new, AdminshopmenuButtonMessage::handler);
	}
}

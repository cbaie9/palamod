
package palamod.network;

import palamod.world.inventory.AdminshopplantMenu;

import palamod.procedures.ConnectadminshopplantwheatProcedure;
import palamod.procedures.ConnectadminshopplantwarpedfungusProcedure;
import palamod.procedures.ConnectadminshopplantsugarcaneProcedure;
import palamod.procedures.ConnectadminshopplantredmushroomProcedure;
import palamod.procedures.ConnectadminshopplantpotatoProcedure;
import palamod.procedures.ConnectadminshopplantmelonProcedure;
import palamod.procedures.ConnectadminshopplantcrimsonfungusProcedure;
import palamod.procedures.ConnectadminshopplantcarrotProcedure;
import palamod.procedures.ConnectadminshopplantcactusProcedure;
import palamod.procedures.ConnectadminshopplantbrownmushroomProcedure;
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
public class AdminshopplantButtonMessage {
	private final int buttonID, x, y, z;

	public AdminshopplantButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdminshopplantButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdminshopplantButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdminshopplantButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AdminshopplantMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectadminshopplantcactusProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectadminshopplantredmushroomProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectadminshopplantbrownmushroomProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadminshopplantwarpedfungusProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadminshopplantcrimsonfungusProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadminshopplantpotatoProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectadminshopplantwheatProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectadminshopplantcarrotProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectadminshopplantmelonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ConnectadminshopplantsugarcaneProcedure.execute(world, x, y, z, entity);
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
		PalamodMod.addNetworkMessage(AdminshopplantButtonMessage.class, AdminshopplantButtonMessage::buffer, AdminshopplantButtonMessage::new, AdminshopplantButtonMessage::handler);
	}
}

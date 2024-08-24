
package palamod.network;

import palamod.world.inventory.AdminshoporeMenu;

import palamod.procedures.ConnectadminshoputilitiesredstoneProcedure;
import palamod.procedures.ConnectadminshoputilitiesemeraldProcedure;
import palamod.procedures.ConnectadhoretitaneProcedure;
import palamod.procedures.ConnectadhorepalaProcedure;
import palamod.procedures.ConnectadhoreironProcedure;
import palamod.procedures.ConnectadhoregoldProcedure;
import palamod.procedures.ConnectadhorefindiumProcedure;
import palamod.procedures.ConnectadhorediamondProcedure;
import palamod.procedures.ConnectadhorecoalProcedure;
import palamod.procedures.ConnectadhoreameProcedure;
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
public class AdminshoporeButtonMessage {
	private final int buttonID, x, y, z;

	public AdminshoporeButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdminshoporeButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdminshoporeButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdminshoporeButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AdminshoporeMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectadhorepalaProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectadhoretitaneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectadhoreameProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadhorefindiumProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadhorediamondProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadhoreironProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectadhoregoldProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectadhorecoalProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectadminshoputilitiesredstoneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ConnectadminshoputilitiesemeraldProcedure.execute(world, x, y, z, entity);
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
		PalamodMod.addNetworkMessage(AdminshoporeButtonMessage.class, AdminshoporeButtonMessage::buffer, AdminshoporeButtonMessage::new, AdminshoporeButtonMessage::handler);
	}
}

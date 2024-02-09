
package palamod.network;

import palamod.world.inventory.Adminshopmobs2Menu;

import palamod.procedures.ConnectadminshopmobsProcedure;
import palamod.procedures.ConnectAdminshopmobs2steakProcedure;
import palamod.procedures.ConnectAdminshopmobs2leatherProcedure;
import palamod.procedures.ConnectAdminshopmobs2inksacProcedure;
import palamod.procedures.ConnectAdminshopmobs2honeycombProcedure;
import palamod.procedures.ConnectAdminshopmobs2gunpowderProcedure;
import palamod.procedures.ConnectAdminshopmobs2glowinksacProcedure;
import palamod.procedures.ConnectAdminshopmobs2featherProcedure;
import palamod.procedures.ConnectAdminshopmobs2blazeProcedure;
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
public class Adminshopmobs2ButtonMessage {
	private final int buttonID, x, y, z;

	public Adminshopmobs2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public Adminshopmobs2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(Adminshopmobs2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(Adminshopmobs2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = Adminshopmobs2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectAdminshopmobs2honeycombProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectAdminshopmobs2leatherProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectAdminshopmobs2featherProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectAdminshopmobs2inksacProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectAdminshopmobs2glowinksacProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectAdminshopmobs2blazeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectAdminshopmobs2gunpowderProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectAdminshopmobs2steakProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			ConnectadminshopmobsProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(Adminshopmobs2ButtonMessage.class, Adminshopmobs2ButtonMessage::buffer, Adminshopmobs2ButtonMessage::new, Adminshopmobs2ButtonMessage::handler);
	}
}


package palamod.network;

import palamod.world.inventory.Adminshopmobs2gunpowderMenu;

import palamod.procedures.Connectadminshopmobs2Procedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.Adminshop_openProcedure;
import palamod.procedures.Adhmobs2sellgunpowderProcedure;
import palamod.procedures.Adhmobs2buygunpowderProcedure;

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
public class Adminshopmobs2gunpowderButtonMessage {
	private final int buttonID, x, y, z;

	public Adminshopmobs2gunpowderButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public Adminshopmobs2gunpowderButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(Adminshopmobs2gunpowderButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(Adminshopmobs2gunpowderButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = Adminshopmobs2gunpowderMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Adhmobs2buygunpowderProcedure.execute(world, entity, guistate);
		}
		if (buttonID == 1) {

			Adhmobs2sellgunpowderProcedure.execute(world, entity, guistate);
		}
		if (buttonID == 2) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 3) {

			Connectadminshopmobs2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(Adminshopmobs2gunpowderButtonMessage.class, Adminshopmobs2gunpowderButtonMessage::buffer, Adminshopmobs2gunpowderButtonMessage::new, Adminshopmobs2gunpowderButtonMessage::handler);
	}
}

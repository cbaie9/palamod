
package palamod.network;

import palamod.world.inventory.AdminpanelmenuMenu;

import palamod.procedures.SpawnpanelconnectProcedure;
import palamod.procedures.Palaerror6connectProcedure;
import palamod.procedures.MoneypanelconnectProcedure;
import palamod.procedures.HdvstocksopenProcedure;

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
public class AdminpanelmenuButtonMessage {
	private final int buttonID, x, y, z;

	public AdminpanelmenuButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdminpanelmenuButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdminpanelmenuButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdminpanelmenuButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AdminpanelmenuMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			HdvstocksopenProcedure.execute(world, entity);
		}
		if (buttonID == 1) {

			MoneypanelconnectProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SpawnpanelconnectProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Palaerror6connectProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Palaerror6connectProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminpanelmenuButtonMessage.class, AdminpanelmenuButtonMessage::buffer, AdminpanelmenuButtonMessage::new, AdminpanelmenuButtonMessage::handler);
	}
}


package palamod.network;

import palamod.world.inventory.AdminshoputilitiesdiampicMenu;

import palamod.procedures.ConnectadminshoputilitiesProcedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.AdminshoputilitiesbuydiampicProcedure;
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
public class AdminshoputilitiesdiampicButtonMessage {
	private final int buttonID, x, y, z;

	public AdminshoputilitiesdiampicButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdminshoputilitiesdiampicButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdminshoputilitiesdiampicButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdminshoputilitiesdiampicButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AdminshoputilitiesdiampicMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AdminshoputilitiesbuydiampicProcedure.execute(world, entity, guistate);
		}
		if (buttonID == 1) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 2) {

			ConnectadminshoputilitiesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshoputilitiesdiampicButtonMessage.class, AdminshoputilitiesdiampicButtonMessage::buffer, AdminshoputilitiesdiampicButtonMessage::new, AdminshoputilitiesdiampicButtonMessage::handler);
	}
}

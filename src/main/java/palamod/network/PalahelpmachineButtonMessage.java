
package palamod.network;

import palamod.world.inventory.PalahelpmachineMenu;

import palamod.procedures.ConnectpalamachinepalahelpProcedure;
import palamod.procedures.ConnectpalahelpcrusherProcedure;
import palamod.procedures.ConnectnotyetguiProcedure;
import palamod.procedures.Connectgrinderpag1Procedure;
import palamod.procedures.ConnectforgepalahelpProcedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.BlockbackProcedure;
import palamod.procedures.BackpalahelpProcedure;

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
public class PalahelpmachineButtonMessage {
	private final int buttonID, x, y, z;

	public PalahelpmachineButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public PalahelpmachineButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(PalahelpmachineButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(PalahelpmachineButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = PalahelpmachineMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Connectgrinderpag1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectpalamachinepalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectpalahelpcrusherProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectforgepalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectnotyetguiProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectnotyetguiProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectnotyetguiProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			BlockbackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			BackpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			CloseguiProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(PalahelpmachineButtonMessage.class, PalahelpmachineButtonMessage::buffer, PalahelpmachineButtonMessage::new, PalahelpmachineButtonMessage::handler);
	}
}

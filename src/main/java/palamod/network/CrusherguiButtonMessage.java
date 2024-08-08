
package palamod.network;

import palamod.world.inventory.CrusherguiMenu;

import palamod.procedures.Crusherluncherv2titaneProcedure;
import palamod.procedures.Crusherluncherv2paladiumProcedure;
import palamod.procedures.Crusherluncherv2endiumProcedure;
import palamod.procedures.Crusherluncherv2amethystProcedure;

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
public class CrusherguiButtonMessage {
	private final int buttonID, x, y, z;

	public CrusherguiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CrusherguiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CrusherguiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CrusherguiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CrusherguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			Crusherluncherv2endiumProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			Crusherluncherv2paladiumProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			Crusherluncherv2titaneProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			Crusherluncherv2amethystProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(CrusherguiButtonMessage.class, CrusherguiButtonMessage::buffer, CrusherguiButtonMessage::new, CrusherguiButtonMessage::handler);
	}
}

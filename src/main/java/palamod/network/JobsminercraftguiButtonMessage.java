
package palamod.network;

import palamod.world.inventory.JobsminercraftguiMenu;

import palamod.procedures.JobsminercraftwoddenspikeProcedure;
import palamod.procedures.JobsminercraftvoidstoneProcedure;
import palamod.procedures.JobsminercrafttitanespikeProcedure;
import palamod.procedures.JobsminercraftslimeobsidianProcedure;
import palamod.procedures.JobsminercraftpaladiumspikeProcedure;
import palamod.procedures.JobsminercraftobsidianpickaxeProcedure;
import palamod.procedures.JobsminercraftmagicialtoolProcedure;
import palamod.procedures.JobsminercraftlavaobsidianProcedure;
import palamod.procedures.JobsminercraftironspikeProcedure;
import palamod.procedures.JobsminercraftgoldenspikeProcedure;
import palamod.procedures.JobsminercraftfakewaterobsidianProcedure;
import palamod.procedures.JobsminercraftendiumpickaxeProcedure;
import palamod.procedures.JobsminercraftdiamondspikeProcedure;
import palamod.procedures.JobsminercraftcompactobsidianProcedure;
import palamod.procedures.JobsminercraftboomtntProcedure;
import palamod.procedures.JobsminercraftamethystspikeProcedure;
import palamod.procedures.JobsminercraftamethystexcavatorProcedure;
import palamod.procedures.CloseguiProcedure;

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
public class JobsminercraftguiButtonMessage {
	private final int buttonID, x, y, z;

	public JobsminercraftguiButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public JobsminercraftguiButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(JobsminercraftguiButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(JobsminercraftguiButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = JobsminercraftguiMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 1) {

			JobsminercraftendiumpickaxeProcedure.execute(entity);
		}
		if (buttonID == 3) {

			JobsminercraftamethystexcavatorProcedure.execute(entity);
		}
		if (buttonID == 4) {

			JobsminercraftamethystexcavatorProcedure.execute(entity);
		}
		if (buttonID == 5) {

			JobsminercraftamethystexcavatorProcedure.execute(entity);
		}
		if (buttonID == 6) {

			JobsminercraftmagicialtoolProcedure.execute(entity);
		}
		if (buttonID == 7) {

			JobsminercraftvoidstoneProcedure.execute(entity);
		}
		if (buttonID == 8) {

			JobsminercraftobsidianpickaxeProcedure.execute(entity);
		}
		if (buttonID == 9) {

			JobsminercraftboomtntProcedure.execute(entity);
		}
		if (buttonID == 10) {

			JobsminercraftcompactobsidianProcedure.execute(entity);
		}
		if (buttonID == 11) {

			JobsminercraftwoddenspikeProcedure.execute(entity);
		}
		if (buttonID == 12) {

			JobsminercraftironspikeProcedure.execute(entity);
		}
		if (buttonID == 13) {

			JobsminercraftgoldenspikeProcedure.execute(entity);
		}
		if (buttonID == 14) {

			JobsminercraftdiamondspikeProcedure.execute(entity);
		}
		if (buttonID == 15) {

			JobsminercraftamethystspikeProcedure.execute(entity);
		}
		if (buttonID == 16) {

			JobsminercrafttitanespikeProcedure.execute(entity);
		}
		if (buttonID == 17) {

			JobsminercraftpaladiumspikeProcedure.execute(entity);
		}
		if (buttonID == 18) {

			JobsminercraftlavaobsidianProcedure.execute(entity);
		}
		if (buttonID == 19) {

			JobsminercraftfakewaterobsidianProcedure.execute(entity);
		}
		if (buttonID == 20) {

			JobsminercraftslimeobsidianProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(JobsminercraftguiButtonMessage.class, JobsminercraftguiButtonMessage::buffer, JobsminercraftguiButtonMessage::new, JobsminercraftguiButtonMessage::handler);
	}
}

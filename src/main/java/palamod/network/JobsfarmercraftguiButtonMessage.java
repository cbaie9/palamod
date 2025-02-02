
package palamod.network;

import palamod.world.inventory.JobsfarmercraftguiMenu;

import palamod.procedures.JobsminercraftwoddenspikeProcedure;
import palamod.procedures.JobsminercraftvoidstoneProcedure;
import palamod.procedures.JobsminercrafttitanespikeProcedure;
import palamod.procedures.JobsminercraftslimeobsidianProcedure;
import palamod.procedures.JobsminercraftpoisonobsidianProcedure;
import palamod.procedures.JobsminercraftpaladiumspikeProcedure;
import palamod.procedures.JobsminercraftobsidianpickaxeProcedure;
import palamod.procedures.JobsminercraftmegaboomobsidianProcedure;
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

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.HashMap;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record JobsfarmercraftguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<JobsfarmercraftguiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "jobsfarmercraftgui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, JobsfarmercraftguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, JobsfarmercraftguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new JobsfarmercraftguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<JobsfarmercraftguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final JobsfarmercraftguiButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> {
				Player entity = context.player();
				int buttonID = message.buttonID;
				int x = message.x;
				int y = message.y;
				int z = message.z;
				handleButtonAction(entity, buttonID, x, y, z);
			}).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = JobsfarmercraftguiMenu.guistate;
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
		if (buttonID == 21) {

			JobsminercraftpoisonobsidianProcedure.execute(entity);
		}
		if (buttonID == 22) {

			JobsminercraftmegaboomobsidianProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(JobsfarmercraftguiButtonMessage.TYPE, JobsfarmercraftguiButtonMessage.STREAM_CODEC, JobsfarmercraftguiButtonMessage::handleData);
	}
}

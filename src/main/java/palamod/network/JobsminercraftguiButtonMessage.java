package palamod.network;

import palamod.procedures.*;

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

@EventBusSubscriber
public record JobsminercraftguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<JobsminercraftguiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "jobsminercraftgui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, JobsminercraftguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, JobsminercraftguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new JobsminercraftguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<JobsminercraftguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final JobsminercraftguiButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
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

			JobsminercrafttitaneexcavatorProcedure.execute(entity);
		}
		if (buttonID == 5) {

			JobsminercraftgreenpaladiumexcavatorProcedure.execute(entity);
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

			JobsminercraftcaveblockProcedure.execute(entity);
		}
		if (buttonID == 23) {

			JobsminercraftcompacttntProcedure.execute(entity);
		}
		if (buttonID == 24) {

			JobsminercraftmagictntProcedure.execute(entity);
		}
		if (buttonID == 25) {

			JobsminercraftwithertntProcedure.execute(entity);
		}
		if (buttonID == 26) {

			JobsminercraftspongetntProcedure.execute(entity);
		}
		if (buttonID == 27) {

			JobsminercraftcompressedtntProcedure.execute(entity);
		}
		if (buttonID == 28) {

			JobsminercraftendiumtntProcedure.execute(entity);
		}
		if (buttonID == 29) {

			JobsminercraftmegaboomobsidianProcedure.execute(entity);
		}
		if (buttonID == 30) {

			JobsminercraftnotingamesoonProcedure.execute(entity);
		}
		if (buttonID == 31) {

			JobsminercraftnotingamesoonProcedure.execute(entity);
		}
		if (buttonID == 32) {

			JobsminercraftnotingamesoonProcedure.execute(entity);
		}
		if (buttonID == 33) {

			JobsminercraftnotingamesoonProcedure.execute(entity);
		}
		if (buttonID == 34) {

			JobsminercraftcobblebreakerProcedure.execute(entity);
		}
		if (buttonID == 35) {

			JobsminercraftcobblebreakeramethysteupgradeProcedure.execute(entity);
		}
		if (buttonID == 36) {

			JobsminercraftcobblebreakertitaneupgradeProcedure.execute(entity);
		}
		if (buttonID == 37) {

			JobsminercraftcobblebreakerpaladiumupgradeProcedure.execute(entity);
		}
		if (buttonID == 38) {

			JobsminercraftvoidstoneminageProcedure.execute(entity);
		}
		if (buttonID == 39) {

			JobsminercraftmoulastoneProcedure.execute(entity);
		}
		if (buttonID == 40) {

			JobsminercraftsealedxpbottleProcedure.execute(entity);
		}
		if (buttonID == 41) {

			JobsminercraftpalaforgeProcedure.execute(entity);
		}
		if (buttonID == 42) {

			JobsminercraftnotingamesoonProcedure.execute(entity);
		}
		if (buttonID == 43) {

			JobsminercraftwitheredobsidianProcedure.execute(entity);
		}
		if (buttonID == 44) {

			JobsminercraftgreenpaladiumexcavatorProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(JobsminercraftguiButtonMessage.TYPE, JobsminercraftguiButtonMessage.STREAM_CODEC, JobsminercraftguiButtonMessage::handleData);
	}
}
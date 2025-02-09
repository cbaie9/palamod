
package palamod.network;

import palamod.world.inventory.JobsfarmercraftguiMenu;

import palamod.procedures.JobsminerfarmertitaneseedplanterProcedure;
import palamod.procedures.JobsminerfarmerpaladiumseedplanterProcedure;
import palamod.procedures.JobsminerfarmergreenpaladiumseedplanterProcedure;
import palamod.procedures.JobsminerfarmergreenpaladiumhoeProcedure;
import palamod.procedures.JobsminerfarmerendiumseedplanterProcedure;
import palamod.procedures.JobsminerfarmerendiumhoeProcedure;
import palamod.procedures.JobsminerfarmerelevatorProcedure;
import palamod.procedures.JobsminerfarmeramethystseedplanterProcedure;
import palamod.procedures.JobsminerfarmeramethysthoeProcedure;
import palamod.procedures.JobsminercrafttitanespikeProcedure;
import palamod.procedures.JobsminercraftamethystspikeProcedure;
import palamod.procedures.JobsfarmerpaladiumhoeProcedure;
import palamod.procedures.JobsfarmercrafttitanehoeProcedure;
import palamod.procedures.JobsfarmercrafttitanebackpackProcedure;
import palamod.procedures.JobsfarmercraftpaladiumbackpackProcedure;
import palamod.procedures.JobsfarmercraftfertilitytotemProcedure;
import palamod.procedures.JobsfarmercraftfarmerthroneProcedure;
import palamod.procedures.JobsfarmercraftendiumchestplateProcedure;
import palamod.procedures.JobsfarmercraftendiumbackpackProcedure;
import palamod.procedures.JobsfarmercraftendiumaxeProcedure;
import palamod.procedures.JobsfarmercraftcrusherProcedure;
import palamod.procedures.JobsfarmercraftamethystbackpackProcedure;
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

			JobsminerfarmeramethysthoeProcedure.execute(entity);
		}
		if (buttonID == 2) {

			JobsfarmercrafttitanehoeProcedure.execute(entity);
		}
		if (buttonID == 3) {

			JobsfarmerpaladiumhoeProcedure.execute(entity);
		}
		if (buttonID == 4) {

			JobsminerfarmerendiumhoeProcedure.execute(entity);
		}
		if (buttonID == 5) {

			JobsminerfarmergreenpaladiumhoeProcedure.execute(entity);
		}
		if (buttonID == 6) {

			JobsminerfarmeramethystseedplanterProcedure.execute(entity);
		}
		if (buttonID == 7) {

			JobsminerfarmertitaneseedplanterProcedure.execute(entity);
		}
		if (buttonID == 8) {

			JobsminerfarmerpaladiumseedplanterProcedure.execute(entity);
		}
		if (buttonID == 9) {

			JobsminerfarmergreenpaladiumseedplanterProcedure.execute(entity);
		}
		if (buttonID == 10) {

			JobsminerfarmerendiumseedplanterProcedure.execute(entity);
		}
		if (buttonID == 11) {

			JobsfarmercraftamethystbackpackProcedure.execute(entity);
		}
		if (buttonID == 12) {

			JobsfarmercrafttitanebackpackProcedure.execute(entity);
		}
		if (buttonID == 13) {

			JobsfarmercraftpaladiumbackpackProcedure.execute(entity);
		}
		if (buttonID == 14) {

			JobsfarmercraftendiumbackpackProcedure.execute(entity);
		}
		if (buttonID == 15) {

			JobsminercraftamethystspikeProcedure.execute(entity);
		}
		if (buttonID == 16) {

			JobsminercrafttitanespikeProcedure.execute(entity);
		}
		if (buttonID == 17) {

			JobsfarmercraftcrusherProcedure.execute(entity);
		}
		if (buttonID == 18) {

			JobsfarmercraftfertilitytotemProcedure.execute(entity);
		}
		if (buttonID == 19) {

			JobsfarmercraftfarmerthroneProcedure.execute(entity);
		}
		if (buttonID == 20) {

			JobsfarmercraftendiumchestplateProcedure.execute(entity);
		}
		if (buttonID == 21) {

			JobsfarmercraftendiumaxeProcedure.execute(entity);
		}
		if (buttonID == 22) {

			JobsminerfarmerelevatorProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(JobsfarmercraftguiButtonMessage.TYPE, JobsfarmercraftguiButtonMessage.STREAM_CODEC, JobsfarmercraftguiButtonMessage::handleData);
	}
}

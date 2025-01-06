
package palamod.network;

import palamod.world.inventory.AdminshopmobsMenu;

import palamod.procedures.ConnectadminshopmobswitherskullProcedure;
import palamod.procedures.ConnectadminshopmobsstringProcedure;
import palamod.procedures.ConnectadminshopmobsspidereyesProcedure;
import palamod.procedures.ConnectadminshopmobsslimeballProcedure;
import palamod.procedures.ConnectadminshopmobsrottenfleshProcedure;
import palamod.procedures.ConnectadminshopmobsghasttearsProcedure;
import palamod.procedures.ConnectadminshopmobsfrspidereyesProcedure;
import palamod.procedures.ConnectadminshopmobsenderpearlProcedure;
import palamod.procedures.ConnectadminshopmobseggProcedure;
import palamod.procedures.ConnectadminshopmobsboneProcedure;
import palamod.procedures.Connectadminshopmobs2Procedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.Adminshop_openProcedure;

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
public record AdminshopmobsButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AdminshopmobsButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "adminshopmobs_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AdminshopmobsButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AdminshopmobsButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AdminshopmobsButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AdminshopmobsButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AdminshopmobsButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = AdminshopmobsMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectadminshopmobsboneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectadminshopmobsenderpearlProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectadminshopmobsfrspidereyesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadminshopmobsspidereyesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadminshopmobsrottenfleshProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadminshopmobsstringProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectadminshopmobsghasttearsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectadminshopmobseggProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectadminshopmobsslimeballProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ConnectadminshopmobswitherskullProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 11) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			Connectadminshopmobs2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshopmobsButtonMessage.TYPE, AdminshopmobsButtonMessage.STREAM_CODEC, AdminshopmobsButtonMessage::handleData);
	}
}

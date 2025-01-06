
package palamod.network;

import palamod.world.inventory.AdminshoporeMenu;

import palamod.procedures.ConnectadminshoputilitiesredstoneProcedure;
import palamod.procedures.ConnectadminshoputilitiesemeraldProcedure;
import palamod.procedures.ConnectadhoretitaneProcedure;
import palamod.procedures.ConnectadhorepalaProcedure;
import palamod.procedures.ConnectadhoreironProcedure;
import palamod.procedures.ConnectadhoregoldProcedure;
import palamod.procedures.ConnectadhorefindiumProcedure;
import palamod.procedures.ConnectadhorediamondProcedure;
import palamod.procedures.ConnectadhorecoalProcedure;
import palamod.procedures.ConnectadhoreameProcedure;
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
public record AdminshoporeButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AdminshoporeButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "adminshopore_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AdminshoporeButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AdminshoporeButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AdminshoporeButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AdminshoporeButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AdminshoporeButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = AdminshoporeMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectadhorepalaProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectadhoretitaneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectadhoreameProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadhorefindiumProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadhorediamondProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadhoreironProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectadhoregoldProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectadhorecoalProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectadminshoputilitiesredstoneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ConnectadminshoputilitiesemeraldProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 11) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshoporeButtonMessage.TYPE, AdminshoporeButtonMessage.STREAM_CODEC, AdminshoporeButtonMessage::handleData);
	}
}

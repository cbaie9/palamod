
package palamod.network;

import palamod.world.inventory.AdminshopblockMenu;

import palamod.procedures.ConnectadhblkstoneProcedure;
import palamod.procedures.ConnectadhblksoulsandProcedure;
import palamod.procedures.ConnectadhblksandProcedure;
import palamod.procedures.ConnectadhblkoakwoodProcedure;
import palamod.procedures.ConnectadhblknetherrackProcedure;
import palamod.procedures.ConnectadhblkgravelProcedure;
import palamod.procedures.ConnectadhblkgrassProcedure;
import palamod.procedures.ConnectadhblkglowstoneProcedure;
import palamod.procedures.ConnectadhblkdirtProcedure;
import palamod.procedures.ConnectadhblkblackstoneProcedure;
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
public record AdminshopblockButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AdminshopblockButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "adminshopblock_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AdminshopblockButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AdminshopblockButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AdminshopblockButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AdminshopblockButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AdminshopblockButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = AdminshopblockMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectadhblkdirtProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectadhblkgrassProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectadhblkstoneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadhblknetherrackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadhblksoulsandProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadhblksandProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectadhblkgravelProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectadhblkglowstoneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectadhblkoakwoodProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ConnectadhblkblackstoneProcedure.execute(world, x, y, z, entity);
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
		PalamodMod.addNetworkMessage(AdminshopblockButtonMessage.TYPE, AdminshopblockButtonMessage.STREAM_CODEC, AdminshopblockButtonMessage::handleData);
	}
}

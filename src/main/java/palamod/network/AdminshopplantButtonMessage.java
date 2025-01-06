
package palamod.network;

import palamod.world.inventory.AdminshopplantMenu;

import palamod.procedures.ConnectadminshopplantwheatProcedure;
import palamod.procedures.ConnectadminshopplantwarpedfungusProcedure;
import palamod.procedures.ConnectadminshopplantsugarcaneProcedure;
import palamod.procedures.ConnectadminshopplantredmushroomProcedure;
import palamod.procedures.ConnectadminshopplantpotatoProcedure;
import palamod.procedures.ConnectadminshopplantmelonProcedure;
import palamod.procedures.ConnectadminshopplantcrimsonfungusProcedure;
import palamod.procedures.ConnectadminshopplantcarrotProcedure;
import palamod.procedures.ConnectadminshopplantcactusProcedure;
import palamod.procedures.ConnectadminshopplantbrownmushroomProcedure;
import palamod.procedures.ConnectadminshopcocoabeanProcedure;
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
public record AdminshopplantButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<AdminshopplantButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "adminshopplant_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AdminshopplantButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AdminshopplantButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AdminshopplantButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<AdminshopplantButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AdminshopplantButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = AdminshopplantMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectadminshopplantcactusProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectadminshopplantredmushroomProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectadminshopplantbrownmushroomProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectadminshopplantwarpedfungusProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectadminshopplantcrimsonfungusProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectadminshopplantpotatoProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ConnectadminshopplantwheatProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectadminshopplantcarrotProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectadminshopplantmelonProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			ConnectadminshopplantsugarcaneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			ConnectadminshopcocoabeanProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 12) {

			Adminshop_openProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshopplantButtonMessage.TYPE, AdminshopplantButtonMessage.STREAM_CODEC, AdminshopplantButtonMessage::handleData);
	}
}

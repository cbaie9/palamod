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
import net.minecraft.core.SectionPos;

@EventBusSubscriber
public record AdminshopmenuButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<AdminshopmenuButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "adminshopmenu_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, AdminshopmenuButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, AdminshopmenuButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new AdminshopmenuButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<AdminshopmenuButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final AdminshopmenuButtonMessage message, final IPayloadContext context) {
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
		if (!world.getChunkSource().hasChunk(SectionPos.blockToSectionCoord(x), SectionPos.blockToSectionCoord(z)))
			return;
		if (buttonID == 0) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 1) {

			Connectadminshoprow1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			Connectadminshoprow2col1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			Connectadminshoprow3col1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			Connectadminshoprow1col2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			Connectadminshoprow2col2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			Connectadminshoprow3col2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			Connectadminshoprow1col3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			Connectadminshoprow2col3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 9) {

			Connectadminshoprow3col3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			Connectadminshoprow1col4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 11) {

			Connectadminshoprow2col4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			Connectadminshoprow3col4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 13) {

			Connectadminshoprow1col5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 14) {

			Connectadminshoprow2col5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 15) {

			Connectadminshoprow3col5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 16) {

			Connectadminshoprow1col6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 17) {

			Connectadminshoprow2col6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 18) {

			Connectadminshoprow3col6Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 19) {

			Connectadminshoprow1col7Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 20) {

			Connectadminshoprow2col7Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 21) {

			Connectadminshoprow3col7Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(AdminshopmenuButtonMessage.TYPE, AdminshopmenuButtonMessage.STREAM_CODEC, AdminshopmenuButtonMessage::handleData);
	}
}
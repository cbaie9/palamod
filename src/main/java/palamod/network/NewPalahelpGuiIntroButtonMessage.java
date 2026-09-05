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
public record NewPalahelpGuiIntroButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<NewPalahelpGuiIntroButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "new_palahelp_gui_intro_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, NewPalahelpGuiIntroButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, NewPalahelpGuiIntroButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new NewPalahelpGuiIntroButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<NewPalahelpGuiIntroButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final NewPalahelpGuiIntroButtonMessage message, final IPayloadContext context) {
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

			ConnectnewOreLiquidsPalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectPalahelpTreeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ConnectarmorpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ConnectnewOreLiquidsPalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectNewPalahelpCommandProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectPalahelpJobsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			Connectgrinderpag1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			ConnectpalamachinepalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			ConnectpalahelpcrusherProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 10) {

			BackpalahelpProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(NewPalahelpGuiIntroButtonMessage.TYPE, NewPalahelpGuiIntroButtonMessage.STREAM_CODEC, NewPalahelpGuiIntroButtonMessage::handleData);
	}
}
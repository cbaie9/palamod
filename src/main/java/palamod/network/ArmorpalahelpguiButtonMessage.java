package palamod.network;

import palamod.procedures.ConnectitemmenuProcedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.BackpalahelpProcedure;
import palamod.procedures.ArmorpalahelpguiThisGUIIsOpenedProcedure;

import palamod.PalamodMod;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.SectionPos;

@EventBusSubscriber
public record ArmorpalahelpguiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<ArmorpalahelpguiButtonMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PalamodMod.MODID, "armorpalahelpgui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ArmorpalahelpguiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ArmorpalahelpguiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ArmorpalahelpguiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<ArmorpalahelpguiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ArmorpalahelpguiButtonMessage message, final IPayloadContext context) {
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

			ArmorpalahelpguiThisGUIIsOpenedProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ConnectitemmenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 3) {

			BackpalahelpProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(ArmorpalahelpguiButtonMessage.TYPE, ArmorpalahelpguiButtonMessage.STREAM_CODEC, ArmorpalahelpguiButtonMessage::handleData);
	}
}
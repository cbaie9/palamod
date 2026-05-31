package palamod.network;

import palamod.procedures.OpenexamplegrinderProcedure;
import palamod.procedures.MachineconnectpalahelpProcedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.BackpalahelpProcedure;

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
public record Grinderpalahelp2guiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {
	public static final Type<Grinderpalahelp2guiButtonMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PalamodMod.MODID, "grinderpalahelp_2gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Grinderpalahelp2guiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Grinderpalahelp2guiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new Grinderpalahelp2guiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));

	@Override
	public Type<Grinderpalahelp2guiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final Grinderpalahelp2guiButtonMessage message, final IPayloadContext context) {
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

			MachineconnectpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			BackpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenexamplegrinderProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(Grinderpalahelp2guiButtonMessage.TYPE, Grinderpalahelp2guiButtonMessage.STREAM_CODEC, Grinderpalahelp2guiButtonMessage::handleData);
	}
}
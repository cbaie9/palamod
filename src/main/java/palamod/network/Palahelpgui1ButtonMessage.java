
package palamod.network;

import palamod.world.inventory.Palahelpgui1Menu;

import palamod.procedures.NextpalahelpProcedure;
import palamod.procedures.MachineconnectpalahelpProcedure;
import palamod.procedures.ConnectnotyetguiProcedure;
import palamod.procedures.ConnectitemmenuProcedure;
import palamod.procedures.BlockconnecthelpProcedure;

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
public record Palahelpgui1ButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<Palahelpgui1ButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "palahelpgui_1_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, Palahelpgui1ButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, Palahelpgui1ButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new Palahelpgui1ButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<Palahelpgui1ButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final Palahelpgui1ButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = Palahelpgui1Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			BlockconnecthelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectitemmenuProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			MachineconnectpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			NextpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ConnectnotyetguiProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			ConnectnotyetguiProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(Palahelpgui1ButtonMessage.TYPE, Palahelpgui1ButtonMessage.STREAM_CODEC, Palahelpgui1ButtonMessage::handleData);
	}
}

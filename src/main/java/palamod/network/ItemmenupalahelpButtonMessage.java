
package palamod.network;

import palamod.world.inventory.ItemmenupalahelpMenu;

import palamod.procedures.OpennewstickguiProcedure;
import palamod.procedures.ConnectlegendarystoneProcedure;
import palamod.procedures.ConnectarmorpalahelpProcedure;
import palamod.procedures.CloseguiProcedure;
import palamod.procedures.BlockbackProcedure;
import palamod.procedures.BackpalahelpProcedure;

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
public record ItemmenupalahelpButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<ItemmenupalahelpButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PalamodMod.MODID, "itemmenupalahelp_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, ItemmenupalahelpButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, ItemmenupalahelpButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new ItemmenupalahelpButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<ItemmenupalahelpButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final ItemmenupalahelpButtonMessage message, final IPayloadContext context) {
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
		HashMap guistate = ItemmenupalahelpMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ConnectlegendarystoneProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ConnectarmorpalahelpProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpennewstickguiProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			CloseguiProcedure.execute(entity);
		}
		if (buttonID == 5) {

			BlockbackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			BackpalahelpProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(ItemmenupalahelpButtonMessage.TYPE, ItemmenupalahelpButtonMessage.STREAM_CODEC, ItemmenupalahelpButtonMessage::handleData);
	}
}

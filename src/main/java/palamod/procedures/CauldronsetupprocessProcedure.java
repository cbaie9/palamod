package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CauldronsetupprocessProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		BlockState core = Blocks.AIR.defaultBlockState();
		boolean pass = false;
		boolean layer_one = false;
		boolean turn = false;
		boolean layer_two = false;
		double x_while = 0;
		double z_while = 0;
		double x_core = 0;
		double z_core = 0;
		double y_core = 0;
		double failsafe_crash = 0;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
			PalamodMod.LOGGER.debug(("------------------------" + "\n" + "Chaudron" + "\n"));
		}
		if (entity instanceof ServerPlayer || entity instanceof Player) {
			if (PalamodModItems.ANGELIC_WATER_BUCKET.get() == itemstack.getItem()) {
				CauldronmanagerprocessProcedure.execute(world, x, y, z, "setup");
			}
		}
	}
}
package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

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
import net.minecraft.core.BlockPos;

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
		PalamodMod.LOGGER.debug(("------------------------" + "\n" + "Chaudron" + "\n"));
		if ((entity instanceof ServerPlayer || entity instanceof Player) && PalamodModItems.ANGELIC_WATER_BUCKET.get() == itemstack.getItem()) {
			int horizontalRadiusHemiBot = (int) 3 - 1;
			int verticalRadiusHemiBot = (int) 2;
			int yIterationsHemiBot = verticalRadiusHemiBot;
			for (int i = -yIterationsHemiBot; i <= 0; i++) {
				if (i == -verticalRadiusHemiBot) {
					continue;
				}
				for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
					for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
								+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
						if (distanceSq <= 1.0) {
							if (PalamodModBlocks.CAULDRON_CORE.get() == (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()) {
								x_core = x + xi;
								y_core = y + i;
								z_core = z + zi;
								pass = true;
								PalamodMod.LOGGER.info(("Core :  x : " + x + xi + " y : " + y + i + " z : " + z + zi));
							}
						}
					}
				}
			}
			if (pass) {/*layer 1*/
				x_while = x_core - 3;
				z_while = z_core - 3;
				while (!(x_while == x_core + 3) && !(z_while == z_core + 3)) {
					PalamodMod.LOGGER.debug(("log l1 : x: " + x_while + "  y: " + y_core + " z: " + z_while));
					if (x_core == x_while && z_while == z_while) {
						continue;
					}
					if (!(PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_while, y_core, z_while))).getBlock())) {
						break;
					}
					if (turn) {
						z_while = z_while + 1;
					} else {
						x_while = x_while + 1;
					}
					turn = !turn;
				}
				layer_one = PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_core + 3, y_core, z_core + 3))).getBlock() && z_while == z_core + 3 && z_while == z_core + 3;
				PalamodMod.LOGGER.info("layer1 : " + layer_one);/*layer 2*/
				turn = false;
				x_while = x_core - 2;
				z_while = z_core - 2;
				while (!(x_while == x_core + 2) && !(z_while == z_core + 2)) {
					if (z_core - 1 <= z_while && z_core + 1 >= z_while || x_core - 1 <= x_while && x_core + 1 >= x_while) {
						continue;
					}
					if (!(PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_while, y_core + 1, z_while))).getBlock())) {
						break;
					}
					if (turn) {
						z_while = z_while + 1;
					} else {
						x_while = x_while + 1;
					}
					turn = !turn;
				}
				layer_two = PalamodModBlocks.CAULDRON.get() == (world.getBlockState(BlockPos.containing(x_core + 2, y_core + 1, z_core + 2))).getBlock() && x_while == x_core + 2 && z_while == z_core + 2;
				PalamodMod.LOGGER.info("layer2 : " + layer_two);
				if (layer_one && layer_two) {
					PalamodMod.LOGGER.info("the structure is completed");
				}
			}
		}
	}
}
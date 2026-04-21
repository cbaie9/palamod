package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

public class CauldroncraftresultProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, ItemStack itemstack) {
		ItemStack output = ItemStack.EMPTY;
		boolean pass = false;
		double random = 0;
		double y_core = 0;
		double x_core = 0;
		double nb_items = 0;
		double z_core = 0;
		if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
			PalamodMod.LOGGER.info("DROP RESULT");
		}
		nb_items = itemstack.getCount();
		PalamodMod.LOGGER.info(("" + nb_items));
		if (itemstack.is(ItemTags.create(ResourceLocation.parse("palamod:modded_flowers")))) {
			output = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			output.setCount((int) nb_items);
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, output);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("palamod:vanilla_flowers")))) {
			for (int index0 = 0; index0 < (int) nb_items; index0++) {
				if (Math.random() < 0.25) {
					random = Mth.nextInt(RandomSource.create(), 1, 3);
					if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
						PalamodMod.LOGGER.info("drop");
					}
					if (1 == random) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.MINERAL_FLOWER.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						continue;
					} else if (2 == random) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, (y + 0.25), z, new ItemStack(PalamodModBlocks.HARPAGOPHYTUM.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						continue;
					} else {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_FLOWER.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						continue;
					}
				}
			}
		} else if (Blocks.GLOWSTONE.asItem() == itemstack.getItem()) {
			for (int index1 = 0; index1 < (int) nb_items; index1++) {
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GOLD_INGOT));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
		if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
			PalamodMod.LOGGER.info("END DROP RESULT");
		}
	}
}
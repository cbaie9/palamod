package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

public class CauldroncraftresultProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack, ItemStack itemstack_transfert) {
		if (entity == null)
			return;
		ItemStack output = ItemStack.EMPTY;
		double random = 0;
		double nb_items = 0;
		double cmp_respawn = 0;
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
			for (int index353 = 0; index353 < (int) nb_items; index353++) {
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
			for (int index354 = 0; index354 < (int) nb_items; index354++) {
				if (Math.random() < 0.25) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(Items.GOLD_INGOT));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		} else if (PalamodModBlocks.ERABLE_LOG.get().asItem() == itemstack.getItem()) {
			cmp_respawn = 0;
			for (int index355 = 0; index355 < (int) nb_items; index355++) {
				if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.LIGHTNING_POTION.get()))) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModItems.LIGHTNING_POTION.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.SHINY_ERABLE_WOOD.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					cmp_respawn = cmp_respawn + 1;
				}
			}
			if (nb_items - cmp_respawn > 0) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModBlocks.ERABLE_LOG.get()).copy();
					_setstack.setCount((int) (nb_items - cmp_respawn));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		} else if (PalamodModBlocks.OSTRYA_WOOD_LOG.get().asItem() == itemstack.getItem()) {
			cmp_respawn = 0;
			for (int index356 = 0; index356 < (int) nb_items; index356++) {
				if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.LIGHTNING_POTION.get()))) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModItems.LIGHTNING_POTION.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.SHINY_OSTRYA_WOOD.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					cmp_respawn = cmp_respawn + 1;
				}
			}
			if (nb_items - cmp_respawn > 0) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModBlocks.OSTRYA_WOOD_LOG.get()).copy();
					_setstack.setCount((int) (nb_items - cmp_respawn));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		} else if (PalamodModBlocks.JUDEECERCIS_LOG.get().asItem() == itemstack.getItem()) {
			cmp_respawn = 0;
			for (int index357 = 0; index357 < (int) nb_items; index357++) {
				if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.LIGHTNING_POTION.get()))) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModItems.LIGHTNING_POTION.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.SHINY_JUDEECERCIS_WOOD.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					cmp_respawn = cmp_respawn + 1;
				}
			}
			if (nb_items - cmp_respawn > 0) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModBlocks.JUDEECERCIS_LOG.get()).copy();
					_setstack.setCount((int) (nb_items - cmp_respawn));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		} else if (PalamodModBlocks.JACARANDA_LOG.get().asItem() == itemstack.getItem()) {
			cmp_respawn = 0;
			for (int index358 = 0; index358 < (int) nb_items; index358++) {
				if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.LIGHTNING_POTION.get()))) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModItems.LIGHTNING_POTION.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.SHINY_JACARANDA_WOOD.get()));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					cmp_respawn = cmp_respawn + 1;
				}
			}
			if (nb_items - cmp_respawn > 0) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModBlocks.JACARANDA_LOG.get()).copy();
					_setstack.setCount((int) (nb_items - cmp_respawn));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		} else if (PalamodModItems.GLUEBALL_PATTERN.get() == itemstack.getItem()) {
			if (world instanceof ServerLevel _level) {
				ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemstack_transfert);
				entityToSpawn.setPickUpDelay(10);
				_level.addFreshEntity(entityToSpawn);
			}
		} else if (PalamodModBlocks.ENDIUM_FLOWER.get().asItem() == itemstack.getItem() || PalamodModBlocks.ENDIUM_FLOWER_ON.get().asItem() == itemstack.getItem()) {
			for (int index359 = 0; index359 < (int) nb_items; index359++) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.ENDIUM_POLLEN.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				if (Math.random() < 0.25) {
					random = Mth.nextInt(RandomSource.create(), 1, 4);
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
					} else if (3 == random) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModBlocks.PALADIUM_FLOWER.get()));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						continue;
					}
				}
				if (Math.random() < 0.00390625) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()));
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

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}
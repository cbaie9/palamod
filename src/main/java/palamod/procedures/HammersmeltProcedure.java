package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class HammersmeltProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		String tag = "";
		boolean removeBlock = false;
		double i = 0;
		double j = 0;
		double nloop = 0;
		double block_x = 0;
		double block_y = 0;
		double block_z = 0;
		ItemStack smelting_result = ItemStack.EMPTY;
		BlockState block = Blocks.AIR.defaultBlockState();
		tag = "mineable/pickaxe";
		i = -1;
		for (int index1688 = 0; index1688 < 3; index1688++) {
			j = -1;
			for (int index1689 = 0; index1689 < 3; index1689++) {
				if (i != 0 || j != 0) {
					if (entity.getXRot() > 40 || entity.getXRot() < -40) {
						block_x = x + i;
						block_y = y;
						block_z = z + j;
						block = (world.getBlockState(BlockPos.containing(block_x, block_y, block_z)));
						if (block.is(BlockTags.create(ResourceLocation.parse((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
							if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops(block) == true) {
								smelting_result = (world instanceof Level _lvlSmeltResult
										? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack(block.getBlock()))), _lvlSmeltResult)
												.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
										: ItemStack.EMPTY).copy();
								if (!(smelting_result.getItem() == Blocks.AIR.asItem())) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (block_x + 0.5), (block_y + 0.5), (block_z + 0.5), smelting_result);
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else {
									removeBlock = false;
								}
								if (removeBlock == true) {
									world.destroyBlock(BlockPos.containing(block_x, block_y, block_z), false);
								} else {
									{
										BlockPos _pos = BlockPos.containing(block_x, block_y, block_z);
										Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(block_x, block_y, block_z), null);
										world.destroyBlock(_pos, false);
									}
								}
							}
						}
					} else if ((entity.getDirection()).getAxis() == Direction.Axis.Z) {
						block_x = x + i;
						block_y = y + j;
						block_z = z;
						block = (world.getBlockState(BlockPos.containing(block_x, block_y, block_z)));
						if (block.is(BlockTags.create(ResourceLocation.parse((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
							if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops(block) == true) {
								smelting_result = (world instanceof Level _lvlSmeltResult
										? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack(block.getBlock()))), _lvlSmeltResult)
												.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
										: ItemStack.EMPTY).copy();
								if (!(smelting_result.getItem() == Blocks.AIR.asItem())) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (block_x + 0.5), (block_y + 0.5), (block_z + 0.5), smelting_result);
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else {
									removeBlock = false;
								}
								if (removeBlock == true) {
									world.destroyBlock(BlockPos.containing(block_x, block_y, block_z), false);
								} else {
									{
										BlockPos _pos = BlockPos.containing(block_x, block_y, block_z);
										Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(block_x, block_y, block_z), null);
										world.destroyBlock(_pos, false);
									}
								}
							}
						}
					} else if ((entity.getDirection()).getAxis() == Direction.Axis.X) {
						block_x = x;
						block_y = y + j;
						block_z = z + i;
						block = (world.getBlockState(BlockPos.containing(block_x, block_y, block_z)));
						if (block.is(BlockTags.create(ResourceLocation.parse((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
							if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops(block) == true) {
								smelting_result = (world instanceof Level _lvlSmeltResult
										? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack(block.getBlock()))), _lvlSmeltResult)
												.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
										: ItemStack.EMPTY).copy();
								if (!(smelting_result.getItem() == Blocks.AIR.asItem())) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (block_x + 0.5), (block_y + 0.5), (block_z + 0.5), smelting_result);
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								} else {
									removeBlock = false;
								}
								if (removeBlock == true) {
									world.destroyBlock(BlockPos.containing(block_x, block_y, block_z), false);
								} else {
									{
										BlockPos _pos = BlockPos.containing(block_x, block_y, block_z);
										Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(block_x, block_y, block_z), null);
										world.destroyBlock(_pos, false);
									}
								}
							}
						}
					}
				} else {
					block_x = x;
					block_y = y;
					block_z = z + i;
					block = (world.getBlockState(BlockPos.containing(block_x, block_y, block_z)));
					if (block.is(BlockTags.create(ResourceLocation.parse((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
						if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops(block) == true) {
							smelting_result = (world instanceof Level _lvlSmeltResult
									? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack(block.getBlock()))), _lvlSmeltResult)
											.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
									: ItemStack.EMPTY).copy();
							if (!(smelting_result.getItem() == Blocks.AIR.asItem())) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (block_x + 0.5), (block_y + 0.5), (block_z + 0.5), smelting_result);
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else {
								removeBlock = false;
							}
							if (removeBlock == true) {
								world.destroyBlock(BlockPos.containing(block_x, block_y, block_z), false);
							} else {
								{
									BlockPos _pos = BlockPos.containing(block_x, block_y, block_z);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(block_x, block_y, block_z), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
					}
				}
				j = j + 1;
			}
			i = i + 1;
		}
	}
}
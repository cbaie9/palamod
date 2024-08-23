package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.SimpleContainer;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class HammersmeltProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean removeBlock = false;
		double i = 0;
		double j = 0;
		String tag = "";
		tag = "mineable/pickaxe";
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
			if (!((world instanceof Level _lvlSmeltResult
					? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()))), _lvlSmeltResult)
							.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
					: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5),
							(world instanceof Level _lvlSmeltResult
									? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()))), _lvlSmeltResult)
											.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
									: ItemStack.EMPTY));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				removeBlock = true;
			} else {
				removeBlock = false;
			}
			if (removeBlock == false) {
				world.destroyBlock(BlockPos.containing(x, y, z), false);
			}
		}
		i = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			j = -1;
			for (int index1 = 0; index1 < 3; index1++) {
				if (i != 0 || j != 0) {
					if (entity.getXRot() > 40 || entity.getXRot() < -40) {
						if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
							if (!((world instanceof Level _lvlSmeltResult
									? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x + i, y, z + j))).getBlock()))), _lvlSmeltResult)
											.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
									: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5),
											(world instanceof Level _lvlSmeltResult
													? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x + i, y, z + j))).getBlock()))), _lvlSmeltResult)
															.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
													: ItemStack.EMPTY));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								removeBlock = true;
							} else {
								removeBlock = false;
							}
							if (removeBlock == true) {
								world.destroyBlock(BlockPos.containing(x + i, y, z + j), false);
							} else {
								{
									BlockPos _pos = BlockPos.containing(x + i, y, z + j);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
					} else if ((entity.getDirection()).getAxis() == Direction.Axis.Z) {
						if ((world.getBlockState(BlockPos.containing(x + i, y + j, z))).is(BlockTags.create(new ResourceLocation((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
							if (!((world instanceof Level _lvlSmeltResult
									? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x + i, y + j, z))).getBlock()))), _lvlSmeltResult)
											.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
									: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5),
											(world instanceof Level _lvlSmeltResult
													? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x + i, y + j, z))).getBlock()))), _lvlSmeltResult)
															.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
													: ItemStack.EMPTY));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								removeBlock = true;
							} else {
								removeBlock = false;
							}
							if (removeBlock == true) {
								world.destroyBlock(BlockPos.containing(x + i, y + j, z), false);
							} else {
								{
									BlockPos _pos = BlockPos.containing(x + i, y + j, z);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
									world.destroyBlock(_pos, false);
								}
							}
						}
					} else if ((entity.getDirection()).getAxis() == Direction.Axis.X) {
						if ((world.getBlockState(BlockPos.containing(x, y + j, z + i))).is(BlockTags.create(new ResourceLocation((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
							if (!((world instanceof Level _lvlSmeltResult
									? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x, y + j, z + i))).getBlock()))), _lvlSmeltResult)
											.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
									: ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5),
											(world instanceof Level _lvlSmeltResult
													? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer((new ItemStack((world.getBlockState(BlockPos.containing(x, y + j, z + i))).getBlock()))), _lvlSmeltResult)
															.map(recipe -> recipe.getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
													: ItemStack.EMPTY));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
								removeBlock = true;
							} else {
								removeBlock = false;
							}
							if (removeBlock == true) {
								world.destroyBlock(BlockPos.containing(x, y + j, z + i), false);
							} else {
								{
									BlockPos _pos = BlockPos.containing(x, y + j, z + i);
									Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
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

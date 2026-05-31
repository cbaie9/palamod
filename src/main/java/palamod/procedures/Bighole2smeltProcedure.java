package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class Bighole2smeltProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getXRot() > 40 || entity.getXRot() < -40) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level8 && _level8.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()))), _level8).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level21
						&& _level21.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock()))), _level21).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level34
						&& _level34.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock()))), _level34).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level47
						&& _level47.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock()))), _level47).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level60
						&& _level60.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock()))), _level60).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level73
						&& _level73.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock()))), _level73).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level86
						&& _level86.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()))), _level86).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level99
						&& _level99.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()))), _level99).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level112
						&& _level112.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock()))), _level112).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level125
						&& _level125.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock()))), _level125).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level138
						&& _level138.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock()))), _level138).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level151
						&& _level151.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock()))), _level151).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level164
						&& _level164.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).getBlock()))), _level164).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 3, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 3, y, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level177
						&& _level177.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).getBlock()))), _level177).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 3, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 3, y, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level190
						&& _level190.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).getBlock()))), _level190).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 3, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 3, y, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level203
						&& _level203.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).getBlock()))), _level203).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 3, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 3, y, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level216
						&& _level216.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock()))), _level216).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level229
						&& _level229.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock()))), _level229).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level242
						&& _level242.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock()))), _level242).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level255
						&& _level255.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock()))), _level255).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level268
						&& _level268.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock()))), _level268).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level281
						&& _level281.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock()))), _level281).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level294
						&& _level294.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock()))), _level294).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level307
						&& _level307.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock()))), _level307).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level320
						&& _level320.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock()))), _level320).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level333
						&& _level333.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock()))), _level333).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 3, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 3, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
		} else if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level350
						&& _level350.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()))), _level350).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level363
						&& _level363.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock()))), _level363).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level376
						&& _level376.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock()))), _level376).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level389
						&& _level389.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock()))), _level389).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y - 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level402
						&& _level402.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock()))), _level402).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level415
						&& _level415.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock()))), _level415).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level428
						&& _level428.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()))), _level428).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level441
						&& _level441.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()))), _level441).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y - 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level454
						&& _level454.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock()))), _level454).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 2, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level467
						&& _level467.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock()))), _level467).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 3, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 3, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level480
						&& _level480.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock()))), _level480).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y + 3, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y + 3, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level493
						&& _level493.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock()))), _level493).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y + 3, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y + 3, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level506
						&& _level506.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock()))), _level506).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y + 3, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y + 3, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level519
						&& _level519.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock()))), _level519).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 2, y + 3, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 2, y + 3, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level532
						&& _level532.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y - 2, z))).getBlock()))), _level532).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 2, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 2, y + 2, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level545
						&& _level545.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock()))), _level545).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y + 2, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level558
						&& _level558.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock()))), _level558).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 1, y + 2, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level571
						&& _level571.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock()))), _level571).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 1, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 1, y + 2, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level584
						&& _level584.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock()))), _level584).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 2, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 2, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level597
						&& _level597.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock()))), _level597).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 2, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 2, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level610
						&& _level610.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock()))), _level610).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level623
						&& _level623.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).getBlock()))), _level623).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y - 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level636
						&& _level636.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).getBlock()))), _level636).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 2, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 2, y - 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level649
						&& _level649.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock()))), _level649).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x - 2, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x - 2, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level662
						&& _level662.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock()))), _level662).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x + 2, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x + 2, y, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
		} else if ((entity.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level679
						&& _level679.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock()))), _level679).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level692
						&& _level692.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock()))), _level692).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level705
						&& _level705.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock()))), _level705).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level718
						&& _level718.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock()))), _level718).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y - 1, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level731
						&& _level731.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock()))), _level731).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y - 1, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level744
						&& _level744.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock()))), _level744).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level757
						&& _level757.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()))), _level757).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level770
						&& _level770.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()))), _level770).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y - 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level783
						&& _level783.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock()))), _level783).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 2, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level796
						&& _level796.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock()))), _level796).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 3, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 3, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level809
						&& _level809.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock()))), _level809).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 2, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 2, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level822
						&& _level822.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock()))), _level822).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 2, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 2, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level835
						&& _level835.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock()))), _level835).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 3, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 3, z + 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level848
						&& _level848.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock()))), _level848).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 3, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 3, z - 1);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level861
						&& _level861.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock()))), _level861).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level874
						&& _level874.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock()))), _level874).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level887
						&& _level887.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).getBlock()))), _level887).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 3, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 3, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level900
						&& _level900.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).getBlock()))), _level900).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 2, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 2, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level913
						&& _level913.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock()))), _level913).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level926
						&& _level926.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).getBlock()))), _level926).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y - 1, z - 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y - 1, z - 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level939
						&& _level939.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).getBlock()))), _level939).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y - 1, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y - 1, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level952
						&& _level952.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock()))), _level952).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 1, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level965
						&& _level965.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).getBlock()))), _level965).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 2, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 2, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).getBlock() == Blocks.BEDROCK)) {
				if (world instanceof ServerLevel _level978
						&& _level978.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).getBlock()))), _level978).isPresent()) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).getBlock())))));
						entityToSpawn.setPickUpDelay(10);
						_level.addFreshEntity(entityToSpawn);
					}
					world.setBlock(BlockPos.containing(x, y + 3, z + 2), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 3, z + 2);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
				}
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEDROCK)) {
			if (world instanceof ServerLevel _level991 && _level991.recipeAccess().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()))), _level991).isPresent()) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())))));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
			} else {
				{
					BlockPos _pos = BlockPos.containing(x, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
		}
	}

	private static ItemStack getItemStackSmeltingResult(LevelAccessor level, ItemStack input) {
		SingleRecipeInput recipeInput = new SingleRecipeInput(input);
		if (level instanceof ServerLevel serverLevel) {
			return serverLevel.recipeAccess().getRecipeFor(RecipeType.SMELTING, recipeInput, serverLevel).map(recipe -> recipe.value().assemble(recipeInput).copy()).orElse(ItemStack.EMPTY);
		}
		return ItemStack.EMPTY;
	}
}
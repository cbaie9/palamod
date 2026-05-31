package palamod.procedures;

import palamod.init.PalamodModItems;

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
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SmeltplusProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean removeBlock = false;
		world.destroyBlock(BlockPos.containing(x, y, z), false);
		if (entity.getXRot() > 40 || entity.getXRot() < -40) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 1, y, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 1, y, z), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 1, y, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 1, y, z), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 1, y, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 1, y, z + 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 1, y, z + 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 1, y, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y, z + 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 1, y, z - 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 1, y, z - 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 1, y, z - 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y, z - 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 1, y, z - 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 1, y, z - 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 1, y, z - 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 1, y, z - 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 1, y, z + 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 1, y, z + 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 1, y, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 1, y, z + 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y, z + 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z + 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y, z + 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z + 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y, z + 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z + 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y, z + 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z + 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y, z + 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z + 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y, z + 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z + 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y, z - 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z - 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y, z - 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y, z - 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z - 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
		} else if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 1, y, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 1, y, z), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 1, y, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 1, y, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 1, y, z), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 1, y, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 1, y, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 1, y + 1, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 1, y + 1, z), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 1, y + 1, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 1, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))
					&& !((world.getBlockState(BlockPos.containing(x + 1, y - 1, z - 0))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 1, y - 1, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 1, y - 1, z - 0), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 1, y - 1, z - 0);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y - 1, z - 0), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))
					&& !((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y + 1, z - 0))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y + 1, z - 0), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y + 1, z - 0);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y + 1, z - 0), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 1, y, z + 0)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 0))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 0))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 1, y + 1, z + 0), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 1, y + 1, z + 0);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 1, y + 1, z + 0), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))
					&& !((world.getBlockState(BlockPos.containing(x - 1, y + 1, z - 0))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 1, y + 1, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 1, y + 1, z - 0), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 1, y + 1, z - 0);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 1, y + 1, z - 0), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 0))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe")))
					&& !((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 0))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 0)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 0))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z + 0))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 1, y - 1, z), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 1, y - 1, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 0, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 0, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y - 1, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y - 1, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y - 1, z), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y - 1, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 0, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 1, y - 1, z)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 1, y - 1, z), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 1, y - 1, z);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
		} else if ((entity.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y, z + 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z + 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y, z + 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z + 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y, z - 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z - 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y, z - 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y, z - 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y, z - 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y + 1, z + 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y + 1, z + 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y + 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 0, y + 1, z + 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y + 1, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 0, y + 1, z + 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y - 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 0, y - 1, z + 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 0, y - 1, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y - 1, z + 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 0, y - 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x - 0, y - 1, z - 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x - 0, y - 1, z - 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x - 0, y - 1, z - 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 0, y + 1, z - 1)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y + 1, z - 1))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y + 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 0, y + 1, z - 1), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 0, y + 1, z - 1);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 1, z - 1), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 0, y + 1, z - 0)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y + 1, z - 0))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y + 1, z - 0))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 0, y + 1, z - 0), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 0, y + 1, z - 0);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y + 1, z - 0), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops((world.getBlockState(BlockPos.containing(x + 0, y - 1, z - 0)))) == true) {
					if (!((getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y - 1, z - 0))).getBlock())))).getItem() == Blocks.AIR.asItem())) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, (x + 0.5), (y + 0.5), (z + 0.5), (getItemStackFromItemStackSlot(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 0, y - 1, z - 0))).getBlock())))));
							entityToSpawn.setPickUpDelay(10);
							_level.addFreshEntity(entityToSpawn);
						}
						removeBlock = true;
					} else {
						removeBlock = false;
					}
					if (removeBlock == true) {
						world.destroyBlock(BlockPos.containing(x + 0, y - 1, z - 0), false);
					} else {
						{
							BlockPos _pos = BlockPos.containing(x + 0, y - 1, z - 0);
							Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x + 1, y - 1, z - 0), null);
							world.destroyBlock(_pos, false);
						}
					}
				}
			}
		}
	}

	private static ItemStack getItemStackFromItemStackSlot(LevelAccessor level, ItemStack input) {
		SingleRecipeInput recipeInput = new SingleRecipeInput(input);
		if (level instanceof ServerLevel serverLevel) {
			return serverLevel.recipeAccess().getRecipeFor(RecipeType.SMELTING, recipeInput, serverLevel).map(recipe -> recipe.value().assemble(recipeInput, serverLevel.registryAccess()).copy()).orElse(ItemStack.EMPTY);
		}
		return ItemStack.EMPTY;
	}
}
package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
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

public class Hamsf3Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getXRot() > 40 || entity.getXRot() < -40) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x + 1, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x + 1, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x - 1, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x - 1, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 0, z + 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
			}
		} else if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 0, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y + 0, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
		} else if ((entity.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 0, z + 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 0, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 0, z - 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(Identifier.parse("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if (!((getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))).getItem() == (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock()))
						.getItem())) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
					if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.33) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (getItemStackSmeltingResult(world, (new ItemStack((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock())))));
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				}
				world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
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
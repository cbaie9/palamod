package palamod.procedures;

import palamod.init.PalamodModEnchantments;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class FortunehammerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState block1 = Blocks.AIR.defaultBlockState();
		BlockState block2 = Blocks.AIR.defaultBlockState();
		BlockState block3 = Blocks.AIR.defaultBlockState();
		BlockState block4 = Blocks.AIR.defaultBlockState();
		BlockState block5 = Blocks.AIR.defaultBlockState();
		BlockState block6 = Blocks.AIR.defaultBlockState();
		BlockState block7 = Blocks.AIR.defaultBlockState();
		BlockState block8 = Blocks.AIR.defaultBlockState();
		BlockState block9 = Blocks.AIR.defaultBlockState();
		boolean rego = false;
		if (entity.getXRot() > 40 || entity.getXRot() < -40) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block9 = (world.getBlockState(BlockPos.containing(x, y, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block9.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x + 1, y, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block1 = (world.getBlockState(BlockPos.containing(x + 1, y, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x - 1, y, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block2 = (world.getBlockState(BlockPos.containing(x - 1, y, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x + 1, y, z + 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block3 = (world.getBlockState(BlockPos.containing(x + 1, y, z + 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x + 1, y, z - 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block4 = (world.getBlockState(BlockPos.containing(x + 1, y, z - 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x - 1, y, z - 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block5 = (world.getBlockState(BlockPos.containing(x - 1, y, z - 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x - 1, y, z + 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block6 = (world.getBlockState(BlockPos.containing(x - 1, y, z + 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z + 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block7 = (world.getBlockState(BlockPos.containing(x, y, z + 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z - 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block8 = (world.getBlockState(BlockPos.containing(x, y, z - 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
		} else if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block9 = (world.getBlockState(BlockPos.containing(x, y, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x + 1, y, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block1 = (world.getBlockState(BlockPos.containing(x + 1, y, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x - 1, y, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block2 = (world.getBlockState(BlockPos.containing(x - 1, y, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x + 1, y + 1, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block3 = (world.getBlockState(BlockPos.containing(x + 1, y + 1, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x + 1, y - 1, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x + 1, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block4 = (world.getBlockState(BlockPos.containing(x + 1, y - 1, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x + 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x - 1, y - 1, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block5 = (world.getBlockState(BlockPos.containing(x - 1, y - 1, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x - 1, y + 1, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x - 1, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block6 = (world.getBlockState(BlockPos.containing(x - 1, y + 1, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x - 1, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y + 1, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block7 = (world.getBlockState(BlockPos.containing(x, y + 1, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y - 1, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block8 = (world.getBlockState(BlockPos.containing(x, y - 1, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
		} else if ((entity.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block9 = (world.getBlockState(BlockPos.containing(x, y, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
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
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z + 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block1 = (world.getBlockState(BlockPos.containing(x, y, z + 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block1.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z - 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block2 = (world.getBlockState(BlockPos.containing(x, y, z - 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block2.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y + 1, z + 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y + 1, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block3 = (world.getBlockState(BlockPos.containing(x, y + 1, z + 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block3.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y - 1, z + 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z + 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block4 = (world.getBlockState(BlockPos.containing(x, y - 1, z + 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block4.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y - 1, z + 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y - 1, z - 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block5 = (world.getBlockState(BlockPos.containing(x, y - 1, z - 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block5.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y - 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y + 1, z - 1), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y + 1, z - 1);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block6 = (world.getBlockState(BlockPos.containing(x, y + 1, z - 1)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block6.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z - 1), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y + 1, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y + 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block7 = (world.getBlockState(BlockPos.containing(x, y + 1, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block7.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					{
						BlockPos _pos = BlockPos.containing(x, y + 1, z);
						Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
						world.destroyBlock(_pos, false);
					}
					rego = true;
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				if ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y - 1, z), "hasbeen_dpct")) == false) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y - 1, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("hasbeen_dpct", true);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					block8 = (world.getBlockState(BlockPos.containing(x, y - 1, z)));
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 0) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 1) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
							entityToSpawn.setPickUpDelay(20);
							_level.addFreshEntity(entityToSpawn);
						}
						if (Math.random() < 0.33) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 2) {
						if (Math.random() < 0.5) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.25) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(PalamodModEnchantments.HAMMER_FORTUNE.get()) == 3) {
						if (Math.random() < 0.4) {
							if (world instanceof ServerLevel _level) {
								ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
								entityToSpawn.setPickUpDelay(20);
								_level.addFreshEntity(entityToSpawn);
							}
						} else {
							if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (Math.random() < 0.2) {
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, (new ItemStack(block8.getBlock())));
									entityToSpawn.setPickUpDelay(20);
									_level.addFreshEntity(entityToSpawn);
								}
							}
						}
					}
					world.setBlock(BlockPos.containing(x, y - 1, z), Blocks.AIR.defaultBlockState(), 3);
				} else {
					rego = true;
				}
			}
		}
	}
}

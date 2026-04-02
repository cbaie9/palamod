package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ForturneprocessoredropProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState block_ore = Blocks.AIR.defaultBlockState();
		ItemStack drop = ItemStack.EMPTY;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.PALADIUM_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_PALADIUM_ORE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_PALADIUM_ORE.get()) {
			drop = new ItemStack(PalamodModItems.PALADIUM_RAW_ORE.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.TITANE_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_TITANE_ORE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_TITANE_ORE.get()) {
			drop = new ItemStack(PalamodModItems.TITANE_RAW_ORE.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYST_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_AMETHYST_ORE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_AMETHYST_ORE.get()) {
			drop = new ItemStack(PalamodModItems.AMETHYST_RAW_ORE.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.PALADIUM_GREEN_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_GREEN_PALADIUM_ORE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_GREEN_PALADIUM_ORE.get()) {
			drop = new ItemStack(PalamodModItems.GREEN_PALADIUM_RAW_ORE.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.FINDIUM_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_FINDIUM_ORE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_FINDIUM_ORE.get()) {
			drop = new ItemStack(PalamodModItems.FINDIUM.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ENDIUM_NUGGET_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_ENDIUM_NUGGET_ORE.get()
				|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_ENDIUM_NUGGET_ORE.get()) {
			drop = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_COAL_ORE.get()) {
			drop = new ItemStack(Items.COAL).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_IRON_ORE.get()) {
			drop = new ItemStack(Items.RAW_IRON).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_DIAMOND_ORE.get()) {
			drop = new ItemStack(Items.DIAMOND).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_GOLD_ORE.get()) {
			drop = new ItemStack(Items.RAW_GOLD).copy();
		} else {
			drop = new ItemStack(Blocks.BEDROCK).copy();
		}
		if (!(drop.getItem() == Blocks.BEDROCK.asItem())) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) == 0) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) == 1) {
				if (world instanceof ServerLevel _level) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
					entityToSpawn.setPickUpDelay(0);
					_level.addFreshEntity(entityToSpawn);
				}
				if (Math.random() < 0.33) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) == 2) {
				if (Math.random() < 0.5) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					if (Math.random() < 0.25) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.25) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) == 3) {
				if (Math.random() < 0.4) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				} else {
					if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					} else if (Math.random() < 0.2) {
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
						if (world instanceof ServerLevel _level) {
							ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
							entityToSpawn.setPickUpDelay(0);
							_level.addFreshEntity(entityToSpawn);
						}
					}
				}
			}
		}
	}
}
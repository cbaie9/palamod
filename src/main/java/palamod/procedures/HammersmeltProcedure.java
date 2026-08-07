package palamod.procedures;

import palamod.init.PalamodModItems;

import palamod.PalamodMod;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.ICancellableEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class HammersmeltProcedure {
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
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:hammer_smt")))) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
					.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0) {
				PalamodMod.LOGGER.debug("[hammerpros] : cancel break block");
				if (event instanceof ICancellableEvent _cancellable) {
					_cancellable.setCanceled(true);
				}
			}
			tag = "mineable/pickaxe";
			i = -1;
			for (int index845 = 0; index845 < 3; index845++) {
				j = -1;
				for (int index846 = 0; index846 < 3; index846++) {
					if (i != 0 || j != 0) {
						if (entity.getXRot() > 40 || entity.getXRot() < -40) {
							block_x = x + i;
							block_y = y;
							block_z = z + j;
						} else if ((entity.getDirection()).getAxis() == Direction.Axis.Z) {
							block_x = x + i;
							block_y = y + j;
							block_z = z;
						} else if ((entity.getDirection()).getAxis() == Direction.Axis.X) {
							block_x = x;
							block_y = y + j;
							block_z = z + i;
						}
					} else {
						block_x = x;
						block_y = y;
						block_z = z;
					}
					block = (world.getBlockState(BlockPos.containing(block_x, block_y, block_z)));
					if (block.is(BlockTags.create(ResourceLocation.parse((tag).toLowerCase(java.util.Locale.ENGLISH))))) {
						if (new ItemStack(PalamodModItems.PALADIUM_HAMMER.get()).isCorrectToolForDrops(block) == true) {
							smelting_result = (world instanceof Level _lvlSmeltResult
									? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput((new ItemStack(block.getBlock()))), _lvlSmeltResult)
											.map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
									: ItemStack.EMPTY).copy();
							if (!(smelting_result.getItem() == Blocks.AIR.asItem()) && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0) {
								for (int index847 = 0; index847 < (int) GetFortuneBonusAmountProcedure.execute(world, entity); index847++) {
									if (world instanceof ServerLevel _level) {
										ItemEntity entityToSpawn = new ItemEntity(_level, (block_x + 0.5), (block_y + 0.5), (block_z + 0.5), smelting_result);
										entityToSpawn.setPickUpDelay(10);
										_level.addFreshEntity(entityToSpawn);
									}
								}
								removeBlock = true;
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
					j = j + 1;
				}
				i = i + 1;
			}
		}
	}
}
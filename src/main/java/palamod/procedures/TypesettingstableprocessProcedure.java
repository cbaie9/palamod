package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class TypesettingstableprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack output_book = ItemStack.EMPTY;
		ItemStack input_book = ItemStack.EMPTY;
		if (!entity.isShiftKeyDown()) {
			if (Items.ENCHANTED_BOOK == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "book_loaded")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("book_loaded", true);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				input_book = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
				PalamodMod.LOGGER.info((world.getBlockState(BlockPos.containing(x, y, z)) + " - "
						+ ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING)) != 0)));
				if (Items.ENCHANTED_BOOK == input_book.getItem()) {
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("smelt",
										(input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt"))))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
							.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune")))) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("hammer_fortune",
										(input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed")))) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("speed",
										(input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole")))) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("big_hole",
										(input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg")))) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("auto_smelt_potg",
										(input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:chargedenchant")))) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("charged",
										(input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:chargedenchant"))))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled")))) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("botteled",
										(input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled"))))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant")))) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("one_more_upgrade",
										(input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant"))))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("aqua_affinity", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("bane_arthropods", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("binding_curse", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("blast_protection", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BREACH)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("breach", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BREACH))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("channeling", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DENSITY)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("density", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DENSITY))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("depth_strider", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("efficiency", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("feather_falling", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("fire_aspect", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("fire_protection", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_PROTECTION))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("flame", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("fortune", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("frost_walker", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("impaling", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("infinity", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("knockback", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("looting", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("loyaty", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("luck_of_the_sea", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("lure", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("mending", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("multishot", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("piercing", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("power", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("power", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("projectile_protection", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("protection", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("punch", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("quick_charge", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("respiration", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("riptide", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("sharpness", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("silk_touch", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("smite", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("soul_speed", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("sweeping", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("swift_sneak", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("thorns", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("unbreaking", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("feuerghyfhjhjkjiklmdfgdfg"), false);
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("vanishing_curse", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					if (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.WIND_BURST)) != 0) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("wind_burst", (input_book.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.WIND_BURST))));
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
				}
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "plate_loaded")) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = PalamodModBlocks.TYPESETTINGMAX.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						BlockEntity _be = world.getBlockEntity(_bp);
						CompoundTag _bnbt = null;
						if (_be != null) {
							_bnbt = _be.saveWithFullMetadata(world.registryAccess());
							_be.setRemoved();
						}
						world.setBlock(_bp, _bs, 3);
						if (_bnbt != null) {
							_be = world.getBlockEntity(_bp);
							if (_be != null) {
								try {
									_be.loadWithComponents(_bnbt, world.registryAccess());
								} catch (Exception ignored) {
								}
							}
						}
					}
				} else {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = PalamodModBlocks.TYPESETTINGBOOK.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						BlockEntity _be = world.getBlockEntity(_bp);
						CompoundTag _bnbt = null;
						if (_be != null) {
							_bnbt = _be.saveWithFullMetadata(world.registryAccess());
							_be.setRemoved();
						}
						world.setBlock(_bp, _bs, 3);
						if (_bnbt != null) {
							_be = world.getBlockEntity(_bp);
							if (_be != null) {
								try {
									_be.loadWithComponents(_bnbt, world.registryAccess());
								} catch (Exception ignored) {
								}
							}
						}
					}
				}
			} else if (PalamodModItems.PLATE.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() && !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "plate_loaded")) {
				if (!world.isClientSide()) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					BlockEntity _blockEntity = world.getBlockEntity(_bp);
					BlockState _bs = world.getBlockState(_bp);
					if (_blockEntity != null)
						_blockEntity.getPersistentData().putBoolean("plate_loaded", true);
					if (world instanceof Level _level)
						_level.sendBlockUpdated(_bp, _bs, _bs, 3);
				}
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PalamodModItems.PLATE.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "book_loaded")) {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = PalamodModBlocks.TYPESETTINGMAX.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						BlockEntity _be = world.getBlockEntity(_bp);
						CompoundTag _bnbt = null;
						if (_be != null) {
							_bnbt = _be.saveWithFullMetadata(world.registryAccess());
							_be.setRemoved();
						}
						world.setBlock(_bp, _bs, 3);
						if (_bnbt != null) {
							_be = world.getBlockEntity(_bp);
							if (_be != null) {
								try {
									_be.loadWithComponents(_bnbt, world.registryAccess());
								} catch (Exception ignored) {
								}
							}
						}
					}
				} else {
					{
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockState _bs = PalamodModBlocks.TYPESETTINGPLATE.get().defaultBlockState();
						BlockState _bso = world.getBlockState(_bp);
						for (Property<?> _propertyOld : _bso.getProperties()) {
							Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
							if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
								try {
									_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
								} catch (Exception e) {
								}
						}
						BlockEntity _be = world.getBlockEntity(_bp);
						CompoundTag _bnbt = null;
						if (_be != null) {
							_bnbt = _be.saveWithFullMetadata(world.registryAccess());
							_be.setRemoved();
						}
						world.setBlock(_bp, _bs, 3);
						if (_bnbt != null) {
							_be = world.getBlockEntity(_bp);
							if (_be != null) {
								try {
									_be.loadWithComponents(_bnbt, world.registryAccess());
								} catch (Exception ignored) {
								}
							}
						}
					}
				}
			} else {
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "book_loaded")) {
					if (!world.isClientSide()) {
						BlockPos _bp = BlockPos.containing(x, y, z);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putBoolean("book_loaded", false);
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					input_book = new ItemStack(Items.ENCHANTED_BOOK).copy();
					if (0 == 0) {
						PalamodMod.LOGGER.info("1");
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smelt") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt"))),
									(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smelt"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "hammer_fortune") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))),
									(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "hammer_fortune"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "speed") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))),
									(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "speed"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "big_hole") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))),
									(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "big_hole"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "auto_smelt_potg") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))),
									(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "auto_smelt_potg"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "charged") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:chargedenchant"))),
									(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "charged"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "botteled") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled"))),
									(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "botteled"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "one_more_upgrade") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant"))),
									(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "one_more_upgrade"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "aqua_affinity") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "aqua_affinity"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "bane_arthropods") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "bane_arthropods"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "binding_curse") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "binding_curse"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "breach") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BREACH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "breach"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blast_protection") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blast_protection"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "channeling") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "channeling"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "density") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DENSITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "density"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "depth_strider") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "depth_strider"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "efficiency") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "efficiency"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feather_falling") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feather_falling"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fire_aspect") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fire_aspect"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flame") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flame"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fortune") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fortune"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frost_walker") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frost_walker"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "impaling") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "impaling"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "infinity") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "infinity"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "knockback") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "knockback"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "looting") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "looting"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "loyaty") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "loyaty"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "luck_of_the_sea") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "luck_of_the_sea"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lure") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lure"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "mending") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "mending"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "multishot") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "multishot"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "piercing") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "piercing"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "power") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "power"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "projectile_protection") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "projectile_protection"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "protection") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "protection"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "punch") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "punch"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "quick_charge") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "quick_charge"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "respiration") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "respiration"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "riptide") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "riptide"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sharpness") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sharpness"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "silk_touch") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "silk_touch"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smite") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smite"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul_speed") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul_speed"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sweeping") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sweeping"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "swift_sneak") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "swift_sneak"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "thorns") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "thorns"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "unbreaking") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "unbreaking"));
							PalamodMod.LOGGER.info("2ubk");
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "vanishing_curse") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "vanishing_curse"));
						}
						if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "wind_burst") > 0) {
							input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.WIND_BURST), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "wind_burst"));
						}
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = input_book.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "plate_loaded")) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = PalamodModBlocks.TYPESETTINGPLATE.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							BlockEntity _be = world.getBlockEntity(_bp);
							CompoundTag _bnbt = null;
							if (_be != null) {
								_bnbt = _be.saveWithFullMetadata(world.registryAccess());
								_be.setRemoved();
							}
							world.setBlock(_bp, _bs, 3);
							if (_bnbt != null) {
								_be = world.getBlockEntity(_bp);
								if (_be != null) {
									try {
										_be.loadWithComponents(_bnbt, world.registryAccess());
									} catch (Exception ignored) {
									}
								}
							}
						}
					} else {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = PalamodModBlocks.TYPESETTINGTABLE.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							BlockEntity _be = world.getBlockEntity(_bp);
							CompoundTag _bnbt = null;
							if (_be != null) {
								_bnbt = _be.saveWithFullMetadata(world.registryAccess());
								_be.setRemoved();
							}
							world.setBlock(_bp, _bs, 3);
							if (_bnbt != null) {
								_be = world.getBlockEntity(_bp);
								if (_be != null) {
									try {
										_be.loadWithComponents(_bnbt, world.registryAccess());
									} catch (Exception ignored) {
									}
								}
							}
						}
					}
				} else {
					if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "plate_loaded")) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("plate_loaded", false);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.PLATE.get()).copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "book_loaded")) {
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = PalamodModBlocks.TYPESETTINGBOOK.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								BlockEntity _be = world.getBlockEntity(_bp);
								CompoundTag _bnbt = null;
								if (_be != null) {
									_bnbt = _be.saveWithFullMetadata(world.registryAccess());
									_be.setRemoved();
								}
								world.setBlock(_bp, _bs, 3);
								if (_bnbt != null) {
									_be = world.getBlockEntity(_bp);
									if (_be != null) {
										try {
											_be.loadWithComponents(_bnbt, world.registryAccess());
										} catch (Exception ignored) {
										}
									}
								}
							}
						} else {
							{
								BlockPos _bp = BlockPos.containing(x, y, z);
								BlockState _bs = PalamodModBlocks.TYPESETTINGTABLE.get().defaultBlockState();
								BlockState _bso = world.getBlockState(_bp);
								for (Property<?> _propertyOld : _bso.getProperties()) {
									Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
									if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
										try {
											_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
										} catch (Exception e) {
										}
								}
								BlockEntity _be = world.getBlockEntity(_bp);
								CompoundTag _bnbt = null;
								if (_be != null) {
									_bnbt = _be.saveWithFullMetadata(world.registryAccess());
									_be.setRemoved();
								}
								world.setBlock(_bp, _bs, 3);
								if (_bnbt != null) {
									_be = world.getBlockEntity(_bp);
									if (_be != null) {
										try {
											_be.loadWithComponents(_bnbt, world.registryAccess());
										} catch (Exception ignored) {
										}
									}
								}
							}
						}
					}
				}
			}
		} else {
			if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "book_loaded")) {
				if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "plate_loaded")) {
					if (30 <= (entity instanceof Player _plr ? _plr.experienceLevel : 0)) {
						input_book = new ItemStack(PalamodModItems.PLATE.get()).copy();
						if (0 == 0) {
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smelt") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt"))),
										(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smelt"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "hammer_fortune") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))),
										(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "hammer_fortune"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "speed") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))),
										(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "speed"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "big_hole") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))),
										(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "big_hole"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "auto_smelt_potg") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))),
										(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "auto_smelt_potg"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "charged") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:chargedenchant"))),
										(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "charged"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "botteled") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled"))),
										(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "botteled"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "one_more_upgrade") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant"))),
										(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "one_more_upgrade"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "aqua_affinity") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "aqua_affinity"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "bane_arthropods") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "bane_arthropods"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "binding_curse") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "binding_curse"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "breach") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BREACH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "breach"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blast_protection") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blast_protection"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "channeling") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "channeling"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "density") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DENSITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "density"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "depth_strider") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "depth_strider"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "efficiency") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "efficiency"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feather_falling") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feather_falling"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fire_aspect") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fire_aspect"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flame") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flame"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fortune") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fortune"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frost_walker") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frost_walker"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "impaling") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "impaling"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "infinity") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "infinity"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "knockback") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "knockback"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "looting") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "looting"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "loyaty") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "loyaty"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "luck_of_the_sea") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "luck_of_the_sea"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lure") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lure"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "mending") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "mending"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "multishot") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "multishot"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "piercing") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "piercing"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "power") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "power"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "projectile_protection") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "projectile_protection"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "protection") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "protection"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "punch") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "punch"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "quick_charge") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "quick_charge"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "respiration") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "respiration"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "riptide") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "riptide"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sharpness") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sharpness"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "silk_touch") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "silk_touch"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smite") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smite"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul_speed") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul_speed"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sweeping") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sweeping"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "swift_sneak") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "swift_sneak"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "thorns") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "thorns"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "unbreaking") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "unbreaking"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "vanishing_curse") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "vanishing_curse"));
							}
							if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "wind_burst") > 0) {
								input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.WIND_BURST), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "wind_burst"));
							}
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = input_book.copy();
							_setstack.setCount(1);
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player)
							_player.giveExperienceLevels(-(30));
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("plate_loaded", false);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putBoolean("book_loaded", false);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						TypesettingtableclearunloadenchantProcedure.execute(world, x, y, z);
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = PalamodModBlocks.TYPESETTINGTABLE.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Property<?> _propertyOld : _bso.getProperties()) {
								Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
								if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
									try {
										_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
									} catch (Exception e) {
									}
							}
							BlockEntity _be = world.getBlockEntity(_bp);
							CompoundTag _bnbt = null;
							if (_be != null) {
								_bnbt = _be.saveWithFullMetadata(world.registryAccess());
								_be.setRemoved();
							}
							world.setBlock(_bp, _bs, 3);
							if (_bnbt != null) {
								_be = world.getBlockEntity(_bp);
								if (_be != null) {
									try {
										_be.loadWithComponents(_bnbt, world.registryAccess());
									} catch (Exception ignored) {
									}
								}
							}
						}
					} else {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("tellraw @s [\"\",{\"text\":\"[ Palamod ]\",\"color\":\"gold\"},{\"text\":\" : " + "" + Component.translatable("palamod.procedure.type_set3").getString() + "\",\"color\":\"dark_red\"}]"));
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("tellraw @s [\"\",{\"text\":\"[ Palamod ]\",\"color\":\"gold\"},{\"text\":\" : " + "" + Component.translatable("palamod.procedure.type_set1").getString() + "\",\"color\":\"dark_red\"}]"));
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @s [\"\",{\"text\":\"[ Palamod ]\",\"color\":\"gold\"},{\"text\":\" : " + "" + Component.translatable("palamod.procedure.type_set2").getString() + "\",\"color\":\"dark_red\"}]"));
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}

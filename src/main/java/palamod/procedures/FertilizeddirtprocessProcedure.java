package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class FertilizeddirtprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(new ResourceLocation("forge:seed")))
				&& (world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("forge:air")))) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY);
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
			if (Items.WHEAT_SEEDS == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.WHEAT.defaultBlockState(), 3);
			} else if (Items.MELON_SEEDS == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.MELON_STEM.defaultBlockState(), 3);
			} else if (Items.PUMPKIN_SEEDS == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.PUMPKIN_STEM.defaultBlockState(), 3);
			} else if (Items.BEETROOT_SEEDS == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.BEETROOTS.defaultBlockState(), 3);
			} else if (Items.CARROT == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.CARROTS.defaultBlockState(), 3);
			} else if (Items.POTATO == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.POTATOES.defaultBlockState(), 3);
			} else if (PalamodModItems.EGGPLANT_SEED.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), PalamodModBlocks.EGGPLANT_0.get().defaultBlockState(), 3);
			} else if (PalamodModItems.CHERVILSEED.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), PalamodModBlocks.CHERVIL_0.get().defaultBlockState(), 3);
			} else if (PalamodModItems.KIWANOSEED.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), PalamodModBlocks.KIWANO_0.get().defaultBlockState(), 3);
			} else if (PalamodModItems.ORANGEBLUESEED.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				world.setBlock(BlockPos.containing(x, y + 1, z), PalamodModBlocks.ORANGEBLUE_0.get().defaultBlockState(), 3);
			}
		}
	}
}

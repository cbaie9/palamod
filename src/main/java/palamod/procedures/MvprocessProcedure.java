package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class MvprocessProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		for (int index1093 = 0; index1093 < 64; index1093++) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("powered") == true) {
				if (hasEntityInInventory(entity, new ItemStack(PalamodModBlocks.SOFT_STONE.get()))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModBlocks.COBBLED_SOFT_STONE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(PalamodModBlocks.COBBLED_SOFT_STONE.get()))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModBlocks.SOFT_STONE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.SMOOTH_STONE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.SMOOTH_STONE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.DEEPSLATE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.DEEPSLATE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.COBBLED_DEEPSLATE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.COBBLED_DEEPSLATE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.STONE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.STONE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.COBBLESTONE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.COBBLESTONE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.GRANITE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.GRANITE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.DIORITE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.DIORITE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.ANDESITE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.ANDESITE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.BLACKSTONE))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.BLACKSTONE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.BASALT))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.BASALT);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.NETHERRACK))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.NETHERRACK);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(Blocks.TUFF))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.TUFF);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(PalamodModBlocks.SOFT_STONE.get()))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModBlocks.SOFT_STONE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (hasEntityInInventory(entity, new ItemStack(PalamodModBlocks.COBBLED_SOFT_STONE.get()))) {
					{
						final String _tagName = "voidstone_count";
						final double _tagValue = (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count") + 1);
						CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
					}
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(PalamodModBlocks.COBBLED_SOFT_STONE.get());
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if ((itemstack.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()).is(BlockTags.create(ResourceLocation.parse("minecraft:mv_blocks")))) {
					continue;
				} else {
					break;
				}
			}
		}
		itemstack.set(DataComponents.CUSTOM_NAME,
				Component.literal((Component.translatable("item.palamod.minage_voidstone").getString() + " - " + Math.round(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("voidstone_count")))));
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}
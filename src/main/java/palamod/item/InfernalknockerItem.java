package palamod.item;

import palamod.procedures.Infernalknocker_aknoProcedure;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class InfernalknockerItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 59, 4f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:infernalknocker_repair_items")));

	public InfernalknockerItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 3f, -2f).setNoCombineRepair());
	}

	@Override
	public ItemStack getCraftingRemainder(ItemStack itemstack) {
		return new ItemStack(this);
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Player entity) {
		super.onCraftedBy(itemstack, entity);
		Infernalknocker_aknoProcedure.execute(entity.level(), itemstack);
	}
}
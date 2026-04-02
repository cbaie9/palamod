package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class EndiumbroadswordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 10000, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:endium_broadsword_repair_items")));

	public EndiumbroadswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 15.5f, -3.5f).fireResistant());
	}
}
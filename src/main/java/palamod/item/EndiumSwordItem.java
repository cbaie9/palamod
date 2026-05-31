package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class EndiumSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 10000, 1f, 0, 50, TagKey.create(Registries.ITEM, Identifier.parse("palamod:endium_sword_repair_items")));

	public EndiumSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 9f, -2f).fireResistant());
	}
}
package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class PaladiumSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 0.5f, 0, 14, TagKey.create(Registries.ITEM, Identifier.parse("palamod:paladium_sword_repair_items")));

	public PaladiumSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 7f, -2f));
	}
}
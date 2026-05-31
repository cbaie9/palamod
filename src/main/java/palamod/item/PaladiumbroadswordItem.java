package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class PaladiumbroadswordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3999, 2f, 0, 1, TagKey.create(Registries.ITEM, Identifier.parse("palamod:paladiumbroadsword_repair_items")));

	public PaladiumbroadswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 11f, -3.5f));
	}
}
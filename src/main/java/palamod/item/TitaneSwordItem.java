package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class TitaneSwordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3999, 1f, 0, 70, TagKey.create(Registries.ITEM, Identifier.parse("palamod:titane_sword_repair_items")));

	public TitaneSwordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 6f, -2f));
	}
}
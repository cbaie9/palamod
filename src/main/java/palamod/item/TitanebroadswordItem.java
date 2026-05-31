package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class TitanebroadswordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2000, 14f, 0, 10, TagKey.create(Registries.ITEM, Identifier.parse("palamod:titanebroadsword_repair_items")));

	public TitanebroadswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 7.2f, -3.5f));
	}
}
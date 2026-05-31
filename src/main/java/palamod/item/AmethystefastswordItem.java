package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class AmethystefastswordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 400, 12f, 0, 10, TagKey.create(Registries.ITEM, Identifier.parse("palamod:amethyst_fastsword_repair_items")));

	public AmethystefastswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 5f, 6f));
	}
}
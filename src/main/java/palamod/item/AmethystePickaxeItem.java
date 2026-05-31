package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class AmethystePickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1999, 14f, 0, 30, TagKey.create(Registries.ITEM, Identifier.parse("palamod:amethyst_pickaxe_repair_items")));

	public AmethystePickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 4f, -3f));
	}
}
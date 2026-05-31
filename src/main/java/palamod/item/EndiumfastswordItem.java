package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class EndiumfastswordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2000, 16f, 0, 1, TagKey.create(Registries.ITEM, Identifier.parse("palamod:endium_fastsword_repair_items")));

	public EndiumfastswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 6.5f, 26f).fireResistant());
	}
}
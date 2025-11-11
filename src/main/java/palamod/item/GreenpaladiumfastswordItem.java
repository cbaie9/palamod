package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class GreenpaladiumfastswordItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 1000, 16f, 0, 1, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:greenpaladiumfastsword_repair_items")));

	public GreenpaladiumfastswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 5f, 16f));
	}
}
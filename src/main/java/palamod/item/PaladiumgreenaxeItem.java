package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class PaladiumgreenaxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 24f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:paladiumgreenaxe_repair_items")));

	public PaladiumgreenaxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 6.5f, -3f, properties);
	}
}
package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class TitaneShovelItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3999, 16f, 0, 30, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:titane_shovel_repair_items")));

	public TitaneShovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -3.9f, properties);
	}
}
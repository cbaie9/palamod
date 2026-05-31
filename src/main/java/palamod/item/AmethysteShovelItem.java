package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class AmethysteShovelItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2999, 14f, 0, 20, TagKey.create(Registries.ITEM, Identifier.parse("palamod:amethyst_shovel_repair_items")));

	public AmethysteShovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 2f, -3f, properties);
	}
}
package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

public class TitaneAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2380, 16f, 0, 70, TagKey.create(Registries.ITEM, Identifier.parse("palamod:titane_axe_repair_items")));

	public TitaneAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 9f, -3f, properties);
	}
}
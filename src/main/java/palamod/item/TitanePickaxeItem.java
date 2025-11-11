package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class TitanePickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 2999, 16f, 0, 25, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:titane_pickaxe_repair_items")));

	public TitanePickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 4.5f, -3f));
	}
}
package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class PaladiumgreenshovelItem extends ShovelItem {
<<<<<<< Updated upstream
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 36f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:paladiumgreenshovel_repair_items")));
=======
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 36f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:green_paladium_shovel_repair_items")));
>>>>>>> Stashed changes

	public PaladiumgreenshovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 4f, -3.5f, properties);
	}
}
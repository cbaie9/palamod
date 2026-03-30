package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class PaladiumgreenswordItem extends Item {
<<<<<<< Updated upstream
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 0.5f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:paladiumgreensword_repair_items")));
=======
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 0.5f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:green_paladium_sword_repair_items")));
>>>>>>> Stashed changes

	public PaladiumgreenswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 7f, -2f));
	}
}
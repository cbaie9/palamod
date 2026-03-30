package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class GreenpaladiumbroadswordItem extends Item {
<<<<<<< Updated upstream
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 100, 1f, 0, 20, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:greenpaladiumbroadsword_repair_items")));
=======
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 100, 1f, 0, 20, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:green_paladium_broadsword_repair_items")));
>>>>>>> Stashed changes

	public GreenpaladiumbroadswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 11f, -3.5f));
	}
}
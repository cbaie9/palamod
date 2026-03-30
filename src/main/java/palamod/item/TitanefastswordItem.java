package palamod.item;

import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;

public class TitanefastswordItem extends Item {
<<<<<<< Updated upstream
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 400, 12f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:titanefastsword_repair_items")));
=======
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 400, 12f, 0, 10, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:titane_fastsword_repair_items")));
>>>>>>> Stashed changes

	public TitanefastswordItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 5f, 6f));
	}
}
package palamod.item;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import java.util.function.Consumer;

public class PaladiumgreenpickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 24f, 0, 10, TagKey.create(Registries.ITEM, Identifier.parse("palamod:green_paladium_pickaxe_repair_items")));

	public PaladiumgreenpickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 5.5f, -2.5f));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.palamod.green_paladium_pickaxe.description_0"));
	}
}
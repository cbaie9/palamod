package palamod.item;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.Item;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class PotatobackpackItem extends Item {
	public PotatobackpackItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public ItemStackTemplate getCraftingRemainder(ItemInstance itemInstance) {
		return new ItemStackTemplate(this);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		componentConsumer.accept(Component.translatable("item.palamod.potato_backpack.description_0"));
	}
}
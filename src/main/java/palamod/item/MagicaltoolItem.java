package palamod.item;

import palamod.procedures.MagicaltoolsprocessProcedure;
<<<<<<< Updated upstream

import net.minecraft.world.item.context.UseOnContext;
=======
import palamod.procedures.CraftableToolTipTextProcedure;

import palamod.PalamodMod;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
>>>>>>> Stashed changes
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
<<<<<<< Updated upstream
=======
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;
>>>>>>> Stashed changes

public class MagicaltoolItem extends Item {
	public MagicaltoolItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public ItemUseAnimation getUseAnimation(ItemStack itemstack) {
		return ItemUseAnimation.EAT;
<<<<<<< Updated upstream
=======
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PalamodMod.clientPlayer();
		String hoverText = CraftableToolTipTextProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				componentConsumer.accept(Component.literal(line));
			}
		}
>>>>>>> Stashed changes
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		MagicaltoolsprocessProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ());
		return InteractionResult.SUCCESS;
	}
}
package palamod.item;

import palamod.procedures.ExtratorblockstateprocessProcedure;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

public class ExtractorItem extends Item {
	public ExtractorItem(Item.Properties properties) {
		super(properties.durability(145));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ExtratorblockstateprocessProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getLevel().getBlockState(context.getClickedPos()), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
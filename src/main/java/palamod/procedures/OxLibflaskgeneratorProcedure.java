package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

public class OxLibflaskgeneratorProcedure {
	public static void execute(Entity entity, double stock, String seve_type) {
		if (entity == null || seve_type == null)
			return;
		ItemStack flask = ItemStack.EMPTY;
		flask = new ItemStack(PalamodModItems.FLASK.get()).copy();
		if ((seve_type).equals("ostrya")) {
			{
				final String _tagName = "type";
				final double _tagValue = 1;
				CustomData.update(DataComponents.CUSTOM_DATA, flask, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else if ((seve_type).equals("judeecercis")) {
			{
				final String _tagName = "type";
				final double _tagValue = 2;
				CustomData.update(DataComponents.CUSTOM_DATA, flask, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else if ((seve_type).equals("jacaranda")) {
			{
				final String _tagName = "type";
				final double _tagValue = 3;
				CustomData.update(DataComponents.CUSTOM_DATA, flask, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else if ((seve_type).equals("erable")) {
			{
				final String _tagName = "type";
				final double _tagValue = 4;
				CustomData.update(DataComponents.CUSTOM_DATA, flask, tag -> tag.putDouble(_tagName, _tagValue));
			}
		} else {
			{
				final String _tagName = "type";
				final double _tagValue = 0;
				CustomData.update(DataComponents.CUSTOM_DATA, flask, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		{
			final String _tagName = "seve";
			final double _tagValue = stock;
			CustomData.update(DataComponents.CUSTOM_DATA, flask, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (entity instanceof Player _player) {
			ItemStack _setstack = flask.copy();
			_setstack.setCount(1);
			ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
		}
	}
}
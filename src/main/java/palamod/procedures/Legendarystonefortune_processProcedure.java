package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

public class Legendarystonefortune_processProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		double number = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) == 0 || entity instanceof Player _plr2 && _plr2.gameMode() == GameType.CREATIVE) {
			if (Math.random() < 0.1) {
				item = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
			} else if (Math.random() < 0.15) {
				item = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
			} else if (Math.random() < 0.25) {
				item = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
			} else if (Math.random() < 0.5) {
				item = new ItemStack(Items.DIAMOND).copy();
			} else {
				item = new ItemStack(Items.GOLD_INGOT).copy();
			}
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(PalamodModItems.LEGENDARY_STONE_FORTUNE.get()));
			if (entity instanceof Player _player) {
				ItemStack _setstack = item.copy();
				_setstack.setCount(Mth.nextInt(RandomSource.create(), 10, 64));
				_player.getInventory().placeItemBackInInventory(_setstack);
			}
			{
				final String _tagName = "name";
				final String _tagValue = (new ItemStack(PalamodModItems.LEGENDARY_STONE_FORTUNE.get()).getDisplayName().getString());
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "cooldown";
				final double _tagValue = 48000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}
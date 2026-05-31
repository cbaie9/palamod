package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class AdshoppreviewamountgoldProcedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		ItemStack item = ItemStack.EMPTY;
		double fac_v = 0;
		double n = 0;
		double n2 = 0;
		double buy = 0;
		String buy_out = "";
		fac_v = 35;
		n2 = 30;
		n = Math.round(Math.abs(parseDouble((entity instanceof Player _entity0 && _entity0.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0) ? _menu0.getMenuState(0, "number_buy", "") : "")));
		buy = n * fac_v;
		if (buy > getBlockNBTNumber(world, new BlockPos(0, 10, 0), ("money_" + entity.getDisplayName().getString()))) {
			buy_out = "{Not enough money}";
		} else {
			buy_out = "" + Math.round(buy);
		}
		if (n != 0) {
			return "Buy :" + buy_out + " / sell : " + Math.round(n2 * n);
		}
		return "Amount : insert number in the bar";
	}

	private static double parseDouble(String s) {
		try {
			return Double.parseDouble(s.trim());
		} catch (Exception e) {
			return 0;
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}
}
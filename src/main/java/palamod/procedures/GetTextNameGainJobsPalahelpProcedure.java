package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class GetTextNameGainJobsPalahelpProcedure {
	public static String execute(Entity entity, double slotNum) {
		if (entity == null)
			return "";
		ItemStack item = ItemStack.EMPTY;
		double xpGain = 0;
		item = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) slotNum).getItem() : ItemStack.EMPTY).copy();
		if ((entity.getPersistentData().getString("jobs_mode")).equals("farmer")) {
			if ((entity.getPersistentData().getString("xp_mode")).equals("grow")) {
				xpGain = GetxpfarmerbreakblockProcedure.execute(item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState(), 199);
			} else if ((entity.getPersistentData().getString("xp_mode")).equals("craft")) {
				xpGain = GetXpcraftjobsProcedure.execute(item, 199, 199, 199, 199, "craft");
			}
		} else if ((entity.getPersistentData().getString("jobs_mode")).equals("miner")) {
			if ((entity.getPersistentData().getString("xp_mode")).equals("mine")) {
				xpGain = GetxpminerbreakblockProcedure.execute(item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState(), entity, true, 199);
			} else if ((entity.getPersistentData().getString("xp_mode")).equals("smelt")) {
				xpGain = GetXpcraftjobsProcedure.execute(item, 199, 199, 199, 199, "smelt");
			}
		} else if ((entity.getPersistentData().getString("jobs_mode")).equals("hunter")) {
			if ((entity.getPersistentData().getString("xp_mode")).equals("kill")) {
				xpGain = GetXpcraftjobsentityProcedure.execute(entity, 199, 199, 199, 199);
			} else if ((entity.getPersistentData().getString("xp_mode")).equals("smelt")) {
				xpGain = GetXpcraftjobsProcedure.execute(item, 199, 199, 199, 199, "smelt");
			}
		} else if ((entity.getPersistentData().getString("jobs_mode")).equals("alchi")) {
			if ((entity.getPersistentData().getString("xp_mode")).equals("craft")) {
				xpGain = GetXpcraftjobsProcedure.execute(item, 199, 199, 199, 199, "craft");
			} else if ((entity.getPersistentData().getString("xp_mode")).equals("break")) {
				xpGain = GetxpalchibreakblockProcedure.execute(item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState(), 199);
			}
		}
		return ((item.getDisplayName().getString()).replace("]", "")).replace("[", "") + "\\n" + (Component.translatable("palamod.procedure.palahelp.jobs.gain").getString()).replace("%1", "" + Math.round(xpGain));
	}
}
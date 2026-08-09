package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;

public class GetTextNameGainJobsPalahelpProcedure {
	public static String execute(LevelAccessor world, Entity entity, double slotNum) {
		if (entity == null)
			return "";
		ItemStack item = ItemStack.EMPTY;
		double xpGain = 0;
		BlockState age_up = Blocks.AIR.defaultBlockState();
		String outputText = "";
		item = new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation
				.parse(((BuiltInRegistries.ITEM.getKey((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) slotNum).getItem() : ItemStack.EMPTY).getItem())
						.toString())).toLowerCase(java.util.Locale.ENGLISH))))
				.copy();
		if (!(Blocks.AIR.asItem() == item.getItem())) {
			if ((entity.getPersistentData().getString("jobs_mode")).equals("farmer")) {
				if ((entity.getPersistentData().getString("xp_mode")).equals("grow")) {
					age_up = (blockStateWithInt((item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()), "age", 7));
					xpGain = GetxpfarmerbreakblockProcedure.execute(age_up, 199);
				} else if ((entity.getPersistentData().getString("xp_mode")).equals("craft")) {
					xpGain = GetXpcraftjobsProcedure.execute(item, 199, 199, 199, 199, "craft");
				}
			} else if ((entity.getPersistentData().getString("jobs_mode")).equals("miner")) {
				if ((entity.getPersistentData().getString("xp_mode")).equals("mine")) {
					xpGain = GetxpminerbreakblockProcedure.execute(world, item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState(), entity, true, 199);
				} else if ((entity.getPersistentData().getString("xp_mode")).equals("smelt")) {
					xpGain = GetXpcraftjobsProcedure.execute(item, 199, 199, 199, 199, "smelt");
				}
			} else if ((entity.getPersistentData().getString("jobs_mode")).equals("hunter")) {
				if ((entity.getPersistentData().getString("xp_mode")).equals("kill")) {
					xpGain = GetXpcraftjobsentityProcedure.execute(199, 199, 199, 199, ConvertSpawnEggToEntityRegistryProcedure.execute(item));
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
			outputText = ((((item.getDisplayName().getString()).replace("]", "")).replace("[", "")).replace("Oeuf d'apparition", "")).replace("Spawn Egg", "") + "\\n"
					+ (Component.translatable("palamod.procedure.palahelp.jobs.gain").getString()).replace("%1", "" + Math.round(xpGain));
		} else {
			outputText = " ";
		}
		return outputText;
	}

	private static BlockState blockStateWithInt(BlockState blockState, String property, int newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty(property);
		return prop instanceof IntegerProperty ip && prop.getPossibleValues().contains(newValue) ? blockState.setValue(ip, newValue) : blockState;
	}
}
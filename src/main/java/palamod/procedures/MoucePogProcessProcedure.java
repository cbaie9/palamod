package palamod.procedures;

import palamod.PalamodMod;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import java.util.Calendar;

public class MoucePogProcessProcedure {
	public static void execute(Entity entity, boolean force_render) {
		if (entity == null)
			return;
		double level = 0;
		double pickaxe_stone = 0;
		double xp_needed_current = 0;
		String tooltip = "";
		if (entity.isShiftKeyDown()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("last_rendered_tooltip_time") != Calendar.getInstance()
					.get(Calendar.SECOND) || force_render) {
				pickaxe_stone = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Pickaxe_stone");
				level = Math.abs(GetLevelPotgProcedure.execute(pickaxe_stone));
				if (level == 20) {
					tooltip = "Fully upgraded - Level 20";
				} else if (level < 20 && level >= 0) {
					tooltip = "%1 Left - Level %2";
				} else {
					tooltip = "%1 - Out of range level %2";
				}
				xp_needed_current = DbgetneededBlockForPotgProcedure.execute(level + 1);
				tooltip = (tooltip.replace("%2", "" + Math.round(level))).replace("%1", "" + (xp_needed_current - pickaxe_stone));
				{
					final String _tagName = "last_rendered_tooltip";
					final String _tagValue = tooltip;
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "last_rendered_tooltip_time";
					final double _tagValue = Calendar.getInstance().get(Calendar.SECOND);
					CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
				}
				PalamodMod.LOGGER.info(("[Pickaxe of the gods tooltip renderer ]: logged tooltip ->" + tooltip));
			} else {
				tooltip = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("last_rendered_tooltip");
			}
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).set(DataComponents.CUSTOM_NAME, Component.literal(tooltip));
		} else {
			(entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).set(DataComponents.CUSTOM_NAME,
					Component.literal((((new ItemStack(BuiltInRegistries.ITEM
							.get(ResourceLocation.parse(((BuiltInRegistries.ITEM.getKey((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))))
							.getDisplayName().getString()).replace("]", "")).replace("[", ""))));
		}
	}
}
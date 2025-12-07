package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;

public class AdminshopgetitemProcedure {
	public static ItemStack execute(Entity entity) {
		if (entity == null)
			return ItemStack.EMPTY;
		ItemStack item = ItemStack.EMPTY;
		double num = 0;
		return !(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((entity.getPersistentData().getString("mode_adminshop"))).toLowerCase(java.util.Locale.ENGLISH))) == Blocks.AIR.asItem())
				? new ItemStack(BuiltInRegistries.ITEM.get(ResourceLocation.parse(((entity.getPersistentData().getString("mode_adminshop"))).toLowerCase(java.util.Locale.ENGLISH))))
				: new ItemStack(Blocks.COMMAND_BLOCK);
	}
}
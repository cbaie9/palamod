package palamod.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;

public class CanPutItemInsideFurnaceProcedure {
	public static boolean execute(LevelAccessor world, ItemStack itemstack) {
		return !(world instanceof Level _level1 && _level1.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(itemstack), _level1).isPresent());
	}
}
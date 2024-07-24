
package palamod.init;

import java.util.List;
import java.util.ArrayList;

@JeiPlugin
public class PalamodModBrewingRecipes implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("palamod:brewing_recipes");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		IVanillaRecipeFactory factory = registration.getVanillaRecipeFactory();
		List<IJeiBrewingRecipe> brewingRecipes = new ArrayList<>();
		ItemStack potion = new ItemStack(Items.POTION);
		ItemStack potion2 = new ItemStack(Items.POTION);
		List<ItemStack> ingredientStack = new ArrayList<>();
		List<ItemStack> inputStack = new ArrayList<>();
		registration.addRecipes(RecipeTypes.BREWING, brewingRecipes);
	}
}


package palamod.init;

import palamod.jei_recipes.PaladiummachinerecipetypejeiRecipeCategory;
import palamod.jei_recipes.PaladiummachinerecipetypejeiRecipe;
import palamod.jei_recipes.GrinderhighrecipetypejeiRecipeCategory;
import palamod.jei_recipes.GrinderhighrecipetypejeiRecipe;
import palamod.jei_recipes.CrusherrecipetypeRecipeCategory;
import palamod.jei_recipes.CrusherrecipetypeRecipe;

import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.Minecraft;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class PalamodModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<CrusherrecipetypeRecipe> Crusherrecipetype_Type = new mezz.jei.api.recipe.RecipeType<>(CrusherrecipetypeRecipeCategory.UID, CrusherrecipetypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<PaladiummachinerecipetypejeiRecipe> Paladiummachinerecipetypejei_Type = new mezz.jei.api.recipe.RecipeType<>(PaladiummachinerecipetypejeiRecipeCategory.UID, PaladiummachinerecipetypejeiRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<GrinderhighrecipetypejeiRecipe> Grinderhighrecipetypejei_Type = new mezz.jei.api.recipe.RecipeType<>(GrinderhighrecipetypejeiRecipeCategory.UID, GrinderhighrecipetypejeiRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("palamod:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new CrusherrecipetypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new PaladiummachinerecipetypejeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new GrinderhighrecipetypejeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		RecipeManager recipeManager = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
		List<CrusherrecipetypeRecipe> CrusherrecipetypeRecipes = recipeManager.getAllRecipesFor(CrusherrecipetypeRecipe.Type.INSTANCE);
		registration.addRecipes(Crusherrecipetype_Type, CrusherrecipetypeRecipes);
		List<PaladiummachinerecipetypejeiRecipe> PaladiummachinerecipetypejeiRecipes = recipeManager.getAllRecipesFor(PaladiummachinerecipetypejeiRecipe.Type.INSTANCE);
		registration.addRecipes(Paladiummachinerecipetypejei_Type, PaladiummachinerecipetypejeiRecipes);
		List<GrinderhighrecipetypejeiRecipe> GrinderhighrecipetypejeiRecipes = recipeManager.getAllRecipesFor(GrinderhighrecipetypejeiRecipe.Type.INSTANCE);
		registration.addRecipes(Grinderhighrecipetypejei_Type, GrinderhighrecipetypejeiRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(PalamodModBlocks.PALADIUM_CRUSHER.get().asItem()), Crusherrecipetype_Type);
		registration.addRecipeCatalyst(new ItemStack(PalamodModBlocks.PALADIUM_MACHINE.get().asItem()), Paladiummachinerecipetypejei_Type);
	}
}

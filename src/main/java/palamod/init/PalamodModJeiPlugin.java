
package palamod.init;

import palamod.jei_recipes.PaladiummachinerecipetypejeiRecipeCategory;
import palamod.jei_recipes.PaladiummachinerecipetypejeiRecipe;
import palamod.jei_recipes.GrinderlowerpartjeiRecipeCategory;
import palamod.jei_recipes.GrinderlowerpartjeiRecipe;
import palamod.jei_recipes.GrinderhighrecipetypejeiRecipeCategory;
import palamod.jei_recipes.GrinderhighrecipetypejeiRecipe;
import palamod.jei_recipes.CrusherrecipetypeRecipeCategory;
import palamod.jei_recipes.CrusherrecipetypeRecipe;

import java.util.Objects;
import java.util.List;

@JeiPlugin
public class PalamodModJeiPlugin implements IModPlugin {
	public static mezz.jei.api.recipe.RecipeType<CrusherrecipetypeRecipe> Crusherrecipetype_Type = new mezz.jei.api.recipe.RecipeType<>(CrusherrecipetypeRecipeCategory.UID, CrusherrecipetypeRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<PaladiummachinerecipetypejeiRecipe> Paladiummachinerecipetypejei_Type = new mezz.jei.api.recipe.RecipeType<>(PaladiummachinerecipetypejeiRecipeCategory.UID, PaladiummachinerecipetypejeiRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<GrinderhighrecipetypejeiRecipe> Grinderhighrecipetypejei_Type = new mezz.jei.api.recipe.RecipeType<>(GrinderhighrecipetypejeiRecipeCategory.UID, GrinderhighrecipetypejeiRecipe.class);
	public static mezz.jei.api.recipe.RecipeType<GrinderlowerpartjeiRecipe> Grinderlowerpartjei_Type = new mezz.jei.api.recipe.RecipeType<>(GrinderlowerpartjeiRecipeCategory.UID, GrinderlowerpartjeiRecipe.class);

	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("palamod:jei_plugin");
	}

	@Override
	public void registerCategories(IRecipeCategoryRegistration registration) {
		registration.addRecipeCategories(new CrusherrecipetypeRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new PaladiummachinerecipetypejeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new GrinderhighrecipetypejeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
		registration.addRecipeCategories(new GrinderlowerpartjeiRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
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
		List<GrinderlowerpartjeiRecipe> GrinderlowerpartjeiRecipes = recipeManager.getAllRecipesFor(GrinderlowerpartjeiRecipe.Type.INSTANCE);
		registration.addRecipes(Grinderlowerpartjei_Type, GrinderlowerpartjeiRecipes);
	}

	@Override
	public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
		registration.addRecipeCatalyst(new ItemStack(PalamodModBlocks.PALADIUM_CRUSHER.get().asItem()), Crusherrecipetype_Type);
		registration.addRecipeCatalyst(new ItemStack(PalamodModBlocks.PALADIUM_MACHINE.get().asItem()), Paladiummachinerecipetypejei_Type);
		registration.addRecipeCatalyst(new ItemStack(PalamodModBlocks.GRINDER_BLOCK.get().asItem()), Grinderhighrecipetypejei_Type);
		registration.addRecipeCatalyst(new ItemStack(PalamodModBlocks.GRINDER_BLOCK.get().asItem()), Grinderlowerpartjei_Type);
	}
}

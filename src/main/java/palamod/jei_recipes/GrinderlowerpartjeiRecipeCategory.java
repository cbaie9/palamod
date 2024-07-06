
package palamod.jei_recipes;

public class GrinderlowerpartjeiRecipeCategory implements IRecipeCategory<GrinderlowerpartjeiRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("palamod", "grinderlowerpartjei");
	public final static ResourceLocation TEXTURE = new ResourceLocation("palamod", "textures/screens/grinder_lower_part_jei.png");

	private final IDrawable background;
	private final IDrawable icon;

	public GrinderlowerpartjeiRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 114, 57);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(PalamodModBlocks.GRINDER_BLOCK.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<GrinderlowerpartjeiRecipe> getRecipeType() {
		return PalamodModJeiPlugin.Grinderlowerpartjei_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Grinder (modifier) ( structure )");
	}

	@Override
	public IDrawable getBackground() {
		return this.background;
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, GrinderlowerpartjeiRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 15, 17).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 76, 10).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 76, 33).addIngredients(recipe.getIngredients().get(0));
	}

}
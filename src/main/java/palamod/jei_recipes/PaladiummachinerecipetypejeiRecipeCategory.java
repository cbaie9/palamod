
package palamod.jei_recipes;

import palamod.init.PalamodModJeiPlugin;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class PaladiummachinerecipetypejeiRecipeCategory implements IRecipeCategory<PaladiummachinerecipetypejeiRecipe> {
	public final static ResourceLocation UID = new ResourceLocation("palamod", "paladiummachinerecipetypejei");
	public final static ResourceLocation TEXTURE = new ResourceLocation("palamod", "textures/screens/palamachine_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public PaladiummachinerecipetypejeiRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 175, 85);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(PalamodModBlocks.PALADIUM_MACHINE.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<PaladiummachinerecipetypejeiRecipe> getRecipeType() {
		return PalamodModJeiPlugin.Paladiummachinerecipetypejei_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Paladium Machine");
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
	public void setRecipe(IRecipeLayoutBuilder builder, PaladiummachinerecipetypejeiRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 21, 22).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 49, 40).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 76, 15).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 103, 40).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 129, 22).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 75, 58).addItemStack(recipe.getResultItem(null));
	}
}

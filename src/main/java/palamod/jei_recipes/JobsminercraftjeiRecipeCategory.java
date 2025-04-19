
package palamod.jei_recipes;

import palamod.init.PalamodModJeiPlugin;
import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.GuiGraphics;

import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.constants.VanillaTypes;

public class JobsminercraftjeiRecipeCategory implements IRecipeCategory<JobsminercraftjeiRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("palamod:jobsminercraftjei");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("palamod:textures/screens/miner_craft_jei_gui.png");
	private final IDrawable background;
	private final IDrawable icon;

	public JobsminercraftjeiRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 164, 102);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(PalamodModItems.MINERJOBSITEM.get()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<JobsminercraftjeiRecipe> getRecipeType() {
		return PalamodModJeiPlugin.Jobsminercraftjei_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Miner Crafts");
	}

	@Override
	public IDrawable getIcon() {
		return this.icon;
	}

	@Override
	public int getWidth() {
		return this.background.getWidth();
	}

	@Override
	public int getHeight() {
		return this.background.getHeight();
	}

	@Override
	public void draw(JobsminercraftjeiRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, JobsminercraftjeiRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 18).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.INPUT, 41, 18).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 59, 18).addIngredients(recipe.getIngredients().get(2));
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 36).addIngredients(recipe.getIngredients().get(3));
		builder.addSlot(RecipeIngredientRole.INPUT, 41, 36).addIngredients(recipe.getIngredients().get(4));
		builder.addSlot(RecipeIngredientRole.INPUT, 59, 36).addIngredients(recipe.getIngredients().get(5));
		builder.addSlot(RecipeIngredientRole.INPUT, 23, 54).addIngredients(recipe.getIngredients().get(6));
		builder.addSlot(RecipeIngredientRole.INPUT, 41, 54).addIngredients(recipe.getIngredients().get(7));
		builder.addSlot(RecipeIngredientRole.INPUT, 59, 54).addIngredients(recipe.getIngredients().get(8));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 118, 36).addItemStack(recipe.getResultItem(null));
	}
}

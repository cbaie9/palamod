
package palamod.jei_recipes;

import palamod.init.PalamodModJeiPlugin;
import palamod.init.PalamodModBlocks;

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

public class CrusherrecipetypeRecipeCategory implements IRecipeCategory<CrusherrecipetypeRecipe> {
	public final static ResourceLocation UID = ResourceLocation.parse("palamod:crusherrecipetype");
	public final static ResourceLocation TEXTURE = ResourceLocation.parse("palamod:textures/screens/crusher_jei.png");
	private final IDrawable background;
	private final IDrawable icon;

	public CrusherrecipetypeRecipeCategory(IGuiHelper helper) {
		this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 79);
		this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(PalamodModBlocks.PALADIUM_CRUSHER.get().asItem()));
	}

	@Override
	public mezz.jei.api.recipe.RecipeType<CrusherrecipetypeRecipe> getRecipeType() {
		return PalamodModJeiPlugin.Crusherrecipetype_Type;
	}

	@Override
	public Component getTitle() {
		return Component.literal("Crusher");
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
	public void draw(CrusherrecipetypeRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
		this.background.draw(guiGraphics);
	}

	@Override
	public void setRecipe(IRecipeLayoutBuilder builder, CrusherrecipetypeRecipe recipe, IFocusGroup focuses) {
		builder.addSlot(RecipeIngredientRole.INPUT, 22, 9).addIngredients(recipe.getIngredients().get(1));
		builder.addSlot(RecipeIngredientRole.INPUT, 22, 45).addIngredients(recipe.getIngredients().get(0));
		builder.addSlot(RecipeIngredientRole.OUTPUT, 91, 45).addItemStack(recipe.getResultItem(null));
	}
}

package palamod.jei_recipes;

import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import javax.annotation.Nullable;

public class GrinderlowerpartjeiRecipe implements Recipe<SimpleContainer> {
	private final ResourceLocation id;
	private final ItemStack output;
	private final NonNullList<Ingredient> recipeItems;

	public GrinderlowerpartjeiRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems) {
		this.id = id;
		this.output = output;
		this.recipeItems = recipeItems;
	}

	@Override
	public boolean matches(SimpleContainer pContainer, Level pLevel) {
		if (pLevel.isClientSide()) {
			return false;
		}
		return false;
		//return recipeItems.get(0).test(pContainer.getItem(1));
	}

	@Override
	public NonNullList<Ingredient> getIngredients() {
		return recipeItems;
	}

	@Override
	public ItemStack assemble(SimpleContainer pContainer, RegistryAccess access) {
		return output;
	}

	@Override
	public boolean canCraftInDimensions(int pWidth, int pHeight) {
		return true;
	}

	@Override
	public ItemStack getResultItem(RegistryAccess access) {
		return output.copy();
	}

	@Override
	public ResourceLocation getId() {
		return id;
	}

	@Override
	public RecipeType<?> getType() {
		return Type.INSTANCE;
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return Serializer.INSTANCE;
	}

	public static class Type implements RecipeType<GrinderlowerpartjeiRecipe> {
		private Type() {
		}

		public static final Type INSTANCE = new Type();
		public static final String ID = "grinderlowerpartjei";
	}

	public static class Serializer implements RecipeSerializer<GrinderlowerpartjeiRecipe> {
		public static final Serializer INSTANCE = new Serializer();
		public static final ResourceLocation ID = new ResourceLocation("palamod", "grinderlowerpartjei");

		@Override
		public GrinderlowerpartjeiRecipe fromJson(ResourceLocation pRecipeId, JsonObject pSerializedRecipe) {
			ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
			JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredients");
			NonNullList<Ingredient> inputs = NonNullList.withSize(2, Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
			}
			return new GrinderlowerpartjeiRecipe(pRecipeId, output, inputs);
		}

		@Override
		public @Nullable GrinderlowerpartjeiRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buf) {
			NonNullList<Ingredient> inputs = NonNullList.withSize(buf.readInt(), Ingredient.EMPTY);
			for (int i = 0; i < inputs.size(); i++) {
				inputs.set(i, Ingredient.fromNetwork(buf));
			}
			ItemStack output = buf.readItem();
			return new GrinderlowerpartjeiRecipe(id, output, inputs);
		}

		@Override
		public void toNetwork(FriendlyByteBuf buf, GrinderlowerpartjeiRecipe recipe) {
			buf.writeInt(recipe.getIngredients().size());
			for (Ingredient ing : recipe.getIngredients()) {
				ing.toNetwork(buf);
			}
			buf.writeItemStack(recipe.getResultItem(null), false);
		}
	}
}
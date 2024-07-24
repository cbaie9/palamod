
package palamod.init;

import java.util.List;

@JeiPlugin
public class PalamodModJeiInformation implements IModPlugin {
	@Override
	public ResourceLocation getPluginUid() {
		return new ResourceLocation("palamod:information");
	}

	@Override
	public void registerRecipes(IRecipeRegistration registration) {
		registration.addIngredientInfo(List.of(new ItemStack(PalamodModBlocks.PALADIUM_CRUSHER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.palamod.crusherinfojei"));
	}
}

package palamod.init;

import palamod.jei_recipes.PaladiummachinerecipetypejeiRecipe;
import palamod.jei_recipes.GrinderlowerpartjeiRecipe;
import palamod.jei_recipes.GrinderhighrecipetypejeiRecipe;
import palamod.jei_recipes.CrusherrecipetypeRecipe;

import palamod.PalamodMod;

@Mod.EventBusSubscriber(modid = PalamodMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PalamodModRecipeTypes {
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, "palamod");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		event.enqueueWork(() -> {
			SERIALIZERS.register(bus);
			SERIALIZERS.register("crusherrecipetype", () -> CrusherrecipetypeRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("paladiummachinerecipetypejei", () -> PaladiummachinerecipetypejeiRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("grinderhighrecipetypejei", () -> GrinderhighrecipetypejeiRecipe.Serializer.INSTANCE);
			SERIALIZERS.register("grinderlowerpartjei", () -> GrinderlowerpartjeiRecipe.Serializer.INSTANCE);
		});
	}
}

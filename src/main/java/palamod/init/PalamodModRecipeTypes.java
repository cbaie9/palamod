package palamod.init;

import palamod.jei_recipes.PaladiummachinerecipetypejeiRecipe;
import palamod.jei_recipes.JobsminercraftjeiRecipe;
import palamod.jei_recipes.GrinderhighrecipetypejeiRecipe;
import palamod.jei_recipes.CrusherrecipetypeRecipe;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.fml.event.lifecycle.FMLConstructModEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.ModList;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.core.registries.BuiltInRegistries;

@EventBusSubscriber(modid = PalamodMod.MODID, bus = EventBusSubscriber.Bus.MOD)
public class PalamodModRecipeTypes {
	public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(BuiltInRegistries.RECIPE_TYPE, "palamod");
	public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(BuiltInRegistries.RECIPE_SERIALIZER, "palamod");

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		IEventBus bus = ModList.get().getModContainerById("palamod").get().getEventBus();
		event.enqueueWork(() -> {
			RECIPE_TYPES.register(bus);
			SERIALIZERS.register(bus);
			RECIPE_TYPES.register("crusherrecipetype", () -> CrusherrecipetypeRecipe.Type.INSTANCE);
			SERIALIZERS.register("crusherrecipetype", () -> CrusherrecipetypeRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("paladiummachinerecipetypejei", () -> PaladiummachinerecipetypejeiRecipe.Type.INSTANCE);
			SERIALIZERS.register("paladiummachinerecipetypejei", () -> PaladiummachinerecipetypejeiRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("grinderhighrecipetypejei", () -> GrinderhighrecipetypejeiRecipe.Type.INSTANCE);
			SERIALIZERS.register("grinderhighrecipetypejei", () -> GrinderhighrecipetypejeiRecipe.Serializer.INSTANCE);
			RECIPE_TYPES.register("jobsminercraftjei", () -> JobsminercraftjeiRecipe.Type.INSTANCE);
			SERIALIZERS.register("jobsminercraftjei", () -> JobsminercraftjeiRecipe.Serializer.INSTANCE);
		});
	}
}

package palamod.init;

import palamod.jei_recipes.PaladiummachinerecipetypejeiRecipe;
import palamod.jei_recipes.CrusherrecipetypeRecipe;

import palamod.PalamodMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;

import net.minecraft.world.item.crafting.RecipeSerializer;

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
		});
	}
}

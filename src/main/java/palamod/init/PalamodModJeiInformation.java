
package palamod.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.IModPlugin;

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
		registration.addIngredientInfo(List.of(new ItemStack(PalamodModBlocks.PALADIUM_MACHINE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.palamod.palamachineinfojei"));
		registration.addIngredientInfo(List.of(new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_1.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_2.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_3.get()),
				new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_4.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_5.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_6.get()),
				new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_7.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_8.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_9.get()),
				new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_10.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_11.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_12.get()),
				new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_14.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_15.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_16.get()),
				new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_17.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_18.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_19.get()),
				new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_20.get()), new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_13.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.palamod.pickaxeofthegodsgen"));
		registration.addIngredientInfo(List.of(new ItemStack(PalamodModBlocks.COBBLEBREAKER.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.palamod.cobblebreakerjeiinfo"));
		registration.addIngredientInfo(List.of(new ItemStack(PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.palamod.cobbblebreakerupgradeamethystjeiinfo"));
		registration.addIngredientInfo(List.of(new ItemStack(PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.palamod.cobblebreakertitaneupgradejeiinfo"));
		registration.addIngredientInfo(List.of(new ItemStack(PalamodModItems.COBBLEBREAKER_PALADIUM_UPGRADE.get())), VanillaTypes.ITEM_STACK, Component.translatable("jei.palamod.cobblebreakerpaladiumupgradejeiinfo"));
		registration.addIngredientInfo(
				List.of(new ItemStack(PalamodModBlocks.GRINDER_CASING.get()), new ItemStack(PalamodModBlocks.GRINDER_FRAME.get()), new ItemStack(PalamodModBlocks.GRINDER_BLOCK.get()), new ItemStack(PalamodModBlocks.TCV_2.get())),
				VanillaTypes.ITEM_STACK, Component.translatable("jei.palamod.grinderjeiinfo"));
	}
}

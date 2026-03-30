package palamod.client.renderer.item;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.EquipmentClientInfo;

@EventBusSubscriber(Dist.CLIENT)
public class Paladiumarmorcustom2Armor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_c2_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_2_HELMET.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM2_HELMET.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_c2_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_2_CHESTPLATE.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM2_CHESTPLATE.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_c2_layer_2.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_2_LEGGINGS.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM2_LEGGINGS.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_c2_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_2_BOOTS.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM2_BOOTS.get());
>>>>>>> Stashed changes
	}
}
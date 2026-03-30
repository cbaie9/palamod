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
public class Paladiumarmorcustom7Armor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_custom_7_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_7_HELMET.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM7_HELMET.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_custom_7_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_7_CHESTPLATE.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM7_CHESTPLATE.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_custom_7_layer_2.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_7_LEGGINGS.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM7_LEGGINGS.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_custom_7_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_7_BOOTS.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM7_BOOTS.get());
>>>>>>> Stashed changes
	}
}
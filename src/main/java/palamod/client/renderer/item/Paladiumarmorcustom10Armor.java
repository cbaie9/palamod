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
public class Paladiumarmorcustom10Armor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_custom_10_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_10_HELMET.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM10_HELMET.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_custom_10_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_10_CHESTPLATE.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM10_CHESTPLATE.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_custom_10_layer_2.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_10_LEGGINGS.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM10_LEGGINGS.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/paladium_custom_10_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PALADIUMARMORCUSTOM_10_BOOTS.get());
=======
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM10_BOOTS.get());
>>>>>>> Stashed changes
	}
}
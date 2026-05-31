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
public class Paladiumarmorcustom1Armor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			private final ResourceLocation armorTexture = ResourceLocation.parse("palamod:textures/models/armor/paladium_c_layer_1.png");

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation original) {
				return armorTexture;
			}
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM1_HELMET.get());
		event.registerItem(new IClientItemExtensions() {
			private final ResourceLocation armorTexture = ResourceLocation.parse("palamod:textures/models/armor/paladium_c_layer_1.png");

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation original) {
				return armorTexture;
			}
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM1_CHESTPLATE.get());
		event.registerItem(new IClientItemExtensions() {
			private final ResourceLocation armorTexture = ResourceLocation.parse("palamod:textures/models/armor/paladium_c_layer_2.png");

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation original) {
				return armorTexture;
			}
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM1_LEGGINGS.get());
		event.registerItem(new IClientItemExtensions() {
			private final ResourceLocation armorTexture = ResourceLocation.parse("palamod:textures/models/armor/paladium_c_layer_1.png");

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation original) {
				return armorTexture;
			}
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM1_BOOTS.get());
	}
}
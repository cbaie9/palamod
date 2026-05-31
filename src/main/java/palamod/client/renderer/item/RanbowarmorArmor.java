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
public class RanbowarmorArmor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			private final ResourceLocation armorTexture = ResourceLocation.parse("palamod:textures/models/armor/ranbow_armor__layer_1.png");

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation original) {
				return armorTexture;
			}
		}, PalamodModItems.RAINBOWARMOR_HELMET.get());
		event.registerItem(new IClientItemExtensions() {
			private final ResourceLocation armorTexture = ResourceLocation.parse("palamod:textures/models/armor/ranbow_armor__layer_1.png");

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation original) {
				return armorTexture;
			}
		}, PalamodModItems.RAINBOWARMOR_CHESTPLATE.get());
		event.registerItem(new IClientItemExtensions() {
			private final ResourceLocation armorTexture = ResourceLocation.parse("palamod:textures/models/armor/ranbow_armor__layer_2.png");

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation original) {
				return armorTexture;
			}
		}, PalamodModItems.RAINBOWARMOR_LEGGINGS.get());
		event.registerItem(new IClientItemExtensions() {
			private final ResourceLocation armorTexture = ResourceLocation.parse("palamod:textures/models/armor/ranbow_armor__layer_1.png");

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation original) {
				return armorTexture;
			}
		}, PalamodModItems.RAINBOWARMOR_BOOTS.get());
	}
}
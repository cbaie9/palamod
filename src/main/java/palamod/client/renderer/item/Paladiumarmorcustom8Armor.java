package palamod.client.renderer.item;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.Identifier;
import net.minecraft.client.resources.model.EquipmentClientInfo;

@EventBusSubscriber(Dist.CLIENT)
public class Paladiumarmorcustom8Armor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			private final Identifier armorTexture = Identifier.parse("palamod:textures/models/armor/paladium_custom_8_layer_1.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM8_HELMET.get());
		event.registerItem(new IClientItemExtensions() {
			private final Identifier armorTexture = Identifier.parse("palamod:textures/models/armor/paladium_custom_8_layer_1.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM8_CHESTPLATE.get());
		event.registerItem(new IClientItemExtensions() {
			private final Identifier armorTexture = Identifier.parse("palamod:textures/models/armor/paladium_custom_8_layer_2.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM8_LEGGINGS.get());
		event.registerItem(new IClientItemExtensions() {
			private final Identifier armorTexture = Identifier.parse("palamod:textures/models/armor/paladium_custom_8_layer_1.png");

			@Override
			public Identifier getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, Identifier original) {
				return armorTexture;
			}
		}, PalamodModItems.PALADIUM_ARMOR_CUSTOM8_BOOTS.get());
	}
}
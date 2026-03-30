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
public class PigarmorArmor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/pig_armor_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PIGARMOR_HELMET.get());
=======
		}, PalamodModItems.PIG_ARMOR_HELMET.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/pig_armor_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PIGARMOR_CHESTPLATE.get());
=======
		}, PalamodModItems.PIG_ARMOR_CHESTPLATE.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/pig_armor_layer_2.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PIGARMOR_LEGGINGS.get());
=======
		}, PalamodModItems.PIG_ARMOR_LEGGINGS.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/pig_armor_layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.PIGARMOR_BOOTS.get());
=======
		}, PalamodModItems.PIG_ARMOR_BOOTS.get());
>>>>>>> Stashed changes
	}
}
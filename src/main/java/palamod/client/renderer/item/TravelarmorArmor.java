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
public class TravelarmorArmor {
	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/travel2__layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.TRAVELARMOR_HELMET.get());
=======
		}, PalamodModItems.TRAVEL_ARMOR_HELMET.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/travel2__layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.TRAVELARMOR_CHESTPLATE.get());
=======
		}, PalamodModItems.TRAVEL_ARMOR_CHESTPLATE.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/travel2__layer_2.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.TRAVELARMOR_LEGGINGS.get());
=======
		}, PalamodModItems.TRAVEL_ARMOR_LEGGINGS.get());
>>>>>>> Stashed changes
		event.registerItem(new IClientItemExtensions() {
			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("palamod:textures/models/armor/travel2__layer_1.png");
			}
<<<<<<< Updated upstream
		}, PalamodModItems.TRAVELARMOR_BOOTS.get());
=======
		}, PalamodModItems.TRAVEL_ARMOR_BOOTS.get());
>>>>>>> Stashed changes
	}
}
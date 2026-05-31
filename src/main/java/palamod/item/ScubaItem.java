package palamod.item;

import palamod.procedures.ScubaHelmetTickEventProcedure;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;

import javax.annotation.Nullable;

import java.util.Map;

public abstract class ScubaItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(13, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 1, ArmorType.BODY, 6), 9,
			BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), 1f, 0f, TagKey.create(Registries.ITEM, Identifier.parse("palamod:scuba_repair_items")), ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.parse("palamod:scuba")));

	private ScubaItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends ScubaItem {
		public Helmet(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				ScubaHelmetTickEventProcedure.execute(entity);
			}
		}
	}
}
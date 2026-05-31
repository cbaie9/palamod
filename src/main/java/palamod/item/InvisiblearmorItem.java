package palamod.item;

import palamod.procedures.PaladiumArmorLeggingsTickEventProcedure;
import palamod.procedures.PaladiumArmorHelmetTickEventProcedure;
import palamod.procedures.PaladiumArmorBootsTickEventProcedure;
import palamod.procedures.PaladiumArmorBodyTickEventProcedure;

import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

import java.util.Map;

public abstract class InvisiblearmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(260, Map.of(ArmorType.BOOTS, 7, ArmorType.LEGGINGS, 8, ArmorType.CHESTPLATE, 8, ArmorType.HELMET, 7, ArmorType.BODY, 8), 55,
			DeferredHolder.create(Registries.SOUND_EVENT, Identifier.parse("item.armor.equip_diamond")), 3.5f, 0.15f, TagKey.create(Registries.ITEM, Identifier.parse("palamod:invisible_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.parse("palamod:invisible_armor")));

	private InvisiblearmorItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends InvisiblearmorItem {
		public Helmet(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				PaladiumArmorHelmetTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Chestplate extends InvisiblearmorItem {
		public Chestplate(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				PaladiumArmorBodyTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Leggings extends InvisiblearmorItem {
		public Leggings(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				PaladiumArmorLeggingsTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Boots extends InvisiblearmorItem {
		public Boots(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				PaladiumArmorBootsTickEventProcedure.execute(entity);
			}
		}
	}
}
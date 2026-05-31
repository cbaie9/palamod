package palamod.item;

import palamod.procedures.MixedendiumarmorLeggingsTickEventProcedure;
import palamod.procedures.MixedendiumarmorHelmetTickEventProcedure;
import palamod.procedures.MixedendiumarmorChestplateTickEventProcedure;
import palamod.procedures.MixedendiumarmorBootsTickEventProcedure;

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

public abstract class MixedendiumarmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(350, Map.of(ArmorType.BOOTS, 4, ArmorType.LEGGINGS, 6, ArmorType.CHESTPLATE, 7, ArmorType.HELMET, 5, ArmorType.BODY, 7), 65,
			DeferredHolder.create(Registries.SOUND_EVENT, Identifier.parse("item.armor.equip_diamond")), 4.5f, 0.25f, TagKey.create(Registries.ITEM, Identifier.parse("palamod:mixed_endium_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.parse("palamod:mixed_endium_armor")));

	private MixedendiumarmorItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends MixedendiumarmorItem {
		public Helmet(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				MixedendiumarmorHelmetTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Chestplate extends MixedendiumarmorItem {
		public Chestplate(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				MixedendiumarmorChestplateTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Leggings extends MixedendiumarmorItem {
		public Leggings(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				MixedendiumarmorLeggingsTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Boots extends MixedendiumarmorItem {
		public Boots(Item.Properties properties) {
			super(properties.humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				MixedendiumarmorBootsTickEventProcedure.execute(entity);
			}
		}
	}
}
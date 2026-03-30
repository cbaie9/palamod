package palamod.item;

import palamod.procedures.FullendiuminvisibleProcedure;

<<<<<<< Updated upstream
=======
import palamod.PalamodMod;

>>>>>>> Stashed changes
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
<<<<<<< Updated upstream
=======
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
>>>>>>> Stashed changes
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
<<<<<<< Updated upstream
=======
import net.minecraft.network.chat.Component;
>>>>>>> Stashed changes
import net.minecraft.core.registries.Registries;

import javax.annotation.Nullable;

<<<<<<< Updated upstream
=======
import java.util.function.Consumer;
>>>>>>> Stashed changes
import java.util.Map;

public abstract class EndiumArmorItem extends Item {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(400, Map.of(ArmorType.BOOTS, 10, ArmorType.LEGGINGS, 6, ArmorType.CHESTPLATE, 12, ArmorType.HELMET, 10, ArmorType.BODY, 12), 70,
			DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_netherite")), 5f, 0.3f, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:endium_armor_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("palamod:endium_armor")));

	private EndiumArmorItem(Item.Properties properties) {
		super(properties);
	}

	public static class Helmet extends EndiumArmorItem {
		public Helmet(Item.Properties properties) {
			super(properties.fireResistant().humanoidArmor(ARMOR_MATERIAL, ArmorType.HELMET));
		}

		@Override
<<<<<<< Updated upstream
=======
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
			Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PalamodMod.clientPlayer();
			String hoverText = CraftableToolTipTextProcedure.execute(itemstack);
			if (hoverText != null) {
				for (String line : hoverText.split("\n")) {
					componentConsumer.accept(Component.literal(line));
				}
			}
		}

		@Override
>>>>>>> Stashed changes
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				FullendiuminvisibleProcedure.execute(entity);
			}
		}
	}

	public static class Chestplate extends EndiumArmorItem {
		public Chestplate(Item.Properties properties) {
			super(properties.fireResistant().humanoidArmor(ARMOR_MATERIAL, ArmorType.CHESTPLATE));
		}

		@Override
<<<<<<< Updated upstream
=======
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
			Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PalamodMod.clientPlayer();
			String hoverText = CraftableToolTipTextProcedure.execute(itemstack);
			if (hoverText != null) {
				for (String line : hoverText.split("\n")) {
					componentConsumer.accept(Component.literal(line));
				}
			}
		}

		@Override
>>>>>>> Stashed changes
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				FullendiuminvisibleProcedure.execute(entity);
			}
		}
	}

	public static class Leggings extends EndiumArmorItem {
		public Leggings(Item.Properties properties) {
			super(properties.fireResistant().humanoidArmor(ARMOR_MATERIAL, ArmorType.LEGGINGS));
		}

		@Override
<<<<<<< Updated upstream
=======
		public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
			super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
			Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PalamodMod.clientPlayer();
			String hoverText = CraftableToolTipTextProcedure.execute(itemstack);
			if (hoverText != null) {
				for (String line : hoverText.split("\n")) {
					componentConsumer.accept(Component.literal(line));
				}
			}
		}

		@Override
>>>>>>> Stashed changes
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				FullendiuminvisibleProcedure.execute(entity);
			}
		}
	}

	public static class Boots extends EndiumArmorItem {
		public Boots(Item.Properties properties) {
			super(properties.fireResistant().humanoidArmor(ARMOR_MATERIAL, ArmorType.BOOTS));
		}

		@Override
		public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
			super.inventoryTick(itemstack, world, entity, equipmentSlot);
			if (entity instanceof Player player && (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR)) {
				FullendiuminvisibleProcedure.execute(entity);
			}
		}
	}
}
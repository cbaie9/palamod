package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.commands.CommandSourceStack;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class CustomswapprocessProcedure {
	public static void execute(CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:paladiumarmorstag")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:paladiumarmorstag")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:paladiumarmorstag")))
				&& (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:paladiumarmorstag")))) {
			if (DoubleArgumentType.getDouble(arguments, "number_swap") == 0) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 1) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM1_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM1_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM1_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM1_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 2) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM2_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM2_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM2_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM2_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 3) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM3_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM3_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM3_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM3_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 4) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM4_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM4_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM4_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM4_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 5) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM5_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM5_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM5_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM5_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 6) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM6_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM6_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM6_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM6_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 7) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM7_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM7_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM7_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM7_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 8) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM8_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM8_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM8_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM8_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 9) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM9_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM9_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM9_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM9_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 10) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM10_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM10_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM10_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUM_ARMOR_CUSTOM10_BOOTS.get()));
				}
			}
		}
	}
}
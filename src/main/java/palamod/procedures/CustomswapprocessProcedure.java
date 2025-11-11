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
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_1_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_1_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_1_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_1_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 2) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_2_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_2_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_2_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_2_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 3) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_3_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_3_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_3_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_3_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 4) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_4_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_4_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_4_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_4_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 5) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_5_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_5_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_5_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_5_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 6) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_6_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_6_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_6_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_6_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 7) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_7_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_7_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_7_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_7_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 8) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_8_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_8_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_8_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_8_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 9) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_9_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_9_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_9_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_9_BOOTS.get()));
				}
			} else if (DoubleArgumentType.getDouble(arguments, "number_swap") == 10) {
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_10_HELMET.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_10_CHESTPLATE.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.LEGS, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_10_LEGGINGS.get()));
				}
				if (entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.FEET, new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_10_BOOTS.get()));
				}
			}
		}
	}
}
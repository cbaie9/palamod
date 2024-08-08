
package palamod.item;

import java.util.function.Consumer;
import net.minecraft.client.model.Model;

public abstract class PaladiumArmorItem extends ArmorItem {

	public PaladiumArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 260;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{7, 8, 8, 7}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 55;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.PALADIUM_INGOT.get()));
			}

			@Override
			public String getName() {
				return "paladium_armor";
			}

			@Override
			public float getToughness() {
				return 3.5f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.15f;
			}
		}, type, properties);
	}

	public static class Helmet extends PaladiumArmorItem {

		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/paladium_cla_layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				PaladiumArmorHelmetTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Chestplate extends PaladiumArmorItem {

		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/paladium_cla_layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				PaladiumArmorBodyTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Leggings extends PaladiumArmorItem {

		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/paladium_cla_layer_2.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				PaladiumArmorLeggingsTickEventProcedure.execute(entity);
			}
		}
	}

	public static class Boots extends PaladiumArmorItem {

		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/paladium_cla_layer_1.png";
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				PaladiumArmorBootsTickEventProcedure.execute(entity);
			}
		}
	}

}

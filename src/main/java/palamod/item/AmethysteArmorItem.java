
package palamod.item;

import java.util.function.Consumer;
import net.minecraft.client.model.Model;

public abstract class AmethysteArmorItem extends ArmorItem {

	public AmethysteArmorItem(ArmorItem.Type type, Item.Properties properties) {
		super(new ArmorMaterial() {
			@Override
			public int getDurabilityForType(ArmorItem.Type type) {
				return new int[]{13, 15, 16, 11}[type.getSlot().getIndex()] * 170;
			}

			@Override
			public int getDefenseForType(ArmorItem.Type type) {
				return new int[]{5, 4, 6, 5}[type.getSlot().getIndex()];
			}

			@Override
			public int getEnchantmentValue() {
				return 30;
			}

			@Override
			public SoundEvent getEquipSound() {
				return SoundEvents.EMPTY;
			}

			@Override
			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.AMETHYST.get()));
			}

			@Override
			public String getName() {
				return "amethyst_armor";
			}

			@Override
			public float getToughness() {
				return 3f;
			}

			@Override
			public float getKnockbackResistance() {
				return 0.1f;
			}
		}, type, properties);
	}

	public static class Helmet extends AmethysteArmorItem {

		public Helmet() {
			super(ArmorItem.Type.HELMET, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/amethyst_.png_layer_1.png";
		}

	}

	public static class Chestplate extends AmethysteArmorItem {

		public Chestplate() {
			super(ArmorItem.Type.CHESTPLATE, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/amethyst_.png_layer_1.png";
		}

	}

	public static class Leggings extends AmethysteArmorItem {

		public Leggings() {
			super(ArmorItem.Type.LEGGINGS, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/amethyst_.png_layer_2.png";
		}

	}

	public static class Boots extends AmethysteArmorItem {

		public Boots() {
			super(ArmorItem.Type.BOOTS, new Item.Properties());
		}

		@Override
		public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
			return "palamod:textures/models/armor/amethyst_.png_layer_1.png";
		}

	}

}

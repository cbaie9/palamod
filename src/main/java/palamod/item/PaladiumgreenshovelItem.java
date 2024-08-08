
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class PaladiumgreenshovelItem extends ShovelItem {
	public PaladiumgreenshovelItem() {
		super(new Tier() {
			public int getUses() {
				return 4999;
			}

			public float getSpeed() {
				return 36f;
			}

			public float getAttackDamageBonus() {
				return 3f;
			}

			public int getLevel() {
				return 6;
			}

			public int getEnchantmentValue() {
				return 14;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.PALADIUM_INGOT.get()));
			}
		}, 1, -3.5f, new Item.Properties());
	}
}

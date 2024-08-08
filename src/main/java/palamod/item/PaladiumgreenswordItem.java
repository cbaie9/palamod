
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class PaladiumgreenswordItem extends SwordItem {
	public PaladiumgreenswordItem() {
		super(new Tier() {
			public int getUses() {
				return 4999;
			}

			public float getSpeed() {
				return 0.5f;
			}

			public float getAttackDamageBonus() {
				return 4f;
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
		}, 3, -2f, new Item.Properties());
	}
}

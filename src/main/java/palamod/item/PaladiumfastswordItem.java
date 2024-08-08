
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class PaladiumfastswordItem extends SwordItem {
	public PaladiumfastswordItem() {
		super(new Tier() {
			public int getUses() {
				return 1000;
			}

			public float getSpeed() {
				return 16f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 5;
			}

			public int getEnchantmentValue() {
				return 0;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.PALADIUM_INGOT.get()));
			}
		}, 3, 16f, new Item.Properties());
	}
}

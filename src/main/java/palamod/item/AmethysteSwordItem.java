
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class AmethysteSwordItem extends SwordItem {
	public AmethysteSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 2999;
			}

			public float getSpeed() {
				return 14f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 56;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.AMETHYST.get()));
			}
		}, 3, -3f, new Item.Properties());
	}
}

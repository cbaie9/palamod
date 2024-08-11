
package palamod.item;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class TitanePickaxeItem extends PickaxeItem {
	public TitanePickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 2999;
			}

			public float getSpeed() {
				return 16f;
			}

			public float getAttackDamageBonus() {
				return 3.5f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 25;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.TITANE_INGOT.get()));
			}
		}, 1, -3f, new Item.Properties());
	}
}

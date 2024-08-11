
package palamod.item;

import palamod.init.PalamodModItems;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class PaladiumPickaxeItem extends PickaxeItem {
	public PaladiumPickaxeItem() {
		super(new Tier() {
			public int getUses() {
				return 4999;
			}

			public float getSpeed() {
				return 30f;
			}

			public float getAttackDamageBonus() {
				return 4.5f;
			}

			public int getLevel() {
				return 4;
			}

			public int getEnchantmentValue() {
				return 10;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(new ItemStack(PalamodModItems.PALADIUM_INGOT.get()));
			}
		}, 1, -2.5f, new Item.Properties());
	}
}

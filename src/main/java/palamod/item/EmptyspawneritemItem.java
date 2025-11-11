package palamod.item;

import palamod.procedures.GetcustomunixProcedure;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class EmptyspawneritemItem extends Item {
	public EmptyspawneritemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(1));
	}

	public record SoulsProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<SoulsProperty> MAP_CODEC = MapCodec.unit(new SoulsProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) GetcustomunixProcedure.execute();
		}

		@Override
		public MapCodec<SoulsProperty> type() {
			return MAP_CODEC;
		}
	}
}
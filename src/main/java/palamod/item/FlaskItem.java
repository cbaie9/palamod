package palamod.item;

import palamod.procedures.TooptipflaskrenderProcedure;
import palamod.procedures.FlaskPropertyValueProvider_type_of_woodProcedure;
import palamod.procedures.FlaskPropertyValueProviderProcedure;

import palamod.PalamodMod;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;

import java.util.function.Consumer;

import com.mojang.serialization.MapCodec;

public class FlaskItem extends Item {
	public FlaskItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PalamodMod.clientPlayer();
		String hoverText = TooptipflaskrenderProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				componentConsumer.accept(Component.literal(line));
			}
		}
	}

	public record SeveProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<SeveProperty> MAP_CODEC = MapCodec.unit(new SeveProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) FlaskPropertyValueProviderProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<SeveProperty> type() {
			return MAP_CODEC;
		}
	}

	public record TypeProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<TypeProperty> MAP_CODEC = MapCodec.unit(new TypeProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) FlaskPropertyValueProvider_type_of_woodProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<TypeProperty> type() {
			return MAP_CODEC;
		}
	}
}
package palamod.item;

import palamod.procedures.TankitemtooltipProcedure;
import palamod.procedures.TankitemPropertyValueProviderProcedure;
import palamod.procedures.TankItemPlaceProcedure;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class TankitemItem extends Item {
	public TankitemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(1));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		TankItemPlaceProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		TankitemtooltipProcedure.execute(itemstack);
	}

	public record TankTypeProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<TankTypeProperty> MAP_CODEC = MapCodec.unit(new TankTypeProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) TankitemPropertyValueProviderProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<TankTypeProperty> type() {
			return MAP_CODEC;
		}
	}
}
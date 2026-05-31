package palamod.item;

import palamod.procedures.XpbottleprocessProcedure;
import palamod.procedures.GetxpfrombottleProcedure;
import palamod.procedures.GetjobsfrombottleProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ItemOwner;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;

public class XpbottleItem extends Item {
	public XpbottleItem(Item.Properties properties) {
		super(properties.durability(1));
	}

	@Override
	public InteractionResult use(Level world, Player entity, InteractionHand hand) {
		InteractionResult ar = super.use(world, entity, hand);
		XpbottleprocessProcedure.execute(world, entity.getX(), entity.getY(), entity.getZ(), entity, entity.getItemInHand(hand));
		return ar;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		XpbottleprocessProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}

	public record XpProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<XpProperty> MAP_CODEC = MapCodec.unit(new XpProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) GetxpfrombottleProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<XpProperty> type() {
			return MAP_CODEC;
		}
	}

	public record JobsTypeProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<JobsTypeProperty> MAP_CODEC = MapCodec.unit(new JobsTypeProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable ItemOwner owner, int seed) {
			return (float) GetjobsfrombottleProcedure.execute(itemStackToRender);
		}

		@Override
		public MapCodec<JobsTypeProperty> type() {
			return MAP_CODEC;
		}
	}
}
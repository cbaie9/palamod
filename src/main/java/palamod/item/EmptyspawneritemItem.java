package palamod.item;

import palamod.procedures.GetcustomunixProcedure;

<<<<<<< Updated upstream
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;

import com.mojang.serialization.MapCodec;
=======
import palamod.PalamodMod;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;
>>>>>>> Stashed changes

public class EmptyspawneritemItem extends Item {
	public EmptyspawneritemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.UNCOMMON).stacksTo(1));
	}

<<<<<<< Updated upstream
	public record SoulsProperty() implements RangeSelectItemModelProperty {
		public static final MapCodec<SoulsProperty> MAP_CODEC = MapCodec.unit(new SoulsProperty());

		@Override
		public float get(ItemStack itemStackToRender, @Nullable ClientLevel clientWorld, @Nullable LivingEntity entity, int seed) {
			return (float) GetcustomunixProcedure.execute();
		}

		@Override
		public MapCodec<SoulsProperty> type() {
			return MAP_CODEC;
=======
	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PalamodMod.clientPlayer();
		String hoverText = GettooptipcavernhammerProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				componentConsumer.accept(Component.literal(line));
			}
>>>>>>> Stashed changes
		}
	}
}
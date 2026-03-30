package palamod.item;

import palamod.procedures.BighoeprocessProcedure;

<<<<<<< Updated upstream
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
=======
import palamod.PalamodMod;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.entity.Entity;
>>>>>>> Stashed changes
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
<<<<<<< Updated upstream
import net.minecraft.core.registries.Registries;

public class TitanehoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 4000, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:titanehoe_repair_items")));

	public TitanehoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -3f, properties);
=======
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import java.util.function.Consumer;

public class TitanehoeItem extends HoeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_DIAMOND_TOOL, 4000, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:titane_hoe_repair_items")));

	public TitanehoeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 3f, -3f, properties);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		Entity entity = itemstack.getEntityRepresentation() != null ? itemstack.getEntityRepresentation() : PalamodMod.clientPlayer();
		String hoverText = CraftableToolTipTextProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				componentConsumer.accept(Component.literal(line));
			}
		}
>>>>>>> Stashed changes
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		BighoeprocessProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer(), context.getItemInHand());
		return InteractionResult.SUCCESS;
	}
}
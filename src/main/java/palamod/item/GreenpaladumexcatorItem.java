package palamod.item;

import palamod.procedures.ExcavatorprocessamethystProcedure;
<<<<<<< Updated upstream

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
=======
import palamod.procedures.CraftableToolTipTextProcedure;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
>>>>>>> Stashed changes
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
<<<<<<< Updated upstream
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class GreenpaladumexcatorItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 18f, 0, 23, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:greenpaladumexcator_repair_items")));
=======
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import java.util.function.Consumer;

public class GreenpaladumexcatorItem extends ShovelItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 18f, 0, 23, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:green_paladum_excavator_repair_items")));
>>>>>>> Stashed changes

	public GreenpaladumexcatorItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 2f, -3.1f, properties);
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
		ExcavatorprocessamethystProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return retval;
	}
<<<<<<< Updated upstream
=======

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
	}
>>>>>>> Stashed changes
}
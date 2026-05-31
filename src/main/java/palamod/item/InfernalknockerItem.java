package palamod.item;

import palamod.procedures.Infernalknocker_aknoProcedure;
import palamod.procedures.CraftableToolTipTextProcedure;

import palamod.PalamodMod;

import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import java.util.function.Consumer;

public class InfernalknockerItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 59, 4f, 0, 1, TagKey.create(Registries.ITEM, Identifier.parse("palamod:infernal_knocker_repair_items")));

	public InfernalknockerItem(Item.Properties properties) {
		super(properties.sword(TOOL_MATERIAL, 3f, -2f).setNoCombineRepair());
	}

	@Override
	public ItemStackTemplate getCraftingRemainder(ItemInstance itemInstance) {
		return new ItemStackTemplate(this);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Item.TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> componentConsumer, TooltipFlag flag) {
		super.appendHoverText(itemstack, context, tooltipDisplay, componentConsumer, flag);
		Entity entity = PalamodMod.clientPlayer();
		String hoverText = CraftableToolTipTextProcedure.execute(itemstack);
		if (hoverText != null) {
			for (String line : hoverText.split("\n")) {
				componentConsumer.accept(Component.literal(line));
			}
		}
	}

	@Override
	public void onCraftedBy(ItemStack itemstack, Player entity) {
		super.onCraftedBy(itemstack, entity);
		Infernalknocker_aknoProcedure.execute(entity.level(), itemstack);
	}
}
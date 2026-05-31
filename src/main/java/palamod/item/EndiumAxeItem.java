package palamod.item;

import palamod.procedures.CraftableToolTipTextProcedure;
import palamod.procedures.AxebreakblockProcedure;

import palamod.init.PalamodModItems;

import palamod.PalamodMod;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import java.util.function.Consumer;

@EventBusSubscriber
public class EndiumAxeItem extends AxeItem {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 0, 50f, 0, 50, TagKey.create(Registries.ITEM, Identifier.parse("palamod:endium_axe_repair_items")));

	public EndiumAxeItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 8f, -3f, properties.fireResistant());
	}

	@SubscribeEvent
	public static void modifyDefaultComponents(ModifyDefaultComponentsEvent event) {
		event.modify(PalamodModItems.ENDIUM_AXE.get(), (builder, _, _) -> builder.set(DataComponents.MAX_DAMAGE, null));
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
		AxebreakblockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
		return retval;
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
}
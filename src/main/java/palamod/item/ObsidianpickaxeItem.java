package palamod.item;

import palamod.procedures.ObsidianpickaxeprocessProcedure;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;

@EventBusSubscriber
public class ObsidianpickaxeItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 0, 4f, 0, 2, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:obsidianpickaxe_repair_items")));

	public ObsidianpickaxeItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 3f, -3f));
	}

	@SubscribeEvent
	public static void handleToolDamage(ModifyDefaultComponentsEvent event) {
		event.modify(PalamodModItems.OBSIDIANPICKAXE.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		ObsidianpickaxeprocessProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
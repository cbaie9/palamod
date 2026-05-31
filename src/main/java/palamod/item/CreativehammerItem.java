package palamod.item;

import palamod.procedures.SmeltplusProcedure;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.event.ModifyDefaultComponentsEvent;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.ItemAbilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.InteractionResult;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

@EventBusSubscriber
public class CreativehammerItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 0, 99999f, 0, 999, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:creative_hammer_repair_items")));

	public CreativehammerItem(Item.Properties properties) {
		super(TOOL_MATERIAL.applyToolProperties(properties, BlockTags.MINEABLE_WITH_PICKAXE, -1f, -3f, 0)
				.attributes(ItemAttributeModifiers.builder().add(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_ID, -1, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
						.add(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_ID, -3, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND).build()));
	}

	@SubscribeEvent
	public static void modifyDefaultComponents(ModifyDefaultComponentsEvent event) {
		event.modify(PalamodModItems.CREATIVE_HAMMER.get(), builder -> builder.remove(DataComponents.MAX_DAMAGE));
	}

	@Override
	public boolean isCorrectToolForDrops(ItemStack itemstack, BlockState blockstate) {
		return blockstate.is(BlockTags.MINEABLE_WITH_AXE) || blockstate.is(BlockTags.MINEABLE_WITH_HOE) || blockstate.is(BlockTags.MINEABLE_WITH_PICKAXE) || blockstate.is(BlockTags.MINEABLE_WITH_SHOVEL);
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ItemAbility toolAction) {
		return ItemAbilities.DEFAULT_AXE_ACTIONS.contains(toolAction) || ItemAbilities.DEFAULT_HOE_ACTIONS.contains(toolAction) || ItemAbilities.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || toolAction == ItemAbilities.SWORD_SWEEP;
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
		return 99999f;
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		itemstack.hurtAndBreak(1, entity, LivingEntity.getSlotForHand(entity.getUsedItemHand()));
		SmeltplusProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return true;
	}

	@Override
	public void hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		itemstack.hurtAndBreak(2, entity, LivingEntity.getSlotForHand(entity.getUsedItemHand()));
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		SmeltplusProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}
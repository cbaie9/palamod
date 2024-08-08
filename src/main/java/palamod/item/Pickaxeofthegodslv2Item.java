
package palamod.item;

import net.minecraft.world.entity.ai.attributes.Attributes;

public class Pickaxeofthegodslv2Item extends TieredItem {
	public Pickaxeofthegodslv2Item() {
		super(new Tier() {
			public int getUses() {
				return 0;
			}

			public float getSpeed() {
				return 4f;
			}

			public float getAttackDamageBonus() {
				return 2f;
			}

			public int getLevel() {
				return 3;
			}

			public int getEnchantmentValue() {
				return 5;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of();
			}
		}, new Item.Properties());
	}

	@Override
	public boolean isCorrectToolForDrops(BlockState blockstate) {
		int tier = 3;
		if (tier < 3 && blockstate.is(BlockTags.NEEDS_DIAMOND_TOOL)) {
			return false;
		} else if (tier < 2 && blockstate.is(BlockTags.NEEDS_IRON_TOOL)) {
			return false;
		} else {
			return tier < 1 && blockstate.is(BlockTags.NEEDS_STONE_TOOL)
					? false
					: (blockstate.is(BlockTags.MINEABLE_WITH_AXE) || blockstate.is(BlockTags.MINEABLE_WITH_HOE) || blockstate.is(BlockTags.MINEABLE_WITH_PICKAXE) || blockstate.is(BlockTags.MINEABLE_WITH_SHOVEL));
		}
	}

	@Override
	public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
		return ToolActions.DEFAULT_AXE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_HOE_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_SHOVEL_ACTIONS.contains(toolAction) || ToolActions.DEFAULT_PICKAXE_ACTIONS.contains(toolAction)
				|| ToolActions.DEFAULT_SWORD_ACTIONS.contains(toolAction);
	}

	@Override
	public float getDestroySpeed(ItemStack itemstack, BlockState blockstate) {
		return 4f;
	}

	@Override
	public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(EquipmentSlot equipmentSlot) {
		if (equipmentSlot == EquipmentSlot.MAINHAND) {
			ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
			builder.putAll(super.getDefaultAttributeModifiers(equipmentSlot));
			builder.put(Attributes.ATTACK_DAMAGE, new AttributeModifier(BASE_ATTACK_DAMAGE_UUID, "Tool modifier", 3f, AttributeModifier.Operation.ADDITION));
			builder.put(Attributes.ATTACK_SPEED, new AttributeModifier(BASE_ATTACK_SPEED_UUID, "Tool modifier", -2.9, AttributeModifier.Operation.ADDITION));
			return builder.build();
		}
		return super.getDefaultAttributeModifiers(equipmentSlot);
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		itemstack.hurtAndBreak(1, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		Upgradepotgv2Procedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return true;
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		itemstack.hurtAndBreak(2, entity, i -> i.broadcastBreakEvent(EquipmentSlot.MAINHAND));
		return true;
	}

	@Override
	public void appendHoverText(ItemStack itemstack, Level level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(Component.literal("Level 2"));
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			MoucepotgProcedure.execute(entity, itemstack);
	}
}

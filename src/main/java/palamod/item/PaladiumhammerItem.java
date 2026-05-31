package palamod.item;

import palamod.procedures.PaladiumhammerToolInInventoryTickProcedure;
import palamod.procedures.Hammer1Procedure;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

public class PaladiumhammerItem extends Item {
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 3999, 8f, 0, 1, TagKey.create(Registries.ITEM, Identifier.parse("palamod:paladium_hammer_repair_items")));

	public PaladiumhammerItem(Item.Properties properties) {
		super(properties.pickaxe(TOOL_MATERIAL, 0f, -3f));
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
		Hammer1Procedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity, itemstack);
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, ServerLevel world, Entity entity, @Nullable EquipmentSlot equipmentSlot) {
		super.inventoryTick(itemstack, world, entity, equipmentSlot);
		PaladiumhammerToolInInventoryTickProcedure.execute(world, itemstack);
	}
}
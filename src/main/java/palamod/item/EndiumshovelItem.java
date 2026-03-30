package palamod.item;

import palamod.procedures.ExcavatorprocessamethystProcedure;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class EndiumshovelItem extends ShovelItem {
<<<<<<< Updated upstream
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 36f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:endiumshovel_repair_items")));
=======
	private static final ToolMaterial TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 4999, 36f, 0, 14, TagKey.create(Registries.ITEM, ResourceLocation.parse("palamod:endium_shovel_repair_items")));
>>>>>>> Stashed changes

	public EndiumshovelItem(Item.Properties properties) {
		super(TOOL_MATERIAL, 4f, -3.5f, properties.fireResistant());
	}

	@Override
	public boolean mineBlock(ItemStack itemstack, Level world, BlockState blockstate, BlockPos pos, LivingEntity entity) {
		boolean retval = super.mineBlock(itemstack, world, blockstate, pos, entity);
		ExcavatorprocessamethystProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
		return retval;
	}
}
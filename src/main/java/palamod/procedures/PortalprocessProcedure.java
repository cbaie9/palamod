package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class PortalprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState angle_block = Blocks.AIR.defaultBlockState();
		BlockState shiny_wood = Blocks.AIR.defaultBlockState();
		ItemStack key = ItemStack.EMPTY;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYST_PORTALBLOCK.get()) {
			angle_block = PalamodModBlocks.AMETHYST_BLOCK.get().defaultBlockState();
			shiny_wood = PalamodModBlocks.SHINY_JACARANDA_WOOD.get().defaultBlockState();
			key = new ItemStack(PalamodModItems.AMETHYST_PORTAL_KEY.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.TITANE_PORTAL_BLOCK.get()) {
			angle_block = PalamodModBlocks.TITANE_BLOCK.get().defaultBlockState();
			shiny_wood = PalamodModBlocks.SHINY_JUDEECERCIS_WOOD.get().defaultBlockState();
			key = new ItemStack(PalamodModItems.TITANE_PORTAL_KEY.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.PALADIUM_PORTAL_BLOCK.get()) {
			angle_block = PalamodModBlocks.PALADIUM_BLOCK.get().defaultBlockState();
			shiny_wood = PalamodModBlocks.SHINY_ERABLE_WOOD.get().defaultBlockState();
			key = new ItemStack(PalamodModItems.PALADIUM_PORTAL_KEY.get()).copy();
		} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ENDIUM_PORTAL_BLOCK.get()) {
			angle_block = PalamodModBlocks.ENDIUM_PORTAL_ANGLE_BLOCK.get().defaultBlockState();
			shiny_wood = PalamodModBlocks.SHINY_ERABLE_WOOD.get().defaultBlockState();
			key = new ItemStack(PalamodModItems.ENDIUM_PORTAL_KEY.get()).copy();
		}
		PalamodMod.LOGGER.debug(("Portal dump :" + "\n" + "angle block :" + angle_block + "\n" + "shiny wood :" + shiny_wood + "\n" + "key : " + key + "\n" + getBlockNBTString(world, BlockPos.containing(x, y, z), "position") + "\n"
				+ getBlockNBTLogic(world, BlockPos.containing(x, y, z), "portal_powered") + IsgameserversideProcedure.execute()));
		if (CheckportalstructureProcedure.execute(world, x, y, z, angle_block, shiny_wood) && key.getItem() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()
				&& !getBlockNBTLogic(world, BlockPos.containing(x, y, z), "portal_powered")) {
			if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "position")).equals("west")) {
				world.setBlock(BlockPos.containing(x + 1, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 2, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 2, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 2, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 3, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 3, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 3, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
			} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "position")).equals("east")) {
				world.setBlock(BlockPos.containing(x - 1, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 2, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 2, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 2, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 3, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 3, y, z), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 3, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
			} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "position")).equals("north")) {
				world.setBlock(BlockPos.containing(x + 1, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z - 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z - 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z - 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z - 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z - 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z - 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z - 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
			} else if ((getBlockNBTString(world, BlockPos.containing(x, y, z), "position")).equals("south")) {
				world.setBlock(BlockPos.containing(x + 1, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z + 1), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z + 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z + 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z + 2), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x + 1, y, z + 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y, z + 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x - 1, y, z + 3), PalamodModBlocks.PORTAL_BLOCK.get().defaultBlockState(), 3);
			}
		}
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getString(tag);
		return "";
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}
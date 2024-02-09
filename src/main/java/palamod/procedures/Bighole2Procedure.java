package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class Bighole2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.getXRot() > 40 || entity.getXRot() < -40) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 3, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 3, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 3, y, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 3, y, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 3, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 3, y, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 3, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
		} else if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
			if ((world.getBlockState(BlockPos.containing(x + 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 2, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 3, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y + 3, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y + 3, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y + 3, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 2, y + 3, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 2, y + 2, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y + 2, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 1, y + 2, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 1, y + 2, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 2, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 2, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 2, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x - 2, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x - 2, y, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x - 2, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x + 2, y, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x + 2, y, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x + 2, y, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
		} else if ((entity.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.EAST) {
			if ((world.getBlockState(BlockPos.containing(x, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 2, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 3, z);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 2, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 2, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 3, z + 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 3, z - 1);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 3, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 2, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z - 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y - 1, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 1, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 2, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
			if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe"))) && !((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).getBlock() == Blocks.BEDROCK)) {
				{
					BlockPos _pos = BlockPos.containing(x, y + 3, z + 2);
					Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
					world.destroyBlock(_pos, false);
				}
			}
		}
	}
}

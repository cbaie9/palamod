package palamod.procedures;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class Bighole2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (jobs.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
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
						if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 1, y, z + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 1, y, z - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 1, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 1, y, z - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 1, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
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
						if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 2, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 2, y, z - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 2, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 2, y, z + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 3, y, z + 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 3, y, z + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 3, y, z - 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 3, y, z - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 3, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 3, y, z - 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 3, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 3, y, z + 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 2, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 2, y, z + 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 2, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 2, y, z - 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 1, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 1, y, z - 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 1, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 1, y, z + 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 1, y, z - 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 1, y, z - 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 1, y, z + 2))).getBlock() == Blocks.BEDROCK)) {
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
						if ((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 1, y + 1, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 1, y - 1, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 1, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 1, y - 1, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 1, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
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
						if ((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 2, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 2, y + 3, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 1, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 1, y + 3, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 1, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 1, y + 3, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 2, y + 3, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 2, y + 3, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 2, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 2, y + 2, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 2, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 2, y + 2, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 1, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 1, y + 2, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 1, y + 2, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 1, y + 2, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 2, y + 1, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x - 2, y + 1, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 2, y + 1, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 2, y + 1, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x + 2, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x + 2, y - 1, z);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x - 2, y - 1, z))).getBlock() == Blocks.BEDROCK)) {
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
						if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 1, z + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y - 1, z + 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y - 1, z + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y - 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y - 1, z - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 1, z - 1))).getBlock() == Blocks.BEDROCK)) {
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
						if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 2, z - 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 2, z - 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 2, z + 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 2, z + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 3, z + 1))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 3, z + 1);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 3, z - 1))).getBlock() == Blocks.BEDROCK)) {
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
						if ((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 3, z - 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 3, z - 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 2, z - 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 2, z - 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 1, z - 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 1, z - 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y - 1, z - 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y - 1, z - 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y - 1, z + 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y - 1, z + 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 1, z + 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 1, z + 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 2, z + 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 2, z + 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
						if ((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).is(BlockTags.create(new ResourceLocation("minecraft:mineable/pickaxe")))
								&& !((world.getBlockState(BlockPos.containing(x, y + 3, z + 2))).getBlock() == Blocks.BEDROCK)) {
							{
								BlockPos _pos = BlockPos.containing(x, y + 3, z + 2);
								Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y, z), null);
								world.destroyBlock(_pos, false);
							}
						}
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(jobs);
					fileWriter.write(mainGSONBuilderVariable.toJson(main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		} else {
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
}

package palamod.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetxpminerbreakblocklogicProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		boolean output = false;
		BlockState block1 = Blocks.AIR.defaultBlockState();
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		File jobs = new File("");
		double nloop = 0;
		jobs = ReadcacheProcedure.execute(entity);
		if (jobs.exists() && (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:hammer_smt")))
				&& (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0) {
			for (int index0 = 0; index0 < 9; index0++) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						if (BuiltInRegistries.BLOCK.get(ResourceLocation.parse((main.get((8 == nloop ? "block" : "block_hammer_cache_" + nloop)).getAsString()).toLowerCase(java.util.Locale.ENGLISH))).defaultBlockState()
								.is(BlockTags.create(ResourceLocation.parse("palamod:miner_dx_xp")))) {
							output = true;
							break;
						}
						nloop = nloop + 1;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("palamod:miner_dx_xp")))) {
				output = true;
			} else {
				output = false;
			}
		}
		return output;
	}
}
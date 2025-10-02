package palamod.procedures;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

@EventBusSubscriber
public class SetblockstateincacheProcedure {
	@SubscribeEvent
	public static void onLeftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getEntity());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main_chs = new com.google.gson.JsonObject();
		File cache = new File("");
		String tag = "";
		double i = 0;
		double j = 0;
		double nloop = 0;
		BlockState block_to_set = Blocks.AIR.defaultBlockState();
		if (IsgameclientsideProcedure.execute()) {
			cache = ReadcacheProcedure.execute(entity);
			if (cache.exists()) {
				if ((world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(ResourceLocation.parse("palamod:got_blockstate")))) {
					main_chs.addProperty("last_block_state",
							((world.getBlockState(BlockPos.containing(x, y, z))).getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip4
									? (world.getBlockState(BlockPos.containing(x, y, z))).getValue(_getip4)
									: -1));
				}
				main_chs.addProperty("block", (BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString()));
				i = -1;
				for (int index0 = 0; index0 < 3; index0++) {
					j = -1;
					for (int index1 = 0; index1 < 3; index1++) {
						if (i != 0 || j != 0) {
							if (entity.getXRot() > 40 || entity.getXRot() < -40) {
								block_to_set = (world.getBlockState(BlockPos.containing(x + i, y, z + j)));
							} else if ((entity.getDirection()).getAxis() == Direction.Axis.Z) {
								block_to_set = (world.getBlockState(BlockPos.containing(x + i, y + j, z)));
							} else if ((entity.getDirection()).getAxis() == Direction.Axis.X) {
								block_to_set = (world.getBlockState(BlockPos.containing(x, y + j, z + i)));
							}
						} else {
							j = j + 1;
							continue;
						}
						if (block_to_set.is(BlockTags.create(ResourceLocation.parse("palamod:got_blockstate")))) {
							main_chs.addProperty(("blockstate_hammer_cache_" + nloop), (block_to_set.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _getip19 ? block_to_set.getValue(_getip19) : -1));
						}
						main_chs.addProperty(("block_hammer_cache_" + nloop), (BuiltInRegistries.BLOCK.getKey(block_to_set.getBlock()).toString()));
						j = j + 1;
						nloop = nloop + 1;
					}
					i = i + 1;
				}
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(cache);
						fileWriter.write(mainGSONBuilderVariable.toJson(main_chs));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}
}
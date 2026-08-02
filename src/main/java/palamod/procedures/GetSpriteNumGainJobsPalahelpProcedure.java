package palamod.procedures;

import palamod.init.PalamodModMenus;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class GetSpriteNumGainJobsPalahelpProcedure {
	public static double execute(Entity entity, double slotNum) {
		if (entity == null)
			return 0;
		ItemStack item = ItemStack.EMPTY;
		double xpGain = 0;
		double lvl_miner = 0;
		double lvl_farmer = 0;
		double lvl_hunter = 0;
		double lvl_alchi = 0;
		File jobs = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		BlockState age_up = Blocks.AIR.defaultBlockState();
		item = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get((int) slotNum).getItem() : ItemStack.EMPTY).copy();
		if (!(Blocks.AIR.asItem() == item.getItem())) {
			jobs = GetjobsfileProcedure.execute(entity);
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
						main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						if (main.has("lvl_miner")) {
							lvl_miner = main.get("lvl_miner").getAsDouble();
						}
						if (main.has("lvl_farmer")) {
							lvl_farmer = main.get("lvl_farmer").getAsDouble();
						}
						if (main.has("lvl_hunter")) {
							lvl_hunter = main.get("lvl_hunter").getAsDouble();
						}
						if (main.has("lvl_alchi")) {
							lvl_alchi = main.get("lvl_alchi").getAsDouble();
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
			if ((entity.getPersistentData().getString("jobs_mode")).equals("farmer")) {
				if ((entity.getPersistentData().getString("xp_mode")).equals("grow")) {
					age_up = (blockStateWithInt((item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState()), "age", 7));
					xpGain = GetxpfarmerbreakblockProcedure.execute(age_up, lvl_farmer);
				} else if ((entity.getPersistentData().getString("xp_mode")).equals("craft")) {
					xpGain = GetXpcraftjobsProcedure.execute(item, lvl_alchi, lvl_farmer, lvl_hunter, lvl_miner, "craft");
				}
			} else if ((entity.getPersistentData().getString("jobs_mode")).equals("miner")) {
				if ((entity.getPersistentData().getString("xp_mode")).equals("mine")) {
					xpGain = GetxpminerbreakblockProcedure.execute(item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState(), entity, true, lvl_miner);
				} else if ((entity.getPersistentData().getString("xp_mode")).equals("smelt")) {
					xpGain = GetXpcraftjobsProcedure.execute(item, lvl_alchi, lvl_farmer, lvl_hunter, lvl_miner, "smelt");
				}
			} else if ((entity.getPersistentData().getString("jobs_mode")).equals("hunter")) {
				if ((entity.getPersistentData().getString("xp_mode")).equals("kill")) {
					xpGain = GetXpcraftjobsentityProcedure.execute(lvl_alchi, lvl_farmer, lvl_hunter, lvl_miner, ConvertSpawnEggToEntityRegistryProcedure.execute(item));
				} else if ((entity.getPersistentData().getString("xp_mode")).equals("smelt")) {
					xpGain = GetXpcraftjobsProcedure.execute(item, lvl_alchi, lvl_farmer, lvl_hunter, lvl_miner, "smelt");
				}
			} else if ((entity.getPersistentData().getString("jobs_mode")).equals("alchi")) {
				if ((entity.getPersistentData().getString("xp_mode")).equals("craft")) {
					xpGain = GetXpcraftjobsProcedure.execute(item, lvl_alchi, lvl_farmer, lvl_hunter, lvl_miner, "craft");
				} else if ((entity.getPersistentData().getString("xp_mode")).equals("break")) {
					xpGain = GetxpalchibreakblockProcedure.execute(item.getItem() instanceof BlockItem _bi ? _bi.getBlock().defaultBlockState() : Blocks.AIR.defaultBlockState(), lvl_alchi);
				}
			}
		}
		if (0 < xpGain) {
			return 0;
		}
		return 1;
	}

	private static BlockState blockStateWithInt(BlockState blockState, String property, int newValue) {
		Property<?> prop = blockState.getBlock().getStateDefinition().getProperty(property);
		return prop instanceof IntegerProperty ip && prop.getPossibleValues().contains(newValue) ? blockState.setValue(ip, newValue) : blockState;
	}
}
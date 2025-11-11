package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class XpbottleprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		double money_add = 0;
		File money = new File("");
		File jobs = new File("");
		boolean money_getadd = false;
		String jobs_text = "";
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_money = new com.google.gson.JsonObject();
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_jobs", 0) > 0) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("jobs_type", 0) == 1) {
				jobs_text = "miner";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("jobs_type", 0) == 2) {
				jobs_text = "farmer";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("jobs_type", 0) == 3) {
				jobs_text = "hunter";
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("jobs_type", 0) == 4) {
				jobs_text = "alchi";
			}
			jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
					+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\jobs\\" + entity.getUUID().toString()),
					File.separator + "jobs.json");
			money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
			if (jobs.exists() && money.exists()) {
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
						if (world.dayTime() > main.get(("xpstreak_time_" + jobs_text)).getAsDouble()) {
							main.addProperty(("xpstreak_" + jobs_text), 0);
						}
						main.addProperty(("xp_" + jobs_text),
								(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_jobs", 0) * main.get("multi_exp").getAsDouble() + main.get(("xp_" + jobs_text)).getAsDouble()));
						main.addProperty(("xpstreak_" + jobs_text),
								(itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_jobs", 0) * main.get("multi_exp").getAsDouble() + main.get(("xpstreak_" + jobs_text)).getAsDouble()));
						main.addProperty(("xpstreak_time_" + jobs_text), (world.dayTime() + 80));
						if (world instanceof ServerLevel _level) {
							itemstack.hurtAndBreak(1, _level, null, _stkprov -> {
							});
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + ""
									+ (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_jobs", 0) * main.get("multi_exp").getAsDouble() + main.get(("xpstreak_" + jobs_text)).getAsDouble())
									+ Component.translatable("palamod.procedure.jobswin3").getString() + " " + new ItemStack(PalamodModItems.XPBOTTLE.get()).getDisplayName().getString())), true);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(jobs);
						fileWriter.write(mainGSONBuilderVariable.toJson(main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
			if (("miner").equals(jobs_text)) {
				ChecklvlminerProcedure.execute(world, x, y, z, entity);
			} else if (("farmer").equals(jobs_text)) {
				ChecklvlfarmerProcedure.execute(world, x, y, z, entity);
			} else if (("hunter").equals(jobs_text)) {
				ChecklvlhunterProcedure.execute(world, x, y, z, entity);
			} else if (("alchi").equals(jobs_text)) {
				ChecklvlalchimistProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
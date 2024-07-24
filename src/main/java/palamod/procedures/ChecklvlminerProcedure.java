package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class ChecklvlminerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double money_add = 0;
		boolean money_getadd = false;
		File jobs = new File("");
		File money = new File("");
		com.google.gson.JsonObject main_jobs = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_money = new com.google.gson.JsonObject();
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (main_jobs.get("next_level_miner").getAsDouble() <= main_jobs.get("xp_miner").getAsDouble() && jobs.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main_jobs = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					main_jobs.addProperty("lvl_miner", (1 + main_jobs.get("lvl_miner").getAsDouble()));
					main_jobs.addProperty("xp_miner", (main_jobs.get("xp_miner").getAsDouble() - main_jobs.get("next_level_miner").getAsDouble()));
					main_jobs.addProperty("next_level_miner", GetnextlevelxpProcedure.execute(entity));
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
						_setstack.setCount((int) (1 + Math.floor(main_jobs.get("lvl_miner").getAsDouble() / 2)));
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (entity instanceof Player _player) {
						ItemStack _setstack = new ItemStack(PalamodModItems.TRIXIUM.get()).copy();
						_setstack.setCount((int) main_jobs.get("lvl_miner").getAsDouble());
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" " + "" + Component.translatable("palamod.procedure.jobswinlvl_miner1").getString() + " \\n "
										+ Component.translatable("palamod.procedure.jobswinlvl_miner2").getString() + " " + Math.round(main_jobs.get("lvl_miner").getAsDouble()) + ","
										+ Component.translatable("palamod.procedure.jobswinlvl_miner3").getString() + " " + Math.round(1000) + "$\",\"color\":\"gold\"}]"));
					money_getadd = true;
					money_add = 2 * (main_jobs.get("lvl_miner").getAsDouble() + 1);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(jobs);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_jobs));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
		if (money.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(money));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main_money = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (money_getadd) {
						main_money.addProperty("money", (main_money.get("money").getAsDouble() + money_add));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(money);
					fileWriter.write(mainGSONBuilderVariable.toJson(main_money));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}

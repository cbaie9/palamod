package palamod.procedures;

import palamod.init.PalamodModItems;

import palamod.PalamodMod;

import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

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
		if (itemstack.getOrCreateTag().getDouble("xp_jobs") > 0) {
			if (itemstack.getOrCreateTag().getDouble("jobs_type") == 1) {
				jobs_text = "miner";
			} else if (itemstack.getOrCreateTag().getDouble("jobs_type") == 2) {
				jobs_text = "farmer";
			} else if (itemstack.getOrCreateTag().getDouble("jobs_type") == 3) {
				jobs_text = "hunter";
			} else if (itemstack.getOrCreateTag().getDouble("jobs_type") == 4) {
				jobs_text = "alchi";
			}
			jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
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
						main.addProperty(("xp_" + jobs_text), (itemstack.getOrCreateTag().getDouble("xp_jobs") * main.get("multi_exp").getAsDouble() + main.get(("xp_" + jobs_text)).getAsDouble()));
						main.addProperty(("xpstreak_" + jobs_text), (itemstack.getOrCreateTag().getDouble("xp_jobs") * main.get("multi_exp").getAsDouble() + main.get(("xpstreak_" + jobs_text)).getAsDouble()));
						main.addProperty(("xpstreak_time_" + jobs_text), (world.dayTime() + 80));
						{
							ItemStack _ist = itemstack;
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal(
									(Component.translatable("palamod.procedure.jobswin1").getString() + "" + (itemstack.getOrCreateTag().getDouble("xp_jobs") * main.get("multi_exp").getAsDouble() + main.get(("xpstreak_" + jobs_text)).getAsDouble())
											+ Component.translatable("palamod.procedure.jobswin3").getString() + " " + new ItemStack(PalamodModItems.XPBOTTLE.get()).getDisplayName().getString())),
									true);
						PalamodMod.LOGGER.debug(("Debug : " + (itemstack.getOrCreateTag().getDouble("xp_jobs") * main.get("multi_exp").getAsDouble() + main.get(("xpstreak_" + jobs_text)).getAsDouble())));
						assert Boolean.TRUE; //#dbg:Xpbottleprocess:check_lvl_miner
						if (main.get(("next_level_" + jobs_text)).getAsDouble() <= main.get(("xp_" + jobs_text)).getAsDouble()) {
							main.addProperty(("lvl_" + jobs_text), (1 + main.get(("lvl_" + jobs_text)).getAsDouble()));
							main.addProperty(("xp_" + jobs_text), (main.get(("xp_" + jobs_text)).getAsDouble() - main.get(("next_level_" + jobs_text)).getAsDouble()));
							main.addProperty(("next_level_" + jobs_text), GetnextlevelxpProcedure.execute(entity));
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
								_setstack.setCount((int) (1 + Math.floor(main.get(("lvl_" + jobs_text)).getAsDouble() / 2)));
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (entity instanceof Player _player) {
								ItemStack _setstack = new ItemStack(PalamodModItems.TRIXIUM.get()).copy();
								_setstack.setCount((int) main.get(("lvl_" + jobs_text)).getAsDouble());
								ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
							}
							if (world instanceof ServerLevel _level)
								_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
										("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" " + "" + Component.translatable("palamod.procedure.jobswinlvl_miner1").getString() + " \\n "
												+ Component.translatable("palamod.procedure.jobswinlvl_miner2").getString() + " " + Math.round(main.get("lvl_miner").getAsDouble()) + ","
												+ Component.translatable("palamod.procedure.jobswinlvl_miner3").getString() + " " + Math.round(1000) + "$\",\"color\":\"gold\"}]"));
							money_getadd = true;
							money_add = 2 * (main.get(("lvl_" + jobs_text)).getAsDouble() + 1);
						}
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
							main_money.addProperty("money", (main.get("money").getAsDouble() + money_add));
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
}

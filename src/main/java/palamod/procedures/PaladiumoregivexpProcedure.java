package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModEnchantments;

import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class PaladiumoregivexpProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		File jobs = new File("");
		File money = new File("");
		boolean money_getadd = false;
		double lvl = 0;
		double money_add = 0;
		double blockstate = 0;
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (jobs.exists() && !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity)) && money.exists()) {
			assert Boolean.TRUE; //#dbg:Paladiumoregivexp:m1
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
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("lvl :" + main.get("lvl_miner").getAsDouble())), false);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("block :" + blockstate)), false);
					if (world.dayTime() > main.get("xpstreak_time_miner").getAsDouble()) {
						main.addProperty("xpstreak_miner", 0);
					}
					if (main.get("lvl_miner").getAsDouble() >= 40) {
						assert Boolean.TRUE; //#dbg:Paladiumoregivexp:lvl_good
						if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BOTTELED.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
								&& (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("jobs_type")
										|| 1 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("jobs_type"))
								&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.XPBOTTLE.get()) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("xp_jobs",
									(150 * main.get("multi_exp").getAsDouble() + (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("xp_jobs")));
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("jobs_type", 1);
						} else {
							assert Boolean.TRUE; //#dbg:Paladiumoregivexp:xp
							main.addProperty("xp_miner", ((2 / 3) * 100 * main.get("multi_exp").getAsDouble() + main.get("xp_miner").getAsDouble()));
						}
						main.addProperty("xpstreak_miner", ((2 / 3) * 100 * main.get("multi_exp").getAsDouble() + main.get("xpstreak_miner").getAsDouble()));
						main.addProperty("xpstreak_time_miner", (world.dayTime() + 80));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + "" + (150 * main.get("multi_exp").getAsDouble() + main.get("xpstreak_miner").getAsDouble())
									+ Component.translatable("palamod.procedure.jobswin2").getString() + " " + Component.translatable("block.palamod.paladium_ore").getString())), true);
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
		ChecklvlminerProcedure.execute(world, x, y, z, entity);
	}
}

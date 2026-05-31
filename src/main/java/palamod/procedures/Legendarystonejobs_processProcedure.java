package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class Legendarystonejobs_processProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		String jobs_string = "";
		File jobs = new File("");
		double random = 0;
		double rd_amount = 0;
		if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("cooldown", 0) == 0 || entity instanceof Player _plr2 && _plr2.gameMode() == GameType.CREATIVE) {
			jobs = GetjobsfileProcedure.execute(entity);
			if (jobs.exists()) {
				random = Mth.nextInt(RandomSource.create(), 1, 4);
				if (random == 1) {
					jobs_string = "miner";
				} else if (random == 2) {
					jobs_string = "farmer";
				} else if (random == 3) {
					jobs_string = "hunter";
				} else {
					jobs_string = "alchi";
				}
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
						rd_amount = main.get("multi_exp").getAsDouble() * Mth.nextInt(RandomSource.create(), 1, 20) * 300;
						if (world.dayTime() > main.get(("xpstreak_time_" + jobs_string)).getAsDouble()) {
							main.addProperty(("xpstreak_" + jobs_string), 0);
						}
						if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
								.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled")))) != 0
								&& (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("jobs_type", 0)
										|| random == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("jobs_type", 0))
								&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.XP_BOTTLE.get()) {
							{
								final String _tagName = "xp_jobs";
								final double _tagValue = (rd_amount
										+ (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_jobs", 0));
								CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
							}
							{
								final String _tagName = "jobs_type";
								final double _tagValue = random;
								CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
							}
						} else {
							main.addProperty(("xp_" + jobs_string), (rd_amount * main.get("multi_exp").getAsDouble() + main.get(("xp_" + jobs_string)).getAsDouble()));
						}
						main.addProperty(("xpstreak_" + jobs_string), (rd_amount + main.get(("xpstreak_" + jobs_string)).getAsDouble()));
						main.addProperty(("xpstreak_time_" + jobs_string), (world.dayTime() + 80));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + "" + (rd_amount + main.get(("xpstreak_" + jobs_string)).getAsDouble())
									+ Component.translatable("palamod.procedure.jobswin2lg_jobs").getString())), true);
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
			} else {
				if (entity instanceof Player _player)
					_player.giveExperiencePoints((int) Math.pow(Mth.nextInt(RandomSource.create(), 1, 10), 5));
			}
			if (world.isClientSide())
				Minecraft.getInstance().gameRenderer.displayItemActivation(new ItemStack(PalamodModItems.LEGENDARY_STONE_JOBS.get()));
			{
				final String _tagName = "name";
				final String _tagValue = (new ItemStack(PalamodModItems.LEGENDARY_STONE_JOBS.get()).getDisplayName().getString());
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
			}
			{
				final String _tagName = "cooldown";
				final double _tagValue = 48000;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
	}
}
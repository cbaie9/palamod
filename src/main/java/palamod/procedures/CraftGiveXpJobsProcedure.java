package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class CraftGiveXpJobsProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack item_craft, String recipe) {
		if (entity == null || recipe == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		ItemStack item = ItemStack.EMPTY;
		File jobs = new File("");
		File money = new File("");
		double xp_receive = 0;
		double jobs_type_xpbottle = 0;
		String jobs_string = "";
		String type_of_recipe = "";
		type_of_recipe = recipe;
		if (((type_of_recipe).equals("craft") || (type_of_recipe).equals("smelt")) && !world.isClientSide()) {
			item = item_craft.copy();
			if (!world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.DISABLEJOBSGAMERULE)) {
				jobs = ReadjobsserverProcedure.execute(entity);
				money = ReadMoneyFileProcedure.execute(entity);
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
							if (world.dayTime() > main.get("xpstreak_time_miner").getAsDouble()) {
								main.addProperty("xpstreak_miner", 0);
							}
							if (world.dayTime() > main.get("xpstreak_time_farmer").getAsDouble()) {
								main.addProperty("xpstreak_farmer", 0);
							}
							if (world.dayTime() > main.get("xpstreak_time_hunter").getAsDouble()) {
								main.addProperty("xpstreak_hunter", 0);
							}
							if (world.dayTime() > main.get("xpstreak_time_alchi").getAsDouble()) {
								main.addProperty("xpstreak_alchi", 0);
							}
							xp_receive = GetXpcraftjobsProcedure.execute(item, main.get("lvl_alchi").getAsDouble(), main.get("lvl_farmer").getAsDouble(), main.get("lvl_hunter").getAsDouble(), main.get("lvl_miner").getAsDouble(), type_of_recipe);
							if (0 < xp_receive) {
								if (item.is(ItemTags.create(ResourceLocation.parse("palamod:farmer_jobs")))) {
									jobs_string = "farmer";
									jobs_type_xpbottle = 2;
								} else if (item.is(ItemTags.create(ResourceLocation.parse("palamod:alchimist_jobs")))) {
									jobs_string = "alchi";
									jobs_type_xpbottle = 4;
								} else if (item.is(ItemTags.create(ResourceLocation.parse("palamod:miner_jobs")))) {/*No craft are in the palamod in paladium here, futurproofing*/
									jobs_string = "miner";
									jobs_type_xpbottle = 1;
								} else if (item.is(ItemTags.create(ResourceLocation.parse("palamod:hunter_jobs")))) {/*No craft are in the palamod in paladium here, futurproofing*/
									jobs_string = "hunter";
									jobs_type_xpbottle = 3;
								} else {
									jobs_string = "alchi";
									PalamodMod.LOGGER.error(("[ Palamod ][ from craftgivejobs.java] : error -> Craft with approved xp amount but no attribued jobs | item :  '" + item + "' , fallback to alchimist"));
								}
								if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
										.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled")))) != 0
										&& (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type")
												|| 1 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type"))
										&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.XP_BOTTLE.get()) {
									{
										final String _tagName = "xp_jobs";
										final double _tagValue = (xp_receive * main.get("multi_exp").getAsDouble() * item.getCount()
												+ (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp_jobs"));
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
									}
									{
										final String _tagName = "jobs_type";
										final double _tagValue = jobs_type_xpbottle;
										CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
									}
								} else {
									main.addProperty(("xp_" + jobs_string), (xp_receive * main.get("multi_exp").getAsDouble() * item.getCount() + main.get(("xp_" + jobs_string)).getAsDouble()));
								}
								main.addProperty(("xpstreak_" + jobs_string), (xp_receive * main.get("multi_exp").getAsDouble() * item.getCount() + main.get(("xpstreak_" + jobs_string)).getAsDouble()));
								main.addProperty(("xpstreak_time_" + jobs_string), (world.dayTime() + 80));
							}
							PalamodMod.LOGGER.debug(
									((((("[PalaMod] [CraftGiveXp] Giving %1 Xp In %2 to %3, source %4 %5".replace("%4", "" + item.getCount())).replace("%5", item.getDisplayName().getString())).replace("%3", entity.getDisplayName().getString()))
											.replace("%2", jobs_string)).replace("%1", "" + (xp_receive * main.get("multi_exp").getAsDouble() * item.getCount() + main.get(("xpstreak_" + jobs_string)).getAsDouble()))));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(
										Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + ""
												+ (xp_receive * main.get("multi_exp").getAsDouble() * item.getCount() + main.get(("xpstreak_" + jobs_string)).getAsDouble()) + Component.translatable(("palamod.procedure.jobswin2" + recipe)).getString()
												+ " " + Component.translatable(((BuiltInRegistries.ITEM.getKey(item.getItem()).toString()).replace("minecraft:", ("" + item).contains("palamod") ? "item.palamod." : "item.minecraft."))).getString())),
										true);
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
			}
		}
	}
}
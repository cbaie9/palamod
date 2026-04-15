package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;

import palamod.PalamodMod;

import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class CraftGiveXpJobskillEntityProcedure {
	@SubscribeEvent
	public static void onEntityDeath(LivingDeathEvent event) {
		if (event.getEntity() != null) {
			execute(event, event.getEntity().level(), event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(LevelAccessor world, Entity entity, Entity sourceentity) {
		execute(null, world, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		File jobs = new File("");
		File money = new File("");
		double xp_receive = 0;
		double jobs_type_xpbottle = 0;
		String jobs_string = "";
		String type_of_recipe = "";
		Entity entity_xp = null;
		PalamodMod.LOGGER.info(("kill entity" + entity + "source" + sourceentity));
		if (!world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.DISABLEJOBSGAMERULE)) {
			jobs = ReadjobsserverProcedure.execute(entity);
			money = ReadMoneyFileProcedure.execute(entity);
			if (jobs.exists() && !(getEntityGameType(entity) == GameType.CREATIVE) && money.exists() && (sourceentity instanceof Player || sourceentity instanceof ServerPlayer)) {
				PalamodMod.LOGGER.info("M1");
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
						xp_receive = GetXpcraftjobsentityProcedure.execute(entity);
						PalamodMod.LOGGER.info(("M2    " + xp_receive));
						if (0 < xp_receive) {
							if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("palamod:farmer_jobs")))) {
								jobs_string = "farmer";
								jobs_type_xpbottle = 2;
							} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("palamod:alchimist_jobs")))) {
								jobs_string = "alchi";
								jobs_type_xpbottle = 4;
							} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("palamod:miner_jobs")))) {/*No craft are in the palamod in paladium here, futurproofing*/
								jobs_string = "miner";
								jobs_type_xpbottle = 1;
							} else if (entity.getType().is(TagKey.create(Registries.ENTITY_TYPE, ResourceLocation.parse("palamod:hunter_jobs")))) {/*No craft are in the palamod in paladium here, futurproofing*/
								jobs_string = "hunter";
								PalamodMod.LOGGER.info("M2");
								jobs_type_xpbottle = 3;
							} else {
								jobs_string = "alchi";
								PalamodMod.LOGGER.info("M2err");
								PalamodMod.LOGGER.error(("[ Palamod ][ from craftgivejobs.java] : error -> Craft with approved xp amount but no attribued jobs | item :  '" + BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()
										+ "' , fallback to alchimist"));
							}
							PalamodMod.LOGGER.debug(jobs_string);
							PalamodMod.LOGGER.info("M3");
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled")))) != 0
									&& (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type")
											|| 1 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("jobs_type"))
									&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.XP_BOTTLE.get()) {
								PalamodMod.LOGGER.info("M3");
								{
									final String _tagName = "xp_jobs";
									final double _tagValue = (xp_receive * main.get("multi_exp").getAsDouble()
											+ (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("xp_jobs"));
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
								}
								{
									final String _tagName = "jobs_type";
									final double _tagValue = jobs_type_xpbottle;
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
								}
							} else {
								main.addProperty(("xp_" + jobs_string), (xp_receive * main.get("multi_exp").getAsDouble() + main.get(("xp_" + jobs_string)).getAsDouble()));
							}
							PalamodMod.LOGGER.info("M4");
							main.addProperty(("xpstreak_" + jobs_string), (xp_receive * main.get("multi_exp").getAsDouble() + main.get(("xpstreak_" + jobs_string)).getAsDouble()));
							main.addProperty(("xpstreak_time_" + jobs_string), (world.dayTime() + 80));
							if (entity instanceof Player _player && !_player.level().isClientSide())
								_player.displayClientMessage(Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + ""
										+ (xp_receive * main.get("multi_exp").getAsDouble() + main.get(("xpstreak_" + jobs_string)).getAsDouble()) + Component.translatable("palamod.procedure.jobswin2craft").getString() + " "
										+ Component.translatable(((BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString()).replace("minecraft:", ("" + entity).contains("palamod") ? "entity.palamod." : "entity.minecraft."))).getString())),
										true);
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
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;

import net.neoforged.neoforge.event.level.block.BreakBlockEvent;
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
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@EventBusSubscriber
public class JobsminerbreakblockProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BreakBlockEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		boolean money_getadd = false;
		boolean breakblock_logic = false;
		File jobs = new File("");
		File money = new File("");
		File cache = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject money_main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject cache_main = new com.google.gson.JsonObject();
		double money_add = 0;
		double xp_bloc = 0;
		if (!(world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(PalamodModGameRules.DISABLEJOBSGAMERULE.get()))) {
			jobs = ReadjobsserverProcedure.execute(entity);
			money = ReadMoneyFileProcedure.execute(entity);
			cache = ReadcacheProcedure.execute(entity);
			RecalcJobsXpBaseMultiplierProcedure.execute(world, entity);
			if (jobs.exists() && !(entity instanceof Player _plr2 && _plr2.gameMode() == GameType.CREATIVE) && money.exists()) {
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
						if (world.getGameTime() > main.get("xpstreak_time_miner").getAsDouble()) {
							main.addProperty("xpstreak_miner", 0);
						}
						if (GetxpminerbreakblocklogicProcedure.execute(world, x, y, z, entity)) {
							xp_bloc = GetxpminerbreakblockProcedure.execute(entity);
							if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
									.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, Identifier.parse("palamod:botteled")))) != 0
									&& (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("jobs_type", 0)
											|| 1 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("jobs_type", 0))
									&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.XP_BOTTLE.get()) {
								{
									final String _tagName = "xp_jobs";
									final double _tagValue = (xp_bloc * main.get("multi_exp").getAsDouble()
											+ (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("xp_jobs", 0));
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
								}
								{
									final String _tagName = "jobs_type";
									final double _tagValue = 1;
									CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY), tag -> tag.putDouble(_tagName, _tagValue));
								}
							} else {
								main.addProperty("xp_miner", (xp_bloc * main.get("multi_exp").getAsDouble() + main.get("xp_miner").getAsDouble()));
							}
							main.addProperty("xpstreak_miner", (xp_bloc * main.get("multi_exp").getAsDouble() + main.get("xpstreak_miner").getAsDouble()));
							main.addProperty("xpstreak_time_miner", (world.getGameTime() + 80));
							if (entity instanceof ServerPlayer _player)
								_player.sendSystemMessage(Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + "" + (xp_bloc * main.get("multi_exp").getAsDouble() + main.get("xpstreak_miner").getAsDouble())
										+ Component.translatable("palamod.procedure.jobswin2").getString() + " " + Component.translatable(((BuiltInRegistries.BLOCK.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString())
												.replace("minecraft:", (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(Identifier.parse("palamod:palablocks"))) ? "block.palamod." : "block.minecraft."))).getString())),
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
				ChecklvlminerProcedure.execute(world, x, y, z, entity);
			}
		}
	}
}
package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModEnchantments;

import palamod.PalamodMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.level.BlockEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@Mod.EventBusSubscriber
public class JobsalchibreakblockProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject money_main = new com.google.gson.JsonObject();
		File jobs = new File("");
		File money = new File("");
		double money_add = 0;
		boolean money_getadd = false;
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
					if (world.dayTime() > main.get("xpstreak_time_alchi").getAsDouble()) {
						main.addProperty("xpstreak_alchi", 0);
					}
					if (GetalchibreakblocklogicProcedure.execute(world, x, y, z, entity)) {
						if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BOTTELED.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
								&& (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("jobs_type")
										|| 4 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("jobs_type"))
								&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.XPBOTTLE.get()) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("xp_jobs",
									(GetxpalchibreakblockProcedure.execute(world, x, y, z, entity) * main.get("multi_exp").getAsDouble()
											+ (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("xp_jobs")));
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("jobs_type", 4);
						} else {
							main.addProperty("xp_alchi", (GetxpalchibreakblockProcedure.execute(world, x, y, z, entity) * main.get("multi_exp").getAsDouble() + main.get("xp_alchi").getAsDouble()));
						}
						main.addProperty("xpstreak_alchi", (GetxpalchibreakblockProcedure.execute(world, x, y, z, entity) * main.get("multi_exp").getAsDouble() + main.get("xpstreak_alchi").getAsDouble()));
						main.addProperty("xpstreak_time_alchi", (world.dayTime() + 80));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + ""
											+ (GetxpalchibreakblockProcedure.execute(world, x, y, z, entity) * main.get("multi_exp").getAsDouble() + main.get("xpstreak_alchi").getAsDouble())
											+ Component.translatable("palamod.procedure.jobswin2").getString() + " " + Component.translatable(((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString())
													.replace("minecraft:", (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("palamod:palablocks"))) ? "block.palamod." : "block.minecraft."))).getString())),
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
			PalamodMod.LOGGER.debug("Debug : checking alchimist lvl");
			if (main.get("next_level_alchi").getAsDouble() <= main.get("xp_alchi").getAsDouble()) {
				main.addProperty("lvl_alchi", (1 + main.get("lvl_alchi").getAsDouble()));
				main.addProperty("xp_alchi", (main.get("xp_alchi").getAsDouble() - main.get("next_level_alchi").getAsDouble()));
				main.addProperty("next_level_alchi", GetnextlevelxpalchiProcedure.execute(entity));
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
					_setstack.setCount((int) (1 + Math.floor(main.get("lvl_alchi").getAsDouble() / 2)));
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.TRIXIUM.get()).copy();
					_setstack.setCount((int) main.get("lvl_alchi").getAsDouble());
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" " + "" + Component.translatable("palamod.procedure.jobswinlvl_miner1").getString() + " \\n "
									+ Component.translatable("palamod.procedure.jobswinlvl_miner2").getString() + " " + Math.round(main.get("lvl_alchi").getAsDouble()) + "," + Component.translatable("palamod.procedure.jobswinlvl_miner3").getString()
									+ " " + Math.round(1000) + "$\",\"color\":\"gold\"}]"));
				money_getadd = true;
				money_add = 2 * (main.get("lvl_alchi").getAsDouble() + 1);
			}
			if (money_getadd) {
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(money));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						money_main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						money_main.addProperty("money", (money_main.get("money").getAsDouble() + money_add));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(money);
						fileWriter.write(mainGSONBuilderVariable.toJson(money_main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}
}

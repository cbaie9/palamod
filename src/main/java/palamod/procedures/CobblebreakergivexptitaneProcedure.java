package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModEnchantments;

import palamod.PalamodMod;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.items.ItemHandlerHelper;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.concurrent.atomic.AtomicInteger;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class CobblebreakergivexptitaneProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double lvl = 0;
		double money_add = 0;
		File jobs = new File("");
		File money = new File("");
		boolean money_getadd = false;
		if (entity instanceof Player _player)
			_player.giveExperiencePoints(new Object() {
				public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
					AtomicInteger _retval = new AtomicInteger(0);
					BlockEntity _ent = world.getBlockEntity(pos);
					if (_ent != null)
						_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
					return _retval.get();
				}
			}.getAmount(world, BlockPos.containing(x, y, z), 5));
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
					lvl = main.get("lvl_miner").getAsDouble();
					if (25 <= lvl) {
						if (world.dayTime() > main.get("xpstreak_time_miner").getAsDouble()) {
							main.addProperty("xpstreak_miner", 0);
						}
						if (EnchantmentHelper.getItemEnchantmentLevel(PalamodModEnchantments.BOTTELED.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0
								&& (0 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("jobs_type")
										|| 1 == (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("jobs_type"))
								&& (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.XPBOTTLE.get()) {
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("xp_jobs",
									(8 * main.get("multi_exp").getAsDouble() + (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("xp_jobs")));
							(entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getOrCreateTag().putDouble("jobs_type", 1);
						} else {
							main.addProperty("xp_miner", (16 * main.get("multi_exp").getAsDouble() + main.get("xp_miner").getAsDouble()));
						}
						main.addProperty("xpstreak_miner", (16 * main.get("multi_exp").getAsDouble() + main.get("xpstreak_miner").getAsDouble()));
						main.addProperty("xpstreak_time_miner", (world.dayTime() + 80));
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(
									Component.literal((Component.translatable("palamod.procedure.jobswin1").getString() + "" + (16 * main.get("multi_exp").getAsDouble() + main.get("xpstreak_miner").getAsDouble())
											+ Component.translatable("palamod.procedure.jobswin2").getString() + " " + Component.translatable(((ForgeRegistries.BLOCKS.getKey((world.getBlockState(BlockPos.containing(x, y, z))).getBlock()).toString())
													.replace("minecraft:", (world.getBlockState(BlockPos.containing(x, y, z))).is(BlockTags.create(new ResourceLocation("palamod:palablocks"))) ? "block.palamod." : "block.minecraft."))).getString())),
									true);
					}
					PalamodMod.LOGGER.debug("Debug : checking miner lvl");
					if (main.get("next_level_miner").getAsDouble() <= main.get("xp_miner").getAsDouble()) {
						main.addProperty("lvl_miner", (1 + main.get("lvl_miner").getAsDouble()));
						main.addProperty("xp_miner", (main.get("xp_miner").getAsDouble() - main.get("next_level_miner").getAsDouble()));
						main.addProperty("next_level_miner", GetnextlevelxpProcedure.execute(entity));
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
							_setstack.setCount((int) (1 + Math.floor(main.get("lvl_miner").getAsDouble() / 2)));
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TRIXIUM.get()).copy();
							_setstack.setCount((int) main.get("lvl_miner").getAsDouble());
							ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
						}
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									("tellraw @p [\"\",{\"text\":\"[ Palamod ] :\",\"color\":\"dark_red\"},{\"text\":\" " + "" + Component.translatable("palamod.procedure.jobswinlvl_miner1").getString() + " \\n "
											+ Component.translatable("palamod.procedure.jobswinlvl_miner2").getString() + " " + Math.round(main.get("lvl_miner").getAsDouble()) + ","
											+ Component.translatable("palamod.procedure.jobswinlvl_miner3").getString() + " " + Math.round(1000) + "$\",\"color\":\"gold\"}]"));
						money_getadd = true;
						money_add = 2 * (main.get("lvl_miner").getAsDouble() + 1);
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
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(money));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (money_getadd) {
						main.addProperty("money", (main.get("money").getAsDouble() + money_add));
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(money);
					fileWriter.write(mainGSONBuilderVariable.toJson(main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		}
	}
}

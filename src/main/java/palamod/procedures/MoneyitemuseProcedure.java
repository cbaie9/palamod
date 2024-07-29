package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.item.ItemTossEvent;

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

import javax.annotation.Nullable;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

@Mod.EventBusSubscriber
public class MoneyitemuseProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main_money = new com.google.gson.JsonObject();
		File money = new File("");
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (money.exists()) {
			if (PalamodModItems.MONEY_ITEM.get() == itemstack.getItem() || PalamodModItems.MONEY_1K.get() == itemstack.getItem()) {
				if (itemstack.getOrCreateTag().getBoolean("Is_pname")) {
					if ((itemstack.getOrCreateTag().getString("Money_spename")).equals(entity.getDisplayName().getString())) {
						if (itemstack.getOrCreateTag().getBoolean("destri_money")) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = itemstack;
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
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
								main_money = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
								main_money.addProperty("money", (itemstack.getOrCreateTag().getDouble("Money_amount") + main_money.get("money").getAsDouble()));
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
					} else {
						if (entity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("wrong player"), false);
					}
				} else {
					if (itemstack.getOrCreateTag().getBoolean("destri_money")) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"kill @e[limit=1,sort=nearest,distance=1..5,type=item]");
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
							main_money = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
							main_money.addProperty("money", (itemstack.getOrCreateTag().getDouble("Money_amount") + main_money.get("money").getAsDouble()));
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
}

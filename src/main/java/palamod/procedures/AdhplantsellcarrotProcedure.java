package palamod.procedures;

import palamod.PalamodMod;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.fml.loading.FMLPaths;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.components.EditBox;

import java.util.concurrent.atomic.AtomicReference;
import java.util.HashMap;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class AdhplantsellcarrotProcedure {
	public static void execute(LevelAccessor world, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		ItemStack item = ItemStack.EMPTY;
		double fac_v = 0;
		double n = 0;
		double n2 = 0;
		File money = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		fac_v = 0.5;
		item = new ItemStack(Items.CARROT);
		n = Math.round(Math.abs(new Object() {
			double convert(String s) {
				try {
					return Double.parseDouble(s.trim());
				} catch (Exception e) {
				}
				return 0;
			}
		}.convert(guistate.containsKey("text:number_buy") ? ((EditBox) guistate.get("text:number_buy")).getValue() : "")));
		main = new Object() {
			public com.google.gson.JsonObject parse(String rawJson) {
				try {
					return new com.google.gson.Gson().fromJson(rawJson, com.google.gson.JsonObject.class);
				} catch (Exception e) {
					PalamodMod.LOGGER.error(e);
					return new com.google.gson.Gson().fromJson("{}", com.google.gson.JsonObject.class);
				}
			}
		}.parse("{}");
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
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
				if (n == 0) {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You can't sell 0 item"), false);
				}
				{
					AtomicReference<IItemHandler> _iitemhandlerref = new AtomicReference<>();
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(_iitemhandlerref::set);
					if (_iitemhandlerref.get() != null) {
						for (int _idx = 0; _idx < _iitemhandlerref.get().getSlots(); _idx++) {
							ItemStack itemstackiterator = _iitemhandlerref.get().getStackInSlot(_idx).copy();
							if (itemstackiterator.getItem() == item.getItem()) {
								n2 = n2 + itemstackiterator.getCount();
							}
						}
					}
				}
				if ((guistate.containsKey("text:number_buy") ? ((EditBox) guistate.get("text:number_buy")).getValue() : "").equals("max")) {
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = item;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) n2, _player.inventoryMenu.getCraftSlots());
					}
					main.addProperty("money", (main.get("money").getAsDouble() + n2 * fac_v));
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You sell " + n2 + " items")), false);
				} else if (n <= n2) {
					main.addProperty("money", (main.get("money").getAsDouble() + n * fac_v));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = item;
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), (int) n, _player.inventoryMenu.getCraftSlots());
					}
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(("You sell " + n + " items")), false);
				} else {
					if (entity instanceof Player _player)
						_player.closeContainer();
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("You don't enough items to sell ( number too big )"), false);
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

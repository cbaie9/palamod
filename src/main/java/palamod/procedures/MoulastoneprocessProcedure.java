package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class MoulastoneprocessProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		File jobs = new File("");
		File money = new File("");
		double count = 0;
		double lvl = 0;
		double money_old = 0;
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
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
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					money_old = main.get("money").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBoolean("powered") == true) {
				for (int index0 = 0; index0 < 64; index0++) {
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.DEEPSLATE)) : false) {
						count = count + 0.15;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.DEEPSLATE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.COBBLED_DEEPSLATE)) : false) {
						count = count + 0.1;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.COBBLED_DEEPSLATE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.STONE)) : false) {
						count = count + 0.15;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.STONE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.COBBLESTONE)) : false) {
						count = count + 0.1;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.COBBLESTONE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.GRANITE)) : false) {
						count = count + 0.125;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.GRANITE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.DIORITE)) : false) {
						count = count + 0.125;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.DIORITE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.ANDESITE)) : false) {
						count = count + 0.125;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.ANDESITE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BLACKSTONE)) : false) {
						count = count + 0.5;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.BLACKSTONE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BASALT)) : false) {
						count = count + 0.5;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.BASALT);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.NETHERRACK)) : false) {
						count = count + 0.125;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.NETHERRACK);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.SOUL_SOIL)) : false) {
						count = count + 0.5;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.SOUL_SOIL);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.SOUL_SAND)) : false) {
						count = count + 0.5;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.SOUL_SAND);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.STONE)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.COBBLESTONE)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.GRANITE)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.DIORITE)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.ANDESITE)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BLACKSTONE)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BASALT)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.COBBLED_DEEPSLATE)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.DEEPSLATE)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.SOUL_SAND)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.SOUL_SOIL)) : false)
							|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.NETHERRACK)) : false)) {
						continue;
					} else {
						break;
					}
				}
				main.addProperty("money", (money_old + count));
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
}

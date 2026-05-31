package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.Permissions;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class PalakitprocessProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		File money = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		boolean write = false;
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (money.isFile()) {
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
					if (entity.getPersistentData().getBooleanOr("take_palakit", false) == false || hasEntityPermissionLevel(entity, 2)) {
						main.addProperty("money", (main.get("money").getAsDouble() + 500));
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_ARMOR_HELMET.get()).copy();
							_setstack.setCount(1);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_ARMOR_CHESTPLATE.get()).copy();
							_setstack.setCount(1);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_ARMOR_LEGGINGS.get()).copy();
							_setstack.setCount(1);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_ARMOR_BOOTS.get()).copy();
							_setstack.setCount(1);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_PICKAXE.get()).copy();
							_setstack.setCount(1);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(Items.COOKED_BEEF).copy();
							_setstack.setCount(64);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(Blocks.OAK_LOG).copy();
							_setstack.setCount(20);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
						entity.getPersistentData().putBoolean("take_palakit", true);
						write = true;
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (write) {
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
		} else {
			if (entity.getPersistentData().getBooleanOr("take_palakit", false) == false || hasEntityPermissionLevel(entity, 2)) {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_ARMOR_HELMET.get()).copy();
					_setstack.setCount(1);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_ARMOR_CHESTPLATE.get()).copy();
					_setstack.setCount(1);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_ARMOR_LEGGINGS.get()).copy();
					_setstack.setCount(1);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.AMETHYST_ARMOR_BOOTS.get()).copy();
					_setstack.setCount(1);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.TITANE_PICKAXE.get()).copy();
					_setstack.setCount(1);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Items.COOKED_BEEF).copy();
					_setstack.setCount(64);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(Blocks.OAK_LOG).copy();
					_setstack.setCount(20);
					_player.getInventory().placeItemBackInInventory(_setstack);
				}
				entity.getPersistentData().putBoolean("take_palakit", true);
			}
		}
	}

	private static boolean hasEntityPermissionLevel(Entity entity, int permissionLevel) {
		if (entity instanceof Player _player) {
			return switch (permissionLevel) {
				case 0 -> true;
				case 1 -> _player.permissions().hasPermission(Permissions.COMMANDS_MODERATOR);
				case 2 -> _player.permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER);
				case 3 -> _player.permissions().hasPermission(Permissions.COMMANDS_ADMIN);
				default -> _player.permissions().hasPermission(Permissions.COMMANDS_OWNER);
			};
		}
		return false;
	}
}
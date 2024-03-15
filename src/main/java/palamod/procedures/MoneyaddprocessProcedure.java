package palamod.procedures;

import palamod.world.inventory.Palaerror0005Menu;

import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import io.netty.buffer.Unpooled;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

public class MoneyaddprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		File money = new File("");
		com.google.gson.JsonObject money_main = new com.google.gson.JsonObject();
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + ((new Object() {
			public Entity getEntity() {
				try {
					return EntityArgument.getEntity(arguments, "player");
				} catch (CommandSyntaxException e) {
					e.printStackTrace();
					return null;
				}
			}
		}.getEntity()).getUUID().toString() + ".json"));
		if (entity.hasPermissions(4)) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(money));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					money_main = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (entity instanceof Player _player)
						_player.closeContainer();
					money_main.addProperty("money", (DoubleArgumentType.getDouble(arguments, "money") + money_main.get("money").getAsDouble()));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
				try {
					FileWriter fileWriter = new FileWriter(money);
					fileWriter.write(mainGSONBuilderVariable.toJson(money_main));
					fileWriter.close();
				} catch (IOException exception) {
					exception.printStackTrace();
				}
			}
		} else {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("Palaerror0005");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new Palaerror0005Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}

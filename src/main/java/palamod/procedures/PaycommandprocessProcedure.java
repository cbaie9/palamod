package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class PaycommandprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main_p1 = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_p2 = new com.google.gson.JsonObject();
		File money_p1 = new File("");
		File money_p2 = new File("");
		double money_count_p1 = 0;
		double money_count_p2 = 0;
		if (!(world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().getBoolean(PalamodModGameRules.DISABLEMONEYGAMERULE))) {
			if (!((null) == (commandParameterEntity(arguments, "player2")))) {
				money_p1 = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
				money_p2 = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + ((commandParameterEntity(arguments, "player2")).getUUID().toString() + ".json"));
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(money_p1));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main_p1 = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						money_count_p1 = main_p1.get("money").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				{
					try {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(money_p2));
						StringBuilder jsonstringbuilder = new StringBuilder();
						String line;
						while ((line = bufferedReader.readLine()) != null) {
							jsonstringbuilder.append(line);
						}
						bufferedReader.close();
						main_p2 = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
						money_count_p2 = main_p2.get("money").getAsDouble();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if (money_count_p1 >= DoubleArgumentType.getDouble(arguments, "amount")) {
					main_p1.addProperty("money", (money_count_p1 - DoubleArgumentType.getDouble(arguments, "amount")));
					main_p2.addProperty("money", (money_count_p2 + DoubleArgumentType.getDouble(arguments, "amount")));
					{
						com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
						try {
							FileWriter fileWriter = new FileWriter(money_p1);
							fileWriter.write(mainGSONBuilderVariable.toJson(main_p1));
							fileWriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
					{
						com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
						try {
							FileWriter fileWriter = new FileWriter(money_p2);
							fileWriter.write(mainGSONBuilderVariable.toJson(main_p2));
							fileWriter.close();
						} catch (IOException exception) {
							exception.printStackTrace();
						}
					}
					MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.pay1").getString() + "" + DoubleArgumentType.getDouble(arguments, "amount") + "$ "
							+ Component.translatable("palamod.procedure.pay2").getString() + " " + (commandParameterEntity(arguments, "player2")).getDisplayName().getString());
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								("tellraw " + commandParameterEntity(arguments, "player2") + " {\"text\":\"" + Component.translatable("palamod.procedure.pay3").getString() + " " + DoubleArgumentType.getDouble(arguments, "amount") + "$ "
										+ Component.translatable("palamod.procedure.pay4").getString() + entity + ", " + Component.translatable("palamod.procedure.pay5").getString() + " " + StringArgumentType.getString(arguments, "reason")
										+ "\",\"color\":\"green\"}"));
				} else {
					MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.pay_not_enough_money").getString());
				}
			} else {
				MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.pay_entity_null").getString());
			}
		} else {
			MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.gamerule_disable_money").getString());
		}
	}

	private static Entity commandParameterEntity(CommandContext<CommandSourceStack> arguments, String parameter) {
		try {
			return EntityArgument.getEntity(arguments, parameter);
		} catch (CommandSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}
}
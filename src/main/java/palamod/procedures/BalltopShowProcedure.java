package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class BalltopShowProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double money_amount = 0;
		File money = new File("");
		File balltop = new File("");
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject money_main = new com.google.gson.JsonObject();
		balltop = ReadBalltopProcedure.execute();
		money = ReadMoneyFileProcedure.execute(entity);
		if (!(world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(PalamodModGameRules.DISABLEMONEYGAMERULE.get())) || balltop.exists() || money.exists()) {
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
					money_amount = money_main.get("money").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(balltop));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								(((((((((((((((((("tellraw @p [\"\",{\"text\":\"[ Palamod ] : Balltop\\n\"},{\"text\":\"--------------------------------\",\"color\":\"dark_green\"},{\"text\":\"\\n%i1 | \"},{\"text\":\"%1 : %2\",\"color\":\"gold\"},{\"text\":\"\\n%i2 | \"},{\"text\":\"%3 : %4\",\"color\":\"gold\"},{\"text\":\"\\n\"},{\"text\":\"%i3 |\",\"color\":\"white\"},{\"text\":\" %5 : %6\",\"color\":\"gold\"},{\"text\":\"\\n%i4 | \"},{\"text\":\"%7 : %8\",\"color\":\"gold\"},{\"text\":\"\\n%i5 | \"},{\"text\":\"%9 : %a\",\"color\":\"gold\"},{\"text\":\"\\n\\n\"},{\"text\":\"%b : %c  %d \",\"color\":\"blue\"},{\"text\":\"\\n\"},{\"text\":\"--------------------------------\",\"color\":\"dark_green\"}]"
										.replace("%i5", Component.translatable("palamod.procedure.balltop.5rd").getString())).replace("%i4", Component.translatable("palamod.procedure.balltop.4rd").getString()))
										.replace("%i3", Component.translatable("palamod.procedure.balltop.3rd").getString())).replace("%i2", Component.translatable("palamod.procedure.balltop.2nd").getString()))
										.replace("%i1", Component.translatable("palamod.procedure.balltop.1st").getString()))
										.replace("%d", 100 * (money_amount / (0 == main.get("n1money").getAsDouble() ? main.get("n1money").getAsDouble() + 0.01 : main.get("n1money").getAsDouble())) + "%")).replace("%c", "" + money_amount))
										.replace("%b", entity.getDisplayName().getString())).replace("%a", "" + main.get("n5money").getAsDouble())).replace("%9", main.get("n5player").getAsString()))
										.replace("%8", "" + main.get("n4money").getAsDouble())).replace("%7", main.get("n4player").getAsString())).replace("%6", "" + main.get("n3money").getAsDouble()))
										.replace("%5", main.get("n3player").getAsString())).replace("%4", "" + main.get("n2money").getAsDouble())).replace("%3", main.get("n2player").getAsString()))
										.replace("%2", "" + main.get("n1money").getAsDouble())).replace("%1", main.get("n1player").getAsString())));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
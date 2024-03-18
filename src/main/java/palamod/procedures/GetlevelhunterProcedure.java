package palamod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

public class GetlevelhunterProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		double lvl = 0;
		File jobs = new File("");
		com.google.gson.JsonObject jobs_main = new com.google.gson.JsonObject();
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/jobs/"), File.separator + (entity.getUUID().toString() + ".json"));
		{
			try {
				BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
				StringBuilder jsonstringbuilder = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jsonstringbuilder.append(line);
				}
				bufferedReader.close();
				jobs_main = new Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
				lvl = jobs_main.get("lvl_hunter").getAsDouble();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return Component.translatable("palamod.procedure.jobsgetlvl").getString() + "" + Math.round(lvl);
	}
}

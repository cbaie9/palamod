package palamod.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class JobsminerbreakblockProcedure {
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
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == Blocks.STONE) {
					jobs_main.addProperty("xp_miner", (0.5 + jobs_main.get("xp_miner").getAsDouble()));
					jobs_main.addProperty("xpstreak_miner", (0.5 + jobs_main.get("xpstreak_miner").getAsDouble()));
					jobs_main.addProperty("xpstreak_time_miner", 80);
					if (entity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal(
								(Component.translatable("palamod.procedure.jobswin1").getString() + "" + (0.5 + jobs_main.get("xpstreak_miner").getAsDouble()) + Component.translatable("palamod.procedure.jobswin2").getString() + " " + Blocks.STONE)),
								true);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		{
			Gson mainGSONBuilderVariable = new GsonBuilder().setPrettyPrinting().create();
			try {
				FileWriter fileWriter = new FileWriter(jobs);
				fileWriter.write(mainGSONBuilderVariable.toJson(jobs_main));
				fileWriter.close();
			} catch (IOException exception) {
				exception.printStackTrace();
			}
		}
	}
}

package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

import palamod.init.PalamodModGameRules;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JobCraftRestrictionManagerProcedure {

    private static final File CONFIG_FILE = new File("config/palamod_jobs.json");
    private static final Map<String, JsonObject> CACHE = new HashMap<>();
    private static boolean loaded = false;

    // Chargement unique ou reload
    public static void loadConfig() {
        try {
            if (!CONFIG_FILE.exists()) {
                CONFIG_FILE.getParentFile().mkdirs();
                String defaultJson = """
                {
                  "minecraft:diamond_pickaxe": {
                    "miner": 10
                  }
                }
                """;
                Files.write(CONFIG_FILE.toPath(), defaultJson.getBytes());
            }

            JsonObject json = JsonParser.parseReader(new FileReader(CONFIG_FILE)).getAsJsonObject();
            CACHE.clear(); // Vide l'ancien cache si reload
            for (String key : json.keySet()) {
                CACHE.put(key, json.getAsJsonObject(key));
            }

            loaded = true;
            System.out.println("[Palamod] Job config loaded successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean canCraft(LevelAccessor world, double x, double y, double z,
                                   Player player, ItemStack stack) {

        if (player == null || stack == null || stack.isEmpty())
            return true;

        // Gamerule check
        if (world.getLevelData().getGameRules()
                .getBoolean(PalamodModGameRules.DISABLEJOBSGAMERULE)) {
            return true;
        }

        // Charge le fichier UNE SEULE FOIS
        if (!loaded) loadConfig();

        String itemId = stack.getItem()
                .builtInRegistryHolder()
                .key()
                .location()
                .toString();

        if (!CACHE.containsKey(itemId))
            return true;

        JsonObject jobData = CACHE.get(itemId);

        for (String jobName : jobData.keySet()) {

            int requiredLevel = jobData.get(jobName).getAsInt();
            double playerLevel = GetleveljobsProcedure.execute(player, jobName);

            if (playerLevel < requiredLevel) {

                MsgtellrawautosendProcedure.execute(
                        world,
                        x,
                        y,
                        z,
                        "Vous devez être niveau "
                                + requiredLevel
                                + " en "
                                + jobName
                                + " pour crafter cet item !"
                );

                return false;
            }
        }

        return true;
    }

    // Méthode publique reload pour la commande /reload
    public static void reload() {
        loadConfig();
        System.out.println("[Palamod] : Job craft config rechargée !");
    }
}
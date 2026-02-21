package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

import java.io.File;
import java.io.FileReader;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JobCraftRestrictionManagerProcedure {

    public static boolean canCraft(LevelAccessor world, double x, double y, double z,
                                   Player player, ItemStack stack) {

        if (player == null || stack == null || stack.isEmpty())
            return true;

        try {
            // Fichier config automatique
            File file = new File("config/palamod_jobs.json");

            if (!file.exists())
                return true;

            JsonObject json = JsonParser.parseReader(new FileReader(file)).getAsJsonObject();

            // Récupère l'ID moderne 1.21
            String itemId = stack.getItem()
                    .builtInRegistryHolder()
                    .key()
                    .location()
                    .toString();

            if (!json.has(itemId))
                return true;

            JsonObject jobData = json.getAsJsonObject(itemId);

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
                                    + " pour crafter cet item ! (Votre niveau : "
                                    + (int) playerLevel
                                    + ")"
                    );

                    return false;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return true;
    }
}
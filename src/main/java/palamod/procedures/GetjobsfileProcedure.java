package palamod.procedures;

import palamod.PalamodMod;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import java.io.File;

public class GetjobsfileProcedure {
    public static File execute(LevelAccessor world, double x, double y, double z, Entity entity) {
        if (entity == null)
            return new File("");
        
        File output = new File("");
        
        try {
            if (world.isClientSide()) {
                // Côté client
                output = ReadjobsclientProcedure.execute(world, entity);
                PalamodMod.LOGGER.debug("Palamod: Reading client side jobs file");
            } else {
                // Côté serveur
                output = ReadjobsserverProcedure.execute(entity);
                PalamodMod.LOGGER.debug("Palamod: Reading server side jobs file");
            }
        } catch (Exception e) {
            PalamodMod.LOGGER.error("Palamod ERROR: Failed to get jobs file - " + e.getMessage());
            // Retourner un fichier par défaut plutôt que de crasher
            output = new File("palamod_jobs/backup_" + entity.getUUID().toString() + ".json");
        }
        
        return output;
    }
}
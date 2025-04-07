package palamod.procedures;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.fml.loading.FMLPaths;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

@EventBusSubscriber
public class BackpackdropdeathProcedure {
    @SubscribeEvent
    public static void onPlayerRespawned(PlayerEvent.PlayerRespawnEvent event) {
        execute(event, event.getEntity().level(), event.getEntity());
    }

    public static void execute(LevelAccessor world, Entity entity) {
        execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        
        String[] paths = new String[5];
        if (IsgameclientsideProcedure.execute()) {
            String worldName = world.isClientSide() ? 
                Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : 
                ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName();
            String basePath = FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + worldName + "\\backpack\\" + entity.getUUID().toString() + "\\";
            
            paths[0] = basePath + "backpack_1.json";
            paths[1] = basePath + "backpack_2.json";
            paths[2] = basePath + "backpack_3.json";
            paths[3] = basePath + "backpack_4.json";
            paths[4] = basePath + "backup.json";

            // Suppression des fichiers
            for (String path : paths) {
                try {
                    Path filePath = Paths.get(path);
                    if (Files.exists(filePath)) {
                        Files.delete(filePath);
                        System.out.println("Fichier supprimé: " + path); // Log pour débogage
                    }
                } catch (IOException e) {
                    System.err.println("Erreur lors de la suppression du fichier " + path + ": " + e.getMessage());
                }
            }
        }
    }
}
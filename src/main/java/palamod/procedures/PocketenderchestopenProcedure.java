package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.Entity; // Import pour Entity

public class PocketenderchestopenProcedure {
    public static void execute(Entity entity) {
        // On vérifie si l'entité qui a déclenché est un joueur sur le serveur
        if (entity instanceof ServerPlayer) {
            // On convertit l'entité générique en un objet Player pour accéder à ses fonctions
            Player player = (Player) entity;

            // On ouvre le menu du coffre du joueur
            player.openMenu(new SimpleMenuProvider(
                (id, inventory, p) -> ChestMenu.threeRows(id, inventory, player.getEnderChestInventory()),
                player.getDisplayName()
            ));
        }
    }
}
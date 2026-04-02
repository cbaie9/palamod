package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelAccessor;

public class JobCraftRestrictionProcedure {

    /**
     * Vérifie si le joueur peut crafter un item selon son job et son niveau.
     * @param world Le monde
     * @param x coordonnée X
     * @param y coordonnée Y
     * @param z coordonnée Z
     * @param player Le joueur
     * @param requiredJob Le job requis pour ce craft ("miner", "farmer", "hunter", "alchi")
     * @param requiredLevel Le niveau minimum requis
     * @return true si le joueur peut crafter, false sinon
     */
    public static boolean canCraft(LevelAccessor world, double x, double y, double z, Player player, String requiredJob, int requiredLevel) {
        if (player == null || requiredJob == null) return false;

        double playerLevel = GetleveljobsProcedure.execute(player, requiredJob);

        if (playerLevel < requiredLevel) {
            // Envoie un message d'avertissement au joueur
            MsgtellrawautosendProcedure.execute(world, x, y, z,
                    "Vous devez être niveau " + requiredLevel + " en " + requiredJob + " pour crafter cet item ! (Votre niveau : " + (playerLevel >= 0 ? (int)playerLevel : "aucun") + ")");
            return false; // Craft interdit
        }

        return true; // Craft autorisé
    }
}
package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.network.chat.Component;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.inventory.ChestMenu;

public class PocketenderchestopenProcedure {
    public static void execute(Level level, Player player) {
        if (player == null || level == null) return;

        if (!level.isClientSide()) {
            player.openMenu(new SimpleMenuProvider(
                    (id, inv, p) -> ChestMenu.threeRows(id, inv, p.getEnderChestInventory()),
                    Component.translatable("container.enderchest")));
        }
    }
}
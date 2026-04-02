package palamod.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.CraftingMenu;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;

public class OpenCraftingTableProcedure {

    public static void execute(LevelAccessor world, double x, double y, double z, Player player) {
        if (player == null)
            return;

        if (player instanceof ServerPlayer serverPlayer) {

            BlockPos pos = BlockPos.containing(x, y, z);

            MenuProvider provider = new SimpleMenuProvider(
                (id, inventory, p) -> new CraftingMenu(id, inventory),
                Component.translatable("container.crafting")
            );

            serverPlayer.openMenu(provider);
        }
    }
}
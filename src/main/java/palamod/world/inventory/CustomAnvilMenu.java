package palamod.world.inventory;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;

public class CustomAnvilMenu extends AnvilMenu {

    public CustomAnvilMenu(int id, Inventory inventory) {
        super(id, inventory);
    }

    public CustomAnvilMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(id, inventory, access);
    }

    @Override
    public void createResult() {
        super.createResult();

        int cost = this.getCost();

        // 🔹 Supprime la limite 40 (Too Expensive)
        if (cost >= 40) {
            this.setMaximumCost(Integer.MAX_VALUE);
        }

        // 🔹 Réduction de 35%
        int reducedCost = (int) Math.floor(cost * 0.65);

        if (reducedCost < 0) {
            reducedCost = 0;
        }

        this.setMaximumCost(reducedCost);
    }
}
package palamod.world.inventory;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;

import java.lang.reflect.Field;

public class CustomAnvilMenu extends AnvilMenu {

    private DataSlot costAccessor;

    public CustomAnvilMenu(int id, Inventory inventory) {
        super(id, inventory);
        initReflection();
    }

    public CustomAnvilMenu(int id, Inventory inventory, ContainerLevelAccess access) {
        super(id, inventory, access);
        initReflection();
    }

    private void initReflection() {
        try {
            Field costField = AnvilMenu.class.getDeclaredField("cost");
            costField.setAccessible(true);
            this.costAccessor = (DataSlot) costField.get(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void broadcastChanges() {
        super.broadcastChanges();

        if (costAccessor != null) {
            int cost = costAccessor.get();

            if (cost > 0) {
                // 🔹 Réduction de 35%
                int reducedCost = (int) Math.floor(cost * 0.65);

                if (reducedCost < 0) {
                    reducedCost = 0;
                }

                costAccessor.set(reducedCost);
            }
        }
    }
}
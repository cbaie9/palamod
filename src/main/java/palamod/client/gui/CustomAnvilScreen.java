package palamod.client.gui;

import palamod.world.inventory.CustomAnvilMenu;

import net.minecraft.client.gui.screens.inventory.AnvilScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class CustomAnvilScreen extends AnvilScreen {

    public CustomAnvilScreen(CustomAnvilMenu menu, Inventory inventory, Component title) {
        super(menu, inventory, title);
    }

    // 🎨 Tu peux override render() ou renderBg() si tu veux modifier l'affichage
}
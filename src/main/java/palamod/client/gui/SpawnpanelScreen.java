package palamod.client.gui;

import palamod.world.inventory.SpawnpanelMenu;

import palamod.procedures.Spawnpanel_get_spawnProcedure;

import palamod.network.SpawnpanelButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SpawnpanelScreen extends AbstractContainerScreen<SpawnpanelMenu> {
	private final static HashMap<String, Object> guistate = SpawnpanelMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_change_spawn;

	public SpawnpanelScreen(SpawnpanelMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 150;
		this.imageHeight = 100;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/spawnpanel.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 150, 100, 150, 100);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				Spawnpanel_get_spawnProcedure.execute(world), 5, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.spawnpanel.label_spawn_panel"), 46, 2, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_change_spawn = Button.builder(Component.translatable("gui.palamod.spawnpanel.button_change_spawn"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SpawnpanelButtonMessage(0, x, y, z));
				SpawnpanelButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 3, this.topPos + 75, 92, 20).build();
		guistate.put("button:button_change_spawn", button_change_spawn);
		this.addRenderableWidget(button_change_spawn);
	}
}

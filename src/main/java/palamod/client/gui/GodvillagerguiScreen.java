package palamod.client.gui;

import palamod.world.inventory.GodvillagerguiMenu;

import palamod.procedures.ReturnusedtradeclickerProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GodvillagerguiScreen extends AbstractContainerScreen<GodvillagerguiMenu> {
	private final static HashMap<String, Object> guistate = GodvillagerguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GodvillagerguiScreen(GodvillagerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 170;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/godvillagergui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 200, 170, 200, 170);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/arrow_1red_new.png"), this.leftPos + 75, this.topPos + 47, 0, 0, 48, 20, 48, 20);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.godvillagergui.label_god_villager"), 65, 8, -1, false);
		guiGraphics.drawString(this.font,

				ReturnusedtradeclickerProcedure.execute(entity), 153, 23, -1, false);
	}

	@Override
	public void init() {
		super.init();
	}
}

package palamod.client.gui;

import palamod.world.inventory.PaladumfurnaceMenu;

import palamod.procedures.PaladiumfurnacereturntimerProcedure;
import palamod.procedures.PaladiumfurnacereturnsmeltingProcedure;
import palamod.procedures.PaladiumfurnacereturnfuelProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PaladumfurnaceScreen extends AbstractContainerScreen<PaladumfurnaceMenu> {
	private final static HashMap<String, Object> guistate = PaladumfurnaceMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PaladumfurnaceScreen(PaladumfurnaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 180;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palamod:textures/screens/paladumfurnace.png");

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
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.paladumfurnace.label_paladium_furnace"), 43, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.paladumfurnace.label_inventory"), 7, 73, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.paladumfurnace.label_upgrades"), 8, 20, -65536, false);
		guiGraphics.drawString(this.font,

				PaladiumfurnacereturntimerProcedure.execute(world, x, y, z), 90, 66, -12829636, false);
		guiGraphics.drawString(this.font,

				PaladiumfurnacereturnfuelProcedure.execute(world, x, y, z), 89, 27, -12829636, false);
		guiGraphics.drawString(this.font,

				PaladiumfurnacereturnsmeltingProcedure.execute(world, x, y, z), 88, 15, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}

package palamod.client.gui;

import palamod.world.inventory.Palaerror0006Menu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Palaerror0006Screen extends AbstractContainerScreen<Palaerror0006Menu> {
	private final static HashMap<String, Object> guistate = Palaerror0006Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public Palaerror0006Screen(Palaerror0006Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/gui176_166.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palaerror_0006.label_paladium_error_0006"), 39, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palaerror_0006.label_this_part_is_work_in_progress"), 10, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palaerror_0006.label_come_soon_to_have_more"), 27, 52, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palaerror_0006.label_fonction_cb9"), 51, 63, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}

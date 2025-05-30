package palamod.client.gui;

import palamod.world.inventory.FlowertotemguiMenu;

import palamod.procedures.GetspritetimerflowermachineProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FlowertotemguiScreen extends AbstractContainerScreen<FlowertotemguiMenu> {
	private final static HashMap<String, Object> guistate = FlowertotemguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public FlowertotemguiScreen(FlowertotemguiMenu container, Inventory inventory, Component text) {
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
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/flowertotemgui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/arrow_right20.png"), this.leftPos + 74, this.topPos + 36, 0, 0, 16, 14, 16, 14);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/bone_meal.png"), this.leftPos + 26, this.topPos + 34, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/pgbar_jobs.png"), this.leftPos + 15, this.topPos + 69, Mth.clamp((int) GetspritetimerflowermachineProcedure.execute(world, x, y, z) * 145, 0, 14355), 0, 145, 10, 14500, 10);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.flowertotemgui.label_flower_totem"), 3, 3, -65536, false);
	}

	@Override
	public void init() {
		super.init();
	}
}

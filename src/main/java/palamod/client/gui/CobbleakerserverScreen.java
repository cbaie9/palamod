package palamod.client.gui;

import palamod.world.inventory.CobbleakerserverMenu;

import palamod.procedures.CobblebreakerarrowreturnspriteProcedure;

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

public class CobbleakerserverScreen extends AbstractContainerScreen<CobbleakerserverMenu> {
	private final static HashMap<String, Object> guistate = CobbleakerserverMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CobbleakerserverScreen(CobbleakerserverMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 180;
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

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/cobblebreakergui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 180, 176, 180);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/particle_iron.png"), this.leftPos + 18, this.topPos + 53, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/particle_gold.png"), this.leftPos + 39, this.topPos + 53, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/particle_diamond.png"), this.leftPos + 60, this.topPos + 53, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/particle_amethyst.png"), this.leftPos + 81, this.topPos + 53, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/particle_titane.png"), this.leftPos + 102, this.topPos + 53, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/particle_paladium.png"), this.leftPos + 123, this.topPos + 53, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/green_paladium_particle.png"), this.leftPos + 144, this.topPos + 53, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/upgrade_cobblebreaker.png"), this.leftPos + 148, this.topPos + 14, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/arrow_down_sprite16.png"), this.leftPos + 82, this.topPos + 25, Mth.clamp((int) CobblebreakerarrowreturnspriteProcedure.execute(world, x, y, z) * 14, 0, 266), 0, 14, 16, 280,
				16);

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
	}

	@Override
	public void init() {
		super.init();
	}
}

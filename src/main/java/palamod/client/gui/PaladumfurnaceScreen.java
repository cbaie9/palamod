package palamod.client.gui;

import palamod.world.inventory.PaladumfurnaceMenu;

import palamod.procedures.Palafurnacesubprocess9Procedure;
import palamod.procedures.Palafurnacesubprocess8Procedure;
import palamod.procedures.Palafurnacesubprocess7Procedure;
import palamod.procedures.Palafurnacesubprocess6Procedure;
import palamod.procedures.Palafurnacesubprocess5Procedure;
import palamod.procedures.Palafurnacesubprocess4Procedure;
import palamod.procedures.Palafurnacesubprocess3Procedure;
import palamod.procedures.Palafurnacesubprocess2Procedure;
import palamod.procedures.Palafurnacesubprocess1Procedure;
import palamod.procedures.Palafurnacesubprocess18Procedure;
import palamod.procedures.Palafurnacesubprocess17Procedure;
import palamod.procedures.Palafurnacesubprocess16Procedure;
import palamod.procedures.Palafurnacesubprocess15Procedure;
import palamod.procedures.Palafurnacesubprocess14Procedure;
import palamod.procedures.Palafurnacesubprocess13Procedure;
import palamod.procedures.Palafurnacesubprocess12Procedure;
import palamod.procedures.Palafurnacesubprocess11Procedure;
import palamod.procedures.Palafurnacesubprocess10Procedure;
import palamod.procedures.Palafurnacesubprocess0Procedure;
import palamod.procedures.Forgesubprocessfuelremaining9Procedure;
import palamod.procedures.Forgesubprocessfuelremaining8Procedure;
import palamod.procedures.Forgesubprocessfuelremaining7Procedure;
import palamod.procedures.Forgesubprocessfuelremaining6Procedure;
import palamod.procedures.Forgesubprocessfuelremaining5Procedure;
import palamod.procedures.Forgesubprocessfuelremaining4Procedure;
import palamod.procedures.Forgesubprocessfuelremaining3Procedure;
import palamod.procedures.Forgesubprocessfuelremaining2Procedure;
import palamod.procedures.Forgesubprocessfuelremaining10Procedure;

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

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/paladumfurnace.png");

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
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (Palafurnacesubprocess0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_1red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_2red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_3red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_4red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_5red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_6red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_7red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_8red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_9red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_10red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_11red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_12red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_13red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_14red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_15red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_16red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess16Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_17red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess17Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_18red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Palafurnacesubprocess18Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_19red_new.png"), this.leftPos + 85, this.topPos + 43, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessfuelremaining2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_2.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_3.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_4.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_5.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_6.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_7.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_8.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_9.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_10.png"), this.leftPos + 60, this.topPos + 42, 0, 0, 16, 16, 16, 16);
		}
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
	}

	@Override
	public void init() {
		super.init();
	}
}

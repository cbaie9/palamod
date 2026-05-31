package palamod.client.gui;

import palamod.world.inventory.ForgeexampleguiMenu;

import palamod.procedures.*;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class ForgeexampleguiScreen extends AbstractContainerScreen<ForgeexampleguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/forgegui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/arrow_fullred_new.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/arrow_1red_new.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/arrow_2red_new.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/arrow_3red_new.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/arrow_4red_new.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/arrow_5red_new.png");
	private static final Identifier IMAGE_7 = Identifier.parse("palamod:textures/screens/arrow_6red_new.png");
	private static final Identifier IMAGE_8 = Identifier.parse("palamod:textures/screens/arrow_7red_new.png");
	private static final Identifier IMAGE_9 = Identifier.parse("palamod:textures/screens/arrow_8red_new.png");
	private static final Identifier IMAGE_10 = Identifier.parse("palamod:textures/screens/arrow_9red_new.png");
	private static final Identifier IMAGE_11 = Identifier.parse("palamod:textures/screens/arrow_10red_new.png");
	private static final Identifier IMAGE_12 = Identifier.parse("palamod:textures/screens/arrow_11red_new.png");
	private static final Identifier IMAGE_13 = Identifier.parse("palamod:textures/screens/arrow_12red_new.png");
	private static final Identifier IMAGE_14 = Identifier.parse("palamod:textures/screens/arrow_13red_new.png");
	private static final Identifier IMAGE_15 = Identifier.parse("palamod:textures/screens/arrow_14red_new.png");
	private static final Identifier IMAGE_16 = Identifier.parse("palamod:textures/screens/arrow_15red_new.png");
	private static final Identifier IMAGE_17 = Identifier.parse("palamod:textures/screens/arrow_16red_new.png");
	private static final Identifier IMAGE_18 = Identifier.parse("palamod:textures/screens/arrow_17red_new.png");
	private static final Identifier IMAGE_19 = Identifier.parse("palamod:textures/screens/arrow_18red_new.png");
	private static final Identifier IMAGE_20 = Identifier.parse("palamod:textures/screens/arrow_19red_new.png");
	private static final Identifier IMAGE_21 = Identifier.parse("palamod:textures/screens/fire_1.png");
	private static final Identifier IMAGE_22 = Identifier.parse("palamod:textures/screens/fire_2.png");
	private static final Identifier IMAGE_23 = Identifier.parse("palamod:textures/screens/fire_3.png");
	private static final Identifier IMAGE_24 = Identifier.parse("palamod:textures/screens/fire_4.png");
	private static final Identifier IMAGE_25 = Identifier.parse("palamod:textures/screens/fire_5.png");
	private static final Identifier IMAGE_26 = Identifier.parse("palamod:textures/screens/fire_6.png");
	private static final Identifier IMAGE_27 = Identifier.parse("palamod:textures/screens/fire_7.png");
	private static final Identifier IMAGE_28 = Identifier.parse("palamod:textures/screens/fire_8.png");
	private static final Identifier IMAGE_29 = Identifier.parse("palamod:textures/screens/fire_9.png");
	private static final Identifier IMAGE_30 = Identifier.parse("palamod:textures/screens/fire_10.png");

	public ForgeexampleguiScreen(ForgeexampleguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 166);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		if (Forgesubprocessgui1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_7, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_8, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_9, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_10, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_11, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_12, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_13, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_14, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_15, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_16, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_17, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui16Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_18, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui17Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_19, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (Forgesubprocessgui18Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_20, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_21, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		if (Forgesubprocessfuelremaining2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_22, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_23, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_24, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_25, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_26, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_27, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_28, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_29, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (Forgesubprocessfuelremaining10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_30, this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.forgeexamplegui.label_forge"), 71, 3, -13421773, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.forgeexamplegui.label_inventory"), 6, 72, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
package palamod.client.gui;

import palamod.world.inventory.ForgeguiMenu;

import palamod.procedures.*;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

public class ForgeguiScreen extends AbstractContainerScreen<ForgeguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/forgegui.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/arrow_fullred_new.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/arrow_1red_new.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/arrow_2red_new.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/arrow_3red_new.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/arrow_4red_new.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/arrow_5red_new.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("palamod:textures/screens/arrow_6red_new.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("palamod:textures/screens/arrow_7red_new.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("palamod:textures/screens/arrow_8red_new.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("palamod:textures/screens/arrow_9red_new.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("palamod:textures/screens/arrow_10red_new.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("palamod:textures/screens/arrow_11red_new.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("palamod:textures/screens/arrow_12red_new.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("palamod:textures/screens/arrow_13red_new.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("palamod:textures/screens/arrow_14red_new.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("palamod:textures/screens/arrow_15red_new.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("palamod:textures/screens/arrow_16red_new.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("palamod:textures/screens/arrow_17red_new.png");
	private static final ResourceLocation IMAGE_19 = ResourceLocation.parse("palamod:textures/screens/arrow_18red_new.png");
	private static final ResourceLocation IMAGE_20 = ResourceLocation.parse("palamod:textures/screens/arrow_19red_new.png");
	private static final ResourceLocation IMAGE_21 = ResourceLocation.parse("palamod:textures/screens/fire_1.png");
	private static final ResourceLocation IMAGE_22 = ResourceLocation.parse("palamod:textures/screens/fire_2.png");
	private static final ResourceLocation IMAGE_23 = ResourceLocation.parse("palamod:textures/screens/fire_3.png");
	private static final ResourceLocation IMAGE_24 = ResourceLocation.parse("palamod:textures/screens/fire_4.png");
	private static final ResourceLocation IMAGE_25 = ResourceLocation.parse("palamod:textures/screens/fire_5.png");
	private static final ResourceLocation IMAGE_26 = ResourceLocation.parse("palamod:textures/screens/fire_6.png");
	private static final ResourceLocation IMAGE_27 = ResourceLocation.parse("palamod:textures/screens/fire_7.png");
	private static final ResourceLocation IMAGE_28 = ResourceLocation.parse("palamod:textures/screens/fire_8.png");
	private static final ResourceLocation IMAGE_29 = ResourceLocation.parse("palamod:textures/screens/fire_9.png");
	private static final ResourceLocation IMAGE_30 = ResourceLocation.parse("palamod:textures/screens/fire_10.png");

	public ForgeguiScreen(ForgeguiMenu container, Inventory inventory, Component text) {
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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		if (Forgesubprocessgui0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
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
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.forgegui.label_forge"), 71, 3, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.forgegui.label_inventory"), 6, 72, -1, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
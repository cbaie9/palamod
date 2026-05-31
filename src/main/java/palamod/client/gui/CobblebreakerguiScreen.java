package palamod.client.gui;

import palamod.world.inventory.CobblebreakerguiMenu;

import palamod.procedures.CobblebreakerarrowreturnspriteProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class CobblebreakerguiScreen extends AbstractContainerScreen<CobblebreakerguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/cobblebreakergui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/particle_iron.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/particle_gold.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/particle_diamond.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/particle_amethyst.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/particle_titane.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/particle_paladium.png");
	private static final Identifier IMAGE_7 = Identifier.parse("palamod:textures/screens/green_paladium_particle.png");
	private static final Identifier IMAGE_8 = Identifier.parse("palamod:textures/screens/upgrade_cobblebreaker.png");
	private static final Identifier SPRITE_0 = Identifier.parse("palamod:textures/screens/arrow_down_sprite16.png");

	public CobblebreakerguiScreen(CobblebreakerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 180);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 176, 180, 176, 180);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 18, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 39, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 60, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 81, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 102, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 123, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_7, this.leftPos + 144, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_8, this.leftPos + 148, this.topPos + 14, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 82, this.topPos + 25, Mth.clamp((int) CobblebreakerarrowreturnspriteProcedure.execute(world, x, y, z) * 14, 0, 266), 0, 14, 16, 280, 16);
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
	}

	@Override
	public void init() {
		super.init();
	}
}
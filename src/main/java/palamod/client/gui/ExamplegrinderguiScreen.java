package palamod.client.gui;

import palamod.world.inventory.ExamplegrinderguiMenu;

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

public class ExamplegrinderguiScreen extends AbstractContainerScreen<ExamplegrinderguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/grindergui_v4.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/arr0.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/arrow_right_full.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/arrow_1red_new.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/btn-all_off.png");
	private static final Identifier SPRITE_0 = Identifier.parse("palamod:textures/screens/grinder_sprite_full.png");

	public ExamplegrinderguiScreen(ExamplegrinderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 215, 163);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 215, 163, 215, 163);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 121, this.topPos + 23, 0, 0, 32, 16, 32, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 48, this.topPos + 63, 0, 0, 24, 10, 24, 10);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 160, this.topPos + 63, 0, 0, 37, 7, 37, 7);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 2601, 50);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.examplegrindergui.label_varg_num_100"), 149, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
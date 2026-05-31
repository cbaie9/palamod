package palamod.client.gui;

import palamod.world.inventory.PaladiumchestguiMenu;

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

public class PaladiumchestguiScreen extends AbstractContainerScreen<PaladiumchestguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/paladiumchestgui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/ring_to_set.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/ring_gui.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/ring_gui.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/ring_gui.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/ring_gui.png");

	public PaladiumchestguiScreen(PaladiumchestguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 306, 225);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 306, 225, 306, 225);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 284, this.topPos + 112, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 252, this.topPos + 181, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 252, this.topPos + 163, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 270, this.topPos + 163, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 270, this.topPos + 181, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.paladiumchestgui.label_inventory"), 70, 131, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.paladiumchestgui.label_rings"), 250, 150, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
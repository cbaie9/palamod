package palamod.client.gui;

import palamod.world.inventory.Palaerror0006Menu;

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

public class Palaerror0006Screen extends AbstractContainerScreen<Palaerror0006Menu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/gui176_166.png");

	public Palaerror0006Screen(Palaerror0006Menu container, Inventory inventory, Component text) {
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palaerror_0006.label_paladium_error_0006"), 39, 5, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palaerror_0006.label_this_part_is_work_in_progress"), 10, 25, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palaerror_0006.label_come_soon_to_have_more"), 27, 52, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palaerror_0006.label_fonction_cb9"), 51, 63, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
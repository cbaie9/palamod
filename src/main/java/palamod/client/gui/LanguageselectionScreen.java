package palamod.client.gui;

import palamod.world.inventory.LanguageselectionMenu;

import palamod.network.LanguageselectionButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class LanguageselectionScreen extends AbstractContainerScreen<LanguageselectionMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_franais;
	private Button button_english;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/gui176_166.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/english_lang.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/french_lang.png");

	public LanguageselectionScreen(LanguageselectionMenu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 7, this.topPos + 31, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 6, this.topPos + 66, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.languageselection.label_select_your_language"), 31, 5, -16724788, false);
	}

	@Override
	public void init() {
		super.init();
		button_franais = Button.builder(Component.translatable("gui.palamod.languageselection.button_franais"), e -> {
			int x = LanguageselectionScreen.this.x;
			int y = LanguageselectionScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new LanguageselectionButtonMessage(0, x, y, z));
				LanguageselectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 28, this.topPos + 64, 67, 20).build();
		this.addRenderableWidget(button_franais);
		button_english = Button.builder(Component.translatable("gui.palamod.languageselection.button_english"), e -> {
			int x = LanguageselectionScreen.this.x;
			int y = LanguageselectionScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new LanguageselectionButtonMessage(1, x, y, z));
				LanguageselectionButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 26, this.topPos + 29, 61, 20).build();
		this.addRenderableWidget(button_english);
	}
}
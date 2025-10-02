package palamod.client.gui;

import palamod.world.inventory.LanguageselectionMenu;

import palamod.network.LanguageselectionButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class LanguageselectionScreen extends AbstractContainerScreen<LanguageselectionMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_franais;
	Button button_english;

	public LanguageselectionScreen(LanguageselectionMenu container, Inventory inventory, Component text) {
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
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/gui176_166.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/english_lang.png"), this.leftPos + 7, this.topPos + 31, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/french_lang.png"), this.leftPos + 6, this.topPos + 66, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.languageselection.label_select_your_language"), 31, 5, -16724788, false);
	}

	@Override
	public void init() {
		super.init();
		button_franais = Button.builder(Component.translatable("gui.palamod.languageselection.button_franais"), e -> {
			int x = LanguageselectionScreen.this.x;
			int y = LanguageselectionScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LanguageselectionButtonMessage(0, x, y, z));
				LanguageselectionButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 28, this.topPos + 64, 67, 20).build();
		this.addRenderableWidget(button_franais);
		button_english = Button.builder(Component.translatable("gui.palamod.languageselection.button_english"), e -> {
			int x = LanguageselectionScreen.this.x;
			int y = LanguageselectionScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LanguageselectionButtonMessage(1, x, y, z));
				LanguageselectionButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 26, this.topPos + 29, 61, 20).build();
		this.addRenderableWidget(button_english);
	}
}
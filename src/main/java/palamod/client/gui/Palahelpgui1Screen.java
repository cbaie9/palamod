package palamod.client.gui;

import palamod.world.inventory.Palahelpgui1Menu;

import palamod.network.Palahelpgui1ButtonMessage;

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

public class Palahelpgui1Screen extends AbstractContainerScreen<Palahelpgui1Menu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_blocks;
	private Button button_items;
	private Button button_gui;
	private Button button_lucky_blocks;
	private Button button_metiers_soon;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/gui176_166.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/paladium_block_photo.png");

	public Palahelpgui1Screen(Palahelpgui1Menu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 1, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 3, this.topPos + 20, 0, 0, 85, 84, 85, 84);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpgui_1.label_palahelp"), 6, 5, -52429, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpgui_1.label_12"), 6, 147, -16750951, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpgui_1.label_soon"), 87, 82, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_blocks = Button.builder(Component.translatable("gui.palamod.palahelpgui_1.button_blocks"), e -> {
			int x = Palahelpgui1Screen.this.x;
			int y = Palahelpgui1Screen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new Palahelpgui1ButtonMessage(0, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 88, this.topPos + 6, 81, 20).build();
		this.addRenderableWidget(button_blocks);
		button_items = Button.builder(Component.translatable("gui.palamod.palahelpgui_1.button_items"), e -> {
			int x = Palahelpgui1Screen.this.x;
			int y = Palahelpgui1Screen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new Palahelpgui1ButtonMessage(1, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 88, this.topPos + 31, 81, 20).build();
		this.addRenderableWidget(button_items);
		button_gui = Button.builder(Component.translatable("gui.palamod.palahelpgui_1.button_gui"), e -> {
			int x = Palahelpgui1Screen.this.x;
			int y = Palahelpgui1Screen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new Palahelpgui1ButtonMessage(2, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 88, this.topPos + 57, 81, 20).build();
		this.addRenderableWidget(button_gui);
		button_lucky_blocks = Button.builder(Component.translatable("gui.palamod.palahelpgui_1.button_lucky_blocks"), e -> {
			int x = Palahelpgui1Screen.this.x;
			int y = Palahelpgui1Screen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new Palahelpgui1ButtonMessage(3, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 88, this.topPos + 122, 81, 20).build();
		this.addRenderableWidget(button_lucky_blocks);
		button_metiers_soon = Button.builder(Component.translatable("gui.palamod.palahelpgui_1.button_metiers_soon"), e -> {
			int x = Palahelpgui1Screen.this.x;
			int y = Palahelpgui1Screen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new Palahelpgui1ButtonMessage(4, x, y, z));
				Palahelpgui1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 88, this.topPos + 97, 81, 20).build();
		this.addRenderableWidget(button_metiers_soon);
	}
}
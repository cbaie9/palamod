package palamod.client.gui;

import palamod.world.inventory.DownloaderlinkMenu;

import palamod.network.DownloaderlinkButtonMessage;

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

public class DownloaderlinkScreen extends AbstractContainerScreen<DownloaderlinkMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_no;
	private Button button_process;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/gui176_166.png");

	public DownloaderlinkScreen(DownloaderlinkMenu container, Inventory inventory, Component text) {
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.downloaderlink.label_this_will_link_your_palamod"), 11, 6, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.downloaderlink.label_money_account_to_this_block"), 14, 18, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.downloaderlink.label_are_your_sure"), 36, 51, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.downloaderlink.label_you_can_unlink_the_account_at"), 9, 121, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.downloaderlink.label_any_time"), 10, 131, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_no = Button.builder(Component.translatable("gui.palamod.downloaderlink.button_no"), e -> {
			int x = DownloaderlinkScreen.this.x;
			int y = DownloaderlinkScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DownloaderlinkButtonMessage(0, x, y, z));
				DownloaderlinkButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 71, 35, 20).build();
		this.addRenderableWidget(button_no);
		button_process = Button.builder(Component.translatable("gui.palamod.downloaderlink.button_process"), e -> {
			int x = DownloaderlinkScreen.this.x;
			int y = DownloaderlinkScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DownloaderlinkButtonMessage(1, x, y, z));
				DownloaderlinkButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 84, this.topPos + 71, 61, 20).build();
		this.addRenderableWidget(button_process);
	}
}
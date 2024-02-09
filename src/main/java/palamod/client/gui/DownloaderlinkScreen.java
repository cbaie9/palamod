package palamod.client.gui;

import palamod.world.inventory.DownloaderlinkMenu;

import palamod.network.DownloaderlinkButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DownloaderlinkScreen extends AbstractContainerScreen<DownloaderlinkMenu> {
	private final static HashMap<String, Object> guistate = DownloaderlinkMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_no;
	Button button_process;

	public DownloaderlinkScreen(DownloaderlinkMenu container, Inventory inventory, Component text) {
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
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/downloaderlink.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.downloaderlink.label_this_will_link_your_palamod"), 11, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.downloaderlink.label_money_account_to_this_block"), 14, 18, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.downloaderlink.label_are_your_sure"), 36, 51, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.downloaderlink.label_you_can_unlink_the_account_at"), 9, 121, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.downloaderlink.label_any_time"), 10, 131, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_no = Button.builder(Component.translatable("gui.palamod.downloaderlink.button_no"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DownloaderlinkButtonMessage(0, x, y, z));
				DownloaderlinkButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 25, this.topPos + 71, 35, 20).build();
		guistate.put("button:button_no", button_no);
		this.addRenderableWidget(button_no);
		button_process = Button.builder(Component.translatable("gui.palamod.downloaderlink.button_process"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DownloaderlinkButtonMessage(1, x, y, z));
				DownloaderlinkButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 84, this.topPos + 71, 61, 20).build();
		guistate.put("button:button_process", button_process);
		this.addRenderableWidget(button_process);
	}
}

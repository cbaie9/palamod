package palamod.client.gui;

import palamod.world.inventory.AdminshopadbanMenu;

import palamod.network.AdminshopadbanButtonMessage;

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

public class AdminshopadbanScreen extends AbstractContainerScreen<AdminshopadbanMenu> {
	private final static HashMap<String, Object> guistate = AdminshopadbanMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_beta_adminshop;

	public AdminshopadbanScreen(AdminshopadbanMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 130;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/adminshopadban.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 130, 166, 130, 166);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopadban.label_work_in_progress"), 25, 6, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopadban.label_v_u1"), 78, 128, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopadban.label_imcomplete_list"), 24, 20, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopadban.label_some_major_graphic"), 7, 66, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopadban.label_will_be_done_later"), 7, 76, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_beta_adminshop = Button.builder(Component.translatable("gui.palamod.adminshopadban.button_beta_adminshop"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopadbanButtonMessage(0, x, y, z));
				AdminshopadbanButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 16, this.topPos + 139, 98, 20).build();
		guistate.put("button:button_beta_adminshop", button_beta_adminshop);
		this.addRenderableWidget(button_beta_adminshop);
	}
}

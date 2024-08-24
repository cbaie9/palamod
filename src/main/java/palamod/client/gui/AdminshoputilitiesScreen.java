package palamod.client.gui;

import palamod.world.inventory.AdminshoputilitiesMenu;

import palamod.procedures.ReturnadminshopmainmenuProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshoputilitiesButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshoputilitiesScreen extends AbstractContainerScreen<AdminshoputilitiesMenu> {
	private final static HashMap<String, Object> guistate = AdminshoputilitiesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_honey_comb;
	Button button_leather;
	Button button_feather;
	Button button_ink_sac;
	Button button_glow_in_sac;
	Button button_blaze;
	Button button_gun_powder;
	Button button_steak;
	Button button_stone;
	Button button_emeraude;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_cross_no_button;

	public AdminshoputilitiesScreen(AdminshoputilitiesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 190;
		this.imageHeight = 200;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 162 && mouseX < leftPos + 178 && mouseY > topPos + 5 && mouseY < topPos + 21)
			guiGraphics.renderTooltip(font, Component.literal(ClosetheguitransProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 5 && mouseX < leftPos + 20 && mouseY > topPos + 7 && mouseY < topPos + 21)
			guiGraphics.renderTooltip(font, Component.literal(ReturnadminshopmainmenuProcedure.execute()), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/adminshoputilities.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 190, 200, 190, 200);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 89, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshoputilities.label_adminshop_plant_section"), 28, 2, -52480, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshoputilities.label_wip"), 76, 13, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshoputilities.label_fast_sell"), 74, 156, -16724788, false);
	}

	@Override
	public void init() {
		super.init();
		button_honey_comb = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_honey_comb"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(0, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 98, this.topPos + 75, 81, 20).build();
		guistate.put("button:button_honey_comb", button_honey_comb);
		this.addRenderableWidget(button_honey_comb);
		button_leather = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_leather"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(1, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 168, 61, 20).build();
		guistate.put("button:button_leather", button_leather);
		this.addRenderableWidget(button_leather);
		button_feather = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_feather"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(2, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 118, this.topPos + 51, 61, 20).build();
		guistate.put("button:button_feather", button_feather);
		this.addRenderableWidget(button_feather);
		button_ink_sac = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_ink_sac"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(3, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 136, this.topPos + 96, 43, 20).build();
		guistate.put("button:button_ink_sac", button_ink_sac);
		this.addRenderableWidget(button_ink_sac);
		button_glow_in_sac = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_glow_in_sac"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(4, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 75, 82, 20).build();
		guistate.put("button:button_glow_in_sac", button_glow_in_sac);
		this.addRenderableWidget(button_glow_in_sac);
		button_blaze = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_blaze"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(5, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 51, 51, 20).build();
		guistate.put("button:button_blaze", button_blaze);
		this.addRenderableWidget(button_blaze);
		button_gun_powder = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_gun_powder"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(6, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 102, this.topPos + 26, 77, 20).build();
		guistate.put("button:button_gun_powder", button_gun_powder);
		this.addRenderableWidget(button_gun_powder);
		button_steak = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_steak"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(7, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 26, 51, 20).build();
		guistate.put("button:button_steak", button_steak);
		this.addRenderableWidget(button_steak);
		button_stone = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_stone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(8, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 111, this.topPos + 169, 68, 20).build();
		guistate.put("button:button_stone", button_stone);
		this.addRenderableWidget(button_stone);
		button_emeraude = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_emeraude"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(9, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 97, 67, 20).build();
		guistate.put("button:button_emeraude", button_emeraude);
		this.addRenderableWidget(button_emeraude);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 4, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(10, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 162, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoputilitiesButtonMessage(11, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}

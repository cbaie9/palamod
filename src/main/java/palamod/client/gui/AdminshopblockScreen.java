package palamod.client.gui;

import palamod.world.inventory.AdminshopblockMenu;

import palamod.network.AdminshopblockButtonMessage;

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

public class AdminshopblockScreen extends AbstractContainerScreen<AdminshopblockMenu> {
	private final static HashMap<String, Object> guistate = AdminshopblockMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_dirt;
	Button button_grass;
	Button button_stone;
	Button button_netherrack;
	Button button_soul_sand;
	Button button_sand;
	Button button_gravel;
	Button button_glowstone;
	Button button_oak_wood;
	Button button_blackstone;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;

	public AdminshopblockScreen(AdminshopblockMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 205;
		this.imageHeight = 206;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 185 && mouseX < leftPos + 201 && mouseY > topPos + 4 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.adminshopblock.tooltip_close_the_gui"), mouseX, mouseY);
		if (mouseX > leftPos + 166 && mouseX < leftPos + 181 && mouseY > topPos + 6 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.adminshopblock.tooltip_return_to_the_adminshop_menu"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/adminshopblock.png"), this.leftPos + 0, this.topPos + 16, 0, 0, 205, 190, 205, 190);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 105, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 73, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopblock.label_adminshop_block_menu"), 8, 7, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_dirt = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_dirt"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(0, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 31, 46, 20).build();
		guistate.put("button:button_dirt", button_dirt);
		this.addRenderableWidget(button_dirt);
		button_grass = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_grass"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(1, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 145, this.topPos + 30, 51, 20).build();
		guistate.put("button:button_grass", button_grass);
		this.addRenderableWidget(button_grass);
		button_stone = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_stone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(2, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 58, 82, 20).build();
		guistate.put("button:button_stone", button_stone);
		this.addRenderableWidget(button_stone);
		button_netherrack = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_netherrack"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(3, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 85, 82, 20).build();
		guistate.put("button:button_netherrack", button_netherrack);
		this.addRenderableWidget(button_netherrack);
		button_soul_sand = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_soul_sand"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(4, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 113, 72, 20).build();
		guistate.put("button:button_soul_sand", button_soul_sand);
		this.addRenderableWidget(button_soul_sand);
		button_sand = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_sand"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(5, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 150, this.topPos + 58, 46, 20).build();
		guistate.put("button:button_sand", button_sand);
		this.addRenderableWidget(button_sand);
		button_gravel = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_gravel"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(6, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 141, this.topPos + 85, 56, 20).build();
		guistate.put("button:button_gravel", button_gravel);
		this.addRenderableWidget(button_gravel);
		button_glowstone = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_glowstone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(7, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 140, 72, 20).build();
		guistate.put("button:button_glowstone", button_glowstone);
		this.addRenderableWidget(button_glowstone);
		button_oak_wood = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_oak_wood"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(8, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 169, 66, 20).build();
		guistate.put("button:button_oak_wood", button_oak_wood);
		this.addRenderableWidget(button_oak_wood);
		button_blackstone = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_blackstone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(9, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 120, this.topPos + 113, 77, 20).build();
		guistate.put("button:button_blackstone", button_blackstone);
		this.addRenderableWidget(button_blackstone);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 185, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(10, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 165, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopblockButtonMessage(11, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}

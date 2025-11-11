package palamod.client.gui;

import palamod.world.inventory.AdminshopblockMenu;

import palamod.procedures.ReturnadminshopmainmenuProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshopblockButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshopblockScreen extends AbstractContainerScreen<AdminshopblockMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_dirt;
	private Button button_grass;
	private Button button_stone;
	private Button button_netherrack;
	private Button button_soul_sand;
	private Button button_sand;
	private Button button_gravel;
	private Button button_glowstone;
	private Button button_oak_wood;
	private Button button_blackstone;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_adminshop;

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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 185 && mouseX < leftPos + 201 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 181 && mouseY > topPos + 6 && mouseY < topPos + 20) {
			String hoverText = ReturnadminshopmainmenuProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/adminshopblock.png"), this.leftPos + 0, this.topPos + 16, 0, 0, 205, 190, 205, 190);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 105, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 73, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(0, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 31, 46, 20).build();
		this.addRenderableWidget(button_dirt);
		button_grass = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_grass"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(1, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 145, this.topPos + 30, 51, 20).build();
		this.addRenderableWidget(button_grass);
		button_stone = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_stone"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(2, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 58, 82, 20).build();
		this.addRenderableWidget(button_stone);
		button_netherrack = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_netherrack"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(3, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 85, 82, 20).build();
		this.addRenderableWidget(button_netherrack);
		button_soul_sand = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_soul_sand"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(4, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 113, 72, 20).build();
		this.addRenderableWidget(button_soul_sand);
		button_sand = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_sand"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(5, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 150, this.topPos + 58, 46, 20).build();
		this.addRenderableWidget(button_sand);
		button_gravel = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_gravel"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(6, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 141, this.topPos + 85, 56, 20).build();
		this.addRenderableWidget(button_gravel);
		button_glowstone = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_glowstone"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(7, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 140, 72, 20).build();
		this.addRenderableWidget(button_glowstone);
		button_oak_wood = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_oak_wood"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(8, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 13, this.topPos + 169, 66, 20).build();
		this.addRenderableWidget(button_oak_wood);
		button_blackstone = Button.builder(Component.translatable("gui.palamod.adminshopblock.button_blackstone"), e -> {
			int x = AdminshopblockScreen.this.x;
			int y = AdminshopblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopblockButtonMessage(9, x, y, z));
				AdminshopblockButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 120, this.topPos + 113, 77, 20).build();
		this.addRenderableWidget(button_blackstone);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 185, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshopblockScreen.this.x;
					int y = AdminshopblockScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopblockButtonMessage(10, x, y, z));
						AdminshopblockButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 165, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = AdminshopblockScreen.this.x;
					int y = AdminshopblockScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopblockButtonMessage(11, x, y, z));
						AdminshopblockButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}
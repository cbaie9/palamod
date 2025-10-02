package palamod.client.gui;

import palamod.world.inventory.AdminshopplantMenu;

import palamod.procedures.ReturnadminshopmainmenuProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshopplantButtonMessage;

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

public class AdminshopplantScreen extends AbstractContainerScreen<AdminshopplantMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_cactus;
	Button button_red_mushroom;
	Button button_brown_mushroom;
	Button button_warped_fungus;
	Button button_crimson_fungun;
	Button button_potato;
	Button button_wheat_seed;
	Button button_carrot;
	Button button_melon;
	Button button_sugar_cane;
	Button button_cocoa;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;

	public AdminshopplantScreen(AdminshopplantMenu container, Inventory inventory, Component text) {
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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 166 && mouseX < leftPos + 182 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 7 && mouseX < leftPos + 22 && mouseY > topPos + 6 && mouseY < topPos + 20) {
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
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/adminshoputilities.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 190, 200, 190, 200);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/adminshopplant.png"), this.leftPos + -1, this.topPos + 0, 0, 0, -1, -1, -1, -1);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 89, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopplant.label_adminshop_seed_menu"), 46, 4, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_cactus = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_cactus"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(0, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 26, 56, 20).build();
		this.addRenderableWidget(button_cactus);
		button_red_mushroom = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_red_mushroom"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(1, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 26, 87, 20).build();
		this.addRenderableWidget(button_red_mushroom);
		button_brown_mushroom = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_brown_mushroom"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(2, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 52, 87, 20).build();
		this.addRenderableWidget(button_brown_mushroom);
		button_warped_fungus = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_warped_fungus"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(3, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 78, 87, 20).build();
		this.addRenderableWidget(button_warped_fungus);
		button_crimson_fungun = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_crimson_fungun"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(4, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 106, 86, 20).build();
		this.addRenderableWidget(button_crimson_fungun);
		button_potato = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_potato"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(5, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 51, 56, 20).build();
		this.addRenderableWidget(button_potato);
		button_wheat_seed = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_wheat_seed"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(6, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 133, 53, 20).build();
		this.addRenderableWidget(button_wheat_seed);
		button_carrot = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_carrot"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(7, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 78, 55, 20).build();
		this.addRenderableWidget(button_carrot);
		button_melon = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_melon"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(8, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 106, 54, 20).build();
		this.addRenderableWidget(button_melon);
		button_sugar_cane = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_sugar_cane"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(9, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 134, 85, 20).build();
		this.addRenderableWidget(button_sugar_cane);
		button_cocoa = Button.builder(Component.translatable("gui.palamod.adminshopplant.button_cocoa"), e -> {
			int x = AdminshopplantScreen.this.x;
			int y = AdminshopplantScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopplantButtonMessage(10, x, y, z));
				AdminshopplantButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 161, 51, 20).build();
		this.addRenderableWidget(button_cocoa);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 166, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshopplantScreen.this.x;
					int y = AdminshopplantScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopplantButtonMessage(11, x, y, z));
						AdminshopplantButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 6, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = AdminshopplantScreen.this.x;
					int y = AdminshopplantScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopplantButtonMessage(12, x, y, z));
						AdminshopplantButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}
package palamod.client.gui;

import palamod.world.inventory.AdminshopmobsMenu;

import palamod.procedures.Returnadminshopmobsp2Procedure;
import palamod.procedures.ReturnadminshopmainmenuProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshopmobsButtonMessage;

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

public class AdminshopmobsScreen extends AbstractContainerScreen<AdminshopmobsMenu> implements PalamodModScreens.ScreenAccessor {
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
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_revert_adminshop_arrow;

	public AdminshopmobsScreen(AdminshopmobsMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 8 && mouseX < leftPos + 23 && mouseY > topPos + 5 && mouseY < topPos + 19) {
			String hoverText = ReturnadminshopmainmenuProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 26 && mouseX < leftPos + 41 && mouseY > topPos + 5 && mouseY < topPos + 19) {
			String hoverText = Returnadminshopmobsp2Procedure.execute();
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
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/adminshopmobs.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 190, 200, 190, 200);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 90, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopmobs.label_adminshop_mobs_menu"), 53, 2, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopmobs.label_page_1"), 77, 11, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_cactus = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_cactus"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(0, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 104, 38, 20).build();
		this.addRenderableWidget(button_cactus);
		button_red_mushroom = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_red_mushroom"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(1, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 27, 87, 20).build();
		this.addRenderableWidget(button_red_mushroom);
		button_brown_mushroom = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_brown_mushroom"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(2, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 77, 117, 20).build();
		this.addRenderableWidget(button_brown_mushroom);
		button_warped_fungus = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_warped_fungus"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(3, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 51, 87, 20).build();
		this.addRenderableWidget(button_warped_fungus);
		button_crimson_fungun = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_crimson_fungun"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(4, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 8, this.topPos + 134, 74, 20).build();
		this.addRenderableWidget(button_crimson_fungun);
		button_potato = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_potato"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(5, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 51, 56, 20).build();
		this.addRenderableWidget(button_potato);
		button_wheat_seed = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_wheat_seed"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(6, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 100, this.topPos + 104, 81, 20).build();
		this.addRenderableWidget(button_wheat_seed);
		button_carrot = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_carrot"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(7, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 77, 34, 20).build();
		this.addRenderableWidget(button_carrot);
		button_melon = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_melon"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(8, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 27, 63, 20).build();
		this.addRenderableWidget(button_melon);
		button_sugar_cane = Button.builder(Component.translatable("gui.palamod.adminshopmobs.button_sugar_cane"), e -> {
			int x = AdminshopmobsScreen.this.x;
			int y = AdminshopmobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(9, x, y, z));
				AdminshopmobsButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 95, this.topPos + 134, 85, 20).build();
		this.addRenderableWidget(button_sugar_cane);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 166, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshopmobsScreen.this.x;
					int y = AdminshopmobsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(10, x, y, z));
						AdminshopmobsButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 7, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = AdminshopmobsScreen.this.x;
					int y = AdminshopmobsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(11, x, y, z));
						AdminshopmobsButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_revert_adminshop_arrow = new ImageButton(this.leftPos + 26, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/revert_adminshop_arrow.png"), ResourceLocation.parse("palamod:textures/screens/pointed_revert_adminshop_arrow.png")), e -> {
					int x = AdminshopmobsScreen.this.x;
					int y = AdminshopmobsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmobsButtonMessage(12, x, y, z));
						AdminshopmobsButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_revert_adminshop_arrow);
	}
}
package palamod.client.gui;

import palamod.world.inventory.AdminshoputilitiesMenu;

import palamod.procedures.ReturnadminshopmainmenuProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshoputilitiesButtonMessage;

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

public class AdminshoputilitiesScreen extends AbstractContainerScreen<AdminshoputilitiesMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_honey_comb;
	private Button button_leather;
	private Button button_feather;
	private Button button_ink_sac;
	private Button button_glow_in_sac;
	private Button button_blaze;
	private Button button_gun_powder;
	private Button button_steak;
	private Button button_stone;
	private Button button_emeraude;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_cross_no_button;

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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 162 && mouseX < leftPos + 178 && mouseY > topPos + 5 && mouseY < topPos + 21) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 5 && mouseX < leftPos + 20 && mouseY > topPos + 7 && mouseY < topPos + 21) {
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
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 89, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(0, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 98, this.topPos + 75, 81, 20).build();
		this.addRenderableWidget(button_honey_comb);
		button_leather = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_leather"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(1, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 168, 61, 20).build();
		this.addRenderableWidget(button_leather);
		button_feather = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_feather"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(2, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 118, this.topPos + 51, 61, 20).build();
		this.addRenderableWidget(button_feather);
		button_ink_sac = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_ink_sac"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(3, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 136, this.topPos + 96, 43, 20).build();
		this.addRenderableWidget(button_ink_sac);
		button_glow_in_sac = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_glow_in_sac"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(4, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 75, 82, 20).build();
		this.addRenderableWidget(button_glow_in_sac);
		button_blaze = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_blaze"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(5, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 51, 51, 20).build();
		this.addRenderableWidget(button_blaze);
		button_gun_powder = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_gun_powder"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(6, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 102, this.topPos + 26, 77, 20).build();
		this.addRenderableWidget(button_gun_powder);
		button_steak = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_steak"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(7, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 26, 51, 20).build();
		this.addRenderableWidget(button_steak);
		button_stone = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_stone"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(8, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 111, this.topPos + 169, 68, 20).build();
		this.addRenderableWidget(button_stone);
		button_emeraude = Button.builder(Component.translatable("gui.palamod.adminshoputilities.button_emeraude"), e -> {
			int x = AdminshoputilitiesScreen.this.x;
			int y = AdminshoputilitiesScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(9, x, y, z));
				AdminshoputilitiesButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 97, 67, 20).build();
		this.addRenderableWidget(button_emeraude);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 4, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = AdminshoputilitiesScreen.this.x;
					int y = AdminshoputilitiesScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(10, x, y, z));
						AdminshoputilitiesButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 162, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshoputilitiesScreen.this.x;
					int y = AdminshoputilitiesScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshoputilitiesButtonMessage(11, x, y, z));
						AdminshoputilitiesButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}
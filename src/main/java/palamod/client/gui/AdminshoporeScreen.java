package palamod.client.gui;

import palamod.world.inventory.AdminshoporeMenu;

import palamod.procedures.ReturnadminshopmainmenuProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshoporeButtonMessage;

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

public class AdminshoporeScreen extends AbstractContainerScreen<AdminshoporeMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_paladium;
	private Button button_titane;
	private Button button_amethyst;
	private Button button_findium;
	private Button button_diamond;
	private Button button_iron;
	private Button button_gold;
	private Button button_coal;
	private Button button_redstone;
	private Button button_emerald;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_adminshop;

	public AdminshoporeScreen(AdminshoporeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 183;
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
		if (mouseX > leftPos + 149 && mouseX < leftPos + 165 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 6 && mouseX < leftPos + 21 && mouseY > topPos + 6 && mouseY < topPos + 20) {
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
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/gui176_166.png"), this.leftPos + 0, this.topPos + 17, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 76, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopore.label_adminshop_ore_menu"), 35, 7, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_paladium = Button.builder(Component.translatable("gui.palamod.adminshopore.button_paladium"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(0, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 24, 72, 20).build();
		this.addRenderableWidget(button_paladium);
		button_titane = Button.builder(Component.translatable("gui.palamod.adminshopore.button_titane"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(1, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 24, 61, 20).build();
		this.addRenderableWidget(button_titane);
		button_amethyst = Button.builder(Component.translatable("gui.palamod.adminshopore.button_amethyst"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(2, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 46, 72, 20).build();
		this.addRenderableWidget(button_amethyst);
		button_findium = Button.builder(Component.translatable("gui.palamod.adminshopore.button_findium"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(3, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 46, 61, 20).build();
		this.addRenderableWidget(button_findium);
		button_diamond = Button.builder(Component.translatable("gui.palamod.adminshopore.button_diamond"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(4, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 68, 72, 20).build();
		this.addRenderableWidget(button_diamond);
		button_iron = Button.builder(Component.translatable("gui.palamod.adminshopore.button_iron"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(5, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 68, 61, 20).build();
		this.addRenderableWidget(button_iron);
		button_gold = Button.builder(Component.translatable("gui.palamod.adminshopore.button_gold"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(6, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 90, 72, 20).build();
		this.addRenderableWidget(button_gold);
		button_coal = Button.builder(Component.translatable("gui.palamod.adminshopore.button_coal"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(7, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 90, 61, 20).build();
		this.addRenderableWidget(button_coal);
		button_redstone = Button.builder(Component.translatable("gui.palamod.adminshopore.button_redstone"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(8, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 112, 72, 20).build();
		this.addRenderableWidget(button_redstone);
		button_emerald = Button.builder(Component.translatable("gui.palamod.adminshopore.button_emerald"), e -> {
			int x = AdminshoporeScreen.this.x;
			int y = AdminshoporeScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporeButtonMessage(9, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 112, 61, 20).build();
		this.addRenderableWidget(button_emerald);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 149, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshoporeScreen.this.x;
					int y = AdminshoporeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshoporeButtonMessage(10, x, y, z));
						AdminshoporeButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 5, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = AdminshoporeScreen.this.x;
					int y = AdminshoporeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshoporeButtonMessage(11, x, y, z));
						AdminshoporeButtonMessage.handleButtonAction(entity, 11, x, y, z);
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
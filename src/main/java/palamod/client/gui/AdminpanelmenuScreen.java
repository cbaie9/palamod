package palamod.client.gui;

import palamod.world.inventory.AdminpanelmenuMenu;

import palamod.network.AdminpanelmenuButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdminpanelmenuScreen extends AbstractContainerScreen<AdminpanelmenuMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_hdv_stocks_panel;
	private Button button_spawn_panel;
	private Button button_trixium_panel;
	private Button button_jobs_panel;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/gui176_166.png");

	public AdminpanelmenuScreen(AdminpanelmenuMenu container, Inventory inventory, Component text) {
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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
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
		int heightPadding = 0;
		int yOffset = 0;
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.adminpanelmenu.label_admin_panel").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 52, 5 + yOffset, -65536, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.adminpanelmenu.label_now_money_change").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 17, 57 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		button_hdv_stocks_panel = Button.builder(Component.translatable("gui.palamod.adminpanelmenu.button_hdv_stocks_panel"), e -> {
			int x = AdminpanelmenuScreen.this.x;
			int y = AdminpanelmenuScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminpanelmenuButtonMessage(0, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 30, this.topPos + 24, 108, 20).build();
		this.addRenderableWidget(button_hdv_stocks_panel);
		button_spawn_panel = Button.builder(Component.translatable("gui.palamod.adminpanelmenu.button_spawn_panel"), e -> {
			int x = AdminpanelmenuScreen.this.x;
			int y = AdminpanelmenuScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminpanelmenuButtonMessage(1, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 43, this.topPos + 78, 82, 20).build();
		this.addRenderableWidget(button_spawn_panel);
		button_trixium_panel = Button.builder(Component.translatable("gui.palamod.adminpanelmenu.button_trixium_panel"), e -> {
			int x = AdminpanelmenuScreen.this.x;
			int y = AdminpanelmenuScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminpanelmenuButtonMessage(2, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 38, this.topPos + 108, 93, 20).build();
		this.addRenderableWidget(button_trixium_panel);
		button_jobs_panel = Button.builder(Component.translatable("gui.palamod.adminpanelmenu.button_jobs_panel"), e -> {
			int x = AdminpanelmenuScreen.this.x;
			int y = AdminpanelmenuScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminpanelmenuButtonMessage(3, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 48, this.topPos + 135, 77, 20).build();
		this.addRenderableWidget(button_jobs_panel);
	}
}
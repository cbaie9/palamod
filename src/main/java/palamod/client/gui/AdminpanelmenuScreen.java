package palamod.client.gui;

import palamod.world.inventory.AdminpanelmenuMenu;

import palamod.network.AdminpanelmenuButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class AdminpanelmenuScreen extends AbstractContainerScreen<AdminpanelmenuMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_hdv_stocks_panel;
	private Button button_spawn_panel;
	private Button button_trixium_panel;
	private Button button_jobs_panel;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/gui176_166.png");

	public AdminpanelmenuScreen(AdminpanelmenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 166);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.adminpanelmenu.label_admin_panel"), 52, 5, -65536, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.adminpanelmenu.label_now_money_change"), 17, 57, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_hdv_stocks_panel = Button.builder(Component.translatable("gui.palamod.adminpanelmenu.button_hdv_stocks_panel"), e -> {
			int x = AdminpanelmenuScreen.this.x;
			int y = AdminpanelmenuScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AdminpanelmenuButtonMessage(0, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 30, this.topPos + 24, 108, 20).build();
		this.addRenderableWidget(button_hdv_stocks_panel);
		button_spawn_panel = Button.builder(Component.translatable("gui.palamod.adminpanelmenu.button_spawn_panel"), e -> {
			int x = AdminpanelmenuScreen.this.x;
			int y = AdminpanelmenuScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AdminpanelmenuButtonMessage(1, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 43, this.topPos + 78, 82, 20).build();
		this.addRenderableWidget(button_spawn_panel);
		button_trixium_panel = Button.builder(Component.translatable("gui.palamod.adminpanelmenu.button_trixium_panel"), e -> {
			int x = AdminpanelmenuScreen.this.x;
			int y = AdminpanelmenuScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AdminpanelmenuButtonMessage(2, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 38, this.topPos + 108, 93, 20).build();
		this.addRenderableWidget(button_trixium_panel);
		button_jobs_panel = Button.builder(Component.translatable("gui.palamod.adminpanelmenu.button_jobs_panel"), e -> {
			int x = AdminpanelmenuScreen.this.x;
			int y = AdminpanelmenuScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AdminpanelmenuButtonMessage(3, x, y, z));
				AdminpanelmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 48, this.topPos + 135, 77, 20).build();
		this.addRenderableWidget(button_jobs_panel);
	}
}
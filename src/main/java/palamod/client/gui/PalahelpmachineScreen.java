package palamod.client.gui;

import palamod.world.inventory.PalahelpmachineMenu;

import palamod.network.PalahelpmachineButtonMessage;

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

public class PalahelpmachineScreen extends AbstractContainerScreen<PalahelpmachineMenu> {
	private final static HashMap<String, Object> guistate = PalahelpmachineMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_grinder;
	Button button_palamachine;
	Button button_crusher;
	Button button_forge;
	Button button_uploader;
	Button button_downloader;
	Button button_drawbridge;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_home_pixel_adminshop;
	ImageButton imagebutton_cross_no_button;

	public PalahelpmachineScreen(PalahelpmachineMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/palahelpmachine.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/golem64.png"), this.leftPos + 13, this.topPos + 28, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpmachine.label_palahelp_machine_menu"), 2, 6, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_grinder = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_grinder"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(0, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 29, 75, 20).build();
		guistate.put("button:button_grinder", button_grinder);
		this.addRenderableWidget(button_grinder);
		button_palamachine = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_palamachine"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(1, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 51, 75, 20).build();
		guistate.put("button:button_palamachine", button_palamachine);
		this.addRenderableWidget(button_palamachine);
		button_crusher = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_crusher"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(2, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 73, 75, 20).build();
		guistate.put("button:button_crusher", button_crusher);
		this.addRenderableWidget(button_crusher);
		button_forge = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_forge"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(3, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 96, 75, 20).build();
		guistate.put("button:button_forge", button_forge);
		this.addRenderableWidget(button_forge);
		button_uploader = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_uploader"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(4, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 118, 75, 20).build();
		guistate.put("button:button_uploader", button_uploader);
		this.addRenderableWidget(button_uploader);
		button_downloader = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_downloader"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(5, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 140, 75, 20).build();
		guistate.put("button:button_downloader", button_downloader);
		this.addRenderableWidget(button_downloader);
		button_drawbridge = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_drawbridge"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(6, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 97, 77, 20).build();
		guistate.put("button:button_drawbridge", button_drawbridge);
		this.addRenderableWidget(button_drawbridge);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 122, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(7, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 139, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(8, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 155, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpmachineButtonMessage(9, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}

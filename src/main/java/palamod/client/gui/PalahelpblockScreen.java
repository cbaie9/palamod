package palamod.client.gui;

import palamod.world.inventory.PalahelpblockMenu;

import palamod.network.PalahelpblockButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PalahelpblockScreen extends AbstractContainerScreen<PalahelpblockMenu> {
	private final static HashMap<String, Object> guistate = PalahelpblockMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ore;
	Button button_trees;
	Button button_back;
	Button button_machine;
	Button button_fluid;
	Button button_close;

	public PalahelpblockScreen(PalahelpblockMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/adminshopblockoakwood.png"), this.leftPos + -1, this.topPos + 0, 0, 0, -1, -1, -1, -1);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/pack.png"), this.leftPos + 6, this.topPos + 24, 0, 0, 63, 63, 63, 63);

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpblock.label_palahelp_block_menu"), 11, 11, -65536, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_ore = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_ore"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(0, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 31, 40, 20).build();
		guistate.put("button:button_ore", button_ore);
		this.addRenderableWidget(button_ore);
		button_trees = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_trees"), e -> {
		}).bounds(this.leftPos + 96, this.topPos + 56, 50, 20).build();
		guistate.put("button:button_trees", button_trees);
		this.addRenderableWidget(button_trees);
		button_back = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(2, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 95, 50, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_machine = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_machine"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(3, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 95, this.topPos + 83, 60, 20).build();
		guistate.put("button:button_machine", button_machine);
		this.addRenderableWidget(button_machine);
		button_fluid = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_fluid"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(4, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 112, 50, 20).build();
		guistate.put("button:button_fluid", button_fluid);
		this.addRenderableWidget(button_fluid);
		button_close = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_close"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(5, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 122, 50, 20).build();
		guistate.put("button:button_close", button_close);
		this.addRenderableWidget(button_close);
	}
}

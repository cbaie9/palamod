package palamod.client.gui;

import palamod.world.inventory.PalahelpblockMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.PalahelpblockButtonMessage;

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

public class PalahelpblockScreen extends AbstractContainerScreen<PalahelpblockMenu> {
	private final static HashMap<String, Object> guistate = PalahelpblockMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_ore;
	Button button_trees;
	Button button_machine;
	Button button_fluid;
	ImageButton imagebutton_close_gui_nohover;
	ImageButton imagebutton_arrow_back_true_1;

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
		if (mouseX > leftPos + 153 && mouseX < leftPos + 170 && mouseY > topPos + 4 && mouseY < topPos + 21)
			guiGraphics.renderTooltip(font, Component.literal(ClosetheguitransProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 134 && mouseX < leftPos + 149 && mouseY > topPos + 5 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.palahelpblock.tooltip_back_to_palahelp_menu"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/gui176_166.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/adminshopblockoakwood.png"), this.leftPos + -1, this.topPos + 0, 0, 0, -1, -1, -1, -1);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 76, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpblock.label_palahelp_block_menu"), 6, 7, -1250068, false);
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
		button_machine = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_machine"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(2, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 95, this.topPos + 83, 60, 20).build();
		guistate.put("button:button_machine", button_machine);
		this.addRenderableWidget(button_machine);
		button_fluid = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_fluid"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(3, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 112, 50, 20).build();
		guistate.put("button:button_fluid", button_fluid);
		this.addRenderableWidget(button_fluid);
		imagebutton_close_gui_nohover = new ImageButton(this.leftPos + 153, this.topPos + 4, 17, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_close_gui_nohover.png"), 17, 34, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(4, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_close_gui_nohover", imagebutton_close_gui_nohover);
		this.addRenderableWidget(imagebutton_close_gui_nohover);
		imagebutton_arrow_back_true_1 = new ImageButton(this.leftPos + 133, this.topPos + 4, 17, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_back_true_1.png"), 17, 34, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpblockButtonMessage(5, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_back_true_1", imagebutton_arrow_back_true_1);
		this.addRenderableWidget(imagebutton_arrow_back_true_1);
	}
}

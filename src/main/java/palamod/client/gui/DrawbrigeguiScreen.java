package palamod.client.gui;

import palamod.world.inventory.DrawbrigeguiMenu;

import palamod.network.DrawbrigeguiButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DrawbrigeguiScreen extends AbstractContainerScreen<DrawbrigeguiMenu> {
	private final static HashMap<String, Object> guistate = DrawbrigeguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arrow_down0001;
	ImageButton imagebutton_arrow_right01;
	ImageButton imagebutton_arrow_up01;
	ImageButton imagebutton_arrow_left01;

	public DrawbrigeguiScreen(DrawbrigeguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 280;
		this.imageHeight = 160;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/drawbrigegui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 280, 160, 280, 160);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 41, this.topPos + 34, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 15, this.topPos + 8, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 15, this.topPos + 34, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 93, this.topPos + 34, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 41, this.topPos + 8, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 67, this.topPos + 8, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 93, this.topPos + 8, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 119, this.topPos + 34, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 119, this.topPos + 8, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 145, this.topPos + 8, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 145, this.topPos + 34, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 171, this.topPos + 8, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 171, this.topPos + 34, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 197, this.topPos + 8, 0, 0, 26, 26, 26, 26);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/big_slot.png"), this.leftPos + 197, this.topPos + 34, 0, 0, 26, 26, 26, 26);

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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_down0001 = new ImageButton(this.leftPos + 212, this.topPos + 125, 28, 32, 0, 0, 32, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_down0001.png"), 28, 64, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DrawbrigeguiButtonMessage(0, x, y, z));
				DrawbrigeguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_down0001", imagebutton_arrow_down0001);
		this.addRenderableWidget(imagebutton_arrow_down0001);
		imagebutton_arrow_right01 = new ImageButton(this.leftPos + 240, this.topPos + 95, 32, 28, 0, 0, 28, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_right01.png"), 32, 56, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DrawbrigeguiButtonMessage(1, x, y, z));
				DrawbrigeguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_right01", imagebutton_arrow_right01);
		this.addRenderableWidget(imagebutton_arrow_right01);
		imagebutton_arrow_up01 = new ImageButton(this.leftPos + 212, this.topPos + 66, 28, 32, 0, 0, 32, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_up01.png"), 28, 64, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DrawbrigeguiButtonMessage(2, x, y, z));
				DrawbrigeguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_up01", imagebutton_arrow_up01);
		this.addRenderableWidget(imagebutton_arrow_up01);
		imagebutton_arrow_left01 = new ImageButton(this.leftPos + 179, this.topPos + 95, 32, 28, 0, 0, 28, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_left01.png"), 32, 56, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DrawbrigeguiButtonMessage(3, x, y, z));
				DrawbrigeguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_left01", imagebutton_arrow_left01);
		this.addRenderableWidget(imagebutton_arrow_left01);
	}
}

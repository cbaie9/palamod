package palamod.client.gui;

import palamod.world.inventory.SticknewhelpMenu;

import palamod.procedures.Getlabelnewstick1Procedure;

import palamod.network.SticknewhelpButtonMessage;

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

public class SticknewhelpScreen extends AbstractContainerScreen<SticknewhelpMenu> {
	private final static HashMap<String, Object> guistate = SticknewhelpMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_home_pixel_adminshop;
	ImageButton imagebutton_speed_stick;
	ImageButton imagebutton_jump_stick2;
	ImageButton imagebutton_hyperjump_stick;
	ImageButton imagebutton_heal_stick;
	ImageButton imagebutton_damage_stick;
	ImageButton imagebutton_strenghtstick;
	ImageButton imagebutton_stickofgod;

	public SticknewhelpScreen(SticknewhelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 225;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/sticknewhelp.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 400, 225, 400, 225);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 199, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 299, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_new.png"), this.leftPos + 331, this.topPos + 144, 0, 0, 24, 10, 24, 10);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.sticknewhelp.label_palahelp_stick"), 157, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.sticknewhelp.label_effect_of_the_stick"), 4, 26, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.sticknewhelp.label_palamachine"), 61, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.sticknewhelp.label_craft"), 3, 83, -12829636, false);
		guiGraphics.drawString(this.font,

				Getlabelnewstick1Procedure.execute(world, entity), 4, 39, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 379, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(0, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 359, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(1, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 342, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(2, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_speed_stick = new ImageButton(this.leftPos + 6, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_speed_stick.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(3, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_speed_stick", imagebutton_speed_stick);
		this.addRenderableWidget(imagebutton_speed_stick);
		imagebutton_jump_stick2 = new ImageButton(this.leftPos + 23, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_jump_stick2.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(4, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_jump_stick2", imagebutton_jump_stick2);
		this.addRenderableWidget(imagebutton_jump_stick2);
		imagebutton_hyperjump_stick = new ImageButton(this.leftPos + 42, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_hyperjump_stick.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(5, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_hyperjump_stick", imagebutton_hyperjump_stick);
		this.addRenderableWidget(imagebutton_hyperjump_stick);
		imagebutton_heal_stick = new ImageButton(this.leftPos + 61, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_heal_stick.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(6, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_heal_stick", imagebutton_heal_stick);
		this.addRenderableWidget(imagebutton_heal_stick);
		imagebutton_damage_stick = new ImageButton(this.leftPos + 79, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_damage_stick.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(7, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_damage_stick", imagebutton_damage_stick);
		this.addRenderableWidget(imagebutton_damage_stick);
		imagebutton_strenghtstick = new ImageButton(this.leftPos + 95, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_strenghtstick.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(8, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_strenghtstick", imagebutton_strenghtstick);
		this.addRenderableWidget(imagebutton_strenghtstick);
		imagebutton_stickofgod = new ImageButton(this.leftPos + 113, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_stickofgod.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new SticknewhelpButtonMessage(9, x, y, z));
				SticknewhelpButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_stickofgod", imagebutton_stickofgod);
		this.addRenderableWidget(imagebutton_stickofgod);
	}
}

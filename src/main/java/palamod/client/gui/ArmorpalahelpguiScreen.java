package palamod.client.gui;

import palamod.world.inventory.ArmorpalahelpguiMenu;

import palamod.network.ArmorpalahelpguiButtonMessage;

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

public class ArmorpalahelpguiScreen extends AbstractContainerScreen<ArmorpalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = ArmorpalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_left_gray_line;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_home_pixel_adminshop;

	public ArmorpalahelpguiScreen(ArmorpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/armorpalahelpgui.png"), this.leftPos + -1, this.topPos + 1, 0, 0, 300, 200, 300, 200);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/amethyst_helmet.png"), this.leftPos + 12, this.topPos + 43, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/amethyst_chestplate.png"), this.leftPos + 12, this.topPos + 69, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/amethyst_leggings.png"), this.leftPos + 11, this.topPos + 98, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/amethyst_boots.png"), this.leftPos + 11, this.topPos + 124, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/endium_helmet.png"), this.leftPos + 221, this.topPos + 45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/endium_chestplate.png"), this.leftPos + 222, this.topPos + 70, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/endium_leggings.png"), this.leftPos + 221, this.topPos + 100, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/endium_boots.png"), this.leftPos + 221, this.topPos + 125, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_chestplate.png"), this.leftPos + 145, this.topPos + 70, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_green_chestplate.png"), this.leftPos + 126, this.topPos + 70, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_green_boots.png"), this.leftPos + 126, this.topPos + 124, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_green_helmet.png"), this.leftPos + 126, this.topPos + 45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_green_leggings.png"), this.leftPos + 126, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_helmet.png"), this.leftPos + 145, this.topPos + 45, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_leggings.png"), this.leftPos + 143, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_boots.png"), this.leftPos + 143, this.topPos + 124, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/titane_helmet.png"), this.leftPos + 61, this.topPos + 43, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/titane_chestplate.png"), this.leftPos + 62, this.topPos + 69, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/titane_leggings.png"), this.leftPos + 59, this.topPos + 98, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/titane_boots.png"), this.leftPos + 60, this.topPos + 124, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 199, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_45"), 29, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_5"), 34, 74, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_4"), 32, 101, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_451"), 29, 126, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_452"), 81, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_453"), 79, 126, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_51"), 79, 102, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_52"), 86, 74, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_454"), 175, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_night_vision_ii"), 151, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_65"), 176, 71, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_force"), 176, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_55"), 175, 97, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_haste"), 178, 110, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_5_speed"), 163, 127, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_53"), 240, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_7"), 246, 69, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_551"), 238, 96, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_552"), 241, 119, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_force1"), 242, 80, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_haste1"), 240, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_speed"), 241, 128, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_palahelp_armor"), 99, 5, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_left_gray_line = new ImageButton(this.leftPos + -1, this.topPos + 0, 100, 24, 0, 0, 24, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_left_gray_line.png"), 100, 48, e -> {
		});
		guistate.put("button:imagebutton_left_gray_line", imagebutton_left_gray_line);
		this.addRenderableWidget(imagebutton_left_gray_line);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 254, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ArmorpalahelpguiButtonMessage(1, x, y, z));
				ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 275, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ArmorpalahelpguiButtonMessage(2, x, y, z));
				ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 235, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ArmorpalahelpguiButtonMessage(3, x, y, z));
				ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}

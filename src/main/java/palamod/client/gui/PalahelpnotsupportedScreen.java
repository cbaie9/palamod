package palamod.client.gui;

import palamod.world.inventory.PalahelpnotsupportedMenu;

import palamod.network.PalahelpnotsupportedButtonMessage;

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

public class PalahelpnotsupportedScreen extends AbstractContainerScreen<PalahelpnotsupportedMenu> {
	private final static HashMap<String, Object> guistate = PalahelpnotsupportedMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_language_btte;

	public PalahelpnotsupportedScreen(PalahelpnotsupportedMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/gui176_166.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/sad_ntsuport.png"), this.leftPos + 10, this.topPos + 26, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/sad_ntsuport.png"), this.leftPos + 137, this.topPos + 26, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/sad_ntsuport.png"), this.leftPos + 7, this.topPos + 127, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/sad_ntsuport.png"), this.leftPos + 136, this.topPos + 129, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpnotsupported.label_an_error_has_been_encountred"), 10, 62, -6750055, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpnotsupported.label_palahelp_error"), 46, 6, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpnotsupported.label_your_language_is_not_supported"), 5, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpnotsupported.label_change_language"), 47, 128, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpnotsupportedButtonMessage(0, x, y, z));
				PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 133, this.topPos + 3, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpnotsupportedButtonMessage(1, x, y, z));
				PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_language_btte = new ImageButton(this.leftPos + 76, this.topPos + 141, 21, 10, 0, 0, 10, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_language_btte.png"), 21, 20, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelpnotsupportedButtonMessage(2, x, y, z));
				PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_language_btte", imagebutton_language_btte);
		this.addRenderableWidget(imagebutton_language_btte);
	}
}

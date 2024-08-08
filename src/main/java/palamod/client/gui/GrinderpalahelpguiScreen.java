package palamod.client.gui;

import palamod.world.inventory.GrinderpalahelpguiMenu;

import palamod.procedures.Palahelpgrindet16Procedure;
import palamod.procedures.Palahelpgrinder19Procedure;
import palamod.procedures.Palahelpgrinder18Procedure;
import palamod.procedures.Palahelpgrinder17Procedure;
import palamod.procedures.Palahelpgrinder15Procedure;
import palamod.procedures.Palahelpgrinder14Procedure;
import palamod.procedures.Palahelpgrinder13Procedure;
import palamod.procedures.Palahelpgrinder12Procedure;
import palamod.procedures.Palahelpgrinder11Procedure;
import palamod.procedures.Palahelpgrinder10Procedure;

import palamod.network.GrinderpalahelpguiButtonMessage;

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

public class GrinderpalahelpguiScreen extends AbstractContainerScreen<GrinderpalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = GrinderpalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_revert_adminshop_arrow;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_home_pixel_adminshop;
	ImageButton imagebutton_example_gui_button;

	public GrinderpalahelpguiScreen(GrinderpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 330;
		this.imageHeight = 185;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinderpalahelpgui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 330, 185, 330, 185);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 199, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 229, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder_block_front16.png"), this.leftPos + 3, this.topPos + 4, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.grinderpalahelpgui.label_grinder"), 98, 7, -1, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder10Procedure.execute(entity), 3, 40, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder11Procedure.execute(entity), 3, 53, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder12Procedure.execute(entity), 3, 66, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder13Procedure.execute(entity), 2, 78, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder14Procedure.execute(entity), 3, 90, -256, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder15Procedure.execute(entity), 2, 99, -256, false);
		guiGraphics.drawString(this.font,

				Palahelpgrindet16Procedure.execute(entity), 3, 110, -8504309, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder17Procedure.execute(entity), 3, 120, -816878, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.grinderpalahelpgui.label_empty"), 54, 71, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder18Procedure.execute(entity), 4, 132, -3335911, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder19Procedure.execute(entity), 4, 145, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.grinderpalahelpgui.label_2_min_12"), 20, 14, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 308, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpguiButtonMessage(0, x, y, z));
				GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_revert_adminshop_arrow = new ImageButton(this.leftPos + 270, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_revert_adminshop_arrow.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpguiButtonMessage(1, x, y, z));
				GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_revert_adminshop_arrow", imagebutton_revert_adminshop_arrow);
		this.addRenderableWidget(imagebutton_revert_adminshop_arrow);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 250, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpguiButtonMessage(2, x, y, z));
				GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 230, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpguiButtonMessage(3, x, y, z));
				GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_example_gui_button = new ImageButton(this.leftPos + 288, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_example_gui_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderpalahelpguiButtonMessage(4, x, y, z));
				GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_example_gui_button", imagebutton_example_gui_button);
		this.addRenderableWidget(imagebutton_example_gui_button);
	}
}

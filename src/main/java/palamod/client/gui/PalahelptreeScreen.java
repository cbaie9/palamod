package palamod.client.gui;

import palamod.world.inventory.PalahelptreeMenu;

import palamod.procedures.Palahelptree7Procedure;
import palamod.procedures.Palahelptree6Procedure;
import palamod.procedures.Palahelptree5Procedure;
import palamod.procedures.Palahelptree4Procedure;
import palamod.procedures.Palahelptree3Procedure;
import palamod.procedures.Palahelptree2Procedure;
import palamod.procedures.Palahelptree1Procedure;
import palamod.procedures.Palahelptree0Procedure;

import palamod.network.PalahelptreeButtonMessage;

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

public class PalahelptreeScreen extends AbstractContainerScreen<PalahelptreeMenu> {
	private final static HashMap<String, Object> guistate = PalahelptreeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_home_pixel_adminshop;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_cross_no_button;

	public PalahelptreeScreen(PalahelptreeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/palahelptree.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 220, 166, 220, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/erable_log.png"), this.leftPos + 10, this.topPos + 102, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/jacaranda_log.png"), this.leftPos + 10, this.topPos + 34, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/judeecercis_log.png"), this.leftPos + 10, this.topPos + 67, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/ostrya_log.png"), this.leftPos + 10, this.topPos + 133, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 77, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 119, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font,

				Palahelptree0Procedure.execute(entity), 38, 96, -52480, false);
		guiGraphics.drawString(this.font,

				Palahelptree1Procedure.execute(entity), 38, 108, -52480, false);
		guiGraphics.drawString(this.font,

				Palahelptree2Procedure.execute(entity), 35, 30, -6750055, false);
		guiGraphics.drawString(this.font,

				Palahelptree3Procedure.execute(entity), 35, 44, -6750055, false);
		guiGraphics.drawString(this.font,

				Palahelptree4Procedure.execute(entity), 35, 65, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelptree5Procedure.execute(entity), 35, 77, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelptree6Procedure.execute(entity), 38, 131, -13434727, false);
		guiGraphics.drawString(this.font,

				Palahelptree7Procedure.execute(entity), 38, 144, -13434727, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelptree.label_palahelp_trees"), 59, 7, -1, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 153, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelptreeButtonMessage(0, x, y, z));
				PalahelptreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 173, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelptreeButtonMessage(1, x, y, z));
				PalahelptreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 195, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PalahelptreeButtonMessage(2, x, y, z));
				PalahelptreeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}

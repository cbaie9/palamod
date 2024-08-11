package palamod.client.gui;

import palamod.world.inventory.FluidpalahelpMenu;

import palamod.network.FluidpalahelpButtonMessage;

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

public class FluidpalahelpScreen extends AbstractContainerScreen<FluidpalahelpMenu> {
	private final static HashMap<String, Object> guistate = FluidpalahelpMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_home_pixel_adminshop;

	public FluidpalahelpScreen(FluidpalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fluidpalahelp.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 200, 200, 200, 200);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/6_fluid.png"), this.leftPos + 7, this.topPos + 37, 0, 0, 22, 21, 22, 21);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/7angel.png"), this.leftPos + 5, this.topPos + 96, 0, 0, 21, 21, 21, 21);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_fluid"), 49, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_fake_water_un_type_deau_invisi"), 2, 63, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_vous_fait_des_dgats_peut_peut"), 3, 73, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_mpecher_la_legendary_stone_de_p"), 4, 86, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_angelique_water_type_deau_qui"), 4, 122, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_soigne"), 3, 132, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 178, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new FluidpalahelpButtonMessage(0, x, y, z));
				FluidpalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 158, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new FluidpalahelpButtonMessage(1, x, y, z));
				FluidpalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 139, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new FluidpalahelpButtonMessage(2, x, y, z));
				FluidpalahelpButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}

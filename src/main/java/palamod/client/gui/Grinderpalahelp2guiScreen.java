package palamod.client.gui;

import palamod.world.inventory.Grinderpalahelp2guiMenu;

import palamod.procedures.Palahelpgrinder32Procedure;
import palamod.procedures.Palahelpgrinder28Procedure;
import palamod.procedures.Palahelpgrinder27Procedure;
import palamod.procedures.Palahelpgrinder26Procedure;
import palamod.procedures.Palahelpgrinder25Procedure;
import palamod.procedures.Palahelpgrinder24Procedure;
import palamod.procedures.Palahelpgrinder23Procedure;
import palamod.procedures.Palahelpgrinder22Procedure;
import palamod.procedures.Palahelpgrinder21Procedure;
import palamod.procedures.Palahelpgrinder20Procedure;
import palamod.procedures.Palahelpgrinder202Procedure;

import palamod.network.Grinderpalahelp2guiButtonMessage;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class Grinderpalahelp2guiScreen extends AbstractContainerScreen<Grinderpalahelp2guiMenu> {
	private final static HashMap<String, Object> guistate = Grinderpalahelp2guiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_home_pixel_adminshop;
	ImageButton imagebutton_example_gui_button;

	public Grinderpalahelp2guiScreen(Grinderpalahelp2guiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 330;
		this.imageHeight = 200;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/grinderpalahelp_2gui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 330, 200, 330, 200);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/grinder_block_front.png"), this.leftPos + 68, this.topPos + 3, 0, 0, -1, -1, -1, -1);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/1.png"), this.leftPos + 16, this.topPos + 144, 0, 0, 45, 46, 45, 46);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/2.png"), this.leftPos + 95, this.topPos + 145, 0, 0, 46, 46, 46, 46);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/1.png"), this.leftPos + 191, this.topPos + 145, 0, 0, 45, 46, 45, 46);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 199, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 229, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/grinder_block_front16.png"), this.leftPos + 7, this.topPos + 5, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.grinderpalahelp_2gui.label_22"), 29, 12, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.grinderpalahelp_2gui.label_grinder_wiki"), 118, 7, -1, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder20Procedure.execute(entity), 3, 37, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder21Procedure.execute(entity), 2, 57, -4385001, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder22Procedure.execute(entity), 4, 68, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder23Procedure.execute(entity), 4, 80, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder25Procedure.execute(entity), 17, 133, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder24Procedure.execute(entity), 3, 107, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder26Procedure.execute(entity), 95, 133, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder27Procedure.execute(entity), 192, 133, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder28Procedure.execute(entity), 3, 120, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder32Procedure.execute(entity), 4, 93, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpgrinder202Procedure.execute(entity), 2, 46, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 307, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new Grinderpalahelp2guiButtonMessage(0, x, y, z));
						Grinderpalahelp2guiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 264, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new Grinderpalahelp2guiButtonMessage(1, x, y, z));
						Grinderpalahelp2guiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 244, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new Grinderpalahelp2guiButtonMessage(2, x, y, z));
						Grinderpalahelp2guiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_example_gui_button = new ImageButton(this.leftPos + 284, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/example_gui_button.png"), ResourceLocation.parse("palamod:textures/screens/example_gui_button_poi.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new Grinderpalahelp2guiButtonMessage(3, x, y, z));
						Grinderpalahelp2guiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_example_gui_button", imagebutton_example_gui_button);
		this.addRenderableWidget(imagebutton_example_gui_button);
	}
}

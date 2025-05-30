package palamod.client.gui;

import palamod.world.inventory.XpbushpalahelpguiMenu;

import palamod.network.XpbushpalahelpguiButtonMessage;

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

public class XpbushpalahelpguiScreen extends AbstractContainerScreen<XpbushpalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = XpbushpalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_home_pixel_adminshop;

	public XpbushpalahelpguiScreen(XpbushpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/xpbushpalahelpgui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 200, 166, 200, 166);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/xp_berry.png"), this.leftPos + 4, this.topPos + 80, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/berry_xp_bush_fancy.png"), this.leftPos + 6, this.topPos + 124, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_xp_bush"), 4, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_xp_bush_est_une_plant_qui_fait_p"), 2, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_des_xp_berries_qui_vous_donne_de"), 2, 35, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_quand_vous_faites_clique_droit_d"), 2, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_vous_pouvez_les_compresser_en"), 2, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_compressed_xp_berries"), 2, 67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_xp_berry"), 38, 92, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_xp_bush1"), 43, 134, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 158, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new XpbushpalahelpguiButtonMessage(0, x, y, z));
						XpbushpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 177, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new XpbushpalahelpguiButtonMessage(1, x, y, z));
						XpbushpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 139, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new XpbushpalahelpguiButtonMessage(2, x, y, z));
						XpbushpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}

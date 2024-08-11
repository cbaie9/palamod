package palamod.client.gui;

import palamod.world.inventory.ItemmenupalahelpMenu;

import palamod.network.ItemmenupalahelpButtonMessage;

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

public class ItemmenupalahelpScreen extends AbstractContainerScreen<ItemmenupalahelpMenu> {
	private final static HashMap<String, Object> guistate = ItemmenupalahelpMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_legendary_stone;
	Button button_armor;
	Button button_xp_bush_xp_berries;
	Button button_newstck;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_home_pixel_adminshop;

	public ItemmenupalahelpScreen(ItemmenupalahelpMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/gui176_166.png"), this.leftPos + -1, this.topPos + 1, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/forest32.png"), this.leftPos + 32, this.topPos + 56, 0, 0, 32, 16, 32, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/desert16.png"), this.leftPos + 8, this.topPos + 24, 0, 0, -1, -1, -1, -1);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fish32.png"), this.leftPos + 24, this.topPos + 24, 0, 0, -1, -1, -1, -1);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/lake32.png"), this.leftPos + 8, this.topPos + 56, 0, 0, -1, -1, -1, -1);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/nether32.png"), this.leftPos + 8, this.topPos + 87, 0, 0, -1, -1, -1, -1);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/plains16.png"), this.leftPos + 8, this.topPos + 40, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.itemmenupalahelp.label_item_menu"), 3, 7, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_legendary_stone = Button.builder(Component.translatable("gui.palamod.itemmenupalahelp.button_legendary_stone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(0, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 26, 100, 20).build();
		guistate.put("button:button_legendary_stone", button_legendary_stone);
		this.addRenderableWidget(button_legendary_stone);
		button_armor = Button.builder(Component.translatable("gui.palamod.itemmenupalahelp.button_armor"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(1, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 76, 61, 20).build();
		guistate.put("button:button_armor", button_armor);
		this.addRenderableWidget(button_armor);
		button_xp_bush_xp_berries = Button.builder(Component.translatable("gui.palamod.itemmenupalahelp.button_xp_bush_xp_berries"), e -> {
		}).bounds(this.leftPos + 40, this.topPos + 101, 125, 20).build();
		guistate.put("button:button_xp_bush_xp_berries", button_xp_bush_xp_berries);
		this.addRenderableWidget(button_xp_bush_xp_berries);
		button_newstck = Button.builder(Component.translatable("gui.palamod.itemmenupalahelp.button_newstck"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(3, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 51, 61, 20).build();
		guistate.put("button:button_newstck", button_newstck);
		this.addRenderableWidget(button_newstck);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(4, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 133, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(5, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 114, this.topPos + 6, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ItemmenupalahelpButtonMessage(6, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}

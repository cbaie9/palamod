package palamod.client.gui;

import palamod.world.inventory.ArmorpalahelpguiMenu;

import palamod.network.ArmorpalahelpguiButtonMessage;

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

public class ArmorpalahelpguiScreen extends AbstractContainerScreen<ArmorpalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = ArmorpalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
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
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 30 && mouseY < topPos + 47)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_amethyst_armor"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 77 && mouseY > topPos + 69 && mouseY < topPos + 88)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 89 && mouseY < topPos + 106)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_e"), mouseX, mouseY);
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 30 && mouseY < topPos + 47)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_titane_armor_set"), mouseX, mouseY);
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 69 && mouseY < topPos + 87)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable1"), mouseX, mouseY);
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 69 && mouseY < topPos + 87)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable2"), mouseX, mouseY);
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 69 && mouseY < topPos + 87)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable3"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 158 && mouseY < topPos + 176)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable4"), mouseX, mouseY);
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 158 && mouseY < topPos + 176)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable5"), mouseX, mouseY);
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 89 && mouseY < topPos + 106)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_e1"), mouseX, mouseY);
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 89 && mouseY < topPos + 106)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m"), mouseX, mouseY);
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 89 && mouseY < topPos + 106)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m1"), mouseX, mouseY);
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 178 && mouseY < topPos + 195)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m2"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 178 && mouseY < topPos + 195)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m3"), mouseX, mouseY);
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 158 && mouseY < topPos + 176)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_in_in_lucky_bl"), mouseX, mouseY);
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 158 && mouseY < topPos + 176)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_in_in_lucky_bl1"), mouseX, mouseY);
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 30 && mouseY < topPos + 47)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_paladium_armor_set"), mouseX, mouseY);
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 30 && mouseY < topPos + 47)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_endium_armor_set"), mouseX, mouseY);
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 119 && mouseY < topPos + 136)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_travel_armor_set"), mouseX, mouseY);
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 119 && mouseY < topPos + 136)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_rainbow_armor_set"), mouseX, mouseY);
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 119 && mouseY < topPos + 136)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_invisible_armor_set"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 119 && mouseY < topPos + 136)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_mixed_endium_armor_set"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/armorpalahelpgui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 300, 200, 300, 200);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_palahelp_armor"), 102, 4, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_amethyst"), 11, 20, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_titane_set"), 79, 20, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_paladium_set"), 147, 20, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_endium_set"), 215, 20, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_mixed_set"), 11, 109, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_invisible_set"), 79, 109, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_rainbow_set"), 149, 109, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_travel_set"), 215, 109, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name"), 37, 34, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name1"), 104, 35, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name2"), 173, 35, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name3"), 241, 35, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name4"), 33, 123, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name5"), 101, 122, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name6"), 169, 123, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name7"), 237, 122, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect2"), 169, 52, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect3"), 238, 51, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect4"), 33, 142, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect5"), 100, 143, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect6"), 169, 142, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect7"), 238, 141, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_early_game"), 35, 93, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_early"), 106, 92, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_mid_game"), 170, 93, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_end_game"), 235, 93, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_midend"), 34, 180, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_na"), 112, 181, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_na1"), 178, 181, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_na2"), 237, 181, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable"), 30, 74, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable1"), 97, 74, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable2"), 166, 73, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable3"), 234, 74, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable4"), 30, 162, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_lb_normal"), 97, 162, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_lb_classic"), 166, 163, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable5"), 234, 162, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 254, this.topPos + 4, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_back_true_1.png"), ResourceLocation.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(0, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 275, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(1, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 235, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(2, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
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

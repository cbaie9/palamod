package palamod.client.gui;

import palamod.world.inventory.ArmorpalahelpguiMenu;

import palamod.network.ArmorpalahelpguiButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class ArmorpalahelpguiScreen extends AbstractContainerScreen<ArmorpalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_if_bugged;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_home_pixel_adminshop;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/armorpalahelpgui.png");

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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 30 && mouseY < topPos + 47) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_amethyst_armor").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_amethyst_armor").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 77 && mouseY > topPos + 69 && mouseY < topPos + 88) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 89 && mouseY < topPos + 106) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_e").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_e").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 30 && mouseY < topPos + 47) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_titane_armor_set").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_titane_armor_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 69 && mouseY < topPos + 87) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable1").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 69 && mouseY < topPos + 87) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable2").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable2").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 69 && mouseY < topPos + 87) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable3").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable3").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 158 && mouseY < topPos + 176) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable4").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable4").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 158 && mouseY < topPos + 176) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable5").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable5").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 89 && mouseY < topPos + 106) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_e1").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_e1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 89 && mouseY < topPos + 106) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 89 && mouseY < topPos + 106) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m1").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 178 && mouseY < topPos + 195) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m2").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m2").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 178 && mouseY < topPos + 195) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m3").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m3").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 158 && mouseY < topPos + 176) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_in_in_lucky_bl").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_in_in_lucky_bl").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 158 && mouseY < topPos + 176) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_in_in_lucky_bl1").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_in_in_lucky_bl1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 30 && mouseY < topPos + 47) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_paladium_armor_set").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_paladium_armor_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 30 && mouseY < topPos + 47) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_endium_armor_set").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_endium_armor_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 119 && mouseY < topPos + 136) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_travel_armor_set").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_travel_armor_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 119 && mouseY < topPos + 136) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_rainbow_armor_set").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_rainbow_armor_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 119 && mouseY < topPos + 136) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_invisible_armor_set").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_invisible_armor_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 119 && mouseY < topPos + 136) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_mixed_endium_armor_set").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_mixed_endium_armor_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 258 && mouseY > topPos + 49 && mouseY < topPos + 67) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 49 && mouseY < topPos + 67) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh1").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 258 && mouseX < leftPos + 280 && mouseY > topPos + 49 && mouseY < topPos + 67) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_full_set_invisible").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_full_set_invisible").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 138 && mouseY < topPos + 156) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh2").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh2").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 138 && mouseY < topPos + 156) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh3").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh3").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 138 && mouseY < topPos + 156) {
			if (Component.translatable("gui.palamod.armorpalahelpgui.tooltip_underwater_breathing_helmet").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.tooltip_underwater_breathing_helmet").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 300, 200, 300, 200);
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
		int heightPadding = 0;
		int yOffset = 0;
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_palahelp_armor").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 102, 4 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_amethyst").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 11, 20 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_titane_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 79, 20 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_paladium_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 147, 20 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_endium_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 215, 20 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_mixed_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 11, 109 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_invisible_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 79, 109 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_rainbow_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 149, 109 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_travel_set").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 215, 109 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_name").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 37, 34 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_name1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 104, 35 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_name2").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 173, 35 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_name3").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 241, 35 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_name4").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 33, 123 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_name5").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 101, 122 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_name6").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 169, 123 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_name7").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 237, 122 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_effect2").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 169, 52 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_effect3").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 238, 51 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_effect4").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 33, 142 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_effect5").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 100, 143 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_effect7").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 238, 141 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_early_game").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 35, 93 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_early").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 106, 92 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_mid_game").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 170, 93 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_end_game").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 235, 93 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_midend").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 34, 180 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_na").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 112, 181 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_na1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 178, 181 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_na2").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 237, 181 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_craftable").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 30, 74 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_craftable1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 97, 74 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_craftable2").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 166, 73 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_craftable3").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 234, 74 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_craftable4").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 30, 162 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_lb_normal").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 97, 162 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_lb_classic").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 166, 163 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.armorpalahelpgui.label_craftable5").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 234, 162 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		button_if_bugged = Button.builder(Component.translatable("gui.palamod.armorpalahelpgui.button_if_bugged"), e -> {
			int x = ArmorpalahelpguiScreen.this.x;
			int y = ArmorpalahelpguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(0, x, y, z));
				ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 1, 57, 20).build();
		this.addRenderableWidget(button_if_bugged);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 254, this.topPos + 4, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_back_true_1.png"), ResourceLocation.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
					int x = ArmorpalahelpguiScreen.this.x;
					int y = ArmorpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(1, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 275, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = ArmorpalahelpguiScreen.this.x;
					int y = ArmorpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(2, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 235, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = ArmorpalahelpguiScreen.this.x;
					int y = ArmorpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(3, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}
package palamod.client.gui;

import palamod.world.inventory.GrinderpalahelpguiMenu;

import palamod.procedures.TRADreturntosumarryProcedure;

import palamod.network.GrinderpalahelpguiButtonMessage;

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
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class GrinderpalahelpguiScreen extends AbstractContainerScreen<GrinderpalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_example_gui_button;
	private ImageButton imagebutton_sommaire_btn;
	private ImageButton imagebutton_arrow_palahelp_right_off;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/underline_48px.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/underline_48px.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/underline_48px.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/underline_48px.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/grinder_palahelp_layer1.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/grinder_palahelp_layer2.png");

	public GrinderpalahelpguiScreen(GrinderpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 319;
		this.imageHeight = 180;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 10 && mouseX < leftPos + 156 && mouseY > topPos + 35 && mouseY < topPos + 64) {
			if (Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_list_of_upgrades_that_the_mod_ha").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_list_of_upgrades_that_the_mod_ha").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 14 && mouseX < leftPos + 75 && mouseY > topPos + 109 && mouseY < topPos + 121) {
			if (Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_materials_needed_for_the_grinder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_materials_needed_for_the_grinder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 175 && mouseX < leftPos + 225 && mouseY > topPos + 92 && mouseY < topPos + 142) {
			if (Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_layer_1_and_3_of_the_grinder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_layer_1_and_3_of_the_grinder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 225 && mouseX < leftPos + 275 && mouseY > topPos + 92 && mouseY < topPos + 142) {
			if (Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_layer_2_of_the_grinder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_layer_2_of_the_grinder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 129 && mouseX < leftPos + 147 && mouseY > topPos + -2 && mouseY < topPos + 18) {
			if (TRADreturntosumarryProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(TRADreturntosumarryProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 14 && mouseX < leftPos + 55 && mouseY > topPos + 144 && mouseY < topPos + 165) {
			if (Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_return_to_previous_page_palahe").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_return_to_previous_page_palahe").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 278 && mouseX < leftPos + 304 && mouseY > topPos + 107 && mouseY < topPos + 137) {
			if (Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_example_graphical_user_interface").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_example_graphical_user_interface").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 262 && mouseX < leftPos + 298 && mouseY > topPos + 146 && mouseY < topPos + 166) {
			if (Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_go_to_palahelp_crusher").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.tooltip_go_to_palahelp_crusher").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 320, 180, 320, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + 10, this.topPos + 39, 0, 0, 48, 16, 48, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + 58, this.topPos + 39, 0, 0, 48, 16, 48, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 105, this.topPos + 39, 0, 0, 48, 16, 48, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 15, this.topPos + 105, 0, 0, 48, 16, 48, 16);
		guiGraphics.blit(IMAGE_5, this.leftPos + 175, this.topPos + 92, 0, 0, 50, 50, 50, 50);
		guiGraphics.blit(IMAGE_6, this.leftPos + 225, this.topPos + 92, 0, 0, 50, 50, 50, 50);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.label_grinder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 27, 12 + yOffset, -6750208, true);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.label_the_grinder_is_a_machine_that_cr").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 15, 25 + yOffset, -13421773, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.label_you_can_also_apply_special_craft").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 13, 70 + yOffset, -10066330, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.label_requirement").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 14, 111 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.label_beta4test_v2001").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 176, 159 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.label_the_grinder_is_a_structurenso_y").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 173, 26 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.grinderpalahelpgui.label_here_the_3_layer_ofn_the_grinde").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 171, 71 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 15, this.topPos + 145, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_on.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(0, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_example_gui_button = new ImageButton(this.leftPos + 284, this.topPos + 116, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/example_gui_button.png"), ResourceLocation.parse("palamod:textures/screens/example_gui_button_poi.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(1, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_example_gui_button);
		imagebutton_sommaire_btn = new ImageButton(this.leftPos + 131, this.topPos + -1, 14, 18,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png"), ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(2, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_sommaire_btn);
		imagebutton_arrow_palahelp_right_off = new ImageButton(this.leftPos + 262, this.topPos + 146, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_right_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_right_on.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(3, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_palahelp_right_off);
	}
}
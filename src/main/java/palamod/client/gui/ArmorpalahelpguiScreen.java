package palamod.client.gui;

import palamod.world.inventory.ArmorpalahelpguiMenu;

import palamod.network.ArmorpalahelpguiButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class ArmorpalahelpguiScreen extends AbstractContainerScreen<ArmorpalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_if_bugged;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_home_pixel_adminshop;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/armorpalahelpgui.png");

	public ArmorpalahelpguiScreen(ArmorpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 300, 200);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 30 && mouseY < topPos + 47) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_amethyst_armor"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 77 && mouseY > topPos + 69 && mouseY < topPos + 88) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 89 && mouseY < topPos + 106) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_e"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 30 && mouseY < topPos + 47) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_titane_armor_set"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 69 && mouseY < topPos + 87) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 69 && mouseY < topPos + 87) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable2"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 69 && mouseY < topPos + 87) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable3"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 158 && mouseY < topPos + 176) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable4"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 158 && mouseY < topPos + 176) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_craftable5"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 89 && mouseY < topPos + 106) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_e1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 89 && mouseY < topPos + 106) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 89 && mouseY < topPos + 106) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 178 && mouseY < topPos + 195) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m2"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 178 && mouseY < topPos + 195) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_is_obtenable_in_the_m3"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 158 && mouseY < topPos + 176) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_in_in_lucky_bl"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 158 && mouseY < topPos + 176) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_this_armor_set_is_in_in_lucky_bl1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 30 && mouseY < topPos + 47) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_paladium_armor_set"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 30 && mouseY < topPos + 47) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_endium_armor_set"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 119 && mouseY < topPos + 136) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_travel_armor_set"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 119 && mouseY < topPos + 136) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_rainbow_armor_set"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 119 && mouseY < topPos + 136) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_invisible_armor_set"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 119 && mouseY < topPos + 136) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_mixed_endium_armor_set"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 258 && mouseY > topPos + 49 && mouseY < topPos + 67) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 166 && mouseX < leftPos + 212 && mouseY > topPos + 49 && mouseY < topPos + 67) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh1"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 258 && mouseX < leftPos + 280 && mouseY > topPos + 49 && mouseY < topPos + 67) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_full_set_invisible"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 30 && mouseX < leftPos + 76 && mouseY > topPos + 138 && mouseY < topPos + 156) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh2"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 98 && mouseX < leftPos + 144 && mouseY > topPos + 138 && mouseY < topPos + 156) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_night_vision_helmet_strengh3"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 234 && mouseX < leftPos + 280 && mouseY > topPos + 138 && mouseY < topPos + 156) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.armorpalahelpgui.tooltip_underwater_breathing_helmet"), mouseX, mouseY);
		}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 300, 200, 300, 200);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_palahelp_armor"), 102, 4, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_amethyst"), 11, 20, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_titane_set"), 79, 20, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_paladium_set"), 147, 20, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_endium_set"), 215, 20, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_mixed_set"), 11, 109, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_invisible_set"), 79, 109, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_rainbow_set"), 149, 109, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_travel_set"), 215, 109, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name"), 37, 34, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name1"), 104, 35, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name2"), 173, 35, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name3"), 241, 35, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name4"), 33, 123, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name5"), 101, 122, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name6"), 169, 123, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_name7"), 237, 122, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect2"), 169, 52, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect3"), 238, 51, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect4"), 33, 142, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect5"), 100, 143, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_effect7"), 238, 141, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_early_game"), 35, 93, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_early"), 106, 92, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_mid_game"), 170, 93, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_end_game"), 235, 93, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_midend"), 34, 180, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_na"), 112, 181, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_na1"), 178, 181, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_na2"), 237, 181, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable"), 30, 74, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable1"), 97, 74, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable2"), 166, 73, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable3"), 234, 74, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable4"), 30, 162, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_lb_normal"), 97, 162, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_lb_classic"), 166, 163, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.armorpalahelpgui.label_craftable5"), 234, 162, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_if_bugged = Button.builder(Component.translatable("gui.palamod.armorpalahelpgui.button_if_bugged"), e -> {
			int x = ArmorpalahelpguiScreen.this.x;
			int y = ArmorpalahelpguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(0, x, y, z));
				ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 12, this.topPos + 1, 57, 20).build();
		this.addRenderableWidget(button_if_bugged);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 254, this.topPos + 4, 17, 17,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_back_true_1.png"), Identifier.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
					int x = ArmorpalahelpguiScreen.this.x;
					int y = ArmorpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(1, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 275, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = ArmorpalahelpguiScreen.this.x;
					int y = ArmorpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(2, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 235, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/home_pixel_adminshop.png"), Identifier.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = ArmorpalahelpguiScreen.this.x;
					int y = ArmorpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ArmorpalahelpguiButtonMessage(3, x, y, z));
						ArmorpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}
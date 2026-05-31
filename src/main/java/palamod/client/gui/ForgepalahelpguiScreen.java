package palamod.client.gui;

import palamod.world.inventory.ForgepalahelpguiMenu;

import palamod.procedures.Palahelpforge3Procedure;
import palamod.procedures.Palahelpforge2Procedure;
import palamod.procedures.Palahelpforge1Procedure;
import palamod.procedures.Palahelpforge0Procedure;

import palamod.network.ForgepalahelpguiButtonMessage;

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
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class ForgepalahelpguiScreen extends AbstractContainerScreen<ForgepalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_example_gui_button;
	private ImageButton imagebutton_arrow_adminshop;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/forgepalahelpgui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/left_gray_line.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/mid_gray_line.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/right_gray_line.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/forge_front_on.png");

	public ForgepalahelpguiScreen(ForgepalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 300, 175);
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
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 300, 175, 300, 175);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 199, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 7, this.topPos + 4, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.forgepalahelpgui.label_paladium_forge"), 76, 7, -1, false);
		guiGraphics.text(this.font, Palahelpforge0Procedure.execute(entity), 3, 55, -12829636, false);
		guiGraphics.text(this.font, Palahelpforge1Procedure.execute(entity), 4, 68, -12829636, false);
		guiGraphics.text(this.font, Palahelpforge2Procedure.execute(entity), 3, 81, -12829636, false);
		guiGraphics.text(this.font, Palahelpforge3Procedure.execute(entity), 3, 94, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.forgepalahelpgui.label_an_example_gui_is_available_next"), 4, 157, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 215, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/home_pixel_adminshop.png"), Identifier.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = ForgepalahelpguiScreen.this.x;
					int y = ForgepalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ForgepalahelpguiButtonMessage(0, x, y, z));
						ForgepalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 278, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = ForgepalahelpguiScreen.this.x;
					int y = ForgepalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ForgepalahelpguiButtonMessage(1, x, y, z));
						ForgepalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_example_gui_button = new ImageButton(this.leftPos + 257, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/example_gui_button.png"), Identifier.parse("palamod:textures/screens/example_gui_button_poi.png")), e -> {
					int x = ForgepalahelpguiScreen.this.x;
					int y = ForgepalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ForgepalahelpguiButtonMessage(2, x, y, z));
						ForgepalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_example_gui_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 235, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_adminshop.png"), Identifier.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = ForgepalahelpguiScreen.this.x;
					int y = ForgepalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ForgepalahelpguiButtonMessage(3, x, y, z));
						ForgepalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}
package palamod.client.gui;

import palamod.world.inventory.GrinderpalahelpguiMenu;

import palamod.procedures.*;

import palamod.network.GrinderpalahelpguiButtonMessage;

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

public class GrinderpalahelpguiScreen extends AbstractContainerScreen<GrinderpalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_revert_adminshop_arrow;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_example_gui_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/grinderpalahelpgui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/mid_gray_line.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/left_gray_line.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/right_gray_line.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/grinder_block_front16.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/mid_gray_line.png");

	public GrinderpalahelpguiScreen(GrinderpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 330, 185);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 330, 185, 330, 185);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 199, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 229, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 3, this.topPos + 4, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.grinderpalahelpgui.label_grinder"), 98, 7, -1, false);
		guiGraphics.text(this.font, Palahelpgrinder10Procedure.execute(entity), 3, 40, -12829636, false);
		guiGraphics.text(this.font, Palahelpgrinder11Procedure.execute(entity), 3, 53, -12829636, false);
		guiGraphics.text(this.font, Palahelpgrinder12Procedure.execute(entity), 3, 66, -12829636, false);
		guiGraphics.text(this.font, Palahelpgrinder13Procedure.execute(entity), 2, 78, -12829636, false);
		guiGraphics.text(this.font, Palahelpgrinder14Procedure.execute(entity), 3, 90, -256, false);
		guiGraphics.text(this.font, Palahelpgrinder15Procedure.execute(entity), 2, 99, -256, false);
		guiGraphics.text(this.font, Palahelpgrindet16Procedure.execute(entity), 3, 110, -8504309, false);
		guiGraphics.text(this.font, Palahelpgrinder17Procedure.execute(entity), 3, 120, -816878, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.grinderpalahelpgui.label_empty"), 54, 71, -12829636, false);
		guiGraphics.text(this.font, Palahelpgrinder18Procedure.execute(entity), 4, 132, -3335911, false);
		guiGraphics.text(this.font, Palahelpgrinder19Procedure.execute(entity), 4, 145, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.grinderpalahelpgui.label_2_min_12"), 20, 14, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 308, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(0, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_revert_adminshop_arrow = new ImageButton(this.leftPos + 270, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/revert_adminshop_arrow.png"), Identifier.parse("palamod:textures/screens/pointed_revert_adminshop_arrow.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(1, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_revert_adminshop_arrow);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 250, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_adminshop.png"), Identifier.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(2, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 230, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/home_pixel_adminshop.png"), Identifier.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(3, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_example_gui_button = new ImageButton(this.leftPos + 288, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/example_gui_button.png"), Identifier.parse("palamod:textures/screens/example_gui_button_poi.png")), e -> {
					int x = GrinderpalahelpguiScreen.this.x;
					int y = GrinderpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new GrinderpalahelpguiButtonMessage(4, x, y, z));
						GrinderpalahelpguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_example_gui_button);
	}
}
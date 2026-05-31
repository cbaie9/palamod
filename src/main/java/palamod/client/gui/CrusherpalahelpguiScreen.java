package palamod.client.gui;

import palamod.world.inventory.CrusherpalahelpguiMenu;

import palamod.procedures.*;

import palamod.network.CrusherpalahelpguiButtonMessage;

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

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.platform.InputConstants;

public class CrusherpalahelpguiScreen extends AbstractContainerScreen<CrusherpalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_example_gui_button;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_book_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/crusherpalahelpgui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/mid_gray_line.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/left_gray_line.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/crusher_front.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/mid_gray_line.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/right_gray_line.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/mid_gray_line.png");

	public CrusherpalahelpguiScreen(CrusherpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 420, 200);
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
		if (mouseX > leftPos + 301 && mouseX < leftPos + 321 && mouseY > topPos + 3 && mouseY < topPos + 21) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.crusherpalahelpgui.tooltip_see_craft_for_crusher"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 395 && mouseX < leftPos + 411 && mouseY > topPos + 3 && mouseY < topPos + 19) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.setComponentTooltipForNextFrame(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
		}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 1, 0, 0, 420, 200, 420, 200);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 98, this.topPos + -1, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + -2, this.topPos + -1, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 5, this.topPos + 3, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 198, this.topPos + -1, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 319, this.topPos + -1, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 275, this.topPos + -1, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.crusherpalahelpgui.label_paladium_crusher_wiki"), 134, 4, -1, false);
		guiGraphics.text(this.font, Palahelpcrusher0Procedure.execute(entity), 4, 28, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher1Procedure.execute(entity), 4, 40, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher2Procedure.execute(entity), 3, 52, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher3Procedure.execute(entity), 4, 64, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher4Procedure.execute(entity), 4, 75, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher6Procedure.execute(entity), 3, 88, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher7Procedure.execute(entity), 3, 101, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher8Procedure.execute(entity), 3, 113, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher9Procedure.execute(entity), 4, 127, -12829636, false);
		guiGraphics.text(this.font, Palahelpcrusher12Procedure.execute(entity), 5, 150, -26368, false);
		guiGraphics.text(this.font, Palahelpcrusher13Procedure.execute(entity), 4, 161, -26368, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.crusherpalahelpgui.label_11_v1"), 374, 184, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 395, this.topPos + 3, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(0, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_example_gui_button = new ImageButton(this.leftPos + 372, this.topPos + 3, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/example_gui_button.png"), Identifier.parse("palamod:textures/screens/example_gui_button_poi.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(1, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_example_gui_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 325, this.topPos + 3, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_adminshop.png"), Identifier.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(2, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 348, this.topPos + 3, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/home_pixel_adminshop.png"), Identifier.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(3, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_book_button = new ImageButton(this.leftPos + 301, this.topPos + 3, 20, 18, new WidgetSprites(Identifier.parse("palamod:textures/screens/book_button.png"), Identifier.parse("palamod:textures/screens/book_button_hover.png")), e -> {
			int x = CrusherpalahelpguiScreen.this.x;
			int y = CrusherpalahelpguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(4, x, y, z));
				CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_book_button);
	}
}
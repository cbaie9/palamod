package palamod.client.gui;

import palamod.world.inventory.PalahelpnotsupportedMenu;

import palamod.network.PalahelpnotsupportedButtonMessage;

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

public class PalahelpnotsupportedScreen extends AbstractContainerScreen<PalahelpnotsupportedMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_language_btte;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/gui176_166.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/sad_ntsuport.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/sad_ntsuport.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/sad_ntsuport.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/sad_ntsuport.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/right_gray_line.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/left_gray_line.png");

	public PalahelpnotsupportedScreen(PalahelpnotsupportedMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 166);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 10, this.topPos + 26, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 137, this.topPos + 26, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 7, this.topPos + 127, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 136, this.topPos + 129, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpnotsupported.label_an_error_has_been_encountred"), 10, 62, -6750055, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpnotsupported.label_palahelp_error"), 46, 6, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpnotsupported.label_your_language_is_not_supported"), 5, 75, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpnotsupported.label_change_language"), 47, 128, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = PalahelpnotsupportedScreen.this.x;
					int y = PalahelpnotsupportedScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelpnotsupportedButtonMessage(0, x, y, z));
						PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 133, this.topPos + 3, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_adminshop.png"), Identifier.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = PalahelpnotsupportedScreen.this.x;
					int y = PalahelpnotsupportedScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelpnotsupportedButtonMessage(1, x, y, z));
						PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_language_btte = new ImageButton(this.leftPos + 76, this.topPos + 141, 21, 10, new WidgetSprites(Identifier.parse("palamod:textures/screens/language_btte.png"), Identifier.parse("palamod:textures/screens/language_btte_poi.png")),
				e -> {
					int x = PalahelpnotsupportedScreen.this.x;
					int y = PalahelpnotsupportedScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelpnotsupportedButtonMessage(2, x, y, z));
						PalahelpnotsupportedButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_language_btte);
	}
}
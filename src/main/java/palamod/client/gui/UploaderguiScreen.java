package palamod.client.gui;

import palamod.world.inventory.UploaderguiMenu;

import palamod.procedures.UploaderdebugProcedure;
import palamod.procedures.Grindertrans0Procedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.UploaderguiButtonMessage;

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

public class UploaderguiScreen extends AbstractContainerScreen<UploaderguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_help_img;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/uploadergui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/text_red_background_left.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/text_red_background_right.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/text_red_background_left.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/text_red_background_right.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/text_red_background_left.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/text_red_background_right.png");

	public UploaderguiScreen(UploaderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 220, 180);
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
		if (mouseX > leftPos + 99 && mouseX < leftPos + 117 && mouseY > topPos + 34 && mouseY < topPos + 52) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.uploadergui.tooltip_money_output"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 99 && mouseX < leftPos + 117 && mouseY > topPos + 68 && mouseY < topPos + 86) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.uploadergui.tooltip_items_you_want_to_sell_must_be"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 200 && mouseX < leftPos + 216 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.setComponentTooltipForNextFrame(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
		}
		if (mouseX > leftPos + 181 && mouseX < leftPos + 197 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.uploadergui.tooltip_this_machine_is_to_sell_thing_to"), mouseX, mouseY);
		}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 220, 180, 220, 180);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 28, this.topPos + 72, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 43, this.topPos + 72, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 130, this.topPos + 71, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 141, this.topPos + 71, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 85, this.topPos + 6, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 86, this.topPos + 6, 0, 0, 50, 16, 50, 16);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.uploadergui.label_uploader"), 89, 8, -1, false);
		guiGraphics.text(this.font, Grindertrans0Procedure.execute(), 30, 76, -1, false);
		guiGraphics.text(this.font, UploaderdebugProcedure.execute(world, x, y, z), 133, 73, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 200, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = UploaderguiScreen.this.x;
					int y = UploaderguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new UploaderguiButtonMessage(0, x, y, z));
						UploaderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_help_img = new ImageButton(this.leftPos + 181, this.topPos + 4, 16, 16, new WidgetSprites(Identifier.parse("palamod:textures/screens/help_img.png"), Identifier.parse("palamod:textures/screens/help_hover.png")), e -> {
		}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_help_img);
	}
}
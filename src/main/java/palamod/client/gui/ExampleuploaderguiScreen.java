package palamod.client.gui;

import palamod.world.inventory.ExampleuploaderguiMenu;

import palamod.procedures.Grindertrans0Procedure;

import palamod.network.ExampleuploaderguiButtonMessage;

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

public class ExampleuploaderguiScreen extends AbstractContainerScreen<ExampleuploaderguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/uploadergui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/golem_treec_sep_nt1.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/left_gray_line.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/right_gray_line.png");

	public ExampleuploaderguiScreen(ExampleuploaderguiMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 63 && mouseX < leftPos + 109 && mouseY > topPos + 5 && mouseY < topPos + 18) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.exampleuploadergui.tooltip_this_interface_need_an_upgrade"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 77 && mouseX < leftPos + 95 && mouseY > topPos + 61 && mouseY < topPos + 79) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.exampleuploadergui.tooltip_money_output"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 77 && mouseX < leftPos + 95 && mouseY > topPos + 27 && mouseY < topPos + 45) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.exampleuploadergui.tooltip_thing_you_want_to_sell_must_be"), mouseX, mouseY);
		}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 220, 180, 220, 180);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 77, this.topPos + 45, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.exampleuploadergui.label_uploader"), 65, 8, -1, false);
		guiGraphics.text(this.font, Grindertrans0Procedure.execute(), 3, 71, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 151, this.topPos + 5, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = ExampleuploaderguiScreen.this.x;
					int y = ExampleuploaderguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ExampleuploaderguiButtonMessage(0, x, y, z));
						ExampleuploaderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}
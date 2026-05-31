package palamod.client.gui;

import palamod.world.inventory.UploaderguipalahelpMenu;

import palamod.procedures.Palahelpuploader2Procedure;
import palamod.procedures.Palahelpuploader1Procedure;
import palamod.procedures.Palahelpuploader0Procedure;

import palamod.network.UploaderguipalahelpButtonMessage;

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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class UploaderguipalahelpScreen extends AbstractContainerScreen<UploaderguipalahelpMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_gui_example_wip;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/uploaderguipalahelp.png");

	public UploaderguipalahelpScreen(UploaderguipalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 319, 200);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 319, 200, 319, 200);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.uploaderguipalahelp.label_page_en_cours_de_redaction"), 21, 24, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.uploaderguipalahelp.label_this_page_is_working_in_progress"), 20, 11, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.uploaderguipalahelp.label_uploader"), 125, 46, -65536, false);
		guiGraphics.text(this.font, Palahelpuploader0Procedure.execute(entity), 4, 60, -12829636, false);
		guiGraphics.text(this.font, Palahelpuploader1Procedure.execute(entity), 4, 71, -12829636, false);
		guiGraphics.text(this.font, Palahelpuploader2Procedure.execute(entity), 4, 82, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_gui_example_wip = Button.builder(Component.translatable("gui.palamod.uploaderguipalahelp.button_gui_example_wip"), e -> {
			int x = UploaderguipalahelpScreen.this.x;
			int y = UploaderguipalahelpScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new UploaderguipalahelpButtonMessage(0, x, y, z));
				UploaderguipalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 170, 123, 20).build();
		this.addRenderableWidget(button_gui_example_wip);
	}
}
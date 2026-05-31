package palamod.client.gui;

import palamod.world.inventory.PalamachinepalahelpguiMenu;

import palamod.procedures.Palahelppalamachine4Procedure;
import palamod.procedures.Palahelppalamachine3Procedure;
import palamod.procedures.Palahelppalamachine2Procedure;
import palamod.procedures.Palahelppalamachine1Procedure;
import palamod.procedures.Palahelppalamachine0Procedure;

import palamod.network.PalamachinepalahelpguiButtonMessage;

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

public class PalamachinepalahelpguiScreen extends AbstractContainerScreen<PalamachinepalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_back;
	private Button button_menu;
	private static final Identifier BACKGROUND = Identifier.parse("palamod:textures/screens/palamachinepalahelpgui.png");

	public PalamachinepalahelpguiScreen(PalamachinepalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 215, 200);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palamachinepalahelpgui.label_palamachine"), 77, 17, -12829636, false);
		guiGraphics.text(this.font, Palahelppalamachine0Procedure.execute(entity), 4, 33, -12829636, false);
		guiGraphics.text(this.font, Palahelppalamachine1Procedure.execute(entity), 4, 46, -12829636, false);
		guiGraphics.text(this.font, Palahelppalamachine2Procedure.execute(entity), 4, 58, -12829636, false);
		guiGraphics.text(this.font, Palahelppalamachine3Procedure.execute(entity), 6, 77, -12829636, false);
		guiGraphics.text(this.font, Palahelppalamachine4Procedure.execute(entity), 55, 184, -3394816, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palamachinepalahelpgui.label_now_in_jei"), 62, 120, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_back = Button.builder(Component.translatable("gui.palamod.palamachinepalahelpgui.button_back"), e -> {
			int x = PalamachinepalahelpguiScreen.this.x;
			int y = PalamachinepalahelpguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalamachinepalahelpguiButtonMessage(0, x, y, z));
				PalamachinepalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 17, this.topPos + 7, 45, 20).build();
		this.addRenderableWidget(button_back);
		button_menu = Button.builder(Component.translatable("gui.palamod.palamachinepalahelpgui.button_menu"), e -> {
			int x = PalamachinepalahelpguiScreen.this.x;
			int y = PalamachinepalahelpguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalamachinepalahelpguiButtonMessage(1, x, y, z));
				PalamachinepalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 145, this.topPos + 7, 45, 20).build();
		this.addRenderableWidget(button_menu);
	}
}
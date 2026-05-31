package palamod.client.gui;

import palamod.world.inventory.PotgtranfertMenu;

import palamod.procedures.PotgtransfertvalueentityProcedure;
import palamod.procedures.PotgtranfertValueProcedure;

import palamod.network.PotgtranfertButtonMessage;

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

public class PotgtranfertScreen extends AbstractContainerScreen<PotgtranfertMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_transfert;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/potgtranfert.png");

	public PotgtranfertScreen(PotgtranfertMenu container, Inventory inventory, Component text) {
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.potgtranfert.label_potg_transfert_gui"), 4, 3, -12829636, false);
		guiGraphics.text(this.font, PotgtranfertValueProcedure.execute(entity), 5, 69, -12829636, false);
		guiGraphics.text(this.font, PotgtransfertvalueentityProcedure.execute(entity), 4, 56, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_transfert = Button.builder(Component.translatable("gui.palamod.potgtranfert.button_transfert"), e -> {
			int x = PotgtranfertScreen.this.x;
			int y = PotgtranfertScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PotgtranfertButtonMessage(0, x, y, z));
				PotgtranfertButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 25, 72, 20).build();
		this.addRenderableWidget(button_transfert);
	}
}
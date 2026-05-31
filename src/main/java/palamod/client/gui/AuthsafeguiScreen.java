package palamod.client.gui;

import palamod.world.inventory.AuthsafeguiMenu;

import palamod.network.AuthsafeguiButtonMessage;

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
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class AuthsafeguiScreen extends AbstractContainerScreen<AuthsafeguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox code_check;
	private Button button_open;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/authsafegui.png");

	public AuthsafeguiScreen(AuthsafeguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 150, 60);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("code_check"))
				code_check.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
		code_check.extractWidgetRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 150, 60, 150, 60);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (code_check.isFocused())
			return code_check.keyPressed(event);
		return super.keyPressed(event);
	}

	@Override
	public void resize(int width, int height) {
		String code_checkValue = code_check.getValue();
		super.resize(width, height);
		code_check.setValue(code_checkValue);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.authsafegui.label_enter_code"), 3, 6, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		code_check = new EditBox(this.font, this.leftPos + 4, this.topPos + 16, 118, 18, Component.translatable("gui.palamod.authsafegui.code_check"));
		code_check.setMaxLength(8192);
		code_check.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "code_check", content, false);
		});
		this.addWidget(this.code_check);
		button_open = Button.builder(Component.translatable("gui.palamod.authsafegui.button_open"), e -> {
			int x = AuthsafeguiScreen.this.x;
			int y = AuthsafeguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new AuthsafeguiButtonMessage(0, x, y, z));
				AuthsafeguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 3, this.topPos + 36, 46, 20).build();
		this.addRenderableWidget(button_open);
	}
}
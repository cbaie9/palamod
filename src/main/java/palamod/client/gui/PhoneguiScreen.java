package palamod.client.gui;

import palamod.world.inventory.PhoneguiMenu;

import palamod.network.PhoneguiButtonMessage;

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

public class PhoneguiScreen extends AbstractContainerScreen<PhoneguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox cheat_code_secret;
	private Button button_test_code;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/phonegui.png");

	public PhoneguiScreen(PhoneguiMenu container, Inventory inventory, Component text) {
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
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("cheat_code_secret"))
				cheat_code_secret.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
		cheat_code_secret.extractWidgetRenderState(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (cheat_code_secret.isFocused())
			return cheat_code_secret.keyPressed(event);
		return super.keyPressed(event);
	}

	@Override
	public void resize(int width, int height) {
		String cheat_code_secretValue = cheat_code_secret.getValue();
		super.resize(width, height);
		cheat_code_secret.setValue(cheat_code_secretValue);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.phonegui.label_enter_your_secret_code"), 4, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		cheat_code_secret = new EditBox(this.font, this.leftPos + 5, this.topPos + 21, 118, 18, Component.translatable("gui.palamod.phonegui.cheat_code_secret"));
		cheat_code_secret.setMaxLength(8192);
		cheat_code_secret.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "cheat_code_secret", content, false);
		});
		cheat_code_secret.setHint(Component.translatable("gui.palamod.phonegui.cheat_code_secret"));
		this.addWidget(this.cheat_code_secret);
		button_test_code = Button.builder(Component.translatable("gui.palamod.phonegui.button_test_code"), e -> {
			int x = PhoneguiScreen.this.x;
			int y = PhoneguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PhoneguiButtonMessage(0, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 98, this.topPos + 57, 72, 20).build();
		this.addRenderableWidget(button_test_code);
	}
}
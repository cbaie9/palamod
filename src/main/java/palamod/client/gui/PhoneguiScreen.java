package palamod.client.gui;

import palamod.world.inventory.PhoneguiMenu;

import palamod.network.PhoneguiButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PhoneguiScreen extends AbstractContainerScreen<PhoneguiMenu> {
	private final static HashMap<String, Object> guistate = PhoneguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox cheat_code_secret;
	Button button_test_code;

	public PhoneguiScreen(PhoneguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		cheat_code_secret.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/phonegui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (cheat_code_secret.isFocused())
			return cheat_code_secret.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		cheat_code_secret.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.phonegui.label_enter_your_secret_code"), 4, 7, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		cheat_code_secret = new EditBox(this.font, this.leftPos + 5, this.topPos + 21, 118, 18, Component.translatable("gui.palamod.phonegui.cheat_code_secret")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.palamod.phonegui.cheat_code_secret").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.palamod.phonegui.cheat_code_secret").getString());
				else
					setSuggestion(null);
			}
		};
		cheat_code_secret.setSuggestion(Component.translatable("gui.palamod.phonegui.cheat_code_secret").getString());
		cheat_code_secret.setMaxLength(32767);
		guistate.put("text:cheat_code_secret", cheat_code_secret);
		this.addWidget(this.cheat_code_secret);
		button_test_code = Button.builder(Component.translatable("gui.palamod.phonegui.button_test_code"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new PhoneguiButtonMessage(0, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 98, this.topPos + 57, 72, 20).build();
		guistate.put("button:button_test_code", button_test_code);
		this.addRenderableWidget(button_test_code);
	}
}

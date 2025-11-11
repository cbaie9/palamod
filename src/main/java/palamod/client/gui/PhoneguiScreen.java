package palamod.client.gui;

import palamod.world.inventory.PhoneguiMenu;

import palamod.network.PhoneguiButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;

public class PhoneguiScreen extends AbstractContainerScreen<PhoneguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox cheat_code_secret;
	private Button button_test_code;

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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("cheat_code_secret"))
				cheat_code_secret.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		cheat_code_secret.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/phonegui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
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
	public void resize(Minecraft minecraft, int width, int height) {
		String cheat_code_secretValue = cheat_code_secret.getValue();
		super.resize(minecraft, width, height);
		cheat_code_secret.setValue(cheat_code_secretValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.phonegui.label_enter_your_secret_code"), 4, 7, -12829636, false);
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
				PacketDistributor.sendToServer(new PhoneguiButtonMessage(0, x, y, z));
				PhoneguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 98, this.topPos + 57, 72, 20).build();
		this.addRenderableWidget(button_test_code);
	}
}
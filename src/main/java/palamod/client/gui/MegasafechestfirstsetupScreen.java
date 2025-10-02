package palamod.client.gui;

import palamod.world.inventory.MegasafechestfirstsetupMenu;

import palamod.network.MegasafechestfirstsetupButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import com.mojang.blaze3d.systems.RenderSystem;

public class MegasafechestfirstsetupScreen extends AbstractContainerScreen<MegasafechestfirstsetupMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox safe_code;
	Checkbox safe_link;
	Button button_save;

	public MegasafechestfirstsetupScreen(MegasafechestfirstsetupMenu container, Inventory inventory, Component text) {
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
			if (name.equals("safe_code"))
				safe_code.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		safe_code.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/megasafechestfirstsetup.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (safe_code.isFocused())
			return safe_code.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String safe_codeValue = safe_code.getValue();
		super.resize(minecraft, width, height);
		safe_code.setValue(safe_codeValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_safe_setup"), 55, 6, -13434625, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_1_enter_future_code_of_the_safe"), 4, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_2do_you_want_link_safe_with"), 3, 64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_this_account_bypass_the_code"), 2, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_it_you"), 3, 85, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_3_save"), 5, 122, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		safe_code = new EditBox(this.font, this.leftPos + 9, this.topPos + 43, 118, 18, Component.translatable("gui.palamod.megasafechestfirstsetup.safe_code"));
		safe_code.setMaxLength(8192);
		safe_code.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "safe_code", content, false);
		});
		safe_code.setHint(Component.translatable("gui.palamod.megasafechestfirstsetup.safe_code"));
		this.addWidget(this.safe_code);
		button_save = Button.builder(Component.translatable("gui.palamod.megasafechestfirstsetup.button_save"), e -> {
			int x = MegasafechestfirstsetupScreen.this.x;
			int y = MegasafechestfirstsetupScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new MegasafechestfirstsetupButtonMessage(0, x, y, z));
				MegasafechestfirstsetupButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 26, this.topPos + 135, 46, 20).build();
		this.addRenderableWidget(button_save);
		safe_link = Checkbox.builder(Component.translatable("gui.palamod.megasafechestfirstsetup.safe_link"), this.font).pos(this.leftPos + 5, this.topPos + 100).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "safe_link", value, false);
		}).build();
		this.addRenderableWidget(safe_link);
	}
}
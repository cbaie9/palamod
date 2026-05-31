package palamod.client.gui;

import palamod.world.inventory.MegasafechestfirstsetupMenu;

import palamod.network.MegasafechestfirstsetupButtonMessage;

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
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class MegasafechestfirstsetupScreen extends AbstractContainerScreen<MegasafechestfirstsetupMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox safe_code;
	private Checkbox safe_link;
	private Button button_save;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/megasafechestfirstsetup.png");

	public MegasafechestfirstsetupScreen(MegasafechestfirstsetupMenu container, Inventory inventory, Component text) {
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
			if (name.equals("safe_code"))
				safe_code.setValue(stringState);
		}
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("safe_link")) {
				if (safe_link.selected() != logicState)
					safe_link.onPress(null);
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
		safe_code.extractWidgetRenderState(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (safe_code.isFocused())
			return safe_code.keyPressed(event);
		return super.keyPressed(event);
	}

	@Override
	public void resize(int width, int height) {
		String safe_codeValue = safe_code.getValue();
		super.resize(width, height);
		safe_code.setValue(safe_codeValue);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_safe_setup"), 55, 6, -13434625, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_1_enter_future_code_of_the_safe"), 4, 25, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_2do_you_want_link_safe_with"), 3, 64, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_this_account_bypass_the_code"), 2, 75, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_it_you"), 3, 85, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_3_save"), 5, 122, -12829636, false);
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
				ClientPacketDistributor.sendToServer(new MegasafechestfirstsetupButtonMessage(0, x, y, z));
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
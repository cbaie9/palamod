package palamod.client.gui;

import palamod.world.inventory.SpecialmoneypanelMenu;

import palamod.network.SpecialmoneypanelButtonMessage;

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

public class SpecialmoneypanelScreen extends AbstractContainerScreen<SpecialmoneypanelMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox player_name;
	private EditBox money;
	private Checkbox custom_destructible;
	private Button button_give;

	public SpecialmoneypanelScreen(SpecialmoneypanelMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 224;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("player_name"))
				player_name.setValue(stringState);
			else if (name.equals("money"))
				money.setValue(stringState);
		}
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("custom_destructible")) {
				if (custom_destructible.selected() != logicState)
					custom_destructible.onPress();
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		player_name.render(guiGraphics, mouseX, mouseY, partialTicks);
		money.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/specialmoneypanel.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 224, 176, 224);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (player_name.isFocused())
			return player_name.keyPressed(key, b, c);
		if (money.isFocused())
			return money.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String player_nameValue = player_name.getValue();
		String moneyValue = money.getValue();
		super.resize(minecraft, width, height);
		player_name.setValue(player_nameValue);
		money.setValue(moneyValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.specialmoneypanel.label_specific_player"), 26, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.specialmoneypanel.label_amount_of_money"), 26, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.specialmoneypanel.label_item_default_money_item"), 7, 74, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		player_name = new EditBox(this.font, this.leftPos + 8, this.topPos + 19, 118, 18, Component.translatable("gui.palamod.specialmoneypanel.player_name"));
		player_name.setMaxLength(8192);
		player_name.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "player_name", content, false);
		});
		player_name.setHint(Component.translatable("gui.palamod.specialmoneypanel.player_name"));
		this.addWidget(this.player_name);
		money = new EditBox(this.font, this.leftPos + 8, this.topPos + 51, 118, 18, Component.translatable("gui.palamod.specialmoneypanel.money"));
		money.setMaxLength(8192);
		money.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "money", content, false);
		});
		money.setHint(Component.translatable("gui.palamod.specialmoneypanel.money"));
		this.addWidget(this.money);
		button_give = Button.builder(Component.translatable("gui.palamod.specialmoneypanel.button_give"), e -> {
			int x = SpecialmoneypanelScreen.this.x;
			int y = SpecialmoneypanelScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new SpecialmoneypanelButtonMessage(0, x, y, z));
				SpecialmoneypanelButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 119, this.topPos + 90, 46, 20).build();
		this.addRenderableWidget(button_give);
		custom_destructible = Checkbox.builder(Component.translatable("gui.palamod.specialmoneypanel.custom_destructible"), this.font).pos(this.leftPos + 6, this.topPos + 114).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "custom_destructible", value, false);
		}).build();
		this.addRenderableWidget(custom_destructible);
	}
}
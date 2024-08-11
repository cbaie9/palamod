package palamod.client.gui;

import palamod.world.inventory.OnlinedetectorguiMenu;

import palamod.procedures.OnlinedetectorgetplayerProcedure;

import palamod.network.OnlinedetectorguiButtonMessage;

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
import net.minecraft.client.Minecraft;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class OnlinedetectorguiScreen extends AbstractContainerScreen<OnlinedetectorguiMenu> {
	private final static HashMap<String, Object> guistate = OnlinedetectorguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox player_name;
	Button button_detect;

	public OnlinedetectorguiScreen(OnlinedetectorguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 150;
		this.imageHeight = 60;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		player_name.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/onlinedetectorgui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 150, 60, 150, 60);

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
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		player_name.tick();
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String player_nameValue = player_name.getValue();
		super.resize(minecraft, width, height);
		player_name.setValue(player_nameValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.onlinedetectorgui.label_insert_player_to_detect"), 6, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.onlinedetectorgui.label_status"), 63, 37, -12829636, false);
		guiGraphics.drawString(this.font,

				OnlinedetectorgetplayerProcedure.execute(world, x, y, z), 63, 47, -12828690, false);
	}

	@Override
	public void init() {
		super.init();
		player_name = new EditBox(this.font, this.leftPos + 5, this.topPos + 17, 135, 18, Component.translatable("gui.palamod.onlinedetectorgui.player_name")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.palamod.onlinedetectorgui.player_name").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.palamod.onlinedetectorgui.player_name").getString());
				else
					setSuggestion(null);
			}
		};
		player_name.setSuggestion(Component.translatable("gui.palamod.onlinedetectorgui.player_name").getString());
		player_name.setMaxLength(32767);
		guistate.put("text:player_name", player_name);
		this.addWidget(this.player_name);
		button_detect = Button.builder(Component.translatable("gui.palamod.onlinedetectorgui.button_detect"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new OnlinedetectorguiButtonMessage(0, x, y, z));
				OnlinedetectorguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 37, 56, 20).build();
		guistate.put("button:button_detect", button_detect);
		this.addRenderableWidget(button_detect);
	}
}

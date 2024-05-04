package palamod.client.gui;

import palamod.world.inventory.NextPalahelpguiMenu;

import palamod.network.NextPalahelpguiButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NextPalahelpguiScreen extends AbstractContainerScreen<NextPalahelpguiMenu> {
	private final static HashMap<String, Object> guistate = NextPalahelpguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_commands;
	Button button_lucky_stats;
	Button button_back;

	public NextPalahelpguiScreen(NextPalahelpguiMenu container, Inventory inventory, Component text) {
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
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/next_palahelpgui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/palablock_green_palahelp2-removebg-preview_1.png"), this.leftPos + 5, this.topPos + 20, 0, 0, 75, 80, 75, 80);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.next_palahelpgui.label_palahelp"), 5, 4, -52429, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.next_palahelpgui.label_22"), 4, 102, -16750951, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.next_palahelpgui.label_more_in_the_future"), 63, 111, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_commands = Button.builder(Component.translatable("gui.palamod.next_palahelpgui.button_commands"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new NextPalahelpguiButtonMessage(0, x, y, z));
				NextPalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 24, 80, 20).build();
		guistate.put("button:button_commands", button_commands);
		this.addRenderableWidget(button_commands);
		button_lucky_stats = Button.builder(Component.translatable("gui.palamod.next_palahelpgui.button_lucky_stats"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new NextPalahelpguiButtonMessage(1, x, y, z));
				NextPalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 56, 80, 20).build();
		guistate.put("button:button_lucky_stats", button_lucky_stats);
		this.addRenderableWidget(button_lucky_stats);
		button_back = Button.builder(Component.translatable("gui.palamod.next_palahelpgui.button_back"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new NextPalahelpguiButtonMessage(2, x, y, z));
				NextPalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 134, 75, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}

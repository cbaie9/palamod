package palamod.client.gui;

import palamod.world.inventory.TrixiumdepositMenu;

import palamod.procedures.Grindertrans0Procedure;

import palamod.network.TrixiumdepositButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TrixiumdepositScreen extends AbstractContainerScreen<TrixiumdepositMenu> {
	private final static HashMap<String, Object> guistate = TrixiumdepositMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	ImageButton imagebutton_cross_no_button;

	public TrixiumdepositScreen(TrixiumdepositMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 78 && mouseX < leftPos + 96 && mouseY > topPos + 41 && mouseY < topPos + 59)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.trixiumdeposit.tooltip_put_trixium_here"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/trixiumdeposit.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/trixium.png"), this.leftPos + 80, this.topPos + 42, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.trixiumdeposit.label_trixium_deposit_menu"), 35, 7, -1, false);
		guiGraphics.drawString(this.font,

				Grindertrans0Procedure.execute(entity), 5, 71, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_empty = Button.builder(Component.translatable("gui.palamod.trixiumdeposit.button_empty"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new TrixiumdepositButtonMessage(0, x, y, z));
				TrixiumdepositButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 101, this.topPos + 40, 65, 20).build();
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 152, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new TrixiumdepositButtonMessage(1, x, y, z));
				TrixiumdepositButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}

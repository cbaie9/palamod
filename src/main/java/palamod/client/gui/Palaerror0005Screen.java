package palamod.client.gui;

import palamod.world.inventory.Palaerror0005Menu;

import palamod.network.Palaerror0005ButtonMessage;

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

public class Palaerror0005Screen extends AbstractContainerScreen<Palaerror0005Menu> {
	private final static HashMap<String, Object> guistate = Palaerror0005Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_quit;

	public Palaerror0005Screen(Palaerror0005Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 180;
		this.imageHeight = 80;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/palaerror_0005.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 180, 80, 180, 80);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palaerror_0005.label_pala_err0r_0005"), 47, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palaerror_0005.label_you_dont_have_the_permission_to"), 5, 26, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palaerror_0005.label_do_that_action"), 5, 36, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_quit = Button.builder(Component.translatable("gui.palamod.palaerror_0005.button_quit"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new Palaerror0005ButtonMessage(0, x, y, z));
				Palaerror0005ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 68, this.topPos + 53, 46, 20).build();
		guistate.put("button:button_quit", button_quit);
		this.addRenderableWidget(button_quit);
	}
}

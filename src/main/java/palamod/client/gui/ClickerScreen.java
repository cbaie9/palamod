package palamod.client.gui;

import palamod.world.inventory.ClickerMenu;

import palamod.network.ClickerButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ClickerScreen extends AbstractContainerScreen<ClickerMenu> {
	private final static HashMap<String, Object> guistate = ClickerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_clicker_potato_btn_v11;
	ImageButton imagebutton_clicker_upgradenone;
	ImageButton imagebutton_clicker_upgradenone1;
	ImageButton imagebutton_clicker_upgradenone2;
	ImageButton imagebutton_clicker_upgradenone3;
	ImageButton imagebutton_clicker_upgradenone4;
	ImageButton imagebutton_clicker_upgradenone5;
	ImageButton imagebutton_clicker_close_btn;
	ImageButton imagebutton_clicker_skip;

	public ClickerScreen(ClickerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 360;
		this.imageHeight = 210;
	}

	@Override
	public boolean isPauseScreen() {
		return true;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/clicker_v1.9.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 360, 210, 360, 210);

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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_clicker_potato_btn_v11 = new ImageButton(this.leftPos + 11, this.topPos + 60, 91, 139, 0, 0, 139, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_potato_btn_v11.png"), 91, 278, e -> {
		});
		guistate.put("button:imagebutton_clicker_potato_btn_v11", imagebutton_clicker_potato_btn_v11);
		this.addRenderableWidget(imagebutton_clicker_potato_btn_v11);
		imagebutton_clicker_upgradenone = new ImageButton(this.leftPos + 116, this.topPos + 182, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_upgradenone.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_clicker_upgradenone", imagebutton_clicker_upgradenone);
		this.addRenderableWidget(imagebutton_clicker_upgradenone);
		imagebutton_clicker_upgradenone1 = new ImageButton(this.leftPos + 134, this.topPos + 182, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_upgradenone1.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_clicker_upgradenone1", imagebutton_clicker_upgradenone1);
		this.addRenderableWidget(imagebutton_clicker_upgradenone1);
		imagebutton_clicker_upgradenone2 = new ImageButton(this.leftPos + 152, this.topPos + 182, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_upgradenone2.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_clicker_upgradenone2", imagebutton_clicker_upgradenone2);
		this.addRenderableWidget(imagebutton_clicker_upgradenone2);
		imagebutton_clicker_upgradenone3 = new ImageButton(this.leftPos + 188, this.topPos + 182, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_upgradenone3.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_clicker_upgradenone3", imagebutton_clicker_upgradenone3);
		this.addRenderableWidget(imagebutton_clicker_upgradenone3);
		imagebutton_clicker_upgradenone4 = new ImageButton(this.leftPos + 170, this.topPos + 182, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_upgradenone4.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_clicker_upgradenone4", imagebutton_clicker_upgradenone4);
		this.addRenderableWidget(imagebutton_clicker_upgradenone4);
		imagebutton_clicker_upgradenone5 = new ImageButton(this.leftPos + 206, this.topPos + 182, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_upgradenone5.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_clicker_upgradenone5", imagebutton_clicker_upgradenone5);
		this.addRenderableWidget(imagebutton_clicker_upgradenone5);
		imagebutton_clicker_close_btn = new ImageButton(this.leftPos + 341, this.topPos + 6, 12, 12, 0, 0, 12, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_close_btn.png"), 12, 24, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new ClickerButtonMessage(7, x, y, z));
				ClickerButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_clicker_close_btn", imagebutton_clicker_close_btn);
		this.addRenderableWidget(imagebutton_clicker_close_btn);
		imagebutton_clicker_skip = new ImageButton(this.leftPos + 229, this.topPos + 184, 12, 12, 0, 0, 12, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_clicker_skip.png"), 12, 24, e -> {
		});
		guistate.put("button:imagebutton_clicker_skip", imagebutton_clicker_skip);
		this.addRenderableWidget(imagebutton_clicker_skip);
	}
}

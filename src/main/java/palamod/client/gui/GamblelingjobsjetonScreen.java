package palamod.client.gui;

import palamod.world.inventory.GamblelingjobsjetonMenu;

import palamod.procedures.ClosetheguitransProcedure;

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

public class GamblelingjobsjetonScreen extends AbstractContainerScreen<GamblelingjobsjetonMenu> {
	private final static HashMap<String, Object> guistate = GamblelingjobsjetonMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_arrow_back_true_1;
	ImageButton imagebutton_close_gui_nohover;

	public GamblelingjobsjetonScreen(GamblelingjobsjetonMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 215;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 379 && mouseX < leftPos + 396 && mouseY > topPos + 4 && mouseY < topPos + 21)
			guiGraphics.renderTooltip(font, Component.literal(ClosetheguitransProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 78 && mouseX < leftPos + 161 && mouseY > topPos + 96 && mouseY < topPos + 179)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.gamblelingjobsjeton.tooltip_hgyhugyuigyuigyi"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.gamblelingjobsjeton.label_jobs"), 15, 14, -3394816, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.gamblelingjobsjeton.label_jetons_de_recompenses"), 15, 32, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_back_true_1 = new ImageButton(this.leftPos + 359, this.topPos + 4, 17, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_back_true_1.png"), 17, 34, e -> {
		});
		guistate.put("button:imagebutton_arrow_back_true_1", imagebutton_arrow_back_true_1);
		this.addRenderableWidget(imagebutton_arrow_back_true_1);
		imagebutton_close_gui_nohover = new ImageButton(this.leftPos + 379, this.topPos + 4, 17, 17, 0, 0, 17, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_close_gui_nohover.png"), 17, 34, e -> {
		});
		guistate.put("button:imagebutton_close_gui_nohover", imagebutton_close_gui_nohover);
		this.addRenderableWidget(imagebutton_close_gui_nohover);
	}
}

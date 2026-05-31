package palamod.client.gui;

import palamod.world.inventory.OrelayerfatMenu;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

public class OrelayerfatScreen extends AbstractContainerScreen<OrelayerfatMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/orelayerfat.png");

	public OrelayerfatScreen(OrelayerfatMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 100;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 250, 100, 250, 100);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_paladium_64_15"), 4, 57, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_titane_64_32"), 5, 69, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_amethyst_64_80"), 7, 80, -6750055, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_findium_64_150"), 5, 42, -13312, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_green_paladium_64_128"), 6, 28, -16738048, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_endium_64_128_customs_p"), 5, 15, -16777114, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
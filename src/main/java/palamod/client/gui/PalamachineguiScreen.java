package palamod.client.gui;

import palamod.world.inventory.PalamachineguiMenu;

import palamod.procedures.Grindertrans0Procedure;
import palamod.procedures.GetspritepalamachinecircleProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

public class PalamachineguiScreen extends AbstractContainerScreen<PalamachineguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public PalamachineguiScreen(PalamachineguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 176;
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/palamachinegui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 176, 176, 176);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/circle_sprite_palamachine.png"), this.leftPos + 48, this.topPos + 5,
				Mth.clamp((int) GetspritepalamachinecircleProcedure.execute(world, x, y, z) * 80, 0, 1040), 0, 80, 80, 1120, 80);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palamachinegui.label_palamachine"), 3, 3, -3407872, false);
		guiGraphics.drawString(this.font, Grindertrans0Procedure.execute(entity), 4, 84, -4671036, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
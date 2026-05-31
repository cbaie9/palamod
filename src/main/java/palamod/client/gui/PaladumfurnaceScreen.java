package palamod.client.gui;

import palamod.world.inventory.PaladumfurnaceMenu;

import palamod.procedures.ReturntimerspritepaladiumfurnaceProcedure;
import palamod.procedures.ReturnfuelspritepaladiumfurnaceProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class PaladumfurnaceScreen extends AbstractContainerScreen<PaladumfurnaceMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/paladiumfurnace.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/paladium_upgrade.png");
	private static final Identifier SPRITE_0 = Identifier.parse("palamod:textures/screens/fire_furnace.png");
	private static final Identifier SPRITE_1 = Identifier.parse("palamod:textures/screens/arrow_right_furnace_sprite.png");

	public PaladumfurnaceScreen(PaladumfurnaceMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 180, 166);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 180, 166, 180, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 14, this.topPos + 41, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 60, this.topPos + 41, Mth.clamp((int) ReturnfuelspritepaladiumfurnaceProcedure.execute(world, x, y, z) * 16, 0, 224), 0, 16, 16, 240, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_1, this.leftPos + 87, this.topPos + 42, Mth.clamp((int) ReturntimerspritepaladiumfurnaceProcedure.execute(world, x, y, z) * 22, 0, 484), 0, 22, 15, 506, 15);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.paladumfurnace.label_paladium_furnace"), 46, 4, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.paladumfurnace.label_inventory"), 7, 73, -1, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
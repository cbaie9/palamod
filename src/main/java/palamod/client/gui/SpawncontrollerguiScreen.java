package palamod.client.gui;

import palamod.world.inventory.SpawncontrollerguiMenu;

import palamod.procedures.SpawnerupgrademorechecknotProcedure;
import palamod.procedures.SpawnercontrollerguitexttierProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class SpawncontrollerguiScreen extends AbstractContainerScreen<SpawncontrollerguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final Identifier BACKGROUND = Identifier.parse("palamod:textures/screens/spawncontrollergui.png");
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/lock_slot.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/lock_slot.png");

	public SpawncontrollerguiScreen(SpawncontrollerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 166);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (SpawnerupgrademorechecknotProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 62, this.topPos + 46, 0, 0, 16, 16, 16, 16);
		}
		if (SpawnerupgrademorechecknotProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 80, this.topPos + 46, 0, 0, 16, 16, 16, 16);
		}
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
		guiGraphics.text(this.font, SpawnercontrollerguitexttierProcedure.execute(world, x, y, z), 7, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
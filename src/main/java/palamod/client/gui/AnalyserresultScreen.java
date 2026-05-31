package palamod.client.gui;

import palamod.world.inventory.AnalyserresultMenu;

import palamod.procedures.*;

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

public class AnalyserresultScreen extends AbstractContainerScreen<AnalyserresultMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/analyserresult.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/end_stone.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/clay.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/paladium_ore.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/planks_oak.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/cobblestone.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/chest_ico32.png");
	private static final Identifier IMAGE_7 = Identifier.parse("palamod:textures/screens/dirt.png");
	private static final Identifier IMAGE_8 = Identifier.parse("palamod:textures/screens/erable_log.png");
	private static final Identifier IMAGE_9 = Identifier.parse("palamod:textures/screens/wool_colored_white.png");
	private static final Identifier IMAGE_10 = Identifier.parse("palamod:textures/screens/bedrock.png");
	private static final Identifier IMAGE_11 = Identifier.parse("palamod:textures/screens/air_scre.png");
	private static final Identifier IMAGE_12 = Identifier.parse("palamod:textures/screens/shulker_screen.png");
	private static final Identifier IMAGE_13 = Identifier.parse("palamod:textures/screens/stone32.png");

	public AnalyserresultScreen(AnalyserresultMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 400, 220);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 400, 220, 400, 220);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 6, this.topPos + 7, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 118, this.topPos + 6, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 5, this.topPos + 39, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 5, this.topPos + 71, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 5, this.topPos + 102, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 3, this.topPos + 135, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_7, this.leftPos + 5, this.topPos + 166, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_8, this.leftPos + 118, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_9, this.leftPos + 118, this.topPos + 70, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_10, this.leftPos + 118, this.topPos + 101, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_11, this.leftPos + 118, this.topPos + 133, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_12, this.leftPos + 118, this.topPos + 165, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_13, this.leftPos + 231, this.topPos + 9, 0, 0, 16, 16, 16, 16);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_ores"), 40, 40, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_endstone"), 39, 7, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_planks"), 38, 73, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_clay"), 153, 6, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_cobblestone"), 37, 99, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_chests"), 35, 137, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_dirt"), 37, 166, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_logs"), 151, 39, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_wool"), 153, 71, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_bedrock"), 151, 101, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnoresProcedure.execute(), 39, 59, -12829636, false);
		guiGraphics.text(this.font, AnalyreturndirtProcedure.execute(), 37, 187, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnstoneProcedure.execute(), 268, 22, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnendstoneProcedure.execute(), 40, 19, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnairProcedure.execute(), 152, 148, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnshulkerProcedure.execute(), 152, 178, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnchestProcedure.execute(), 34, 148, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnwoolProcedure.execute(), 153, 84, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnbedrockProcedure.execute(), 152, 112, -12829636, false);
		guiGraphics.text(this.font, AnalyreturncobbleProcedure.execute(), 25, 111, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnlogsProcedure.execute(), 153, 51, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnplanksProcedure.execute(), 38, 84, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_air"), 151, 130, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_stone"), 267, 9, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.analyserresult.label_shulker"), 151, 165, -12829636, false);
		guiGraphics.text(this.font, AnalyreturnclayProcedure.execute(), 151, 22, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}
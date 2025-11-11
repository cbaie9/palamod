package palamod.client.gui;

import palamod.world.inventory.FactionhomeguiMenu;

import palamod.procedures.Factionhomeguisubprocess1Procedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

public class FactionhomeguiScreen extends AbstractContainerScreen<FactionhomeguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_invite;

	public FactionhomeguiScreen(FactionhomeguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palamod:textures/screens/factionhomegui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.factionhomegui.label_faction_home"), 116, 3, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.factionhomegui.label_empty"), 19, 71, -12829636, false);
		guiGraphics.drawString(this.font, Factionhomeguisubprocess1Procedure.execute(world, entity), 4, 25, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_invite = Button.builder(Component.translatable("gui.palamod.factionhomegui.button_invite"), e -> {
		}).bounds(this.leftPos + 8, this.topPos + 171, 56, 20).build();
		this.addRenderableWidget(button_invite);
	}
}
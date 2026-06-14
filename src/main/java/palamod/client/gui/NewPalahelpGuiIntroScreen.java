package palamod.client.gui;

import palamod.world.inventory.NewPalahelpGuiIntroMenu;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class NewPalahelpGuiIntroScreen extends AbstractContainerScreen<NewPalahelpGuiIntroMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_ores;
	private Button button_trees;
	private Button button_armors;
	private Button button_liquids;
	private Button button_commands;
	private Button button_jobs;
	private Button button_grinder;
	private Button button_palamachine;
	private Button button_crusher;
	private Button button_more;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("palamod:textures/screens/new_palahelp_gui_intro.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");

	public NewPalahelpGuiIntroScreen(NewPalahelpGuiIntroMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 166;
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
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 435, this.topPos + 43, 0, 0, 288, 180, 288, 180);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.new_palahelp_gui_intro.label_palahelp"), 8, 21, -52480, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.new_palahelp_gui_intro.label_thanks_for_install_my_mod"), 6, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.new_palahelp_gui_intro.label_this_is_an_intern_wiki_for_the_m"), 9, 100, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.new_palahelp_gui_intro.label_for_the_mod"), 10, 112, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.new_palahelp_gui_intro.label_summary"), 208, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.new_palahelp_gui_intro.label_machines"), 177, 92, -16777063, false);
	}

	@Override
	public void init() {
		super.init();
		button_ores = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_ores"), e -> {
		}).bounds(this.leftPos + 178, this.topPos + 23, 50, 20).build();
		this.addRenderableWidget(button_ores);
		button_trees = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_trees"), e -> {
		}).bounds(this.leftPos + 178, this.topPos + 47, 50, 20).build();
		this.addRenderableWidget(button_trees);
		button_armors = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_armors"), e -> {
		}).bounds(this.leftPos + 232, this.topPos + 23, 61, 20).build();
		this.addRenderableWidget(button_armors);
		button_liquids = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_liquids"), e -> {
		}).bounds(this.leftPos + 232, this.topPos + 47, 61, 20).build();
		this.addRenderableWidget(button_liquids);
		button_commands = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_commands"), e -> {
		}).bounds(this.leftPos + 178, this.topPos + 69, 50, 20).build();
		this.addRenderableWidget(button_commands);
		button_jobs = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_jobs"), e -> {
		}).bounds(this.leftPos + 232, this.topPos + 69, 61, 20).build();
		this.addRenderableWidget(button_jobs);
		button_grinder = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_grinder"), e -> {
		}).bounds(this.leftPos + 178, this.topPos + 106, 50, 20).build();
		this.addRenderableWidget(button_grinder);
		button_palamachine = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_palamachine"), e -> {
		}).bounds(this.leftPos + 232, this.topPos + 106, 61, 20).build();
		this.addRenderableWidget(button_palamachine);
		button_crusher = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_crusher"), e -> {
		}).bounds(this.leftPos + 178, this.topPos + 128, 50, 20).build();
		this.addRenderableWidget(button_crusher);
		button_more = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_more"), e -> {
		}).bounds(this.leftPos + 232, this.topPos + 127, 61, 20).build();
		this.addRenderableWidget(button_more);
	}
}
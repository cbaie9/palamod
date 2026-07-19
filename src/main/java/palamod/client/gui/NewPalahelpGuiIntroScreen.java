package palamod.client.gui;

import palamod.world.inventory.NewPalahelpGuiIntroMenu;

import palamod.network.NewPalahelpGuiIntroButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

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
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");

	public NewPalahelpGuiIntroScreen(NewPalahelpGuiIntroMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 180;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 88 && mouseX < leftPos + 138 && mouseY > topPos + 155 && mouseY < topPos + 167) {
			if (Component.translatable("gui.palamod.new_palahelp_gui_intro.tooltip_can_also_be_accessible_by_the_co").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.new_palahelp_gui_intro.tooltip_can_also_be_accessible_by_the_co").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 1, this.topPos + -2, 0, 0, 320, 180, 320, 180);
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
		int heightPadding = 0;
		int yOffset = 0;
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.new_palahelp_gui_intro.label_palahelp").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 17, 10 + yOffset, -52480, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.new_palahelp_gui_intro.label_thanks_for_install_my_mod").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 15, 21 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.new_palahelp_gui_intro.label_this_is_an_intern_wiki_for_the_m").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 17, 142 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.new_palahelp_gui_intro.label_for_the_mod").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 16, 155 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.new_palahelp_gui_intro.label_summary").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 218, 14 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.new_palahelp_gui_intro.label_machines").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 187, 99 + yOffset, -16777063, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.new_palahelp_gui_intro.label_my_mod").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 17, 30 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		button_ores = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_ores"), e -> {
			int x = NewPalahelpGuiIntroScreen.this.x;
			int y = NewPalahelpGuiIntroScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NewPalahelpGuiIntroButtonMessage(0, x, y, z));
				NewPalahelpGuiIntroButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 188, this.topPos + 30, 50, 20).build();
		this.addRenderableWidget(button_ores);
		button_trees = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_trees"), e -> {
			int x = NewPalahelpGuiIntroScreen.this.x;
			int y = NewPalahelpGuiIntroScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NewPalahelpGuiIntroButtonMessage(1, x, y, z));
				NewPalahelpGuiIntroButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 188, this.topPos + 54, 50, 20).build();
		this.addRenderableWidget(button_trees);
		button_armors = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_armors"), e -> {
			int x = NewPalahelpGuiIntroScreen.this.x;
			int y = NewPalahelpGuiIntroScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NewPalahelpGuiIntroButtonMessage(2, x, y, z));
				NewPalahelpGuiIntroButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 242, this.topPos + 30, 61, 20).build();
		this.addRenderableWidget(button_armors);
		button_liquids = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_liquids"), e -> {
			int x = NewPalahelpGuiIntroScreen.this.x;
			int y = NewPalahelpGuiIntroScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NewPalahelpGuiIntroButtonMessage(3, x, y, z));
				NewPalahelpGuiIntroButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 242, this.topPos + 54, 61, 20).build();
		this.addRenderableWidget(button_liquids);
		button_commands = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_commands"), e -> {
			int x = NewPalahelpGuiIntroScreen.this.x;
			int y = NewPalahelpGuiIntroScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NewPalahelpGuiIntroButtonMessage(4, x, y, z));
				NewPalahelpGuiIntroButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 188, this.topPos + 76, 50, 20).build();
		this.addRenderableWidget(button_commands);
		button_jobs = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_jobs"), e -> {
		}).bounds(this.leftPos + 242, this.topPos + 76, 61, 20).build();
		this.addRenderableWidget(button_jobs);
		button_grinder = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_grinder"), e -> {
			int x = NewPalahelpGuiIntroScreen.this.x;
			int y = NewPalahelpGuiIntroScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NewPalahelpGuiIntroButtonMessage(6, x, y, z));
				NewPalahelpGuiIntroButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 188, this.topPos + 113, 50, 20).build();
		this.addRenderableWidget(button_grinder);
		button_palamachine = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_palamachine"), e -> {
			int x = NewPalahelpGuiIntroScreen.this.x;
			int y = NewPalahelpGuiIntroScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NewPalahelpGuiIntroButtonMessage(7, x, y, z));
				NewPalahelpGuiIntroButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 242, this.topPos + 113, 61, 20).build();
		this.addRenderableWidget(button_palamachine);
		button_crusher = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_crusher"), e -> {
			int x = NewPalahelpGuiIntroScreen.this.x;
			int y = NewPalahelpGuiIntroScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new NewPalahelpGuiIntroButtonMessage(8, x, y, z));
				NewPalahelpGuiIntroButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 188, this.topPos + 135, 50, 20).build();
		this.addRenderableWidget(button_crusher);
		button_more = Button.builder(Component.translatable("gui.palamod.new_palahelp_gui_intro.button_more"), e -> {
		}).bounds(this.leftPos + 242, this.topPos + 134, 61, 20).build();
		this.addRenderableWidget(button_more);
	}
}
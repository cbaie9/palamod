package palamod.client.gui;

import palamod.world.inventory.PalamachinepalahelpguiMenu;

import palamod.procedures.Palahelppalamachine4Procedure;
import palamod.procedures.Palahelppalamachine3Procedure;
import palamod.procedures.Palahelppalamachine2Procedure;
import palamod.procedures.Palahelppalamachine1Procedure;
import palamod.procedures.Palahelppalamachine0Procedure;

import palamod.network.PalamachinepalahelpguiButtonMessage;

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

public class PalamachinepalahelpguiScreen extends AbstractContainerScreen<PalamachinepalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_back;
	private Button button_menu;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("palamod:textures/screens/palamachinepalahelpgui.png");

	public PalamachinepalahelpguiScreen(PalamachinepalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 215;
		this.imageHeight = 200;
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palamachinepalahelpgui.label_palamachine").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 77, 17 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Palahelppalamachine0Procedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 33 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Palahelppalamachine1Procedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 46 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Palahelppalamachine2Procedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 58 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Palahelppalamachine3Procedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 6, 77 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Palahelppalamachine4Procedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 55, 184 + yOffset, -3394816, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palamachinepalahelpgui.label_now_in_jei").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 62, 120 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		button_back = Button.builder(Component.translatable("gui.palamod.palamachinepalahelpgui.button_back"), e -> {
			int x = PalamachinepalahelpguiScreen.this.x;
			int y = PalamachinepalahelpguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PalamachinepalahelpguiButtonMessage(0, x, y, z));
				PalamachinepalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 17, this.topPos + 7, 45, 20).build();
		this.addRenderableWidget(button_back);
		button_menu = Button.builder(Component.translatable("gui.palamod.palamachinepalahelpgui.button_menu"), e -> {
			int x = PalamachinepalahelpguiScreen.this.x;
			int y = PalamachinepalahelpguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PalamachinepalahelpguiButtonMessage(1, x, y, z));
				PalamachinepalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 145, this.topPos + 7, 45, 20).build();
		this.addRenderableWidget(button_menu);
	}
}
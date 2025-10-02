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

import com.mojang.blaze3d.systems.RenderSystem;

public class PalamachinepalahelpguiScreen extends AbstractContainerScreen<PalamachinepalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_back;
	Button button_menu;

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

	private static final ResourceLocation texture = ResourceLocation.parse("palamod:textures/screens/palamachinepalahelpgui.png");

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
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palamachinepalahelpgui.label_palamachine"), 77, 17, -12829636, false);
		guiGraphics.drawString(this.font, Palahelppalamachine0Procedure.execute(entity), 4, 33, -12829636, false);
		guiGraphics.drawString(this.font, Palahelppalamachine1Procedure.execute(entity), 4, 46, -12829636, false);
		guiGraphics.drawString(this.font, Palahelppalamachine2Procedure.execute(entity), 4, 58, -12829636, false);
		guiGraphics.drawString(this.font, Palahelppalamachine3Procedure.execute(entity), 6, 77, -12829636, false);
		guiGraphics.drawString(this.font, Palahelppalamachine4Procedure.execute(entity), 55, 184, -3394816, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palamachinepalahelpgui.label_now_in_jei"), 62, 120, -12829636, false);
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
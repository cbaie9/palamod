package palamod.client.gui;

import palamod.world.inventory.PotgtranfertMenu;

import palamod.procedures.PotgtransfertvalueentityProcedure;
import palamod.procedures.PotgtranfertValueProcedure;

import palamod.network.PotgtranfertButtonMessage;

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

public class PotgtranfertScreen extends AbstractContainerScreen<PotgtranfertMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_transfert;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/potgtranfert.png");

	public PotgtranfertScreen(PotgtranfertMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.potgtranfert.label_potg_transfert_gui").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 3 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(PotgtranfertValueProcedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 5, 69 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(PotgtransfertvalueentityProcedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 56 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		button_transfert = Button.builder(Component.translatable("gui.palamod.potgtranfert.button_transfert"), e -> {
			int x = PotgtranfertScreen.this.x;
			int y = PotgtranfertScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PotgtranfertButtonMessage(0, x, y, z));
				PotgtranfertButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 93, this.topPos + 25, 72, 20).build();
		this.addRenderableWidget(button_transfert);
	}
}
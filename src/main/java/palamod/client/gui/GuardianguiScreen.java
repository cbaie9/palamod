package palamod.client.gui;

import palamod.world.inventory.GuardianguiMenu;

import palamod.procedures.GuardianentityproviderProcedure;
import palamod.procedures.GetguardianpvProcedure;
import palamod.procedures.GetguardianlevelProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuardianguiScreen extends AbstractContainerScreen<GuardianguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_arbre_de_competance;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("palamod:textures/screens/guardiangui.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/golem_blackground.png");

	public GuardianguiScreen(GuardianguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 310;
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
		if (GuardianentityproviderProcedure.execute(world, x, y, z) instanceof LivingEntity livingEntity) {
			PalamodModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 55, this.topPos + 75, 30, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(IMAGE_0, this.leftPos + 21, this.topPos + 6, 0, 0, 64, 128, 64, 128);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.guardiangui.label_degats").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 215, 67 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.guardiangui.label_pv").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 273, 67 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.guardiangui.label_golem").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 140, 8 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.guardiangui.label_level").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 125, 29 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.guardiangui.label_renommer").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 112, 69 + yOffset, -256, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.guardiangui.label_whitelist").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 158, 70 + yOffset, -65536, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetguardianlevelProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 156, 29 + yOffset, -65485, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetguardianpvProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 260, 85 + yOffset, -65434, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		button_arbre_de_competance = Button.builder(Component.translatable("gui.palamod.guardiangui.button_arbre_de_competance"), e -> {
		}).bounds(this.leftPos + 4, this.topPos + 139, 124, 20).build();
		this.addRenderableWidget(button_arbre_de_competance);
	}
}
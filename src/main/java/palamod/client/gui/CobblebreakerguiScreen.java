package palamod.client.gui;

import palamod.world.inventory.CobblebreakerguiMenu;

import palamod.procedures.CobblebreakerarrowreturnspriteProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class CobblebreakerguiScreen extends AbstractContainerScreen<CobblebreakerguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/cobblebreakergui.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/particle_iron.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/particle_gold.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/particle_diamond.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/particle_amethyst.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/particle_titane.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/particle_paladium.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("palamod:textures/screens/green_paladium_particle.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("palamod:textures/screens/upgrade_cobblebreaker.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("palamod:textures/screens/arrow_down_sprite16.png");

	public CobblebreakerguiScreen(CobblebreakerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
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
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 176, 180, 176, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + 18, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + 39, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 60, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 81, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_5, this.leftPos + 102, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_6, this.leftPos + 123, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_7, this.leftPos + 144, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_8, this.leftPos + 148, this.topPos + 14, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(SPRITE_0, this.leftPos + 82, this.topPos + 25, Mth.clamp((int) CobblebreakerarrowreturnspriteProcedure.execute(world, x, y, z) * 14, 0, 266), 0, 14, 16, 280, 16);
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
	}

	@Override
	public void init() {
		super.init();
	}
}
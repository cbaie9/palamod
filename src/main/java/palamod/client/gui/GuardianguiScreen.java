package palamod.client.gui;

import palamod.world.inventory.GuardianguiMenu;

import palamod.procedures.GuardianentityproviderProcedure;
import palamod.procedures.GetguardianpvProcedure;
import palamod.procedures.GetguardianlevelProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GuardianguiScreen extends AbstractContainerScreen<GuardianguiMenu> {
	private final static HashMap<String, Object> guistate = GuardianguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_arbre_de_competance;

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

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/guardiangui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (GuardianentityproviderProcedure.execute(world, x, y, z) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 55, this.topPos + 75, 30, 0f, 0, livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/golem_blackground.png"), this.leftPos + 21, this.topPos + 6, 0, 0, 64, 128, 64, 128);

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.guardiangui.label_degats"), 215, 67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.guardiangui.label_pv"), 273, 67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.guardiangui.label_golem"), 140, 8, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.guardiangui.label_level"), 125, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.guardiangui.label_renommer"), 112, 69, -256, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.guardiangui.label_whitelist"), 158, 70, -65536, false);
		guiGraphics.drawString(this.font,

				GetguardianlevelProcedure.execute(), 156, 29, -65485, false);
		guiGraphics.drawString(this.font,

				GetguardianpvProcedure.execute(), 260, 85, -65434, false);
	}

	@Override
	public void init() {
		super.init();
		button_arbre_de_competance = Button.builder(Component.translatable("gui.palamod.guardiangui.button_arbre_de_competance"), e -> {
		}).bounds(this.leftPos + 4, this.topPos + 139, 124, 20).build();
		guistate.put("button:button_arbre_de_competance", button_arbre_de_competance);
		this.addRenderableWidget(button_arbre_de_competance);
	}
}

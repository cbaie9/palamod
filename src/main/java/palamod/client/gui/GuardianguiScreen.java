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
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class GuardianguiScreen extends AbstractContainerScreen<GuardianguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_arbre_de_competance;
	private static final Identifier BACKGROUND = Identifier.parse("palamod:textures/screens/guardiangui.png");
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/golem_blackground.png");

	public GuardianguiScreen(GuardianguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 310, 200);
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
		if (GuardianentityproviderProcedure.execute(world, x, y, z) instanceof LivingEntity livingEntity) {
			InventoryScreen.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + -945, this.topPos + -925, this.leftPos + 1055, this.topPos + 1075, 30, -livingEntity.getBbHeight() / (2.0f * livingEntity.getScale()), 0f, 0, livingEntity);
		}
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 21, this.topPos + 6, 0, 0, 64, 128, 64, 128);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.guardiangui.label_degats"), 215, 67, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.guardiangui.label_pv"), 273, 67, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.guardiangui.label_golem"), 140, 8, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.guardiangui.label_level"), 125, 29, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.guardiangui.label_renommer"), 112, 69, -256, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.guardiangui.label_whitelist"), 158, 70, -65536, false);
		guiGraphics.text(this.font, GetguardianlevelProcedure.execute(), 156, 29, -65485, false);
		guiGraphics.text(this.font, GetguardianpvProcedure.execute(), 260, 85, -65434, false);
	}

	@Override
	public void init() {
		super.init();
		button_arbre_de_competance = Button.builder(Component.translatable("gui.palamod.guardiangui.button_arbre_de_competance"), e -> {
		}).bounds(this.leftPos + 4, this.topPos + 139, 124, 20).build();
		this.addRenderableWidget(button_arbre_de_competance);
	}
}
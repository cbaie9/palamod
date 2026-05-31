package palamod.client.gui;

import palamod.world.inventory.GolemtreecMenu;

import palamod.procedures.GetgolemusablepointProcedure;
import palamod.procedures.GetgolempvleveltreeProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class GolemtreecScreen extends AbstractContainerScreen<GolemtreecMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox upgarde_base;
	private Checkbox golem_v_hunter1;
	private Checkbox golem_v_farmer1;
	private Button button_see_ultilitary_branch;
	private Button button_buy_selected_upgrade;
	private static final Identifier BACKGROUND = Identifier.parse("palamod:textures/screens/golemtreec.png");
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/golem_llh.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/golem_llh.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/golem_ltf.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/golem_ltf.png");

	public GolemtreecScreen(GolemtreecMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 400, 220);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("upgarde_base")) {
				if (upgarde_base.selected() != logicState)
					upgarde_base.onPress(null);
			} else if (name.equals("golem_v_hunter1")) {
				if (golem_v_hunter1.selected() != logicState)
					golem_v_hunter1.onPress(null);
			} else if (name.equals("golem_v_farmer1")) {
				if (golem_v_farmer1.selected() != logicState)
					golem_v_farmer1.onPress(null);
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 66, this.topPos + 156, 0, 0, 64, 64, 64, 64);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 125, this.topPos + 119, 0, 0, 64, 64, 64, 64);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 192, this.topPos + 119, 0, 0, 64, 64, 64, 64);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 255, this.topPos + 156, 0, 0, 64, 64, 64, 64);
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
		guiGraphics.text(this.font, GetgolempvleveltreeProcedure.execute(), 6, 7, -52429, false);
		guiGraphics.text(this.font, GetgolemusablepointProcedure.execute(), 6, 18, -16777012, false);
	}

	@Override
	public void init() {
		super.init();
		button_see_ultilitary_branch = Button.builder(Component.translatable("gui.palamod.golemtreec.button_see_ultilitary_branch"), e -> {
		}).bounds(this.leftPos + 6, this.topPos + 65, 140, 20).build();
		this.addRenderableWidget(button_see_ultilitary_branch);
		button_buy_selected_upgrade = Button.builder(Component.translatable("gui.palamod.golemtreec.button_buy_selected_upgrade"), e -> {
		}).bounds(this.leftPos + 263, this.topPos + 29, 129, 20).build();
		this.addRenderableWidget(button_buy_selected_upgrade);
		upgarde_base = Checkbox.builder(Component.translatable("gui.palamod.golemtreec.upgarde_base"), this.font).pos(this.leftPos + 181, this.topPos + 99).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "upgarde_base", value, false);
		}).build();
		this.addRenderableWidget(upgarde_base);
		golem_v_hunter1 = Checkbox.builder(Component.translatable("gui.palamod.golemtreec.golem_v_hunter1"), this.font).pos(this.leftPos + 46, this.topPos + 194).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "golem_v_hunter1", value, false);
		}).build();
		this.addRenderableWidget(golem_v_hunter1);
		golem_v_farmer1 = Checkbox.builder(Component.translatable("gui.palamod.golemtreec.golem_v_farmer1"), this.font).pos(this.leftPos + 318, this.topPos + 193).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "golem_v_farmer1", value, false);
		}).build();
		this.addRenderableWidget(golem_v_farmer1);
	}
}
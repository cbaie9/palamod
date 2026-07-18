package palamod.client.gui;

import palamod.world.inventory.GolemtreecMenu;

import palamod.procedures.GetgolemusablepointProcedure;
import palamod.procedures.GetgolempvleveltreeProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

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
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("palamod:textures/screens/golemtreec.png");
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/golem_llh.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/golem_llh.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/golem_ltf.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/golem_ltf.png");

	public GolemtreecScreen(GolemtreecMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 220;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("upgarde_base")) {
				if (upgarde_base.selected() != logicState)
					upgarde_base.onPress();
			} else if (name.equals("golem_v_hunter1")) {
				if (golem_v_hunter1.selected() != logicState)
					golem_v_hunter1.onPress();
			} else if (name.equals("golem_v_farmer1")) {
				if (golem_v_farmer1.selected() != logicState)
					golem_v_farmer1.onPress();
			}
		}
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 66, this.topPos + 156, 0, 0, 64, 64, 64, 64);
		guiGraphics.blit(IMAGE_1, this.leftPos + 125, this.topPos + 119, 0, 0, 64, 64, 64, 64);
		guiGraphics.blit(IMAGE_2, this.leftPos + 192, this.topPos + 119, 0, 0, 64, 64, 64, 64);
		guiGraphics.blit(IMAGE_3, this.leftPos + 255, this.topPos + 156, 0, 0, 64, 64, 64, 64);
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
		for (Component actualComponent : Arrays.stream(GetgolempvleveltreeProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 6, 7 + yOffset, -52429, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetgolemusablepointProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 6, 18 + yOffset, -16777012, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
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
package palamod.client.gui;

import palamod.world.inventory.GolemtreecMenu;

import palamod.procedures.GetgolemusablepointProcedure;
import palamod.procedures.GetgolempvleveltreeProcedure;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GolemtreecScreen extends AbstractContainerScreen<GolemtreecMenu> {
	private final static HashMap<String, Object> guistate = GolemtreecMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox upgarde_base;
	Checkbox golem_v_hunter1;
	Checkbox golem_v_farmer1;
	Button button_see_ultilitary_branch;
	Button button_buy_selected_upgrade;

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

	private static final ResourceLocation texture = new ResourceLocation("palamod:textures/screens/golemtreec.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/golem_llh.png"), this.leftPos + 66, this.topPos + 156, 0, 0, 64, 64, 64, 64);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/golem_llh.png"), this.leftPos + 125, this.topPos + 119, 0, 0, 64, 64, 64, 64);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/golem_ltf.png"), this.leftPos + 192, this.topPos + 119, 0, 0, 64, 64, 64, 64);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/golem_ltf.png"), this.leftPos + 255, this.topPos + 156, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font,

				GetgolempvleveltreeProcedure.execute(), 6, 7, -52429, false);
		guiGraphics.drawString(this.font,

				GetgolemusablepointProcedure.execute(), 6, 18, -16777012, false);
	}

	@Override
	public void init() {
		super.init();
		button_see_ultilitary_branch = Button.builder(Component.translatable("gui.palamod.golemtreec.button_see_ultilitary_branch"), e -> {
		}).bounds(this.leftPos + 6, this.topPos + 65, 140, 20).build();
		guistate.put("button:button_see_ultilitary_branch", button_see_ultilitary_branch);
		this.addRenderableWidget(button_see_ultilitary_branch);
		button_buy_selected_upgrade = Button.builder(Component.translatable("gui.palamod.golemtreec.button_buy_selected_upgrade"), e -> {
		}).bounds(this.leftPos + 263, this.topPos + 29, 129, 20).build();
		guistate.put("button:button_buy_selected_upgrade", button_buy_selected_upgrade);
		this.addRenderableWidget(button_buy_selected_upgrade);
		upgarde_base = new Checkbox(this.leftPos + 181, this.topPos + 99, 20, 20, Component.translatable("gui.palamod.golemtreec.upgarde_base"), false);
		guistate.put("checkbox:upgarde_base", upgarde_base);
		this.addRenderableWidget(upgarde_base);
		golem_v_hunter1 = new Checkbox(this.leftPos + 46, this.topPos + 194, 20, 20, Component.translatable("gui.palamod.golemtreec.golem_v_hunter1"), false);
		guistate.put("checkbox:golem_v_hunter1", golem_v_hunter1);
		this.addRenderableWidget(golem_v_hunter1);
		golem_v_farmer1 = new Checkbox(this.leftPos + 318, this.topPos + 193, 20, 20, Component.translatable("gui.palamod.golemtreec.golem_v_farmer1"), false);
		guistate.put("checkbox:golem_v_farmer1", golem_v_farmer1);
		this.addRenderableWidget(golem_v_farmer1);
	}
}

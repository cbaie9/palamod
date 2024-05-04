package palamod.client.gui;

import palamod.world.inventory.StockhdvMenu;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class StockhdvScreen extends AbstractContainerScreen<StockhdvMenu> {
	private final static HashMap<String, Object> guistate = StockhdvMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_return_to_admin_panel;
	Button button_quit_admin_panel;

	public StockhdvScreen(StockhdvMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 425;
		this.imageHeight = 240;
	}

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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/stockhdv.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 425, 240, 425, 240);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.stockhdv.label_0_1_2_3_4_5_6_7_8"), 4, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.stockhdv.label_23_24_25_26_27_28_29_30_31"), 4, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.stockhdv.label_46_47_48_49_50_51_52_53_54"), 8, 59, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.stockhdv.label_inventory"), 246, 142, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.stockhdv.label_stocks_hdv_items_0_10_0"), 248, 131, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.stockhdv.label_69_70_71_72_73_74_75_76_77_7"), 7, 87, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_return_to_admin_panel = Button.builder(Component.translatable("gui.palamod.stockhdv.button_return_to_admin_panel"), e -> {
		}).bounds(this.leftPos + 115, this.topPos + 213, 134, 20).build();
		guistate.put("button:button_return_to_admin_panel", button_return_to_admin_panel);
		this.addRenderableWidget(button_return_to_admin_panel);
		button_quit_admin_panel = Button.builder(Component.translatable("gui.palamod.stockhdv.button_quit_admin_panel"), e -> {
		}).bounds(this.leftPos + 4, this.topPos + 213, 108, 20).build();
		guistate.put("button:button_quit_admin_panel", button_quit_admin_panel);
		this.addRenderableWidget(button_quit_admin_panel);
	}
}

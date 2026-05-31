package palamod.client.gui;

import palamod.world.inventory.StockhdvMenu;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class StockhdvScreen extends AbstractContainerScreen<StockhdvMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_return_to_admin_panel;
	private Button button_quit_admin_panel;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/stockhdv.png");

	public StockhdvScreen(StockhdvMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 425, 240);
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
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 425, 240, 425, 240);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.stockhdv.label_0_1_2_3_4_5_6_7_8"), 4, 4, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.stockhdv.label_23_24_25_26_27_28_29_30_31"), 4, 32, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.stockhdv.label_46_47_48_49_50_51_52_53_54"), 8, 59, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.stockhdv.label_inventory"), 246, 142, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.stockhdv.label_stocks_hdv_items_0_10_0"), 248, 131, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.stockhdv.label_69_70_71_72_73_74_75_76_77_7"), 7, 87, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_return_to_admin_panel = Button.builder(Component.translatable("gui.palamod.stockhdv.button_return_to_admin_panel"), e -> {
		}).bounds(this.leftPos + 115, this.topPos + 213, 134, 20).build();
		this.addRenderableWidget(button_return_to_admin_panel);
		button_quit_admin_panel = Button.builder(Component.translatable("gui.palamod.stockhdv.button_quit_admin_panel"), e -> {
		}).bounds(this.leftPos + 4, this.topPos + 213, 108, 20).build();
		this.addRenderableWidget(button_quit_admin_panel);
	}
}
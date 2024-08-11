package palamod.client.gui;

import palamod.world.inventory.AdminshoporeMenu;

import palamod.network.AdminshoporeButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshoporeScreen extends AbstractContainerScreen<AdminshoporeMenu> {
	private final static HashMap<String, Object> guistate = AdminshoporeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_paladium;
	Button button_titane;
	Button button_amethyst;
	Button button_findium;
	Button button_diamond;
	Button button_iron;
	Button button_gold;
	Button button_coal;
	Button button_redstone;
	Button button_emerald;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_arrow_adminshop;

	public AdminshoporeScreen(AdminshoporeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 183;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 149 && mouseX < leftPos + 165 && mouseY > topPos + 4 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.adminshopore.tooltip_close_the_gui"), mouseX, mouseY);
		if (mouseX > leftPos + 6 && mouseX < leftPos + 21 && mouseY > topPos + 6 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.adminshopore.tooltip_return_to_the_adminshop_menu"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/gui176_166.png"), this.leftPos + -1, this.topPos + 17, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopore.label_adminshop_ore_menu"), 35, 7, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_paladium = Button.builder(Component.translatable("gui.palamod.adminshopore.button_paladium"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(0, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 24, 72, 20).build();
		guistate.put("button:button_paladium", button_paladium);
		this.addRenderableWidget(button_paladium);
		button_titane = Button.builder(Component.translatable("gui.palamod.adminshopore.button_titane"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(1, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 24, 61, 20).build();
		guistate.put("button:button_titane", button_titane);
		this.addRenderableWidget(button_titane);
		button_amethyst = Button.builder(Component.translatable("gui.palamod.adminshopore.button_amethyst"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(2, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 46, 72, 20).build();
		guistate.put("button:button_amethyst", button_amethyst);
		this.addRenderableWidget(button_amethyst);
		button_findium = Button.builder(Component.translatable("gui.palamod.adminshopore.button_findium"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(3, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 46, 61, 20).build();
		guistate.put("button:button_findium", button_findium);
		this.addRenderableWidget(button_findium);
		button_diamond = Button.builder(Component.translatable("gui.palamod.adminshopore.button_diamond"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(4, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 68, 72, 20).build();
		guistate.put("button:button_diamond", button_diamond);
		this.addRenderableWidget(button_diamond);
		button_iron = Button.builder(Component.translatable("gui.palamod.adminshopore.button_iron"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(5, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 68, 61, 20).build();
		guistate.put("button:button_iron", button_iron);
		this.addRenderableWidget(button_iron);
		button_gold = Button.builder(Component.translatable("gui.palamod.adminshopore.button_gold"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(6, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 90, 72, 20).build();
		guistate.put("button:button_gold", button_gold);
		this.addRenderableWidget(button_gold);
		button_coal = Button.builder(Component.translatable("gui.palamod.adminshopore.button_coal"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(7, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 90, 61, 20).build();
		guistate.put("button:button_coal", button_coal);
		this.addRenderableWidget(button_coal);
		button_redstone = Button.builder(Component.translatable("gui.palamod.adminshopore.button_redstone"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(8, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 112, 72, 20).build();
		guistate.put("button:button_redstone", button_redstone);
		this.addRenderableWidget(button_redstone);
		button_emerald = Button.builder(Component.translatable("gui.palamod.adminshopore.button_emerald"), e -> {
		}).bounds(this.leftPos + 104, this.topPos + 112, 61, 20).build();
		guistate.put("button:button_emerald", button_emerald);
		this.addRenderableWidget(button_emerald);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 149, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(10, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 5, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshoporeButtonMessage(11, x, y, z));
				AdminshoporeButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}

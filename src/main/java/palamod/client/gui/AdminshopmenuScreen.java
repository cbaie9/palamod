package palamod.client.gui;

import palamod.world.inventory.AdminshopmenuMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshopmenuButtonMessage;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshopmenuScreen extends AbstractContainerScreen<AdminshopmenuMenu> {
	private final static HashMap<String, Object> guistate = AdminshopmenuMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_admin_btte_ore;
	ImageButton imagebutton_btte_block;
	ImageButton imagebutton_btte_plant;
	ImageButton imagebutton_btte_mobs;
	ImageButton imagebutton_btte_utilities;

	public AdminshopmenuScreen(AdminshopmenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 177;
		this.imageHeight = 186;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 156 && mouseX < leftPos + 172 && mouseY > topPos + 4 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.literal(ClosetheguitransProcedure.execute()), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/adminshopmenu.png"), this.leftPos + 0, this.topPos + 20, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 1, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 76, this.topPos + 1, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopmenu.label_adminshop"), 61, 6, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 156, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(0, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_admin_btte_ore = new ImageButton(this.leftPos + 61, this.topPos + 65, 48, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/admin_btte_ore.png"), ResourceLocation.parse("palamod:textures/screens/admin_btte_ore_poi.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(1, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_admin_btte_ore", imagebutton_admin_btte_ore);
		this.addRenderableWidget(imagebutton_admin_btte_ore);
		imagebutton_btte_block = new ImageButton(this.leftPos + 60, this.topPos + 35, 48, 17, new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/btte_block.png"), ResourceLocation.parse("palamod:textures/screens/btte_block_poi.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(2, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_btte_block", imagebutton_btte_block);
		this.addRenderableWidget(imagebutton_btte_block);
		imagebutton_btte_plant = new ImageButton(this.leftPos + 61, this.topPos + 96, 48, 17, new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/btte_plant.png"), ResourceLocation.parse("palamod:textures/screens/btte_plant_poi.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(3, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_btte_plant", imagebutton_btte_plant);
		this.addRenderableWidget(imagebutton_btte_plant);
		imagebutton_btte_mobs = new ImageButton(this.leftPos + 60, this.topPos + 128, 48, 17, new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/btte_mobs.png"), ResourceLocation.parse("palamod:textures/screens/btte_mobs_poi.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(4, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_btte_mobs", imagebutton_btte_mobs);
		this.addRenderableWidget(imagebutton_btte_mobs);
		imagebutton_btte_utilities = new ImageButton(this.leftPos + 60, this.topPos + 159, 48, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/btte_utilities.png"), ResourceLocation.parse("palamod:textures/screens/btte_utilities_poi.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(5, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_btte_utilities", imagebutton_btte_utilities);
		this.addRenderableWidget(imagebutton_btte_utilities);
	}
}

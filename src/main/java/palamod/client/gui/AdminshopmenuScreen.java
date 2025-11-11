package palamod.client.gui;

import palamod.world.inventory.AdminshopmenuMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshopmenuButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

public class AdminshopmenuScreen extends AbstractContainerScreen<AdminshopmenuMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_admin_btte_ore;
	private ImageButton imagebutton_btte_block;
	private ImageButton imagebutton_btte_plant;
	private ImageButton imagebutton_btte_mobs;
	private ImageButton imagebutton_btte_utilities;

	public AdminshopmenuScreen(AdminshopmenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 177;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 154 && mouseX < leftPos + 170 && mouseY > topPos + 5 && mouseY < topPos + 21) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.setComponentTooltipForNextFrame(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/gui176_166.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopmenu.label_adminshop"), 60, 7, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(0, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_admin_btte_ore = new ImageButton(this.leftPos + 60, this.topPos + 61, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_ore_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_ore_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(1, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_admin_btte_ore);
		imagebutton_btte_block = new ImageButton(this.leftPos + 60, this.topPos + 32, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_block_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_block_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(2, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_btte_block);
		imagebutton_btte_plant = new ImageButton(this.leftPos + 60, this.topPos + 87, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_plant_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_plant_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(3, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_btte_plant);
		imagebutton_btte_mobs = new ImageButton(this.leftPos + 61, this.topPos + 114, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_mobs_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_mobs_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(4, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_btte_mobs);
		imagebutton_btte_utilities = new ImageButton(this.leftPos + 61, this.topPos + 141, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_item_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_item_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(5, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_btte_utilities);
	}
}
package palamod.client.gui;

import palamod.world.inventory.ItemmenupalahelpMenu;

import palamod.network.ItemmenupalahelpButtonMessage;

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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

public class ItemmenupalahelpScreen extends AbstractContainerScreen<ItemmenupalahelpMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_legendary_stone;
	private Button button_armor;
	private Button button_xp_bush_xp_berries;
	private Button button_newstck;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_home_pixel_adminshop;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/gui176_166.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/forest32.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/desert16.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/fish32.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/lake32.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/nether32.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/plains16.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("palamod:textures/screens/left_gray_line.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("palamod:textures/screens/right_gray_line.png");

	public ItemmenupalahelpScreen(ItemmenupalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
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
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 1, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 32, this.topPos + 56, 0, 0, 32, 16, 32, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 8, this.topPos + 24, 0, 0, 17, 16, 17, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 24, this.topPos + 24, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 8, this.topPos + 56, 0, 0, 32, 32, 32, 32);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 8, this.topPos + 87, 0, 0, 32, 16, 32, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 8, this.topPos + 40, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_7, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_8, this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.itemmenupalahelp.label_item_menu"), 3, 7, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_legendary_stone = Button.builder(Component.translatable("gui.palamod.itemmenupalahelp.button_legendary_stone"), e -> {
			int x = ItemmenupalahelpScreen.this.x;
			int y = ItemmenupalahelpScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ItemmenupalahelpButtonMessage(0, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 26, 100, 20).build();
		this.addRenderableWidget(button_legendary_stone);
		button_armor = Button.builder(Component.translatable("gui.palamod.itemmenupalahelp.button_armor"), e -> {
			int x = ItemmenupalahelpScreen.this.x;
			int y = ItemmenupalahelpScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ItemmenupalahelpButtonMessage(1, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 76, 61, 20).build();
		this.addRenderableWidget(button_armor);
		button_xp_bush_xp_berries = Button.builder(Component.translatable("gui.palamod.itemmenupalahelp.button_xp_bush_xp_berries"), e -> {
		}).bounds(this.leftPos + 40, this.topPos + 101, 125, 20).build();
		this.addRenderableWidget(button_xp_bush_xp_berries);
		button_newstck = Button.builder(Component.translatable("gui.palamod.itemmenupalahelp.button_newstck"), e -> {
			int x = ItemmenupalahelpScreen.this.x;
			int y = ItemmenupalahelpScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ItemmenupalahelpButtonMessage(3, x, y, z));
				ItemmenupalahelpButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 104, this.topPos + 51, 61, 20).build();
		this.addRenderableWidget(button_newstck);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = ItemmenupalahelpScreen.this.x;
					int y = ItemmenupalahelpScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ItemmenupalahelpButtonMessage(4, x, y, z));
						ItemmenupalahelpButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 133, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = ItemmenupalahelpScreen.this.x;
					int y = ItemmenupalahelpScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ItemmenupalahelpButtonMessage(5, x, y, z));
						ItemmenupalahelpButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 114, this.topPos + 6, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = ItemmenupalahelpScreen.this.x;
					int y = ItemmenupalahelpScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ItemmenupalahelpButtonMessage(6, x, y, z));
						ItemmenupalahelpButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}
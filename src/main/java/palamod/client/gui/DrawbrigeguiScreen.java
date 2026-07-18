package palamod.client.gui;

import palamod.world.inventory.DrawbrigeguiMenu;

import palamod.network.DrawbrigeguiButtonMessage;

import palamod.init.PalamodModScreens;

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

import com.mojang.blaze3d.systems.RenderSystem;

public class DrawbrigeguiScreen extends AbstractContainerScreen<DrawbrigeguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_arrow_down0001;
	private ImageButton imagebutton_arrow_right01;
	private ImageButton imagebutton_arrow_up01;
	private ImageButton imagebutton_arrow_left01;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/drawbrigegui.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("palamod:textures/screens/big_slot.png");

	public DrawbrigeguiScreen(DrawbrigeguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 280;
		this.imageHeight = 160;
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
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 280, 160, 280, 160);
		guiGraphics.blit(IMAGE_1, this.leftPos + 41, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_2, this.leftPos + 15, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_3, this.leftPos + 15, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_4, this.leftPos + 93, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_5, this.leftPos + 67, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_6, this.leftPos + 41, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_7, this.leftPos + 67, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_8, this.leftPos + 93, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_9, this.leftPos + 119, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_10, this.leftPos + 119, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_11, this.leftPos + 145, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_12, this.leftPos + 145, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_13, this.leftPos + 171, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_14, this.leftPos + 171, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_15, this.leftPos + 197, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(IMAGE_16, this.leftPos + 197, this.topPos + 34, 0, 0, 26, 26, 26, 26);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_down0001 = new ImageButton(this.leftPos + 224, this.topPos + 116, 14, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_down_empty.png"), ResourceLocation.parse("palamod:textures/screens/arrow_down_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(0, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_down0001);
		imagebutton_arrow_right01 = new ImageButton(this.leftPos + 237, this.topPos + 102, 16, 14,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_right_empty.png"), ResourceLocation.parse("palamod:textures/screens/arrow_right_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(1, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_right01);
		imagebutton_arrow_up01 = new ImageButton(this.leftPos + 223, this.topPos + 86, 14, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_up_empty.png"), ResourceLocation.parse("palamod:textures/screens/arrow_up_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(2, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_up01);
		imagebutton_arrow_left01 = new ImageButton(this.leftPos + 208, this.topPos + 102, 16, 14,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_left_empty.png"), ResourceLocation.parse("palamod:textures/screens/arrow_left_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(3, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_left01);
	}
}
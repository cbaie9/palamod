package palamod.client.gui;

import palamod.world.inventory.DrawbrigeguiMenu;

import palamod.network.DrawbrigeguiButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class DrawbrigeguiScreen extends AbstractContainerScreen<DrawbrigeguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_arrow_down0001;
	private ImageButton imagebutton_arrow_right01;
	private ImageButton imagebutton_arrow_up01;
	private ImageButton imagebutton_arrow_left01;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/drawbrigegui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_7 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_8 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_9 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_10 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_11 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_12 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_13 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_14 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_15 = Identifier.parse("palamod:textures/screens/big_slot.png");
	private static final Identifier IMAGE_16 = Identifier.parse("palamod:textures/screens/big_slot.png");

	public DrawbrigeguiScreen(DrawbrigeguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 280, 160);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 280, 160, 280, 160);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 41, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 15, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 15, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 93, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 67, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 41, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_7, this.leftPos + 67, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_8, this.leftPos + 93, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_9, this.leftPos + 119, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_10, this.leftPos + 119, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_11, this.leftPos + 145, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_12, this.leftPos + 145, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_13, this.leftPos + 171, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_14, this.leftPos + 171, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_15, this.leftPos + 197, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_16, this.leftPos + 197, this.topPos + 34, 0, 0, 26, 26, 26, 26);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_down0001 = new ImageButton(this.leftPos + 224, this.topPos + 116, 14, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_down_empty.png"), Identifier.parse("palamod:textures/screens/arrow_down_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(0, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_down0001);
		imagebutton_arrow_right01 = new ImageButton(this.leftPos + 237, this.topPos + 102, 16, 14,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_right_empty.png"), Identifier.parse("palamod:textures/screens/arrow_right_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(1, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_right01);
		imagebutton_arrow_up01 = new ImageButton(this.leftPos + 223, this.topPos + 86, 14, 16, new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_up_empty.png"), Identifier.parse("palamod:textures/screens/arrow_up_full.png")), e -> {
			int x = DrawbrigeguiScreen.this.x;
			int y = DrawbrigeguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(2, x, y, z));
				DrawbrigeguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_up01);
		imagebutton_arrow_left01 = new ImageButton(this.leftPos + 208, this.topPos + 102, 16, 14, new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_left_empty.png"), Identifier.parse("palamod:textures/screens/arrow_left_full.png")),
				e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(3, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_left01);
	}
}
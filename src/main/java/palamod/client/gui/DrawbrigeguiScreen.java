package palamod.client.gui;

import palamod.world.inventory.DrawbrigeguiMenu;

import palamod.network.DrawbrigeguiButtonMessage;

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

public class DrawbrigeguiScreen extends AbstractContainerScreen<DrawbrigeguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_arrow_down0001;
	private ImageButton imagebutton_arrow_right01;
	private ImageButton imagebutton_arrow_up01;
	private ImageButton imagebutton_arrow_left01;

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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/drawbrigegui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 280, 160, 280, 160);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 41, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 15, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 15, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 93, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 67, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 41, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 67, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 93, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 119, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 119, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 145, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 145, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 171, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 171, this.topPos + 34, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 197, this.topPos + 8, 0, 0, 26, 26, 26, 26);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/big_slot.png"), this.leftPos + 197, this.topPos + 34, 0, 0, 26, 26, 26, 26);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_down0001 = new ImageButton(this.leftPos + 224, this.topPos + 116, 14, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_down_empty.png"), ResourceLocation.parse("palamod:textures/screens/arrow_down_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(0, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_down0001);
		imagebutton_arrow_right01 = new ImageButton(this.leftPos + 237, this.topPos + 102, 16, 14,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_right_empty.png"), ResourceLocation.parse("palamod:textures/screens/arrow_right_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(1, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_right01);
		imagebutton_arrow_up01 = new ImageButton(this.leftPos + 223, this.topPos + 86, 14, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_up_empty.png"), ResourceLocation.parse("palamod:textures/screens/arrow_up_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(2, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_up01);
		imagebutton_arrow_left01 = new ImageButton(this.leftPos + 208, this.topPos + 102, 16, 14,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_left_empty.png"), ResourceLocation.parse("palamod:textures/screens/arrow_left_full.png")), e -> {
					int x = DrawbrigeguiScreen.this.x;
					int y = DrawbrigeguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new DrawbrigeguiButtonMessage(3, x, y, z));
						DrawbrigeguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_left01);
	}
}
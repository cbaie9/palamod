package palamod.client.gui;

import palamod.world.inventory.LuckyguiMenu;

import palamod.procedures.LuckyblockgetnameProcedure;

import palamod.network.LuckyguiButtonMessage;

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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import com.mojang.blaze3d.systems.RenderSystem;

public class LuckyguiScreen extends AbstractContainerScreen<LuckyguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_open;
	private ImageButton imagebutton_cross_no_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/luckygui.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/left_gray_line.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/right_gray_line.png");

	public LuckyguiScreen(LuckyguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 180;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 180, 176, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_2, this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.luckygui.label_lucky_block"), 55, 6, -1, false);
		guiGraphics.drawString(this.font, LuckyblockgetnameProcedure.execute(world, x, y, z), 26, 84, -3407821, false);
	}

	@Override
	public void init() {
		super.init();
		button_open = Button.builder(Component.translatable("gui.palamod.luckygui.button_open"), e -> {
			int x = LuckyguiScreen.this.x;
			int y = LuckyguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new LuckyguiButtonMessage(0, x, y, z));
				LuckyguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 117, this.topPos + 44, 45, 20).build();
		this.addRenderableWidget(button_open);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 155, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = LuckyguiScreen.this.x;
					int y = LuckyguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LuckyguiButtonMessage(1, x, y, z));
						LuckyguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}
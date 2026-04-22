package palamod.client.gui;

import palamod.world.inventory.PalahelpblockMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.PalahelpblockButtonMessage;

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

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class PalahelpblockScreen extends AbstractContainerScreen<PalahelpblockMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_ore;
	private Button button_trees;
	private Button button_machine;
	private Button button_fluid;
	private ImageButton imagebutton_close_gui_nohover;
	private ImageButton imagebutton_arrow_back_true_1;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/gui176_166.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/adminshopblockoakwood.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/left_gray_line.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/right_gray_line.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/pack.png");

	public PalahelpblockScreen(PalahelpblockMenu container, Inventory inventory, Component text) {
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
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 153 && mouseX < leftPos + 170 && mouseY > topPos + 4 && mouseY < topPos + 21) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 134 && mouseX < leftPos + 149 && mouseY > topPos + 5 && mouseY < topPos + 20) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.palahelpblock.tooltip_back_to_palahelp_menu"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(IMAGE_1, this.leftPos + -1, this.topPos + 0, 0, 0, -1, -1, -1, -1);
		guiGraphics.blit(IMAGE_2, this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_3, this.leftPos + 76, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_4, this.leftPos + 6, this.topPos + 24, 0, 0, 63, 63, 63, 63);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpblock.label_palahelp_block_menu"), 6, 7, -1250068, false);
	}

	@Override
	public void init() {
		super.init();
		button_ore = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_ore"), e -> {
			int x = PalahelpblockScreen.this.x;
			int y = PalahelpblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PalahelpblockButtonMessage(0, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 31, 40, 20).build();
		this.addRenderableWidget(button_ore);
		button_trees = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_trees"), e -> {
		}).bounds(this.leftPos + 96, this.topPos + 56, 50, 20).build();
		this.addRenderableWidget(button_trees);
		button_machine = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_machine"), e -> {
			int x = PalahelpblockScreen.this.x;
			int y = PalahelpblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PalahelpblockButtonMessage(2, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 95, this.topPos + 83, 60, 20).build();
		this.addRenderableWidget(button_machine);
		button_fluid = Button.builder(Component.translatable("gui.palamod.palahelpblock.button_fluid"), e -> {
			int x = PalahelpblockScreen.this.x;
			int y = PalahelpblockScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PalahelpblockButtonMessage(3, x, y, z));
				PalahelpblockButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 96, this.topPos + 112, 50, 20).build();
		this.addRenderableWidget(button_fluid);
		imagebutton_close_gui_nohover = new ImageButton(this.leftPos + 153, this.topPos + 4, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/close_gui_nohover.png"), ResourceLocation.parse("palamod:textures/screens/close_gui_hover.png")), e -> {
					int x = PalahelpblockScreen.this.x;
					int y = PalahelpblockScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpblockButtonMessage(4, x, y, z));
						PalahelpblockButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_close_gui_nohover);
		imagebutton_arrow_back_true_1 = new ImageButton(this.leftPos + 133, this.topPos + 4, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_back_true_1.png"), ResourceLocation.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
					int x = PalahelpblockScreen.this.x;
					int y = PalahelpblockScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpblockButtonMessage(5, x, y, z));
						PalahelpblockButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_back_true_1);
	}
}
package palamod.client.gui;

import palamod.world.inventory.PalahelporeMenu;

import palamod.network.PalahelporeButtonMessage;

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

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class PalahelporeScreen extends AbstractContainerScreen<PalahelporeMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_cross_no_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/palahelpore.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/amethyst_ingot.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/paladium_ingot.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/findium.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/titane_ingot.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/paladium_green_ingot.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/endium_ingot.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("palamod:textures/screens/left_gray_line.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("palamod:textures/screens/right_gray_line.png");

	public PalahelporeScreen(PalahelporeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 220;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 300, 220, 300, 220);
		guiGraphics.blit(IMAGE_1, this.leftPos + 9, this.topPos + 155, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + 10, this.topPos + 77, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 10, this.topPos + 99, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 10, this.topPos + 123, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_5, this.leftPos + 10, this.topPos + 56, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_6, this.leftPos + 10, this.topPos + 28, 0, 0, 0, 0, 0, 0);
		guiGraphics.blit(IMAGE_7, this.leftPos + -1, this.topPos + -1, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_8, this.leftPos + 99, this.topPos + -1, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_9, this.leftPos + 199, this.topPos + -1, 0, 0, 100, 24, 100, 24);
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
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_paladium_le_minerais_le_plus_pu").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 28, 81 + yOffset, -52480, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_tres_rare_sert_a_quelque_craft").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 27, 103 + yOffset, -205, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_resitanttres_bon_pour_ses_premi").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 28, 126 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_amthyste").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 27, 166 + yOffset, -6750055, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_paladium_vert_equivalent_en_pl").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 28, 59 + yOffset, -10027213, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_endium_le_materiau_ultime_obte").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 28, 27 + yOffset, -13434727, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_via_le_paladium_crusher_voir_m").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 28, 38 + yOffset, -13434727, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_tools").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 29, 136 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_assez_facilement").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 27, 177 + yOffset, -6750055, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpore.label_palahelp_ore").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 95, 4 + yOffset, -131587, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 236, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = PalahelporeScreen.this.x;
					int y = PalahelporeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelporeButtonMessage(0, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 255, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = PalahelporeScreen.this.x;
					int y = PalahelporeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelporeButtonMessage(1, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 278, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = PalahelporeScreen.this.x;
					int y = PalahelporeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelporeButtonMessage(2, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 2, x, y, z);
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
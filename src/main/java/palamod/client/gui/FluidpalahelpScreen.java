package palamod.client.gui;

import palamod.world.inventory.FluidpalahelpMenu;

import palamod.network.FluidpalahelpButtonMessage;

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

public class FluidpalahelpScreen extends AbstractContainerScreen<FluidpalahelpMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_home_pixel_adminshop;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/fluidpalahelp.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/6_fluid.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/7angel.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/left_gray_line.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/right_gray_line.png");

	public FluidpalahelpScreen(FluidpalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 200;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 200, 200, 200, 200);
		guiGraphics.blit(IMAGE_1, this.leftPos + 6, this.topPos + 37, 0, 0, 22, 21, 22, 21);
		guiGraphics.blit(IMAGE_2, this.leftPos + 3, this.topPos + 112, 0, 0, 21, 21, 21, 21);
		guiGraphics.blit(IMAGE_3, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_4, this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.fluidpalahelp.label_fluid").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 49, 7 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.fluidpalahelp.label_fake_water_un_type_deau_invisi").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 2, 63 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.fluidpalahelp.label_vous_fait_des_dgats_peut_peut").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 3, 73 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.fluidpalahelp.label_mpecher_la_legendary_stone_de_p").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 83 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.fluidpalahelp.label_angelique_water_type_deau_qui").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 3, 133 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.fluidpalahelp.label_soigne").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 3, 143 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.fluidpalahelp.label_an_enchantment_who_nullfy_dmg").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 94 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 178, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = FluidpalahelpScreen.this.x;
					int y = FluidpalahelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FluidpalahelpButtonMessage(0, x, y, z));
						FluidpalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 158, this.topPos + 4, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_back_true_1.png"), ResourceLocation.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
					int x = FluidpalahelpScreen.this.x;
					int y = FluidpalahelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FluidpalahelpButtonMessage(1, x, y, z));
						FluidpalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 139, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = FluidpalahelpScreen.this.x;
					int y = FluidpalahelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new FluidpalahelpButtonMessage(2, x, y, z));
						FluidpalahelpButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}
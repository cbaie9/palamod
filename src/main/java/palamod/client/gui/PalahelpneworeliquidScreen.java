package palamod.client.gui;

import palamod.world.inventory.PalahelpneworeliquidMenu;

import palamod.network.PalahelpneworeliquidButtonMessage;

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

public class PalahelpneworeliquidScreen extends AbstractContainerScreen<PalahelpneworeliquidMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_sommaire_btn;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/amethyst_ingot.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/titane_ingot.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/paladium_ingot.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/paladium_ore.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/paladium_green_ingot.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/endium_nugets_vfufu.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("palamod:textures/screens/7angel.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("palamod:textures/screens/6_fluid.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("palamod:textures/screens/amethyst_ore.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("palamod:textures/screens/titane_ore.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("palamod:textures/screens/paladium_green_ore.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("palamod:textures/screens/endium_nugget_ore.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("palamod:textures/screens/legend_power.png");

	public PalahelpneworeliquidScreen(PalahelpneworeliquidMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 318;
		this.imageHeight = 176;
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
		if (mouseX > leftPos + 15 && mouseX < leftPos + 90 && mouseY > topPos + 137 && mouseY < topPos + 164) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.palahelpneworeliquid.tooltip_the_ultimate_ore_craftable_tho"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 15 && mouseX < leftPos + 90 && mouseY > topPos + 20 && mouseY < topPos + 50) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.palahelpneworeliquid.tooltip_low_level_ore_easily_available"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 15 && mouseX < leftPos + 90 && mouseY > topPos + 50 && mouseY < topPos + 79) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.palahelpneworeliquid.tooltip_durable_a_very_good_start_for_f"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 15 && mouseX < leftPos + 90 && mouseY > topPos + 79 && mouseY < topPos + 108) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.palahelpneworeliquid.tooltip_the_most_powerful_minable_ore_t"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 15 && mouseX < leftPos + 90 && mouseY > topPos + 108 && mouseY < topPos + 137) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.palahelpneworeliquid.tooltip_equivalent_to_paladium_but_more"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 220 && mouseX < leftPos + 234 && mouseY > topPos + 93 && mouseY < topPos + 106) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.palahelpneworeliquid.tooltip_to_nullify_its_damage_you_can_u"), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -2, this.topPos + 0, 0, 0, 320, 180, 320, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + 22, this.topPos + 31, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + 18, this.topPos + 58, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 17, this.topPos + 88, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 38, this.topPos + 90, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_5, this.leftPos + 18, this.topPos + 119, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_6, this.leftPos + 19, this.topPos + 149, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_7, this.leftPos + 183, this.topPos + 34, 0, 0, 42, 43, 42, 43);
		guiGraphics.blit(IMAGE_8, this.leftPos + 182, this.topPos + 100, 0, 0, 44, 42, 44, 42);
		guiGraphics.blit(IMAGE_9, this.leftPos + 39, this.topPos + 30, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_10, this.leftPos + 37, this.topPos + 59, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_11, this.leftPos + 39, this.topPos + 118, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_12, this.leftPos + 40, this.topPos + 148, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_13, this.leftPos + 223, this.topPos + 96, 0, 0, 8, 8, 8, 8);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_amethyst"), 37, 19, -6750055, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_titane"), 45, 48, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_paladium"), 45, 77, -65536, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_green_paladium"), 16, 107, -16724992, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_endium"), 41, 135, -16777012, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_ores_and_materials"), 21, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_liquids"), 222, 11, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_fake_water"), 236, 112, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpneworeliquid.label_angelic_water"), 235, 46, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_sommaire_btn = new ImageButton(this.leftPos + 121, this.topPos + -1, 14, 18,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png"), ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png")), e -> {
					int x = PalahelpneworeliquidScreen.this.x;
					int y = PalahelpneworeliquidScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpneworeliquidButtonMessage(0, x, y, z));
						PalahelpneworeliquidButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_sommaire_btn);
	}
}
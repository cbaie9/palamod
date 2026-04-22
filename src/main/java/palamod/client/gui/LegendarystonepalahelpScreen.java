package palamod.client.gui;

import palamod.world.inventory.LegendarystonepalahelpMenu;

import palamod.network.LegendarystonepalahelpButtonMessage;

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

public class LegendarystonepalahelpScreen extends AbstractContainerScreen<LegendarystonepalahelpMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_arrow_adminshop;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/legendarystonepalahelp.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/legend_fortune.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/legend_invisibility.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/legend_jobs.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/legend_power.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/legend_tp.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/legend_random.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("palamod:textures/screens/left_gray_line.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("palamod:textures/screens/right_gray_line.png");

	public LegendarystonepalahelpScreen(LegendarystonepalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 220, 200, 220, 200);
		guiGraphics.blit(IMAGE_1, this.leftPos + 10, this.topPos + 50, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + 10, this.topPos + 74, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 10, this.topPos + 95, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 10, this.topPos + 116, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_5, this.leftPos + 10, this.topPos + 140, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_6, this.leftPos + 11, this.topPos + 167, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_7, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_8, this.leftPos + 88, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_9, this.leftPos + 119, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_legendary_stone_wiki"), 3, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_forturne_permet_de_vous_give"), 26, 54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_note_utilisable_une_fois_tous_l"), 3, 24, -16777012, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_invisible_vous_rend_invisible"), 26, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_jobs_vous_donne_de_lxp"), 25, 98, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_power_vous_permet_detre_prote"), 26, 119, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_contre_la_fake_water"), 14, 130, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_teleportation_vous_tp_aletorem"), 27, 144, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_sur_la_map"), 13, 157, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_random_vous_donne_une_des_5_pi"), 26, 173, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_au_dessus"), 12, 183, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_effect"), 27, 85, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 198, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = LegendarystonepalahelpScreen.this.x;
					int y = LegendarystonepalahelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LegendarystonepalahelpButtonMessage(0, x, y, z));
						LegendarystonepalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 164, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = LegendarystonepalahelpScreen.this.x;
					int y = LegendarystonepalahelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LegendarystonepalahelpButtonMessage(1, x, y, z));
						LegendarystonepalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 180, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = LegendarystonepalahelpScreen.this.x;
					int y = LegendarystonepalahelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new LegendarystonepalahelpButtonMessage(2, x, y, z));
						LegendarystonepalahelpButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}
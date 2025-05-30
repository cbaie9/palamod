package palamod.client.gui;

import palamod.world.inventory.PalahelporeMenu;

import palamod.network.PalahelporeButtonMessage;

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

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PalahelporeScreen extends AbstractContainerScreen<PalahelporeMenu> {
	private final static HashMap<String, Object> guistate = PalahelporeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_home_pixel_adminshop;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_cross_no_button;

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
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/palahelpore.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 300, 220, 300, 220);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/amethyst_ingot.png"), this.leftPos + 9, this.topPos + 155, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/paladium_ingot.png"), this.leftPos + 10, this.topPos + 77, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/findium.png"), this.leftPos + 10, this.topPos + 99, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/titane_ingot.png"), this.leftPos + 10, this.topPos + 123, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/paladium_green_ingot.png"), this.leftPos + 10, this.topPos + 56, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/endium_ingot.png"), this.leftPos + 10, this.topPos + 28, 0, 0, 0, 0, 0, 0);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + -1, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 99, this.topPos + -1, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 199, this.topPos + -1, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_paladium_le_minerais_le_plus_pu"), 28, 81, -52480, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_tres_rare_sert_a_quelque_craft"), 27, 103, -205, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_resitanttres_bon_pour_ses_premi"), 28, 126, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_amthyste"), 27, 166, -6750055, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_paladium_vert_equivalent_en_pl"), 28, 59, -10027213, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_endium_le_materiau_ultime_obte"), 28, 27, -13434727, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_via_le_paladium_crusher_voir_m"), 28, 38, -13434727, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_tools"), 29, 136, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_assez_facilement"), 27, 177, -6750055, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.palahelpore.label_palahelp_ore"), 95, 4, -131587, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 236, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new PalahelporeButtonMessage(0, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 255, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new PalahelporeButtonMessage(1, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 278, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new PalahelporeButtonMessage(2, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}

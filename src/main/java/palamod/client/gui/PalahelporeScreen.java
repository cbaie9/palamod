package palamod.client.gui;

import palamod.world.inventory.PalahelporeMenu;

import palamod.network.PalahelporeButtonMessage;

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

public class PalahelporeScreen extends AbstractContainerScreen<PalahelporeMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_cross_no_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/palahelpore.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/amethyst_ingot.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/paladium_ingot.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/findium.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/titane_ingot.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/paladium_green_ingot.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/endium_ingot.png");
	private static final Identifier IMAGE_7 = Identifier.parse("palamod:textures/screens/left_gray_line.png");
	private static final Identifier IMAGE_8 = Identifier.parse("palamod:textures/screens/mid_gray_line.png");
	private static final Identifier IMAGE_9 = Identifier.parse("palamod:textures/screens/right_gray_line.png");

	public PalahelporeScreen(PalahelporeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 300, 220);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 300, 220, 300, 220);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 9, this.topPos + 155, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 10, this.topPos + 77, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 10, this.topPos + 99, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 10, this.topPos + 123, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 10, this.topPos + 56, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 10, this.topPos + 28, 0, 0, 0, 0, 0, 0);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_7, this.leftPos + -1, this.topPos + -1, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_8, this.leftPos + 99, this.topPos + -1, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_9, this.leftPos + 199, this.topPos + -1, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_paladium_le_minerais_le_plus_pu"), 28, 81, -52480, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_tres_rare_sert_a_quelque_craft"), 27, 103, -205, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_resitanttres_bon_pour_ses_premi"), 28, 126, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_amthyste"), 27, 166, -6750055, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_paladium_vert_equivalent_en_pl"), 28, 59, -10027213, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_endium_le_materiau_ultime_obte"), 28, 27, -13434727, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_via_le_paladium_crusher_voir_m"), 28, 38, -13434727, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_tools"), 29, 136, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_assez_facilement"), 27, 177, -6750055, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpore.label_palahelp_ore"), 95, 4, -131587, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 236, this.topPos + 3, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/home_pixel_adminshop.png"), Identifier.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = PalahelporeScreen.this.x;
					int y = PalahelporeScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelporeButtonMessage(0, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 255, this.topPos + 3, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_adminshop.png"), Identifier.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = PalahelporeScreen.this.x;
					int y = PalahelporeScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelporeButtonMessage(1, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 278, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = PalahelporeScreen.this.x;
					int y = PalahelporeScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelporeButtonMessage(2, x, y, z));
						PalahelporeButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}
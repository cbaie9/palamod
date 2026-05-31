package palamod.client.gui;

import palamod.world.inventory.FluidpalahelpMenu;

import palamod.network.FluidpalahelpButtonMessage;

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

public class FluidpalahelpScreen extends AbstractContainerScreen<FluidpalahelpMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_home_pixel_adminshop;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/fluidpalahelp.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/6_fluid.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/7angel.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/left_gray_line.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/right_gray_line.png");

	public FluidpalahelpScreen(FluidpalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 200, 200);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 200, 200, 200, 200);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 6, this.topPos + 37, 0, 0, 22, 21, 22, 21);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 3, this.topPos + 112, 0, 0, 21, 21, 21, 21);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_fluid"), 49, 7, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_fake_water_un_type_deau_invisi"), 2, 63, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_vous_fait_des_dgats_peut_peut"), 3, 73, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_mpecher_la_legendary_stone_de_p"), 4, 83, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_angelique_water_type_deau_qui"), 3, 133, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_soigne"), 3, 143, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.fluidpalahelp.label_an_enchantment_who_nullfy_dmg"), 4, 94, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 178, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = FluidpalahelpScreen.this.x;
					int y = FluidpalahelpScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new FluidpalahelpButtonMessage(0, x, y, z));
						FluidpalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 158, this.topPos + 4, 17, 17,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_back_true_1.png"), Identifier.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
					int x = FluidpalahelpScreen.this.x;
					int y = FluidpalahelpScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new FluidpalahelpButtonMessage(1, x, y, z));
						FluidpalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 139, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/home_pixel_adminshop.png"), Identifier.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = FluidpalahelpScreen.this.x;
					int y = FluidpalahelpScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new FluidpalahelpButtonMessage(2, x, y, z));
						FluidpalahelpButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
	}
}
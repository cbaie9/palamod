package palamod.client.gui;

import palamod.world.inventory.GrinderguiMenu;

import palamod.procedures.*;

import palamod.network.GrinderguiButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class GrinderguiScreen extends AbstractContainerScreen<GrinderguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_help_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/grindergui_v4.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/btn-all_off.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/btn-blue_on.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/btn-red_on.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/btn-green_on.png");
	private static final Identifier SPRITE_0 = Identifier.parse("palamod:textures/screens/grinder_sprite_full.png");
	private static final Identifier SPRITE_1 = Identifier.parse("palamod:textures/screens/fire_furnace.png");
	private static final Identifier SPRITE_2 = Identifier.parse("palamod:textures/screens/arrow_right_furnace_sprite.png");
	private static final Identifier SPRITE_3 = Identifier.parse("palamod:textures/screens/arrow_right_furnace_sprite.png");

	public GrinderguiScreen(GrinderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 215, 163);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 215, 163, 215, 163);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 160, this.topPos + 63, 0, 0, 37, 7, 37, 7);
		if (LightbluegrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 190, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}
		if (LightredgrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 160, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}
		if (LightgreengrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 175, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 152, this.topPos + 9, Mth.clamp((int) ProgressbargrinderspritereturnProcedure.execute(world, x, y, z) * 51, 0, 2550), 0, 51, 50, 2601, 50);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_1, this.leftPos + 126, this.topPos + 25, Mth.clamp((int) ReturntimerinputgrinderProcedure.execute(world, x, y, z) * 16, 0, 224), 0, 16, 16, 240, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_2, this.leftPos + 49, this.topPos + 13, Mth.clamp((int) GrindergettimercraftProcedure.execute(world, x, y, z) * 22, 0, 484), 0, 22, 15, 506, 15);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_3, this.leftPos + 48, this.topPos + 60, Mth.clamp((int) GrindergettimerfusionProcedure.execute(world, x, y, z) * 22, 0, 484), 0, 22, 15, 506, 15);
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
		guiGraphics.text(this.font, Grindertrans1Procedure.execute(world, x, y, z), 144, 70, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_help_button = new ImageButton(this.leftPos + 193, this.topPos + 141, 16, 16, new WidgetSprites(Identifier.parse("palamod:textures/screens/help_button.png"), Identifier.parse("palamod:textures/screens/help_button_poi.png")), e -> {
			int x = GrinderguiScreen.this.x;
			int y = GrinderguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new GrinderguiButtonMessage(0, x, y, z));
				GrinderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_help_button);
	}
}
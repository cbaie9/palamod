package palamod.client.gui;

import palamod.world.inventory.FlowertotemguiMenu;

import palamod.procedures.GetstringtotemnumProcedure;
import palamod.procedures.GetspritetimerflowermachineProcedure;

import palamod.network.FlowertotemguiButtonMessage;

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

public class FlowertotemguiScreen extends AbstractContainerScreen<FlowertotemguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_close_gui_nohover;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/flowertotemgui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/arrow_right_full.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/bone_meal.png");
	private static final Identifier SPRITE_0 = Identifier.parse("palamod:textures/screens/pgbar_jobs.png");

	public FlowertotemguiScreen(FlowertotemguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 166);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 74, this.topPos + 36, 0, 0, 16, 14, 16, 14);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 26, this.topPos + 34, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 15, this.topPos + 69, Mth.clamp((int) GetspritetimerflowermachineProcedure.execute(world, x, y, z) * 145, 0, 14355), 0, 145, 10, 14500, 10);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.flowertotemgui.label_flower_totem"), 3, 3, -65536, false);
		guiGraphics.text(this.font, GetstringtotemnumProcedure.execute(world, x, y, z), 69, 70, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_close_gui_nohover = new ImageButton(this.leftPos + 154, this.topPos + 5, 17, 17,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/close_gui_nohover.png"), Identifier.parse("palamod:textures/screens/close_gui_hover.png")), e -> {
					int x = FlowertotemguiScreen.this.x;
					int y = FlowertotemguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new FlowertotemguiButtonMessage(0, x, y, z));
						FlowertotemguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_close_gui_nohover);
	}
}
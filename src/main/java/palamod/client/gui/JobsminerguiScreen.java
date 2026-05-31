package palamod.client.gui;

import palamod.world.inventory.JobsminerguiMenu;

import palamod.procedures.JobsminergetxpprogressbarProcedure;
import palamod.procedures.GetxpminertextProcedure;
import palamod.procedures.GetxpminerProcedure;
import palamod.procedures.GetlevelminerProcedure;

import palamod.network.JobsminerguiButtonMessage;

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

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.platform.InputConstants;

public class JobsminerguiScreen extends AbstractContainerScreen<JobsminerguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_button_gray;
	private ImageButton imagebutton_cross_no_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/jobsminergui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/left_gray_line.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/right_gray_line.png");
	private static final Identifier SPRITE_0 = Identifier.parse("palamod:textures/screens/pgbar_jobs.png");

	public JobsminerguiScreen(JobsminerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 80);
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
		if (mouseX > leftPos + 14 && mouseX < leftPos + 159 && mouseY > topPos + 26 && mouseY < topPos + 36) {
			String hoverText = GetxpminertextProcedure.execute(entity);
			if (hoverText != null) {
				guiGraphics.setComponentTooltipForNextFrame(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
		}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 176, 80, 176, 80);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 76, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 14, this.topPos + 26, Mth.clamp((int) JobsminergetxpprogressbarProcedure.execute(entity) * 145, 0, 14355), 0, 145, 10, 14500, 10);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsminergui.label_jobs_miner"), 9, 7, -1, false);
		guiGraphics.text(this.font, GetxpminerProcedure.execute(entity), 13, 38, -1, false);
		guiGraphics.text(this.font, GetlevelminerProcedure.execute(entity), 5, 63, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_button_gray = new ImageButton(this.leftPos + 104, this.topPos + 53, 48, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/craft_button_v2.png"), Identifier.parse("palamod:textures/screens/craft_button_hover_v3.png")), e -> {
					int x = JobsminerguiScreen.this.x;
					int y = JobsminerguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsminerguiButtonMessage(0, x, y, z));
						JobsminerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_button_gray);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 5, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = JobsminerguiScreen.this.x;
					int y = JobsminerguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsminerguiButtonMessage(1, x, y, z));
						JobsminerguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
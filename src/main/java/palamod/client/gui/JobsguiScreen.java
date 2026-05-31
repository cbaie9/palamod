package palamod.client.gui;

import palamod.world.inventory.JobsguiMenu;

import palamod.procedures.*;

import palamod.network.JobsguiButtonMessage;

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

public class JobsguiScreen extends AbstractContainerScreen<JobsguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_screen_beta_template_jobs;
	private ImageButton imagebutton_screen_beta2_template_jobs;
	private ImageButton imagebutton_screen_beta2_template_jobs1;
	private ImageButton imagebutton_screen_beta2_template_jobs2;
	private ImageButton imagebutton_cross_no_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/jobsgui.png");
	private static final Identifier SPRITE_0 = Identifier.parse("palamod:textures/screens/sprite_last_unlocked_miner.png");

	public JobsguiScreen(JobsguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 350, 200);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 350, 200, 350, 200);
		if (IsgameclientsideProcedure.execute()) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 10, this.topPos + 149, Mth.clamp((int) LastunlockedgetspriteProcedure.execute(entity) * 16, 0, 400), 0, 16, 16, 416, 16);
		}
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsgui.label_jobs"), 160, 5, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsgui.label_last_unlocked_items"), 8, 120, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsgui.label_miner"), 48, 45, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsgui.label_farmer"), 123, 45, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsgui.label_le_hunter"), 207, 45, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsgui.label_alchimist"), 269, 45, -1, false);
		guiGraphics.text(this.font, GetlevelminerProcedure.execute(entity), 44, 99, -1, false);
		guiGraphics.text(this.font, GetlevelfarmerProcedure.execute(entity), 119, 99, -1, false);
		guiGraphics.text(this.font, GetlevelhunterProcedure.execute(entity), 201, 99, -1, false);
		guiGraphics.text(this.font, GetlevelalchiProcedure.execute(entity), 272, 99, -1, false);
		if (IsgameclientsideProcedure.execute())
			guiGraphics.text(this.font, LastunlockedminerProcedure.execute(entity), 8, 134, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsgui.label_beta"), 8, 5, -3407872, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_screen_beta_template_jobs = new ImageButton(this.leftPos + 119, this.topPos + 57, 40, 40,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/screen_beta3_famer_jobs.png"), Identifier.parse("palamod:textures/screens/screen_beta3_farm2.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsguiButtonMessage(0, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta_template_jobs);
		imagebutton_screen_beta2_template_jobs = new ImageButton(this.leftPos + 41, this.topPos + 57, 40, 40,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/screen_beta3_jobs_miner.png"), Identifier.parse("palamod:textures/screens/screen_beta3_jobs_miner2.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsguiButtonMessage(1, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs);
		imagebutton_screen_beta2_template_jobs1 = new ImageButton(this.leftPos + 201, this.topPos + 57, 40, 40,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/screen_beta3_jobs_hunter.png"), Identifier.parse("palamod:textures/screens/screen_beta3_jobs_hunter2.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsguiButtonMessage(2, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs1);
		imagebutton_screen_beta2_template_jobs2 = new ImageButton(this.leftPos + 272, this.topPos + 57, 40, 40,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/screen_beta3_jobs_alchi.png"), Identifier.parse("palamod:textures/screens/screen_beta3_jobs_alchi2.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsguiButtonMessage(3, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs2);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 328, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsguiButtonMessage(4, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
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
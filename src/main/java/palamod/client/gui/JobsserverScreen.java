package palamod.client.gui;

import palamod.world.inventory.JobsserverMenu;

import palamod.network.JobsserverButtonMessage;

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

public class JobsserverScreen extends AbstractContainerScreen<JobsserverMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_screen_beta_template_jobs;
	private ImageButton imagebutton_screen_beta2_template_jobs;
	private ImageButton imagebutton_screen_beta2_template_jobs1;
	private ImageButton imagebutton_screen_beta2_template_jobs2;
	private ImageButton imagebutton_cross_no_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/jobs_gui_server.png");

	public JobsserverScreen(JobsserverMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 350, 100);
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
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 350, 100, 350, 100);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsserver.label_jobs"), 161, 5, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsserver.label_miner"), 46, 24, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsserver.label_farmer"), 124, 24, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsserver.label_le_hunter"), 205, 24, -1, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.jobsserver.label_alchimist"), 268, 24, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_screen_beta_template_jobs = new ImageButton(this.leftPos + 118, this.topPos + 38, 40, 40,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/screen_beta3_famer_jobs.png"), Identifier.parse("palamod:textures/screens/screen_beta3_farm2.png")), e -> {
					int x = JobsserverScreen.this.x;
					int y = JobsserverScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsserverButtonMessage(0, x, y, z));
						JobsserverButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta_template_jobs);
		imagebutton_screen_beta2_template_jobs = new ImageButton(this.leftPos + 40, this.topPos + 38, 40, 40,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/screen_beta3_jobs_miner.png"), Identifier.parse("palamod:textures/screens/screen_beta3_jobs_miner2.png")), e -> {
					int x = JobsserverScreen.this.x;
					int y = JobsserverScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsserverButtonMessage(1, x, y, z));
						JobsserverButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs);
		imagebutton_screen_beta2_template_jobs1 = new ImageButton(this.leftPos + 201, this.topPos + 38, 40, 40,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/screen_beta3_jobs_hunter.png"), Identifier.parse("palamod:textures/screens/screen_beta3_jobs_hunter2.png")), e -> {
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs1);
		imagebutton_screen_beta2_template_jobs2 = new ImageButton(this.leftPos + 272, this.topPos + 38, 40, 40,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/screen_beta3_jobs_alchi.png"), Identifier.parse("palamod:textures/screens/screen_beta3_jobs_alchi2.png")), e -> {
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs2);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 327, this.topPos + 6, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = JobsserverScreen.this.x;
					int y = JobsserverScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new JobsserverButtonMessage(4, x, y, z));
						JobsserverButtonMessage.handleButtonAction(entity, 4, x, y, z);
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
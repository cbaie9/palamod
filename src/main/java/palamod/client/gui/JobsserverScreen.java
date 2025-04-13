package palamod.client.gui;

import palamod.world.inventory.JobsserverMenu;

import palamod.network.JobsserverButtonMessage;

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

public class JobsserverScreen extends AbstractContainerScreen<JobsserverMenu> {
	private final static HashMap<String, Object> guistate = JobsserverMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_screen_beta_template_jobs;
	ImageButton imagebutton_screen_beta2_template_jobs;
	ImageButton imagebutton_screen_beta2_template_jobs1;
	ImageButton imagebutton_screen_beta2_template_jobs2;
	ImageButton imagebutton_cross_no_button;

	public JobsserverScreen(JobsserverMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 350;
		this.imageHeight = 100;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/jobs_gui_server.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 350, 100, 350, 100);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsserver.label_jobs"), 161, 5, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsserver.label_miner"), 46, 24, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsserver.label_farmer"), 124, 24, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsserver.label_le_hunter"), 205, 24, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsserver.label_alchimist"), 268, 24, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_screen_beta_template_jobs = new ImageButton(this.leftPos + 118, this.topPos + 38, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_famer_jobs.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_farm2.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsserverButtonMessage(0, x, y, z));
						JobsserverButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_screen_beta_template_jobs", imagebutton_screen_beta_template_jobs);
		this.addRenderableWidget(imagebutton_screen_beta_template_jobs);
		imagebutton_screen_beta2_template_jobs = new ImageButton(this.leftPos + 40, this.topPos + 38, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_miner.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_miner2.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsserverButtonMessage(1, x, y, z));
						JobsserverButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_screen_beta2_template_jobs", imagebutton_screen_beta2_template_jobs);
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs);
		imagebutton_screen_beta2_template_jobs1 = new ImageButton(this.leftPos + 201, this.topPos + 38, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_hunter.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_hunter2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_screen_beta2_template_jobs1", imagebutton_screen_beta2_template_jobs1);
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs1);
		imagebutton_screen_beta2_template_jobs2 = new ImageButton(this.leftPos + 272, this.topPos + 38, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_alchi.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_alchi2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_screen_beta2_template_jobs2", imagebutton_screen_beta2_template_jobs2);
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs2);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 327, this.topPos + 6, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsserverButtonMessage(4, x, y, z));
						JobsserverButtonMessage.handleButtonAction(entity, 4, x, y, z);
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

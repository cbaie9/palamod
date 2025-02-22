package palamod.client.gui;

import palamod.world.inventory.JobsguiMenu;

import palamod.procedures.GetlevelminerProcedure;
import palamod.procedures.GetlevelhunterProcedure;
import palamod.procedures.GetlevelfarmerProcedure;
import palamod.procedures.GetlevelalchiProcedure;

import palamod.network.JobsguiButtonMessage;

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

public class JobsguiScreen extends AbstractContainerScreen<JobsguiMenu> {
	private final static HashMap<String, Object> guistate = JobsguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_screen_beta_template_jobs;
	ImageButton imagebutton_screen_beta2_template_jobs;
	ImageButton imagebutton_screen_beta2_template_jobs1;
	ImageButton imagebutton_screen_beta2_template_jobs2;
	ImageButton imagebutton_cross_no_button;

	public JobsguiScreen(JobsguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 350;
		this.imageHeight = 200;
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

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/jobs_main_menu_bar20.png"), this.leftPos + 52, this.topPos + 101, 0, 0, 24, 8, 24, 8);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/jobs_main_menu_bar20.png"), this.leftPos + 130, this.topPos + 101, 0, 0, 24, 8, 24, 8);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/jobs_main_menu_bar20.png"), this.leftPos + 209, this.topPos + 101, 0, 0, 24, 8, 24, 8);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/jobs_main_menu_bar20.png"), this.leftPos + 279, this.topPos + 101, 0, 0, 24, 8, 24, 8);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/jobsgui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 350, 200, 350, 200);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 100, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 200, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 250, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsgui.label_jobs"), 134, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsgui.label_last_unlocked_items"), 5, 121, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsgui.label_miner"), 48, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsgui.label_farmer"), 123, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsgui.label_le_hunter"), 207, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsgui.label_alchimist"), 269, 45, -12829636, false);
		guiGraphics.drawString(this.font,

				GetlevelminerProcedure.execute(world, entity), 44, 99, -12829636, false);
		guiGraphics.drawString(this.font,

				GetlevelfarmerProcedure.execute(world, entity), 119, 99, -12829636, false);
		guiGraphics.drawString(this.font,

				GetlevelhunterProcedure.execute(world, entity), 201, 99, -12829636, false);
		guiGraphics.drawString(this.font,

				GetlevelalchiProcedure.execute(world, entity), 272, 99, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsgui.label_work_in_progress_will_be_updat"), 8, 151, -13434676, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_screen_beta_template_jobs = new ImageButton(this.leftPos + 119, this.topPos + 57, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_famer_jobs.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_farm2.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsguiButtonMessage(0, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_screen_beta_template_jobs", imagebutton_screen_beta_template_jobs);
		this.addRenderableWidget(imagebutton_screen_beta_template_jobs);
		imagebutton_screen_beta2_template_jobs = new ImageButton(this.leftPos + 41, this.topPos + 57, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_miner.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_miner2.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsguiButtonMessage(1, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_screen_beta2_template_jobs", imagebutton_screen_beta2_template_jobs);
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs);
		imagebutton_screen_beta2_template_jobs1 = new ImageButton(this.leftPos + 201, this.topPos + 57, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_hunter.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_hunter2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_screen_beta2_template_jobs1", imagebutton_screen_beta2_template_jobs1);
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs1);
		imagebutton_screen_beta2_template_jobs2 = new ImageButton(this.leftPos + 272, this.topPos + 57, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_alchi.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_alchi2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_screen_beta2_template_jobs2", imagebutton_screen_beta2_template_jobs2);
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs2);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 328, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsguiButtonMessage(4, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
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

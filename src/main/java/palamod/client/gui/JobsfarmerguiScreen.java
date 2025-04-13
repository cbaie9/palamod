package palamod.client.gui;

import palamod.world.inventory.JobsfarmerguiMenu;

import palamod.procedures.JobsfarmergetxpprogressbarProcedure;
import palamod.procedures.GetxpfarmertextProcedure;
import palamod.procedures.GetxpfarmerProcedure;

import palamod.network.JobsfarmerguiButtonMessage;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class JobsfarmerguiScreen extends AbstractContainerScreen<JobsfarmerguiMenu> {
	private final static HashMap<String, Object> guistate = JobsfarmerguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_button_gray;
	ImageButton imagebutton_help_button;
	ImageButton imagebutton_cross_no_button;

	public JobsfarmerguiScreen(JobsfarmerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 80;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 14 && mouseX < leftPos + 159 && mouseY > topPos + 26 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.literal(GetxpfarmertextProcedure.execute(world, entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/jobsminergui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 80, 176, 80);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 76, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/pgbar_jobs.png"), this.leftPos + 14, this.topPos + 26, Mth.clamp((int) JobsfarmergetxpprogressbarProcedure.execute(world, entity) * 145, 0, 14355), 0, 145, 10, 14500, 10);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsfarmergui.label_jobs_miner"), 9, 7, -1, false);
		guiGraphics.drawString(this.font,

				GetxpfarmerProcedure.execute(world, entity), 13, 38, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_button_gray = new ImageButton(this.leftPos + 104, this.topPos + 53, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/craft_button_v2.png"), ResourceLocation.parse("palamod:textures/screens/craft_button_hover_v3.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmerguiButtonMessage(0, x, y, z));
						JobsfarmerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_gray", imagebutton_button_gray);
		this.addRenderableWidget(imagebutton_button_gray);
		imagebutton_help_button = new ImageButton(this.leftPos + 14, this.topPos + 53, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_helpjobs_v1.png"), ResourceLocation.parse("palamod:textures/screens/button_helpjobs_poi_v1.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_help_button", imagebutton_help_button);
		this.addRenderableWidget(imagebutton_help_button);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmerguiButtonMessage(2, x, y, z));
						JobsfarmerguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
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

package palamod.client.gui;

import palamod.world.inventory.JobsguiMenu;

import palamod.procedures.*;

import palamod.network.JobsguiButtonMessage;

import palamod.init.PalamodModScreens;

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

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

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
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/jobsgui.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("palamod:textures/screens/sprite_last_unlocked_miner.png");

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
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 350, 200, 350, 200);
		if (IsgameclientsideProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(SPRITE_0, this.leftPos + 10, this.topPos + 149, Mth.clamp((int) LastunlockedgetspriteProcedure.execute(entity) * 16, 0, 400), 0, 16, 16, 416, 16);
		}
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
		int heightPadding = 0;
		int yOffset = 0;
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.jobsgui.label_jobs").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 160, 5 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.jobsgui.label_last_unlocked_items").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 8, 120 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.jobsgui.label_miner").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 48, 45 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.jobsgui.label_farmer").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 123, 45 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.jobsgui.label_le_hunter").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 207, 45 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.jobsgui.label_alchimist").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 269, 45 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetlevelminerProcedure.execute(world, entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 44, 99 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetlevelfarmerProcedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 119, 99 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetlevelhunterProcedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 201, 99 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetlevelalchiProcedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 272, 99 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		if (IsgameclientsideProcedure.execute(world, x, y, z))
			yOffset = 0;
		for (Component actualComponent : Arrays.stream(LastunlockedminerProcedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 8, 134 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.jobsgui.label_beta").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 8, 5 + yOffset, -3407872, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_screen_beta_template_jobs = new ImageButton(this.leftPos + 119, this.topPos + 57, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_famer_jobs.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_farm2.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new JobsguiButtonMessage(0, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta_template_jobs);
		imagebutton_screen_beta2_template_jobs = new ImageButton(this.leftPos + 41, this.topPos + 57, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_miner.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_miner2.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new JobsguiButtonMessage(1, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs);
		imagebutton_screen_beta2_template_jobs1 = new ImageButton(this.leftPos + 201, this.topPos + 57, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_hunter.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_hunter2.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new JobsguiButtonMessage(2, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs1);
		imagebutton_screen_beta2_template_jobs2 = new ImageButton(this.leftPos + 272, this.topPos + 57, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_alchi.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_alchi2.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new JobsguiButtonMessage(3, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta2_template_jobs2);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 328, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = JobsguiScreen.this.x;
					int y = JobsguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new JobsguiButtonMessage(4, x, y, z));
						JobsguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}
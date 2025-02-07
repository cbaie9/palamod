package palamod.client.gui;

import palamod.world.inventory.JobsfarmercraftguiMenu;

import palamod.procedures.JobsgetlvlrequiredProcedure;
import palamod.procedures.JobsgetinfotextProcedure;
import palamod.procedures.Jobsgetinfotext5Procedure;
import palamod.procedures.Jobsgetinfotext4Procedure;
import palamod.procedures.Jobsgetinfotext3Procedure;
import palamod.procedures.Jobsgetinfotext2Procedure;
import palamod.procedures.JobsgetdurabilityProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.JobsfarmercraftguiButtonMessage;

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

public class JobsfarmercraftguiScreen extends AbstractContainerScreen<JobsfarmercraftguiMenu> {
	private final static HashMap<String, Object> guistate = JobsfarmercraftguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_endium_pickaxe;
	ImageButton imagebutton_potg_of_1;
	ImageButton imagebutton_amethyste_exca;
	ImageButton imagebutton_titane_excavator;
	ImageButton imagebutton_paladium_excavator;
	ImageButton imagebutton_magical_tool16;
	ImageButton imagebutton_voidstone;
	ImageButton imagebutton_obsidian_pickaxe;
	ImageButton imagebutton_boom_obsi;
	ImageButton imagebutton_big_obsi;
	ImageButton imagebutton_spike_obsi;
	ImageButton imagebutton_spike_obsi_1;
	ImageButton imagebutton_spike_obsi_2;
	ImageButton imagebutton_spike_obsi_3;
	ImageButton imagebutton_spike_obsi_4;
	ImageButton imagebutton_spike_obsi_5;
	ImageButton imagebutton_spike_obsi_6;
	ImageButton imagebutton_lava_obsi;
	ImageButton imagebutton_fake_obsi;
	ImageButton imagebutton_slime_obsi;
	ImageButton imagebutton_poison_obsi;
	ImageButton imagebutton_beta_block;

	public JobsfarmercraftguiScreen(JobsfarmercraftguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 210;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 277 && mouseX < leftPos + 293 && mouseY > topPos + 4 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.literal(ClosetheguitransProcedure.execute()), mouseX, mouseY);
		if (mouseX > leftPos + 10 && mouseX < leftPos + 26 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_endium_pickaxe"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 45 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_pickaxe_of_the_gods"), mouseX, mouseY);
		if (mouseX > leftPos + 48 && mouseX < leftPos + 64 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_amethyst_excavator"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 83 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_titane_excavator"), mouseX, mouseY);
		if (mouseX > leftPos + 86 && mouseX < leftPos + 102 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_paladium_excavator"), mouseX, mouseY);
		if (mouseX > leftPos + 105 && mouseX < leftPos + 121 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_magical_tool"), mouseX, mouseY);
		if (mouseX > leftPos + 124 && mouseX < leftPos + 140 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_voidstone"), mouseX, mouseY);
		if (mouseX > leftPos + 143 && mouseX < leftPos + 159 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_obsidian_pickaxe"), mouseX, mouseY);
		if (mouseX > leftPos + 162 && mouseX < leftPos + 178 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_obsidian_tnt"), mouseX, mouseY);
		if (mouseX > leftPos + 10 && mouseX < leftPos + 26 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_compressed_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 29 && mouseX < leftPos + 45 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_mega_boom_tnt_soon"), mouseX, mouseY);
		if (mouseX > leftPos + 48 && mouseX < leftPos + 64 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_wodden_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 83 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_iron_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 86 && mouseX < leftPos + 102 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_golden_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 105 && mouseX < leftPos + 121 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_diamond_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 124 && mouseX < leftPos + 140 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_amethyst_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 143 && mouseX < leftPos + 159 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_titane_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 162 && mouseX < leftPos + 178 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_paladium_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 10 && mouseX < leftPos + 26 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_lava_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 29 && mouseX < leftPos + 45 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_fake_water_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 48 && mouseX < leftPos + 64 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_slime_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 83 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsfarmercraftgui.tooltip_poison_obsidian"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/jobsminercraftgui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 300, 210, 300, 210);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 100, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 190, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 200, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_hor.png"), this.leftPos + 281, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_hor.png"), this.leftPos + 265, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_hor.png"), this.leftPos + 249, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_hor.png"), this.leftPos + 233, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_hor.png"), this.leftPos + 217, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_hor.png"), this.leftPos + 201, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 191, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 175, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_hor.png"), this.leftPos + 185, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 159, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 143, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 127, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_hor.png"), this.leftPos + 171, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 113, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/arrow_right20.png"), this.leftPos + 241, this.topPos + 56, 0, 0, 16, 14, 16, 14);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsfarmercraftgui.label_jobs_miner_crafts"), 106, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsfarmercraftgui.label_information"), 174, 115, -1, false);
		guiGraphics.drawString(this.font,

				JobsgetinfotextProcedure.execute(entity), 175, 128, -1, false);
		guiGraphics.drawString(this.font,

				JobsgetlvlrequiredProcedure.execute(entity), 177, 193, -16738048, false);
		guiGraphics.drawString(this.font,

				Jobsgetinfotext2Procedure.execute(entity), 175, 139, -1, false);
		guiGraphics.drawString(this.font,

				Jobsgetinfotext3Procedure.execute(entity), 175, 149, -1, false);
		guiGraphics.drawString(this.font,

				JobsgetdurabilityProcedure.execute(entity), 177, 183, -16737895, false);
		guiGraphics.drawString(this.font,

				Jobsgetinfotext4Procedure.execute(entity), 175, 158, -1, false);
		guiGraphics.drawString(this.font,

				Jobsgetinfotext5Procedure.execute(entity), 175, 167, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 277, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(0, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_endium_pickaxe = new ImageButton(this.leftPos + 10, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/amethyst_hoe.png"), ResourceLocation.parse("palamod:textures/screens/amethyst_hoe_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(1, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_endium_pickaxe", imagebutton_endium_pickaxe);
		this.addRenderableWidget(imagebutton_endium_pickaxe);
		imagebutton_potg_of_1 = new ImageButton(this.leftPos + 30, this.topPos + 28, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/titane_radius_hoe.png"), ResourceLocation.parse("palamod:textures/screens/titane_hoe_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(2, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_potg_of_1", imagebutton_potg_of_1);
		this.addRenderableWidget(imagebutton_potg_of_1);
		imagebutton_amethyste_exca = new ImageButton(this.leftPos + 48, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/paladium_radius_hoe.png"), ResourceLocation.parse("palamod:textures/screens/paladium_hoe_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(3, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_amethyste_exca", imagebutton_amethyste_exca);
		this.addRenderableWidget(imagebutton_amethyste_exca);
		imagebutton_titane_excavator = new ImageButton(this.leftPos + 67, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/endium_radius_hoe.png"), ResourceLocation.parse("palamod:textures/screens/endium_radius_hoe_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(4, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_titane_excavator", imagebutton_titane_excavator);
		this.addRenderableWidget(imagebutton_titane_excavator);
		imagebutton_paladium_excavator = new ImageButton(this.leftPos + 86, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/green_paladium_radius_hoe.png"), ResourceLocation.parse("palamod:textures/screens/paladium_hoe_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(5, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_paladium_excavator", imagebutton_paladium_excavator);
		this.addRenderableWidget(imagebutton_paladium_excavator);
		imagebutton_magical_tool16 = new ImageButton(this.leftPos + 105, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/seedplanter_amethyst.png"), ResourceLocation.parse("palamod:textures/screens/seedplanter_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(6, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_magical_tool16", imagebutton_magical_tool16);
		this.addRenderableWidget(imagebutton_magical_tool16);
		imagebutton_voidstone = new ImageButton(this.leftPos + 124, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/seedplanter_titane.png"), ResourceLocation.parse("palamod:textures/screens/seedplanter_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(7, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_voidstone", imagebutton_voidstone);
		this.addRenderableWidget(imagebutton_voidstone);
		imagebutton_obsidian_pickaxe = new ImageButton(this.leftPos + 143, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/seedplanter_paladium.png"), ResourceLocation.parse("palamod:textures/screens/seedplanter_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(8, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_obsidian_pickaxe", imagebutton_obsidian_pickaxe);
		this.addRenderableWidget(imagebutton_obsidian_pickaxe);
		imagebutton_boom_obsi = new ImageButton(this.leftPos + 162, this.topPos + 29, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/seedplanter_green_paladium.png"), ResourceLocation.parse("palamod:textures/screens/seedplanter_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(9, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_boom_obsi", imagebutton_boom_obsi);
		this.addRenderableWidget(imagebutton_boom_obsi);
		imagebutton_big_obsi = new ImageButton(this.leftPos + 10, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/seedplanter_endium.png"), ResourceLocation.parse("palamod:textures/screens/seedplanter_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(10, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_big_obsi", imagebutton_big_obsi);
		this.addRenderableWidget(imagebutton_big_obsi);
		imagebutton_spike_obsi = new ImageButton(this.leftPos + 48, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/amethyst_backpack.png"), ResourceLocation.parse("palamod:textures/screens/backpack_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(11, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_spike_obsi", imagebutton_spike_obsi);
		this.addRenderableWidget(imagebutton_spike_obsi);
		imagebutton_spike_obsi_1 = new ImageButton(this.leftPos + 67, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/titan_backpack.png"), ResourceLocation.parse("palamod:textures/screens/backpack_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(12, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_spike_obsi_1", imagebutton_spike_obsi_1);
		this.addRenderableWidget(imagebutton_spike_obsi_1);
		imagebutton_spike_obsi_2 = new ImageButton(this.leftPos + 86, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/paladium_backpack.png"), ResourceLocation.parse("palamod:textures/screens/backpack_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(13, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_spike_obsi_2", imagebutton_spike_obsi_2);
		this.addRenderableWidget(imagebutton_spike_obsi_2);
		imagebutton_spike_obsi_3 = new ImageButton(this.leftPos + 105, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/endium_backpack.png"), ResourceLocation.parse("palamod:textures/screens/backpack_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(14, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_spike_obsi_3", imagebutton_spike_obsi_3);
		this.addRenderableWidget(imagebutton_spike_obsi_3);
		imagebutton_spike_obsi_4 = new ImageButton(this.leftPos + 124, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/colored_grass_seed.png"), ResourceLocation.parse("palamod:textures/screens/colored_seed_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(15, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 15, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_spike_obsi_4", imagebutton_spike_obsi_4);
		this.addRenderableWidget(imagebutton_spike_obsi_4);
		imagebutton_spike_obsi_5 = new ImageButton(this.leftPos + 143, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/root_tree_foliage.png"), ResourceLocation.parse("palamod:textures/screens/block_white.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(16, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 16, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_spike_obsi_5", imagebutton_spike_obsi_5);
		this.addRenderableWidget(imagebutton_spike_obsi_5);
		imagebutton_spike_obsi_6 = new ImageButton(this.leftPos + 162, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/crusher_front.png"), ResourceLocation.parse("palamod:textures/screens/block_white.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(17, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 17, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_spike_obsi_6", imagebutton_spike_obsi_6);
		this.addRenderableWidget(imagebutton_spike_obsi_6);
		imagebutton_lava_obsi = new ImageButton(this.leftPos + 10, this.topPos + 67, 16, 16, new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/totem.png"), ResourceLocation.parse("palamod:textures/screens/block_white.png")), e -> {
			if (true) {
				PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(18, x, y, z));
				JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_lava_obsi", imagebutton_lava_obsi);
		this.addRenderableWidget(imagebutton_lava_obsi);
		imagebutton_fake_obsi = new ImageButton(this.leftPos + 29, this.topPos + 67, 16, 16, new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/beta_block.png"), ResourceLocation.parse("palamod:textures/screens/block_white.png")),
				e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(19, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 19, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_fake_obsi", imagebutton_fake_obsi);
		this.addRenderableWidget(imagebutton_fake_obsi);
		imagebutton_slime_obsi = new ImageButton(this.leftPos + 48, this.topPos + 67, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/endium_chestplate.png"), ResourceLocation.parse("palamod:textures/screens/chestplate_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(20, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 20, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_slime_obsi", imagebutton_slime_obsi);
		this.addRenderableWidget(imagebutton_slime_obsi);
		imagebutton_poison_obsi = new ImageButton(this.leftPos + 67, this.topPos + 67, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/endium_axe.png"), ResourceLocation.parse("palamod:textures/screens/endium_axe_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(21, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 21, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_poison_obsi", imagebutton_poison_obsi);
		this.addRenderableWidget(imagebutton_poison_obsi);
		imagebutton_beta_block = new ImageButton(this.leftPos + 29, this.topPos + 48, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/elevator_block.png"), ResourceLocation.parse("palamod:textures/screens/block_white.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new JobsfarmercraftguiButtonMessage(22, x, y, z));
						JobsfarmercraftguiButtonMessage.handleButtonAction(entity, 22, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_beta_block", imagebutton_beta_block);
		this.addRenderableWidget(imagebutton_beta_block);
	}
}

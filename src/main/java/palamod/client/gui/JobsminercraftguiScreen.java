package palamod.client.gui;

import palamod.world.inventory.JobsminercraftguiMenu;

import palamod.procedures.JobsgetlvlrequiredProcedure;
import palamod.procedures.JobsgetinfotextProcedure;
import palamod.procedures.Jobsgetinfotext5Procedure;
import palamod.procedures.Jobsgetinfotext4Procedure;
import palamod.procedures.Jobsgetinfotext3Procedure;
import palamod.procedures.Jobsgetinfotext2Procedure;
import palamod.procedures.JobsgetdurabilityProcedure;

import palamod.network.JobsminercraftguiButtonMessage;

import palamod.PalamodMod;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class JobsminercraftguiScreen extends AbstractContainerScreen<JobsminercraftguiMenu> {
	private final static HashMap<String, Object> guistate = JobsminercraftguiMenu.guistate;
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
	ImageButton imagebutton_cave_block_vfufu;
	ImageButton imagebutton_big_tnt_side;
	ImageButton imagebutton_effect_tnt_side;
	ImageButton imagebutton_wither_tnt_side;
	ImageButton imagebutton_sponge_tnt_side;
	ImageButton imagebutton_sponge;
	ImageButton imagebutton_endium_tnt_side;
	ImageButton imagebutton_beta_block;
	ImageButton imagebutton_beta_block1;
	ImageButton imagebutton_beta_block2;
	ImageButton imagebutton_beta_block3;
	ImageButton imagebutton_beta_block4;
	ImageButton imagebutton_cobblebreaker_front;
	ImageButton imagebutton_cobblebreaker_amethyst_upgrade;
	ImageButton imagebutton_cobblebreaker_titane_upgrade;
	ImageButton imagebutton_cobblebreaker_paladium_upgrade;
	ImageButton imagebutton_voidstone_minage;
	ImageButton imagebutton_moula_stone;
	ImageButton imagebutton_sealed_xp_bottle;
	ImageButton imagebutton_forge_front_off;
	ImageButton imagebutton_beta_block5;

	public JobsminercraftguiScreen(JobsminercraftguiMenu container, Inventory inventory, Component text) {
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
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 277 && mouseX < leftPos + 293 && mouseY > topPos + 4 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_close_the_gui"), mouseX, mouseY);
		if (mouseX > leftPos + 10 && mouseX < leftPos + 26 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_endium_pickaxe"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 45 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_pickaxe_of_the_gods"), mouseX, mouseY);
		if (mouseX > leftPos + 48 && mouseX < leftPos + 64 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_amethyst_excavator"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 83 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_titane_excavator"), mouseX, mouseY);
		if (mouseX > leftPos + 86 && mouseX < leftPos + 102 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_paladium_excavator"), mouseX, mouseY);
		if (mouseX > leftPos + 105 && mouseX < leftPos + 121 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_magical_tool"), mouseX, mouseY);
		if (mouseX > leftPos + 124 && mouseX < leftPos + 140 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_voidstone"), mouseX, mouseY);
		if (mouseX > leftPos + 143 && mouseX < leftPos + 159 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_obsidian_pickaxe"), mouseX, mouseY);
		if (mouseX > leftPos + 162 && mouseX < leftPos + 178 && mouseY > topPos + 29 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_obsidian_tnt"), mouseX, mouseY);
		if (mouseX > leftPos + 10 && mouseX < leftPos + 26 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_compressed_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 29 && mouseX < leftPos + 45 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_mega_boom_tnt_soon"), mouseX, mouseY);
		if (mouseX > leftPos + 48 && mouseX < leftPos + 64 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_wodden_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 83 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_iron_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 86 && mouseX < leftPos + 102 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_golden_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 105 && mouseX < leftPos + 121 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_diamond_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 124 && mouseX < leftPos + 140 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_amethyst_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 143 && mouseX < leftPos + 159 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_titane_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 162 && mouseX < leftPos + 178 && mouseY > topPos + 48 && mouseY < topPos + 64)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_paladium_spike_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 10 && mouseX < leftPos + 26 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_lava_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 29 && mouseX < leftPos + 45 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_fake_water_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 48 && mouseX < leftPos + 64 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_slime_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 83 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_poison_obsidian"), mouseX, mouseY);
		if (mouseX > leftPos + 86 && mouseX < leftPos + 102 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_cave_block"), mouseX, mouseY);
		if (mouseX > leftPos + 105 && mouseX < leftPos + 121 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_compact_tnt"), mouseX, mouseY);
		if (mouseX > leftPos + 124 && mouseX < leftPos + 140 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_magic_tnt"), mouseX, mouseY);
		if (mouseX > leftPos + 143 && mouseX < leftPos + 159 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_wither_tnt"), mouseX, mouseY);
		if (mouseX > leftPos + 162 && mouseX < leftPos + 178 && mouseY > topPos + 67 && mouseY < topPos + 83)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_sponge_tnt"), mouseX, mouseY);
		if (mouseX > leftPos + 10 && mouseX < leftPos + 26 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_compressed_sponge"), mouseX, mouseY);
		if (mouseX > leftPos + 29 && mouseX < leftPos + 45 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_endium_tnt"), mouseX, mouseY);
		if (mouseX > leftPos + 48 && mouseX < leftPos + 64 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_amethyst_builder_wand"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 83 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_titane_builder_wand"), mouseX, mouseY);
		if (mouseX > leftPos + 86 && mouseX < leftPos + 102 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_paladium_builder_wand"), mouseX, mouseY);
		if (mouseX > leftPos + 105 && mouseX < leftPos + 121 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_endium_builder_wand"), mouseX, mouseY);
		if (mouseX > leftPos + 124 && mouseX < leftPos + 140 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_cobblebreaker"), mouseX, mouseY);
		if (mouseX > leftPos + 143 && mouseX < leftPos + 159 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_cobblebreaker_amethyst_upgrade"), mouseX, mouseY);
		if (mouseX > leftPos + 162 && mouseX < leftPos + 178 && mouseY > topPos + 86 && mouseY < topPos + 102)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_cobblebreakers_titane_upgrade"), mouseX, mouseY);
		if (mouseX > leftPos + 11 && mouseX < leftPos + 26 && mouseY > topPos + 105 && mouseY < topPos + 121)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_cobblebreakers_paladium_upgrade"), mouseX, mouseY);
		if (mouseX > leftPos + 30 && mouseX < leftPos + 45 && mouseY > topPos + 105 && mouseY < topPos + 121)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_minage_voidstone"), mouseX, mouseY);
		if (mouseX > leftPos + 48 && mouseX < leftPos + 64 && mouseY > topPos + 105 && mouseY < topPos + 121)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_dollard_stone"), mouseX, mouseY);
		if (mouseX > leftPos + 67 && mouseX < leftPos + 83 && mouseY > topPos + 105 && mouseY < topPos + 121)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_sealed_xp_bottle"), mouseX, mouseY);
		if (mouseX > leftPos + 86 && mouseX < leftPos + 102 && mouseY > topPos + 105 && mouseY < topPos + 121)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_palaforge"), mouseX, mouseY);
		if (mouseX > leftPos + 105 && mouseX < leftPos + 121 && mouseY > topPos + 105 && mouseY < topPos + 121)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.jobsminercraftgui.tooltip_autocrafter"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/jobsminercraftgui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 300, 210, 300, 210);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 100, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 190, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 200, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_hor.png"), this.leftPos + 281, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_hor.png"), this.leftPos + 265, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_hor.png"), this.leftPos + 249, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_hor.png"), this.leftPos + 233, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_hor.png"), this.leftPos + 217, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_hor.png"), this.leftPos + 201, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 191, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 175, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_hor.png"), this.leftPos + 185, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 159, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 143, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 127, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_hor.png"), this.leftPos + 171, this.topPos + 112, 0, 0, 16, 3, 16, 3);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/line_ver.png"), this.leftPos + 171, this.topPos + 113, 0, 0, 3, 16, 3, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right20.png"), this.leftPos + 241, this.topPos + 56, 0, 0, 16, 14, 16, 14);

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsminercraftgui.label_jobs_miner_crafts"), 106, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsminercraftgui.label_information"), 174, 115, -1, false);
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
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 277, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(0, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_endium_pickaxe = new ImageButton(this.leftPos + 10, this.topPos + 29, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_endium_pickaxe.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(1, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_endium_pickaxe", imagebutton_endium_pickaxe);
		this.addRenderableWidget(imagebutton_endium_pickaxe);
		imagebutton_potg_of_1 = new ImageButton(this.leftPos + 30, this.topPos + 28, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_potg_of_1.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_potg_of_1", imagebutton_potg_of_1);
		this.addRenderableWidget(imagebutton_potg_of_1);
		imagebutton_amethyste_exca = new ImageButton(this.leftPos + 48, this.topPos + 29, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_amethyste_exca.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(3, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_amethyste_exca", imagebutton_amethyste_exca);
		this.addRenderableWidget(imagebutton_amethyste_exca);
		imagebutton_titane_excavator = new ImageButton(this.leftPos + 67, this.topPos + 29, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_titane_excavator.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(4, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_titane_excavator", imagebutton_titane_excavator);
		this.addRenderableWidget(imagebutton_titane_excavator);
		imagebutton_paladium_excavator = new ImageButton(this.leftPos + 86, this.topPos + 29, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_paladium_excavator.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(5, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_paladium_excavator", imagebutton_paladium_excavator);
		this.addRenderableWidget(imagebutton_paladium_excavator);
		imagebutton_magical_tool16 = new ImageButton(this.leftPos + 105, this.topPos + 29, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_magical_tool16.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(6, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_magical_tool16", imagebutton_magical_tool16);
		this.addRenderableWidget(imagebutton_magical_tool16);
		imagebutton_voidstone = new ImageButton(this.leftPos + 124, this.topPos + 29, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_voidstone.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(7, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_voidstone", imagebutton_voidstone);
		this.addRenderableWidget(imagebutton_voidstone);
		imagebutton_obsidian_pickaxe = new ImageButton(this.leftPos + 143, this.topPos + 29, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_obsidian_pickaxe.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(8, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_obsidian_pickaxe", imagebutton_obsidian_pickaxe);
		this.addRenderableWidget(imagebutton_obsidian_pickaxe);
		imagebutton_boom_obsi = new ImageButton(this.leftPos + 162, this.topPos + 29, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_boom_obsi.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(9, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		});
		guistate.put("button:imagebutton_boom_obsi", imagebutton_boom_obsi);
		this.addRenderableWidget(imagebutton_boom_obsi);
		imagebutton_big_obsi = new ImageButton(this.leftPos + 10, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_big_obsi.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(10, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		});
		guistate.put("button:imagebutton_big_obsi", imagebutton_big_obsi);
		this.addRenderableWidget(imagebutton_big_obsi);
		imagebutton_spike_obsi = new ImageButton(this.leftPos + 48, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_spike_obsi.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(11, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		});
		guistate.put("button:imagebutton_spike_obsi", imagebutton_spike_obsi);
		this.addRenderableWidget(imagebutton_spike_obsi);
		imagebutton_spike_obsi_1 = new ImageButton(this.leftPos + 67, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_spike_obsi_1.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(12, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		});
		guistate.put("button:imagebutton_spike_obsi_1", imagebutton_spike_obsi_1);
		this.addRenderableWidget(imagebutton_spike_obsi_1);
		imagebutton_spike_obsi_2 = new ImageButton(this.leftPos + 86, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_spike_obsi_2.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(13, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 13, x, y, z);
			}
		});
		guistate.put("button:imagebutton_spike_obsi_2", imagebutton_spike_obsi_2);
		this.addRenderableWidget(imagebutton_spike_obsi_2);
		imagebutton_spike_obsi_3 = new ImageButton(this.leftPos + 105, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_spike_obsi_3.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(14, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 14, x, y, z);
			}
		});
		guistate.put("button:imagebutton_spike_obsi_3", imagebutton_spike_obsi_3);
		this.addRenderableWidget(imagebutton_spike_obsi_3);
		imagebutton_spike_obsi_4 = new ImageButton(this.leftPos + 124, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_spike_obsi_4.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(15, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 15, x, y, z);
			}
		});
		guistate.put("button:imagebutton_spike_obsi_4", imagebutton_spike_obsi_4);
		this.addRenderableWidget(imagebutton_spike_obsi_4);
		imagebutton_spike_obsi_5 = new ImageButton(this.leftPos + 143, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_spike_obsi_5.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(16, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 16, x, y, z);
			}
		});
		guistate.put("button:imagebutton_spike_obsi_5", imagebutton_spike_obsi_5);
		this.addRenderableWidget(imagebutton_spike_obsi_5);
		imagebutton_spike_obsi_6 = new ImageButton(this.leftPos + 162, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_spike_obsi_6.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(17, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 17, x, y, z);
			}
		});
		guistate.put("button:imagebutton_spike_obsi_6", imagebutton_spike_obsi_6);
		this.addRenderableWidget(imagebutton_spike_obsi_6);
		imagebutton_lava_obsi = new ImageButton(this.leftPos + 10, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_lava_obsi.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(18, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 18, x, y, z);
			}
		});
		guistate.put("button:imagebutton_lava_obsi", imagebutton_lava_obsi);
		this.addRenderableWidget(imagebutton_lava_obsi);
		imagebutton_fake_obsi = new ImageButton(this.leftPos + 29, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_fake_obsi.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(19, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 19, x, y, z);
			}
		});
		guistate.put("button:imagebutton_fake_obsi", imagebutton_fake_obsi);
		this.addRenderableWidget(imagebutton_fake_obsi);
		imagebutton_slime_obsi = new ImageButton(this.leftPos + 48, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_slime_obsi.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminercraftguiButtonMessage(20, x, y, z));
				JobsminercraftguiButtonMessage.handleButtonAction(entity, 20, x, y, z);
			}
		});
		guistate.put("button:imagebutton_slime_obsi", imagebutton_slime_obsi);
		this.addRenderableWidget(imagebutton_slime_obsi);
		imagebutton_poison_obsi = new ImageButton(this.leftPos + 67, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_poison_obsi.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_poison_obsi", imagebutton_poison_obsi);
		this.addRenderableWidget(imagebutton_poison_obsi);
		imagebutton_cave_block_vfufu = new ImageButton(this.leftPos + 86, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cave_block_vfufu.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_cave_block_vfufu", imagebutton_cave_block_vfufu);
		this.addRenderableWidget(imagebutton_cave_block_vfufu);
		imagebutton_big_tnt_side = new ImageButton(this.leftPos + 105, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_big_tnt_side.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_big_tnt_side", imagebutton_big_tnt_side);
		this.addRenderableWidget(imagebutton_big_tnt_side);
		imagebutton_effect_tnt_side = new ImageButton(this.leftPos + 124, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_effect_tnt_side.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_effect_tnt_side", imagebutton_effect_tnt_side);
		this.addRenderableWidget(imagebutton_effect_tnt_side);
		imagebutton_wither_tnt_side = new ImageButton(this.leftPos + 143, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_wither_tnt_side.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_wither_tnt_side", imagebutton_wither_tnt_side);
		this.addRenderableWidget(imagebutton_wither_tnt_side);
		imagebutton_sponge_tnt_side = new ImageButton(this.leftPos + 162, this.topPos + 67, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_sponge_tnt_side.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_sponge_tnt_side", imagebutton_sponge_tnt_side);
		this.addRenderableWidget(imagebutton_sponge_tnt_side);
		imagebutton_sponge = new ImageButton(this.leftPos + 10, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_sponge.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_sponge", imagebutton_sponge);
		this.addRenderableWidget(imagebutton_sponge);
		imagebutton_endium_tnt_side = new ImageButton(this.leftPos + 29, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_endium_tnt_side.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_endium_tnt_side", imagebutton_endium_tnt_side);
		this.addRenderableWidget(imagebutton_endium_tnt_side);
		imagebutton_beta_block = new ImageButton(this.leftPos + 29, this.topPos + 48, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_beta_block.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_beta_block", imagebutton_beta_block);
		this.addRenderableWidget(imagebutton_beta_block);
		imagebutton_beta_block1 = new ImageButton(this.leftPos + 48, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_beta_block1.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_beta_block1", imagebutton_beta_block1);
		this.addRenderableWidget(imagebutton_beta_block1);
		imagebutton_beta_block2 = new ImageButton(this.leftPos + 67, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_beta_block2.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_beta_block2", imagebutton_beta_block2);
		this.addRenderableWidget(imagebutton_beta_block2);
		imagebutton_beta_block3 = new ImageButton(this.leftPos + 86, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_beta_block3.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_beta_block3", imagebutton_beta_block3);
		this.addRenderableWidget(imagebutton_beta_block3);
		imagebutton_beta_block4 = new ImageButton(this.leftPos + 105, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_beta_block4.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_beta_block4", imagebutton_beta_block4);
		this.addRenderableWidget(imagebutton_beta_block4);
		imagebutton_cobblebreaker_front = new ImageButton(this.leftPos + 124, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cobblebreaker_front.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_cobblebreaker_front", imagebutton_cobblebreaker_front);
		this.addRenderableWidget(imagebutton_cobblebreaker_front);
		imagebutton_cobblebreaker_amethyst_upgrade = new ImageButton(this.leftPos + 143, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cobblebreaker_amethyst_upgrade.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_cobblebreaker_amethyst_upgrade", imagebutton_cobblebreaker_amethyst_upgrade);
		this.addRenderableWidget(imagebutton_cobblebreaker_amethyst_upgrade);
		imagebutton_cobblebreaker_titane_upgrade = new ImageButton(this.leftPos + 162, this.topPos + 86, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cobblebreaker_titane_upgrade.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_cobblebreaker_titane_upgrade", imagebutton_cobblebreaker_titane_upgrade);
		this.addRenderableWidget(imagebutton_cobblebreaker_titane_upgrade);
		imagebutton_cobblebreaker_paladium_upgrade = new ImageButton(this.leftPos + 10, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cobblebreaker_paladium_upgrade.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_cobblebreaker_paladium_upgrade", imagebutton_cobblebreaker_paladium_upgrade);
		this.addRenderableWidget(imagebutton_cobblebreaker_paladium_upgrade);
		imagebutton_voidstone_minage = new ImageButton(this.leftPos + 29, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_voidstone_minage.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_voidstone_minage", imagebutton_voidstone_minage);
		this.addRenderableWidget(imagebutton_voidstone_minage);
		imagebutton_moula_stone = new ImageButton(this.leftPos + 47, this.topPos + 105, 18, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_moula_stone.png"), 18, 32, e -> {
		});
		guistate.put("button:imagebutton_moula_stone", imagebutton_moula_stone);
		this.addRenderableWidget(imagebutton_moula_stone);
		imagebutton_sealed_xp_bottle = new ImageButton(this.leftPos + 70, this.topPos + 106, 11, 15, 0, 0, 15, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_sealed_xp_bottle.png"), 11, 30, e -> {
		});
		guistate.put("button:imagebutton_sealed_xp_bottle", imagebutton_sealed_xp_bottle);
		this.addRenderableWidget(imagebutton_sealed_xp_bottle);
		imagebutton_forge_front_off = new ImageButton(this.leftPos + 86, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_forge_front_off.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_forge_front_off", imagebutton_forge_front_off);
		this.addRenderableWidget(imagebutton_forge_front_off);
		imagebutton_beta_block5 = new ImageButton(this.leftPos + 105, this.topPos + 105, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_beta_block5.png"), 16, 32, e -> {
		});
		guistate.put("button:imagebutton_beta_block5", imagebutton_beta_block5);
		this.addRenderableWidget(imagebutton_beta_block5);
	}
}

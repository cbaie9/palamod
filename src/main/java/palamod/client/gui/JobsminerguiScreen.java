package palamod.client.gui;

import palamod.world.inventory.JobsminerguiMenu;

import palamod.procedures.Progressbarjobsminer9Procedure;
import palamod.procedures.Progressbarjobsminer99Procedure;
import palamod.procedures.Progressbarjobsminer98Procedure;
import palamod.procedures.Progressbarjobsminer97Procedure;
import palamod.procedures.Progressbarjobsminer96Procedure;
import palamod.procedures.Progressbarjobsminer95Procedure;
import palamod.procedures.Progressbarjobsminer94Procedure;
import palamod.procedures.Progressbarjobsminer93Procedure;
import palamod.procedures.Progressbarjobsminer92Procedure;
import palamod.procedures.Progressbarjobsminer91Procedure;
import palamod.procedures.Progressbarjobsminer90Procedure;
import palamod.procedures.Progressbarjobsminer8Procedure;
import palamod.procedures.Progressbarjobsminer89Procedure;
import palamod.procedures.Progressbarjobsminer88Procedure;
import palamod.procedures.Progressbarjobsminer87Procedure;
import palamod.procedures.Progressbarjobsminer86Procedure;
import palamod.procedures.Progressbarjobsminer85Procedure;
import palamod.procedures.Progressbarjobsminer84Procedure;
import palamod.procedures.Progressbarjobsminer82Procedure;
import palamod.procedures.Progressbarjobsminer81Procedure;
import palamod.procedures.Progressbarjobsminer80Procedure;
import palamod.procedures.Progressbarjobsminer7Procedure;
import palamod.procedures.Progressbarjobsminer79Procedure;
import palamod.procedures.Progressbarjobsminer78Procedure;
import palamod.procedures.Progressbarjobsminer77Procedure;
import palamod.procedures.Progressbarjobsminer76Procedure;
import palamod.procedures.Progressbarjobsminer75Procedure;
import palamod.procedures.Progressbarjobsminer74Procedure;
import palamod.procedures.Progressbarjobsminer73Procedure;
import palamod.procedures.Progressbarjobsminer72Procedure;
import palamod.procedures.Progressbarjobsminer71Procedure;
import palamod.procedures.Progressbarjobsminer70Procedure;
import palamod.procedures.Progressbarjobsminer6Procedure;
import palamod.procedures.Progressbarjobsminer69Procedure;
import palamod.procedures.Progressbarjobsminer68Procedure;
import palamod.procedures.Progressbarjobsminer67Procedure;
import palamod.procedures.Progressbarjobsminer66Procedure;
import palamod.procedures.Progressbarjobsminer65Procedure;
import palamod.procedures.Progressbarjobsminer64Procedure;
import palamod.procedures.Progressbarjobsminer63Procedure;
import palamod.procedures.Progressbarjobsminer62Procedure;
import palamod.procedures.Progressbarjobsminer61Procedure;
import palamod.procedures.Progressbarjobsminer60Procedure;
import palamod.procedures.Progressbarjobsminer5Procedure;
import palamod.procedures.Progressbarjobsminer59Procedure;
import palamod.procedures.Progressbarjobsminer58Procedure;
import palamod.procedures.Progressbarjobsminer57Procedure;
import palamod.procedures.Progressbarjobsminer56Procedure;
import palamod.procedures.Progressbarjobsminer55Procedure;
import palamod.procedures.Progressbarjobsminer54Procedure;
import palamod.procedures.Progressbarjobsminer53Procedure;
import palamod.procedures.Progressbarjobsminer52Procedure;
import palamod.procedures.Progressbarjobsminer51Procedure;
import palamod.procedures.Progressbarjobsminer50Procedure;
import palamod.procedures.Progressbarjobsminer4Procedure;
import palamod.procedures.Progressbarjobsminer49Procedure;
import palamod.procedures.Progressbarjobsminer48Procedure;
import palamod.procedures.Progressbarjobsminer47Procedure;
import palamod.procedures.Progressbarjobsminer46Procedure;
import palamod.procedures.Progressbarjobsminer45Procedure;
import palamod.procedures.Progressbarjobsminer44Procedure;
import palamod.procedures.Progressbarjobsminer43Procedure;
import palamod.procedures.Progressbarjobsminer42Procedure;
import palamod.procedures.Progressbarjobsminer41Procedure;
import palamod.procedures.Progressbarjobsminer40Procedure;
import palamod.procedures.Progressbarjobsminer3Procedure;
import palamod.procedures.Progressbarjobsminer39Procedure;
import palamod.procedures.Progressbarjobsminer38Procedure;
import palamod.procedures.Progressbarjobsminer37Procedure;
import palamod.procedures.Progressbarjobsminer36Procedure;
import palamod.procedures.Progressbarjobsminer34Procedure;
import palamod.procedures.Progressbarjobsminer33Procedure;
import palamod.procedures.Progressbarjobsminer32Procedure;
import palamod.procedures.Progressbarjobsminer31Procedure;
import palamod.procedures.Progressbarjobsminer30Procedure;
import palamod.procedures.Progressbarjobsminer2Procedure;
import palamod.procedures.Progressbarjobsminer29Procedure;
import palamod.procedures.Progressbarjobsminer28Procedure;
import palamod.procedures.Progressbarjobsminer27Procedure;
import palamod.procedures.Progressbarjobsminer26Procedure;
import palamod.procedures.Progressbarjobsminer25Procedure;
import palamod.procedures.Progressbarjobsminer24Procedure;
import palamod.procedures.Progressbarjobsminer23Procedure;
import palamod.procedures.Progressbarjobsminer22Procedure;
import palamod.procedures.Progressbarjobsminer21Procedure;
import palamod.procedures.Progressbarjobsminer20Procedure;
import palamod.procedures.Progressbarjobsminer1Procedure;
import palamod.procedures.Progressbarjobsminer19Procedure;
import palamod.procedures.Progressbarjobsminer18Procedure;
import palamod.procedures.Progressbarjobsminer17Procedure;
import palamod.procedures.Progressbarjobsminer16Procedure;
import palamod.procedures.Progressbarjobsminer15Procedure;
import palamod.procedures.Progressbarjobsminer14Procedure;
import palamod.procedures.Progressbarjobsminer13Procedure;
import palamod.procedures.Progressbarjobsminer12Procedure;
import palamod.procedures.Progressbarjobsminer11Procedure;
import palamod.procedures.Progressbarjobsminer10Procedure;
import palamod.procedures.Progressbarjobsminer100Procedure;
import palamod.procedures.GetxpminertextProcedure;
import palamod.procedures.GetxpminerProcedure;

import palamod.network.JobsminerguiButtonMessage;

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

public class JobsminerguiScreen extends AbstractContainerScreen<JobsminerguiMenu> {
	private final static HashMap<String, Object> guistate = JobsminerguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_button_gray;
	ImageButton imagebutton_help_button;
	ImageButton imagebutton_cross_no_button;

	public JobsminerguiScreen(JobsminerguiMenu container, Inventory inventory, Component text) {
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
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 14 && mouseX < leftPos + 159 && mouseY > topPos + 26 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.literal(GetxpminertextProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/jobsminergui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 80, 176, 80);

		if (Progressbarjobsminer1Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs_v1empty.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 76, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		if (Progressbarjobsminer2Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs1.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer3Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs2.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer4Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs3.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer5Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs4.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer6Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs5.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer7Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs6.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer8Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs7.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer9Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs8.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer10Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs9.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer11Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs10.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer12Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs11.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer13Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs12.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer14Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs13.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer15Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs14.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer16Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs15.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer17Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs16.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer18Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs17.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer19Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs18.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer20Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs19.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer21Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs20.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer22Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs21.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer23Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs22.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer24Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs23.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer25Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs24.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer26Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs25.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer27Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs26.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer28Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs27.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer29Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs28.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer30Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs29.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer31Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs30.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer32Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs31.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer33Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs32.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer34Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs33.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer55Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs34.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer36Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs35.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer37Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs36.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer38Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs37.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer39Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs38.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer40Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs39.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer41Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs40.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer42Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs41.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer43Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs42.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer44Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs43.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer45Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs44.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer46Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs45.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer47Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs46.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer48Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs47.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer49Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs48.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer50Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs49.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer51Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs50.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer52Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs51.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer53Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs52.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer54Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs53.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer55Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs54.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer56Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs55.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer57Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs56.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer58Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs57.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer59Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs58.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer60Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs59.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer61Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs60.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer62Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs61.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer63Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs62.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer64Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs63.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer65Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs64.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer66Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs65.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer67Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs66.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer68Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs67.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer69Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs68.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer70Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs69.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer71Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs70.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer72Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs71.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer73Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs72.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer74Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs73.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer75Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs74.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer76Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs75.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer77Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs76.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer78Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs77.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer79Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs78.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer80Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs79.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer81Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs80.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer82Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs81.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer84Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs83.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer85Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs84.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer86Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs85.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer87Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs86.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer88Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs87.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer89Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs88.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer90Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs89.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer91Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs90.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer92Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs91.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer93Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs92.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer94Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs93.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer95Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs94.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer96Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs95.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer97Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs96.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer98Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs97.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer99Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs98.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
		}
		if (Progressbarjobsminer100Procedure.execute(entity)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs99.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);
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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsminergui.label_jobs_miner"), 9, 7, -1, false);
		guiGraphics.drawString(this.font,

				GetxpminerProcedure.execute(entity), 13, 38, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_button_gray = new ImageButton(this.leftPos + 104, this.topPos + 53, 48, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_button_gray.png"), 48, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminerguiButtonMessage(0, x, y, z));
				JobsminerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_button_gray", imagebutton_button_gray);
		this.addRenderableWidget(imagebutton_button_gray);
		imagebutton_help_button = new ImageButton(this.leftPos + 14, this.topPos + 53, 48, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_help_button.png"), 48, 32, e -> {
		});
		guistate.put("button:imagebutton_help_button", imagebutton_help_button);
		this.addRenderableWidget(imagebutton_help_button);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminerguiButtonMessage(2, x, y, z));
				JobsminerguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}

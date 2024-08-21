package palamod.client.gui;

import palamod.world.inventory.GrinderguiMenu;

import palamod.procedures.Progressbargrindergnum9Procedure;
import palamod.procedures.Progressbargrindergnum8Procedure;
import palamod.procedures.Progressbargrindergnum7Procedure;
import palamod.procedures.Progressbargrindergnum6Procedure;
import palamod.procedures.Progressbargrindergnum5Procedure;
import palamod.procedures.Progressbargrindergnum50Procedure;
import palamod.procedures.Progressbargrindergnum4Procedure;
import palamod.procedures.Progressbargrindergnum49Procedure;
import palamod.procedures.Progressbargrindergnum48Procedure;
import palamod.procedures.Progressbargrindergnum47Procedure;
import palamod.procedures.Progressbargrindergnum46Procedure;
import palamod.procedures.Progressbargrindergnum45Procedure;
import palamod.procedures.Progressbargrindergnum44Procedure;
import palamod.procedures.Progressbargrindergnum43Procedure;
import palamod.procedures.Progressbargrindergnum42Procedure;
import palamod.procedures.Progressbargrindergnum41Procedure;
import palamod.procedures.Progressbargrindergnum40Procedure;
import palamod.procedures.Progressbargrindergnum3Procedure;
import palamod.procedures.Progressbargrindergnum39Procedure;
import palamod.procedures.Progressbargrindergnum38Procedure;
import palamod.procedures.Progressbargrindergnum37Procedure;
import palamod.procedures.Progressbargrindergnum36Procedure;
import palamod.procedures.Progressbargrindergnum35Procedure;
import palamod.procedures.Progressbargrindergnum34Procedure;
import palamod.procedures.Progressbargrindergnum33Procedure;
import palamod.procedures.Progressbargrindergnum32Procedure;
import palamod.procedures.Progressbargrindergnum31Procedure;
import palamod.procedures.Progressbargrindergnum30Procedure;
import palamod.procedures.Progressbargrindergnum2Procedure;
import palamod.procedures.Progressbargrindergnum29Procedure;
import palamod.procedures.Progressbargrindergnum28Procedure;
import palamod.procedures.Progressbargrindergnum27Procedure;
import palamod.procedures.Progressbargrindergnum26Procedure;
import palamod.procedures.Progressbargrindergnum25Procedure;
import palamod.procedures.Progressbargrindergnum24Procedure;
import palamod.procedures.Progressbargrindergnum23Procedure;
import palamod.procedures.Progressbargrindergnum22Procedure;
import palamod.procedures.Progressbargrindergnum21Procedure;
import palamod.procedures.Progressbargrindergnum20Procedure;
import palamod.procedures.Progressbargrindergnum1Procedure;
import palamod.procedures.Progressbargrindergnum19Procedure;
import palamod.procedures.Progressbargrindergnum18Procedure;
import palamod.procedures.Progressbargrindergnum17Procedure;
import palamod.procedures.Progressbargrindergnum16Procedure;
import palamod.procedures.Progressbargrindergnum15Procedure;
import palamod.procedures.Progressbargrindergnum14Procedure;
import palamod.procedures.Progressbargrindergnum13Procedure;
import palamod.procedures.Progressbargrindergnum12Procedure;
import palamod.procedures.Progressbargrindergnum11Procedure;
import palamod.procedures.Progressbargrindergnum10Procedure;
import palamod.procedures.Progressbargrindergnum0Procedure;
import palamod.procedures.LightredgrinderonProcedure;
import palamod.procedures.LightgreengrinderonProcedure;
import palamod.procedures.LightbluegrinderonProcedure;
import palamod.procedures.Grindertrans1Procedure;
import palamod.procedures.Grindersubprocessarrowsplit9Procedure;
import palamod.procedures.Grindersubprocessarrowsplit8Procedure;
import palamod.procedures.Grindersubprocessarrowsplit7Procedure;
import palamod.procedures.Grindersubprocessarrowsplit6Procedure;
import palamod.procedures.Grindersubprocessarrowsplit5Procedure;
import palamod.procedures.Grindersubprocessarrowsplit4Procedure;
import palamod.procedures.Grindersubprocessarrowsplit3Procedure;
import palamod.procedures.Grindersubprocessarrowsplit2Procedure;
import palamod.procedures.Grindersubprocessarrowsplit1Procedure;
import palamod.procedures.Grindersubprocessarrowsplit10Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn4Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn3Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn2Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn1Procedure;
import palamod.procedures.Grindersubprocessarrowinsertn0Procedure;
import palamod.procedures.Grinderguiarrow2n9Procedure;
import palamod.procedures.Grinderguiarrow2n8Procedure;
import palamod.procedures.Grinderguiarrow2n7Procedure;
import palamod.procedures.Grinderguiarrow2n5Procedure;
import palamod.procedures.Grinderguiarrow2n4Procedure;
import palamod.procedures.Grinderguiarrow2n3Procedure;
import palamod.procedures.Grinderguiarrow2n2Procedure;
import palamod.procedures.Grinderguiarrow2n1Procedure;
import palamod.procedures.Grinderguiarrow2n10Procedure;
import palamod.procedures.Crushersubprocessv2n6Procedure;

import palamod.network.GrinderguiButtonMessage;

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

public class GrinderguiScreen extends AbstractContainerScreen<GrinderguiMenu> {
	private final static HashMap<String, Object> guistate = GrinderguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_help_button;

	public GrinderguiScreen(GrinderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 215;
		this.imageHeight = 163;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grindergui_v4.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 215, 163, 215, 163);

		if (Grindersubprocessarrowinsertn0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arr0.png"), this.leftPos + 121, this.topPos + 23, 0, 0, 32, 16, 32, 16);
		}
		if (Grindersubprocessarrowinsertn1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arr1.png"), this.leftPos + 121, this.topPos + 23, 0, 0, 32, 16, 32, 16);
		}
		if (Grindersubprocessarrowinsertn2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arr2.png"), this.leftPos + 121, this.topPos + 23, 0, 0, 32, 16, 32, 16);
		}
		if (Grindersubprocessarrowinsertn3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arr3.png"), this.leftPos + 121, this.topPos + 23, 0, 0, 32, 16, 32, 16);
		}
		if (Grindersubprocessarrowinsertn4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arr4.png"), this.leftPos + 121, this.topPos + 23, 0, 0, 32, 16, 32, 16);
		}

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right01.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);

		if (Grinderguiarrow2n1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right03.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Grinderguiarrow2n2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right05.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Grinderguiarrow2n3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right07.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Grinderguiarrow2n4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right09.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Grinderguiarrow2n5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right11.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Crushersubprocessv2n6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right13.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Grinderguiarrow2n7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right15.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Grinderguiarrow2n8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right17.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Grinderguiarrow2n9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right19.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}
		if (Grinderguiarrow2n10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_right20.png"), this.leftPos + 53, this.topPos + 12, 0, 0, 16, 14, 16, 14);
		}

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_1red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);

		if (Grindersubprocessarrowsplit1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_3red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_5red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_7red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_9red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_11red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_13red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_15red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_17red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_18red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}
		if (Grindersubprocessarrowsplit10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_19red_new.png"), this.leftPos + 50, this.topPos + 60, 0, 0, 24, 10, 24, 10);
		}

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/btn-all_off.png"), this.leftPos + 160, this.topPos + 63, 0, 0, 37, 7, 37, 7);

		if (LightbluegrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/btn-blue_on.png"), this.leftPos + 190, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}
		if (LightredgrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/btn-red_on.png"), this.leftPos + 160, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}
		if (LightgreengrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/btn-green_on.png"), this.leftPos + 175, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}
		if (Progressbargrindergnum0Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00000.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum1Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00001.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum2Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00002.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum3Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00003.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum4Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00004.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum5Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00005.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum6Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00006.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum7Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00007.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum8Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00008.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum9Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00009.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum10Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00010.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum11Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00011.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum12Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00012.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum13Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00013.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum14Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00014.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum15Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00015.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum16Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00016.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum17Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00017.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum18Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00018.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum19Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00019.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum20Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00020.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum21Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00021.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum22Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00022.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum23Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00023.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum24Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00024.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum25Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00025.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum26Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00026.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum27Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00027.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum28Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00028.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum29Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00029.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum30Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00030.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum31Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00031.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum32Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00032.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum33Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00033.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum34Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00034.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum35Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00035.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum36Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00036.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum37Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00037.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum38Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00038.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum39Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00039.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum40Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00040.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum41Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00041.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum42Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00042.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum43Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00043.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum44Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00044.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum45Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00045.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum46Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00046.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum47Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00047.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum48Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00048.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum49Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00049.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
		}
		if (Progressbargrindergnum50Procedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grinder--00050.png"), this.leftPos + 152, this.topPos + 9, 0, 0, 51, 50, 51, 50);
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
		guiGraphics.drawString(this.font,

				Grindertrans1Procedure.execute(world, x, y, z), 144, 70, -4671036, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_help_button = new ImageButton(this.leftPos + 195, this.topPos + 140, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_help_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new GrinderguiButtonMessage(0, x, y, z));
				GrinderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_help_button", imagebutton_help_button);
		this.addRenderableWidget(imagebutton_help_button);
	}
}

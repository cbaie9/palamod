package palamod.client.gui;

import palamod.world.inventory.GrinderguiMenu;

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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/grindergui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 215, 163, 215, 163);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/gnew_indicator.png"), this.leftPos + 146, this.topPos + 3, 0, 0, 64, 64, 64, 64);

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
		guiGraphics.drawString(this.font,

				Grindertrans1Procedure.execute(), 143, 67, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
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

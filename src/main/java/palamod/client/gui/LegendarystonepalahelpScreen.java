package palamod.client.gui;

import palamod.world.inventory.LegendarystonepalahelpMenu;

import palamod.network.LegendarystonepalahelpButtonMessage;

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

public class LegendarystonepalahelpScreen extends AbstractContainerScreen<LegendarystonepalahelpMenu> {
	private final static HashMap<String, Object> guistate = LegendarystonepalahelpMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_home_pixel_adminshop;
	ImageButton imagebutton_arrow_adminshop;

	public LegendarystonepalahelpScreen(LegendarystonepalahelpMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
		this.imageHeight = 200;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/legendarystonepalahelp.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 220, 200, 220, 200);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/legend_fortune.png"), this.leftPos + 10, this.topPos + 50, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/legend_invisibility.png"), this.leftPos + 10, this.topPos + 74, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/legend_jobs.png"), this.leftPos + 10, this.topPos + 95, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/legend_power.png"), this.leftPos + 10, this.topPos + 116, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/legend_tp.png"), this.leftPos + 10, this.topPos + 140, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/legend_random.png"), this.leftPos + 11, this.topPos + 167, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 88, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 119, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_legendary_stone_wiki"), 3, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_forturne_permet_de_vous_give"), 26, 54, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_note_utilisable_une_fois_tous_l"), 3, 24, -16777012, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_invisible_vous_rend_invisible"), 26, 76, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_jobs_vous_donne_de_lxp"), 25, 98, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_power_vous_permet_detre_prote"), 26, 119, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_contre_la_fake_water"), 14, 130, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_teleportation_vous_tp_aletorem"), 27, 144, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_sur_la_map"), 13, 157, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_random_vous_donne_une_des_5_pi"), 26, 173, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_au_dessus"), 12, 183, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.legendarystonepalahelp.label_effect"), 27, 85, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 198, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LegendarystonepalahelpButtonMessage(0, x, y, z));
				LegendarystonepalahelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 164, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LegendarystonepalahelpButtonMessage(1, x, y, z));
				LegendarystonepalahelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 180, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LegendarystonepalahelpButtonMessage(2, x, y, z));
				LegendarystonepalahelpButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}

package palamod.client.gui;

import palamod.world.inventory.CrusherguiMenu;

import palamod.procedures.CrushertextadProcedure;
import palamod.procedures.Crushertextad4Procedure;
import palamod.procedures.Crushertextad3Procedure;
import palamod.procedures.Crushertextad2Procedure;
import palamod.procedures.Crushersubprocessv3barpaladiumProcedure;
import palamod.procedures.Crushersubprocessv3barendiumProcedure;
import palamod.procedures.Crushersubprocessv3baramethystProcedure;
import palamod.procedures.CrushersubprocessflamespritereturnProcedure;
import palamod.procedures.CrusherdebugProcedure;
import palamod.procedures.CrushercustominfotitaneProcedure;
import palamod.procedures.CrushercustominfopaladiumProcedure;
import palamod.procedures.CrushercustominfoendiumProcedure;
import palamod.procedures.CrushercustominfoameProcedure;

import palamod.network.CrusherguiButtonMessage;

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

public class CrusherguiScreen extends AbstractContainerScreen<CrusherguiMenu> {
	private final static HashMap<String, Object> guistate = CrusherguiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_button_white3;
	ImageButton imagebutton_button_white4;
	ImageButton imagebutton_button_white5;
	ImageButton imagebutton_button_white6;

	public CrusherguiScreen(CrusherguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 335;
		this.imageHeight = 205;
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

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/crusher_gui_v2.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 335, 205, 335, 205);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/amethystmixedcoal.png"), this.leftPos + 177, this.topPos + 140, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/titanemixedcoal.png"), this.leftPos + 177, this.topPos + 158, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/goldmixedcoal.png"), this.leftPos + 177, this.topPos + 122, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/palamixedcoal.png"), this.leftPos + 177, this.topPos + 176, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/eggplante_crusher_v2.png"), this.leftPos + 7, this.topPos + 20, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/amethyst_ingot.png"), this.leftPos + 194, this.topPos + 19, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/titane_ingot.png"), this.leftPos + 194, this.topPos + 51, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/endium_nugets_vfufu.png"), this.leftPos + 312, this.topPos + 51, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/paladium_ingot.png"), this.leftPos + 312, this.topPos + 20, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/fuel_crusher.png"), this.leftPos + 7, this.topPos + 56, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/pgbar_ame_full.png"), this.leftPos + 198, this.topPos + 124, Mth.clamp((int) Crushersubprocessv3baramethystProcedure.execute(world, x, y, z) * 100, 0, 1600), 0, 100, 10, 1700,
				10);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/titane_pgbar_full.png"), this.leftPos + 198, this.topPos + 141, 0, 0, 100, 10, 3300, 10);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/paladium_pgbar_full.png"), this.leftPos + 198, this.topPos + 161, Mth.clamp((int) Crushersubprocessv3barpaladiumProcedure.execute(world, x, y, z) * 100, 0, 3200), 0, 100, 10,
				3300, 10);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/pgbar_endium_v1.2.png"), this.leftPos + 198, this.topPos + 180, Mth.clamp((int) Crushersubprocessv3barendiumProcedure.execute(world, x, y, z) * 136, 0, 17272), 0, 136, 10,
				17408, 10);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/flamme_crusher_sprite.png"), this.leftPos + 7, this.topPos + 38, Mth.clamp((int) CrushersubprocessflamespritereturnProcedure.execute(world, x, y, z) * 16, 0, 144), 0, 16, 16,
				160, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_paladium_crusher"), 121, 3, -3407821, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_inventaire"), 14, 109, -1315861, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_fuel"), 27, 58, -3394816, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_fruits"), 26, 24, -3407668, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_v2004"), 299, 192, -12829636, false);
		if (Crushertextad4Procedure.execute())
			guiGraphics.drawString(this.font,

					CrushercustominfoameProcedure.execute(world, x, y, z), 123, 38, -12829636, false);
		if (Crushertextad3Procedure.execute())
			guiGraphics.drawString(this.font,

					CrushercustominfotitaneProcedure.execute(world, x, y, z), 124, 70, -12829636, false);
		if (Crushertextad2Procedure.execute())
			guiGraphics.drawString(this.font,

					CrushercustominfopaladiumProcedure.execute(world, x, y, z), 229, 38, -12829636, false);
		if (CrushertextadProcedure.execute())
			guiGraphics.drawString(this.font,

					CrushercustominfoendiumProcedure.execute(world, x, y, z), 245, 70, -12829636, false);
		guiGraphics.drawString(this.font,

				CrusherdebugProcedure.execute(world, x, y, z), 4, -12, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_button_white3 = new ImageButton(this.leftPos + 100, this.topPos + 51, 92, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_white.png"), ResourceLocation.parse("palamod:textures/screens/button_gray.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new CrusherguiButtonMessage(0, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_white3", imagebutton_button_white3);
		this.addRenderableWidget(imagebutton_button_white3);
		imagebutton_button_white4 = new ImageButton(this.leftPos + 219, this.topPos + 51, 92, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_white.png"), ResourceLocation.parse("palamod:textures/screens/button_blue.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new CrusherguiButtonMessage(1, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_white4", imagebutton_button_white4);
		this.addRenderableWidget(imagebutton_button_white4);
		imagebutton_button_white5 = new ImageButton(this.leftPos + 100, this.topPos + 19, 92, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_white.png"), ResourceLocation.parse("palamod:textures/screens/button_purple.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new CrusherguiButtonMessage(2, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_white5", imagebutton_button_white5);
		this.addRenderableWidget(imagebutton_button_white5);
		imagebutton_button_white6 = new ImageButton(this.leftPos + 219, this.topPos + 19, 92, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_white.png"), ResourceLocation.parse("palamod:textures/screens/button_red.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new CrusherguiButtonMessage(3, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_button_white6", imagebutton_button_white6);
		this.addRenderableWidget(imagebutton_button_white6);
	}
}

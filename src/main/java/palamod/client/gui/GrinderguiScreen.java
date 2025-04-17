package palamod.client.gui;

import palamod.world.inventory.GrinderguiMenu;

import palamod.procedures.ReturntimerinputgrinderProcedure;
import palamod.procedures.ProgressbargrinderspritereturnProcedure;
import palamod.procedures.LightredgrinderonProcedure;
import palamod.procedures.LightgreengrinderonProcedure;
import palamod.procedures.LightbluegrinderonProcedure;
import palamod.procedures.Grindertrans1Procedure;
import palamod.procedures.GrindergettimerfusionProcedure;
import palamod.procedures.GrindergettimercraftProcedure;

import palamod.network.GrinderguiButtonMessage;

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
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/grindergui_v4.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 215, 163, 215, 163);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/btn-all_off.png"), this.leftPos + 160, this.topPos + 63, 0, 0, 37, 7, 37, 7);

		if (LightbluegrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/btn-blue_on.png"), this.leftPos + 190, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}
		if (LightredgrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/btn-red_on.png"), this.leftPos + 160, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}
		if (LightgreengrinderonProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/btn-green_on.png"), this.leftPos + 175, this.topPos + 63, 0, 0, 7, 7, 7, 7);
		}

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/grinder_sprite_full.png"), this.leftPos + 152, this.topPos + 9, Mth.clamp((int) ProgressbargrinderspritereturnProcedure.execute(world, x, y, z) * 51, 0, 2550), 0, 51, 50, 2601,
				50);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/fire_furnace.png"), this.leftPos + 126, this.topPos + 25, Mth.clamp((int) ReturntimerinputgrinderProcedure.execute(world, x, y, z) * 16, 0, 224), 0, 16, 16, 240, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/arrow_right_furnace_sprite.png"), this.leftPos + 53, this.topPos + 59, 0, 0, 22, 15, 506, 15);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/arrow_right_furnace_sprite.png"), this.leftPos + 49, this.topPos + 13, Mth.clamp((int) GrindergettimercraftProcedure.execute(world, x, y, z) * 22, 0, 484), 0, 22, 15, 506, 15);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/arrow_right_furnace_sprite.png"), this.leftPos + 48, this.topPos + 60, Mth.clamp((int) GrindergettimerfusionProcedure.execute(world, x, y, z) * 22, 0, 484), 0, 22, 15, 506,
				15);

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
		imagebutton_help_button = new ImageButton(this.leftPos + 193, this.topPos + 141, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/help_button.png"), ResourceLocation.parse("palamod:textures/screens/help_button_poi.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GrinderguiButtonMessage(0, x, y, z));
						GrinderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_help_button", imagebutton_help_button);
		this.addRenderableWidget(imagebutton_help_button);
	}
}

package palamod.client.gui;

import palamod.world.inventory.ClickerMenu;

import palamod.procedures.ClickerprintcoinsProcedure;
import palamod.procedures.ClickergetpageforspriteProcedure;
import palamod.procedures.Clickergetnump1Procedure;
import palamod.procedures.Clickergetdizp1Procedure;
import palamod.procedures.ClickerconditionpageupProcedure;
import palamod.procedures.ClickerconditionpagedownProcedure;

import palamod.network.ClickerButtonMessage;

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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ClickerScreen extends AbstractContainerScreen<ClickerMenu> {
	private final static HashMap<String, Object> guistate = ClickerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_up;
	ImageButton imagebutton_clicker_skip;
	ImageButton imagebutton_clicker_close_btn;
	ImageButton imagebutton_clicker_potato_btn_v11;
	ImageButton imagebutton_page_up_clicker;
	ImageButton imagebutton_page_down;

	public ClickerScreen(ClickerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 360;
		this.imageHeight = 210;
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

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_v1.11.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 360, 210, 360, 210);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_button_noclick.png"), this.leftPos + 260, this.topPos + 38, 0, 0, 88, 21, 88, 21);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_button_noclick.png"), this.leftPos + 260, this.topPos + 61, 0, 0, 88, 21, 88, 21);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_button_noclick.png"), this.leftPos + 260, this.topPos + 83, 0, 0, 88, 21, 88, 21);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_button_noclick.png"), this.leftPos + 260, this.topPos + 106, 0, 0, 88, 21, 88, 21);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_button_noclick.png"), this.leftPos + 260, this.topPos + 128, 0, 0, 88, 21, 88, 21);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_button_noclick.png"), this.leftPos + 260, this.topPos + 151, 0, 0, 88, 21, 88, 21);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/page_btn_off.png"), this.leftPos + 260, this.topPos + 181, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/page_btn_off.png"), this.leftPos + 332, this.topPos + 181, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/numbers.png"), this.leftPos + 296, this.topPos + 181, Mth.clamp((int) ClickergetpageforspriteProcedure.execute(world) * 16, 0, 128), 0, 16, 16, 144, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/numbers_mc_dungeons.png"), this.leftPos + 325, this.topPos + 41, Mth.clamp((int) Clickergetdizp1Procedure.execute(world, entity) * 16, 0, 160), 0, 16, 16, 176, 16);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/numbers_mc_dungeons.png"), this.leftPos + 334, this.topPos + 41, Mth.clamp((int) Clickergetnump1Procedure.execute(world, entity) * 16, 0, 160), 0, 16, 16, 176, 16);

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

				ClickerprintcoinsProcedure.execute(world, entity), 12, 44, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_up = Button.builder(Component.translatable("gui.palamod.clicker.button_up"), e -> {
			if (true) {
				PacketDistributor.sendToServer(new ClickerButtonMessage(0, x, y, z));
				ClickerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -26, this.topPos + 93, 35, 20).build();
		guistate.put("button:button_up", button_up);
		this.addRenderableWidget(button_up);
		imagebutton_clicker_skip = new ImageButton(this.leftPos + 229, this.topPos + 184, 12, 12,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_skip.png"), ResourceLocation.parse("palamod:textures/screens/clicker_skip_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_skip", imagebutton_clicker_skip);
		this.addRenderableWidget(imagebutton_clicker_skip);
		imagebutton_clicker_close_btn = new ImageButton(this.leftPos + 336, this.topPos + 6, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/close_gui_nohover.png"), ResourceLocation.parse("palamod:textures/screens/close_gui_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ClickerButtonMessage(2, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_close_btn", imagebutton_clicker_close_btn);
		this.addRenderableWidget(imagebutton_clicker_close_btn);
		imagebutton_clicker_potato_btn_v11 = new ImageButton(this.leftPos + 11, this.topPos + 60, 91, 139,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_potato_btn_v1.1.png"), ResourceLocation.parse("palamod:textures/screens/clicker_potato_btn_v1.1.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ClickerButtonMessage(3, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_potato_btn_v11", imagebutton_clicker_potato_btn_v11);
		this.addRenderableWidget(imagebutton_clicker_potato_btn_v11);
		imagebutton_page_up_clicker = new ImageButton(this.leftPos + 332, this.topPos + 181, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/page_up_clicker.png"), ResourceLocation.parse("palamod:textures/screens/page_up_clicker.png")), e -> {
					if (ClickerconditionpageupProcedure.execute(world)) {
						PacketDistributor.sendToServer(new ClickerButtonMessage(4, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ClickerconditionpageupProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_page_up_clicker", imagebutton_page_up_clicker);
		this.addRenderableWidget(imagebutton_page_up_clicker);
		imagebutton_page_down = new ImageButton(this.leftPos + 260, this.topPos + 181, 16, 16, new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/page_down.png"), ResourceLocation.parse("palamod:textures/screens/page_down.png")),
				e -> {
					if (ClickerconditionpagedownProcedure.execute(world)) {
						PacketDistributor.sendToServer(new ClickerButtonMessage(5, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				if (ClickerconditionpagedownProcedure.execute(world))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_page_down", imagebutton_page_down);
		this.addRenderableWidget(imagebutton_page_down);
	}
}

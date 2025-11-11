package palamod.client.gui;

import palamod.world.inventory.UploaderguiMenu;

import palamod.procedures.UploaderdebugProcedure;
import palamod.procedures.Grindertrans0Procedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.UploaderguiButtonMessage;

import palamod.init.PalamodModScreens;

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

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class UploaderguiScreen extends AbstractContainerScreen<UploaderguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_help_img;

	public UploaderguiScreen(UploaderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 76 && mouseX < leftPos + 94 && mouseY > topPos + 61 && mouseY < topPos + 79) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.uploadergui.tooltip_money_output"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 76 && mouseX < leftPos + 94 && mouseY > topPos + 27 && mouseY < topPos + 45) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.uploadergui.tooltip_items_you_want_to_sell_must_be"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 152 && mouseX < leftPos + 168 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 61 && mouseX < leftPos + 107 && mouseY > topPos + 5 && mouseY < topPos + 18) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.uploadergui.tooltip_this_gui_interface_need_an_upgra"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 132 && mouseX < leftPos + 148 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.uploadergui.tooltip_this_machine_is_to_sell_thing_to"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/uploadergui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/golem_treec_sep_nt1.png"), this.leftPos + 77, this.topPos + 45, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/right_gray_line.png"), this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.uploadergui.label_uploader"), 64, 7, -1, false);
		guiGraphics.drawString(this.font, Grindertrans0Procedure.execute(entity), 3, 71, -12829636, false);
		guiGraphics.drawString(this.font, UploaderdebugProcedure.execute(world, x, y, z), 95, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 152, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = UploaderguiScreen.this.x;
					int y = UploaderguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new UploaderguiButtonMessage(0, x, y, z));
						UploaderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_help_img = new ImageButton(this.leftPos + 132, this.topPos + 4, 16, 16, new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/help_img.png"), ResourceLocation.parse("palamod:textures/screens/help_hover.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_help_img);
	}
}
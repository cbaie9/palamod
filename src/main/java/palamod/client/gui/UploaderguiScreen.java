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
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/uploadergui.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/text_red_background_left.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/text_red_background_right.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/text_red_background_left.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/text_red_background_right.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/text_red_background_left.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/text_red_background_right.png");

	public UploaderguiScreen(UploaderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
		this.imageHeight = 180;
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
		if (mouseX > leftPos + 99 && mouseX < leftPos + 117 && mouseY > topPos + 34 && mouseY < topPos + 52) {
			if (Component.translatable("gui.palamod.uploadergui.tooltip_money_output").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.uploadergui.tooltip_money_output").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 99 && mouseX < leftPos + 117 && mouseY > topPos + 68 && mouseY < topPos + 86) {
			if (Component.translatable("gui.palamod.uploadergui.tooltip_items_you_want_to_sell_must_be").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.uploadergui.tooltip_items_you_want_to_sell_must_be").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 200 && mouseX < leftPos + 216 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			if (ClosetheguitransProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(ClosetheguitransProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 181 && mouseX < leftPos + 197 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			if (Component.translatable("gui.palamod.uploadergui.tooltip_this_machine_is_to_sell_thing_to").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.uploadergui.tooltip_this_machine_is_to_sell_thing_to").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 220, 180, 220, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + 28, this.topPos + 72, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + 43, this.topPos + 72, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + 130, this.topPos + 71, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + 141, this.topPos + 71, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(IMAGE_5, this.leftPos + 85, this.topPos + 6, 0, 0, 50, 16, 50, 16);
		guiGraphics.blit(IMAGE_6, this.leftPos + 86, this.topPos + 6, 0, 0, 50, 16, 50, 16);
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
		int heightPadding = 0;
		int yOffset = 0;
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.uploadergui.label_uploader").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 89, 8 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Grindertrans0Procedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 30, 76 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(UploaderdebugProcedure.execute(world, x, y, z).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 133, 73 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 200, this.topPos + 4, 16, 16,
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
		imagebutton_help_img = new ImageButton(this.leftPos + 181, this.topPos + 4, 16, 16, new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/help_img.png"), ResourceLocation.parse("palamod:textures/screens/help_hover.png")), e -> {
		}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_help_img);
	}
}
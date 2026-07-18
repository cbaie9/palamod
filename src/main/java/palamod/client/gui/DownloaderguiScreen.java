package palamod.client.gui;

import palamod.world.inventory.DownloaderguiMenu;

import palamod.procedures.Grindertrans0Procedure;
import palamod.procedures.DownloadercheckedProcedure;

import palamod.network.DownloaderguiButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class DownloaderguiScreen extends AbstractContainerScreen<DownloaderguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox download_state;
	private Button button_reload;
	private Button button_link;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/downloadergui.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/arrow_down_downloader_gray.png");

	public DownloaderguiScreen(DownloaderguiMenu container, Inventory inventory, Component text) {
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
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("download_state")) {
				if (download_state.selected() != logicState)
					download_state.onPress();
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 113 && mouseX < leftPos + 169 && mouseY > topPos + 60 && mouseY < topPos + 80) {
			if (Component.translatable("gui.palamod.downloadergui.tooltip_reboot_the_downloader_change_t").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.downloadergui.tooltip_reboot_the_downloader_change_t").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 3 && mouseX < leftPos + 49 && mouseY > topPos + 48 && mouseY < topPos + 67) {
			if (Component.translatable("gui.palamod.downloadergui.tooltip_link_a_bank_account_who_will_be").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.downloadergui.tooltip_link_a_bank_account_who_will_be").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 4 && mouseX < leftPos + 24 && mouseY > topPos + 4 && mouseY < topPos + 24) {
			if (Component.translatable("gui.palamod.downloadergui.tooltip_turn_onoff_the_machine").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.downloadergui.tooltip_turn_onoff_the_machine").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 138 && mouseX < leftPos + 170 && mouseY > topPos + 4 && mouseY < topPos + 34) {
			if (Component.translatable("gui.palamod.downloadergui.tooltip_what_you_will_buy_with_the_machi").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.downloadergui.tooltip_what_you_will_buy_with_the_machi").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(IMAGE_1, this.leftPos + 79, this.topPos + 62, 0, 0, 16, 16, 16, 16);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.downloadergui.label_filter").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 138, 3 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.downloadergui.label_output").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 71, 31 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Grindertrans0Procedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 6, 71 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		button_reload = Button.builder(Component.translatable("gui.palamod.downloadergui.button_reload"), e -> {
			int x = DownloaderguiScreen.this.x;
			int y = DownloaderguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new DownloaderguiButtonMessage(0, x, y, z));
				DownloaderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 60, 56, 20).build();
		this.addRenderableWidget(button_reload);
		button_link = Button.builder(Component.translatable("gui.palamod.downloadergui.button_link"), e -> {
			int x = DownloaderguiScreen.this.x;
			int y = DownloaderguiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new DownloaderguiButtonMessage(1, x, y, z));
				DownloaderguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 3, this.topPos + 48, 46, 20).build();
		this.addRenderableWidget(button_link);
		boolean download_stateSelected = DownloadercheckedProcedure.execute(world, x, y, z);
		download_state = Checkbox.builder(Component.translatable("gui.palamod.downloadergui.download_state"), this.font).pos(this.leftPos + 4, this.topPos + 4).onValueChange((checkbox, value) -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 1, "download_state", value, false);
		}).selected(download_stateSelected).build();
		if (download_stateSelected)
			menu.sendMenuStateUpdate(entity, 1, "download_state", true, false);
		this.addRenderableWidget(download_state);
	}
}
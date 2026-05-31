package palamod.client.gui;

import palamod.world.inventory.DownloaderguiMenu;

import palamod.procedures.Grindertrans0Procedure;
import palamod.procedures.DownloadercheckedProcedure;

import palamod.network.DownloaderguiButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class DownloaderguiScreen extends AbstractContainerScreen<DownloaderguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Checkbox download_state;
	private Button button_reload;
	private Button button_link;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/downloadergui.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/arrow_down_downloader_gray.png");

	public DownloaderguiScreen(DownloaderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 176, 166);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 1 && elementState instanceof Boolean logicState) {
			if (name.equals("download_state")) {
				if (download_state.selected() != logicState)
					download_state.onPress(null);
			}
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		if (mouseX > leftPos + 113 && mouseX < leftPos + 169 && mouseY > topPos + 60 && mouseY < topPos + 80) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.downloadergui.tooltip_reboot_the_downloader_change_t"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 3 && mouseX < leftPos + 49 && mouseY > topPos + 48 && mouseY < topPos + 67) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.downloadergui.tooltip_link_a_bank_account_who_will_be"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 4 && mouseX < leftPos + 24 && mouseY > topPos + 4 && mouseY < topPos + 24) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.downloadergui.tooltip_turn_onoff_the_machine"), mouseX, mouseY);
		}
		if (mouseX > leftPos + 138 && mouseX < leftPos + 170 && mouseY > topPos + 4 && mouseY < topPos + 34) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.downloadergui.tooltip_what_you_will_buy_with_the_machi"), mouseX, mouseY);
		}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 79, this.topPos + 62, 0, 0, 16, 16, 16, 16);
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.downloadergui.label_filter"), 138, 3, -12829636, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.downloadergui.label_output"), 71, 31, -12829636, false);
		guiGraphics.text(this.font, Grindertrans0Procedure.execute(), 6, 71, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_reload = Button.builder(Component.translatable("gui.palamod.downloadergui.button_reload"), e -> {
			int x = DownloaderguiScreen.this.x;
			int y = DownloaderguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DownloaderguiButtonMessage(0, x, y, z));
				DownloaderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 60, 56, 20).build();
		this.addRenderableWidget(button_reload);
		button_link = Button.builder(Component.translatable("gui.palamod.downloadergui.button_link"), e -> {
			int x = DownloaderguiScreen.this.x;
			int y = DownloaderguiScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new DownloaderguiButtonMessage(1, x, y, z));
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
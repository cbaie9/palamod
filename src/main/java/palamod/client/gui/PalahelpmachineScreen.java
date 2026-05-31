package palamod.client.gui;

import palamod.world.inventory.PalahelpmachineMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.PalahelpmachineButtonMessage;

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
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.platform.InputConstants;

public class PalahelpmachineScreen extends AbstractContainerScreen<PalahelpmachineMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_grinder;
	private Button button_palamachine;
	private Button button_crusher;
	private Button button_forge;
	private Button button_uploader;
	private Button button_downloader;
	private Button button_drawbridge;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_cross_no_button;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/gui176_166.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/left_gray_line.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/right_gray_line.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/golem64.png");

	public PalahelpmachineScreen(PalahelpmachineMenu container, Inventory inventory, Component text) {
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
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		if (mouseX > leftPos + 155 && mouseX < leftPos + 171 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.setComponentTooltipForNextFrame(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
		}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 76, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 13, this.topPos + 28, 0, 0, 64, 64, 64, 64);
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
		guiGraphics.text(this.font, Component.translatable("gui.palamod.palahelpmachine.label_palahelp_machine_menu"), 2, 6, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_grinder = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_grinder"), e -> {
			int x = PalahelpmachineScreen.this.x;
			int y = PalahelpmachineScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(0, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 29, 75, 20).build();
		this.addRenderableWidget(button_grinder);
		button_palamachine = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_palamachine"), e -> {
			int x = PalahelpmachineScreen.this.x;
			int y = PalahelpmachineScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(1, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 51, 75, 20).build();
		this.addRenderableWidget(button_palamachine);
		button_crusher = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_crusher"), e -> {
			int x = PalahelpmachineScreen.this.x;
			int y = PalahelpmachineScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(2, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 73, 75, 20).build();
		this.addRenderableWidget(button_crusher);
		button_forge = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_forge"), e -> {
			int x = PalahelpmachineScreen.this.x;
			int y = PalahelpmachineScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(3, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 96, 75, 20).build();
		this.addRenderableWidget(button_forge);
		button_uploader = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_uploader"), e -> {
			int x = PalahelpmachineScreen.this.x;
			int y = PalahelpmachineScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(4, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 118, 75, 20).build();
		this.addRenderableWidget(button_uploader);
		button_downloader = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_downloader"), e -> {
			int x = PalahelpmachineScreen.this.x;
			int y = PalahelpmachineScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(5, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 140, 75, 20).build();
		this.addRenderableWidget(button_downloader);
		button_drawbridge = Button.builder(Component.translatable("gui.palamod.palahelpmachine.button_drawbridge"), e -> {
			int x = PalahelpmachineScreen.this.x;
			int y = PalahelpmachineScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(6, x, y, z));
				PalahelpmachineButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 97, 77, 20).build();
		this.addRenderableWidget(button_drawbridge);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 122, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_adminshop.png"), Identifier.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = PalahelpmachineScreen.this.x;
					int y = PalahelpmachineScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(7, x, y, z));
						PalahelpmachineButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 139, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/home_pixel_adminshop.png"), Identifier.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = PalahelpmachineScreen.this.x;
					int y = PalahelpmachineScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(8, x, y, z));
						PalahelpmachineButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 155, this.topPos + 4, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/cross_no_button.png"), Identifier.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = PalahelpmachineScreen.this.x;
					int y = PalahelpmachineScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new PalahelpmachineButtonMessage(9, x, y, z));
						PalahelpmachineButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
	}
}
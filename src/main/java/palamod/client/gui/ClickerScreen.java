package palamod.client.gui;

import palamod.world.inventory.ClickerMenu;

import palamod.procedures.*;

import palamod.network.ClickerButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import com.mojang.blaze3d.platform.InputConstants;

public class ClickerScreen extends AbstractContainerScreen<ClickerMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_up;
	private ImageButton imagebutton_clicker_skip;
	private ImageButton imagebutton_clicker_close_btn;
	private ImageButton imagebutton_clicker_potato_btn_v11;
	private ImageButton imagebutton_page_up_clicker;
	private ImageButton imagebutton_page_down;
	private static final Identifier IMAGE_0 = Identifier.parse("palamod:textures/screens/clicker_v1.11.png");
	private static final Identifier IMAGE_1 = Identifier.parse("palamod:textures/screens/clicker_button_noclick.png");
	private static final Identifier IMAGE_2 = Identifier.parse("palamod:textures/screens/clicker_button_noclick.png");
	private static final Identifier IMAGE_3 = Identifier.parse("palamod:textures/screens/clicker_button_noclick.png");
	private static final Identifier IMAGE_4 = Identifier.parse("palamod:textures/screens/clicker_button_noclick.png");
	private static final Identifier IMAGE_5 = Identifier.parse("palamod:textures/screens/clicker_button_noclick.png");
	private static final Identifier IMAGE_6 = Identifier.parse("palamod:textures/screens/clicker_button_noclick.png");
	private static final Identifier IMAGE_7 = Identifier.parse("palamod:textures/screens/page_btn_off.png");
	private static final Identifier IMAGE_8 = Identifier.parse("palamod:textures/screens/page_btn_off.png");
	private static final Identifier SPRITE_0 = Identifier.parse("palamod:textures/screens/numbers.png");
	private static final Identifier SPRITE_1 = Identifier.parse("palamod:textures/screens/numbers_mc_dungeons.png");
	private static final Identifier SPRITE_2 = Identifier.parse("palamod:textures/screens/numbers_mc_dungeons.png");

	public ClickerScreen(ClickerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 360, 210);
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
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 360, 210, 360, 210);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 260, this.topPos + 38, 0, 0, 88, 21, 88, 21);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 260, this.topPos + 61, 0, 0, 88, 21, 88, 21);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 260, this.topPos + 83, 0, 0, 88, 21, 88, 21);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 260, this.topPos + 106, 0, 0, 88, 21, 88, 21);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 260, this.topPos + 128, 0, 0, 88, 21, 88, 21);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 260, this.topPos + 151, 0, 0, 88, 21, 88, 21);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_7, this.leftPos + 260, this.topPos + 181, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_8, this.leftPos + 332, this.topPos + 181, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 296, this.topPos + 181, Mth.clamp((int) ClickergetpageforspriteProcedure.execute(world) * 16, 0, 128), 0, 16, 16, 144, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_1, this.leftPos + 325, this.topPos + 41, Mth.clamp((int) Clickergetdizp1Procedure.execute(world, entity) * 16, 0, 160), 0, 16, 16, 176, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_2, this.leftPos + 334, this.topPos + 41, Mth.clamp((int) Clickergetnump1Procedure.execute(world, entity) * 16, 0, 160), 0, 16, 16, 176, 16);
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
		guiGraphics.text(this.font, ClickerprintcoinsProcedure.execute(world, entity), 12, 44, -1, false);
	}

	@Override
	public void init() {
		super.init();
		button_up = Button.builder(Component.translatable("gui.palamod.clicker.button_up"), e -> {
			int x = ClickerScreen.this.x;
			int y = ClickerScreen.this.y;
			if (true) {
				ClientPacketDistributor.sendToServer(new ClickerButtonMessage(0, x, y, z));
				ClickerButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + -26, this.topPos + 93, 35, 20).build();
		this.addRenderableWidget(button_up);
		imagebutton_clicker_skip = new ImageButton(this.leftPos + 229, this.topPos + 184, 12, 12, new WidgetSprites(Identifier.parse("palamod:textures/screens/clicker_skip.png"), Identifier.parse("palamod:textures/screens/clicker_skip_hover.png")),
				e -> {
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_clicker_skip);
		imagebutton_clicker_close_btn = new ImageButton(this.leftPos + 336, this.topPos + 6, 17, 17,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/close_gui_nohover.png"), Identifier.parse("palamod:textures/screens/close_gui_hover.png")), e -> {
					int x = ClickerScreen.this.x;
					int y = ClickerScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ClickerButtonMessage(2, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_clicker_close_btn);
		imagebutton_clicker_potato_btn_v11 = new ImageButton(this.leftPos + 11, this.topPos + 60, 91, 139,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/clicker_potato_btn_v1.1.png"), Identifier.parse("palamod:textures/screens/clicker_potato_btn_v1.1.png")), e -> {
					int x = ClickerScreen.this.x;
					int y = ClickerScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new ClickerButtonMessage(3, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_clicker_potato_btn_v11);
		imagebutton_page_up_clicker = new ImageButton(this.leftPos + 332, this.topPos + 181, 16, 16,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/page_up_clicker.png"), Identifier.parse("palamod:textures/screens/page_up_clicker.png")), e -> {
					int x = ClickerScreen.this.x;
					int y = ClickerScreen.this.y;
					if (ClickerconditionpageupProcedure.execute(world)) {
						ClientPacketDistributor.sendToServer(new ClickerButtonMessage(4, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = ClickerScreen.this.x;
				int y = ClickerScreen.this.y;
				if (ClickerconditionpageupProcedure.execute(world))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_page_up_clicker);
		imagebutton_page_down = new ImageButton(this.leftPos + 260, this.topPos + 181, 16, 16, new WidgetSprites(Identifier.parse("palamod:textures/screens/page_down.png"), Identifier.parse("palamod:textures/screens/page_down.png")), e -> {
			int x = ClickerScreen.this.x;
			int y = ClickerScreen.this.y;
			if (ClickerconditionpagedownProcedure.execute(world)) {
				ClientPacketDistributor.sendToServer(new ClickerButtonMessage(5, x, y, z));
				ClickerButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = ClickerScreen.this.x;
				int y = ClickerScreen.this.y;
				if (ClickerconditionpagedownProcedure.execute(world))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_page_down);
	}
}
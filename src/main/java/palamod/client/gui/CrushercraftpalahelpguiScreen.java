package palamod.client.gui;

import palamod.world.inventory.CrushercraftpalahelpguiMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.CrushercraftpalahelpguiButtonMessage;

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

public class CrushercraftpalahelpguiScreen extends AbstractContainerScreen<CrushercraftpalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_paladium_ingot;
	private ImageButton imagebutton_amethyst_ingot;
	private ImageButton imagebutton_titane_ingot;
	private ImageButton imagebutton_endium_nugets_vfufu;
	private ImageButton imagebutton_help_button;
	private ImageButton imagebutton_close_gui_nohover;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/crusher_jei.png");

	public CrushercraftpalahelpguiScreen(CrushercraftpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 85;
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
		if (mouseX > leftPos + 21 && mouseX < leftPos + 39 && mouseY > topPos + 8 && mouseY < topPos + 26) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_fruits_slot_input").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_fruits_slot_input").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 21 && mouseX < leftPos + 39 && mouseY > topPos + 44 && mouseY < topPos + 62) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_fuel_slot_input").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_fuel_slot_input").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 90 && mouseX < leftPos + 108 && mouseY > topPos + 44 && mouseY < topPos + 62) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_crushers_output_slot").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_crushers_output_slot").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 157 && mouseX < leftPos + 174 && mouseY > topPos + -23 && mouseY < topPos + -6) {
			if (ClosetheguitransProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(ClosetheguitransProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 114 && mouseX < leftPos + 169 && mouseY > topPos + 27 && mouseY < topPos + 73) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_crusher_progression_bar").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_crusher_progression_bar").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 68 && mouseX < leftPos + 154 && mouseY > topPos + 6 && mouseY < topPos + 27) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_click_on_me_once_on_the_bar_your").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_click_on_me_once_on_the_bar_your").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 142 && mouseX < leftPos + 153 && mouseY > topPos + -22 && mouseY < topPos + -7) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_help_with_the_crusher").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_help_with_the_crusher").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 22 && mouseX < leftPos + 38 && mouseY > topPos + -19 && mouseY < topPos + -7) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_amethyst_craft").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_amethyst_craft").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 51 && mouseX < leftPos + 67 && mouseY > topPos + -19 && mouseY < topPos + -7) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_titane_craft").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_titane_craft").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 78 && mouseX < leftPos + 93 && mouseY > topPos + -19 && mouseY < topPos + -7) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_paladium_craft").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_paladium_craft").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 105 && mouseX < leftPos + 121 && mouseY > topPos + -21 && mouseY < topPos + -6) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_endium_nugget_craft").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_endium_nugget_craft").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 23 && mouseX < leftPos + 37 && mouseY > topPos + 28 && mouseY < topPos + 43) {
			if (Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_fuel_progressbar").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crushercraftpalahelpgui.tooltip_fuel_progressbar").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 256, 256, 256, 256);
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
	}

	@Override
	public void init() {
		super.init();
		imagebutton_paladium_ingot = new ImageButton(this.leftPos + 78, this.topPos + -21, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/paladium_ingot.png"), ResourceLocation.parse("palamod:textures/screens/paladium_ingot.png")), e -> {
					int x = CrushercraftpalahelpguiScreen.this.x;
					int y = CrushercraftpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrushercraftpalahelpguiButtonMessage(0, x, y, z));
						CrushercraftpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_paladium_ingot);
		imagebutton_amethyst_ingot = new ImageButton(this.leftPos + 22, this.topPos + -21, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/amethyst_ingot.png"), ResourceLocation.parse("palamod:textures/screens/amethyst_ingot.png")), e -> {
					int x = CrushercraftpalahelpguiScreen.this.x;
					int y = CrushercraftpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrushercraftpalahelpguiButtonMessage(1, x, y, z));
						CrushercraftpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_amethyst_ingot);
		imagebutton_titane_ingot = new ImageButton(this.leftPos + 51, this.topPos + -21, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/titane_ingot.png"), ResourceLocation.parse("palamod:textures/screens/titane_ingot.png")), e -> {
					int x = CrushercraftpalahelpguiScreen.this.x;
					int y = CrushercraftpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrushercraftpalahelpguiButtonMessage(2, x, y, z));
						CrushercraftpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_titane_ingot);
		imagebutton_endium_nugets_vfufu = new ImageButton(this.leftPos + 106, this.topPos + -21, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/endium_nugets_vfufu.png"), ResourceLocation.parse("palamod:textures/screens/endium_nugets_vfufu.png")), e -> {
					int x = CrushercraftpalahelpguiScreen.this.x;
					int y = CrushercraftpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrushercraftpalahelpguiButtonMessage(3, x, y, z));
						CrushercraftpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_endium_nugets_vfufu);
		imagebutton_help_button = new ImageButton(this.leftPos + 139, this.topPos + -23, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/help_button.png"), ResourceLocation.parse("palamod:textures/screens/help_button_poi.png")), e -> {
					int x = CrushercraftpalahelpguiScreen.this.x;
					int y = CrushercraftpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrushercraftpalahelpguiButtonMessage(4, x, y, z));
						CrushercraftpalahelpguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_help_button);
		imagebutton_close_gui_nohover = new ImageButton(this.leftPos + 157, this.topPos + -23, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/close_gui_nohover.png"), ResourceLocation.parse("palamod:textures/screens/close_gui_hover.png")), e -> {
					int x = CrushercraftpalahelpguiScreen.this.x;
					int y = CrushercraftpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrushercraftpalahelpguiButtonMessage(5, x, y, z));
						CrushercraftpalahelpguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_close_gui_nohover);
	}
}
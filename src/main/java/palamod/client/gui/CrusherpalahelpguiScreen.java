package palamod.client.gui;

import palamod.world.inventory.CrusherpalahelpguiMenu;

import palamod.procedures.TRADreturntosumarryProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.CrusherpalahelpguiButtonMessage;

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

public class CrusherpalahelpguiScreen extends AbstractContainerScreen<CrusherpalahelpguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_example_gui_button;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_book_button;
	private ImageButton imagebutton_sommaire_btn;
	private ImageButton imagebutton_arrow_palahelp_left_off;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/crusher_front.png");

	public CrusherpalahelpguiScreen(CrusherpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 420;
		this.imageHeight = 200;
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
		if (mouseX > leftPos + 163 && mouseX < leftPos + 183 && mouseY > topPos + 162 && mouseY < topPos + 180) {
			if (Component.translatable("gui.palamod.crusherpalahelpgui.tooltip_see_craft_for_crusher").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crusherpalahelpgui.tooltip_see_craft_for_crusher").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 395 && mouseX < leftPos + 411 && mouseY > topPos + 3 && mouseY < topPos + 19) {
			if (ClosetheguitransProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(ClosetheguitransProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 224 && mouseX < leftPos + 244 && mouseY > topPos + 19 && mouseY < topPos + 38) {
			if (TRADreturntosumarryProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(TRADreturntosumarryProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 67 && mouseX < leftPos + 103 && mouseY > topPos + 164 && mouseY < topPos + 184) {
			if (Component.translatable("gui.palamod.crusherpalahelpgui.tooltip_go_to_palahelp_grinder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.crusherpalahelpgui.tooltip_go_to_palahelp_grinder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 50, this.topPos + 19, 0, 0, 320, 180, 320, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + 68, this.topPos + 28, 0, 0, 16, 16, 16, 16);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.crusherpalahelpgui.label_paladium_crusher_wiki").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 86, 32 + yOffset, -13421773, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.crusherpalahelpgui.label_11_v1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 374, 184 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.crusherpalahelpgui.label_this_is_the_crusher_the_machine").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 64, 45 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.crusherpalahelpgui.label_to_finish_the_creation_of_the_in").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 222, 38 + yOffset, -65536, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.crusherpalahelpgui.label_note_its_not_mandatory_to_put").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 221, 120 + yOffset, -26368, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.crusherpalahelpgui.label_you_can_see_all_the_crafts_here").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 64, 139 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 395, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(0, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_example_gui_button = new ImageButton(this.leftPos + 372, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/example_gui_button.png"), ResourceLocation.parse("palamod:textures/screens/example_gui_button_poi.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(1, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_example_gui_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 325, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(2, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 348, this.topPos + 3, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(3, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_book_button = new ImageButton(this.leftPos + 163, this.topPos + 162, 20, 18,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/book_button.png"), ResourceLocation.parse("palamod:textures/screens/book_button_hover.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(4, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_book_button);
		imagebutton_sommaire_btn = new ImageButton(this.leftPos + 227, this.topPos + 19, 14, 18,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png"), ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(5, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_sommaire_btn);
		imagebutton_arrow_palahelp_left_off = new ImageButton(this.leftPos + 67, this.topPos + 164, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_on.png")), e -> {
					int x = CrusherpalahelpguiScreen.this.x;
					int y = CrusherpalahelpguiScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new CrusherpalahelpguiButtonMessage(6, x, y, z));
						CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_palahelp_left_off);
	}
}
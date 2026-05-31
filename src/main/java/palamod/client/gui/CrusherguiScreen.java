package palamod.client.gui;

import palamod.world.inventory.CrusherguiMenu;

import palamod.procedures.*;

import palamod.network.CrusherguiButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

public class CrusherguiScreen extends AbstractContainerScreen<CrusherguiMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_button_white3;
	private ImageButton imagebutton_button_white4;
	private ImageButton imagebutton_button_white5;
	private ImageButton imagebutton_button_white6;
	private ImageButton imagebutton_crusher_btn_pctg_on;
	private ImageButton imagebutton_pro_mode_crusher;
	private ImageButton imagebutton_book_button;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/crusher_gui_v2.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/amethystmixedcoal.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/titanemixedcoal.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/goldmixedcoal.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/palamixedcoal.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/eggplante_crusher_v2.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/amethyst_ingot.png");
	private static final ResourceLocation IMAGE_7 = ResourceLocation.parse("palamod:textures/screens/titane_ingot.png");
	private static final ResourceLocation IMAGE_8 = ResourceLocation.parse("palamod:textures/screens/endium_nugets_vfufu.png");
	private static final ResourceLocation IMAGE_9 = ResourceLocation.parse("palamod:textures/screens/paladium_ingot.png");
	private static final ResourceLocation IMAGE_10 = ResourceLocation.parse("palamod:textures/screens/fuel_crusher.png");
	private static final ResourceLocation IMAGE_11 = ResourceLocation.parse("palamod:textures/screens/no_plant_crusher.png");
	private static final ResourceLocation IMAGE_12 = ResourceLocation.parse("palamod:textures/screens/no_plant_crusher.png");
	private static final ResourceLocation IMAGE_13 = ResourceLocation.parse("palamod:textures/screens/no_plant_crusher.png");
	private static final ResourceLocation IMAGE_14 = ResourceLocation.parse("palamod:textures/screens/no_plant_crusher.png");
	private static final ResourceLocation IMAGE_15 = ResourceLocation.parse("palamod:textures/screens/delim_amethyst_crusher.png");
	private static final ResourceLocation IMAGE_16 = ResourceLocation.parse("palamod:textures/screens/delim_titane_crusher.png");
	private static final ResourceLocation IMAGE_17 = ResourceLocation.parse("palamod:textures/screens/delim_endium_crusher.png");
	private static final ResourceLocation IMAGE_18 = ResourceLocation.parse("palamod:textures/screens/delim_paladium_crusher.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("palamod:textures/screens/pgbar_ame_full.png");
	private static final ResourceLocation SPRITE_1 = ResourceLocation.parse("palamod:textures/screens/titane_pgbar_full.png");
	private static final ResourceLocation SPRITE_2 = ResourceLocation.parse("palamod:textures/screens/paladium_pgbar_full.png");
	private static final ResourceLocation SPRITE_3 = ResourceLocation.parse("palamod:textures/screens/pgbar_endium_v1.2.png");
	private static final ResourceLocation SPRITE_4 = ResourceLocation.parse("palamod:textures/screens/flamme_crusher_sprite.png");

	public CrusherguiScreen(CrusherguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 335;
		this.imageHeight = 205;
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
		if (mouseX > leftPos + 139 && mouseX < leftPos + 155 && mouseY > topPos + 99 && mouseY < topPos + 115) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.crushergui.tooltip_show_percentage_of_getting_a_ing"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 179 && mouseX < leftPos + 331 && mouseY > topPos + 121 && mouseY < topPos + 192) {
				guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.crushergui.tooltip_percentage_of_getting_an_ingot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (mouseX > leftPos + 112 && mouseX < leftPos + 136 && mouseY > topPos + 99 && mouseY < topPos + 115) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.crushergui.tooltip_enabledisable_pro_mode"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 159 && mouseX < leftPos + 177 && mouseY > topPos + 98 && mouseY < topPos + 116) {
				guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.crushergui.tooltip_output_slot"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z))
			if (mouseX > leftPos + 14 && mouseX < leftPos + 34 && mouseY > topPos + 87 && mouseY < topPos + 105) {
				guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.crushergui.tooltip_show_crusher_crafts"), mouseX, mouseY);
				customTooltipShown = true;
			}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 335, 205, 335, 205);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_1, this.leftPos + 177, this.topPos + 140, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_2, this.leftPos + 177, this.topPos + 158, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_3, this.leftPos + 177, this.topPos + 122, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_4, this.leftPos + 177, this.topPos + 176, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_5, this.leftPos + 7, this.topPos + 20, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_6, this.leftPos + 194, this.topPos + 19, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_7, this.leftPos + 197, this.topPos + 52, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_8, this.leftPos + 311, this.topPos + 52, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_9, this.leftPos + 311, this.topPos + 20, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_10, this.leftPos + 7, this.topPos + 56, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_11, this.leftPos + 101, this.topPos + 20, 0, 0, 92, 20, 92, 20);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_12, this.leftPos + 215, this.topPos + 20, 0, 0, 92, 20, 92, 20);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_13, this.leftPos + 101, this.topPos + 52, 0, 0, 92, 20, 92, 20);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_14, this.leftPos + 215, this.topPos + 52, 0, 0, 92, 20, 92, 20);
		if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_15, this.leftPos + 100, this.topPos + 19, 0, 0, 114, 32, 114, 32);
		}
		if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_16, this.leftPos + 100, this.topPos + 51, 0, 0, 114, 32, 114, 32);
		}
		if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_17, this.leftPos + 214, this.topPos + 51, 0, 0, 114, 32, 114, 32);
		}
		if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(RenderPipelines.GUI_TEXTURED, IMAGE_18, this.leftPos + 214, this.topPos + 19, 0, 0, 114, 32, 114, 32);
		}
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, this.leftPos + 198, this.topPos + 124, Mth.clamp((int) Crushersubprocessv3baramethystProcedure.execute(world, x, y, z) * 100, 0, 1600), 0, 100, 10, 1700, 10);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_1, this.leftPos + 198, this.topPos + 141, 0, 0, 100, 10, 3300, 10);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_2, this.leftPos + 198, this.topPos + 161, Mth.clamp((int) Crushersubprocessv3barpaladiumProcedure.execute(world, x, y, z) * 100, 0, 3200), 0, 100, 10, 3300, 10);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_3, this.leftPos + 198, this.topPos + 180, Mth.clamp((int) Crushersubprocessv3barendiumProcedure.execute(world, x, y, z) * 136, 0, 17272), 0, 136, 10, 17408, 10);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, SPRITE_4, this.leftPos + 7, this.topPos + 38, Mth.clamp((int) CrushersubprocessflamespritereturnProcedure.execute(world, x, y, z) * 16, 0, 144), 0, 16, 16, 160, 16);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_paladium_crusher"), 121, 3, -3407821, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_inventaire"), 14, 109, -1315861, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_fuel"), 27, 58, -3394816, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_fruits"), 26, 24, -3407668, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_v2004"), 299, 192, -1, false);
		if (Crushertextad4Procedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, CrushercustominfoameProcedure.execute(world, x, y, z), 101, 38, -1, false);
		if (Crushertextad3Procedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, CrushercustominfotitaneProcedure.execute(world, x, y, z), 100, 72, -1, false);
		if (Crushertextad2Procedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, CrushercustominfopaladiumProcedure.execute(world, x, y, z), 220, 38, -1, false);
		if (CrushertextadProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font, CrushercustominfoendiumProcedure.execute(world, x, y, z), 221, 72, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_button_white3 = new ImageButton(this.leftPos + 101, this.topPos + 52, 92, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_white.png"), ResourceLocation.parse("palamod:textures/screens/button_gray.png")), e -> {
					int x = CrusherguiScreen.this.x;
					int y = CrusherguiScreen.this.y;
					if (CrushershowlunchertitaneProcedure.execute(world, x, y, z)) {
						ClientPacketDistributor.sendToServer(new CrusherguiButtonMessage(0, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = CrusherguiScreen.this.x;
				int y = CrusherguiScreen.this.y;
				if (CrushershowlunchertitaneProcedure.execute(world, x, y, z))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_button_white3);
		imagebutton_button_white4 = new ImageButton(this.leftPos + 215, this.topPos + 52, 92, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_white.png"), ResourceLocation.parse("palamod:textures/screens/button_blue.png")), e -> {
					int x = CrusherguiScreen.this.x;
					int y = CrusherguiScreen.this.y;
					if (CrushershowluncherendiumProcedure.execute(world, x, y, z)) {
						ClientPacketDistributor.sendToServer(new CrusherguiButtonMessage(1, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = CrusherguiScreen.this.x;
				int y = CrusherguiScreen.this.y;
				if (CrushershowluncherendiumProcedure.execute(world, x, y, z))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_button_white4);
		imagebutton_button_white5 = new ImageButton(this.leftPos + 101, this.topPos + 20, 92, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_white.png"), ResourceLocation.parse("palamod:textures/screens/button_purple.png")), e -> {
					int x = CrusherguiScreen.this.x;
					int y = CrusherguiScreen.this.y;
					if (CrushershowluncheramethystProcedure.execute(world, x, y, z)) {
						ClientPacketDistributor.sendToServer(new CrusherguiButtonMessage(2, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = CrusherguiScreen.this.x;
				int y = CrusherguiScreen.this.y;
				if (CrushershowluncheramethystProcedure.execute(world, x, y, z))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_button_white5);
		imagebutton_button_white6 = new ImageButton(this.leftPos + 215, this.topPos + 20, 92, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/button_white.png"), ResourceLocation.parse("palamod:textures/screens/button_red.png")), e -> {
					int x = CrusherguiScreen.this.x;
					int y = CrusherguiScreen.this.y;
					if (CrushershowluncherpaladiumProcedure.execute(world, x, y, z)) {
						ClientPacketDistributor.sendToServer(new CrusherguiButtonMessage(3, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = CrusherguiScreen.this.x;
				int y = CrusherguiScreen.this.y;
				if (CrushershowluncherpaladiumProcedure.execute(world, x, y, z))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_button_white6);
		imagebutton_crusher_btn_pctg_on = new ImageButton(this.leftPos + 139, this.topPos + 99, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/crusher_btn_pctg_on.png"), ResourceLocation.parse("palamod:textures/screens/crusher_btn_pctg_on_hover.png")), e -> {
					int x = CrusherguiScreen.this.x;
					int y = CrusherguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new CrusherguiButtonMessage(4, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_crusher_btn_pctg_on);
		imagebutton_pro_mode_crusher = new ImageButton(this.leftPos + 112, this.topPos + 99, 24, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/pro_mode_crusher.png"), ResourceLocation.parse("palamod:textures/screens/pro_mode_crusher_hover.png")), e -> {
					int x = CrusherguiScreen.this.x;
					int y = CrusherguiScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new CrusherguiButtonMessage(5, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_pro_mode_crusher);
		imagebutton_book_button = new ImageButton(this.leftPos + 14, this.topPos + 87, 20, 18,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/book_button.png"), ResourceLocation.parse("palamod:textures/screens/book_button_hover.png")), e -> {
					int x = CrusherguiScreen.this.x;
					int y = CrusherguiScreen.this.y;
					if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z)) {
						ClientPacketDistributor.sendToServer(new CrusherguiButtonMessage(6, x, y, z));
						CrusherguiButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = CrusherguiScreen.this.x;
				int y = CrusherguiScreen.this.y;
				if (IscrushercrusherpromodefalseProcedure.execute(world, x, y, z))
					guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_book_button);
	}
}
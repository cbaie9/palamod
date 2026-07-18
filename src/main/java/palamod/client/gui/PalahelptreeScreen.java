package palamod.client.gui;

import palamod.world.inventory.PalahelptreeMenu;

import palamod.procedures.TRADreturntosumarryProcedure;
import palamod.procedures.GetImagePalahelpTreeProcedure;

import palamod.network.PalahelptreeButtonMessage;

import palamod.init.PalamodModScreens;

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
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class PalahelptreeScreen extends AbstractContainerScreen<PalahelptreeMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_palahelp_right_off;
	private ImageButton imagebutton_judeecercis_sapling;
	private ImageButton imagebutton_sapjacaranda;
	private ImageButton imagebutton_saperable;
	private ImageButton imagebutton_sapostrya;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/jacaranda_log.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/judeecercis_log.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/erable_log.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/ostrya_log.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("palamod:textures/screens/palahelp_tree.png");

	public PalahelptreeScreen(PalahelptreeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 220;
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
		if (mouseX > leftPos + -31 && mouseX < leftPos + 22 && mouseY > topPos + 24 && mouseY < topPos + 46) {
			if (Component.translatable("gui.palamod.palahelptree.tooltip_can_be_extracted_to_make_jacaran").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelptree.tooltip_can_be_extracted_to_make_jacaran").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -31 && mouseX < leftPos + 22 && mouseY > topPos + 49 && mouseY < topPos + 71) {
			if (Component.translatable("gui.palamod.palahelptree.tooltip_judeecercis").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelptree.tooltip_judeecercis").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -31 && mouseX < leftPos + 22 && mouseY > topPos + 79 && mouseY < topPos + 103) {
			if (Component.translatable("gui.palamod.palahelptree.tooltip_erable").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelptree.tooltip_erable").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -31 && mouseX < leftPos + 22 && mouseY > topPos + 111 && mouseY < topPos + 136) {
			if (Component.translatable("gui.palamod.palahelptree.tooltip_ostrya").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelptree.tooltip_ostrya").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -32 && mouseX < leftPos + -10 && mouseY > topPos + -10 && mouseY < topPos + 10) {
			if (TRADreturntosumarryProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(TRADreturntosumarryProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 213 && mouseX < leftPos + 253 && mouseY > topPos + 136 && mouseY < topPos + 159) {
			if (Component.translatable("gui.palamod.palahelptree.tooltip_go_to_palahelp_ore_and_liquids").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelptree.tooltip_go_to_palahelp_ore_and_liquids").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + -32 && mouseX < leftPos + 12 && mouseY > topPos + 138 && mouseY < topPos + 161) {
			if (TRADreturntosumarryProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(TRADreturntosumarryProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + -49, this.topPos + -10, 0, 0, 320, 180, 320, 180);
		guiGraphics.blit(IMAGE_1, this.leftPos + -28, this.topPos + 27, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_2, this.leftPos + -28, this.topPos + 53, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_3, this.leftPos + -28, this.topPos + 85, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(IMAGE_4, this.leftPos + -28, this.topPos + 117, 0, 0, 16, 16, 16, 16);
		guiGraphics.blit(SPRITE_0, this.leftPos + 131, this.topPos + 12, Mth.clamp((int) GetImagePalahelpTreeProcedure.execute(entity) * 115, 0, 345), 0, 115, 115, 460, 115);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelptree.label_palahelp_trees").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, -2, 7 + yOffset, -13421773, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + -28, this.topPos + -10, 14, 18,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png"), ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png")), e -> {
					int x = PalahelptreeScreen.this.x;
					int y = PalahelptreeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelptreeButtonMessage(0, x, y, z));
						PalahelptreeButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + -31, this.topPos + 140, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_on.png")), e -> {
					int x = PalahelptreeScreen.this.x;
					int y = PalahelptreeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelptreeButtonMessage(1, x, y, z));
						PalahelptreeButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 255, this.topPos + -10, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = PalahelptreeScreen.this.x;
					int y = PalahelptreeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelptreeButtonMessage(2, x, y, z));
						PalahelptreeButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_palahelp_right_off = new ImageButton(this.leftPos + 215, this.topPos + 138, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_right_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_right_on.png")), e -> {
					int x = PalahelptreeScreen.this.x;
					int y = PalahelptreeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelptreeButtonMessage(3, x, y, z));
						PalahelptreeButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_palahelp_right_off);
		imagebutton_judeecercis_sapling = new ImageButton(this.leftPos + -1, this.topPos + 53, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/judeecercis_sapling.png"), ResourceLocation.parse("palamod:textures/screens/judeecercis_sappling_on.png")), e -> {
					int x = PalahelptreeScreen.this.x;
					int y = PalahelptreeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelptreeButtonMessage(4, x, y, z));
						PalahelptreeButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_judeecercis_sapling);
		imagebutton_sapjacaranda = new ImageButton(this.leftPos + 1, this.topPos + 27, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sap.jacaranda.png"), ResourceLocation.parse("palamod:textures/screens/jacaranda_sappling_on.png")), e -> {
					int x = PalahelptreeScreen.this.x;
					int y = PalahelptreeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelptreeButtonMessage(5, x, y, z));
						PalahelptreeButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_sapjacaranda);
		imagebutton_saperable = new ImageButton(this.leftPos + 0, this.topPos + 85, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sap.erable.png"), ResourceLocation.parse("palamod:textures/screens/erable_sappling_on.png")), e -> {
					int x = PalahelptreeScreen.this.x;
					int y = PalahelptreeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelptreeButtonMessage(6, x, y, z));
						PalahelptreeButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_saperable);
		imagebutton_sapostrya = new ImageButton(this.leftPos + -2, this.topPos + 117, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sap.ostrya.png"), ResourceLocation.parse("palamod:textures/screens/ostrya_sappling.png")), e -> {
					int x = PalahelptreeScreen.this.x;
					int y = PalahelptreeScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelptreeButtonMessage(7, x, y, z));
						PalahelptreeButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_sapostrya);
	}
}
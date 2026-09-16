package palamod.client.gui;

import palamod.world.inventory.PalahelpnewPalamachineMenu;

import palamod.procedures.GetDescriptionPalamachinePalahelpProcedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.PalahelpnewPalamachineButtonMessage;

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

public class PalahelpnewPalamachineScreen extends AbstractContainerScreen<PalahelpnewPalamachineMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_adminshop;
	private ImageButton imagebutton_home_pixel_adminshop;
	private ImageButton imagebutton_speed_stick;
	private ImageButton imagebutton_jump_stick2;
	private ImageButton imagebutton_hyperjump_stick;
	private ImageButton imagebutton_heal_stick;
	private ImageButton imagebutton_damage_stick;
	private ImageButton imagebutton_strenghtstick;
	private ImageButton imagebutton_stickofgod;
	private ImageButton imagebutton_endium_medium_ring;
	private ImageButton imagebutton_endium_big_ring;
	private ImageButton imagebutton_unclaimfinder;
	private ImageButton imagebutton_unclaimfinder_orange;
	private ImageButton imagebutton_unclaimfinder_red;
	private ImageButton imagebutton_unclaimfinder_precise;
	private ImageButton imagebutton_heal_stick1;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/sticknewhelp.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/left_gray_line.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/right_gray_line.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("palamod:textures/screens/arrow_right_furnace_sprite.png");

	public PalahelpnewPalamachineScreen(PalahelpnewPalamachineMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 225;
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
		if (mouseX > leftPos + 379 && mouseX < leftPos + 395 && mouseY > topPos + 4 && mouseY < topPos + 20) {
			if (ClosetheguitransProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(ClosetheguitransProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 284 && mouseX < leftPos + 301 && mouseY > topPos + 81 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_go_to_palahelp").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_go_to_palahelp").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 42 && mouseX < leftPos + 60 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_paladium_small_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_paladium_small_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 61 && mouseX < leftPos + 79 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_paladium_medium_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_paladium_medium_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 80 && mouseX < leftPos + 98 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_paladium_big_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_paladium_big_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 99 && mouseX < leftPos + 116 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_green_paladium_small_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_green_paladium_small_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 117 && mouseX < leftPos + 135 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_green_paladium_medium_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_green_paladium_medium_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 136 && mouseX < leftPos + 154 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_green_paladium_big_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_green_paladium_big_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 155 && mouseX < leftPos + 173 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_endium_small_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_endium_small_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 174 && mouseX < leftPos + 192 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_endium_medium_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_endium_medium_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 193 && mouseX < leftPos + 211 && mouseY > topPos + 86 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_endium_big_ring").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_endium_big_ring").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 212 && mouseX < leftPos + 229 && mouseY > topPos + 81 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_green_unclaim_finder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_green_unclaim_finder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 230 && mouseX < leftPos + 247 && mouseY > topPos + 81 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_orange_unclaim_finder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_orange_unclaim_finder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 248 && mouseX < leftPos + 265 && mouseY > topPos + 81 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_red_unclaim_finder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_red_unclaim_finder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 266 && mouseX < leftPos + 283 && mouseY > topPos + 81 && mouseY < topPos + 98) {
			if (Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_blue_unclaim_finder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.tooltip_blue_unclaim_finder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 400, 225, 400, 225);
		guiGraphics.blit(IMAGE_1, this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_2, this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_3, this.leftPos + 199, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_4, this.leftPos + 300, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(IMAGE_5, this.leftPos + 260, this.topPos + 0, 0, 0, 100, 24, 100, 24);
		guiGraphics.blit(SPRITE_0, this.leftPos + 333, this.topPos + 143, 0, 0, 22, 15, 506, 15);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.label_palahelp_stick").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 158, 8 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.label_effect_of_the_stick").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 26 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.label_palamachine").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 61, 106 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_palamachine.label_craft").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 5, 88 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetDescriptionPalamachinePalahelpProcedure.execute(entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 4, 59 + yOffset, -1, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 379, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(0, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 359, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/arrow_adminshop_poi.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(1, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 342, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/home_pixel_adminshop.png"), ResourceLocation.parse("palamod:textures/screens/pointec_home_pixel_adminshop.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(2, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_speed_stick = new ImageButton(this.leftPos + 43, this.topPos + 84, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/paladium_small_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_small_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(3, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_speed_stick);
		imagebutton_jump_stick2 = new ImageButton(this.leftPos + 62, this.topPos + 84, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/paladium_medium_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_medium_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(4, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jump_stick2);
		imagebutton_hyperjump_stick = new ImageButton(this.leftPos + 81, this.topPos + 85, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/paladium_big_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_big_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(5, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_hyperjump_stick);
		imagebutton_heal_stick = new ImageButton(this.leftPos + 100, this.topPos + 84, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/green_paladium_small_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_small_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(6, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heal_stick);
		imagebutton_damage_stick = new ImageButton(this.leftPos + 118, this.topPos + 84, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/green_paladium_medium_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_medium_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(7, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_damage_stick);
		imagebutton_strenghtstick = new ImageButton(this.leftPos + 137, this.topPos + 85, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/green_paladium_big_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_big_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(8, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_strenghtstick);
		imagebutton_stickofgod = new ImageButton(this.leftPos + 156, this.topPos + 84, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/endium_small_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_small_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(9, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_stickofgod);
		imagebutton_endium_medium_ring = new ImageButton(this.leftPos + 175, this.topPos + 84, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/endium_medium_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_medium_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(10, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_endium_medium_ring);
		imagebutton_endium_big_ring = new ImageButton(this.leftPos + 194, this.topPos + 85, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/endium_big_ring.png"), ResourceLocation.parse("palamod:textures/screens/white_big_ring.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(11, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_endium_big_ring);
		imagebutton_unclaimfinder = new ImageButton(this.leftPos + 213, this.topPos + 82, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/unclaimfinder.png"), ResourceLocation.parse("palamod:textures/screens/white_unclaim_finder.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(12, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_unclaimfinder);
		imagebutton_unclaimfinder_orange = new ImageButton(this.leftPos + 231, this.topPos + 82, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/unclaimfinder_orange.png"), ResourceLocation.parse("palamod:textures/screens/white_unclaim_finder.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(13, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_unclaimfinder_orange);
		imagebutton_unclaimfinder_red = new ImageButton(this.leftPos + 249, this.topPos + 82, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/unclaimfinder_red.png"), ResourceLocation.parse("palamod:textures/screens/white_unclaim_finder.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(14, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_unclaimfinder_red);
		imagebutton_unclaimfinder_precise = new ImageButton(this.leftPos + 267, this.topPos + 82, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/unclaimfinder_precise.png"), ResourceLocation.parse("palamod:textures/screens/white_unclaim_finder.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(15, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 15, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_unclaimfinder_precise);
		imagebutton_heal_stick1 = new ImageButton(this.leftPos + 284, this.topPos + 82, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/heal_stick.png"), ResourceLocation.parse("palamod:textures/screens/heal_stick_hover_poi.png")), e -> {
					int x = PalahelpnewPalamachineScreen.this.x;
					int y = PalahelpnewPalamachineScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewPalamachineButtonMessage(16, x, y, z));
						PalahelpnewPalamachineButtonMessage.handleButtonAction(entity, 16, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heal_stick1);
	}
}
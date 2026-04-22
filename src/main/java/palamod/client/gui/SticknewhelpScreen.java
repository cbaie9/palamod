package palamod.client.gui;

import palamod.world.inventory.SticknewhelpMenu;

import palamod.procedures.Getlabelnewstick1Procedure;
import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.SticknewhelpButtonMessage;

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

public class SticknewhelpScreen extends AbstractContainerScreen<SticknewhelpMenu> implements PalamodModScreens.ScreenAccessor {
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
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/sticknewhelp.png");
	private static final ResourceLocation IMAGE_1 = ResourceLocation.parse("palamod:textures/screens/left_gray_line.png");
	private static final ResourceLocation IMAGE_2 = ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png");
	private static final ResourceLocation IMAGE_3 = ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png");
	private static final ResourceLocation IMAGE_4 = ResourceLocation.parse("palamod:textures/screens/right_gray_line.png");
	private static final ResourceLocation IMAGE_5 = ResourceLocation.parse("palamod:textures/screens/arrow_new.png");
	private static final ResourceLocation IMAGE_6 = ResourceLocation.parse("palamod:textures/screens/mid_gray_line.png");

	public SticknewhelpScreen(SticknewhelpMenu container, Inventory inventory, Component text) {
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
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_5, this.leftPos + 331, this.topPos + 144, 0, 0, 24, 10, 24, 10);
		guiGraphics.blit(IMAGE_6, this.leftPos + 260, this.topPos + 0, 0, 0, 100, 24, 100, 24);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.sticknewhelp.label_palahelp_stick"), 158, 8, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.sticknewhelp.label_effect_of_the_stick"), 4, 26, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.sticknewhelp.label_palamachine"), 61, 106, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.sticknewhelp.label_craft"), 3, 83, -12829636, false);
		guiGraphics.drawString(this.font, Getlabelnewstick1Procedure.execute(world, entity), 5, 39, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 379, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(0, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 0, x, y, z);
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
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(1, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 1, x, y, z);
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
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(2, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);
		imagebutton_speed_stick = new ImageButton(this.leftPos + 6, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/speed_stick.png"), ResourceLocation.parse("palamod:textures/screens/speed_stick_hover_poi.png")), e -> {
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(3, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_speed_stick);
		imagebutton_jump_stick2 = new ImageButton(this.leftPos + 23, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/jump_stick2.png"), ResourceLocation.parse("palamod:textures/screens/jump_stick_hover_poi.png")), e -> {
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(4, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jump_stick2);
		imagebutton_hyperjump_stick = new ImageButton(this.leftPos + 42, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/hyperjump_stick.png"), ResourceLocation.parse("palamod:textures/screens/hyper_jump_stick_hover_poi.png")), e -> {
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(5, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_hyperjump_stick);
		imagebutton_heal_stick = new ImageButton(this.leftPos + 61, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/heal_stick.png"), ResourceLocation.parse("palamod:textures/screens/heal_stick_hover_poi.png")), e -> {
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(6, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_heal_stick);
		imagebutton_damage_stick = new ImageButton(this.leftPos + 79, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/damage_stick.png"), ResourceLocation.parse("palamod:textures/screens/damage_stick_hover_poi.png")), e -> {
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(7, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_damage_stick);
		imagebutton_strenghtstick = new ImageButton(this.leftPos + 95, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/strenghtstick.png"), ResourceLocation.parse("palamod:textures/screens/strenght_stick_hover_poi.png")), e -> {
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(8, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_strenghtstick);
		imagebutton_stickofgod = new ImageButton(this.leftPos + 113, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/stickofgod.png"), ResourceLocation.parse("palamod:textures/screens/stick_of_gods_hover_poi.png")), e -> {
					int x = SticknewhelpScreen.this.x;
					int y = SticknewhelpScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new SticknewhelpButtonMessage(9, x, y, z));
						SticknewhelpButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_stickofgod);
	}
}
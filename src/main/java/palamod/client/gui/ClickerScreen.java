package palamod.client.gui;

import palamod.world.inventory.ClickerMenu;

import palamod.procedures.ClickerprintcoinsProcedure;

import palamod.network.ClickerButtonMessage;

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

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ClickerScreen extends AbstractContainerScreen<ClickerMenu> {
	private final static HashMap<String, Object> guistate = ClickerMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_clicker_build_hive;
	ImageButton imagebutton_clicker_skip;
	ImageButton imagebutton_clicker_build_cave;
	ImageButton imagebutton_clicker_build_mine;
	ImageButton imagebutton_clicker_build_dwarf;
	ImageButton imagebutton_clicker_close_btn;
	ImageButton imagebutton_clicker_build_garden;
	ImageButton imagebutton_clicker_build_witch;
	ImageButton imagebutton_clicker_potato_btn_v11;
	ImageButton imagebutton_clicker_morebuild;

	public ClickerScreen(ClickerMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 360;
		this.imageHeight = 210;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("palamod:textures/screens/clicker.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_paterne.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 360, 210, 360, 210);

		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/clicker_v1.11.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 360, 210, 360, 210);

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
		guiGraphics.drawString(this.font,

				ClickerprintcoinsProcedure.execute(world, entity), 12, 44, -1, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_clicker_build_hive = new ImageButton(this.leftPos + 260, this.topPos + 156, 88, 21,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_build_hive.png"), ResourceLocation.parse("palamod:textures/screens/clicker_build_hive_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_build_hive", imagebutton_clicker_build_hive);
		this.addRenderableWidget(imagebutton_clicker_build_hive);
		imagebutton_clicker_skip = new ImageButton(this.leftPos + 229, this.topPos + 184, 12, 12,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_skip.png"), ResourceLocation.parse("palamod:textures/screens/clicker_skip.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_skip", imagebutton_clicker_skip);
		this.addRenderableWidget(imagebutton_clicker_skip);
		imagebutton_clicker_build_cave = new ImageButton(this.leftPos + 260, this.topPos + 60, 88, 21,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_build_cave.png"), ResourceLocation.parse("palamod:textures/screens/clicker_build_cave_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_build_cave", imagebutton_clicker_build_cave);
		this.addRenderableWidget(imagebutton_clicker_build_cave);
		imagebutton_clicker_build_mine = new ImageButton(this.leftPos + 260, this.topPos + 36, 88, 21,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_build_mine.png"), ResourceLocation.parse("palamod:textures/screens/clicker_build_mine_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_build_mine", imagebutton_clicker_build_mine);
		this.addRenderableWidget(imagebutton_clicker_build_mine);
		imagebutton_clicker_build_dwarf = new ImageButton(this.leftPos + 260, this.topPos + 84, 88, 21,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_build_dwarf.png"), ResourceLocation.parse("palamod:textures/screens/clicker_build_dwarf_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_build_dwarf", imagebutton_clicker_build_dwarf);
		this.addRenderableWidget(imagebutton_clicker_build_dwarf);
		imagebutton_clicker_close_btn = new ImageButton(this.leftPos + 336, this.topPos + 6, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/close_gui_nohover.png"), ResourceLocation.parse("palamod:textures/screens/close_gui_hover.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ClickerButtonMessage(5, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_close_btn", imagebutton_clicker_close_btn);
		this.addRenderableWidget(imagebutton_clicker_close_btn);
		imagebutton_clicker_build_garden = new ImageButton(this.leftPos + 260, this.topPos + 108, 88, 21,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_build_garden.png"), ResourceLocation.parse("palamod:textures/screens/clicker_build_garden_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_build_garden", imagebutton_clicker_build_garden);
		this.addRenderableWidget(imagebutton_clicker_build_garden);
		imagebutton_clicker_build_witch = new ImageButton(this.leftPos + 260, this.topPos + 132, 88, 21,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_build_witch.png"), ResourceLocation.parse("palamod:textures/screens/clicker_build_witch_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_build_witch", imagebutton_clicker_build_witch);
		this.addRenderableWidget(imagebutton_clicker_build_witch);
		imagebutton_clicker_potato_btn_v11 = new ImageButton(this.leftPos + 11, this.topPos + 60, 91, 139,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_potato_btn_v1.1.png"), ResourceLocation.parse("palamod:textures/screens/clicker_potato_btn_v1.1.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new ClickerButtonMessage(8, x, y, z));
						ClickerButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_potato_btn_v11", imagebutton_clicker_potato_btn_v11);
		this.addRenderableWidget(imagebutton_clicker_potato_btn_v11);
		imagebutton_clicker_morebuild = new ImageButton(this.leftPos + 261, this.topPos + 180, 86, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/clicker_more-build.png"), ResourceLocation.parse("palamod:textures/screens/clicker_more_build_hover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_clicker_morebuild", imagebutton_clicker_morebuild);
		this.addRenderableWidget(imagebutton_clicker_morebuild);
	}
}

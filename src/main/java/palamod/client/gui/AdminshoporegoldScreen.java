package palamod.client.gui;

import palamod.world.inventory.AdminshoporegoldMenu;

import palamod.procedures.ReturnadminshopmainmenuProcedure;
import palamod.procedures.ClosetheguitransProcedure;
import palamod.procedures.AdshoppreviewamountgoldProcedure;

import palamod.network.AdminshoporegoldButtonMessage;

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
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdminshoporegoldScreen extends AbstractContainerScreen<AdminshoporegoldMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private EditBox number_buy;
	private Button button_buy;
	private Button button_sell;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_arrow_adminshop;

	public AdminshoporegoldScreen(AdminshoporegoldMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("number_buy"))
				number_buy.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		number_buy.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 138 && mouseX < leftPos + 153 && mouseY > topPos + 5 && mouseY < topPos + 20) {
			String hoverText = ReturnadminshopmainmenuProcedure.execute();
			if (hoverText != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 155 && mouseX < leftPos + 171 && mouseY > topPos + 4 && mouseY < topPos + 20) {
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
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/gui176_166.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (number_buy.isFocused())
			return number_buy.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String number_buyValue = number_buy.getValue();
		super.resize(minecraft, width, height);
		number_buy.setValue(number_buyValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshoporegold.label_gold"), 72, 7, -1, false);
		guiGraphics.drawString(this.font, AdshoppreviewamountgoldProcedure.execute(world, entity), 29, 74, -4671036, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshoporegold.label_sell_price_30"), 41, 27, -4671036, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshoporegold.label_buy_price_35"), 47, 42, -4671036, false);
	}

	@Override
	public void init() {
		super.init();
		number_buy = new EditBox(this.font, this.leftPos + 27, this.topPos + 88, 118, 18, Component.translatable("gui.palamod.adminshoporegold.number_buy"));
		number_buy.setMaxLength(8192);
		number_buy.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "number_buy", content, false);
		});
		number_buy.setHint(Component.translatable("gui.palamod.adminshoporegold.number_buy"));
		this.addWidget(this.number_buy);
		button_buy = Button.builder(Component.translatable("gui.palamod.adminshoporegold.button_buy"), e -> {
			int x = AdminshoporegoldScreen.this.x;
			int y = AdminshoporegoldScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporegoldButtonMessage(0, x, y, z));
				AdminshoporegoldButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 26, this.topPos + 108, 40, 20).build();
		this.addRenderableWidget(button_buy);
		button_sell = Button.builder(Component.translatable("gui.palamod.adminshoporegold.button_sell"), e -> {
			int x = AdminshoporegoldScreen.this.x;
			int y = AdminshoporegoldScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new AdminshoporegoldButtonMessage(1, x, y, z));
				AdminshoporegoldButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 100, this.topPos + 108, 46, 20).build();
		this.addRenderableWidget(button_sell);
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 155, this.topPos + 4, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshoporegoldScreen.this.x;
					int y = AdminshoporegoldScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshoporegoldButtonMessage(2, x, y, z));
						AdminshoporegoldButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 137, this.topPos + 4, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_back_true_1.png"), ResourceLocation.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
					int x = AdminshoporegoldScreen.this.x;
					int y = AdminshoporegoldScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshoporegoldButtonMessage(3, x, y, z));
						AdminshoporegoldButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_adminshop);
	}
}
package palamod.client.gui;

import palamod.world.inventory.AdminshopmenuMenu;

import palamod.procedures.*;

import palamod.network.AdminshopmenuButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;

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

public class AdminshopmenuScreen extends AbstractContainerScreen<AdminshopmenuMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_adminshop_new_placeholder;
	private ImageButton imagebutton_adminshop_new_placeholder1;
	private ImageButton imagebutton_adminshop_new_placeholder2;
	private ImageButton imagebutton_adminshop_new_placeholder3;
	private ImageButton imagebutton_adminshop_new_placeholder4;
	private ImageButton imagebutton_adminshop_new_placeholder5;
	private ImageButton imagebutton_adminshop_new_placeholder6;
	private ImageButton imagebutton_adminshop_new_placeholder7;
	private ImageButton imagebutton_adminshop_new_placeholder8;
	private ImageButton imagebutton_adminshop_new_placeholder9;
	private ImageButton imagebutton_adminshop_new_placeholder10;
	private ImageButton imagebutton_adminshop_new_placeholder11;
	private ImageButton imagebutton_adminshop_new_placeholder12;
	private ImageButton imagebutton_adminshop_new_placeholder13;
	private ImageButton imagebutton_adminshop_new_placeholder14;
	private ImageButton imagebutton_adminshop_new_placeholder15;
	private ImageButton imagebutton_adminshop_new_placeholder16;
	private ImageButton imagebutton_adminshop_new_placeholder17;
	private ImageButton imagebutton_adminshop_new_placeholder18;
	private ImageButton imagebutton_adminshop_new_placeholder19;
	private ImageButton imagebutton_adminshop_new_placeholder20;
	private ExtendedSlider slider;

	public AdminshopmenuScreen(AdminshopmenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
		this.imageHeight = 200;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 2 && elementState instanceof Number n) {
			if (name.equals("slider"))
				slider.setValue(n.doubleValue());
		}
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 280 && mouseX < leftPos + 296 && mouseY > topPos + 17 && mouseY < topPos + 33) {
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
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/adminshopmenu.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 300, 200, 300, 200);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 20, this.topPos + 42, Mth.clamp((int) Adminshopcol1adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 56, this.topPos + 42, Mth.clamp((int) Adminshopcol2adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 92, this.topPos + 42, Mth.clamp((int) Adminshopcol3adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 128, this.topPos + 42, Mth.clamp((int) Adminshopcol4adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 164, this.topPos + 42, Mth.clamp((int) Adminshopcol5adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 200, this.topPos + 42, Mth.clamp((int) Adminshopcol6adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 236, this.topPos + 42, Mth.clamp((int) Adminshopcol7adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 20, this.topPos + 90, Mth.clamp((int) Adminshopcol1adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 56, this.topPos + 90, Mth.clamp((int) Adminshopcol2adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 92, this.topPos + 90, Mth.clamp((int) Adminshopcol3adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 128, this.topPos + 90, Mth.clamp((int) Adminshopcol4adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 164, this.topPos + 90, Mth.clamp((int) Adminshopcol5adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 200, this.topPos + 90, Mth.clamp((int) Adminshopcol6adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 236, this.topPos + 90, Mth.clamp((int) Adminshopcol7adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 20, this.topPos + 138, Mth.clamp((int) Adminshopcol1adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 56, this.topPos + 138, Mth.clamp((int) Adminshopcol2adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 92, this.topPos + 138, Mth.clamp((int) Adminshopcol3adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 128, this.topPos + 138, Mth.clamp((int) Adminshopcol4adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 164, this.topPos + 138, Mth.clamp((int) Adminshopcol5adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 200, this.topPos + 138, Mth.clamp((int) Adminshopcol6adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 236, this.topPos + 138, Mth.clamp((int) Adminshopcol7adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
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
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		return (this.getFocused() != null && this.isDragging() && button == 0) ? this.getFocused().mouseDragged(mouseX, mouseY, button, dragX, dragY) : super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 280, this.topPos + 17, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(0, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_adminshop_new_placeholder = new ImageButton(this.leftPos + 16, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(1, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder);
		imagebutton_adminshop_new_placeholder1 = new ImageButton(this.leftPos + 16, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(2, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder1);
		imagebutton_adminshop_new_placeholder2 = new ImageButton(this.leftPos + 16, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(3, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder2);
		imagebutton_adminshop_new_placeholder3 = new ImageButton(this.leftPos + 52, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(4, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder3);
		imagebutton_adminshop_new_placeholder4 = new ImageButton(this.leftPos + 52, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(5, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder4);
		imagebutton_adminshop_new_placeholder5 = new ImageButton(this.leftPos + 52, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(6, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder5);
		imagebutton_adminshop_new_placeholder6 = new ImageButton(this.leftPos + 88, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(7, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder6);
		imagebutton_adminshop_new_placeholder7 = new ImageButton(this.leftPos + 88, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(8, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder7);
		imagebutton_adminshop_new_placeholder8 = new ImageButton(this.leftPos + 88, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(9, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder8);
		imagebutton_adminshop_new_placeholder9 = new ImageButton(this.leftPos + 124, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(10, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder9);
		imagebutton_adminshop_new_placeholder10 = new ImageButton(this.leftPos + 124, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(11, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder10);
		imagebutton_adminshop_new_placeholder11 = new ImageButton(this.leftPos + 124, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(12, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder11);
		imagebutton_adminshop_new_placeholder12 = new ImageButton(this.leftPos + 160, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(13, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder12);
		imagebutton_adminshop_new_placeholder13 = new ImageButton(this.leftPos + 160, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(14, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder13);
		imagebutton_adminshop_new_placeholder14 = new ImageButton(this.leftPos + 160, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(15, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 15, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder14);
		imagebutton_adminshop_new_placeholder15 = new ImageButton(this.leftPos + 196, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(16, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 16, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder15);
		imagebutton_adminshop_new_placeholder16 = new ImageButton(this.leftPos + 196, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(17, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 17, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder16);
		imagebutton_adminshop_new_placeholder17 = new ImageButton(this.leftPos + 196, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(18, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 18, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder17);
		imagebutton_adminshop_new_placeholder18 = new ImageButton(this.leftPos + 232, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(19, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 19, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder18);
		imagebutton_adminshop_new_placeholder19 = new ImageButton(this.leftPos + 232, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(20, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 20, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder19);
		imagebutton_adminshop_new_placeholder20 = new ImageButton(this.leftPos + 232, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new AdminshopmenuButtonMessage(21, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 21, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder20);
		slider = new ExtendedSlider(this.leftPos + 13, this.topPos + 168, 275, 20, Component.translatable("gui.palamod.adminshopmenu.slider_prefix"), Component.translatable("gui.palamod.adminshopmenu.slider_suffix"), 0, 10, 0, 1, 0, true) {
			@Override
			protected void applyValue() {
				if (!menuStateUpdateActive)
					menu.sendMenuStateUpdate(entity, 2, "slider", this.getValue(), false);
			}
		};
		this.addRenderableWidget(slider);
		if (!menuStateUpdateActive)
			menu.sendMenuStateUpdate(entity, 2, "slider", slider.getValue(), false);
	}
}
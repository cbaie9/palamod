package palamod.client.gui;

import palamod.world.inventory.AdminshopmenuMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.network.AdminshopmenuButtonMessage;

import palamod.init.PalamodModScreens;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
<<<<<<< Updated upstream
=======
import net.neoforged.neoforge.client.gui.widget.ExtendedSlider;
>>>>>>> Stashed changes

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

public class AdminshopmenuScreen extends AbstractContainerScreen<AdminshopmenuMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_cross_no_button;
	private ImageButton imagebutton_admin_btte_ore;
	private ImageButton imagebutton_btte_block;
	private ImageButton imagebutton_btte_plant;
	private ImageButton imagebutton_btte_mobs;
	private ImageButton imagebutton_btte_utilities;

	public AdminshopmenuScreen(AdminshopmenuMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 177;
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
		if (mouseX > leftPos + 154 && mouseX < leftPos + 170 && mouseY > topPos + 5 && mouseY < topPos + 21) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.setComponentTooltipForNextFrame(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
<<<<<<< Updated upstream
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/gui176_166.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 166, 176, 166);
=======
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/adminshopmenu.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 300, 200, 300, 200);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 20, this.topPos + 42, Mth.clamp((int) Adminshopcol1adminshopgetspriteProcedure.execute(entity) * 16, 0, 256),
				0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 56, this.topPos + 42, Mth.clamp((int) Adminshopcol2adminshopgetspriteProcedure.execute(entity) * 16, 0, 256),
				0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 92, this.topPos + 42, Mth.clamp((int) Adminshopcol3adminshopgetspriteProcedure.execute(entity) * 16, 0, 256),
				0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 128, this.topPos + 42,
				Mth.clamp((int) Adminshopcol4adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 164, this.topPos + 42,
				Mth.clamp((int) Adminshopcol5adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 200, this.topPos + 42,
				Mth.clamp((int) Adminshopcol6adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row1_v1.png"), this.leftPos + 236, this.topPos + 42,
				Mth.clamp((int) Adminshopcol7adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 20, this.topPos + 90, Mth.clamp((int) Adminshopcol1adminshopgetspriteProcedure.execute(entity) * 16, 0, 256),
				0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 56, this.topPos + 90, Mth.clamp((int) Adminshopcol2adminshopgetspriteProcedure.execute(entity) * 16, 0, 256),
				0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 92, this.topPos + 90, Mth.clamp((int) Adminshopcol3adminshopgetspriteProcedure.execute(entity) * 16, 0, 256),
				0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 128, this.topPos + 90,
				Mth.clamp((int) Adminshopcol4adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 164, this.topPos + 90,
				Mth.clamp((int) Adminshopcol5adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 200, this.topPos + 90,
				Mth.clamp((int) Adminshopcol6adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row2_v1.png"), this.leftPos + 236, this.topPos + 90,
				Mth.clamp((int) Adminshopcol7adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 20, this.topPos + 138,
				Mth.clamp((int) Adminshopcol1adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 56, this.topPos + 138,
				Mth.clamp((int) Adminshopcol2adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 92, this.topPos + 138,
				Mth.clamp((int) Adminshopcol3adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 128, this.topPos + 138,
				Mth.clamp((int) Adminshopcol4adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 164, this.topPos + 138,
				Mth.clamp((int) Adminshopcol5adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 200, this.topPos + 138,
				Mth.clamp((int) Adminshopcol6adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
		guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ResourceLocation.parse("palamod:textures/screens/sprite_row3_v1.png"), this.leftPos + 236, this.topPos + 138,
				Mth.clamp((int) Adminshopcol7adminshopgetspriteProcedure.execute(entity) * 16, 0, 256), 0, 16, 16, 272, 16);
>>>>>>> Stashed changes
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.adminshopmenu.label_adminshop"), 60, 7, -65536, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 5, 16, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/cross_no_button.png"), ResourceLocation.parse("palamod:textures/screens/pointed_cross_no_button.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(0, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_cross_no_button);
		imagebutton_admin_btte_ore = new ImageButton(this.leftPos + 60, this.topPos + 61, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_ore_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_ore_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(1, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_admin_btte_ore);
		imagebutton_btte_block = new ImageButton(this.leftPos + 60, this.topPos + 32, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_block_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_block_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(2, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_btte_block);
		imagebutton_btte_plant = new ImageButton(this.leftPos + 60, this.topPos + 87, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_plant_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_plant_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(3, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_btte_plant);
		imagebutton_btte_mobs = new ImageButton(this.leftPos + 61, this.topPos + 114, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_mobs_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_mobs_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(4, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_btte_mobs);
		imagebutton_btte_utilities = new ImageButton(this.leftPos + 61, this.topPos + 141, 48, 16,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_item_icon.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_item_icon_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(5, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
<<<<<<< Updated upstream
		this.addRenderableWidget(imagebutton_btte_utilities);
=======
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder4);
		imagebutton_adminshop_new_placeholder5 = new ImageButton(this.leftPos + 52, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(6, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder5);
		imagebutton_adminshop_new_placeholder6 = new ImageButton(this.leftPos + 88, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(7, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder6);
		imagebutton_adminshop_new_placeholder7 = new ImageButton(this.leftPos + 88, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(8, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder7);
		imagebutton_adminshop_new_placeholder8 = new ImageButton(this.leftPos + 88, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(9, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder8);
		imagebutton_adminshop_new_placeholder9 = new ImageButton(this.leftPos + 124, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(10, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder9);
		imagebutton_adminshop_new_placeholder10 = new ImageButton(this.leftPos + 124, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(11, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder10);
		imagebutton_adminshop_new_placeholder11 = new ImageButton(this.leftPos + 124, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(12, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder11);
		imagebutton_adminshop_new_placeholder12 = new ImageButton(this.leftPos + 160, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(13, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder12);
		imagebutton_adminshop_new_placeholder13 = new ImageButton(this.leftPos + 160, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(14, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 14, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder13);
		imagebutton_adminshop_new_placeholder14 = new ImageButton(this.leftPos + 160, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(15, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 15, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder14);
		imagebutton_adminshop_new_placeholder15 = new ImageButton(this.leftPos + 196, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(16, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 16, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder15);
		imagebutton_adminshop_new_placeholder16 = new ImageButton(this.leftPos + 196, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(17, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 17, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder16);
		imagebutton_adminshop_new_placeholder17 = new ImageButton(this.leftPos + 196, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(18, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 18, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder17);
		imagebutton_adminshop_new_placeholder18 = new ImageButton(this.leftPos + 232, this.topPos + 38, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(19, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 19, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder18);
		imagebutton_adminshop_new_placeholder19 = new ImageButton(this.leftPos + 232, this.topPos + 86, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(20, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 20, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_adminshop_new_placeholder19);
		imagebutton_adminshop_new_placeholder20 = new ImageButton(this.leftPos + 232, this.topPos + 134, 24, 24,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/adminshop_btn_pashover.png"), ResourceLocation.parse("palamod:textures/screens/adminshop_btn_hover.png")), e -> {
					int x = AdminshopmenuScreen.this.x;
					int y = AdminshopmenuScreen.this.y;
					if (true) {
						ClientPacketDistributor.sendToServer(new AdminshopmenuButtonMessage(21, x, y, z));
						AdminshopmenuButtonMessage.handleButtonAction(entity, 21, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
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
>>>>>>> Stashed changes
	}
}
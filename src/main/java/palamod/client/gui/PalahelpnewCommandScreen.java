package palamod.client.gui;

import palamod.world.inventory.PalahelpnewCommandMenu;

import palamod.procedures.TRADreturntosumarryProcedure;

import palamod.network.PalahelpnewCommandButtonMessage;

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

public class PalahelpnewCommandScreen extends AbstractContainerScreen<PalahelpnewCommandMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_arrow_palahelp_left_off;
	private ImageButton imagebutton_sommaire_btn;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");

	public PalahelpnewCommandScreen(PalahelpnewCommandMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 182;
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
		if (mouseX > leftPos + 127 && mouseX < leftPos + 145 && mouseY > topPos + 0 && mouseY < topPos + 18) {
			if (TRADreturntosumarryProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(TRADreturntosumarryProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 58 && mouseY > topPos + 29 && mouseY < topPos + 42) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_you_to_the_spawn_the_ad").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_you_to_the_spawn_the_ad").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 73 && mouseY > topPos + 42 && mouseY < topPos + 53) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_setup_at").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_setup_at").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 144 && mouseY > topPos + 73 && mouseY < topPos + 86) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_to_the_home_named_in_th").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_to_the_home_named_in_th").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 49 && mouseY > topPos + 53 && mouseY < topPos + 64) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_jobs_interface").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_jobs_interface").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 102 && mouseY > topPos + 64 && mouseY < topPos + 73) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_create_a_home_with_given_name_in").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_create_a_home_with_given_name_in").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 65 && mouseY > topPos + 86 && mouseY < topPos + 94) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_delete_the_given_home_in_the_1st").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_delete_the_given_home_in_the_1st").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 48 && mouseY > topPos + 94 && mouseY < topPos + 104) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_give_the_player_a_starting_kit").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_give_the_player_a_starting_kit").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 47 && mouseY > topPos + 104 && mouseY < topPos + 113) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_give_saturation_2_to_the_player").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_give_saturation_2_to_the_player").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 110 && mouseY > topPos + 113 && mouseY < topPos + 123) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_adminshop_where_you_can").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_adminshop_where_you_can").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 89 && mouseY > topPos + 123 && mouseY < topPos + 132) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_the_old_ga").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_the_old_ga").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 97 && mouseY > topPos + 132 && mouseY < topPos + 141) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_execute").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_execute").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 19 && mouseX < leftPos + 50 && mouseY > topPos + 141 && mouseY < topPos + 151) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_a_random_location_on").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_a_random_location_on").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 177 && mouseX < leftPos + 211 && mouseY > topPos + 13 && mouseY < topPos + 25) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_show_the_current_player_money_f").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_show_the_current_player_money_f").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 177 && mouseX < leftPos + 211 && mouseY > topPos + 25 && mouseY < topPos + 33) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_pay_the_given_player_the_given_a").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_pay_the_given_player_the_given_a").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 177 && mouseX < leftPos + 204 && mouseY > topPos + 33 && mouseY < topPos + 43) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_the_position_where_y").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_the_position_where_y").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 177 && mouseX < leftPos + 215 && mouseY > topPos + 43 && mouseY < topPos + 52) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_random_location_in_t").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_random_location_in_t").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 1, 0, 0, 320, 180, 320, 180);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_palahelp_command").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 35, 13 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_spawn").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 21, 30 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_setspawn").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 21, 41 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_sethome_name").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 21, 63 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_feed").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 19, 102 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_palakit").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 19, 92 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_home_nameinfo").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 20, 72 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_delhome").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 20, 84 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_adminshop").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 21, 112 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_gm_0123").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 18, 121 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_palalag_force_admin").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 19, 130 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_rtp").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 17, 140 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_money").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 178, 13 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_pay").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 177, 22 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_back").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 176, 32 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_nether").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 175, 42 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_jobs").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 19, 53 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_palahelp_left_off = new ImageButton(this.leftPos + 17, this.topPos + 150, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_on.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_palahelp_left_off);
		imagebutton_sommaire_btn = new ImageButton(this.leftPos + 129, this.topPos + 0, 14, 18,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png"), ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png")), e -> {
					int x = PalahelpnewCommandScreen.this.x;
					int y = PalahelpnewCommandScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewCommandButtonMessage(1, x, y, z));
						PalahelpnewCommandButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_sommaire_btn);
	}
}
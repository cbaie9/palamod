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
	private ImageButton imagebutton_arrow_palahelp_right_off;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");

	public PalahelpnewCommandScreen(PalahelpnewCommandMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 320;
		this.imageHeight = 180;
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
		if (mouseX > leftPos + 127 && mouseX < leftPos + 145 && mouseY > topPos + -1 && mouseY < topPos + 17) {
			if (TRADreturntosumarryProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(TRADreturntosumarryProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 58 && mouseY > topPos + 28 && mouseY < topPos + 41) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_you_to_the_spawn_the_ad").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_you_to_the_spawn_the_ad").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 73 && mouseY > topPos + 41 && mouseY < topPos + 52) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_setup_at").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_setup_at").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 144 && mouseY > topPos + 72 && mouseY < topPos + 85) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_to_the_home_named_in_th").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_to_the_home_named_in_th").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 102 && mouseY > topPos + 63 && mouseY < topPos + 72) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_create_a_home_with_given_name_in").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_create_a_home_with_given_name_in").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 65 && mouseY > topPos + 85 && mouseY < topPos + 93) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_delete_the_given_home_in_the_1st").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_delete_the_given_home_in_the_1st").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 48 && mouseY > topPos + 93 && mouseY < topPos + 103) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_give_the_player_a_starting_kit").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_give_the_player_a_starting_kit").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 47 && mouseY > topPos + 103 && mouseY < topPos + 112) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_give_saturation_2_to_the_player").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_give_saturation_2_to_the_player").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 110 && mouseY > topPos + 112 && mouseY < topPos + 122) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_adminshop_where_you_can").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_adminshop_where_you_can").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 89 && mouseY > topPos + 122 && mouseY < topPos + 131) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_the_old_ga").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_the_old_ga").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 97 && mouseY > topPos + 131 && mouseY < topPos + 140) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_execute").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_administrators_only_execute").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 51 && mouseY > topPos + 140 && mouseY < topPos + 150) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_a_random_location_on").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_a_random_location_on").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 177 && mouseX < leftPos + 211 && mouseY > topPos + 12 && mouseY < topPos + 24) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_show_the_current_player_money_f").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_show_the_current_player_money_f").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 177 && mouseX < leftPos + 211 && mouseY > topPos + 24 && mouseY < topPos + 32) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_pay_the_given_player_the_given_a").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_pay_the_given_player_the_given_a").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 177 && mouseX < leftPos + 204 && mouseY > topPos + 32 && mouseY < topPos + 42) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_the_position_where_y").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_the_position_where_y").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 177 && mouseX < leftPos + 215 && mouseY > topPos + 42 && mouseY < topPos + 51) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_random_location_in_t").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_teleport_at_random_location_in_t").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 54 && mouseY > topPos + 52 && mouseY < topPos + 63) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_job_system_interface_n").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_job_system_interface_n").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 176 && mouseX < leftPos + 220 && mouseY > topPos + 51 && mouseY < topPos + 61) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_a_command_to_teleport_at_a_rando").getString() != null) {
				guiGraphics.renderComponentTooltip(font,
						Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_a_command_to_teleport_at_a_rando").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 176 && mouseX < leftPos + 211 && mouseY > topPos + 61 && mouseY < topPos + 72) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_craft_table_interface").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_open_the_craft_table_interface").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 20 && mouseX < leftPos + 57 && mouseY > topPos + 150 && mouseY < topPos + 170) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_go_to_palahelp_ores_and_liquids").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_go_to_palahelp_ores_and_liquids").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 264 && mouseX < leftPos + 306 && mouseY > topPos + 147 && mouseY < topPos + 171) {
			if (Component.translatable("gui.palamod.palahelpnew_command.tooltip_go_to_palahelp_jobs").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.tooltip_go_to_palahelp_jobs").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 320, 180, 320, 180);
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
			guiGraphics.drawString(this.font, actualComponent, 35, 12 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_spawn").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 21, 29 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_setspawn").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 21, 40 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_sethome_name").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 21, 62 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_feed").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 19, 101 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_palakit").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 19, 91 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_home_nameinfo").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 20, 71 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_delhome").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 20, 83 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_adminshop").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 21, 111 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_gm_0123").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 18, 120 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_palalag_force_admin").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 19, 129 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_rtp").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 20, 139 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_money").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 178, 12 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_pay").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 177, 21 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_back").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 176, 31 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_nether").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 175, 41 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_jobs").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 19, 52 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_rtp1").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 176, 51 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_craft").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 177, 61 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelpnew_command.label_here_all_the_main_commandnthe_m").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 170, 73 + yOffset, -16777063, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_palahelp_left_off = new ImageButton(this.leftPos + 20, this.topPos + 150, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_on.png")), e -> {
					int x = PalahelpnewCommandScreen.this.x;
					int y = PalahelpnewCommandScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewCommandButtonMessage(0, x, y, z));
						PalahelpnewCommandButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_palahelp_left_off);
		imagebutton_sommaire_btn = new ImageButton(this.leftPos + 129, this.topPos + -1, 14, 18,
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
		imagebutton_arrow_palahelp_right_off = new ImageButton(this.leftPos + 264, this.topPos + 150, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_right_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_right_on.png")), e -> {
					int x = PalahelpnewCommandScreen.this.x;
					int y = PalahelpnewCommandScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpnewCommandButtonMessage(2, x, y, z));
						PalahelpnewCommandButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_palahelp_right_off);
	}
}
package palamod.client.gui;

import palamod.world.inventory.PalahelpJobsxpgainMenu;

import palamod.procedures.*;

import palamod.network.PalahelpJobsxpgainButtonMessage;

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

public class PalahelpJobsxpgainScreen extends AbstractContainerScreen<PalahelpJobsxpgainMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_jobs_xpgain_arrow_up;
	private ImageButton imagebutton_jobs_xpgain_arrow_down;
	private ImageButton imagebutton_jobs_xpgain_farmer_break;
	private ImageButton imagebutton_jobs_xpgain_farmer_craft;
	private ImageButton imagebutton_jobs_xpgain_miner_break;
	private ImageButton imagebutton_jobs_xpgain_miner_smelt;
	private ImageButton imagebutton_jobs_xpgain_hunter_smelt;
	private ImageButton imagebutton_jobs_xpgain_alchi_craft;
	private ImageButton imagebutton_jobs_xpgain_alchi_break;
	private ImageButton imagebutton_jobs_xpgain_hunter_kill;
	private ImageButton imagebutton_screen_beta3_jobs_miner;
	private ImageButton imagebutton_screen_beta3_jobs_hunter;
	private ImageButton imagebutton_screen_beta3_famer_jobs;
	private ImageButton imagebutton_screen_beta3_jobs_alchi;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/palahelp_jobsxpgain.png");
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("palamod:textures/screens/sprite_xpgain.png");
	private static final ResourceLocation SPRITE_1 = ResourceLocation.parse("palamod:textures/screens/sprite_xpgain.png");
	private static final ResourceLocation SPRITE_2 = ResourceLocation.parse("palamod:textures/screens/sprite_xpgain.png");
	private static final ResourceLocation SPRITE_3 = ResourceLocation.parse("palamod:textures/screens/sprite_xpgain.png");
	private static final ResourceLocation SPRITE_4 = ResourceLocation.parse("palamod:textures/screens/sprite_xpgain.png");
	private static final ResourceLocation SPRITE_5 = ResourceLocation.parse("palamod:textures/screens/sprite_xpgain.png");

	public PalahelpJobsxpgainScreen(PalahelpJobsxpgainMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 300;
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
		if (mouseX > leftPos + 8 && mouseX < leftPos + 40 && mouseY > topPos + 11 && mouseY < topPos + 43) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_mining_based_experience").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_mining_based_experience").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 40 && mouseX < leftPos + 72 && mouseY > topPos + 11 && mouseY < topPos + 43) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_smelting_base_experience_gain").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_smelting_base_experience_gain").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 40 && mouseX < leftPos + 72 && mouseY > topPos + 75 && mouseY < topPos + 107) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_smelting_based_experience_gain").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_smelting_based_experience_gain").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 40 && mouseX < leftPos + 72 && mouseY > topPos + 43 && mouseY < topPos + 75) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_crafting_base_experience_gain").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_crafting_base_experience_gain").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 8 && mouseX < leftPos + 40 && mouseY > topPos + 107 && mouseY < topPos + 139) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_breaking_wood_based_experience").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_breaking_wood_based_experience").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 8 && mouseX < leftPos + 40 && mouseY > topPos + 43 && mouseY < topPos + 75) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_breaking_crops_based_experience").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_breaking_crops_based_experience").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 40 && mouseX < leftPos + 72 && mouseY > topPos + 107 && mouseY < topPos + 139) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_crafting_based_experience_gain").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_crafting_based_experience_gain").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()),
						mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 86 && mouseX < leftPos + 126 && mouseY > topPos + -21 && mouseY < topPos + 19) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_farmer").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_farmer").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 134 && mouseX < leftPos + 174 && mouseY > topPos + -21 && mouseY < topPos + 19) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_miner").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_miner").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 183 && mouseX < leftPos + 223 && mouseY > topPos + -21 && mouseY < topPos + 19) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_hunter").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_hunter").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 232 && mouseX < leftPos + 272 && mouseY > topPos + -20 && mouseY < topPos + 20) {
			if (Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_alchimist").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.tooltip_alchimist").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + 0, 0, 0, 300, 180, 300, 180);
		if (ShowFromSlot0PalahelpJobsXpGainProcedure.execute(entity)) {
			guiGraphics.blit(SPRITE_0, this.leftPos + 247, this.topPos + 41, Mth.clamp((int) GetSprite0PalahelpJobsXpGainProcedure.execute(world, entity) * 16, 0, 16), 0, 16, 16, 32, 16);
		}
		if (ShowFromSlot1PalahelpJobsXpGainProcedure.execute(entity)) {
			guiGraphics.blit(SPRITE_1, this.leftPos + 247, this.topPos + 63, Mth.clamp((int) GetSprite1PalahelpJobsXpGainProcedure.execute(world, entity) * 16, 0, 16), 0, 16, 16, 32, 16);
		}
		if (ShowFromSlot2PalahelpJobsXpGainProcedure.execute(entity)) {
			guiGraphics.blit(SPRITE_2, this.leftPos + 247, this.topPos + 84, Mth.clamp((int) GetSprite2PalahelpJobsXpGainProcedure.execute(world, entity) * 16, 0, 16), 0, 16, 16, 32, 16);
		}
		if (ShowFromSlot3PalahelpJobsXpGainProcedure.execute(entity)) {
			guiGraphics.blit(SPRITE_3, this.leftPos + 247, this.topPos + 105, Mth.clamp((int) GetSprite3PalahelpJobsXpGainProcedure.execute(world, entity) * 16, 0, 16), 0, 16, 16, 32, 16);
		}
		if (ShowFromSlot4PalahelpJobsXpGainProcedure.execute(entity)) {
			guiGraphics.blit(SPRITE_4, this.leftPos + 247, this.topPos + 127, Mth.clamp((int) GetSprite4PalahelpJobsXpGainProcedure.execute(world, entity) * 16, 0, 16), 0, 16, 16, 32, 16);
		}
		if (ShowFromSlot5PalahelpJobsXpGainProcedure.execute(entity)) {
			guiGraphics.blit(SPRITE_5, this.leftPos + 247, this.topPos + 148, Mth.clamp((int) GetSprite5PalahelpJobsXpGainProcedure.execute(world, entity) * 16, 0, 16), 0, 16, 16, 32, 16);
		}
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.label_item").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 145, 25 + yOffset, -16751104, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		if (ShowFromSlot0PalahelpJobsXpGainProcedure.execute(entity))
			yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetTextItemName0PalahelpXpGainProcedure.execute(world, entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 148, 45 + yOffset, -65485, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		if (ShowFromSlot1PalahelpJobsXpGainProcedure.execute(entity))
			yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetTextItemName1PalahelpXpGainProcedure.execute(world, entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 148, 65 + yOffset, -65485, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		if (ShowFromSlot2PalahelpJobsXpGainProcedure.execute(entity))
			yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetTextItemName2PalahelpXpGainProcedure.execute(world, entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 148, 86 + yOffset, -65485, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		if (ShowFromSlot3PalahelpJobsXpGainProcedure.execute(entity))
			yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetTextItemName3PalahelpXpGainProcedure.execute(world, entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 148, 107 + yOffset, -65485, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		if (ShowFromSlot4PalahelpJobsXpGainProcedure.execute(entity))
			yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetTextItemName4PalahelpXpGainProcedure.execute(world, entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 148, 129 + yOffset, -65485, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		if (ShowFromSlot5PalahelpJobsXpGainProcedure.execute(entity))
			yOffset = 0;
		for (Component actualComponent : Arrays.stream(GetTextItemName5PalahelpXpGainProcedure.execute(world, entity).split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 148, 150 + yOffset, -65485, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelp_jobsxpgain.label_can_gain_xp_now").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 212, 25 + yOffset, -16777216, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_jobs_xpgain_arrow_up = new ImageButton(this.leftPos + 95, this.topPos + 165, 16, 12,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/jobs_xpgain_arrow_down.png"), ResourceLocation.parse("palamod:textures/screens/jobs_xpgain_arrow_down_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (PageUpPalahelpJobsXpGainLogicProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(0, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 0, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (PageUpPalahelpJobsXpGainLogicProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_arrow_up);
		imagebutton_jobs_xpgain_arrow_down = new ImageButton(this.leftPos + 95, this.topPos + 29, 16, 12,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/jobs_xpgain_arrow_up.png"), ResourceLocation.parse("palamod:textures/screens/jobs_xpgain_arrow_up_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (PageDownPalahelpJobsXpGainLogicProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(1, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (PageDownPalahelpJobsXpGainLogicProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_arrow_down);
		imagebutton_jobs_xpgain_farmer_break = new ImageButton(this.leftPos + 8, this.topPos + 43, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/breaking_farming_recipe32_xpgain.png"), ResourceLocation.parse("palamod:textures/screens/breaking_farming_recipe32_xpgain_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (IsModeFarmerJobsXpgainProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(2, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (IsModeFarmerJobsXpgainProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_farmer_break);
		imagebutton_jobs_xpgain_farmer_craft = new ImageButton(this.leftPos + 40, this.topPos + 43, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/crafting_recipe_xpgain32.png"), ResourceLocation.parse("palamod:textures/screens/crafting_recipe_xpgain32_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (IsModeFarmerJobsXpgainProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(3, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 3, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (IsModeFarmerJobsXpgainProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_farmer_craft);
		imagebutton_jobs_xpgain_miner_break = new ImageButton(this.leftPos + 8, this.topPos + 11, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/base_miner.png"), ResourceLocation.parse("palamod:textures/screens/base_miner.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (IsModeMinerJobsXpgainProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(4, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 4, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (IsModeMinerJobsXpgainProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_miner_break);
		imagebutton_jobs_xpgain_miner_smelt = new ImageButton(this.leftPos + 40, this.topPos + 11, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/furnace_recipe32_xpgain.png"), ResourceLocation.parse("palamod:textures/screens/furnace_recipe32_xpgain_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (IsModeMinerJobsXpgainProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(5, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 5, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (IsModeMinerJobsXpgainProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_miner_smelt);
		imagebutton_jobs_xpgain_hunter_smelt = new ImageButton(this.leftPos + 40, this.topPos + 75, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/furnace_recipe32_xpgain.png"), ResourceLocation.parse("palamod:textures/screens/furnace_recipe32_xpgain_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (IsModeHunterJobsXpgainProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(6, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 6, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (IsModeHunterJobsXpgainProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_hunter_smelt);
		imagebutton_jobs_xpgain_alchi_craft = new ImageButton(this.leftPos + 40, this.topPos + 107, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/crafting_recipe_xpgain32.png"), ResourceLocation.parse("palamod:textures/screens/crafting_recipe_xpgain32_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (IsModeAlchiJobsXpgainProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(7, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 7, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (IsModeAlchiJobsXpgainProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_alchi_craft);
		imagebutton_jobs_xpgain_alchi_break = new ImageButton(this.leftPos + 8, this.topPos + 107, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/breaking_recipe32_xpgain.png"), ResourceLocation.parse("palamod:textures/screens/breaking_recipe32_xpgain_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (IsModeAlchiJobsXpgainProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(8, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 8, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (IsModeAlchiJobsXpgainProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_alchi_break);
		imagebutton_jobs_xpgain_hunter_kill = new ImageButton(this.leftPos + 8, this.topPos + 75, 32, 32,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/killing_recipe32_xpgain.png"), ResourceLocation.parse("palamod:textures/screens/killing_recipe32_xpgain_hover.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (IsModeHunterJobsXpgainProcedure.execute(entity)) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(9, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 9, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				int x = PalahelpJobsxpgainScreen.this.x;
				int y = PalahelpJobsxpgainScreen.this.y;
				if (IsModeHunterJobsXpgainProcedure.execute(entity))
					guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_jobs_xpgain_hunter_kill);
		imagebutton_screen_beta3_jobs_miner = new ImageButton(this.leftPos + 134, this.topPos + -21, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_miner.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_miner2.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(10, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 10, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta3_jobs_miner);
		imagebutton_screen_beta3_jobs_hunter = new ImageButton(this.leftPos + 183, this.topPos + -21, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_hunter.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_hunter2.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(11, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 11, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta3_jobs_hunter);
		imagebutton_screen_beta3_famer_jobs = new ImageButton(this.leftPos + 86, this.topPos + -21, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_famer_jobs.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_farm2.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(12, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 12, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta3_famer_jobs);
		imagebutton_screen_beta3_jobs_alchi = new ImageButton(this.leftPos + 232, this.topPos + -20, 40, 40,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_alchi.png"), ResourceLocation.parse("palamod:textures/screens/screen_beta3_jobs_alchi2.png")), e -> {
					int x = PalahelpJobsxpgainScreen.this.x;
					int y = PalahelpJobsxpgainScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpJobsxpgainButtonMessage(13, x, y, z));
						PalahelpJobsxpgainButtonMessage.handleButtonAction(entity, 13, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_screen_beta3_jobs_alchi);
	}
}
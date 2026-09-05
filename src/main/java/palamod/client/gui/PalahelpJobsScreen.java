package palamod.client.gui;

import palamod.world.inventory.PalahelpJobsMenu;

import palamod.procedures.TRADreturntosumarryProcedure;

import palamod.network.PalahelpJobsButtonMessage;

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
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.systems.RenderSystem;

public class PalahelpJobsScreen extends AbstractContainerScreen<PalahelpJobsMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_xpgain;
	private ImageButton imagebutton_arrow_palahelp_left_off;
	private ImageButton imagebutton_sommaire_btn;
	private ImageButton imagebutton_arrow_palahelp_right_off;
	private static final ResourceLocation IMAGE_0 = ResourceLocation.parse("palamod:textures/screens/template_livre.png");

	public PalahelpJobsScreen(PalahelpJobsMenu container, Inventory inventory, Component text) {
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
		if (mouseX > leftPos + 170 && mouseX < leftPos + 311 && mouseY > topPos + 79 && mouseY < topPos + 99) {
			if (Component.translatable("gui.palamod.palahelp_jobs.tooltip_access_jobs_xpgain_gui").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobs.tooltip_access_jobs_xpgain_gui").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 124 && mouseX < leftPos + 142 && mouseY > topPos + -1 && mouseY < topPos + 19) {
			if (TRADreturntosumarryProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(TRADreturntosumarryProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 15 && mouseX < leftPos + 60 && mouseY > topPos + 142 && mouseY < topPos + 166) {
			if (Component.translatable("gui.palamod.palahelp_jobs.tooltip_go_to_palahelp_commands").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobs.tooltip_go_to_palahelp_commands").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
						mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 263 && mouseX < leftPos + 299 && mouseY > topPos + 146 && mouseY < topPos + 166) {
			if (Component.translatable("gui.palamod.palahelp_jobs.tooltip_go_to_palahelp_grinder").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.palahelp_jobs.tooltip_go_to_palahelp_grinder").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
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
		guiGraphics.blit(IMAGE_0, this.leftPos + 0, this.topPos + -1, 0, 0, 320, 180, 320, 180);
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelp_jobs.label_the_jobs").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 15, 11 + yOffset, -1, true);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelp_jobs.label_the_jobs_is_a_level_basednsyste").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 15, 29 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.palahelp_jobs.label_more_information_on_thenjobs_sy").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 175, 12 + yOffset, -12829636, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		button_xpgain = Button.builder(Component.translatable("gui.palamod.palahelp_jobs.button_xpgain"), e -> {
			int x = PalahelpJobsScreen.this.x;
			int y = PalahelpJobsScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new PalahelpJobsButtonMessage(0, x, y, z));
				PalahelpJobsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 170, this.topPos + 79, 141, 20).build();
		this.addRenderableWidget(button_xpgain);
		imagebutton_arrow_palahelp_left_off = new ImageButton(this.leftPos + 17, this.topPos + 144, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_left_on.png")), e -> {
					int x = PalahelpJobsScreen.this.x;
					int y = PalahelpJobsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpJobsButtonMessage(1, x, y, z));
						PalahelpJobsButtonMessage.handleButtonAction(entity, 1, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_palahelp_left_off);
		imagebutton_sommaire_btn = new ImageButton(this.leftPos + 126, this.topPos + -1, 14, 18,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png"), ResourceLocation.parse("palamod:textures/screens/sommaire_btn.png")), e -> {
					int x = PalahelpJobsScreen.this.x;
					int y = PalahelpJobsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpJobsButtonMessage(2, x, y, z));
						PalahelpJobsButtonMessage.handleButtonAction(entity, 2, x, y, z);
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_sommaire_btn);
		imagebutton_arrow_palahelp_right_off = new ImageButton(this.leftPos + 263, this.topPos + 146, 41, 20,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_right_off.png"), ResourceLocation.parse("palamod:textures/screens/arrow_palahelp_right_on.png")), e -> {
					int x = PalahelpJobsScreen.this.x;
					int y = PalahelpJobsScreen.this.y;
					if (true) {
						PacketDistributor.sendToServer(new PalahelpJobsButtonMessage(3, x, y, z));
						PalahelpJobsButtonMessage.handleButtonAction(entity, 3, x, y, z);
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
package palamod.client.gui;

import palamod.world.inventory.GamblelingjobsjetonMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.init.PalamodModScreens;

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

public class GamblelingjobsjetonScreen extends AbstractContainerScreen<GamblelingjobsjetonMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_arrow_back_true_1;
	private ImageButton imagebutton_close_gui_nohover;

	public GamblelingjobsjetonScreen(GamblelingjobsjetonMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 400;
		this.imageHeight = 215;
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
		if (mouseX > leftPos + 379 && mouseX < leftPos + 396 && mouseY > topPos + 4 && mouseY < topPos + 21) {
			if (ClosetheguitransProcedure.execute() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(ClosetheguitransProcedure.execute().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 78 && mouseX < leftPos + 161 && mouseY > topPos + 96 && mouseY < topPos + 179) {
			if (Component.translatable("gui.palamod.gamblelingjobsjeton.tooltip_hgyhugyuigyuigyi").getString() != null) {
				guiGraphics.renderComponentTooltip(font, Arrays.stream(Component.translatable("gui.palamod.gamblelingjobsjeton.tooltip_hgyhugyuigyuigyi").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList()), mouseX,
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
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.gamblelingjobsjeton.label_jobs").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 15, 14 + yOffset, -3394816, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
		yOffset = 0;
		for (Component actualComponent : Arrays.stream(Component.translatable("gui.palamod.gamblelingjobsjeton.label_jetons_de_recompenses").getString().split("\\\\n")).map(Component::literal).collect(Collectors.toList())) {
			guiGraphics.drawString(this.font, actualComponent, 15, 32 + yOffset, -3355444, false);
			heightPadding = 2;
			yOffset += this.font.lineHeight + heightPadding;
		}
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_back_true_1 = new ImageButton(this.leftPos + 359, this.topPos + 4, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/arrow_back_true_1.png"), ResourceLocation.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_back_true_1);
		imagebutton_close_gui_nohover = new ImageButton(this.leftPos + 379, this.topPos + 4, 17, 17,
				new WidgetSprites(ResourceLocation.parse("palamod:textures/screens/close_gui_nohover.png"), ResourceLocation.parse("palamod:textures/screens/close_gui_nohover.png")), e -> {
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_close_gui_nohover);
	}
}
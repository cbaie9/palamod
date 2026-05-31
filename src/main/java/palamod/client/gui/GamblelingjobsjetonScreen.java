package palamod.client.gui;

import palamod.world.inventory.GamblelingjobsjetonMenu;

import palamod.procedures.ClosetheguitransProcedure;

import palamod.init.PalamodModScreens;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.input.KeyEvent;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphicsExtractor;

import java.util.stream.Collectors;
import java.util.Arrays;

import com.mojang.blaze3d.platform.InputConstants;

public class GamblelingjobsjetonScreen extends AbstractContainerScreen<GamblelingjobsjetonMenu> implements PalamodModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private ImageButton imagebutton_arrow_back_true_1;
	private ImageButton imagebutton_close_gui_nohover;

	public GamblelingjobsjetonScreen(GamblelingjobsjetonMenu container, Inventory inventory, Component text) {
		super(container, inventory, text, 400, 215);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void extractRenderState(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
		if (mouseX > leftPos + 379 && mouseX < leftPos + 396 && mouseY > topPos + 4 && mouseY < topPos + 21) {
			String hoverText = ClosetheguitransProcedure.execute();
			if (hoverText != null) {
				guiGraphics.setComponentTooltipForNextFrame(font, Arrays.stream(hoverText.split("\n")).map(Component::literal).collect(Collectors.toList()), mouseX, mouseY);
			}
		}
		if (mouseX > leftPos + 78 && mouseX < leftPos + 161 && mouseY > topPos + 96 && mouseY < topPos + 179) {
			guiGraphics.setTooltipForNextFrame(font, Component.translatable("gui.palamod.gamblelingjobsjeton.tooltip_hgyhugyuigyuigyi"), mouseX, mouseY);
		}
		super.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
	}

	@Override
	public void extractBackground(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
	}

	@Override
	public boolean keyPressed(KeyEvent event) {
		int key = InputConstants.getKey(event).getValue();
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(event);
	}

	@Override
	protected void extractLabels(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY) {
		guiGraphics.text(this.font, Component.translatable("gui.palamod.gamblelingjobsjeton.label_jobs"), 15, 14, -3394816, false);
		guiGraphics.text(this.font, Component.translatable("gui.palamod.gamblelingjobsjeton.label_jetons_de_recompenses"), 15, 32, -3355444, false);
	}

	@Override
	public void init() {
		super.init();
		imagebutton_arrow_back_true_1 = new ImageButton(this.leftPos + 359, this.topPos + 4, 17, 17,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/arrow_back_true_1.png"), Identifier.parse("palamod:textures/screens/arrow_back_true2.png")), e -> {
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_arrow_back_true_1);
		imagebutton_close_gui_nohover = new ImageButton(this.leftPos + 379, this.topPos + 4, 17, 17,
				new WidgetSprites(Identifier.parse("palamod:textures/screens/close_gui_nohover.png"), Identifier.parse("palamod:textures/screens/close_gui_nohover.png")), e -> {
				}) {
			@Override
			public void extractContents(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
				guiGraphics.blit(RenderPipelines.GUI_TEXTURED, sprites.get(isActive(), isHoveredOrFocused()), getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		this.addRenderableWidget(imagebutton_close_gui_nohover);
	}
}
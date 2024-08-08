package palamod.client.gui;

public class OrelayerfatScreen extends AbstractContainerScreen<OrelayerfatMenu> {

	private final static HashMap<String, Object> guistate = OrelayerfatMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public OrelayerfatScreen(OrelayerfatMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 100;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/orelayerfat.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 250, 100, 250, 100);

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
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_paladium_64_15"), 4, 57, -3407872, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_titane_64_32"), 5, 69, -10066330, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_amethyst_64_80"), 7, 80, -6750055, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_findium_64_150"), 5, 42, -13312, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_green_paladium_64_128"), 6, 28, -16738048, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.orelayerfat.label_endium_64_128_customs_p"), 5, 15, -16777114, false);
	}

	@Override
	public void init() {
		super.init();

	}

}

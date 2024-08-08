package palamod.client.gui;

public class EndiumchestguiScreen extends AbstractContainerScreen<EndiumchestguiMenu> {

	private final static HashMap<String, Object> guistate = EndiumchestguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public EndiumchestguiScreen(EndiumchestguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 244;
		this.imageHeight = 140;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/endiumchestgui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 244, 140, 244, 140);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/ring_endium.png"), this.leftPos + 212, this.topPos + 78, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/ring_endium.png"), this.leftPos + 212, this.topPos + 96, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.endiumchestgui.label_inventory"), 39, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.endiumchestgui.label_ring"), 208, 64, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

	}

}

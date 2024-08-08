package palamod.client.gui;

public class TitanechestguiScreen extends AbstractContainerScreen<TitanechestguiMenu> {

	private final static HashMap<String, Object> guistate = TitanechestguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public TitanechestguiScreen(TitanechestguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 306;
		this.imageHeight = 225;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/titanechestgui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 306, 225, 306, 225);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/ring_to_set.png"), this.leftPos + 283, this.topPos + 112, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/ring_gui.png"), this.leftPos + 259, this.topPos + 163, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/ring_gui.png"), this.leftPos + 259, this.topPos + 181, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.titanechestgui.label_inventory"), 70, 132, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.titanechestgui.label_rings"), 254, 147, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

	}

}

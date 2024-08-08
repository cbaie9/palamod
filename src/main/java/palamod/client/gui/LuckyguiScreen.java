package palamod.client.gui;

public class LuckyguiScreen extends AbstractContainerScreen<LuckyguiMenu> {

	private final static HashMap<String, Object> guistate = LuckyguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Button button_open;

	ImageButton imagebutton_cross_no_button;

	public LuckyguiScreen(LuckyguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 180;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/luckygui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 180, 176, 180);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 75, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.luckygui.label_lucky_block"), 55, 6, -1, false);
		guiGraphics.drawString(this.font,

				LuckyblockgetnameProcedure.execute(world, x, y, z), 26, 84, -3407821, false);
	}

	@Override
	public void init() {
		super.init();

		button_open = Button.builder(Component.translatable("gui.palamod.luckygui.button_open"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LuckyguiButtonMessage(0, x, y, z));
				LuckyguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 117, this.topPos + 44, 45, 20).build();

		guistate.put("button:button_open", button_open);
		this.addRenderableWidget(button_open);

		imagebutton_cross_no_button = new ImageButton(this.leftPos + 155, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new LuckyguiButtonMessage(1, x, y, z));
				LuckyguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});

		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);

	}

}

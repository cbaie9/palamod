package palamod.client.gui;

public class UploaderguiScreen extends AbstractContainerScreen<UploaderguiMenu> {

	private final static HashMap<String, Object> guistate = UploaderguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	ImageButton imagebutton_cross_no_button;

	public UploaderguiScreen(UploaderguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

		if (mouseX > leftPos + 76 && mouseX < leftPos + 94 && mouseY > topPos + 61 && mouseY < topPos + 79)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.uploadergui.tooltip_money_output"), mouseX, mouseY);
		if (mouseX > leftPos + 76 && mouseX < leftPos + 94 && mouseY > topPos + 27 && mouseY < topPos + 45)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.uploadergui.tooltip_items_you_want_to_sell_must_be"), mouseX, mouseY);
		if (mouseX > leftPos + 152 && mouseX < leftPos + 168 && mouseY > topPos + 4 && mouseY < topPos + 20)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.uploadergui.tooltip_close_the_gui"), mouseX, mouseY);
		if (mouseX > leftPos + 61 && mouseX < leftPos + 107 && mouseY > topPos + 5 && mouseY < topPos + 18)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.uploadergui.tooltip_this_gui_interface_need_an_upgra"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/uploadergui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/golem_treec_sep_nt1.png"), this.leftPos + 77, this.topPos + 45, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.uploadergui.label_uploader"), 64, 7, -1, false);
		guiGraphics.drawString(this.font,

				Grindertrans0Procedure.execute(entity), 3, 71, -12829636, false);
		guiGraphics.drawString(this.font,

				UploaderdebugProcedure.execute(world, x, y, z), 96, 64, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

		imagebutton_cross_no_button = new ImageButton(this.leftPos + 152, this.topPos + 4, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new UploaderguiButtonMessage(0, x, y, z));
				UploaderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});

		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);

	}

}

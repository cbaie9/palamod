package palamod.client.gui;

public class DownloaderguiScreen extends AbstractContainerScreen<DownloaderguiMenu> {

	private final static HashMap<String, Object> guistate = DownloaderguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	Checkbox download_state;

	Button button_reload;
	Button button_link;

	public DownloaderguiScreen(DownloaderguiMenu container, Inventory inventory, Component text) {
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

		if (mouseX > leftPos + 113 && mouseX < leftPos + 169 && mouseY > topPos + 60 && mouseY < topPos + 80)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.downloadergui.tooltip_reboot_the_downloader_change_t"), mouseX, mouseY);
		if (mouseX > leftPos + 3 && mouseX < leftPos + 49 && mouseY > topPos + 48 && mouseY < topPos + 67)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.downloadergui.tooltip_link_a_bank_account_who_will_be"), mouseX, mouseY);
		if (mouseX > leftPos + 4 && mouseX < leftPos + 24 && mouseY > topPos + 4 && mouseY < topPos + 24)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.downloadergui.tooltip_turn_onoff_the_machine"), mouseX, mouseY);
		if (mouseX > leftPos + 138 && mouseX < leftPos + 170 && mouseY > topPos + 4 && mouseY < topPos + 34)
			guiGraphics.renderTooltip(font, Component.translatable("gui.palamod.downloadergui.tooltip_what_you_will_buy_with_the_machi"), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/downloadergui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down_downloader_gray.png"), this.leftPos + 79, this.topPos + 62, 0, 0, 16, 16, 16, 16);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.downloadergui.label_filter"), 138, 3, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.downloadergui.label_output"), 71, 31, -12829636, false);
		guiGraphics.drawString(this.font,

				Grindertrans0Procedure.execute(entity), 6, 71, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

		button_reload = Button.builder(Component.translatable("gui.palamod.downloadergui.button_reload"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DownloaderguiButtonMessage(0, x, y, z));
				DownloaderguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 113, this.topPos + 60, 56, 20).build();

		guistate.put("button:button_reload", button_reload);
		this.addRenderableWidget(button_reload);

		button_link = Button.builder(Component.translatable("gui.palamod.downloadergui.button_link"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new DownloaderguiButtonMessage(1, x, y, z));
				DownloaderguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 3, this.topPos + 48, 46, 20).build();

		guistate.put("button:button_link", button_link);
		this.addRenderableWidget(button_link);

		download_state = new Checkbox(this.leftPos + 4, this.topPos + 4, 20, 20, Component.translatable("gui.palamod.downloadergui.download_state"),

				DownloadercheckedProcedure.execute(world, x, y, z)

		);

		guistate.put("checkbox:download_state", download_state);
		this.addRenderableWidget(download_state);
	}

}

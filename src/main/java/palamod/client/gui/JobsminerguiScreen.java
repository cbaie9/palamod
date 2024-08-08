package palamod.client.gui;

public class JobsminerguiScreen extends AbstractContainerScreen<JobsminerguiMenu> {

	private final static HashMap<String, Object> guistate = JobsminerguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	ImageButton imagebutton_button_gray;
	ImageButton imagebutton_help_button;
	ImageButton imagebutton_cross_no_button;

	public JobsminerguiScreen(JobsminerguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 80;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);

		super.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

		if (mouseX > leftPos + 14 && mouseX < leftPos + 159 && mouseY > topPos + 26 && mouseY < topPos + 36)
			guiGraphics.renderTooltip(font, Component.literal(

					GetxpminertextProcedure.execute(entity)), mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/jobsminergui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 80, 176, 80);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_jobs_v1empty.png"), this.leftPos + 14, this.topPos + 26, 0, 0, 145, 10, 145, 10);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 76, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.jobsminergui.label_jobs_miner"), 9, 7, -1, false);
		guiGraphics.drawString(this.font,

				GetxpminerProcedure.execute(entity), 114, 36, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

		imagebutton_button_gray = new ImageButton(this.leftPos + 104, this.topPos + 53, 48, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_button_gray.png"), 48, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminerguiButtonMessage(0, x, y, z));
				JobsminerguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});

		guistate.put("button:imagebutton_button_gray", imagebutton_button_gray);
		this.addRenderableWidget(imagebutton_button_gray);

		imagebutton_help_button = new ImageButton(this.leftPos + 14, this.topPos + 53, 48, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_help_button.png"), 48, 32, e -> {
		});

		guistate.put("button:imagebutton_help_button", imagebutton_help_button);
		this.addRenderableWidget(imagebutton_help_button);

		imagebutton_cross_no_button = new ImageButton(this.leftPos + 154, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobsminerguiButtonMessage(2, x, y, z));
				JobsminerguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});

		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);

	}

}

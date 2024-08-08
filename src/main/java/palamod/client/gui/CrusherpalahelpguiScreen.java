package palamod.client.gui;

public class CrusherpalahelpguiScreen extends AbstractContainerScreen<CrusherpalahelpguiMenu> {

	private final static HashMap<String, Object> guistate = CrusherpalahelpguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_example_gui_button;
	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_home_pixel_adminshop;

	public CrusherpalahelpguiScreen(CrusherpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 420;
		this.imageHeight = 200;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/crusherpalahelpgui.png"), this.leftPos + -1, this.topPos + 1, 0, 0, 420, 200, 420, 200);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 98, this.topPos + -1, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -2, this.topPos + -1, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/crusher_front.png"), this.leftPos + 5, this.topPos + 3, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 198, this.topPos + -1, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 319, this.topPos + -1, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/mid_gray_line.png"), this.leftPos + 275, this.topPos + -1, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crusherpalahelpgui.label_beta_nochange_0004"), 6, 186, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crusherpalahelpgui.label_paladium_crusher_wiki"), 134, 4, -1, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher0Procedure.execute(entity), 4, 28, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher1Procedure.execute(entity), 4, 40, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher2Procedure.execute(entity), 3, 52, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher3Procedure.execute(entity), 4, 64, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher4Procedure.execute(entity), 4, 75, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher6Procedure.execute(entity), 3, 88, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher7Procedure.execute(entity), 3, 101, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher8Procedure.execute(entity), 3, 113, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher9Procedure.execute(entity), 4, 127, -12829636, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher12Procedure.execute(entity), 5, 150, -26368, false);
		guiGraphics.drawString(this.font,

				Palahelpcrusher13Procedure.execute(entity), 4, 161, -26368, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crusherpalahelpgui.label_11_v1"), 383, 184, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

		imagebutton_cross_no_button = new ImageButton(this.leftPos + 395, this.topPos + 3, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiButtonMessage(0, x, y, z));
				CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});

		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);

		imagebutton_example_gui_button = new ImageButton(this.leftPos + 372, this.topPos + 3, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_example_gui_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiButtonMessage(1, x, y, z));
				CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});

		guistate.put("button:imagebutton_example_gui_button", imagebutton_example_gui_button);
		this.addRenderableWidget(imagebutton_example_gui_button);

		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 325, this.topPos + 3, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiButtonMessage(2, x, y, z));
				CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});

		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);

		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 348, this.topPos + 3, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherpalahelpguiButtonMessage(3, x, y, z));
				CrusherpalahelpguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});

		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);

	}

}

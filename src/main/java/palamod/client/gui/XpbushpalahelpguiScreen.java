package palamod.client.gui;

public class XpbushpalahelpguiScreen extends AbstractContainerScreen<XpbushpalahelpguiMenu> {

	private final static HashMap<String, Object> guistate = XpbushpalahelpguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	ImageButton imagebutton_arrow_adminshop;
	ImageButton imagebutton_cross_no_button;
	ImageButton imagebutton_home_pixel_adminshop;

	public XpbushpalahelpguiScreen(XpbushpalahelpguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 166;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/xpbushpalahelpgui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 200, 166, 200, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/xp_berry.png"), this.leftPos + 4, this.topPos + 80, 0, 0, 32, 32, 32, 32);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/berry_xp_bush_fancy.png"), this.leftPos + 6, this.topPos + 124, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/left_gray_line.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 100, 24, 100, 24);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/right_gray_line.png"), this.leftPos + 99, this.topPos + 0, 0, 0, 100, 24, 100, 24);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_xp_bush"), 4, 7, -1, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_xp_bush_est_une_plant_qui_fait_p"), 2, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_des_xp_berries_qui_vous_donne_de"), 2, 35, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_quand_vous_faites_clique_droit_d"), 2, 46, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_vous_pouvez_les_compresser_en"), 2, 56, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_compressed_xp_berries"), 2, 67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_xp_berry"), 38, 92, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.xpbushpalahelpgui.label_xp_bush1"), 43, 134, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

		imagebutton_arrow_adminshop = new ImageButton(this.leftPos + 158, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_arrow_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new XpbushpalahelpguiButtonMessage(0, x, y, z));
				XpbushpalahelpguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});

		guistate.put("button:imagebutton_arrow_adminshop", imagebutton_arrow_adminshop);
		this.addRenderableWidget(imagebutton_arrow_adminshop);

		imagebutton_cross_no_button = new ImageButton(this.leftPos + 177, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_cross_no_button.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new XpbushpalahelpguiButtonMessage(1, x, y, z));
				XpbushpalahelpguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});

		guistate.put("button:imagebutton_cross_no_button", imagebutton_cross_no_button);
		this.addRenderableWidget(imagebutton_cross_no_button);

		imagebutton_home_pixel_adminshop = new ImageButton(this.leftPos + 139, this.topPos + 5, 16, 16, 0, 0, 16, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_home_pixel_adminshop.png"), 16, 32, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new XpbushpalahelpguiButtonMessage(2, x, y, z));
				XpbushpalahelpguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});

		guistate.put("button:imagebutton_home_pixel_adminshop", imagebutton_home_pixel_adminshop);
		this.addRenderableWidget(imagebutton_home_pixel_adminshop);

	}

}

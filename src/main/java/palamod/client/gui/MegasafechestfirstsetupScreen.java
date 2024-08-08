package palamod.client.gui;

public class MegasafechestfirstsetupScreen extends AbstractContainerScreen<MegasafechestfirstsetupMenu> {

	private final static HashMap<String, Object> guistate = MegasafechestfirstsetupMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	EditBox safe_code;

	Checkbox safe_link;

	Button button_save;

	public MegasafechestfirstsetupScreen(MegasafechestfirstsetupMenu container, Inventory inventory, Component text) {
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

		safe_code.render(guiGraphics, mouseX, mouseY, partialTicks);

		this.renderTooltip(guiGraphics, mouseX, mouseY);

	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/megasafechestfirstsetup.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}

		if (safe_code.isFocused())
			return safe_code.keyPressed(key, b, c);

		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		safe_code.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_safe_setup"), 55, 6, -13434625, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_1_enter_future_code_of_the_safe"), 4, 25, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_2do_you_want_link_safe_with"), 3, 64, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_this_account_bypass_the_code"), 2, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_it_you"), 3, 85, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.megasafechestfirstsetup.label_3_save"), 5, 122, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

		safe_code = new EditBox(this.font, this.leftPos + 9, this.topPos + 43, 118, 18, Component.translatable("gui.palamod.megasafechestfirstsetup.safe_code")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.palamod.megasafechestfirstsetup.safe_code").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.palamod.megasafechestfirstsetup.safe_code").getString());
				else
					setSuggestion(null);
			}
		};
		safe_code.setSuggestion(Component.translatable("gui.palamod.megasafechestfirstsetup.safe_code").getString());
		safe_code.setMaxLength(32767);

		guistate.put("text:safe_code", safe_code);
		this.addWidget(this.safe_code);

		button_save = Button.builder(Component.translatable("gui.palamod.megasafechestfirstsetup.button_save"), e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new MegasafechestfirstsetupButtonMessage(0, x, y, z));
				MegasafechestfirstsetupButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 26, this.topPos + 135, 46, 20).build();

		guistate.put("button:button_save", button_save);
		this.addRenderableWidget(button_save);

		safe_link = new Checkbox(this.leftPos + 5, this.topPos + 100, 20, 20, Component.translatable("gui.palamod.megasafechestfirstsetup.safe_link"), false);

		guistate.put("checkbox:safe_link", safe_link);
		this.addRenderableWidget(safe_link);
	}

}

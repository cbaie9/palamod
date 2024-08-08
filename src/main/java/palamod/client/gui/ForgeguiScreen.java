package palamod.client.gui;

public class ForgeguiScreen extends AbstractContainerScreen<ForgeguiMenu> {

	private final static HashMap<String, Object> guistate = ForgeguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ForgeguiScreen(ForgeguiMenu container, Inventory inventory, Component text) {
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

	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/forgegui.png"), this.leftPos + -1, this.topPos + 0, 0, 0, 176, 166, 176, 166);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_fullred_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);

		if (

		Forgesubprocessgui0Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_1red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui1Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_2red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui2Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_3red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui3Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_4red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui4Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_5red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui5Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_6red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui6Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_7red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui7Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_8red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui8Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_9red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui9Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_10red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui10Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_11red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui11Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_12red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui12Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_13red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui13Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_14red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui14Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_15red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui15Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_16red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui16Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_17red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui17Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_18red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}
		if (

		Forgesubprocessgui18Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_19red_new.png"), this.leftPos + 81, this.topPos + 38, 0, 0, 24, 10, 24, 10);
		}

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_1.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);

		if (

		Forgesubprocessfuelremaining2Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_2.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (

		Forgesubprocessfuelremaining3Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_3.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (

		Forgesubprocessfuelremaining4Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_4.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (

		Forgesubprocessfuelremaining5Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_5.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (

		Forgesubprocessfuelremaining6Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_6.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (

		Forgesubprocessfuelremaining7Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_7.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (

		Forgesubprocessfuelremaining8Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_8.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (

		Forgesubprocessfuelremaining9Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_9.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}
		if (

		Forgesubprocessfuelremaining10Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/fire_10.png"), this.leftPos + 61, this.topPos + 35, 0, 0, 16, 16, 16, 16);
		}

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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.forgegui.label_forge"), 71, 3, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.forgegui.label_inventory"), 6, 72, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

	}

}

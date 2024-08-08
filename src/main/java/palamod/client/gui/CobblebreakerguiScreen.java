package palamod.client.gui;

public class CobblebreakerguiScreen extends AbstractContainerScreen<CobblebreakerguiMenu> {

	private final static HashMap<String, Object> guistate = CobblebreakerguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CobblebreakerguiScreen(CobblebreakerguiMenu container, Inventory inventory, Component text) {
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/cobblebreakergui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 176, 180, 176, 180);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/particle_iron.png"), this.leftPos + 18, this.topPos + 42, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/particle_gold.png"), this.leftPos + 39, this.topPos + 43, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/particle_diamond.png"), this.leftPos + 60, this.topPos + 43, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/particle_titane.png"), this.leftPos + 102, this.topPos + 43, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/particle_paladium.png"), this.leftPos + 123, this.topPos + 43, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/green_paladium_particle.png"), this.leftPos + 144, this.topPos + 43, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/particle_amethyst.png"), this.leftPos + 81, this.topPos + 44, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0001.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);

		if (

		Cobblebreakergetcobbletick2Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0002.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick3Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0003.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick4Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0004.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick5Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0005.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick6Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0006.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick7Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0007.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick8Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0008.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick9Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0009.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick10Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0010.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick11Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0011.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick12Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0012.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick13Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0013.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick14Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0014.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick15Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0015.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick16Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0016.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick17Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0017.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick18Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0018.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick19Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0019.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}
		if (

		Cobblebreakergetcobbletick20Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/arrow_down0020.png"), this.leftPos + 82, this.topPos + 27, 0, 0, 14, 16, 14, 16);
		}

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/upgrade_cobblebreaker.png"), this.leftPos + 148, this.topPos + 14, 0, 0, 16, 16, 16, 16);

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
	}

	@Override
	public void init() {
		super.init();

	}

}

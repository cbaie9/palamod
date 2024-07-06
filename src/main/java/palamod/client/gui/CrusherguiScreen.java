package palamod.client.gui;

public class CrusherguiScreen extends AbstractContainerScreen<CrusherguiMenu> {

	private final static HashMap<String, Object> guistate = CrusherguiMenu.guistate;

	private final Level world;
	private final int x, y, z;
	private final Player entity;

	ImageButton imagebutton_button_blank;
	ImageButton imagebutton_button_white;
	ImageButton imagebutton_button_white1;
	ImageButton imagebutton_button_white2;

	public CrusherguiScreen(CrusherguiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 335;
		this.imageHeight = 205;
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

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/crushergui.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 335, 205, 335, 205);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/amethystmixedcoal.png"), this.leftPos + 177, this.topPos + 140, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/titanemixedcoal.png"), this.leftPos + 177, this.topPos + 158, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/goldmixedcoal.png"), this.leftPos + 177, this.topPos + 122, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/palamixedcoal.png"), this.leftPos + 175, this.topPos + 179, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/orangeblue_1.png"), this.leftPos + 7, this.topPos + 21, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/amethyst_ingot.png"), this.leftPos + 194, this.topPos + 22, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/titane_ingot.png"), this.leftPos + 194, this.topPos + 51, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/endium_ingot_vfufu.png"), this.leftPos + 312, this.topPos + 51, 0, 0, 16, 16, 16, 16);

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_ingot.png"), this.leftPos + 312, this.topPos + 20, 0, 0, 16, 16, 16, 16);

		if (

		Crushersubprocessv2n0Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher0.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n1Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher1.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n2Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher2.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n3Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher3.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n4Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher4.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n5Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher5.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n6Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher6.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n7Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher7.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n8Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher8.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n9Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher9.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}
		if (

		Crushersubprocessv2n10Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/flame_crusher10.png"), this.leftPos + 8, this.topPos + 38, 0, 0, 16, 16, 16, 16);
		}

		guiGraphics.blit(new ResourceLocation("palamod:textures/screens/paladium_mixed_coaltrans.png"), this.leftPos + 6, this.topPos + 56, 0, 0, 16, 16, 16, 16);

		if (

		Crushersubprocessv2progressbar1Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst1.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar2Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst2.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar3Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst3.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar4Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst4.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar5Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst5.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar6Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst6.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar7Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst7.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar8Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst8.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar9Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst9.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar11Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst11.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar12Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst12.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar13Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst13.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar14Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst14.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar15Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst15.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar16Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_ame_full.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar10Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_amethyst10.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbar0Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_empty.png"), this.leftPos + 208, this.topPos + 123, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane0Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_empty.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane1Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane1.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane2Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane2.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane3Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane3.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane4Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane4.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane5Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane5.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane6Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane6.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane7Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane7.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane8Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane8.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane9Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane9.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane10Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane10.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane11Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane11.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane12Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane12.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane13Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane13.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane14Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane14.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane15Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane15.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane16Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane16.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane17Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane17.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane18Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane18.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane19Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane19.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane20Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane20.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane21Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane21.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane22Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane22.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane23Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane23.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane24Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane24.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane25Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane25.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane26Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane26.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane27Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane27.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane28Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane28.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane29Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane29.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane30Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane30.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane31Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane31.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbartitane32Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_titane_full.png"), this.leftPos + 208, this.topPos + 140, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium0Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_empty.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium1Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium1.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium2Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium2.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium3Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium3.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium5Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium5.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium6Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium6.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium7Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium7.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium8Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium8.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium9Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium9.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium10Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium10.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium11Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium11.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium12Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium12.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium13Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium13.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium14Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium14.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium14Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium14.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium15Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium15.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium16Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium16.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium17Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium17.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium18Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium18.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium19Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium19.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium20Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium20.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium21Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium21.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium22Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium22.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium23Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium23.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium24Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium24.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium25Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium25.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium26Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium26.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium27Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium27.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium28Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium28.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium29Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium29.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium30Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium30.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium31Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium31.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarpaladium32Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_paladium_full.png"), this.leftPos + 208, this.topPos + 158, 0, 0, 100, 10, 100, 10);
		}
		if (

		Crushersubprocessv2progressbarendium0Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_100empty.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium1Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium1.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium2Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium2.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium3Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium3.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium4Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium4.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium5Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium5.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium6Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium6.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium7Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium7.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium8Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium8.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium9Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium9.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium10Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium10.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium11Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium11.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium12Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium12.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium13Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium13.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium14Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium14.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium15Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium15.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium16Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium16.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium17Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium17.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium18Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium18.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium19Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium19.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium20Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium20.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium21Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium21.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium22Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium22.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium23Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium23.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium24Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium24.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium25Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium25.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium26Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium26.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium27Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium27.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium28Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium28.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium29Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium29.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium30Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium30.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium31Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium31.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium32Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium32.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium33Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium33.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium34Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium34.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium35Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium35.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium36Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium36.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium37Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium37.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium38Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium38.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium39Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium39.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium40Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium40.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium41Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium41.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium42Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium42.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium43Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium43.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium44Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium44.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium45Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium45.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium46Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium46.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium47Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium47.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium48Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium48.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium49Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium49.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium50Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium50.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium51Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium51.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium52Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium52.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium53Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium53.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium54Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium54.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium55Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium55.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium56Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium56.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium57Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium57.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium58Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium58.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium59Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium59.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium60Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium60.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium61Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium61.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium62Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium62.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium63Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium63.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium64Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium64.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium65Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium65.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium66Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium66.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium67Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium67.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium68Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium68.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium69Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium69.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium70Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium70.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium71Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium71.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium72Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium72.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium73Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium73.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium74Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium74.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium75Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium75.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium76Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium76.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium77Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium77.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium78Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium78.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium79Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium79.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium80Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium80.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium81Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium81.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium82Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium82.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium83Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium83.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium84Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium84.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium85Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium85.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium86Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium86.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium87Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium87.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium88Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium88.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium89Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium89.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium90Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium90.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium91Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium91.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium92Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium92.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium93Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium93.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium94Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium94.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium95Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium95.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium96Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium96.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium97Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium97.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium98Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium98.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium99Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium99.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium100Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium100.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium101Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium101.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium102Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium102.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium103Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium103.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium104Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium104.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium105Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium105.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium106Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium106.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium107Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium107.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium108Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium108.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium109Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium109.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium110Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium110.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium111Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium111.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium112Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium112.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium113Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium113.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium114Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium114.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium115Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium115.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium116Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium116.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium117Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium117.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium118Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium118.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium119Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium119.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium120Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium120.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium121Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium121.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium122Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium122.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium123Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium123.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium124Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium124.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium125Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium125.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium126Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium126.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium127Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium127.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
		}
		if (

		Crushersubprocessv2progressbarendium128Procedure.execute(world, x, y, z)

		) {
			guiGraphics.blit(new ResourceLocation("palamod:textures/screens/progressbar_endium_full.png"), this.leftPos + 193, this.topPos + 179, 0, 0, 136, 10, 136, 10);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_paladium_crusher"), 121, 3, -3407821, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_inventaire"), 13, 111, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_fuel"), 27, 58, -3394816, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_fruits"), 26, 24, -3407668, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.palamod.crushergui.label_v2004"), 299, 192, -12829636, false);
		if (

		Crushertextad4Procedure.execute()

		)
			guiGraphics.drawString(this.font,

					CrushercustominfoameProcedure.execute(world, x, y, z), 123, 38, -12829636, false);
		if (

		Crushertextad3Procedure.execute()

		)
			guiGraphics.drawString(this.font,

					CrushercustominfotitaneProcedure.execute(world, x, y, z), 124, 70, -12829636, false);
		if (

		Crushertextad2Procedure.execute()

		)
			guiGraphics.drawString(this.font,

					CrushercustominfopaladiumProcedure.execute(world, x, y, z), 244, 39, -12829636, false);
		if (

		CrushertextadProcedure.execute()

		)
			guiGraphics.drawString(this.font,

					CrushercustominfoendiumProcedure.execute(world, x, y, z), 245, 70, -12829636, false);
	}

	@Override
	public void init() {
		super.init();

		imagebutton_button_blank = new ImageButton(this.leftPos + 214, this.topPos + 48, 92, 20, 0, 0, 20, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_button_blank.png"), 92, 40, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherguiButtonMessage(0, x, y, z));
				CrusherguiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});

		guistate.put("button:imagebutton_button_blank", imagebutton_button_blank);
		this.addRenderableWidget(imagebutton_button_blank);

		imagebutton_button_white = new ImageButton(this.leftPos + 215, this.topPos + 22, 92, 20, 0, 0, 20, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_button_white.png"), 92, 40, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherguiButtonMessage(1, x, y, z));
				CrusherguiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});

		guistate.put("button:imagebutton_button_white", imagebutton_button_white);
		this.addRenderableWidget(imagebutton_button_white);

		imagebutton_button_white1 = new ImageButton(this.leftPos + 99, this.topPos + 48, 92, 20, 0, 0, 20, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_button_white1.png"), 92, 40, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherguiButtonMessage(2, x, y, z));
				CrusherguiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});

		guistate.put("button:imagebutton_button_white1", imagebutton_button_white1);
		this.addRenderableWidget(imagebutton_button_white1);

		imagebutton_button_white2 = new ImageButton(this.leftPos + 99, this.topPos + 18, 92, 20, 0, 0, 20, new ResourceLocation("palamod:textures/screens/atlas/imagebutton_button_white2.png"), 92, 40, e -> {
			if (true) {
				PalamodMod.PACKET_HANDLER.sendToServer(new CrusherguiButtonMessage(3, x, y, z));
				CrusherguiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});

		guistate.put("button:imagebutton_button_white2", imagebutton_button_white2);
		this.addRenderableWidget(imagebutton_button_white2);

	}

}

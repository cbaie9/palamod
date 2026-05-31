package palamod.client.screens;

import palamod.procedures.FightingTimeOverlayGetLogicProcedure;
import palamod.procedures.FightingTimeOverlayGetLabelProcedure;
import palamod.procedures.FightimeOverlayGetindexProcedure;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.client.Minecraft;

@EventBusSubscriber(Dist.CLIENT)
public class FightingTimeOverlayOverlay {
	private static final ResourceLocation SPRITE_0 = ResourceLocation.parse("palamod:textures/screens/split_combat.png");

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (FightingTimeOverlayGetLogicProcedure.execute(entity)) {

			event.getGuiGraphics().blit(RenderPipelines.GUI_TEXTURED, SPRITE_0, 6, 4, Mth.clamp((int) FightimeOverlayGetindexProcedure.execute(entity) * 22, 0, 440), 0, 22, 22, 462, 22);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					FightingTimeOverlayGetLabelProcedure.execute(entity), 9, 29, -1, false);
		}
	}
}
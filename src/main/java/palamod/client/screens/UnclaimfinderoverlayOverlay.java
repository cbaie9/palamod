package palamod.client.screens;

import palamod.procedures.UnclaimfindergetpctgProcedure;
import palamod.procedures.HasunclaiminhandProcedure;
import palamod.procedures.GetunclaimfindertypeProcedure;

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
import net.minecraft.client.Minecraft;

@EventBusSubscriber(Dist.CLIENT)
public class UnclaimfinderoverlayOverlay {
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
		if (HasunclaiminhandProcedure.execute(entity)) {
			if (HasunclaiminhandProcedure.execute(entity)) {
				event.getGuiGraphics().blit(ResourceLocation.parse("palamod:textures/screens/overlay_unclaimfinder.png"), w - 51, 20, Mth.clamp((int) GetunclaimfindertypeProcedure.execute(entity) * 32, 0, 96), 0, 32, 32, 128, 32);
			}
			if (HasunclaiminhandProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						UnclaimfindergetpctgProcedure.execute(entity), w - 53, 39, -1, false);
		}
	}
}
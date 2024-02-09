
package palamod.client.screens;

import palamod.procedures.ReturnsnapshotoverlayProcedure;
import palamod.procedures.PalamodgameserververProcedure;
import palamod.procedures.DevchecksnapProcedure;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

@Mod.EventBusSubscriber({Dist.CLIENT})
public class SnapshotOverlay {
	@SubscribeEvent(priority = EventPriority.LOWEST)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
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
		if (true) {
			if (DevchecksnapProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.snapshot.label_paladium_creator_footage_devlopp"), w / 2 + -212, h / 2 + -110, -26368, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					ReturnsnapshotoverlayProcedure.execute(), w / 2 + -214, h / 2 + -122, -3407872, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					PalamodgameserververProcedure.execute(world), w / 2 + 109, h / 2 + 110, -39424, false);
		}
	}
}


package palamod.client.screens;

import palamod.procedures.OrelayershowProcedure;

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
public class OrelayerOverlay {
	@SubscribeEvent(priority = EventPriority.LOW)
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
		if (OrelayershowProcedure.execute()) {
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.orelayer.label_empty"), w / 2 + -211, h / 2 + -76, -1, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.orelayer.label_paladium_64_15"), w / 2 + -210, h / 2 + -31, -3407872, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.orelayer.label_endium_64_128_customs_p"), w / 2 + -211, h / 2 + -66, -16777114, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.orelayer.label_green_paladium_64_128"), w / 2 + -210, h / 2 + -55, -13395712, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.orelayer.label_titane_64_32"), w / 2 + -210, h / 2 + -20, -10066330, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.orelayer.label_amethyst_64_80"), w / 2 + -210, h / 2 + -9, -6750055, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.orelayer.label_findium_64_150"), w / 2 + -210, h / 2 + -45, -13312, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.orelayer.label_empty1"), w / 2 + -211, h / 2 + 2, -1, false);
		}
	}
}

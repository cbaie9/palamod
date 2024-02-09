
package palamod.client.screens;

import palamod.procedures.MinageprocessdynamicchecknbtProcedure;
import palamod.procedures.DynamicchecktitaneProcedure;
import palamod.procedures.Dynamicchecksector5Procedure;
import palamod.procedures.Dynamicchecksector4Procedure;
import palamod.procedures.Dynamicchecksector3Procedure;
import palamod.procedures.Dynamicchecksector2Procedure;
import palamod.procedures.Dynamicchecksector1Procedure;
import palamod.procedures.DynamiccheckendiumfullverenverProcedure;
import palamod.procedures.DynamiccheckendiumfullverProcedure;
import palamod.procedures.DynamiccheckamethystProcedure;
import palamod.procedures.DynamiccechkpaladiumProcedure;

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
public class DynamicorelayerOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
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
		if (MinageprocessdynamicchecknbtProcedure.execute(entity)) {
			if (DynamiccheckendiumfullverProcedure.execute(world, x, y, z, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_empty"), w / 2 + -211, h / 2 + -76, -1, false);
			if (DynamiccechkpaladiumProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_paladium_64_15"), w / 2 + -210, h / 2 + -9, -3407872, false);
			if (DynamiccheckendiumfullverProcedure.execute(world, x, y, z, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_endium_64_128_customs_p"), w / 2 + -211, h / 2 + -66, -16777114, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_green_paladium_64_128"), w / 2 + -210, h / 2 + -55, -13395712, false);
			if (DynamicchecktitaneProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_titane_64_32"), w / 2 + -210, h / 2 + -20, -10066330, false);
			if (DynamiccheckamethystProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_amethyst_64_80"), w / 2 + -211, h / 2 + -32, -6750055, false);
			event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_findium_64_150"), w / 2 + -211, h / 2 + -44, -13312, false);
			if (Dynamicchecksector5Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_empty1"), w / 2 + -211, h / 2 + 2, -1, false);
			if (Dynamicchecksector4Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_empty2"), w / 2 + -210, h / 2 + -9, -1, false);
			if (Dynamicchecksector3Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_empty3"), w / 2 + -210, h / 2 + -20, -1, false);
			if (DynamiccheckendiumfullverenverProcedure.execute(world, x, y, z, entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_empty4"), w / 2 + -212, h / 2 + -68, -1, false);
			if (Dynamicchecksector1Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_empty5"), w / 2 + -210, h / 2 + -45, -1, false);
			if (Dynamicchecksector2Procedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.palamod.dynamicorelayer.label_empty6"), w / 2 + -210, h / 2 + -31, -1, false);
		}
	}
}

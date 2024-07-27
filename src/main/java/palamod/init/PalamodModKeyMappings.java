
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.network.JobskeybindingMessage;
import palamod.network.FactionblindingMessage;
import palamod.network.AdminshopkeyblindingMessage;

import palamod.PalamodMod;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PalamodModKeyMappings {
	public static final KeyMapping ADMINSHOPKEYBLINDING = new KeyMapping("key.palamod.adminshopkeyblinding", GLFW.GLFW_KEY_O, "key.categories.palamod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PalamodMod.PACKET_HANDLER.sendToServer(new AdminshopkeyblindingMessage(0, 0));
				AdminshopkeyblindingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping FACTIONBLINDING = new KeyMapping("key.palamod.factionblinding", GLFW.GLFW_KEY_F, "key.categories.palamod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PalamodMod.PACKET_HANDLER.sendToServer(new FactionblindingMessage(0, 0));
				FactionblindingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping JOBSKEYBINDING = new KeyMapping("key.palamod.jobskeybinding", GLFW.GLFW_KEY_J, "key.categories.palamod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PalamodMod.PACKET_HANDLER.sendToServer(new JobskeybindingMessage(0, 0));
				JobskeybindingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ADMINSHOPKEYBLINDING);
		event.register(FACTIONBLINDING);
		event.register(JOBSKEYBINDING);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				ADMINSHOPKEYBLINDING.consumeClick();
				FACTIONBLINDING.consumeClick();
				JOBSKEYBINDING.consumeClick();
			}
		}
	}
}

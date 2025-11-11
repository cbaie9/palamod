/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.network.OpenclickerMessage;
import palamod.network.JobskeybindingMessage;
import palamod.network.FactionblindingMessage;
import palamod.network.AdminshopkeyblindingMessage;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.client.network.ClientPacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

@EventBusSubscriber(Dist.CLIENT)
public class PalamodModKeyMappings {
	public static final KeyMapping ADMINSHOPKEYBLINDING = new KeyMapping("key.palamod.adminshopkeyblinding", GLFW.GLFW_KEY_O, "key.categories.palamod") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new AdminshopkeyblindingMessage(0, 0));
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
				ClientPacketDistributor.sendToServer(new FactionblindingMessage(0, 0));
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
				ClientPacketDistributor.sendToServer(new JobskeybindingMessage(0, 0));
				JobskeybindingMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping OPENCLICKER = new KeyMapping("key.palamod.openclicker", GLFW.GLFW_KEY_K, "key.categories.ui") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				ClientPacketDistributor.sendToServer(new OpenclickerMessage(0, 0));
				OpenclickerMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(ADMINSHOPKEYBLINDING);
		event.register(FACTIONBLINDING);
		event.register(JOBSKEYBINDING);
		event.register(OPENCLICKER);
	}

	@EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				ADMINSHOPKEYBLINDING.consumeClick();
				FACTIONBLINDING.consumeClick();
				JOBSKEYBINDING.consumeClick();
				OPENCLICKER.consumeClick();
			}
		}
	}
}
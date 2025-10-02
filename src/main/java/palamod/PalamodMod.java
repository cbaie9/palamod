package palamod;

import palamod.world.features.StructureFeature;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModVillagerProfessions;
import palamod.init.PalamodModTabs;
import palamod.init.PalamodModSounds;
import palamod.init.PalamodModPotions;
import palamod.init.PalamodModParticleTypes;
import palamod.init.PalamodModMobEffects;
import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModFluids;
import palamod.init.PalamodModFluidTypes;
import palamod.init.PalamodModEntities;
import palamod.init.PalamodModBlocks;
import palamod.init.PalamodModBlockEntities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;

import net.minecraft.util.Tuple;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;

@Mod("palamod")
public class PalamodMod {
	public static final Logger LOGGER = LogManager.getLogger(PalamodMod.class);
	public static final String MODID = "palamod";

	public PalamodMod(IEventBus modEventBus) {
		// Start of user code block mod constructor
		// End of user code block mod constructor
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);
		PalamodModSounds.REGISTRY.register(modEventBus);
		PalamodModBlocks.REGISTRY.register(modEventBus);
		PalamodModBlockEntities.REGISTRY.register(modEventBus);
		PalamodModItems.REGISTRY.register(modEventBus);
		PalamodModEntities.REGISTRY.register(modEventBus);
		PalamodModTabs.REGISTRY.register(modEventBus);
		PalamodModVariables.ATTACHMENT_TYPES.register(modEventBus);

		StructureFeature.REGISTRY.register(modEventBus);
		PalamodModPotions.REGISTRY.register(modEventBus);
		PalamodModMobEffects.REGISTRY.register(modEventBus);
		PalamodModMenus.REGISTRY.register(modEventBus);
		PalamodModParticleTypes.REGISTRY.register(modEventBus);
		PalamodModVillagerProfessions.PROFESSIONS.register(modEventBus);
		PalamodModFluids.REGISTRY.register(modEventBus);
		PalamodModFluidTypes.REGISTRY.register(modEventBus);

		// Start of user code block mod init
		// End of user code block mod init
	}

	// Start of user code block mod methods
	// End of user code block mod methods
	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
	}

	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MODID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	private static final Collection<Tuple<Runnable, Integer>> workQueue = new ConcurrentLinkedQueue<>();

	public static void queueServerWork(int tick, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workQueue.add(new Tuple<>(action, tick));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		List<Tuple<Runnable, Integer>> actions = new ArrayList<>();
		workQueue.forEach(work -> {
			work.setB(work.getB() - 1);
			if (work.getB() == 0)
				actions.add(work);
		});
		actions.forEach(e -> e.getA().run());
		workQueue.removeAll(actions);
	}
}
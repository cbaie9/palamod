package palamod.network;

import palamod.PalamodMod;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PalamodModVariables {
	public static double alchemy = 0;
	public static double cooltick_spike = 0;
	public static String crusher_mode = "";
	public static double crusher_num_var = 0;
	public static double crusher_num_var_seen = 0;
	public static double g_num = 0;
	public static double Lucky_destroy = 0;
	public static String lucky_name = "no";
	public static String market_conf_name = "error:0notset";
	public static double market_conf_num = 0.0;
	public static double market_conf_price = 0.0;
	public static String furnace_processing = "-)";
	public static double Grinder_ingot = 4.0;
	public static double Golem_level = 0;
	public static double Golem_usable_point = 0;
	public static double Golem_pv = 0;
	public static String faction_create_ing = "100";
	public static double jump_y = 0;
	public static double jump_ecr = 0;
	public static double analy_ores = 0;
	public static double analy_dirt = 0;
	public static double analy_stone = 0;
	public static double analy_endstone = 0;
	public static double analy_clay = 0;
	public static double analy_cobble = 0;
	public static double analy_logs = 0;
	public static double analy_planks = 0;
	public static double analy_bedrock = 0;
	public static double analy_wool = 0;
	public static double analy_chest = 0;
	public static double analy_shulker = 0;
	public static double analy_air = 0;
	public static double analy_grass = 0;

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(SavedDataSyncMessage.class, SavedDataSyncMessage::buffer, SavedDataSyncMessage::new, SavedDataSyncMessage::handler);
		PalamodMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Faction_name = original.Faction_name;
			clone.Faction_xp = original.Faction_xp;
			clone.Faction_max_xp = original.Faction_max_xp;
			clone.jobs_get_text = original.jobs_get_text;
			clone.lvl_required = original.lvl_required;
			clone.jobs_get_text2 = original.jobs_get_text2;
			clone.jobs_get_text3 = original.jobs_get_text3;
			clone.jobs_durability = original.jobs_durability;
			clone.jobs_get_text4 = original.jobs_get_text4;
			clone.jobs_get_text5 = original.jobs_get_text5;
			if (!event.isWasDeath()) {
				clone.buyslot = original.buyslot;
			}
			if (!event.getEntity().level().isClientSide()) {
				for (Entity entityiterator : new ArrayList<>(event.getEntity().level().players())) {
					((PlayerVariables) entityiterator.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(entityiterator);
				}
			}
		}

		@SubscribeEvent
		public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData mapdata = MapVariables.get(event.getEntity().level());
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (mapdata != null)
					PalamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(0, mapdata));
				if (worlddata != null)
					PalamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}

		@SubscribeEvent
		public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getEntity().level().isClientSide()) {
				SavedData worlddata = WorldVariables.get(event.getEntity().level());
				if (worlddata != null)
					PalamodMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayer) event.getEntity()), new SavedDataSyncMessage(1, worlddata));
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final String DATA_NAME = "palamod_worldvars";

		public static WorldVariables load(CompoundTag tag) {
			WorldVariables data = new WorldVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level level && !level.isClientSide())
				PalamodMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(level::dimension), new SavedDataSyncMessage(1, this));
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(e -> WorldVariables.load(e), WorldVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final String DATA_NAME = "palamod_mapvars";
		public String coor_spawn = "";
		public double hdv_price1 = 0;
		public double hdv_price2 = 0;
		public double hdv_price3 = 0;
		public double hdv_price4 = 0;

		public static MapVariables load(CompoundTag tag) {
			MapVariables data = new MapVariables();
			data.read(tag);
			return data;
		}

		public void read(CompoundTag nbt) {
			coor_spawn = nbt.getString("coor_spawn");
			hdv_price1 = nbt.getDouble("hdv_price1");
			hdv_price2 = nbt.getDouble("hdv_price2");
			hdv_price3 = nbt.getDouble("hdv_price3");
			hdv_price4 = nbt.getDouble("hdv_price4");
		}

		@Override
		public CompoundTag save(CompoundTag nbt) {
			nbt.putString("coor_spawn", coor_spawn);
			nbt.putDouble("hdv_price1", hdv_price1);
			nbt.putDouble("hdv_price2", hdv_price2);
			nbt.putDouble("hdv_price3", hdv_price3);
			nbt.putDouble("hdv_price4", hdv_price4);
			return nbt;
		}

		public void syncData(LevelAccessor world) {
			this.setDirty();
			if (world instanceof Level && !world.isClientSide())
				PalamodMod.PACKET_HANDLER.send(PacketDistributor.ALL.noArg(), new SavedDataSyncMessage(0, this));
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAcc) {
				return serverLevelAcc.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(e -> MapVariables.load(e), MapVariables::new, DATA_NAME);
			} else {
				return clientSide;
			}
		}
	}

	public static class SavedDataSyncMessage {
		private final int type;
		private SavedData data;

		public SavedDataSyncMessage(FriendlyByteBuf buffer) {
			this.type = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			if (nbt != null) {
				this.data = this.type == 0 ? new MapVariables() : new WorldVariables();
				if (this.data instanceof MapVariables mapVariables)
					mapVariables.read(nbt);
				else if (this.data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt);
			}
		}

		public SavedDataSyncMessage(int type, SavedData data) {
			this.type = type;
			this.data = data;
		}

		public static void buffer(SavedDataSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeInt(message.type);
			if (message.data != null)
				buffer.writeNbt(message.data.save(new CompoundTag()));
		}

		public static void handler(SavedDataSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer() && message.data != null) {
					if (message.type == 0)
						MapVariables.clientSide = (MapVariables) message.data;
					else
						WorldVariables.clientSide = (WorldVariables) message.data;
				}
			});
			context.setPacketHandled(true);
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("palamod", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public String Faction_name = "\"\"";
		public double Faction_xp = 0;
		public double Faction_max_xp = 0;
		public double buyslot = 0;
		public String jobs_get_text = "\"\"";
		public String lvl_required = "\"\"";
		public String jobs_get_text2 = "\"\"";
		public String jobs_get_text3 = "\"\"";
		public String jobs_durability = "\"\"";
		public String jobs_get_text4 = "\"\"";
		public String jobs_get_text5 = "\"\"";

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PalamodMod.PACKET_HANDLER.send(PacketDistributor.DIMENSION.with(entity.level()::dimension), new PlayerVariablesSyncMessage(this, entity.getId()));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("Faction_name", Faction_name);
			nbt.putDouble("Faction_xp", Faction_xp);
			nbt.putDouble("Faction_max_xp", Faction_max_xp);
			nbt.putDouble("buyslot", buyslot);
			nbt.putString("jobs_get_text", jobs_get_text);
			nbt.putString("lvl_required", lvl_required);
			nbt.putString("jobs_get_text2", jobs_get_text2);
			nbt.putString("jobs_get_text3", jobs_get_text3);
			nbt.putString("jobs_durability", jobs_durability);
			nbt.putString("jobs_get_text4", jobs_get_text4);
			nbt.putString("jobs_get_text5", jobs_get_text5);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Faction_name = nbt.getString("Faction_name");
			Faction_xp = nbt.getDouble("Faction_xp");
			Faction_max_xp = nbt.getDouble("Faction_max_xp");
			buyslot = nbt.getDouble("buyslot");
			jobs_get_text = nbt.getString("jobs_get_text");
			lvl_required = nbt.getString("lvl_required");
			jobs_get_text2 = nbt.getString("jobs_get_text2");
			jobs_get_text3 = nbt.getString("jobs_get_text3");
			jobs_durability = nbt.getString("jobs_durability");
			jobs_get_text4 = nbt.getString("jobs_get_text4");
			jobs_get_text5 = nbt.getString("jobs_get_text5");
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	public static class PlayerVariablesSyncMessage {
		private final int target;
		private final PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
			this.target = buffer.readInt();
		}

		public PlayerVariablesSyncMessage(PlayerVariables data, int entityid) {
			this.data = data;
			this.target = entityid;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
			buffer.writeInt(message.target);
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.level().getEntity(message.target).getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Faction_name = message.data.Faction_name;
					variables.Faction_xp = message.data.Faction_xp;
					variables.Faction_max_xp = message.data.Faction_max_xp;
					variables.buyslot = message.data.buyslot;
					variables.jobs_get_text = message.data.jobs_get_text;
					variables.lvl_required = message.data.lvl_required;
					variables.jobs_get_text2 = message.data.jobs_get_text2;
					variables.jobs_get_text3 = message.data.jobs_get_text3;
					variables.jobs_durability = message.data.jobs_durability;
					variables.jobs_get_text4 = message.data.jobs_get_text4;
					variables.jobs_get_text5 = message.data.jobs_get_text5;
				}
			});
			context.setPacketHandled(true);
		}
	}
}

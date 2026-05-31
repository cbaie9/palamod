package palamod.network;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.ValueIOSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.TagValueOutput;
import net.minecraft.world.level.storage.TagValueInput;
import net.minecraft.world.level.saveddata.SavedDataType;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.util.ProblemReporter;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import java.util.function.Supplier;

import java.io.File;

@EventBusSubscriber
public class PalamodModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PalamodMod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(PlayerVariables::new).build());
	public static double alchemy = 0;
	public static double cooltick_spike = 0;
	public static String crusher_mode = "";
	public static double crusher_num_var = 0.0;
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
	public static double analy_chest = 0.0;
	public static double analy_shulker = 0;
	public static double analy_air = 0;
	public static double analy_grass = 0;
	public static File server_path_cache = new File("");

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PalamodMod.addNetworkMessage(SavedDataSyncMessage.TYPE, SavedDataSyncMessage.STREAM_CODEC, SavedDataSyncMessage::handleData);
		PalamodMod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@SubscribeEvent
	public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player)
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
	}

	@SubscribeEvent
	public static void onPlayerTickUpdateSyncPlayerVariables(PlayerTickEvent.Post event) {
		if (event.getEntity() instanceof ServerPlayer player && player.getData(PLAYER_VARIABLES)._syncDirty) {
			PacketDistributor.sendToPlayer(player, new PlayerVariablesSyncMessage(player.getData(PLAYER_VARIABLES)));
			player.getData(PLAYER_VARIABLES)._syncDirty = false;
		}
	}

	@SubscribeEvent
	public static void clonePlayer(PlayerEvent.Clone event) {
		PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
		PlayerVariables clone = new PlayerVariables();
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
		clone.last_unlocked_miner = original.last_unlocked_miner;
		clone.last_unlocked_farmer = original.last_unlocked_farmer;
		clone.last_unlocked_hunter = original.last_unlocked_hunter;
		if (!event.isWasDeath()) {
			clone.buyslot = original.buyslot;
			clone.last_unlocked_alchi = original.last_unlocked_alchi;
		}
		event.getEntity().setData(PLAYER_VARIABLES, clone);
	}

	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData mapdata = MapVariables.get(player.level());
			SavedData worlddata = WorldVariables.get(player.level());
			if (mapdata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(0, mapdata));
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (event.getEntity() instanceof ServerPlayer player) {
			SavedData worlddata = WorldVariables.get(player.level());
			if (worlddata != null)
				PacketDistributor.sendToPlayer(player, new SavedDataSyncMessage(1, worlddata));
		}
	}

	@SubscribeEvent
	public static void onWorldTick(LevelTickEvent.Post event) {
		if (event.getLevel() instanceof ServerLevel level) {
			WorldVariables worldVariables = WorldVariables.get(level);
			if (worldVariables._syncDirty) {
				PacketDistributor.sendToPlayersInDimension(level, new SavedDataSyncMessage(1, worldVariables));
				worldVariables._syncDirty = false;
			}
			MapVariables mapVariables = MapVariables.get(level);
			if (mapVariables._syncDirty) {
				PacketDistributor.sendToAllPlayers(new SavedDataSyncMessage(0, mapVariables));
				mapVariables._syncDirty = false;
			}
		}
	}

	public static class WorldVariables extends SavedData {
		public static final SavedDataType<WorldVariables> TYPE = new SavedDataType<>(Identifier.parse("palamod:worldvars"), level -> new WorldVariables(), level -> CompoundTag.CODEC.xmap(tag -> {
			WorldVariables instance = new WorldVariables();
			instance.read(tag, level.registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), level.registryAccess())));
		boolean _syncDirty = false;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static WorldVariables clientSide = new WorldVariables();

		public static WorldVariables get(LevelAccessor world) {
			if (world instanceof ServerLevel level) {
				return level.getDataStorage().computeIfAbsent(WorldVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public static class MapVariables extends SavedData {
		public static final SavedDataType<MapVariables> TYPE = new SavedDataType<>(Identifier.parse("palamod:mapvars"), level -> new MapVariables(), level -> CompoundTag.CODEC.xmap(tag -> {
			MapVariables instance = new MapVariables();
			instance.read(tag, level.registryAccess());
			return instance;
		}, instance -> instance.save(new CompoundTag(), level.registryAccess())));
		boolean _syncDirty = false;
		public String coor_spawn = "";
		public double hdv_price1 = 0;
		public double hdv_price2 = 0.0;
		public double hdv_price3 = 0;
		public double hdv_price4 = 0;
		public double clicker_page = 1.0;
		public double cps_cooldown = 20.0;

		public void read(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			coor_spawn = nbt.getStringOr("coor_spawn", "");
			hdv_price1 = nbt.getDoubleOr("hdv_price1", 0);
			hdv_price2 = nbt.getDoubleOr("hdv_price2", 0);
			hdv_price3 = nbt.getDoubleOr("hdv_price3", 0);
			hdv_price4 = nbt.getDoubleOr("hdv_price4", 0);
			clicker_page = nbt.getDoubleOr("clicker_page", 0);
			cps_cooldown = nbt.getDoubleOr("cps_cooldown", 0);
		}

		public CompoundTag save(CompoundTag nbt, HolderLookup.Provider lookupProvider) {
			nbt.putString("coor_spawn", coor_spawn);
			nbt.putDouble("hdv_price1", hdv_price1);
			nbt.putDouble("hdv_price2", hdv_price2);
			nbt.putDouble("hdv_price3", hdv_price3);
			nbt.putDouble("hdv_price4", hdv_price4);
			nbt.putDouble("clicker_page", clicker_page);
			nbt.putDouble("cps_cooldown", cps_cooldown);
			return nbt;
		}

		public void markSyncDirty() {
			this.setDirty();
			this._syncDirty = true;
		}

		static MapVariables clientSide = new MapVariables();

		public static MapVariables get(LevelAccessor world) {
			if (world instanceof ServerLevelAccessor serverLevelAccessor) {
				return serverLevelAccessor.getLevel().getServer().getLevel(Level.OVERWORLD).getDataStorage().computeIfAbsent(MapVariables.TYPE);
			} else {
				return clientSide;
			}
		}
	}

	public record SavedDataSyncMessage(int dataType, SavedData data) implements CustomPacketPayload {
		public static final Type<SavedDataSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PalamodMod.MODID, "saved_data_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, SavedDataSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, SavedDataSyncMessage message) -> {
			buffer.writeInt(message.dataType);
			if (message.data instanceof MapVariables mapVariables)
				buffer.writeNbt(mapVariables.save(new CompoundTag(), buffer.registryAccess()));
			else if (message.data instanceof WorldVariables worldVariables)
				buffer.writeNbt(worldVariables.save(new CompoundTag(), buffer.registryAccess()));
		}, (RegistryFriendlyByteBuf buffer) -> {
			int dataType = buffer.readInt();
			CompoundTag nbt = buffer.readNbt();
			SavedData data = null;
			if (nbt != null) {
				data = dataType == 0 ? new MapVariables() : new WorldVariables();
				if (data instanceof MapVariables mapVariables)
					mapVariables.read(nbt, buffer.registryAccess());
				else if (data instanceof WorldVariables worldVariables)
					worldVariables.read(nbt, buffer.registryAccess());
			}
			return new SavedDataSyncMessage(dataType, data);
		});

		@Override
		public Type<SavedDataSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final SavedDataSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					if (message.dataType == 0)
						MapVariables.clientSide.read(((MapVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
					else
						WorldVariables.clientSide.read(((WorldVariables) message.data).save(new CompoundTag(), context.player().registryAccess()), context.player().registryAccess());
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}

	public static class PlayerVariables implements ValueIOSerializable {
		boolean _syncDirty = false;
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
		public String last_unlocked_miner = "\"go farm something\"";
		public String last_unlocked_farmer = "\"go farm something\"";
		public String last_unlocked_hunter = "\"go farm something\"";
		public String last_unlocked_alchi = "\"go farm something\"";

		@Override
		public void serialize(ValueOutput output) {
			output.putString("Faction_name", Faction_name);
			output.putDouble("Faction_xp", Faction_xp);
			output.putDouble("Faction_max_xp", Faction_max_xp);
			output.putDouble("buyslot", buyslot);
			output.putString("jobs_get_text", jobs_get_text);
			output.putString("lvl_required", lvl_required);
			output.putString("jobs_get_text2", jobs_get_text2);
			output.putString("jobs_get_text3", jobs_get_text3);
			output.putString("jobs_durability", jobs_durability);
			output.putString("jobs_get_text4", jobs_get_text4);
			output.putString("jobs_get_text5", jobs_get_text5);
			output.putString("last_unlocked_miner", last_unlocked_miner);
			output.putString("last_unlocked_farmer", last_unlocked_farmer);
			output.putString("last_unlocked_hunter", last_unlocked_hunter);
			output.putString("last_unlocked_alchi", last_unlocked_alchi);
		}

		@Override
		public void deserialize(ValueInput input) {
			Faction_name = input.getStringOr("Faction_name", "");
			Faction_xp = input.getDoubleOr("Faction_xp", 0);
			Faction_max_xp = input.getDoubleOr("Faction_max_xp", 0);
			buyslot = input.getDoubleOr("buyslot", 0);
			jobs_get_text = input.getStringOr("jobs_get_text", "");
			lvl_required = input.getStringOr("lvl_required", "");
			jobs_get_text2 = input.getStringOr("jobs_get_text2", "");
			jobs_get_text3 = input.getStringOr("jobs_get_text3", "");
			jobs_durability = input.getStringOr("jobs_durability", "");
			jobs_get_text4 = input.getStringOr("jobs_get_text4", "");
			jobs_get_text5 = input.getStringOr("jobs_get_text5", "");
			last_unlocked_miner = input.getStringOr("last_unlocked_miner", "");
			last_unlocked_farmer = input.getStringOr("last_unlocked_farmer", "");
			last_unlocked_hunter = input.getStringOr("last_unlocked_hunter", "");
			last_unlocked_alchi = input.getStringOr("last_unlocked_alchi", "");
		}

		public void markSyncDirty() {
			_syncDirty = true;
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(Identifier.fromNamespaceAndPath(PalamodMod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> {
			TagValueOutput output = TagValueOutput.createWithoutContext(ProblemReporter.DISCARDING);
			message.data.serialize(output);
			buffer.writeNbt(output.buildResult());
		}, (RegistryFriendlyByteBuf buffer) -> {
			PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
			message.data.deserialize(TagValueInput.create(ProblemReporter.DISCARDING, buffer.registryAccess(), buffer.readNbt()));
			return message;
		});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> {
					TagValueOutput output = TagValueOutput.createWithContext(ProblemReporter.DISCARDING, context.player().registryAccess());
					message.data.serialize(output);
					context.player().getData(PLAYER_VARIABLES).deserialize(TagValueInput.create(ProblemReporter.DISCARDING, context.player().registryAccess(), output.buildResult()));
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}
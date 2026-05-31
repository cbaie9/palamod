/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.block.entity.*;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.items.wrapper.SidedInvWrapper;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

@EventBusSubscriber
public class PalamodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PalamodMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PaladiumcrusherBlockEntity>> PALADIUM_CRUSHER = register("paladium_crusher", PalamodModBlocks.PALADIUM_CRUSHER, PaladiumcrusherBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<NbtblockBlockEntity>> NBT_BLOCK = register("nbt_block", PalamodModBlocks.NBT_BLOCK, NbtblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<XpbushBlockEntity>> XP_BUSH = register("xp_bush", PalamodModBlocks.XP_BUSH, XpbushBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<XpbushonBlockEntity>> XP_BUSH_ON = register("xp_bush_on", PalamodModBlocks.XP_BUSH_ON, XpbushonBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Alchimet1BlockEntity>> ALCHIMET_1 = register("alchimet_1", PalamodModBlocks.ALCHIMET_1, Alchimet1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GrinderblockBlockEntity>> GRINDER_BLOCK = register("grinder_block", PalamodModBlocks.GRINDER_BLOCK, GrinderblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PaladiumfurnaceBlockEntity>> PALADIUM_FURNACE = register("paladium_furnace", PalamodModBlocks.PALADIUM_FURNACE, PaladiumfurnaceBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PaladiumfurnaceonBlockEntity>> PALADIUM_FURNACE_ON = register("paladium_furnace_on", PalamodModBlocks.PALADIUM_FURNACE_ON, PaladiumfurnaceonBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PaladiumforgeBlockEntity>> PALADIUM_FORGE = register("paladium_forge", PalamodModBlocks.PALADIUM_FORGE, PaladiumforgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Tcv2BlockEntity>> TCV_2 = register("tcv_2", PalamodModBlocks.TCV_2, Tcv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PaladiummachineBlockEntity>> PALADIUM_MACHINE = register("paladium_machine", PalamodModBlocks.PALADIUM_MACHINE, PaladiummachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<LuckyblockBlockEntity>> LUCKY_BLOCK = register("lucky_block", PalamodModBlocks.LUCKY_BLOCK, LuckyblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<MegasafechestBlockEntity>> MEGA_SAFE_CHEST = register("mega_safe_chest", PalamodModBlocks.MEGA_SAFE_CHEST, MegasafechestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TrixiumnbtblockBlockEntity>> TRIXIUM_NBT_BLOCK = register("trixium_nbt_block", PalamodModBlocks.TRIXIUM_NBT_BLOCK, TrixiumnbtblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CloudblockBlockEntity>> CLOUD_BLOCK = register("cloud_block", PalamodModBlocks.CLOUD_BLOCK, CloudblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FactionblckBlockEntity>> FACTION_BLOCK = register("faction_block", PalamodModBlocks.FACTION_BLOCK, FactionblckBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<UploaderBlockEntity>> UPLOADER = register("uploader", PalamodModBlocks.UPLOADER, UploaderBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HdvblockBlockEntity>> HDV_BLOCK = register("hdv_block", PalamodModBlocks.HDV_BLOCK, HdvblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TitanechestBlockEntity>> FLATTEN_TITANE_CHEST = register("flatten_titane_chest", PalamodModBlocks.FLATTEN_TITANE_CHEST, TitanechestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PaladiumchestBlockEntity>> FLATTEN_PALADIUM_CHEST = register("flatten_paladium_chest", PalamodModBlocks.FLATTEN_PALADIUM_CHEST, PaladiumchestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AmethystchestBlockEntity>> FLATTEN_AMETHYST_CHEST = register("flatten_amethyst_chest", PalamodModBlocks.FLATTEN_AMETHYST_CHEST, AmethystchestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GreenpaladiumchestBlockEntity>> FLATTEN_GREEN_PALADIUM_CHEST = register("flatten_green_paladium_chest", PalamodModBlocks.FLATTEN_GREEN_PALADIUM_CHEST,
			GreenpaladiumchestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EndiumchestBlockEntity>> FLATTEN_ENDIUM_CHEST = register("flatten_endium_chest", PalamodModBlocks.FLATTEN_ENDIUM_CHEST, EndiumchestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DownloaderBlockEntity>> DOWNLOADER = register("downloader", PalamodModBlocks.DOWNLOADER, DownloaderBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Paladiumchestv2BlockEntity>> PALADIUM_CHEST = register("paladium_chest", PalamodModBlocks.PALADIUM_CHEST, Paladiumchestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Greenpaladiumchestv2BlockEntity>> GREEN_PALADIUM_CHEST = register("green_paladium_chest", PalamodModBlocks.GREEN_PALADIUM_CHEST, Greenpaladiumchestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Amethystchestv2BlockEntity>> AMETHYST_CHEST = register("amethyst_chest", PalamodModBlocks.AMETHYST_CHEST, Amethystchestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Endiumchestv2BlockEntity>> ENDIUM_CHEST = register("endium_chest", PalamodModBlocks.ENDIUM_CHEST, Endiumchestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<Titanechestv2BlockEntity>> TITANE_CHEST = register("titane_chest", PalamodModBlocks.TITANE_CHEST, Titanechestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OnlinedetectorBlockEntity>> ONLINE_DETECTOR = register("online_detector", PalamodModBlocks.ONLINE_DETECTOR, OnlinedetectorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<OnlinedetectoronBlockEntity>> ONLINE_DETECTOR_ON = register("online_detector_on", PalamodModBlocks.ONLINE_DETECTOR_ON, OnlinedetectoronBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobblebreakerBlockEntity>> COBBLEBREAKER = register("cobblebreaker", PalamodModBlocks.COBBLEBREAKER, CobblebreakerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PrintingpressBlockEntity>> PRINTINGPRESS = register("printingpress", PalamodModBlocks.PRINTINGPRESS, PrintingpressBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TypesettingtableBlockEntity>> TYPESETTINGTABLE = register("typesettingtable", PalamodModBlocks.TYPESETTINGTABLE, TypesettingtableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<DrawbridgeBlockEntity>> DRAWBRIDGE = register("drawbridge", PalamodModBlocks.DRAWBRIDGE, DrawbridgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<ExctractorBlockEntity>> EXTRACTOR = register("extractor", PalamodModBlocks.EXTRACTOR, ExctractorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TotemfertilityBlockEntity>> TOTEM_FERTILITY = register("totem_fertility", PalamodModBlocks.TOTEM_FERTILITY, TotemfertilityBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<XpbushlowBlockEntity>> XP_BUSH_LOW = register("xp_bush_low", PalamodModBlocks.XP_BUSH_LOW, XpbushlowBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CobblebreakerserverBlockEntity>> COBBLEBREAKER_SERVER = register("cobblebreaker_server", PalamodModBlocks.COBBLEBREAKER_SERVER, CobblebreakerserverBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<FlowertotemBlockEntity>> FLOWER_TOTEM = register("flower_totem", PalamodModBlocks.FLOWER_TOTEM, FlowertotemBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<SpawncontrollerBlockEntity>> SPAWN_CONTROLLER = register("spawn_controller", PalamodModBlocks.SPAWN_CONTROLLER, SpawncontrollerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EmptyspawnerBlockEntity>> EMPTY_SPAWNER = register("empty_spawner", PalamodModBlocks.EMPTY_SPAWNER, EmptyspawnerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AmethysttankBlockEntity>> AMETHYST_TANK = register("amethyst_tank", PalamodModBlocks.AMETHYST_TANK, AmethysttankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<GoldentankBlockEntity>> GOLDEN_TANK = register("golden_tank", PalamodModBlocks.GOLDEN_TANK, GoldentankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TitanetankBlockEntity>> TITANE_TANK = register("titane_tank", PalamodModBlocks.TITANE_TANK, TitanetankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PaladiumTankBlockEntity>> PALADIUM_TANK = register("paladium_tank", PalamodModBlocks.PALADIUM_TANK, PaladiumTankBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<CauldronCoreBlockEntity>> CAULDRON_CORE = register("cauldron_core", PalamodModBlocks.CAULDRON_CORE, CauldronCoreBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<AmethystPortalblockBlockEntity>> AMETHYST_PORTALBLOCK = register("amethyst_portalblock", PalamodModBlocks.AMETHYST_PORTALBLOCK, AmethystPortalblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<TitanePortalBlockBlockEntity>> TITANE_PORTAL_BLOCK = register("titane_portal_block", PalamodModBlocks.TITANE_PORTAL_BLOCK, TitanePortalBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<PaladiumPortalBlockBlockEntity>> PALADIUM_PORTAL_BLOCK = register("paladium_portal_block", PalamodModBlocks.PALADIUM_PORTAL_BLOCK, PaladiumPortalBlockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<EndiumPortalBlockBlockEntity>> ENDIUM_PORTAL_BLOCK = register("endium_portal_block", PalamodModBlocks.ENDIUM_PORTAL_BLOCK, EndiumPortalBlockBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static <T extends BlockEntity> DeferredHolder<BlockEntityType<?>, BlockEntityType<T>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<T> supplier) {
		return REGISTRY.register(registryname, () -> new BlockEntityType(supplier, block.get()));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_CRUSHER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, NBT_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, XP_BUSH.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, XP_BUSH_ON.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ALCHIMET_1.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRINDER_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_FURNACE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_FURNACE_ON.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_FORGE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TCV_2.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_MACHINE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LUCKY_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MEGA_SAFE_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRIXIUM_NBT_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CLOUD_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FACTION_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UPLOADER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HDV_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_TITANE_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_PALADIUM_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_AMETHYST_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_GREEN_PALADIUM_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_ENDIUM_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DOWNLOADER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GREEN_PALADIUM_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AMETHYST_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ENDIUM_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TITANE_CHEST.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ONLINE_DETECTOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ONLINE_DETECTOR_ON.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COBBLEBREAKER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PRINTINGPRESS.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TYPESETTINGTABLE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DRAWBRIDGE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EXTRACTOR.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TOTEM_FERTILITY.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, XP_BUSH_LOW.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COBBLEBREAKER_SERVER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLOWER_TOTEM.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, SPAWN_CONTROLLER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EMPTY_SPAWNER.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AMETHYST_TANK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GOLDEN_TANK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TITANE_TANK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_TANK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CAULDRON_CORE.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AMETHYST_PORTALBLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TITANE_PORTAL_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_PORTAL_BLOCK.get(), SidedInvWrapper::new);
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ENDIUM_PORTAL_BLOCK.get(), SidedInvWrapper::new);
	}
}
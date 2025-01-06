
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.block.entity.UploaderBlockEntity;
import palamod.block.entity.TypesettingtableBlockEntity;
import palamod.block.entity.TypesettingplateBlockEntity;
import palamod.block.entity.TypesettingmaxBlockEntity;
import palamod.block.entity.TypesettingbookBlockEntity;
import palamod.block.entity.TrixiumnbtblockBlockEntity;
import palamod.block.entity.Titanechestv2BlockEntity;
import palamod.block.entity.TitanechestBlockEntity;
import palamod.block.entity.Tcv2BlockEntity;
import palamod.block.entity.PrintingpressBlockEntity;
import palamod.block.entity.PaladiummachineBlockEntity;
import palamod.block.entity.PaladiumfurnaceonBlockEntity;
import palamod.block.entity.PaladiumfurnaceBlockEntity;
import palamod.block.entity.PaladiumforgeBlockEntity;
import palamod.block.entity.PaladiumcrusherBlockEntity;
import palamod.block.entity.Paladiumchestv2BlockEntity;
import palamod.block.entity.PaladiumchestBlockEntity;
import palamod.block.entity.OnlinedetectoronBlockEntity;
import palamod.block.entity.OnlinedetectorBlockEntity;
import palamod.block.entity.NbtblockBlockEntity;
import palamod.block.entity.MegasafechestBlockEntity;
import palamod.block.entity.LuckyblockBlockEntity;
import palamod.block.entity.HdvblockBlockEntity;
import palamod.block.entity.GrinderblockBlockEntity;
import palamod.block.entity.Greenpaladiumchestv2BlockEntity;
import palamod.block.entity.GreenpaladiumchestBlockEntity;
import palamod.block.entity.FactionblckBlockEntity;
import palamod.block.entity.ExctractorBlockEntity;
import palamod.block.entity.Endiumchestv2BlockEntity;
import palamod.block.entity.EndiumchestBlockEntity;
import palamod.block.entity.DrawbridgeBlockEntity;
import palamod.block.entity.DownloaderBlockEntity;
import palamod.block.entity.CobblebreakerBlockEntity;
import palamod.block.entity.CloudblockBlockEntity;
import palamod.block.entity.Amethystchestv2BlockEntity;
import palamod.block.entity.AmethystchestBlockEntity;
import palamod.block.entity.Alchimet1BlockEntity;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.BuiltInRegistries;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PalamodModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, PalamodMod.MODID);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PALADIUM_CRUSHER = register("paladium_crusher", PalamodModBlocks.PALADIUM_CRUSHER, PaladiumcrusherBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> NBT_BLOCK = register("nbt_block", PalamodModBlocks.NBT_BLOCK, NbtblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ALCHIMET_1 = register("alchimet_1", PalamodModBlocks.ALCHIMET_1, Alchimet1BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GRINDER_BLOCK = register("grinder_block", PalamodModBlocks.GRINDER_BLOCK, GrinderblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PALADIUM_FURNACE = register("paladium_furnace", PalamodModBlocks.PALADIUM_FURNACE, PaladiumfurnaceBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PALADIUM_FURNACE_ON = register("paladium_furnace_on", PalamodModBlocks.PALADIUM_FURNACE_ON, PaladiumfurnaceonBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PALADIUM_FORGE = register("paladium_forge", PalamodModBlocks.PALADIUM_FORGE, PaladiumforgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TCV_2 = register("tcv_2", PalamodModBlocks.TCV_2, Tcv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PALADIUM_MACHINE = register("paladium_machine", PalamodModBlocks.PALADIUM_MACHINE, PaladiummachineBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> LUCKY_BLOCK = register("lucky_block", PalamodModBlocks.LUCKY_BLOCK, LuckyblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> MEGA_SAFE_CHEST = register("mega_safe_chest", PalamodModBlocks.MEGA_SAFE_CHEST, MegasafechestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TRIXIUM_NBT_BLOCK = register("trixium_nbt_block", PalamodModBlocks.TRIXIUM_NBT_BLOCK, TrixiumnbtblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> CLOUD_BLOCK = register("cloud_block", PalamodModBlocks.CLOUD_BLOCK, CloudblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FACTION_BLOCK = register("faction_block", PalamodModBlocks.FACTION_BLOCK, FactionblckBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> UPLOADER = register("uploader", PalamodModBlocks.UPLOADER, UploaderBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> HDV_BLOCK = register("hdv_block", PalamodModBlocks.HDV_BLOCK, HdvblockBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FLATTEN_TITANE_CHEST = register("flatten_titane_chest", PalamodModBlocks.FLATTEN_TITANE_CHEST, TitanechestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FLATTEN_PALADIUM_CHEST = register("flatten_paladium_chest", PalamodModBlocks.FLATTEN_PALADIUM_CHEST, PaladiumchestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FLATTEN_AMETHYST_CHEST = register("flatten_amethyst_chest", PalamodModBlocks.FLATTEN_AMETHYST_CHEST, AmethystchestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FLATTEN_GREEN_PALADIUM_CHEST = register("flatten_green_paladium_chest", PalamodModBlocks.FLATTEN_GREEN_PALADIUM_CHEST, GreenpaladiumchestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> FLATTEN_ENDIUM_CHEST = register("flatten_endium_chest", PalamodModBlocks.FLATTEN_ENDIUM_CHEST, EndiumchestBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DOWNLOADER = register("downloader", PalamodModBlocks.DOWNLOADER, DownloaderBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PALADIUM_CHEST = register("paladium_chest", PalamodModBlocks.PALADIUM_CHEST, Paladiumchestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> GREEN_PALADIUM_CHEST = register("green_paladium_chest", PalamodModBlocks.GREEN_PALADIUM_CHEST, Greenpaladiumchestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> AMETHYST_CHEST = register("amethyst_chest", PalamodModBlocks.AMETHYST_CHEST, Amethystchestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ENDIUM_CHEST = register("endium_chest", PalamodModBlocks.ENDIUM_CHEST, Endiumchestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TITANE_CHEST = register("titane_chest", PalamodModBlocks.TITANE_CHEST, Titanechestv2BlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ONLINE_DETECTOR = register("online_detector", PalamodModBlocks.ONLINE_DETECTOR, OnlinedetectorBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> ONLINE_DETECTOR_ON = register("online_detector_on", PalamodModBlocks.ONLINE_DETECTOR_ON, OnlinedetectoronBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> COBBLEBREAKER = register("cobblebreaker", PalamodModBlocks.COBBLEBREAKER, CobblebreakerBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> PRINTINGPRESS = register("printingpress", PalamodModBlocks.PRINTINGPRESS, PrintingpressBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TYPESETTINGTABLE = register("typesettingtable", PalamodModBlocks.TYPESETTINGTABLE, TypesettingtableBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TYPESETTINGBOOK = register("typesettingbook", PalamodModBlocks.TYPESETTINGBOOK, TypesettingbookBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TYPESETTINGPLATE = register("typesettingplate", PalamodModBlocks.TYPESETTINGPLATE, TypesettingplateBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> TYPESETTINGMAX = register("typesettingmax", PalamodModBlocks.TYPESETTINGMAX, TypesettingmaxBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> DRAWBRIDGE = register("drawbridge", PalamodModBlocks.DRAWBRIDGE, DrawbridgeBlockEntity::new);
	public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> EXCTRACTOR = register("exctractor", PalamodModBlocks.EXCTRACTOR, ExctractorBlockEntity::new);

	// Start of user code block custom block entities
	// End of user code block custom block entities
	private static DeferredHolder<BlockEntityType<?>, BlockEntityType<?>> register(String registryname, DeferredHolder<Block, Block> block, BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}

	@SubscribeEvent
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_CRUSHER.get(), (blockEntity, side) -> ((PaladiumcrusherBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, NBT_BLOCK.get(), (blockEntity, side) -> ((NbtblockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ALCHIMET_1.get(), (blockEntity, side) -> ((Alchimet1BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GRINDER_BLOCK.get(), (blockEntity, side) -> ((GrinderblockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_FURNACE.get(), (blockEntity, side) -> ((PaladiumfurnaceBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_FURNACE_ON.get(), (blockEntity, side) -> ((PaladiumfurnaceonBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_FORGE.get(), (blockEntity, side) -> ((PaladiumforgeBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TCV_2.get(), (blockEntity, side) -> ((Tcv2BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_MACHINE.get(), (blockEntity, side) -> ((PaladiummachineBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, LUCKY_BLOCK.get(), (blockEntity, side) -> ((LuckyblockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, MEGA_SAFE_CHEST.get(), (blockEntity, side) -> ((MegasafechestBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TRIXIUM_NBT_BLOCK.get(), (blockEntity, side) -> ((TrixiumnbtblockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, CLOUD_BLOCK.get(), (blockEntity, side) -> ((CloudblockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FACTION_BLOCK.get(), (blockEntity, side) -> ((FactionblckBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, UPLOADER.get(), (blockEntity, side) -> ((UploaderBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, HDV_BLOCK.get(), (blockEntity, side) -> ((HdvblockBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_TITANE_CHEST.get(), (blockEntity, side) -> ((TitanechestBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_PALADIUM_CHEST.get(), (blockEntity, side) -> ((PaladiumchestBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_AMETHYST_CHEST.get(), (blockEntity, side) -> ((AmethystchestBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_GREEN_PALADIUM_CHEST.get(), (blockEntity, side) -> ((GreenpaladiumchestBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, FLATTEN_ENDIUM_CHEST.get(), (blockEntity, side) -> ((EndiumchestBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DOWNLOADER.get(), (blockEntity, side) -> ((DownloaderBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PALADIUM_CHEST.get(), (blockEntity, side) -> ((Paladiumchestv2BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, GREEN_PALADIUM_CHEST.get(), (blockEntity, side) -> ((Greenpaladiumchestv2BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, AMETHYST_CHEST.get(), (blockEntity, side) -> ((Amethystchestv2BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ENDIUM_CHEST.get(), (blockEntity, side) -> ((Endiumchestv2BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TITANE_CHEST.get(), (blockEntity, side) -> ((Titanechestv2BlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ONLINE_DETECTOR.get(), (blockEntity, side) -> ((OnlinedetectorBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, ONLINE_DETECTOR_ON.get(), (blockEntity, side) -> ((OnlinedetectoronBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, COBBLEBREAKER.get(), (blockEntity, side) -> ((CobblebreakerBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, PRINTINGPRESS.get(), (blockEntity, side) -> ((PrintingpressBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TYPESETTINGTABLE.get(), (blockEntity, side) -> ((TypesettingtableBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TYPESETTINGBOOK.get(), (blockEntity, side) -> ((TypesettingbookBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TYPESETTINGPLATE.get(), (blockEntity, side) -> ((TypesettingplateBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, TYPESETTINGMAX.get(), (blockEntity, side) -> ((TypesettingmaxBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, DRAWBRIDGE.get(), (blockEntity, side) -> ((DrawbridgeBlockEntity) blockEntity).getItemHandler());
		event.registerBlockEntity(Capabilities.ItemHandler.BLOCK, EXCTRACTOR.get(), (blockEntity, side) -> ((ExctractorBlockEntity) blockEntity).getItemHandler());
	}
}


/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.PalamodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PalamodModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PalamodMod.MODID);
	public static final RegistryObject<CreativeModeTab> PALAMOD = REGISTRY.register("palamod",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.palamod.palamod")).icon(() -> new ItemStack(PalamodModItems.PALADIUM_INGOT.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PalamodModItems.PALADIUM_INGOT.get());
				tabData.accept(PalamodModItems.PALADIUM_PARTICLE.get());
				tabData.accept(PalamodModItems.PALADIUM_POLLEN.get());
				tabData.accept(PalamodModItems.PALADIUM_STICK.get());
				tabData.accept(PalamodModBlocks.PALADIUM_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.DEEPSLATE_PALADIUM_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.PALADIUM_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.COMPRESSED_PALADIUM.get());
				tabData.accept(PalamodModBlocks.PALADIUM_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.PALADIUM_SLAB.get().asItem());
				tabData.accept(PalamodModItems.PALADIUM_SWORD.get());
				tabData.accept(PalamodModItems.PALADIUM_AXE.get());
				tabData.accept(PalamodModItems.PALADIUM_SHOVEL.get());
				tabData.accept(PalamodModItems.PALADIUMEXCAVATOR.get());
				tabData.accept(PalamodModItems.PALADIUM_PICKAXE.get());
				tabData.accept(PalamodModItems.PALADIUMFASTSWORD.get());
				tabData.accept(PalamodModItems.PALADIUMBROADSWORD.get());
				tabData.accept(PalamodModItems.PALADIUM_ARMOR_HELMET.get());
				tabData.accept(PalamodModItems.PALADIUM_ARMOR_CHESTPLATE.get());
				tabData.accept(PalamodModItems.PALADIUM_ARMOR_LEGGINGS.get());
				tabData.accept(PalamodModItems.PALADIUM_ARMOR_BOOTS.get());
				tabData.accept(PalamodModItems.SMALL_RING.get());
				tabData.accept(PalamodModItems.MEDIUM_RING.get());
				tabData.accept(PalamodModItems.BIG_RING.get());
				tabData.accept(PalamodModBlocks.PALADIUM_CHEST.get().asItem());
				tabData.accept(PalamodModBlocks.FLATTEN_PALADIUM_CHEST.get().asItem());
				tabData.accept(PalamodModItems.TITANE_INGOT.get());
				tabData.accept(PalamodModItems.TITANE_PARTICLE.get());
				tabData.accept(PalamodModItems.TITANE_POLLEN.get());
				tabData.accept(PalamodModItems.TITANE_STICK.get());
				tabData.accept(PalamodModBlocks.TITANE_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.DEEPSLATE_TITANE_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.TITANE_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.COMPRESSED_TITANE.get());
				tabData.accept(PalamodModBlocks.TITANE_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.TITANE_SLAB.get().asItem());
				tabData.accept(PalamodModItems.TITANE_SWORD.get());
				tabData.accept(PalamodModItems.TITANE_AXE.get());
				tabData.accept(PalamodModItems.TITANE_SHOVEL.get());
				tabData.accept(PalamodModItems.TITANEEXCAVATOR.get());
				tabData.accept(PalamodModItems.TITANE_PICKAXE.get());
				tabData.accept(PalamodModItems.TITANEFASTSWORD.get());
				tabData.accept(PalamodModItems.TITANEBROADSWORD.get());
				tabData.accept(PalamodModItems.TITANE_ARMOR_HELMET.get());
				tabData.accept(PalamodModItems.TITANE_ARMOR_CHESTPLATE.get());
				tabData.accept(PalamodModItems.TITANE_ARMOR_LEGGINGS.get());
				tabData.accept(PalamodModItems.TITANE_ARMOR_BOOTS.get());
				tabData.accept(PalamodModBlocks.TITANE_CHEST.get().asItem());
				tabData.accept(PalamodModBlocks.FLATTEN_TITANE_CHEST.get().asItem());
				tabData.accept(PalamodModItems.AMETHYST.get());
				tabData.accept(PalamodModItems.AMETHYST_PARTICLE.get());
				tabData.accept(PalamodModItems.AMETHYST_POLLEN.get());
				tabData.accept(PalamodModBlocks.AMETHYST_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.DEEPSLATE_AMETHYST_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.AMETHYST_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.COMPRESSED_AMETHYST.get());
				tabData.accept(PalamodModBlocks.AMETHYST_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.AMETHYST_SLAB.get().asItem());
				tabData.accept(PalamodModBlocks.AMETHYST_CHEST.get().asItem());
				tabData.accept(PalamodModBlocks.FLATTEN_AMETHYST_CHEST.get().asItem());
				tabData.accept(PalamodModItems.AMETHYST_AXE.get());
				tabData.accept(PalamodModItems.AMETHYST_SWORD.get());
				tabData.accept(PalamodModItems.AMETHYST_BROADSWORD.get());
				tabData.accept(PalamodModItems.AMETHYST_SHOVEL.get());
				tabData.accept(PalamodModItems.AMETHYST_EXCACVATOR.get());
				tabData.accept(PalamodModItems.AMETHYST_FASTSWORD.get());
				tabData.accept(PalamodModItems.AMETHYST_PICKAXE.get());
				tabData.accept(PalamodModItems.AMETHYST_ARMOR_HELMET.get());
				tabData.accept(PalamodModItems.AMETHYST_ARMOR_CHESTPLATE.get());
				tabData.accept(PalamodModItems.AMETHYST_ARMOR_LEGGINGS.get());
				tabData.accept(PalamodModItems.AMETHYST_ARMOR_BOOTS.get());
				tabData.accept(PalamodModItems.AMETHYST_STICK.get());
				tabData.accept(PalamodModBlocks.PALADIUM_CRUSHER.get().asItem());
				tabData.accept(PalamodModItems.PALADIUM_MIXED_CHARCOAL.get());
				tabData.accept(PalamodModItems.ENDIUM_INGOT.get());
				tabData.accept(PalamodModItems.ENDIUM_NUGGET.get());
				tabData.accept(PalamodModItems.ENDIUM_FRAGMENT.get());
				tabData.accept(PalamodModItems.ENDIUM_POLLEN.get());
				tabData.accept(PalamodModBlocks.ENDIUM_NUGGET_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.DEEPSLATE_ENDIUM_NUGGET_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.ENDIUM_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.COMPRESSED_GREEN_PALADUM.get());
				tabData.accept(PalamodModBlocks.ENDIUM_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.ENDIUM_SLAB.get().asItem());
				tabData.accept(PalamodModItems.ENDIUMSHOVEL.get());
				tabData.accept(PalamodModItems.ENDIUM_PICKAXE.get());
				tabData.accept(PalamodModItems.ENDIUM_AXE.get());
				tabData.accept(PalamodModItems.ENDIUM_SWORD.get());
				tabData.accept(PalamodModItems.ENDIUM_ARMOR_HELMET.get());
				tabData.accept(PalamodModItems.ENDIUM_ARMOR_CHESTPLATE.get());
				tabData.accept(PalamodModItems.ENDIUM_ARMOR_LEGGINGS.get());
				tabData.accept(PalamodModItems.ENDIUM_ARMOR_BOOTS.get());
				tabData.accept(PalamodModItems.ENDIUM_SMALL_RING.get());
				tabData.accept(PalamodModItems.ENDIUM_MEDIUM_RING.get());
				tabData.accept(PalamodModItems.ENDIUM_BIG_RING.get());
				tabData.accept(PalamodModBlocks.ENDIUM_CHEST.get().asItem());
				tabData.accept(PalamodModBlocks.FLATTEN_ENDIUM_CHEST.get().asItem());
				tabData.accept(PalamodModBlocks.PALADIUM_GREEN_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.DEEPSLATE_GREEN_PALADIUM_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem());
				tabData.accept(PalamodModBlocks.GREEN_PALADIUM_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.GREEN_PALADIUM_SLAB.get().asItem());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_INGOT.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_PARTICLE.get());
				tabData.accept(PalamodModItems.PALADIUMGREENSHOVEL.get());
				tabData.accept(PalamodModItems.GREENPALADUMEXCATOR.get());
				tabData.accept(PalamodModItems.PALADIUMGREENSWORD.get());
				tabData.accept(PalamodModItems.PALADIUMGREENAXE.get());
				tabData.accept(PalamodModItems.PALADIUMGREENPICKAXE.get());
				tabData.accept(PalamodModItems.GREENPALADIUMARMOR_HELMET.get());
				tabData.accept(PalamodModItems.GREENPALADIUMARMOR_CHESTPLATE.get());
				tabData.accept(PalamodModItems.GREENPALADIUMARMOR_LEGGINGS.get());
				tabData.accept(PalamodModItems.GREENPALADIUMARMOR_BOOTS.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_SMALL_RING.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_BIG_RING.get());
				tabData.accept(PalamodModBlocks.GREEN_PALADIUM_CHEST.get().asItem());
				tabData.accept(PalamodModBlocks.FLATTEN_GREEN_PALADIUM_CHEST.get().asItem());
				tabData.accept(PalamodModItems.FINDIUM.get());
				tabData.accept(PalamodModBlocks.FINDIUM_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.DEEPSLATE_FINDIUM_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.FINDIUM_BLOCK.get().asItem());
				tabData.accept(PalamodModBlocks.FINDIUM_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.FINDIUM_SLAB.get().asItem());
				tabData.accept(PalamodModBlocks.TRIXIUM_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.TRIXIUM.get());
				tabData.accept(PalamodModBlocks.TRIXIUM_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.DEEPSLATE_TRIXIUM_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.XPBUSH.get().asItem());
				tabData.accept(PalamodModItems.XPBERRY.get());
				tabData.accept(PalamodModItems.COMPRESSEDXPBERRY.get());
				tabData.accept(PalamodModItems.PALADIUM_CORE.get());
				tabData.accept(PalamodModItems.FLAT_CHEST_UPGRADE.get());
				tabData.accept(PalamodModBlocks.ALCHIMET_1.get().asItem());
				tabData.accept(PalamodModBlocks.ASEMBLING_TABLE.get().asItem());
				tabData.accept(PalamodModBlocks.PALADIUM_FURNACE.get().asItem());
				tabData.accept(PalamodModItems.FURNACE_UPGRADE.get());
				tabData.accept(PalamodModBlocks.TYPESETTINGTABLE.get().asItem());
				tabData.accept(PalamodModBlocks.PRINTINGPRESS.get().asItem());
				tabData.accept(PalamodModBlocks.ONLINE_DETECTOR.get().asItem());
				tabData.accept(PalamodModBlocks.DRAWBRIDGE.get().asItem());
				tabData.accept(PalamodModItems.MAGICAL_TOOL.get());
				tabData.accept(PalamodModItems.GOLD_MIXEDCOAL.get());
				tabData.accept(PalamodModItems.AMETHYST_MIXEDCOAL.get());
				tabData.accept(PalamodModItems.TITANE_MIXED_COAL.get());
				tabData.accept(PalamodModBlocks.PALADIUM_FORGE.get().asItem());
				tabData.accept(PalamodModBlocks.LOADBLOCK_1T.get().asItem());
				tabData.accept(PalamodModItems.WITHER_SHARD.get());
				tabData.accept(PalamodModBlocks.MEGA_SAFE_CHEST.get().asItem());
				tabData.accept(PalamodModBlocks.COLORED_LAMP.get().asItem());
				tabData.accept(PalamodModBlocks.COLOFUL_LAMP.get().asItem());
				tabData.accept(PalamodModItems.DYNAMITE.get());
				tabData.accept(PalamodModItems.ENDIUM_DYNAMITE.get());
				tabData.accept(PalamodModItems.BIG_DYNAMITE.get());
				tabData.accept(PalamodModItems.DIAMOND_STRING.get());
				tabData.accept(PalamodModItems.WITHER_IMBUE_POTION.get());
				tabData.accept(PalamodModItems.FIRE_IMBUE_POTION.get());
				tabData.accept(PalamodModItems.POISON_IMBUE_POTION.get());
				tabData.accept(PalamodModItems.MINAGE_VOIDSTONE.get());
				tabData.accept(PalamodModItems.VOIDSTONE.get());
				tabData.accept(PalamodModItems.INFERNALKNOCKER.get());
				tabData.accept(PalamodModItems.TRAVELARMOR_HELMET.get());
				tabData.accept(PalamodModItems.TRAVELARMOR_CHESTPLATE.get());
				tabData.accept(PalamodModItems.TRAVELARMOR_LEGGINGS.get());
				tabData.accept(PalamodModItems.TRAVELARMOR_BOOTS.get());
				tabData.accept(PalamodModItems.SCUBA_HELMET.get());
				tabData.accept(PalamodModItems.WING.get());
				tabData.accept(PalamodModItems.HANG_GLIDER.get());
				tabData.accept(PalamodModBlocks.ELEVATOR_WHITE.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATO_RRED.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_BLUE.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_GREEN.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_PINK.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATORL_IGHT_BLUE.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_LIGHT_GREEN.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_BROWN.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_ORANGE.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_PURPLE.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_GRAY.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_LIGHT_GRAY.get().asItem());
				tabData.accept(PalamodModBlocks.ELEVATOR_CYAN.get().asItem());
				tabData.accept(PalamodModItems.PALADIUMGOLEM_SPAWN_EGG.get());
				tabData.accept(PalamodModItems.GUARDIAN_STONE.get());
				tabData.accept(PalamodModBlocks.GUARDIAN_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.ENFYUPOTION.get());
				tabData.accept(PalamodModBlocks.STONY.get().asItem());
				tabData.accept(PalamodModBlocks.CLOUD_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.INVISIBLEARMOR_HELMET.get());
				tabData.accept(PalamodModItems.INVISIBLEARMOR_CHESTPLATE.get());
				tabData.accept(PalamodModItems.INVISIBLEARMOR_LEGGINGS.get());
				tabData.accept(PalamodModItems.INVISIBLEARMOR_BOOTS.get());
				tabData.accept(PalamodModItems.RAINBOWARMOR_HELMET.get());
				tabData.accept(PalamodModItems.RAINBOWARMOR_CHESTPLATE.get());
				tabData.accept(PalamodModItems.RAINBOWARMOR_LEGGINGS.get());
				tabData.accept(PalamodModItems.RAINBOWARMOR_BOOTS.get());
				tabData.accept(PalamodModItems.FLYPOTION.get());
				tabData.accept(PalamodModBlocks.UPLOADER.get().asItem());
				tabData.accept(PalamodModBlocks.DOWNLOADER.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLETRAPDOOR.get().asItem());
				tabData.accept(PalamodModItems.PESYBLPOTION.get());
				tabData.accept(PalamodModItems.CREATIVE_HAMMER.get());
				tabData.accept(PalamodModItems.CREATIVE_TRIXIUM_SWORD.get());
				tabData.accept(PalamodModItems.POTATO_BACKPACK.get());
				tabData.accept(PalamodModItems.DIAMOND_PARTICLE.get());
				tabData.accept(PalamodModItems.GOLD_PARTICLE.get());
				tabData.accept(PalamodModItems.IRON_PARTICLE.get());
				tabData.accept(PalamodModBlocks.ENDIUM_LUCKY_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.GREENPALADIUMFASTSWORD.get());
				tabData.accept(PalamodModItems.ENDIUMFASTSWORD.get());
				tabData.accept(PalamodModBlocks.CAVE_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.MIICHALENGE.get());
				tabData.accept(PalamodModItems.FUZEDISC.get());
				tabData.accept(PalamodModItems.ANTIFUZEDISC.get());
				tabData.accept(PalamodModItems.ROULETTEPALADIENNEDISC.get());
				tabData.accept(PalamodModItems.CLASHKUMIZ.get());
				tabData.accept(PalamodModItems.PLATE.get());
				tabData.accept(PalamodModBlocks.COMPRESSEDSPONGE.get().asItem());
				tabData.accept(PalamodModBlocks.SPONGETNT.get().asItem());
				tabData.accept(PalamodModBlocks.LAVASPONGE.get().asItem());
				tabData.accept(PalamodModBlocks.WETLAVASPONGE.get().asItem());
				tabData.accept(PalamodModBlocks.WITHERTNT.get().asItem());
				tabData.accept(PalamodModBlocks.MAGIC_TNT.get().asItem());
				tabData.accept(PalamodModBlocks.COMPACTTNT.get().asItem());
				tabData.accept(PalamodModBlocks.ENDIUMTNT.get().asItem());
				tabData.accept(PalamodModItems.FAKEWTER_BUCKET.get());
				tabData.accept(PalamodModItems.ANGELICWTER_BUCKET.get());
				tabData.accept(PalamodModBlocks.SLIMEOBSIDIAN.get().asItem());
				tabData.accept(PalamodModBlocks.POISONOBSIDIAN.get().asItem());
				tabData.accept(PalamodModItems.SEALEDXPBOTTLE.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> PICKAXEOFGODSTAB = REGISTRY.register("pickaxeofgodstab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.palamod.pickaxeofgodstab")).icon(() -> new ItemStack(PalamodModItems.PICKAXEOFTHEGODSLV_1.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_1.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_2.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_3.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_4.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_5.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_6.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_7.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_8.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_9.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_10.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_11.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_12.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_13.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_14.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_15.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_16.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_17.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_18.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_19.get());
				tabData.accept(PalamodModItems.PICKAXEOFTHEGODSLV_20.get());
				tabData.accept(PalamodModItems.CREATIVEPOTG.get());
				tabData.accept(PalamodModItems.BIG_HOLE_UPGRADE.get());
				tabData.accept(PalamodModItems.AUTO_SMELT_UPGRADE_POTG.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> GRINDERCREATIVETAB = REGISTRY.register("grindercreativetab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.palamod.grindercreativetab")).icon(() -> new ItemStack(PalamodModBlocks.TCV_2.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PalamodModItems.KIWANOSEED.get());
				tabData.accept(PalamodModItems.ORANGEBLUESEED.get());
				tabData.accept(PalamodModItems.CHERVILSEED.get());
				tabData.accept(PalamodModItems.EGGPLANT_SEED.get());
				tabData.accept(PalamodModItems.TITANE_HAMMER.get());
				tabData.accept(PalamodModItems.AMETHYST_HAMMER.get());
				tabData.accept(PalamodModItems.SOCKET_PATERN.get());
				tabData.accept(PalamodModBlocks.GRINDER_BLOCK.get().asItem());
				tabData.accept(PalamodModBlocks.GRINDER_CASING.get().asItem());
				tabData.accept(PalamodModBlocks.GRINDER_FRAME.get().asItem());
				tabData.accept(PalamodModBlocks.TCV_2.get().asItem());
				tabData.accept(PalamodModItems.SPEED_MODIFIER.get());
				tabData.accept(PalamodModItems.KNOCKBACK_MODIFIER.get());
				tabData.accept(PalamodModItems.FLAME_MODIFIER.get());
				tabData.accept(PalamodModItems.FORTUNE_MODIFIER.get());
				tabData.accept(PalamodModItems.ONE_MORE_MODIFIER.get());
				tabData.accept(PalamodModItems.PALADIUM_HAMMER.get());
				tabData.accept(PalamodModItems.ENDIUM_HAMMER.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_HAMMER.get());
				tabData.accept(PalamodModItems.ENDIUMBROADSWORD.get());
				tabData.accept(PalamodModItems.GREENPALADIUMBROADSWORD.get());
				tabData.accept(PalamodModItems.EGGPLANT.get());
				tabData.accept(PalamodModItems.ORANGEBLUE.get());
				tabData.accept(PalamodModItems.KIWANO.get());
				tabData.accept(PalamodModItems.CHERVIL.get());
				tabData.accept(PalamodModItems.AXE_HEAD.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_AXE_HEAD.get());
				tabData.accept(PalamodModItems.HEAD_ENDIUM_AXE.get());
				tabData.accept(PalamodModItems.PICKAXE_HEAD.get());
				tabData.accept(PalamodModItems.HEAD_ENDIUM_PICKAXE.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_PICKAXE_HEAD.get());
				tabData.accept(PalamodModItems.HAMMER_HEAD.get());
				tabData.accept(PalamodModItems.FASTSWORD_HEAD.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_HAMMER_HEAD.get());
				tabData.accept(PalamodModItems.ENDIUM_HAMMER_HEAD.get());
				tabData.accept(PalamodModItems.BROADSWORD_HEAD.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_BROADSWORD_HEAD.get());
				tabData.accept(PalamodModItems.ENDIUM_BROADSWORD_HEAD.get());
				tabData.accept(PalamodModItems.SHOVEL_HEAD.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_SHOVEL_HEAD.get());
				tabData.accept(PalamodModItems.SWORD_HEAD.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_SWORD_HEAD.get());
				tabData.accept(PalamodModItems.HEADENDIUMSWORD.get());
				tabData.accept(PalamodModItems.AXE_PARTERN.get());
				tabData.accept(PalamodModItems.PICKAXE_PATERN.get());
				tabData.accept(PalamodModItems.BROADSWORD_PATERN.get());
				tabData.accept(PalamodModItems.BLOCK_PATERN.get());
				tabData.accept(PalamodModItems.FASTSWORD_PATERN.get());
				tabData.accept(PalamodModItems.INGOT_PATERN.get());
				tabData.accept(PalamodModItems.HAMMER_PATERN.get());
				tabData.accept(PalamodModItems.SWORD_PATERN.get());
				tabData.accept(PalamodModItems.SHOVEL_PATERN.get());
				tabData.accept(PalamodModItems.SMELT_MODIFIER.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_FASTSWORD_HEAD.get());
				tabData.accept(PalamodModItems.ENDIUM_FASTSWORD_HEAD.get());
				tabData.accept(PalamodModItems.ENDIUM_SHOVEL_HEAD.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> DECORATIONCREATIVETAB = REGISTRY.register("decorationcreativetab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.palamod.decorationcreativetab")).icon(() -> new ItemStack(PalamodModBlocks.OSTRYA_WOOD_PLANKS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PalamodModBlocks.OSTRYA_SAPPLING.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_WOOD_WOOD.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_WOOD_LOG.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_WOOD_PLANKS.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_WOOD_LEAVES.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_WOOD_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_WOOD_SLAB.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_WOOD_FENCE.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_WOOD_FENCE_GATE.get().asItem());
				tabData.accept(PalamodModBlocks.OSTRYA_DOOR.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_SAPPLING.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_WOOD.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_LOG.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_PLANKS.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_LEAVES.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_SLAB.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_FENCE.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_FENCE_GATE.get().asItem());
				tabData.accept(PalamodModBlocks.JACARANDA_DOOR.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_SAPPLING.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_WOOD.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_LOG.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_PLANKS.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_LEAVES.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_SLAB.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_FENCE.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_FENCE_GATE.get().asItem());
				tabData.accept(PalamodModBlocks.JUDEECERCIS_DOOR.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_SAPPLING.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_WOOD.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_LOG.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_PLANKS.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_LEAVES.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_STAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_SLAB.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_FENCE.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_FENCE_GATE.get().asItem());
				tabData.accept(PalamodModBlocks.ERABLE_DOOR.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> PVPCREATIVETAB = REGISTRY.register("pvpcreativetab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.palamod.pvpcreativetab")).icon(() -> new ItemStack(PalamodModItems.STICKOFGODS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PalamodModBlocks.SLIMEPAD.get().asItem());
				tabData.accept(PalamodModItems.HEAL_ORB.get());
				tabData.accept(PalamodModItems.SPEED_ORB.get());
				tabData.accept(PalamodModItems.STRENGH_ORB.get());
				tabData.accept(PalamodModItems.JUMP_ORB.get());
				tabData.accept(PalamodModItems.KNOCKBACK_ORB.get());
				tabData.accept(PalamodModBlocks.PALADIUM_MACHINE.get().asItem());
				tabData.accept(PalamodModItems.SPEEDSTICK.get());
				tabData.accept(PalamodModItems.JUMPSTICK.get());
				tabData.accept(PalamodModItems.HYPERJUMPSTICK.get());
				tabData.accept(PalamodModItems.HEALSTICK.get());
				tabData.accept(PalamodModItems.STRENGHTSTICK.get());
				tabData.accept(PalamodModItems.DAMAGESTICK.get());
				tabData.accept(PalamodModItems.STICKOFGODS.get());
				tabData.accept(PalamodModItems.PALADIUM_APPLE.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> LUCKYBLOCKCREATIVETAB = REGISTRY.register("luckyblockcreativetab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.palamod.luckyblockcreativetab")).icon(() -> new ItemStack(PalamodModBlocks.LUCKY_BLOCK.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PalamodModBlocks.TRESAURE_FALSE.get().asItem());
				tabData.accept(PalamodModBlocks.TRESAURE_TRUE.get().asItem());
				tabData.accept(PalamodModBlocks.FAKE_PALADIUM_ORE.get().asItem());
				tabData.accept(PalamodModBlocks.ALARM.get().asItem());
				tabData.accept(PalamodModBlocks.ALARM_ON.get().asItem());
				tabData.accept(PalamodModItems.SPACE_FOOD.get());
				tabData.accept(PalamodModItems.LEGENDARY_STONE_FORTUNE.get());
				tabData.accept(PalamodModItems.LEGENDARY_STONE_INVISIBLE.get());
				tabData.accept(PalamodModItems.LEGENDARY_STONE_POWER.get());
				tabData.accept(PalamodModItems.LEGENDARY_STONE_JOBS.get());
				tabData.accept(PalamodModItems.LEGENDARY_STONE_TELEPORTATION.get());
				tabData.accept(PalamodModItems.LEGENDARY_STONE_RANDOM.get());
				tabData.accept(PalamodModBlocks.LUCKY_BLOCK.get().asItem());
				tabData.accept(PalamodModItems.WEIGHTED_BOOTS.get());
				tabData.accept(PalamodModItems.PALADIUM_PHONE.get());
				tabData.accept(PalamodModItems.CHUNKANASLYSER.get());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> BASECLAIM = REGISTRY.register("baseclaim",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.palamod.baseclaim")).icon(() -> new ItemStack(PalamodModBlocks.RENFORCED_OBSIDIAN.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PalamodModBlocks.OBSIDIAN_TRAPDOOR.get().asItem());
				tabData.accept(PalamodModBlocks.RENFORCED_OBSIDIAN.get().asItem());
				tabData.accept(PalamodModBlocks.OBSIDIAN_DOOR.get().asItem());
				tabData.accept(PalamodModBlocks.COMPACTED_OBSIDIAN.get().asItem());
				tabData.accept(PalamodModBlocks.FAKE_WATER_OBSIDIAN.get().asItem());
				tabData.accept(PalamodModBlocks.LAVA_OBSIDIAN.get().asItem());
				tabData.accept(PalamodModBlocks.IRON_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.SPIKE_GOLD.get().asItem());
				tabData.accept(PalamodModBlocks.DIAMOND_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.AMETHYST_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.TITANE_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.PALADIUM_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.WOODEN_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.WOODEN_OBSIDIAN_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.IRON_OBSIDIAN_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.GOLDEN_OBSIDIAN_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.DIAMOND_OBSIDIAN_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.AMETHYS_TOBSIDIAN_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.TITANE_OBSIDIAN_SPIKE.get().asItem());
				tabData.accept(PalamodModBlocks.PALADIUM_OBSIDIAN_SPIKE.get().asItem());
				tabData.accept(PalamodModItems.OBSIDIANPICKAXE.get());
				tabData.accept(PalamodModBlocks.RENFORCEDOBSIDIANSTAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.OBSIDIANSTAIRS.get().asItem());
				tabData.accept(PalamodModBlocks.OBSIDIANSLAB.get().asItem());
				tabData.accept(PalamodModBlocks.HARDENEDOBSIDIANSLAB.get().asItem());
			})

					.build());
	public static final RegistryObject<CreativeModeTab> JOBSCREATIVETABS = REGISTRY.register("jobscreativetabs",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.palamod.jobscreativetabs")).icon(() -> new ItemStack(PalamodModItems.PALADIUM_HOE.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PalamodModBlocks.COBBLEBREAKER.get().asItem());
				tabData.accept(PalamodModItems.DOLLARS_STONE.get());
				tabData.accept(PalamodModItems.COBBLEBREAKER_AMETHYST_UPGRADE.get());
				tabData.accept(PalamodModItems.COBBLEBREAKER_TITANE_UPGRADE.get());
				tabData.accept(PalamodModItems.COBBLEBREAKER_PALADIUM_UPGRADE.get());
				tabData.accept(PalamodModBlocks.FERTILZED_DIRT.get().asItem());
				tabData.accept(PalamodModItems.AMETHYST_HOE.get());
				tabData.accept(PalamodModItems.TITANEHOE.get());
				tabData.accept(PalamodModItems.PALADIUM_HOE.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_HOE.get());
				tabData.accept(PalamodModItems.ENDIUM_HOE.get());
				tabData.accept(PalamodModItems.AMETHYST_SEEDPLANTER.get());
				tabData.accept(PalamodModItems.TITANE_SEEDPLANTER.get());
				tabData.accept(PalamodModItems.PALADIUM_SEEDPLANTER.get());
				tabData.accept(PalamodModItems.GREEN_PALADIUM_SEEDPLANTER.get());
				tabData.accept(PalamodModItems.ENDIUM_SEEDPLANTER.get());
			})

					.build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {

		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(PalamodModItems.INTERNET_CARD.get());
		}
	}
}
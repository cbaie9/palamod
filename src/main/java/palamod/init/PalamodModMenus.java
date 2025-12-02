/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.world.inventory.*;

import palamod.network.MenuStateUpdateMessage;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import java.util.Map;

public class PalamodModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PalamodMod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<CrusherguiMenu>> CRUSHERGUI = REGISTRY.register("crushergui", () -> IMenuTypeExtension.create(CrusherguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PalamachineguiMenu>> PALAMACHINEGUI = REGISTRY.register("palamachinegui", () -> IMenuTypeExtension.create(PalamachineguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GrinderguiMenu>> GRINDERGUI = REGISTRY.register("grindergui", () -> IMenuTypeExtension.create(GrinderguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AlchemycreatorguiMenu>> ALCHEMYCREATORGUI = REGISTRY.register("alchemycreatorgui", () -> IMenuTypeExtension.create(AlchemycreatorguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Palahelpgui1Menu>> PALAHELPGUI_1 = REGISTRY.register("palahelpgui_1", () -> IMenuTypeExtension.create(Palahelpgui1Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PalahelpblockMenu>> PALAHELPBLOCK = REGISTRY.register("palahelpblock", () -> IMenuTypeExtension.create(PalahelpblockMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ForgeguiMenu>> FORGEGUI = REGISTRY.register("forgegui", () -> IMenuTypeExtension.create(ForgeguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PalahelporeMenu>> PALAHELPORE = REGISTRY.register("palahelpore", () -> IMenuTypeExtension.create(PalahelporeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PalahelptreeMenu>> PALAHELPTREE = REGISTRY.register("palahelptree", () -> IMenuTypeExtension.create(PalahelptreeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PalahelpmachineMenu>> PALAHELPMACHINE = REGISTRY.register("palahelpmachine", () -> IMenuTypeExtension.create(PalahelpmachineMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GrinderpalahelpguiMenu>> GRINDERPALAHELPGUI = REGISTRY.register("grinderpalahelpgui", () -> IMenuTypeExtension.create(GrinderpalahelpguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Grinderpalahelp2guiMenu>> GRINDERPALAHELP_2GUI = REGISTRY.register("grinderpalahelp_2gui", () -> IMenuTypeExtension.create(Grinderpalahelp2guiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PalamachinepalahelpguiMenu>> PALAMACHINEPALAHELPGUI = REGISTRY.register("palamachinepalahelpgui", () -> IMenuTypeExtension.create(PalamachinepalahelpguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CrusherpalahelpguiMenu>> CRUSHERPALAHELPGUI = REGISTRY.register("crusherpalahelpgui", () -> IMenuTypeExtension.create(CrusherpalahelpguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ForgepalahelpguiMenu>> FORGEPALAHELPGUI = REGISTRY.register("forgepalahelpgui", () -> IMenuTypeExtension.create(ForgepalahelpguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FluidpalahelpMenu>> FLUIDPALAHELP = REGISTRY.register("fluidpalahelp", () -> IMenuTypeExtension.create(FluidpalahelpMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ItemmenupalahelpMenu>> ITEMMENUPALAHELP = REGISTRY.register("itemmenupalahelp", () -> IMenuTypeExtension.create(ItemmenupalahelpMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LegendarystonepalahelpMenu>> LEGENDARYSTONEPALAHELP = REGISTRY.register("legendarystonepalahelp", () -> IMenuTypeExtension.create(LegendarystonepalahelpMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ArmorpalahelpguiMenu>> ARMORPALAHELPGUI = REGISTRY.register("armorpalahelpgui", () -> IMenuTypeExtension.create(ArmorpalahelpguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<XpbushpalahelpguiMenu>> XPBUSHPALAHELPGUI = REGISTRY.register("xpbushpalahelpgui", () -> IMenuTypeExtension.create(XpbushpalahelpguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LuckyguiMenu>> LUCKYGUI = REGISTRY.register("luckygui", () -> IMenuTypeExtension.create(LuckyguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PaladumfurnaceMenu>> PALADUMFURNACE = REGISTRY.register("paladumfurnace", () -> IMenuTypeExtension.create(PaladumfurnaceMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SafeguiMenu>> SAFEGUI = REGISTRY.register("safegui", () -> IMenuTypeExtension.create(SafeguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PhoneguiMenu>> PHONEGUI = REGISTRY.register("phonegui", () -> IMenuTypeExtension.create(PhoneguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<MegasafechestfirstsetupMenu>> MEGASAFECHESTFIRSTSETUP = REGISTRY.register("megasafechestfirstsetup", () -> IMenuTypeExtension.create(MegasafechestfirstsetupMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AuthsafeguiMenu>> AUTHSAFEGUI = REGISTRY.register("authsafegui", () -> IMenuTypeExtension.create(AuthsafeguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<LanguageselectionMenu>> LANGUAGESELECTION = REGISTRY.register("languageselection", () -> IMenuTypeExtension.create(LanguageselectionMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PalahelpnotsupportedMenu>> PALAHELPNOTSUPPORTED = REGISTRY.register("palahelpnotsupported", () -> IMenuTypeExtension.create(PalahelpnotsupportedMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StockhdvMenu>> STOCKHDV = REGISTRY.register("stockhdv", () -> IMenuTypeExtension.create(StockhdvMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminpanelmenuMenu>> ADMINPANELMENU = REGISTRY.register("adminpanelmenu", () -> IMenuTypeExtension.create(AdminpanelmenuMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Palaerror0005Menu>> PALAERROR_0005 = REGISTRY.register("palaerror_0005", () -> IMenuTypeExtension.create(Palaerror0005Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SpawnpanelMenu>> SPAWNPANEL = REGISTRY.register("spawnpanel", () -> IMenuTypeExtension.create(SpawnpanelMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Palaerror0006Menu>> PALAERROR_0006 = REGISTRY.register("palaerror_0006", () -> IMenuTypeExtension.create(Palaerror0006Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TrashguiMenu>> TRASHGUI = REGISTRY.register("trashgui", () -> IMenuTypeExtension.create(TrashguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmenuMenu>> ADMINSHOPMENU = REGISTRY.register("adminshopmenu", () -> IMenuTypeExtension.create(AdminshopmenuMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockMenu>> ADMINSHOPBLOCK = REGISTRY.register("adminshopblock", () -> IMenuTypeExtension.create(AdminshopblockMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GuardianguiMenu>> GUARDIANGUI = REGISTRY.register("guardiangui", () -> IMenuTypeExtension.create(GuardianguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GolemtreecMenu>> GOLEMTREEC = REGISTRY.register("golemtreec", () -> IMenuTypeExtension.create(GolemtreecMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FactionhomeguiMenu>> FACTIONHOMEGUI = REGISTRY.register("factionhomegui", () -> IMenuTypeExtension.create(FactionhomeguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AnalyserloadingMenu>> ANALYSERLOADING = REGISTRY.register("analyserloading", () -> IMenuTypeExtension.create(AnalyserloadingMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AnalyserresultMenu>> ANALYSERRESULT = REGISTRY.register("analyserresult", () -> IMenuTypeExtension.create(AnalyserresultMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporeMenu>> ADMINSHOPORE = REGISTRY.register("adminshopore", () -> IMenuTypeExtension.create(AdminshoporeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporepaladiumMenu>> ADMINSHOPOREPALADIUM = REGISTRY.register("adminshoporepaladium", () -> IMenuTypeExtension.create(AdminshoporepaladiumMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporetitaneMenu>> ADMINSHOPORETITANE = REGISTRY.register("adminshoporetitane", () -> IMenuTypeExtension.create(AdminshoporetitaneMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporeamethystMenu>> ADMINSHOPOREAMETHYST = REGISTRY.register("adminshoporeamethyst", () -> IMenuTypeExtension.create(AdminshoporeamethystMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporediamondMenu>> ADMINSHOPOREDIAMOND = REGISTRY.register("adminshoporediamond", () -> IMenuTypeExtension.create(AdminshoporediamondMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporecoalMenu>> ADMINSHOPORECOAL = REGISTRY.register("adminshoporecoal", () -> IMenuTypeExtension.create(AdminshoporecoalMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporegoldMenu>> ADMINSHOPOREGOLD = REGISTRY.register("adminshoporegold", () -> IMenuTypeExtension.create(AdminshoporegoldMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporeironMenu>> ADMINSHOPOREIRON = REGISTRY.register("adminshoporeiron", () -> IMenuTypeExtension.create(AdminshoporeironMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoporefindiumMenu>> ADMINSHOPOREFINDIUM = REGISTRY.register("adminshoporefindium", () -> IMenuTypeExtension.create(AdminshoporefindiumMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockDirtMenu>> ADMINSHOPBLOCK_DIRT = REGISTRY.register("adminshopblock_dirt", () -> IMenuTypeExtension.create(AdminshopblockDirtMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockstoneMenu>> ADMINSHOPBLOCKSTONE = REGISTRY.register("adminshopblockstone", () -> IMenuTypeExtension.create(AdminshopblockstoneMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockgrassMenu>> ADMINSHOPBLOCKGRASS = REGISTRY.register("adminshopblockgrass", () -> IMenuTypeExtension.create(AdminshopblockgrassMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockSandMenu>> ADMINSHOPBLOCK_SAND = REGISTRY.register("adminshopblock_sand", () -> IMenuTypeExtension.create(AdminshopblockSandMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockNetherrackMenu>> ADMINSHOPBLOCK_NETHERRACK = REGISTRY.register("adminshopblock_netherrack", () -> IMenuTypeExtension.create(AdminshopblockNetherrackMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockGravelMenu>> ADMINSHOPBLOCK_GRAVEL = REGISTRY.register("adminshopblock_gravel", () -> IMenuTypeExtension.create(AdminshopblockGravelMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblocksoulsandMenu>> ADMINSHOPBLOCKSOULSAND = REGISTRY.register("adminshopblocksoulsand", () -> IMenuTypeExtension.create(AdminshopblocksoulsandMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockblackstoneMenu>> ADMINSHOPBLOCKBLACKSTONE = REGISTRY.register("adminshopblockblackstone", () -> IMenuTypeExtension.create(AdminshopblockblackstoneMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockoakwoodMenu>> ADMINSHOPBLOCKOAKWOOD = REGISTRY.register("adminshopblockoakwood", () -> IMenuTypeExtension.create(AdminshopblockoakwoodMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopblockGlowstoneMenu>> ADMINSHOPBLOCK_GLOWSTONE = REGISTRY.register("adminshopblock_glowstone", () -> IMenuTypeExtension.create(AdminshopblockGlowstoneMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UploaderguiMenu>> UPLOADERGUI = REGISTRY.register("uploadergui", () -> IMenuTypeExtension.create(UploaderguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SpecialmoneypanelMenu>> SPECIALMONEYPANEL = REGISTRY.register("specialmoneypanel", () -> IMenuTypeExtension.create(SpecialmoneypanelMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TitanechestguiMenu>> TITANECHESTGUI = REGISTRY.register("titanechestgui", () -> IMenuTypeExtension.create(TitanechestguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AmethystchestguiMenu>> AMETHYSTCHESTGUI = REGISTRY.register("amethystchestgui", () -> IMenuTypeExtension.create(AmethystchestguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PaladiumchestguiMenu>> PALADIUMCHESTGUI = REGISTRY.register("paladiumchestgui", () -> IMenuTypeExtension.create(PaladiumchestguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GreenpaladiumchestguiMenu>> GREENPALADIUMCHESTGUI = REGISTRY.register("greenpaladiumchestgui", () -> IMenuTypeExtension.create(GreenpaladiumchestguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<EndiumchestguiMenu>> ENDIUMCHESTGUI = REGISTRY.register("endiumchestgui", () -> IMenuTypeExtension.create(EndiumchestguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OrelayerfatMenu>> ORELAYERFAT = REGISTRY.register("orelayerfat", () -> IMenuTypeExtension.create(OrelayerfatMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DownloaderguiMenu>> DOWNLOADERGUI = REGISTRY.register("downloadergui", () -> IMenuTypeExtension.create(DownloaderguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DownloaderlinkMenu>> DOWNLOADERLINK = REGISTRY.register("downloaderlink", () -> IMenuTypeExtension.create(DownloaderlinkMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PotgtranfertMenu>> POTGTRANFERT = REGISTRY.register("potgtranfert", () -> IMenuTypeExtension.create(PotgtranfertMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TrixiumdepositMenu>> TRIXIUMDEPOSIT = REGISTRY.register("trixiumdeposit", () -> IMenuTypeExtension.create(TrixiumdepositMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExampleuploaderguiMenu>> EXAMPLEUPLOADERGUI = REGISTRY.register("exampleuploadergui", () -> IMenuTypeExtension.create(ExampleuploaderguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<UploaderguipalahelpMenu>> UPLOADERGUIPALAHELP = REGISTRY.register("uploaderguipalahelp", () -> IMenuTypeExtension.create(UploaderguipalahelpMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantMenu>> ADMINSHOPPLANT = REGISTRY.register("adminshopplant", () -> IMenuTypeExtension.create(AdminshopplantMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantcactusMenu>> ADMINSHOPPLANTCACTUS = REGISTRY.register("adminshopplantcactus", () -> IMenuTypeExtension.create(AdminshopplantcactusMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantredmushroomMenu>> ADMINSHOPPLANTREDMUSHROOM = REGISTRY.register("adminshopplantredmushroom", () -> IMenuTypeExtension.create(AdminshopplantredmushroomMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantbrownmushroomMenu>> ADMINSHOPPLANTBROWNMUSHROOM = REGISTRY.register("adminshopplantbrownmushroom", () -> IMenuTypeExtension.create(AdminshopplantbrownmushroomMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantwarpedfungusMenu>> ADMINSHOPPLANTWARPEDFUNGUS = REGISTRY.register("adminshopplantwarpedfungus", () -> IMenuTypeExtension.create(AdminshopplantwarpedfungusMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantcrimsonfungusMenu>> ADMINSHOPPLANTCRIMSONFUNGUS = REGISTRY.register("adminshopplantcrimsonfungus", () -> IMenuTypeExtension.create(AdminshopplantcrimsonfungusMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantwheatMenu>> ADMINSHOPPLANTWHEAT = REGISTRY.register("adminshopplantwheat", () -> IMenuTypeExtension.create(AdminshopplantwheatMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantpotatoMenu>> ADMINSHOPPLANTPOTATO = REGISTRY.register("adminshopplantpotato", () -> IMenuTypeExtension.create(AdminshopplantpotatoMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantcarrotMenu>> ADMINSHOPPLANTCARROT = REGISTRY.register("adminshopplantcarrot", () -> IMenuTypeExtension.create(AdminshopplantcarrotMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantmelonMenu>> ADMINSHOPPLANTMELON = REGISTRY.register("adminshopplantmelon", () -> IMenuTypeExtension.create(AdminshopplantmelonMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantsugarcaneMenu>> ADMINSHOPPLANTSUGARCANE = REGISTRY.register("adminshopplantsugarcane", () -> IMenuTypeExtension.create(AdminshopplantsugarcaneMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsMenu>> ADMINSHOPMOBS = REGISTRY.register("adminshopmobs", () -> IMenuTypeExtension.create(AdminshopmobsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsboneMenu>> ADMINSHOPMOBSBONE = REGISTRY.register("adminshopmobsbone", () -> IMenuTypeExtension.create(AdminshopmobsboneMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsslimeballMenu>> ADMINSHOPMOBSSLIMEBALL = REGISTRY.register("adminshopmobsslimeball", () -> IMenuTypeExtension.create(AdminshopmobsslimeballMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsenderpearlMenu>> ADMINSHOPMOBSENDERPEARL = REGISTRY.register("adminshopmobsenderpearl", () -> IMenuTypeExtension.create(AdminshopmobsenderpearlMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsstringMenu>> ADMINSHOPMOBSSTRING = REGISTRY.register("adminshopmobsstring", () -> IMenuTypeExtension.create(AdminshopmobsstringMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsfrspidereyesMenu>> ADMINSHOPMOBSFRSPIDEREYES = REGISTRY.register("adminshopmobsfrspidereyes", () -> IMenuTypeExtension.create(AdminshopmobsfrspidereyesMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsendereyesMenu>> ADMINSHOPMOBSENDEREYES = REGISTRY.register("adminshopmobsendereyes", () -> IMenuTypeExtension.create(AdminshopmobsendereyesMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsRottenfleshMenu>> ADMINSHOPMOBS_ROTTENFLESH = REGISTRY.register("adminshopmobs_rottenflesh", () -> IMenuTypeExtension.create(AdminshopmobsRottenfleshMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobsghasttearsMenu>> ADMINSHOPMOBSGHASTTEARS = REGISTRY.register("adminshopmobsghasttears", () -> IMenuTypeExtension.create(AdminshopmobsghasttearsMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobseggMenu>> ADMINSHOPMOBSEGG = REGISTRY.register("adminshopmobsegg", () -> IMenuTypeExtension.create(AdminshopmobseggMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopmobswitherskullMenu>> ADMINSHOPMOBSWITHERSKULL = REGISTRY.register("adminshopmobswitherskull", () -> IMenuTypeExtension.create(AdminshopmobswitherskullMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2Menu>> ADMINSHOPMOBS_2 = REGISTRY.register("adminshopmobs_2", () -> IMenuTypeExtension.create(Adminshopmobs2Menu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2steakMenu>> ADMINSHOPMOBS_2STEAK = REGISTRY.register("adminshopmobs_2steak", () -> IMenuTypeExtension.create(Adminshopmobs2steakMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2gunpowderMenu>> ADMINSHOPMOBS_2GUNPOWDER = REGISTRY.register("adminshopmobs_2gunpowder", () -> IMenuTypeExtension.create(Adminshopmobs2gunpowderMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2blazeMenu>> ADMINSHOPMOBS_2BLAZE = REGISTRY.register("adminshopmobs_2blaze", () -> IMenuTypeExtension.create(Adminshopmobs2blazeMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2inksacMenu>> ADMINSHOPMOBS_2INKSAC = REGISTRY.register("adminshopmobs_2inksac", () -> IMenuTypeExtension.create(Adminshopmobs2inksacMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2glowinksacMenu>> ADMINSHOPMOBS_2GLOWINKSAC = REGISTRY.register("adminshopmobs_2glowinksac", () -> IMenuTypeExtension.create(Adminshopmobs2glowinksacMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2featherMenu>> ADMINSHOPMOBS_2FEATHER = REGISTRY.register("adminshopmobs_2feather", () -> IMenuTypeExtension.create(Adminshopmobs2featherMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2honeycombMenu>> ADMINSHOPMOBS_2HONEYCOMB = REGISTRY.register("adminshopmobs_2honeycomb", () -> IMenuTypeExtension.create(Adminshopmobs2honeycombMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<Adminshopmobs2leatherMenu>> ADMINSHOPMOBS_2LEATHER = REGISTRY.register("adminshopmobs_2leather", () -> IMenuTypeExtension.create(Adminshopmobs2leatherMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoputilitiesMenu>> ADMINSHOPUTILITIES = REGISTRY.register("adminshoputilities", () -> IMenuTypeExtension.create(AdminshoputilitiesMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdhutilitiesredstoneMenu>> ADHUTILITIESREDSTONE = REGISTRY.register("adhutilitiesredstone", () -> IMenuTypeExtension.create(AdhutilitiesredstoneMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoputilitiesemeraldMenu>> ADMINSHOPUTILITIESEMERALD = REGISTRY.register("adminshoputilitiesemerald", () -> IMenuTypeExtension.create(AdminshoputilitiesemeraldMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshoputilitiesdiampicMenu>> ADMINSHOPUTILITIESDIAMPIC = REGISTRY.register("adminshoputilitiesdiampic", () -> IMenuTypeExtension.create(AdminshoputilitiesdiampicMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<OnlinedetectorguiMenu>> ONLINEDETECTORGUI = REGISTRY.register("onlinedetectorgui", () -> IMenuTypeExtension.create(OnlinedetectorguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CobblebreakerguiMenu>> COBBLEBREAKERGUI = REGISTRY.register("cobblebreakergui", () -> IMenuTypeExtension.create(CobblebreakerguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<DrawbrigeguiMenu>> DRAWBRIGEGUI = REGISTRY.register("drawbrigegui", () -> IMenuTypeExtension.create(DrawbrigeguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NotyetguiMenu>> NOTYETGUI = REGISTRY.register("notyetgui", () -> IMenuTypeExtension.create(NotyetguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobsguiMenu>> JOBSGUI = REGISTRY.register("jobsgui", () -> IMenuTypeExtension.create(JobsguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ExamplegrinderguiMenu>> EXAMPLEGRINDERGUI = REGISTRY.register("examplegrindergui", () -> IMenuTypeExtension.create(ExamplegrinderguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ForgeexampleguiMenu>> FORGEEXAMPLEGUI = REGISTRY.register("forgeexamplegui", () -> IMenuTypeExtension.create(ForgeexampleguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<SticknewhelpMenu>> STICKNEWHELP = REGISTRY.register("sticknewhelp", () -> IMenuTypeExtension.create(SticknewhelpMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobsminerguiMenu>> JOBSMINERGUI = REGISTRY.register("jobsminergui", () -> IMenuTypeExtension.create(JobsminerguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobsminercraftguiMenu>> JOBSMINERCRAFTGUI = REGISTRY.register("jobsminercraftgui", () -> IMenuTypeExtension.create(JobsminercraftguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GamblelingjobsjetonMenu>> GAMBLELINGJOBSJETON = REGISTRY.register("gamblelingjobsjeton", () -> IMenuTypeExtension.create(GamblelingjobsjetonMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AdminshopplantcacaoMenu>> ADMINSHOPPLANTCACAO = REGISTRY.register("adminshopplantcacao", () -> IMenuTypeExtension.create(AdminshopplantcacaoMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<ClickerMenu>> CLICKER = REGISTRY.register("clicker", () -> IMenuTypeExtension.create(ClickerMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobsfarmercraftguiMenu>> JOBSFARMERCRAFTGUI = REGISTRY.register("jobsfarmercraftgui", () -> IMenuTypeExtension.create(JobsfarmercraftguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackamethystguiMenu>> BACKPACKAMETHYSTGUI = REGISTRY.register("backpackamethystgui", () -> IMenuTypeExtension.create(BackpackamethystguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpacktitaneMenu>> BACKPACKTITANE = REGISTRY.register("backpacktitane", () -> IMenuTypeExtension.create(BackpacktitaneMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackpaladiumMenu>> BACKPACKPALADIUM = REGISTRY.register("backpackpaladium", () -> IMenuTypeExtension.create(BackpackpaladiumMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<InventorybackupMenu>> INVENTORYBACKUP = REGISTRY.register("inventorybackup", () -> IMenuTypeExtension.create(InventorybackupMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<BackpackendiumMenu>> BACKPACKENDIUM = REGISTRY.register("backpackendium", () -> IMenuTypeExtension.create(BackpackendiumMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobsfarmerguiMenu>> JOBSFARMERGUI = REGISTRY.register("jobsfarmergui", () -> IMenuTypeExtension.create(JobsfarmerguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GodvillagerguiMenu>> GODVILLAGERGUI = REGISTRY.register("godvillagergui", () -> IMenuTypeExtension.create(GodvillagerguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobsserverMenu>> JOBSSERVER = REGISTRY.register("jobsserver", () -> IMenuTypeExtension.create(JobsserverMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CobbleakerserverMenu>> COBBLEAKERSERVER = REGISTRY.register("cobbleakerserver", () -> IMenuTypeExtension.create(CobbleakerserverMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FlowertotemguiMenu>> FLOWERTOTEMGUI = REGISTRY.register("flowertotemgui", () -> IMenuTypeExtension.create(FlowertotemguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<TypesettingtablestorageMenu>> TYPESETTINGTABLESTORAGE = REGISTRY.register("typesettingtablestorage", () -> IMenuTypeExtension.create(TypesettingtablestorageMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<NewAdminshopguiMenu>> NEW_ADMINSHOPGUI = REGISTRY.register("new_adminshopgui", () -> IMenuTypeExtension.create(NewAdminshopguiMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof PalamodModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}
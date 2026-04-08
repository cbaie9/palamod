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
	public static final DeferredHolder<MenuType<?>, MenuType<GuardianguiMenu>> GUARDIANGUI = REGISTRY.register("guardiangui", () -> IMenuTypeExtension.create(GuardianguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<GolemtreecMenu>> GOLEMTREEC = REGISTRY.register("golemtreec", () -> IMenuTypeExtension.create(GolemtreecMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<FactionhomeguiMenu>> FACTIONHOMEGUI = REGISTRY.register("factionhomegui", () -> IMenuTypeExtension.create(FactionhomeguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AnalyserloadingMenu>> ANALYSERLOADING = REGISTRY.register("analyserloading", () -> IMenuTypeExtension.create(AnalyserloadingMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<AnalyserresultMenu>> ANALYSERRESULT = REGISTRY.register("analyserresult", () -> IMenuTypeExtension.create(AnalyserresultMenu::new));
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
	public static final DeferredHolder<MenuType<?>, MenuType<SpawncontrollerguiMenu>> SPAWNCONTROLLERGUI = REGISTRY.register("spawncontrollergui", () -> IMenuTypeExtension.create(SpawncontrollerguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<CrushercraftpalahelpguiMenu>> CRUSHERCRAFTPALAHELPGUI = REGISTRY.register("crushercraftpalahelpgui", () -> IMenuTypeExtension.create(CrushercraftpalahelpguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobshunterguiMenu>> JOBSHUNTERGUI = REGISTRY.register("jobshuntergui", () -> IMenuTypeExtension.create(JobshunterguiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<JobsalchiguiMenu>> JOBSALCHIGUI = REGISTRY.register("jobsalchigui", () -> IMenuTypeExtension.create(JobsalchiguiMenu::new));

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
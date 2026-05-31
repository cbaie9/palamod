/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.client.gui.*;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

@EventBusSubscriber(Dist.CLIENT)
public class PalamodModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(PalamodModMenus.CRUSHERGUI.get(), CrusherguiScreen::new);
		event.register(PalamodModMenus.PALAMACHINEGUI.get(), PalamachineguiScreen::new);
		event.register(PalamodModMenus.GRINDERGUI.get(), GrinderguiScreen::new);
		event.register(PalamodModMenus.ALCHEMYCREATORGUI.get(), AlchemycreatorguiScreen::new);
		event.register(PalamodModMenus.PALAHELPGUI_1.get(), Palahelpgui1Screen::new);
		event.register(PalamodModMenus.PALAHELPBLOCK.get(), PalahelpblockScreen::new);
		event.register(PalamodModMenus.FORGEGUI.get(), ForgeguiScreen::new);
		event.register(PalamodModMenus.PALAHELPORE.get(), PalahelporeScreen::new);
		event.register(PalamodModMenus.PALAHELPTREE.get(), PalahelptreeScreen::new);
		event.register(PalamodModMenus.PALAHELPMACHINE.get(), PalahelpmachineScreen::new);
		event.register(PalamodModMenus.GRINDERPALAHELPGUI.get(), GrinderpalahelpguiScreen::new);
		event.register(PalamodModMenus.GRINDERPALAHELP_2GUI.get(), Grinderpalahelp2guiScreen::new);
		event.register(PalamodModMenus.PALAMACHINEPALAHELPGUI.get(), PalamachinepalahelpguiScreen::new);
		event.register(PalamodModMenus.CRUSHERPALAHELPGUI.get(), CrusherpalahelpguiScreen::new);
		event.register(PalamodModMenus.FORGEPALAHELPGUI.get(), ForgepalahelpguiScreen::new);
		event.register(PalamodModMenus.FLUIDPALAHELP.get(), FluidpalahelpScreen::new);
		event.register(PalamodModMenus.ITEMMENUPALAHELP.get(), ItemmenupalahelpScreen::new);
		event.register(PalamodModMenus.LEGENDARYSTONEPALAHELP.get(), LegendarystonepalahelpScreen::new);
		event.register(PalamodModMenus.ARMORPALAHELPGUI.get(), ArmorpalahelpguiScreen::new);
		event.register(PalamodModMenus.XPBUSHPALAHELPGUI.get(), XpbushpalahelpguiScreen::new);
		event.register(PalamodModMenus.LUCKYGUI.get(), LuckyguiScreen::new);
		event.register(PalamodModMenus.PALADUMFURNACE.get(), PaladumfurnaceScreen::new);
		event.register(PalamodModMenus.SAFEGUI.get(), SafeguiScreen::new);
		event.register(PalamodModMenus.PHONEGUI.get(), PhoneguiScreen::new);
		event.register(PalamodModMenus.MEGASAFECHESTFIRSTSETUP.get(), MegasafechestfirstsetupScreen::new);
		event.register(PalamodModMenus.AUTHSAFEGUI.get(), AuthsafeguiScreen::new);
		event.register(PalamodModMenus.LANGUAGESELECTION.get(), LanguageselectionScreen::new);
		event.register(PalamodModMenus.PALAHELPNOTSUPPORTED.get(), PalahelpnotsupportedScreen::new);
		event.register(PalamodModMenus.STOCKHDV.get(), StockhdvScreen::new);
		event.register(PalamodModMenus.ADMINPANELMENU.get(), AdminpanelmenuScreen::new);
		event.register(PalamodModMenus.PALAERROR_0005.get(), Palaerror0005Screen::new);
		event.register(PalamodModMenus.SPAWNPANEL.get(), SpawnpanelScreen::new);
		event.register(PalamodModMenus.PALAERROR_0006.get(), Palaerror0006Screen::new);
		event.register(PalamodModMenus.TRASHGUI.get(), TrashguiScreen::new);
		event.register(PalamodModMenus.ADMINSHOPMENU.get(), AdminshopmenuScreen::new);
		event.register(PalamodModMenus.GUARDIANGUI.get(), GuardianguiScreen::new);
		event.register(PalamodModMenus.GOLEMTREEC.get(), GolemtreecScreen::new);
		event.register(PalamodModMenus.FACTIONHOMEGUI.get(), FactionhomeguiScreen::new);
		event.register(PalamodModMenus.ANALYSERLOADING.get(), AnalyserloadingScreen::new);
		event.register(PalamodModMenus.ANALYSERRESULT.get(), AnalyserresultScreen::new);
		event.register(PalamodModMenus.UPLOADERGUI.get(), UploaderguiScreen::new);
		event.register(PalamodModMenus.SPECIALMONEYPANEL.get(), SpecialmoneypanelScreen::new);
		event.register(PalamodModMenus.TITANECHESTGUI.get(), TitanechestguiScreen::new);
		event.register(PalamodModMenus.AMETHYSTCHESTGUI.get(), AmethystchestguiScreen::new);
		event.register(PalamodModMenus.PALADIUMCHESTGUI.get(), PaladiumchestguiScreen::new);
		event.register(PalamodModMenus.GREENPALADIUMCHESTGUI.get(), GreenpaladiumchestguiScreen::new);
		event.register(PalamodModMenus.ENDIUMCHESTGUI.get(), EndiumchestguiScreen::new);
		event.register(PalamodModMenus.ORELAYERFAT.get(), OrelayerfatScreen::new);
		event.register(PalamodModMenus.DOWNLOADERGUI.get(), DownloaderguiScreen::new);
		event.register(PalamodModMenus.DOWNLOADERLINK.get(), DownloaderlinkScreen::new);
		event.register(PalamodModMenus.POTGTRANFERT.get(), PotgtranfertScreen::new);
		event.register(PalamodModMenus.TRIXIUMDEPOSIT.get(), TrixiumdepositScreen::new);
		event.register(PalamodModMenus.EXAMPLEUPLOADERGUI.get(), ExampleuploaderguiScreen::new);
		event.register(PalamodModMenus.UPLOADERGUIPALAHELP.get(), UploaderguipalahelpScreen::new);
		event.register(PalamodModMenus.ONLINEDETECTORGUI.get(), OnlinedetectorguiScreen::new);
		event.register(PalamodModMenus.COBBLEBREAKERGUI.get(), CobblebreakerguiScreen::new);
		event.register(PalamodModMenus.DRAWBRIGEGUI.get(), DrawbrigeguiScreen::new);
		event.register(PalamodModMenus.NOTYETGUI.get(), NotyetguiScreen::new);
		event.register(PalamodModMenus.JOBSGUI.get(), JobsguiScreen::new);
		event.register(PalamodModMenus.EXAMPLEGRINDERGUI.get(), ExamplegrinderguiScreen::new);
		event.register(PalamodModMenus.FORGEEXAMPLEGUI.get(), ForgeexampleguiScreen::new);
		event.register(PalamodModMenus.STICKNEWHELP.get(), SticknewhelpScreen::new);
		event.register(PalamodModMenus.JOBSMINERGUI.get(), JobsminerguiScreen::new);
		event.register(PalamodModMenus.JOBSMINERCRAFTGUI.get(), JobsminercraftguiScreen::new);
		event.register(PalamodModMenus.GAMBLELINGJOBSJETON.get(), GamblelingjobsjetonScreen::new);
		event.register(PalamodModMenus.CLICKER.get(), ClickerScreen::new);
		event.register(PalamodModMenus.JOBSFARMERCRAFTGUI.get(), JobsfarmercraftguiScreen::new);
		event.register(PalamodModMenus.BACKPACKAMETHYSTGUI.get(), BackpackamethystguiScreen::new);
		event.register(PalamodModMenus.BACKPACKTITANE.get(), BackpacktitaneScreen::new);
		event.register(PalamodModMenus.BACKPACKPALADIUM.get(), BackpackpaladiumScreen::new);
		event.register(PalamodModMenus.INVENTORYBACKUP.get(), InventorybackupScreen::new);
		event.register(PalamodModMenus.BACKPACKENDIUM.get(), BackpackendiumScreen::new);
		event.register(PalamodModMenus.JOBSFARMERGUI.get(), JobsfarmerguiScreen::new);
		event.register(PalamodModMenus.GODVILLAGERGUI.get(), GodvillagerguiScreen::new);
		event.register(PalamodModMenus.JOBSSERVER.get(), JobsserverScreen::new);
		event.register(PalamodModMenus.COBBLEAKERSERVER.get(), CobbleakerserverScreen::new);
		event.register(PalamodModMenus.FLOWERTOTEMGUI.get(), FlowertotemguiScreen::new);
		event.register(PalamodModMenus.TYPESETTINGTABLESTORAGE.get(), TypesettingtablestorageScreen::new);
		event.register(PalamodModMenus.NEW_ADMINSHOPGUI.get(), NewAdminshopguiScreen::new);
		event.register(PalamodModMenus.SPAWNCONTROLLERGUI.get(), SpawncontrollerguiScreen::new);
		event.register(PalamodModMenus.CRUSHERCRAFTPALAHELPGUI.get(), CrushercraftpalahelpguiScreen::new);
		event.register(PalamodModMenus.JOBSHUNTERGUI.get(), JobshunterguiScreen::new);
		event.register(PalamodModMenus.JOBSALCHIGUI.get(), JobsalchiguiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}
}
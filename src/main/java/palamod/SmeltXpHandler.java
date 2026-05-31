/*
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside palamod as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package palamod;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.common.EventBusSubscriber;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import palamod.procedures.CraftGiveXpJobsProcedure;


@EventBusSubscriber
public class SmeltXpHandler {

    @SubscribeEvent
    public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        Player player = event.getEntity();
        ItemStack result = event.getSmelting();

		if(!player.level().isClientSide()){
			CraftGiveXpJobsProcedure.execute( /// xp craft via crafting table 
			player.level(), // ✅ world en premier
	        player,         // ✅ entity ensuite
	        result,
	        "smelt"
			);


		}
    }
}
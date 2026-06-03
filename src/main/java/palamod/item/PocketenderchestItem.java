package palamod.item;

import palamod.procedures.PocketenderchestopenProcedure;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.neoforged.fml.loading.FMLEnvironment;



public class PocketenderchestItem extends Item {

    public PocketenderchestItem(Item.Properties properties) {
        super(properties.stacksTo(1).rarity(Rarity.EPIC));
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack itemstack, BlockState state) {
        return true;
    }

    @Override
    public InteractionResult use(Level world, Player player, InteractionHand hand) {

        if (!FMLEnvironment.getDist().isDedicatedServer()) {
            return InteractionResult.SUCCESS;
        }

        PocketenderchestopenProcedure.execute(player);

        return InteractionResult.CONSUME;
    }
}
package palamod.item;

import palamod.procedures.PocketenderchestopenProcedure;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;

public class PocketenderchestItem extends Item {
    public PocketenderchestItem(Item.Properties properties) {
        super(properties.rarity(Rarity.EPIC).stacksTo(1));
    }

    @Override
    public boolean isCorrectToolForDrops(ItemStack itemstack, BlockState state) {
        return true;
    }

    @Override
    public InteractionResult use(Level world, Player entity, InteractionHand hand) {
        InteractionResult ar = super.use(world, entity, hand);
        PocketenderchestopenProcedure.execute(world, entity); // Correction ici
        return ar;
    }
}
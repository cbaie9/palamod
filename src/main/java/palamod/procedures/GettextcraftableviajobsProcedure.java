package palamod.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;


public class GettextcraftableviajobsProcedure {


    // Nouvelle vraie méthode utilisée par le tooltip
    public static String execute(ItemStack itemstack) {

        if (itemstack == null || itemstack.isEmpty())
            return "";

        String requirement = JobCraftRestrictionManagerProcedure
                .getRequirementText(itemstack);

        if (requirement.isEmpty())
            return "";

        return Component.translatable("palamod.item.craft_via_jobs")
                .getString()
                + requirement;
    }
}
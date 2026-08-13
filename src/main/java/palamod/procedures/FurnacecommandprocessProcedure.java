package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

public class FurnacecommandprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack main_hand = ItemStack.EMPTY;
		if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.COMMANDFURNACENOPERMACCESS) || entity.hasPermissions(2)) {
			main_hand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			if (!(main_hand.getItem() == (world instanceof Level _lvlSmeltResult
					? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(main_hand), _lvlSmeltResult).map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy()).orElse(ItemStack.EMPTY)
					: ItemStack.EMPTY).getItem())
					&& !(Blocks.AIR.asItem() == (world instanceof Level _lvlSmeltResult
							? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(main_hand), _lvlSmeltResult).map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy())
									.orElse(ItemStack.EMPTY)
							: ItemStack.EMPTY).getItem())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack9 = (world instanceof Level _lvlSmeltResult
							? _lvlSmeltResult.getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SingleRecipeInput(main_hand), _lvlSmeltResult).map(recipe -> recipe.value().getResultItem(_lvlSmeltResult.registryAccess()).copy())
									.orElse(ItemStack.EMPTY)
							: ItemStack.EMPTY).copy();
					_setstack9.setCount(main_hand.getCount());
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack9);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				MsgtellrawautosendProcedure.execute(world, x, y, z, entity, Component.translatable("palamod.procedure.furnace_cantbesmelted").getString());
			}
		} else {
			MsgtellrawautosendProcedure.execute(world, x, y, z, entity, Component.translatable("palamod.procedure.noperm").getString());
		}
	}
}
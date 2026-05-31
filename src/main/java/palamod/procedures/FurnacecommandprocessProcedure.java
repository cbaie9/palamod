package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.permissions.Permissions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;

public class FurnacecommandprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack main_hand = ItemStack.EMPTY;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(PalamodModGameRules.COMMANDFURNACENOPERMACCESS.get()) || hasEntityPermissionLevel(entity, 2)) {
			main_hand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			if (!(main_hand.getItem() == (getItemStackSmeltingResult(world, main_hand)).getItem()) && !(Blocks.AIR.asItem() == (getItemStackSmeltingResult(world, main_hand)).getItem())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack9 = (getItemStackSmeltingResult(world, main_hand)).copy();
					_setstack9.setCount(main_hand.getCount());
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack9);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.furnace_cantbesmelted").getString());
			}
		} else {
			MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.procedure.noperm").getString());
		}
	}

	private static boolean hasEntityPermissionLevel(Entity entity, int permissionLevel) {
		if (entity instanceof Player _player) {
			return switch (permissionLevel) {
				case 0 -> true;
				case 1 -> _player.permissions().hasPermission(Permissions.COMMANDS_MODERATOR);
				case 2 -> _player.permissions().hasPermission(Permissions.COMMANDS_GAMEMASTER);
				case 3 -> _player.permissions().hasPermission(Permissions.COMMANDS_ADMIN);
				default -> _player.permissions().hasPermission(Permissions.COMMANDS_OWNER);
			};
		}
		return false;
	}

	private static ItemStack getItemStackSmeltingResult(LevelAccessor level, ItemStack input) {
		SingleRecipeInput recipeInput = new SingleRecipeInput(input);
		if (level instanceof ServerLevel serverLevel) {
			return serverLevel.recipeAccess().getRecipeFor(RecipeType.SMELTING, recipeInput, serverLevel).map(recipe -> recipe.value().assemble(recipeInput).copy()).orElse(ItemStack.EMPTY);
		}
		return ItemStack.EMPTY;
	}
}
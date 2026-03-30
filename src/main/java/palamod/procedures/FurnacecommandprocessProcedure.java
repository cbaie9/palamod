package palamod.procedures;

import palamod.init.PalamodModGameRules;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class FurnacecommandprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack main_hand = ItemStack.EMPTY;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().getBoolean(PalamodModGameRules.COMMANDFURNACENOPERMACCESS) || entity instanceof Player _playerCmd1 && _playerCmd1.hasPermissions(2)) {
			main_hand = (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).copy();
			if (!(main_hand.getItem() == (getItemStackFromItemStackSlot(world, main_hand)).getItem()) && !(Blocks.AIR.asItem() == (getItemStackFromItemStackSlot(world, main_hand)).getItem())) {
				if (entity instanceof LivingEntity _entity) {
					ItemStack _setstack9 = (getItemStackFromItemStackSlot(world, main_hand)).copy();
					_setstack9.setCount(main_hand.getCount());
					_entity.setItemInHand(InteractionHand.MAIN_HAND, _setstack9);
					if (_entity instanceof Player _player)
						_player.getInventory().setChanged();
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"[ Palamod : \",\"color\":\"dark_red\"},{\"text\":\"/furnace\",\"color\":\"gold\"},{\"text\":\" ] :\",\"color\":\"dark_red\"},{\"text\":\" " + ""
									+ Component.translatable("palamod.procedure.furnace_cantbesmelted").getString() + "\",\"color\":\"gold\"}]"));
			}
		} else {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						("tellraw @p [\"\",{\"text\":\"[ Palamod : \",\"color\":\"dark_red\"},{\"text\":\"/furnace\",\"color\":\"gold\"},{\"text\":\" ] :\",\"color\":\"dark_red\"},{\"text\":\" " + ""
								+ Component.translatable("palamod.procedure.noperm").getString() + "\",\"color\":\"gold\"}]"));
		}
	}

	private static ItemStack getItemStackFromItemStackSlot(LevelAccessor level, ItemStack input) {
		SingleRecipeInput recipeInput = new SingleRecipeInput(input);
		if (level instanceof ServerLevel serverLevel) {
			return serverLevel.recipeAccess().getRecipeFor(RecipeType.SMELTING, recipeInput, serverLevel).map(recipe -> recipe.value().assemble(recipeInput, serverLevel.registryAccess()).copy()).orElse(ItemStack.EMPTY);
		}
		return ItemStack.EMPTY;
	}
}
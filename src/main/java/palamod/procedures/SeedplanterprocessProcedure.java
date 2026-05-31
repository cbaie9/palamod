package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

public class SeedplanterprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean act = false;
		double level = 0;
		double turn = 0;
		double xplus = 0;
		double zplus = 0;
		if (!itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("seedplanter_setup", false)) {
			{
				final String _tagName = "seedplanter_setup";
				final boolean _tagValue = true;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putBoolean(_tagName, _tagValue));
			}
			{
				final String _tagName = "mode";
				final double _tagValue = 1;
				CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
			}
		}
		if (entity.isShiftKeyDown()) {
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 1) {
				{
					final String _tagName = "mode";
					final double _tagValue = 2;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.minecraft.carrot").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 2) {
				{
					final String _tagName = "mode";
					final double _tagValue = 3;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.minecraft.potato").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 3) {
				{
					final String _tagName = "mode";
					final double _tagValue = 4;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("block.minecraft.melon").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 4) {
				{
					final String _tagName = "mode";
					final double _tagValue = 5;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("block.minecraft.pumpkin").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 5) {
				{
					final String _tagName = "mode";
					final double _tagValue = 6;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.palamod.eggplant_seed").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 6) {
				{
					final String _tagName = "mode";
					final double _tagValue = 7;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.palamod.chervilseed").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 7) {
				{
					final String _tagName = "mode";
					final double _tagValue = 8;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.palamod.kiwanoseed").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 8) {
				{
					final String _tagName = "mode";
					final double _tagValue = 9;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.palamod.orangeblueseed").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 9) {
				{
					final String _tagName = "mode";
					final double _tagValue = 10;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.minecraft.beetroot").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 10) {
				{
					final String _tagName = "mode";
					final double _tagValue = 1;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(
							new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.minecraft.wheat").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			}
		} else {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_SEEDPLANTER.get()) {
				turn = 2;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_SEEDPLANTER.get()) {
				turn = 4;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_SEEDPLANTER.get()) {
				turn = 6;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.GREEN_PALADIUM_SEEDPLANTER.get()) {
				turn = 8;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_SEEDPLANTER.get()) {
				turn = 12;
			}
			if (act) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.crop.plant")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("item.crop.plant")), SoundSource.BLOCKS, 1, 1, false);
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}
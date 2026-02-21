package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModEntities;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundLevelEventPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.chat.Component;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;

public class Luckyprocessv2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Random = 0;
		boolean illegal_operation_check = false;
		Random = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "Random_lucky");
		if (Random >= 164000 && Random <= 164500) {
			PalamodModVariables.lucky_name = "Double Xp";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack1 = new ItemStack(Items.EXPERIENCE_BOTTLE).copy();
				_setstack1.setCount(1);
				_menu.getSlots().get(3).set(_setstack1);
				ItemStack _setstack2 = new ItemStack(Items.EXPERIENCE_BOTTLE).copy();
				_setstack2.setCount(1);
				_menu.getSlots().get(4).set(_setstack2);
				ItemStack _setstack3 = new ItemStack(Items.EXPERIENCE_BOTTLE).copy();
				_setstack3.setCount(1);
				_menu.getSlots().get(5).set(_setstack3);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player)
				_player.giveExperienceLevels(entity instanceof Player _plr ? _plr.experienceLevel : 0);
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Double Xp"));
			}
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 164500 && Random <= 164600) {
			PalamodModVariables.lucky_name = "Duplicata";
			if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
				for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
					ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
					if (entity instanceof Player _player) {
						ItemStack _setstack = itemstackiterator.copy();
						_setstack.setCount(1);
						ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
					}
				}
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack12 = new ItemStack(Blocks.AIR).copy();
				_setstack12.setCount(1);
				_menu.getSlots().get(3).set(_setstack12);
				ItemStack _setstack13 = new ItemStack(Blocks.COMMAND_BLOCK).copy();
				_setstack13.setCount(1);
				_menu.getSlots().get(4).set(_setstack13);
				ItemStack _setstack14 = new ItemStack(Blocks.AIR).copy();
				_setstack14.setCount(1);
				_menu.getSlots().get(5).set(_setstack14);
				_player.containerMenu.broadcastChanges();
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Duplicata"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = true;
		}
		if (Random >= 600 && Random <= 166810) {
			PalamodModVariables.lucky_name = "End";
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = true;
			PalamodMod.queueServerWork(100, () -> {
				if (entity instanceof ServerPlayer _player && !_player.level().isClientSide()) {
					ResourceKey<Level> destinationType = Level.END;
					if (_player.level().dimension() == destinationType)
						return;
					ServerLevel nextLevel = _player.server.getLevel(destinationType);
					if (nextLevel != null) {
						_player.connection.send(new ClientboundGameEventPacket(ClientboundGameEventPacket.WIN_GAME, 0));
						_player.teleportTo(nextLevel, _player.getX(), _player.getY(), _player.getZ(), _player.getYRot(), _player.getXRot());
						_player.connection.send(new ClientboundPlayerAbilitiesPacket(_player.getAbilities()));
						for (MobEffectInstance _effectinstance : _player.getActiveEffects())
							_player.connection.send(new ClientboundUpdateMobEffectPacket(_player.getId(), _effectinstance, false));
						_player.connection.send(new ClientboundLevelEventPacket(1032, BlockPos.ZERO, 0, false));
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack19 = new ItemStack(Blocks.END_PORTAL_FRAME).copy();
					_setstack19.setCount(1);
					_menu.getSlots().get(3).set(_setstack19);
					ItemStack _setstack20 = new ItemStack(Blocks.END_PORTAL).copy();
					_setstack20.setCount(1);
					_menu.getSlots().get(4).set(_setstack20);
					ItemStack _setstack21 = new ItemStack(Blocks.END_PORTAL_FRAME).copy();
					_setstack21.setCount(1);
					_menu.getSlots().get(5).set(_setstack21);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " End"));
				}
			});
		}
		if (Random >= 166800 && Random <= 168000) {
			PalamodModVariables.lucky_name = "Endium beacon";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack26 = new ItemStack(Blocks.LAPIS_BLOCK).copy();
				_setstack26.setCount(1);
				_menu.getSlots().get(3).set(_setstack26);
				ItemStack _setstack27 = new ItemStack(Blocks.BEACON).copy();
				_setstack27.setCount(1);
				_menu.getSlots().get(4).set(_setstack27);
				ItemStack _setstack28 = new ItemStack(Blocks.LAPIS_BLOCK).copy();
				_setstack28.setCount(1);
				_menu.getSlots().get(5).set(_setstack28);
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~-3 ~ ~3 ~3 ~ ~-3 minecraft:lapis_block");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~-2 ~1 ~2 ~2 ~1 ~-2 minecraft:lapis_block");
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~-1 ~2 ~1 ~1 ~2 ~-1 minecraft:lapis_block");
			world.setBlock(BlockPos.containing(x, y + 1, z), Blocks.BEACON.defaultBlockState(), 3);
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Endium beacon"));
			}
			PalamodModVariables.Lucky_destroy = 2;
			illegal_operation_check = false;
		}
		if (Random >= 168000 && Random <= 168100) {
			PalamodModVariables.lucky_name = "Endium \"Grade\"";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack36 = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
				_setstack36.setCount(1);
				_menu.getSlots().get(3).set(_setstack36);
				ItemStack _setstack37 = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
				_setstack37.setCount(1);
				_menu.getSlots().get(4).set(_setstack37);
				ItemStack _setstack38 = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
				_setstack38.setCount(1);
				_menu.getSlots().get(5).set(_setstack38);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_INGOT.get()).copy();
				_setstack.setCount(64);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Endium \"Grade\" ( core beta v1 )"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = false;
		}
		if (Random >= 168100 && Random <= 168200) {
			PalamodModVariables.lucky_name = "Endium Block";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack43 = new ItemStack(PalamodModBlocks.ENDIUM_BLOCK.get()).copy();
				_setstack43.setCount(1);
				_menu.getSlots().get(3).set(_setstack43);
				ItemStack _setstack44 = new ItemStack(PalamodModBlocks.ENDIUM_BLOCK.get()).copy();
				_setstack44.setCount(1);
				_menu.getSlots().get(4).set(_setstack44);
				ItemStack _setstack45 = new ItemStack(PalamodModBlocks.ENDIUM_BLOCK.get()).copy();
				_setstack45.setCount(1);
				_menu.getSlots().get(5).set(_setstack45);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModBlocks.ENDIUM_BLOCK.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Endium Block"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = true;
		}
		if (Random >= 168200 && Random <= 191200) {
			PalamodModVariables.lucky_name = "Enferm\uFFFD";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack50 = new ItemStack(Blocks.IRON_BARS).copy();
				_setstack50.setCount(1);
				_menu.getSlots().get(3).set(_setstack50);
				ItemStack _setstack51 = new ItemStack(Blocks.IRON_BARS).copy();
				_setstack51.setCount(1);
				_menu.getSlots().get(4).set(_setstack51);
				ItemStack _setstack52 = new ItemStack(Blocks.IRON_BARS).copy();
				_setstack52.setCount(1);
				_menu.getSlots().get(5).set(_setstack52);
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, new Vec3((entity.getX()), (entity.getY() - 1), (entity.getZ())), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"fill ~-3 ~ ~3 ~3 ~ ~-3 minecraft:obsidian");
			{
				BlockPos _bp = BlockPos.containing(entity.getX() + 1, entity.getY() + 1, entity.getZ());
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = BlockPos.containing(entity.getX() + 1, entity.getY(), entity.getZ());
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = BlockPos.containing(entity.getX() - 1, entity.getY() + 1, entity.getZ());
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = BlockPos.containing(entity.getX() - 1, entity.getY(), entity.getZ());
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() + 1);
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() + 1);
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY(), entity.getZ() - 1);
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY() + 1, entity.getZ() - 1);
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			{
				BlockPos _bp = BlockPos.containing(entity.getX(), entity.getY() + 2, entity.getZ());
				BlockState _bs = PalamodModBlocks.RENFORCED_OBSIDIAN.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Property<?> _propertyOld : _bso.getProperties()) {
					Property _propertyNew = _bs.getBlock().getStateDefinition().getProperty(_propertyOld.getName());
					if (_propertyNew != null && _bs.getValue(_propertyNew) != null)
						try {
							_bs = _bs.setValue(_propertyNew, _bso.getValue(_propertyOld));
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Enferm\uFFFD"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = false;
		}
		if (Random >= 191200 && Random <= 193500) {
			PalamodModVariables.lucky_name = " Et Les Phant";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack96 = new ItemStack(Blocks.BAMBOO).copy();
				_setstack96.setCount(1);
				_menu.getSlots().get(3).set(_setstack96);
				ItemStack _setstack97 = new ItemStack(Blocks.BAMBOO).copy();
				_setstack97.setCount(1);
				_menu.getSlots().get(4).set(_setstack97);
				ItemStack _setstack98 = new ItemStack(Blocks.BAMBOO).copy();
				_setstack98.setCount(1);
				_menu.getSlots().get(5).set(_setstack98);
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = PalamodModEntities.PALADIUM_GOLEM.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"Title title In current devloppement");
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Et Les Phant"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = false;
		}
		if (Random >= 193500 && Random <= 193600) {
			PalamodModVariables.lucky_name = " Et Paf des \"sous \"";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack104 = new ItemStack(PalamodModItems.MONEY_OTHER.get()).copy();
				_setstack104.setCount(1);
				_menu.getSlots().get(3).set(_setstack104);
				ItemStack _setstack105 = new ItemStack(PalamodModItems.MONEY_OTHER.get()).copy();
				_setstack105.setCount(1);
				_menu.getSlots().get(4).set(_setstack105);
				ItemStack _setstack106 = new ItemStack(PalamodModItems.MONEY_OTHER.get()).copy();
				_setstack106.setCount(1);
				_menu.getSlots().get(5).set(_setstack106);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModBlocks.LUCKY_BLOCK.get()).copy();
				_setstack.setCount(64);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Et paf des sous"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = false;
		}
		if (Random >= 193600 && Random <= 193700) {
			PalamodModVariables.lucky_name = " Et Paf plus de \"sous\"";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack111 = new ItemStack(PalamodModItems.MONEY_OTHER.get()).copy();
				_setstack111.setCount(1);
				_menu.getSlots().get(3).set(_setstack111);
				ItemStack _setstack112 = new ItemStack(PalamodModItems.MONEY_OTHER.get()).copy();
				_setstack112.setCount(1);
				_menu.getSlots().get(4).set(_setstack112);
				ItemStack _setstack113 = new ItemStack(PalamodModItems.MONEY_OTHER.get()).copy();
				_setstack113.setCount(1);
				_menu.getSlots().get(5).set(_setstack113);
				_player.containerMenu.broadcastChanges();
			}
			if (hasEntityInInventory(entity, new ItemStack(PalamodModBlocks.LUCKY_BLOCK.get()))) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(PalamodModBlocks.LUCKY_BLOCK.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 20, _player.inventoryMenu.getCraftSlots());
				}
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + " Et paf plus de sous"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = false;
		}
		if (Random >= 193700 && Random <= 196800) {
			PalamodModVariables.lucky_name = "Ex-pala-osion";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack119 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack119.setCount(1);
				_menu.getSlots().get(3).set(_setstack119);
				ItemStack _setstack120 = new ItemStack(Blocks.TNT).copy();
				_setstack120.setCount(1);
				_menu.getSlots().get(4).set(_setstack120);
				ItemStack _setstack121 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack121.setCount(1);
				_menu.getSlots().get(5).set(_setstack121);
				_player.containerMenu.broadcastChanges();
			}
			for (int index0 = 0; index0 < 64; index0++) {
				PalamodMod.queueServerWork(6, () -> {
					if (world instanceof ServerLevel _level)
						_level.sendParticles(ParticleTypes.EXPLOSION, x, y, z, 5, 3, 3, 3, 1);
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.PALADIUM_INGOT.get()));
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				});
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + "Ex-pala-osion"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = false;
		}
		if (Random >= 193700 && Random <= 198300) {
			PalamodModVariables.lucky_name = "Coordonn\uFFFD de Fuze";
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"/give @p written_book{pages:['{\"text\":\"Voici Les coordonn\uFFFDes de Fuze et des r\uFFFDcompences \\n\\nCalcule la page \\n(( 3 + 90 / 3 + 6 ) / 3 + 2 ) / 5\\n\\nBonne chance ;)\"}','[\"\",{\"text\":\"1 : Coordonn\uFFFDes\\n\\n\"},{\"selector\":\"https://youtu.be/3Y7aWLpuxA4\"}]','[\"\",{\"text\":\"2 Coordonn\uFFFD de fuze\\n\\n\"},{\"selector\":\"https://youtu.be/ajlkhFnz8eo?list=TLPQMTcwMjIwMjI29uqOA1D3sQ&t=4\"}]','[\"\",{\"text\":\"3 Coordonn\uFFFDes de Fuze \\n\\n\"},{\"selector\":\"https://youtu.be/GPXkjtpGCFI?t=7\"}]','[\"\",{\"text\":\"4 Coordonn\uFFFDes de fuze \\n\\n\"},{\"selector\":\"https://youtu.be/O91DT1pR1ew\"}]'],title:\"Ma base\",author:Fuzay,display:{Lore:[\"Les Coo de ma base\"]}}");
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu l'event aux Lucky Block " + "Coordonn\uFFFD de fuze"));
			}
			PalamodModVariables.Lucky_destroy = 1;
			illegal_operation_check = false;
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null) {
				_blockEntity.getPersistentData().putString("lucky_name", PalamodModVariables.lucky_name);
			}
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}
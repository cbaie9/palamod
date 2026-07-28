package palamod.procedures;

import palamod.network.PalamodModVariables;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModEntities;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.DoubleArgumentType;

public class Luckyprocess1adminProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		double Random = 0;
		Random = DoubleArgumentType.getDouble(arguments, "random");
		if (Random >= 1 && Random <= 11600) {
			PalamodModVariables.lucky_name = "0 + 0 = La tete a Toto";
			PalamodMod.queueServerWork(100, () -> {
				if (entity instanceof Player _player)
					_player.giveExperienceLevels(-(10000));
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " a eu aux lucky block l'event" + "0 + 0 = La tete a Toto"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 11600 && Random <= 14700) {
			PalamodModVariables.lucky_name = "20 000 Lieux";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack6 = new ItemStack(PalamodModItems.WEIGHTED_BOOTS.get()).copy();
				_setstack6.setCount(1);
				_menu.getSlots().get(3).set(_setstack6);
				ItemStack _setstack7 = new ItemStack(PalamodModItems.WEIGHTED_BOOTS.get()).copy();
				_setstack7.setCount(1);
				_menu.getSlots().get(4).set(_setstack7);
				ItemStack _setstack8 = new ItemStack(PalamodModItems.WEIGHTED_BOOTS.get()).copy();
				_setstack8.setCount(1);
				_menu.getSlots().get(5).set(_setstack8);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.WEIGHTED_BOOTS.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			});
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + " 20 000 Lieux"));
			}
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 11600 && Random <= 14700) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Vous avez eu un event non impl\uFFFDment\uFFFD ( Adieu Faction ) ( N\uFFFDgatif ) Vous avez le droit \uFFFD un deuxi\uFFFDme essai"), true);
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("Lucky_lock", false);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Adieu Faction ( Non impl\uFFFDment\uFFFD )"));
			}
			PalamodModVariables.Lucky_destroy = 2;
		}
		if (Random >= 14700 && Random <= 26300) {
			PalamodModVariables.lucky_name = "Allumer le feu";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack19 = new ItemStack(Blocks.NETHERRACK).copy();
				_setstack19.setCount(1);
				_menu.getSlots().get(3).set(_setstack19);
				ItemStack _setstack20 = new ItemStack(Blocks.NETHERRACK).copy();
				_setstack20.setCount(1);
				_menu.getSlots().get(4).set(_setstack20);
				ItemStack _setstack21 = new ItemStack(Blocks.NETHERRACK).copy();
				_setstack21.setCount(1);
				_menu.getSlots().get(5).set(_setstack21);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-5 ~-1 ~5 ~5 ~-1 ~-5 minecraft:netherrack");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-5 ~ ~5 ~5 ~ ~-5 minecraft:fire");
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Allumer le feu"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 26300 && Random <= 27500) {
			PalamodModVariables.lucky_name = "Amethyste beacon";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack28 = new ItemStack(PalamodModBlocks.AMETHYST_BLOCK.get()).copy();
				_setstack28.setCount(1);
				_menu.getSlots().get(3).set(_setstack28);
				ItemStack _setstack29 = new ItemStack(PalamodModBlocks.AMETHYST_BLOCK.get()).copy();
				_setstack29.setCount(1);
				_menu.getSlots().get(5).set(_setstack29);
				ItemStack _setstack30 = new ItemStack(Blocks.BEACON).copy();
				_setstack30.setCount(1);
				_menu.getSlots().get(4).set(_setstack30);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-3 ~-1 ~3 ~3 ~-1 ~-3 palamod:amethyste_block");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-2 ~1 ~2 ~2 ~1 ~-2 palamod:amethyste_block");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~2 ~1 ~1 ~2 ~-1 palamod:amethyste_block");
				world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.BEACON.defaultBlockState(), 3);
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Amethyste beacon"));
				}
			});
			PalamodModVariables.Lucky_destroy = 3;
		}
		if (Random >= 27500 && Random <= 14700) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Vous avez eu un event non impl\uFFFDment\uFFFD ( Analyste ) ( N\uFFFDgatif ) Vous avez le droit \uFFFD un deuxi\uFFFDme essai"), true);
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack40 = new ItemStack(PalamodModItems.CHUNK_ANASLYSER.get()).copy();
				_setstack40.setCount(1);
				_menu.getSlots().get(3).set(_setstack40);
				ItemStack _setstack41 = new ItemStack(PalamodModItems.CHUNK_ANASLYSER.get()).copy();
				_setstack41.setCount(1);
				_menu.getSlots().get(4).set(_setstack41);
				ItemStack _setstack42 = new ItemStack(PalamodModItems.CHUNK_ANASLYSER.get()).copy();
				_setstack42.setCount(1);
				_menu.getSlots().get(5).set(_setstack42);
				_player.containerMenu.broadcastChanges();
			}
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.CHUNK_ANASLYSER.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("Lucky_lock", false);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
				PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Analyste ( Non impl\uFFFDment\uFFFD )"));
			}
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 14700 && Random <= 26300) {
			PalamodModVariables.lucky_name = "Aranho trap";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack48 = new ItemStack(Blocks.COBWEB).copy();
				_setstack48.setCount(1);
				_menu.getSlots().get(3).set(_setstack48);
				ItemStack _setstack49 = new ItemStack(Blocks.COBWEB).copy();
				_setstack49.setCount(1);
				_menu.getSlots().get(4).set(_setstack49);
				ItemStack _setstack50 = new ItemStack(Blocks.COBWEB).copy();
				_setstack50.setCount(1);
				_menu.getSlots().get(5).set(_setstack50);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-5 ~-1 ~5 ~5 ~-1 ~-5 minecraft:cobweb");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-5 ~ ~5 ~5 ~ ~-5 minecraft:cobweb");
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Aracno- trap"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 26300 && Random <= 35600) {
			PalamodModVariables.lucky_name = "Batman nerveux";
			for (int index480 = 0; index480 < 3; index480++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.BAT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack58 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
				_setstack58.setCount(1);
				_menu.getSlots().get(3).set(_setstack58);
				ItemStack _setstack59 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
				_setstack59.setCount(1);
				_menu.getSlots().get(4).set(_setstack59);
				ItemStack _setstack60 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
				_setstack60.setCount(1);
				_menu.getSlots().get(5).set(_setstack60);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Batman Nerveux"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 35600 && Random <= 81900) {
			PalamodModVariables.lucky_name = "Body guard";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack65 = new ItemStack(Blocks.IRON_BLOCK).copy();
				_setstack65.setCount(1);
				_menu.getSlots().get(3).set(_setstack65);
				ItemStack _setstack66 = new ItemStack(Blocks.CARVED_PUMPKIN).copy();
				_setstack66.setCount(1);
				_menu.getSlots().get(4).set(_setstack66);
				ItemStack _setstack67 = new ItemStack(Blocks.IRON_BLOCK).copy();
				_setstack67.setCount(1);
				_menu.getSlots().get(5).set(_setstack67);
				_player.containerMenu.broadcastChanges();
			}
			for (int index481 = 0; index481 < 3; index481++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.IRON_GOLEM.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Body guard"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 81900 && Random <= 97300) {
			PalamodModVariables.lucky_name = "Boom";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack73 = new ItemStack(Blocks.TNT).copy();
				_setstack73.setCount(1);
				_menu.getSlots().get(3).set(_setstack73);
				ItemStack _setstack74 = new ItemStack(Blocks.TNT).copy();
				_setstack74.setCount(1);
				_menu.getSlots().get(4).set(_setstack74);
				ItemStack _setstack75 = new ItemStack(Blocks.TNT).copy();
				_setstack75.setCount(1);
				_menu.getSlots().get(5).set(_setstack75);
				_player.containerMenu.broadcastChanges();
			}
			for (int index482 = 0; index482 < 3; index482++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PalamodModEntities.PALADIUMDYNAMITE.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Boom"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 97300 && Random <= 120400) {
			PalamodModVariables.lucky_name = "BOOM";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack81 = new ItemStack(Items.TNT_MINECART).copy();
				_setstack81.setCount(1);
				_menu.getSlots().get(3).set(_setstack81);
				ItemStack _setstack82 = new ItemStack(Items.TNT_MINECART).copy();
				_setstack82.setCount(1);
				_menu.getSlots().get(4).set(_setstack82);
				ItemStack _setstack83 = new ItemStack(Items.TNT_MINECART).copy();
				_setstack83.setCount(1);
				_menu.getSlots().get(5).set(_setstack83);
				_player.containerMenu.broadcastChanges();
			}
			for (int index483 = 0; index483 < 1; index483++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = PalamodModEntities.BIGDYNAMITEENTITY.get().spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "BOOM"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 120400 && Random <= 129700) {
			PalamodModVariables.lucky_name = "Boo-Ban";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack89 = new ItemStack(Blocks.POTTED_BAMBOO).copy();
				_setstack89.setCount(1);
				_menu.getSlots().get(3).set(_setstack89);
				ItemStack _setstack90 = new ItemStack(Blocks.POTTED_BAMBOO).copy();
				_setstack90.setCount(1);
				_menu.getSlots().get(4).set(_setstack90);
				ItemStack _setstack91 = new ItemStack(Blocks.POTTED_BAMBOO).copy();
				_setstack91.setCount(1);
				_menu.getSlots().get(5).set(_setstack91);
				_player.containerMenu.broadcastChanges();
			}
			world.setBlock(BlockPos.containing(x, y, z), Blocks.BAMBOO_SAPLING.defaultBlockState(), 3);
			for (int index484 = 0; index484 < 5; index484++) {
				if (world instanceof Level _level) {
					BlockPos _bp = BlockPos.containing(x, y, z);
					if (BoneMealItem.growCrop(new ItemStack(Items.BONE_MEAL), _level, _bp) || BoneMealItem.growWaterPlant(new ItemStack(Items.BONE_MEAL), _level, _bp, null)) {
						if (!_level.isClientSide())
							_level.levelEvent(2005, _bp, 0);
					}
				}
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Boo-Ban"));
				}
			});
			PalamodModVariables.Lucky_destroy = 3;
		}
		if (Random >= 129700 && Random <= 139000) {
			PalamodModVariables.lucky_name = "Bunny life";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack98 = new ItemStack(Items.RABBIT_FOOT).copy();
				_setstack98.setCount(1);
				_menu.getSlots().get(3).set(_setstack98);
				ItemStack _setstack99 = new ItemStack(Items.RABBIT_FOOT).copy();
				_setstack99.setCount(1);
				_menu.getSlots().get(4).set(_setstack99);
				ItemStack _setstack100 = new ItemStack(Items.RABBIT_FOOT).copy();
				_setstack100.setCount(1);
				_menu.getSlots().get(5).set(_setstack100);
				_player.containerMenu.broadcastChanges();
			}
			for (int index485 = 0; index485 < 100; index485++) {
				PalamodMod.queueServerWork(20, () -> {
					{
						Entity _ent = entity;
						double _tx = x;
						double _ty = (y + 1);
						double _tz = z;
						_ent.teleportTo(_tx, _ty, _tz);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
					}
				});
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Bunny life"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 139000 && Random <= 143600) {
			PalamodModVariables.lucky_name = "C'est pas pass\uFFFD loin";
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(1);
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack108 = new ItemStack(Blocks.CREEPER_HEAD).copy();
				_setstack108.setCount(1);
				_menu.getSlots().get(3).set(_setstack108);
				ItemStack _setstack109 = new ItemStack(Blocks.CREEPER_HEAD).copy();
				_setstack109.setCount(1);
				_menu.getSlots().get(4).set(_setstack109);
				ItemStack _setstack110 = new ItemStack(Blocks.CREEPER_HEAD).copy();
				_setstack110.setCount(1);
				_menu.getSlots().get(5).set(_setstack110);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "\"C'est pas pass\uFFFD loin\""));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 143600 && Random <= 145100) {
			PalamodModVariables.lucky_name = "C'est tr\uFFFDs haut non ?";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack115 = new ItemStack(Items.ENDER_PEARL).copy();
				_setstack115.setCount(1);
				_menu.getSlots().get(3).set(_setstack115);
				ItemStack _setstack116 = new ItemStack(Items.ENDER_PEARL).copy();
				_setstack116.setCount(1);
				_menu.getSlots().get(4).set(_setstack116);
				ItemStack _setstack117 = new ItemStack(Items.ENDER_PEARL).copy();
				_setstack117.setCount(1);
				_menu.getSlots().get(5).set(_setstack117);
				_player.containerMenu.broadcastChanges();
			}
			{
				Entity _ent = entity;
				double _tx = x;
				double _ty = 256;
				double _tz = z;
				_ent.teleportTo(_tx, _ty, _tz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(_tx, _ty, _tz, _ent.getYRot(), _ent.getXRot());
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "\"C'est tr\uFFFDs haut non ?\""));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 145100 && Random <= 143600) {
			PalamodModVariables.lucky_name = "Caballo de la muerte";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack123 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
				_setstack123.setCount(1);
				_menu.getSlots().get(3).set(_setstack123);
				ItemStack _setstack124 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
				_setstack124.setCount(1);
				_menu.getSlots().get(4).set(_setstack124);
				ItemStack _setstack125 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
				_setstack125.setCount(1);
				_menu.getSlots().get(5).set(_setstack125);
				_player.containerMenu.broadcastChanges();
			}
			for (int index486 = 0; index486 < 5; index486++) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = EntityType.SKELETON_HORSE.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setDeltaMovement(0, 0, 0);
					}
				}
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Caballo de la muerte"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 145100 && Random <= 147400) {
			PalamodModVariables.lucky_name = "Carte au tr\uFFFDsor";
			world.setBlock(new BlockPos(21000, 255, 100), PalamodModBlocks.TRESAURE_TRUE.get().defaultBlockState(), 3);
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack132 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
				_setstack132.setCount(1);
				_menu.getSlots().get(3).set(_setstack132);
				ItemStack _setstack133 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
				_setstack133.setCount(1);
				_menu.getSlots().get(4).set(_setstack133);
				ItemStack _setstack134 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
				_setstack134.setCount(1);
				_menu.getSlots().get(5).set(_setstack134);
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"msg @s Le coffre au tr\uFFFDsor  est a X:21000 Y:255 Z:100");
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "carte au tr\uFFFDsor (\uFFFD$\uFFFD$"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 147400 && Random <= 149700) {
			PalamodModVariables.lucky_name = "Carte au tr\uFFFDsor";
			world.setBlock(new BlockPos(21000, 255, 100), PalamodModBlocks.TRESAURE_FALSE.get().defaultBlockState(), 3);
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack141 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
				_setstack141.setCount(1);
				_menu.getSlots().get(3).set(_setstack141);
				ItemStack _setstack142 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
				_setstack142.setCount(1);
				_menu.getSlots().get(4).set(_setstack142);
				ItemStack _setstack143 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
				_setstack143.setCount(1);
				_menu.getSlots().get(5).set(_setstack143);
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"msg @s Le coffre au tr\uFFFDsor  est a X:21000 Y:255 Z:100");
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "carte au tr\uFFFDsor $\uFFFD$"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 149700 && Random <= 151200) {
			PalamodModVariables.lucky_name = "Au voleur";
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.ALARM.get().defaultBlockState(), 3);
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack150 = new ItemStack(PalamodModBlocks.ALARM.get()).copy();
				_setstack150.setCount(1);
				_menu.getSlots().get(3).set(_setstack150);
				ItemStack _setstack151 = new ItemStack(PalamodModBlocks.ALARM.get()).copy();
				_setstack151.setCount(1);
				_menu.getSlots().get(4).set(_setstack151);
				ItemStack _setstack152 = new ItemStack(PalamodModBlocks.ALARM.get()).copy();
				_setstack152.setCount(1);
				_menu.getSlots().get(5).set(_setstack152);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Au voleur"));
				}
				PalamodModVariables.Lucky_destroy = 1;
			});
		}
		if (Random >= 151200 && Random <= 152100) {
			PalamodModVariables.lucky_name = "Coffre fort ";
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.MEGA_SAFE_CHEST.get().defaultBlockState(), 3);
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack158 = new ItemStack(PalamodModBlocks.MEGA_SAFE_CHEST.get()).copy();
				_setstack158.setCount(1);
				_menu.getSlots().get(3).set(_setstack158);
				ItemStack _setstack159 = new ItemStack(PalamodModBlocks.MEGA_SAFE_CHEST.get()).copy();
				_setstack159.setCount(1);
				_menu.getSlots().get(4).set(_setstack159);
				ItemStack _setstack160 = new ItemStack(PalamodModBlocks.MEGA_SAFE_CHEST.get()).copy();
				_setstack160.setCount(1);
				_menu.getSlots().get(5).set(_setstack160);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Coffre fort"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 152100 && Random <= 156700) {
			PalamodModVariables.lucky_name = "Colorful lamp";
			world.setBlock(BlockPos.containing(x, y, z), PalamodModBlocks.COLORED_LAMP.get().defaultBlockState(), 3);
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack166 = new ItemStack(PalamodModBlocks.COLOFUL_LAMP.get()).copy();
				_setstack166.setCount(1);
				_menu.getSlots().get(3).set(_setstack166);
				ItemStack _setstack167 = new ItemStack(PalamodModBlocks.COLOFUL_LAMP.get()).copy();
				_setstack167.setCount(1);
				_menu.getSlots().get(4).set(_setstack167);
				ItemStack _setstack168 = new ItemStack(PalamodModBlocks.COLOFUL_LAMP.get()).copy();
				_setstack168.setCount(1);
				_menu.getSlots().get(5).set(_setstack168);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Colorful lamp"));
				}
			});
			PalamodModVariables.Lucky_destroy = 2;
		}
		if (Random >= 156700 && Random <= 157200) {
			PalamodModVariables.lucky_name = " Comment t'a eu \uFFFDa";
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.ORANGEBLUE_SEED.get()).copy();
				_setstack.setCount(12);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack174 = new ItemStack(PalamodModItems.ORANGEBLUE_SEED.get()).copy();
				_setstack174.setCount(1);
				_menu.getSlots().get(3).set(_setstack174);
				ItemStack _setstack175 = new ItemStack(PalamodModItems.ORANGEBLUE_SEED.get()).copy();
				_setstack175.setCount(1);
				_menu.getSlots().get(4).set(_setstack175);
				ItemStack _setstack176 = new ItemStack(PalamodModItems.ORANGEBLUE_SEED.get()).copy();
				_setstack176.setCount(1);
				_menu.getSlots().get(5).set(_setstack176);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Comment t'a eu \uFFFDa"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 157200 && Random <= 161700) {
			PalamodModVariables.lucky_name = "Consolation";
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack.setCount(64);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack182 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack182.setCount(1);
				_menu.getSlots().get(3).set(_setstack182);
				ItemStack _setstack183 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack183.setCount(1);
				_menu.getSlots().get(4).set(_setstack183);
				ItemStack _setstack184 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
				_setstack184.setCount(1);
				_menu.getSlots().get(5).set(_setstack184);
				_player.containerMenu.broadcastChanges();
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.fall")), SoundSource.MASTER, 2, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.anvil.fall")), SoundSource.MASTER, 2, 1, false);
				}
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Consolation"));
				}
			});
			PalamodModVariables.Lucky_destroy = 1;
		}
		if (Random >= 161700 && Random <= 164000) {
			PalamodModVariables.lucky_name = "Diamond beacon";
			PalamodMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-3 ~-1 ~3 ~3 ~-1 ~-3 minecraft:diamond_block");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-2 ~1 ~2 ~2 ~1 ~-2 minecraft:diamond_block");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~2 ~1 ~1 ~2 ~-1 minecraft:diamond_block");
				world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.BEACON.defaultBlockState(), 3);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack194 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
					_setstack194.setCount(1);
					_menu.getSlots().get(3).set(_setstack194);
					ItemStack _setstack195 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
					_setstack195.setCount(1);
					_menu.getSlots().get(4).set(_setstack195);
					ItemStack _setstack196 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
					_setstack196.setCount(1);
					_menu.getSlots().get(5).set(_setstack196);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Diamond beacon"));
				}
			});
			PalamodModVariables.Lucky_destroy = 3;
		}
		if (Random >= 161700 && Random <= 164000) {
			PalamodModVariables.lucky_name = "Diamond beacon";
			if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
				ItemStack _setstack201 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
				_setstack201.setCount(1);
				_menu.getSlots().get(3).set(_setstack201);
				ItemStack _setstack202 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
				_setstack202.setCount(1);
				_menu.getSlots().get(4).set(_setstack202);
				ItemStack _setstack203 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
				_setstack203.setCount(1);
				_menu.getSlots().get(5).set(_setstack203);
				_player.containerMenu.broadcastChanges();
			}
			PalamodMod.queueServerWork(100, () -> {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-3 ~-1 ~3 ~3 ~-1 ~-3 minecraft:diamond_block");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-2 ~1 ~2 ~2 ~1 ~-2 minecraft:diamond_block");
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, (y - 1), z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"fill ~-1 ~2 ~1 ~1 ~2 ~-1 minecraft:diamond_block");
				world.setBlock(BlockPos.containing(x, y + 2, z), Blocks.BEACON.defaultBlockState(), 3);
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + " \uFFFD eu aux lucky block l'event" + "Diamond beacon"));
				}
			});
			PalamodModVariables.Lucky_destroy = 3;
		}
		if (Random > 164000) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putDouble("Random_lucky", Random);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			Luckyprocessv2Procedure.execute(world, x, y, z, entity);
		}
	}
}
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

public class Luckyprocessv1Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double Random = 0;
		if (getBlockNBTLogic(world, BlockPos.containing(x, y, z), "Lucky_lock") == false) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null) {
					_blockEntity.getPersistentData().putBoolean("Lucky_lock", true);
				}
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
			Random = new Random().nextInt(198300 + 1);
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
					ItemStack _setstack8 = new ItemStack(PalamodModItems.WEIGHTED_BOOTS.get()).copy();
					_setstack8.setCount(1);
					_menu.getSlots().get(3).set(_setstack8);
					ItemStack _setstack9 = new ItemStack(PalamodModItems.WEIGHTED_BOOTS.get()).copy();
					_setstack9.setCount(1);
					_menu.getSlots().get(4).set(_setstack9);
					ItemStack _setstack10 = new ItemStack(PalamodModItems.WEIGHTED_BOOTS.get()).copy();
					_setstack10.setCount(1);
					_menu.getSlots().get(5).set(_setstack10);
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
					ItemStack _setstack21 = new ItemStack(Blocks.NETHERRACK).copy();
					_setstack21.setCount(1);
					_menu.getSlots().get(3).set(_setstack21);
					ItemStack _setstack22 = new ItemStack(Blocks.NETHERRACK).copy();
					_setstack22.setCount(1);
					_menu.getSlots().get(4).set(_setstack22);
					ItemStack _setstack23 = new ItemStack(Blocks.NETHERRACK).copy();
					_setstack23.setCount(1);
					_menu.getSlots().get(5).set(_setstack23);
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
					ItemStack _setstack30 = new ItemStack(PalamodModBlocks.AMETHYST_BLOCK.get()).copy();
					_setstack30.setCount(1);
					_menu.getSlots().get(3).set(_setstack30);
					ItemStack _setstack31 = new ItemStack(PalamodModBlocks.AMETHYST_BLOCK.get()).copy();
					_setstack31.setCount(1);
					_menu.getSlots().get(5).set(_setstack31);
					ItemStack _setstack32 = new ItemStack(Blocks.BEACON).copy();
					_setstack32.setCount(1);
					_menu.getSlots().get(4).set(_setstack32);
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
					ItemStack _setstack42 = new ItemStack(PalamodModItems.CHUNKANASLYSER.get()).copy();
					_setstack42.setCount(1);
					_menu.getSlots().get(3).set(_setstack42);
					ItemStack _setstack43 = new ItemStack(PalamodModItems.CHUNKANASLYSER.get()).copy();
					_setstack43.setCount(1);
					_menu.getSlots().get(4).set(_setstack43);
					ItemStack _setstack44 = new ItemStack(PalamodModItems.CHUNKANASLYSER.get()).copy();
					_setstack44.setCount(1);
					_menu.getSlots().get(5).set(_setstack44);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(PalamodModItems.CHUNKANASLYSER.get()).copy();
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
					ItemStack _setstack50 = new ItemStack(Blocks.COBWEB).copy();
					_setstack50.setCount(1);
					_menu.getSlots().get(3).set(_setstack50);
					ItemStack _setstack51 = new ItemStack(Blocks.COBWEB).copy();
					_setstack51.setCount(1);
					_menu.getSlots().get(4).set(_setstack51);
					ItemStack _setstack52 = new ItemStack(Blocks.COBWEB).copy();
					_setstack52.setCount(1);
					_menu.getSlots().get(5).set(_setstack52);
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
				for (int index0 = 0; index0 < 3; index0++) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = EntityType.BAT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack60 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
					_setstack60.setCount(1);
					_menu.getSlots().get(3).set(_setstack60);
					ItemStack _setstack61 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
					_setstack61.setCount(1);
					_menu.getSlots().get(4).set(_setstack61);
					ItemStack _setstack62 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
					_setstack62.setCount(1);
					_menu.getSlots().get(5).set(_setstack62);
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
					ItemStack _setstack67 = new ItemStack(Blocks.IRON_BLOCK).copy();
					_setstack67.setCount(1);
					_menu.getSlots().get(3).set(_setstack67);
					ItemStack _setstack68 = new ItemStack(Blocks.CARVED_PUMPKIN).copy();
					_setstack68.setCount(1);
					_menu.getSlots().get(4).set(_setstack68);
					ItemStack _setstack69 = new ItemStack(Blocks.IRON_BLOCK).copy();
					_setstack69.setCount(1);
					_menu.getSlots().get(5).set(_setstack69);
					_player.containerMenu.broadcastChanges();
				}
				for (int index1 = 0; index1 < 3; index1++) {
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
					ItemStack _setstack75 = new ItemStack(Blocks.TNT).copy();
					_setstack75.setCount(1);
					_menu.getSlots().get(3).set(_setstack75);
					ItemStack _setstack76 = new ItemStack(Blocks.TNT).copy();
					_setstack76.setCount(1);
					_menu.getSlots().get(4).set(_setstack76);
					ItemStack _setstack77 = new ItemStack(Blocks.TNT).copy();
					_setstack77.setCount(1);
					_menu.getSlots().get(5).set(_setstack77);
					_player.containerMenu.broadcastChanges();
				}
				for (int index2 = 0; index2 < 3; index2++) {
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
					ItemStack _setstack83 = new ItemStack(Items.TNT_MINECART).copy();
					_setstack83.setCount(1);
					_menu.getSlots().get(3).set(_setstack83);
					ItemStack _setstack84 = new ItemStack(Items.TNT_MINECART).copy();
					_setstack84.setCount(1);
					_menu.getSlots().get(4).set(_setstack84);
					ItemStack _setstack85 = new ItemStack(Items.TNT_MINECART).copy();
					_setstack85.setCount(1);
					_menu.getSlots().get(5).set(_setstack85);
					_player.containerMenu.broadcastChanges();
				}
				for (int index3 = 0; index3 < 1; index3++) {
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
					ItemStack _setstack91 = new ItemStack(Blocks.POTTED_BAMBOO).copy();
					_setstack91.setCount(1);
					_menu.getSlots().get(3).set(_setstack91);
					ItemStack _setstack92 = new ItemStack(Blocks.POTTED_BAMBOO).copy();
					_setstack92.setCount(1);
					_menu.getSlots().get(4).set(_setstack92);
					ItemStack _setstack93 = new ItemStack(Blocks.POTTED_BAMBOO).copy();
					_setstack93.setCount(1);
					_menu.getSlots().get(5).set(_setstack93);
					_player.containerMenu.broadcastChanges();
				}
				world.setBlock(BlockPos.containing(x, y, z), Blocks.BAMBOO_SAPLING.defaultBlockState(), 3);
				for (int index4 = 0; index4 < 5; index4++) {
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
					ItemStack _setstack100 = new ItemStack(Items.RABBIT_FOOT).copy();
					_setstack100.setCount(1);
					_menu.getSlots().get(3).set(_setstack100);
					ItemStack _setstack101 = new ItemStack(Items.RABBIT_FOOT).copy();
					_setstack101.setCount(1);
					_menu.getSlots().get(4).set(_setstack101);
					ItemStack _setstack102 = new ItemStack(Items.RABBIT_FOOT).copy();
					_setstack102.setCount(1);
					_menu.getSlots().get(5).set(_setstack102);
					_player.containerMenu.broadcastChanges();
				}
				for (int index5 = 0; index5 < 100; index5++) {
					PalamodMod.queueServerWork(20, () -> {
						{
							Entity _ent = entity;
							_ent.teleportTo(x, (y + 1), z);
							if (_ent instanceof ServerPlayer _serverPlayer)
								_serverPlayer.connection.teleport(x, (y + 1), z, _ent.getYRot(), _ent.getXRot());
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
					ItemStack _setstack110 = new ItemStack(Blocks.CREEPER_HEAD).copy();
					_setstack110.setCount(1);
					_menu.getSlots().get(3).set(_setstack110);
					ItemStack _setstack111 = new ItemStack(Blocks.CREEPER_HEAD).copy();
					_setstack111.setCount(1);
					_menu.getSlots().get(4).set(_setstack111);
					ItemStack _setstack112 = new ItemStack(Blocks.CREEPER_HEAD).copy();
					_setstack112.setCount(1);
					_menu.getSlots().get(5).set(_setstack112);
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
					ItemStack _setstack117 = new ItemStack(Items.ENDER_PEARL).copy();
					_setstack117.setCount(1);
					_menu.getSlots().get(3).set(_setstack117);
					ItemStack _setstack118 = new ItemStack(Items.ENDER_PEARL).copy();
					_setstack118.setCount(1);
					_menu.getSlots().get(4).set(_setstack118);
					ItemStack _setstack119 = new ItemStack(Items.ENDER_PEARL).copy();
					_setstack119.setCount(1);
					_menu.getSlots().get(5).set(_setstack119);
					_player.containerMenu.broadcastChanges();
				}
				{
					Entity _ent = entity;
					_ent.teleportTo(x, 256, z);
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport(x, 256, z, _ent.getYRot(), _ent.getXRot());
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
					ItemStack _setstack125 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
					_setstack125.setCount(1);
					_menu.getSlots().get(3).set(_setstack125);
					ItemStack _setstack126 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
					_setstack126.setCount(1);
					_menu.getSlots().get(4).set(_setstack126);
					ItemStack _setstack127 = new ItemStack(Items.BAT_SPAWN_EGG).copy();
					_setstack127.setCount(1);
					_menu.getSlots().get(5).set(_setstack127);
					_player.containerMenu.broadcastChanges();
				}
				for (int index6 = 0; index6 < 5; index6++) {
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
					ItemStack _setstack134 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
					_setstack134.setCount(1);
					_menu.getSlots().get(3).set(_setstack134);
					ItemStack _setstack135 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
					_setstack135.setCount(1);
					_menu.getSlots().get(4).set(_setstack135);
					ItemStack _setstack136 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
					_setstack136.setCount(1);
					_menu.getSlots().get(5).set(_setstack136);
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
					ItemStack _setstack143 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
					_setstack143.setCount(1);
					_menu.getSlots().get(3).set(_setstack143);
					ItemStack _setstack144 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
					_setstack144.setCount(1);
					_menu.getSlots().get(4).set(_setstack144);
					ItemStack _setstack145 = new ItemStack(PalamodModBlocks.TRESAURE_FALSE.get()).copy();
					_setstack145.setCount(1);
					_menu.getSlots().get(5).set(_setstack145);
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
					ItemStack _setstack152 = new ItemStack(PalamodModBlocks.ALARM.get()).copy();
					_setstack152.setCount(1);
					_menu.getSlots().get(3).set(_setstack152);
					ItemStack _setstack153 = new ItemStack(PalamodModBlocks.ALARM.get()).copy();
					_setstack153.setCount(1);
					_menu.getSlots().get(4).set(_setstack153);
					ItemStack _setstack154 = new ItemStack(PalamodModBlocks.ALARM.get()).copy();
					_setstack154.setCount(1);
					_menu.getSlots().get(5).set(_setstack154);
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
					ItemStack _setstack160 = new ItemStack(PalamodModBlocks.MEGA_SAFE_CHEST.get()).copy();
					_setstack160.setCount(1);
					_menu.getSlots().get(3).set(_setstack160);
					ItemStack _setstack161 = new ItemStack(PalamodModBlocks.MEGA_SAFE_CHEST.get()).copy();
					_setstack161.setCount(1);
					_menu.getSlots().get(4).set(_setstack161);
					ItemStack _setstack162 = new ItemStack(PalamodModBlocks.MEGA_SAFE_CHEST.get()).copy();
					_setstack162.setCount(1);
					_menu.getSlots().get(5).set(_setstack162);
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
					ItemStack _setstack168 = new ItemStack(PalamodModBlocks.COLOFUL_LAMP.get()).copy();
					_setstack168.setCount(1);
					_menu.getSlots().get(3).set(_setstack168);
					ItemStack _setstack169 = new ItemStack(PalamodModBlocks.COLOFUL_LAMP.get()).copy();
					_setstack169.setCount(1);
					_menu.getSlots().get(4).set(_setstack169);
					ItemStack _setstack170 = new ItemStack(PalamodModBlocks.COLOFUL_LAMP.get()).copy();
					_setstack170.setCount(1);
					_menu.getSlots().get(5).set(_setstack170);
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
					ItemStack _setstack176 = new ItemStack(PalamodModItems.ORANGEBLUE_SEED.get()).copy();
					_setstack176.setCount(1);
					_menu.getSlots().get(3).set(_setstack176);
					ItemStack _setstack177 = new ItemStack(PalamodModItems.ORANGEBLUE_SEED.get()).copy();
					_setstack177.setCount(1);
					_menu.getSlots().get(4).set(_setstack177);
					ItemStack _setstack178 = new ItemStack(PalamodModItems.ORANGEBLUE_SEED.get()).copy();
					_setstack178.setCount(1);
					_menu.getSlots().get(5).set(_setstack178);
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
					ItemStack _setstack184 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
					_setstack184.setCount(1);
					_menu.getSlots().get(3).set(_setstack184);
					ItemStack _setstack185 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
					_setstack185.setCount(1);
					_menu.getSlots().get(4).set(_setstack185);
					ItemStack _setstack186 = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
					_setstack186.setCount(1);
					_menu.getSlots().get(5).set(_setstack186);
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
						ItemStack _setstack196 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
						_setstack196.setCount(1);
						_menu.getSlots().get(3).set(_setstack196);
						ItemStack _setstack197 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
						_setstack197.setCount(1);
						_menu.getSlots().get(4).set(_setstack197);
						ItemStack _setstack198 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
						_setstack198.setCount(1);
						_menu.getSlots().get(5).set(_setstack198);
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
					ItemStack _setstack203 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
					_setstack203.setCount(1);
					_menu.getSlots().get(3).set(_setstack203);
					ItemStack _setstack204 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
					_setstack204.setCount(1);
					_menu.getSlots().get(4).set(_setstack204);
					ItemStack _setstack205 = new ItemStack(Blocks.DIAMOND_BLOCK).copy();
					_setstack205.setCount(1);
					_menu.getSlots().get(5).set(_setstack205);
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
			} else {
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
				LuckyexitProcedure.execute(world, x, y, z, entity);
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}
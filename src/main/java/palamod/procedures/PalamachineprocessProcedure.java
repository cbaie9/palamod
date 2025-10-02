package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;

public class PalamachineprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu2 ? _menu2.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu6 ? _menu6.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu8 ? _menu8.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.HEAL_ORB.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.HEALSTICK.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Is using the Palamachine ( heal stick )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu22 ? _menu22.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu26 ? _menu26.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SLIMEPAD.get().asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu28 ? _menu28.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.SLIMEPAD.get().asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu30 ? _menu30.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.JUMP_ORB.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.STRENGHTSTICK.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Is using the Palamachine ( strenght stick )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu44 ? _menu44.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu46 ? _menu46.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu48 ? _menu48.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get()
						.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu50 ? _menu50.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get()
						.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu52 ? _menu52.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.STRENGH_ORB.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.JUMPSTICK.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Is using the Palamachine ( jump stick )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu66 ? _menu66.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu68 ? _menu68.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu70 ? _menu70.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_SPIKE.get()
						.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu72 ? _menu72.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_SPIKE.get()
						.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu74 ? _menu74.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_SWORD.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.DAMAGESTICK.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Is using the Palamachine ( damage stick )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu88 ? _menu88.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.AMETHYST_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu90 ? _menu90.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.TITANE_STICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu92 ? _menu92.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.COMPRESSED_AMETHYST.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu94 ? _menu94.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.COMPRESSED_TITANE.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu96 ? _menu96.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.SPEED_ORB.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.SPEEDSTICK.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Is using the Palamachine ( speed stick )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu110 ? _menu110.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.JUMPSTICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu112 ? _menu112.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.JUMPSTICK.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu114 ? _menu114.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get()
						.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu116 ? _menu116.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get()
						.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu118 ? _menu118.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.JUMP_ORB.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.HYPERJUMPSTICK.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.info((entity.getDisplayName().getString() + "Is using the Palamachine ( hyper shiny jump stick )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu132 ? _menu132.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu134 ? _menu134.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu136 ? _menu136.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu138 ? _menu138.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu140 ? _menu140.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get()
						.asItem()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.SMALL_RING.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + "Is using the Palamachine ( small ring )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu154 ? _menu154.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu156 ? _menu156.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu158 ? _menu158.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu160 ? _menu160.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu162 ? _menu162.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.BIG_RING.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_SMALL_RING.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + "Is using the Palamachine ( small endium ring )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu176 ? _menu176.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu178 ? _menu178.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get()
						.asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu180 ? _menu180.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu182 ? _menu182.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu184 ? _menu184.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.SMALL_RING.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.MEDIUM_RING.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + "Is using the Palamachine ( medium ring )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu198 ? _menu198.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu200 ? _menu200.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu202 ? _menu202.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu204 ? _menu204.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu206 ? _menu206.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_SMALL_RING.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_MEDIUM_RING.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + "Is using the Palamachine ( medium endium ring )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu220 ? _menu220.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.ENDIUM_BLOCK.get().asItem()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu222 ? _menu222.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu224 ? _menu224.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu226 ? _menu226.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu228 ? _menu228.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.ENDIUM_MEDIUM_RING
						.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_BIG_RING.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + "Is using the Palamachine ( big endium ring )"));
				}
			});
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu242 ? _menu242.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu244 ? _menu244.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu246 ? _menu246.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu248 ? _menu248.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu250 ? _menu250.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.MEDIUM_RING.get()) {
			PalamodMod.queueServerWork(160, () -> {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.get(ResourceLocation.parse("block.fire.ambient")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				world.addParticle(ParticleTypes.EXPLOSION, x, y, z, 0, 1, 0);
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					ItemStack _setstack = new ItemStack(PalamodModItems.BIG_RING.get()).copy();
					_setstack.setCount(1);
					_menu.getSlots().get(6).set(_setstack);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(2).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(3).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(4).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof PalamodModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(5).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOGSALL)) {
					PalamodMod.LOGGER.debug((entity.getDisplayName().getString() + "Is using the Palamachine ( big ring )"));
				}
			});
		}
	}
}
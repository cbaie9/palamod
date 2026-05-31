package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.permissions.LevelBasedPermissionSet;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@EventBusSubscriber
public class CauldroncraftprocessProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event, event.getPlayer().level(), event.getPlayer().getX(), event.getPlayer().getY(), event.getPlayer().getZ(), event.getPlayer(), event.getEntity().getItem());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		execute(null, world, x, y, z, entity, itemstack);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean pass = false;
		boolean res = false;
		boolean no_clear = false;
		ItemStack output = ItemStack.EMPTY;
		ItemStack glueball = ItemStack.EMPTY;
		String tank1_type = "";
		String tank2_type = "";
		double y_core = 0;
		double x_core = 0;
		double z_core = 0;
		double nb_items = 0;
		double random = 0;
		double jobs_alchi = 0;
		if (world instanceof ServerLevel _serverLevelGR0 && _serverLevelGR0.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
			PalamodMod.LOGGER.info("drop");
			PalamodMod.LOGGER.info(("drop        :" + itemstack));
		}
		if ((entity instanceof ServerPlayer || entity instanceof Player) && itemstack.is(ItemTags.create(Identifier.parse("palamod:cauldron_craft")))) {
			if (pass) {
				tank1_type = "None";
				tank2_type = "None";
				if (world instanceof ServerLevel _serverLevelGR13 && _serverLevelGR13.getGameRules().get(PalamodModGameRules.PALAMODDEBUGLOG.get())) {
					PalamodMod.LOGGER.info("core found");
					PalamodMod.LOGGER.info(("core found" + itemstack + "\n" + "setup : " + getBlockNBTLogic(world, BlockPos.containing(x_core, y_core, z_core), "cauldron_open") + "\n"
							+ itemstack.is(ItemTags.create(Identifier.parse("palamod:modded_flowers"))) + itemstack.is(ItemTags.create(Identifier.parse("palamod:vanilla_flowers")))));
				}
				nb_items = itemstack.getCount();
				if (itemstack.is(ItemTags.create(Identifier.parse("palamod:modded_flowers")))) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"kill @e[type=minecraft:item,distance=..5]");
					res = true;
				} else if (itemstack.is(ItemTags.create(Identifier.parse("palamod:vanilla_flowers")))) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"kill @e[type=minecraft:item,distance=..5]");
					res = true;
				} else if (Blocks.GLOWSTONE.asItem() == itemstack.getItem()) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"kill @e[type=minecraft:item,distance=..5]");
					res = true;
				} else if (itemstack.getItem() == PalamodModItems.GLUEBALL_PATTERN.get()) {
					PalamodMod.LOGGER.info("Starting glueball craft, acquering tank 1 and 2");
					no_clear = true;
					res = true;
					PalamodMod.LOGGER.info(("TANK" + (world.getBlockState(BlockPos.containing(x_core - 3, y_core + 1, z_core))).is(BlockTags.create(Identifier.parse("palamod:tanks")))
							+ getBlockNBTLogic(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "setup") + (5 <= getBlockNBTNumber(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "stock"))));
					if ((world.getBlockState(BlockPos.containing(x_core - 3, y_core + 1, z_core))).is(BlockTags.create(Identifier.parse("palamod:tanks")))) {
						if (getBlockNBTLogic(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "setup")) {
							if (5 <= getBlockNBTNumber(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "stock")) {
								if (("ostrya").equals(getBlockNBTString(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "type"))
										|| ("judeecercis").equals(getBlockNBTString(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "type"))
										|| ("jacaranda").equals(getBlockNBTString(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "type"))
										|| ("erable").equals(getBlockNBTString(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "type"))) {
									tank1_type = getBlockNBTString(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "type");
									PalamodMod.LOGGER.info(("tank1 acr , type : " + tank1_type));
								}
							}
						}
					}
					if ((world.getBlockState(BlockPos.containing(x_core + 3, y_core + 1, z_core))).is(BlockTags.create(Identifier.parse("palamod:tanks")))) {
						if (getBlockNBTLogic(world, BlockPos.containing(x_core + 3, y_core + 1, z_core), "setup")) {
							if (5 <= getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core + 1, z_core), "stock")) {
								if (("ostrya").equals(getBlockNBTString(world, BlockPos.containing(x_core + 3, y_core + 1, z_core), "type"))
										|| ("judeecercis").equals(getBlockNBTString(world, BlockPos.containing(x_core + 3, y_core + 1, z_core), "type"))
										|| ("jacaranda").equals(getBlockNBTString(world, BlockPos.containing(x_core + 3, y_core + 1, z_core), "type"))
										|| ("erable").equals(getBlockNBTString(world, BlockPos.containing(x_core + 3, y_core + 1, z_core), "type"))) {
									tank2_type = getBlockNBTString(world, BlockPos.containing(x_core - 3, y_core + 1, z_core), "type");
									PalamodMod.LOGGER.info(("tank2 acr , type : " + tank2_type));
								}
							}
						}
					}
					jobs_alchi = GetleveljobsProcedure.execute(world, entity, "alchi");
					PalamodMod.LOGGER.info(("jobs acr for player : " + entity.getDisplayName().getString() + ", level alchi : " + jobs_alchi));
					if (!(world instanceof ServerLevel _serverLevelGR63 && _serverLevelGR63.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get()))) {
						jobs_alchi = 9999;
					}
					if (!("None").equals(tank1_type) || !("None").equals(tank2_type)) {
						if (("erable").equals(tank1_type) && ("judeecercis").equals(tank2_type) || ("judeecercis").equals(tank1_type) && ("erable").equals(tank2_type)) {
							if (jobs_alchi >= 10) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core - 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								glueball = new ItemStack(PalamodModBlocks.GLUEBALL_ORANGE.get()).copy();
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("erable").equals(tank1_type) && ("ostrya").equals(tank2_type) || ("ostrya").equals(tank1_type) && ("erable").equals(tank2_type)) {
							if (jobs_alchi >= 10) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core - 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								glueball = new ItemStack(PalamodModBlocks.GLUEBALL_GRAY.get()).copy();
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("erable").equals(tank1_type) && ("jacaranda").equals(tank2_type) || ("jacaranda").equals(tank1_type) && ("erable").equals(tank2_type)) {
							if (jobs_alchi >= 10) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core - 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								glueball = new ItemStack(PalamodModBlocks.GLUEBALL_PURPLE.get()).copy();
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("ostrya").equals(tank1_type) && ("judeecercis").equals(tank2_type) || ("judeecercis").equals(tank1_type) && ("ostrya").equals(tank2_type)) {
							if (jobs_alchi >= 10) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core - 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								glueball = new ItemStack(PalamodModBlocks.GLUEBALL_LIGHT_GREEN.get()).copy();
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("jacaranda").equals(tank1_type) && ("judeecercis").equals(tank2_type) || ("judeecercis").equals(tank1_type) && ("jacaranda").equals(tank2_type)) {
							if (jobs_alchi >= 10) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core - 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								glueball = new ItemStack(PalamodModBlocks.GLUEBALL_DARK_GREEN.get()).copy();
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("jacaranda").equals(tank1_type) && ("ostrya").equals(tank2_type) || ("ostrya").equals(tank1_type) && ("jacaranda").equals(tank2_type)) {
							if (jobs_alchi >= 10) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core - 3, y_core, z_core), "stock") - 5));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								glueball = new ItemStack(PalamodModBlocks.GLUEBALL_CYAN.get()).copy();
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("jacaranda").equals(tank1_type) || ("jacaranda").equals(tank2_type)) {
							if (jobs_alchi >= 6) {
								if (("jacaranda").equals(tank1_type)) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									glueball = new ItemStack(PalamodModBlocks.GLUEBALL_BLUE.get()).copy();
								} else if (("jacaranda").equals(tank2_type)) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									glueball = new ItemStack(PalamodModBlocks.GLUEBALL_BLUE.get()).copy();
								} else {
									PalamodMod.LOGGER.error("[Palamod->Cauldron]: Internal Error -> no tank is defined but system is in has a defined state");
								}
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("ostrya").equals(tank1_type) || ("ostrya").equals(tank2_type)) {
							if (jobs_alchi >= 6) {
								if (("ostrya").equals(tank1_type)) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									glueball = new ItemStack(PalamodModBlocks.GREEN_GLUEBALL.get()).copy();
								} else if (("ostrya").equals(tank2_type)) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									glueball = new ItemStack(PalamodModBlocks.GREEN_GLUEBALL.get()).copy();
								} else {
									PalamodMod.LOGGER.error("[Palamod->Cauldron]: Internal Error -> no tank is defined but system is in has a defined state");
								}
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("judeecercis").equals(tank1_type) || ("judeecercis").equals(tank2_type)) {
							if (jobs_alchi >= 6) {
								if (("judeecercis").equals(tank1_type)) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									glueball = new ItemStack(PalamodModBlocks.GLUEBALL_YELLOW.get()).copy();
								} else if (("judeecercis").equals(tank2_type)) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									glueball = new ItemStack(PalamodModBlocks.GLUEBALL_YELLOW.get()).copy();
								} else {
									PalamodMod.LOGGER.error("[Palamod->Cauldron]: Internal Error -> no tank is defined but system is in has a defined state");
								}
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						} else if (("erable").equals(tank1_type) || ("erable").equals(tank2_type)) {
							if (jobs_alchi >= 6) {
								if (("erable").equals(tank1_type)) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x_core - 3, y_core, z_core);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									glueball = new ItemStack(PalamodModBlocks.GLUEBALL_RED.get()).copy();
								} else if (("erable").equals(tank2_type)) {
									if (!world.isClientSide()) {
										BlockPos _bp = BlockPos.containing(x_core + 3, y_core, z_core);
										BlockEntity _blockEntity = world.getBlockEntity(_bp);
										BlockState _bs = world.getBlockState(_bp);
										if (_blockEntity != null) {
											_blockEntity.getPersistentData().putDouble("stock", (getBlockNBTNumber(world, BlockPos.containing(x_core + 3, y_core, z_core), "stock") - 5));
										}
										if (world instanceof Level _level)
											_level.sendBlockUpdated(_bp, _bs, _bs, 3);
									}
									glueball = new ItemStack(PalamodModBlocks.GLUEBALL_RED.get()).copy();
								} else {
									PalamodMod.LOGGER.error("[Palamod->Cauldron]: Internal Error -> no tank is defined but system is in has a defined state");
								}
							} else {
								MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
							}
						}
					}
				} else if (PalamodModBlocks.ENDIUM_FLOWER.get().asItem() == itemstack.getItem() || PalamodModBlocks.ENDIUM_FLOWER_ON.get().asItem() == itemstack.getItem()) {
					jobs_alchi = GetleveljobsProcedure.execute(world, entity, "alchi");
					if (!(world instanceof ServerLevel _serverLevelGR112 && _serverLevelGR112.getGameRules().get(PalamodModGameRules.LOCKEDCRAFT.get()))) {
						jobs_alchi = 9999;
					}
					if (jobs_alchi >= 20) {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"kill @e[type=minecraft:item,distance=..5]");
						res = true;
					}
				} else if (itemstack.is(ItemTags.create(Identifier.parse("palamod:cauldron_craft")))) {
					res = true;
				}
			}
			if (res) {
				if (!no_clear) {
					PalamodMod.queueServerWork(3, () -> {
						if (world instanceof ServerLevel _level)
							_level.getServer().getCommands().performPrefixedCommand(
									new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, LevelBasedPermissionSet.OWNER, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
									"kill @e[type=minecraft:item,distance=..5]");
						PalamodMod.queueServerWork(1, () -> {
							CauldroncraftresultProcedure.execute(world, x, y, z, entity, itemstack, new ItemStack(PalamodModBlocks.NBT_BLOCK.get()));
						});
					});
				} else {
					CauldroncraftresultProcedure.execute(world, x, y, z, entity, itemstack, glueball);
				}
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBooleanOr(tag, false);
		return false;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDoubleOr(tag, 0);
		return -1;
	}

	private static String getBlockNBTString(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getStringOr(tag, "");
		return "";
	}
}
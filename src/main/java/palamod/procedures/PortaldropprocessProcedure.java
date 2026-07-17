package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@EventBusSubscriber
public class PortaldropprocessProcedure {
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
		BlockState active = Blocks.AIR.defaultBlockState();
		ItemStack key = ItemStack.EMPTY;
		double y_core = 0;
		double x_core = 0;
		double z_core = 0;
		double loop = 0;
		double limit_to_result = 0;
		double level_alchi = 0;
		double level_required = 0;
		String type = "";
		String type_input = "";
		String stock_name = "";
		PalamodMod.LOGGER.debug("Drop portal --------");
		level_alchi = GetleveljobsProcedure.execute(world, entity, "alchi");
		if (itemstack.getItem() == PalamodModItems.TANKITEM.get() || itemstack.getItem() == PalamodModItems.FLASK.get()) {
			if (itemstack.getItem() == PalamodModItems.TANKITEM.get()) {
				type_input = itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("type");
				stock_name = "stock";
			} else {
				stock_name = "seve";
				if (1 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type")) {
					type_input = "ostrya";
				} else if (2 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type")) {
					type_input = "judeecercis";
				} else if (3 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type")) {
					type_input = "jacaranda";
				} else if (4 == itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("type")) {
					type_input = "erable";
				}
			}
			for (int index119 = 0; index119 < 4; index119++) {
				if (loop == 0) {
					active = PalamodModBlocks.AMETHYST_PORTALBLOCK.get().defaultBlockState();
					type = "jacaranda";
					level_required = 6;
					limit_to_result = 1;
				} else if (loop == 1) {
					active = PalamodModBlocks.TITANE_PORTAL_BLOCK.get().defaultBlockState();
					type = "judeecercis";
					level_required = 9;
					limit_to_result = 2;
				} else if (loop == 2) {
					active = PalamodModBlocks.PALADIUM_PORTAL_BLOCK.get().defaultBlockState();
					type = "erable";
					level_required = 12;
					limit_to_result = 4;
				} else if (loop == 3) {
					active = PalamodModBlocks.ENDIUM_PORTAL_BLOCK.get().defaultBlockState();
					type = "ostrya";
					level_required = 20;
					limit_to_result = 3448;
				} else {
					break;
				}
				int horizontalRadiusHemiBot = (int) 5 - 1;
				int verticalRadiusHemiBot = (int) 2;
				int yIterationsHemiBot = verticalRadiusHemiBot;
				for (int i = -yIterationsHemiBot; i <= 0; i++) {
					if (i == -verticalRadiusHemiBot) {
						continue;
					}
					for (int xi = -horizontalRadiusHemiBot; xi <= horizontalRadiusHemiBot; xi++) {
						for (int zi = -horizontalRadiusHemiBot; zi <= horizontalRadiusHemiBot; zi++) {
							double distanceSq = (xi * xi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot) + (i * i) / (double) (verticalRadiusHemiBot * verticalRadiusHemiBot)
									+ (zi * zi) / (double) (horizontalRadiusHemiBot * horizontalRadiusHemiBot);
							if (distanceSq <= 1.0) {
								if (active.getBlock() == (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()) {
									x_core = x + xi;
									y_core = y + i;
									z_core = z + zi;
									pass = true;
									if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
										PalamodMod.LOGGER.debug(("Core(portal) :  x : " + x_core + " y : " + y_core + " z : " + z_core + "\n" + level_required + " - " + limit_to_result + "\n" + "Active :" + active));
									}
								}
								if (pass) {
									break;
								}
							}
						}
					}
				}
				if (pass) {
					break;
				}
				loop = loop + 1;
			}
			PalamodMod.LOGGER.info(type_input);
			PalamodMod.LOGGER.info(type);
			if (pass) {
				if (level_alchi >= level_required || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDUSE)) {
					if (getBlockNBTLogic(world, BlockPos.containing(x_core, y_core, z_core), "portal_powered") && (type_input).equals(type)) {
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putDouble("key_stock",
										(getBlockNBTNumber(world, BlockPos.containing(x_core, y_core, z_core), "key_stock") + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(stock_name)));
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						PalamodMod.LOGGER.info(("tank stock" + key.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(stock_name)));
						{
							final String _tagName = stock_name;
							final double _tagValue = 0;
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
						}
						{
							final String _tagName = "type";
							final String _tagValue = "None";
							CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putString(_tagName, _tagValue));
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null) {
								_blockEntity.getPersistentData().putString("key_type", type_input);
							}
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						PalamodMod.LOGGER.info(("key stock" + getBlockNBTNumber(world, BlockPos.containing(x_core, y_core, z_core), "key_stock")));
						while (getBlockNBTNumber(world, BlockPos.containing(x_core, y_core, z_core), "key_stock") >= limit_to_result) {
							PalamodMod.LOGGER.info(("tank stock" + itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble(stock_name)));
							if (("jacaranda").equals(type)) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("key_stock", (getBlockNBTNumber(world, BlockPos.containing(x_core, y_core, z_core), "key_stock") - limit_to_result));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.AMETHYST_INGOT.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (("judeecercis").equals(type)) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("key_stock", (getBlockNBTNumber(world, BlockPos.containing(x_core, y_core, z_core), "key_stock") - limit_to_result));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.TITANE_INGOT.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (("erable").equals(type)) {
								if (!world.isClientSide()) {
									BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
									BlockEntity _blockEntity = world.getBlockEntity(_bp);
									BlockState _bs = world.getBlockState(_bp);
									if (_blockEntity != null) {
										_blockEntity.getPersistentData().putDouble("key_stock", (getBlockNBTNumber(world, BlockPos.containing(x_core, y_core, z_core), "key_stock") - limit_to_result));
									}
									if (world instanceof Level _level)
										_level.sendBlockUpdated(_bp, _bs, _bs, 3);
								}
								if (world instanceof ServerLevel _level) {
									ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.PALADIUM_INGOT.get()));
									entityToSpawn.setPickUpDelay(10);
									_level.addFreshEntity(entityToSpawn);
								}
							} else if (("ostrya").equals(type)) {
								if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.ENDIUM_POLLEN.get()))) {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(PalamodModItems.ENDIUM_POLLEN.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									if (hasEntityInInventory(entity, new ItemStack(PalamodModItems.ENDIUM_POLLEN.get()))) {
										if (!world.isClientSide()) {
											BlockPos _bp = BlockPos.containing(x_core, y_core, z_core);
											BlockEntity _blockEntity = world.getBlockEntity(_bp);
											BlockState _bs = world.getBlockState(_bp);
											if (_blockEntity != null) {
												_blockEntity.getPersistentData().putDouble("key_stock", (getBlockNBTNumber(world, BlockPos.containing(x_core, y_core, z_core), "key_stock") - limit_to_result));
											}
											if (world instanceof Level _level)
												_level.sendBlockUpdated(_bp, _bs, _bs, 3);
										}
										if (entity instanceof Player _player) {
											ItemStack _stktoremove = new ItemStack(PalamodModItems.ENDIUM_POLLEN.get());
											_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
										}
										if (world instanceof ServerLevel _level) {
											ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()));
											entityToSpawn.setPickUpDelay(10);
											_level.addFreshEntity(entityToSpawn);
										}
									} else {
										if (entity instanceof Player _player) {
											ItemStack _setstack = new ItemStack(PalamodModItems.ENDIUM_POLLEN.get()).copy();
											_setstack.setCount(1);
											ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
										}
										MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.portal.need_pollen").getString());
										break;
									}
								} else {
									MsgtellrawautosendProcedure.execute(world, x, y, z, Component.translatable("palamod.portal.need_pollen").getString());
									break;
								}
							} else {
								PalamodMod.LOGGER.error("The given type is not valid, existing portal procedure");
								break;
							}
						}
					}
				} else {
					MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
				}
			}
		}
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
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
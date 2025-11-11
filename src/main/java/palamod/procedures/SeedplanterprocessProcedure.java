package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

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
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.minecraft.carrot").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 2) {
				{
					final String _tagName = "mode";
					final double _tagValue = 3;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.minecraft.potato").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 3) {
				{
					final String _tagName = "mode";
					final double _tagValue = 4;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("block.minecraft.melon").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 4) {
				{
					final String _tagName = "mode";
					final double _tagValue = 5;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("block.minecraft.pumpkin").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 5) {
				{
					final String _tagName = "mode";
					final double _tagValue = 6;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.palamod.eggplant_seed").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 6) {
				{
					final String _tagName = "mode";
					final double _tagValue = 7;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.palamod.chervilseed").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 7) {
				{
					final String _tagName = "mode";
					final double _tagValue = 8;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.palamod.kiwanoseed").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 8) {
				{
					final String _tagName = "mode";
					final double _tagValue = 9;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.palamod.orangeblueseed").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 9) {
				{
					final String _tagName = "mode";
					final double _tagValue = 10;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							("tellraw @p [\"\",{\"text\":\"" + "" + Component.translatable("palamod.procedure.select_seed").getString() + " : \",\"color\":\"yellow\"},{\"text\":\"" + Component.translatable("item.minecraft.beetroot").getString()
									+ "\",\"color\":\"dark_green\"},{\"text\":\"\\n \"}]"));
			} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 10) {
				{
					final String _tagName = "mode";
					final double _tagValue = 1;
					CustomData.update(DataComponents.CUSTOM_DATA, itemstack, tag -> tag.putDouble(_tagName, _tagValue));
				}
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
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
			int horizontalRadiusSphere = (int) turn - 1;
			int verticalRadiusSphere = (int) 2 - 1;
			int yIterationsSphere = verticalRadiusSphere;
			for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
				for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
					for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
						double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
								+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
						if (distanceSq <= 1.0) {
							if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(ResourceLocation.parse("forge:farmland")))
									&& (world.getBlockState(BlockPos.containing(x + xi, y + i + 1, z + zi))).getBlock() == Blocks.AIR) {
								if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 1
										&& (hasEntityInInventory(entity, new ItemStack(Items.WHEAT_SEEDS)) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = Blocks.WHEAT.defaultBlockState();
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
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.WHEAT_SEEDS);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 2
										&& (hasEntityInInventory(entity, new ItemStack(Items.CARROT)) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.CARROT);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = Blocks.CARROTS.defaultBlockState();
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
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 3
										&& (hasEntityInInventory(entity, new ItemStack(Items.POTATO)) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = Blocks.POTATOES.defaultBlockState();
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
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.POTATO);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 4
										&& (hasEntityInInventory(entity, new ItemStack(Items.MELON_SEEDS)) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = Blocks.MELON_STEM.defaultBlockState();
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
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.MELON_SEEDS);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 5
										&& (hasEntityInInventory(entity, new ItemStack(Items.PUMPKIN_SEEDS)) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.PUMPKIN_SEEDS);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = Blocks.PUMPKIN_STEM.defaultBlockState();
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
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 6
										&& (hasEntityInInventory(entity, new ItemStack(PalamodModItems.EGGPLANT_SEED.get())) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(PalamodModItems.EGGPLANT_SEED.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = PalamodModBlocks.EGGPLANT_0.get().defaultBlockState();
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
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 7
										&& (hasEntityInInventory(entity, new ItemStack(PalamodModItems.CHERVILSEED.get())) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = PalamodModBlocks.CHERVIL_0.get().defaultBlockState();
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
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(PalamodModItems.CHERVILSEED.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 8
										&& (hasEntityInInventory(entity, new ItemStack(PalamodModItems.KIWANOSEED.get())) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(PalamodModItems.KIWANOSEED.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = PalamodModBlocks.KIWANO_0.get().defaultBlockState();
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
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 9
										&& (hasEntityInInventory(entity, new ItemStack(PalamodModItems.ORANGEBLUESEED.get())) || getEntityGameType(entity) == GameType.CREATIVE)) {
									act = true;
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = PalamodModBlocks.ORANGEBLUE_0.get().defaultBlockState();
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
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(PalamodModItems.ORANGEBLUESEED.get());
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
								} else if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDoubleOr("mode", 0) == 10
										&& (hasEntityInInventory(entity, new ItemStack(Items.BEETROOT_SEEDS)) || getEntityGameType(entity) == GameType.CREATIVE)) {
									if (entity instanceof Player _player) {
										ItemStack _stktoremove = new ItemStack(Items.BEETROOT_SEEDS);
										_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
									}
									{
										BlockPos _bp = BlockPos.containing(x + xi, y + i + 1, z + zi);
										BlockState _bs = Blocks.BEETROOTS.defaultBlockState();
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
								}
							}
						}
					}
				}
			}
			if (act) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.crop.plant")), SoundSource.BLOCKS, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("item.crop.plant")), SoundSource.BLOCKS, 1, 1, false);
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

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
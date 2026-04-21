package palamod.procedures;

import palamod.init.PalamodModGameRules;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
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
		ItemStack output = ItemStack.EMPTY;
		double y_core = 0;
		double x_core = 0;
		double z_core = 0;
		double nb_items = 0;
		double random = 0;
		boolean pass = false;
		boolean res = false;
		if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
			PalamodMod.LOGGER.info("drop");
			PalamodMod.LOGGER.info(("drop        :" + itemstack));
		}
		if ((entity instanceof ServerPlayer || entity instanceof Player) && itemstack.is(ItemTags.create(ResourceLocation.parse("palamod:cauldron_craft")))) {
			int horizontalRadiusHemiBot = (int) 3 - 1;
			int verticalRadiusHemiBot = (int) 3;
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
							if (PalamodModBlocks.CAULDRON_CORE.get() == (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock()) {
								x_core = x + xi;
								y_core = y + i;
								z_core = z + zi;
								pass = getBlockNBTLogic(world, BlockPos.containing(x + xi, y + i, z_core), "cauldron_open");
								if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
									PalamodMod.LOGGER.info(("Core :  x : " + x_core + " y : " + y_core + " z : " + z_core));
								}
							}
						}
					}
				}
			}
			if (pass) {
				if (world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.PALAMODDEBUGLOG)) {
					PalamodMod.LOGGER.info("core found");
					PalamodMod.LOGGER.info(("core found" + itemstack + "\n" + "setup : " + getBlockNBTLogic(world, BlockPos.containing(x_core, y_core, z_core), "cauldron_open") + "\n"
							+ itemstack.is(ItemTags.create(ResourceLocation.parse("palamod:modded_flowers"))) + itemstack.is(ItemTags.create(ResourceLocation.parse("palamod:vanilla_flowers")))));
				}
				nb_items = itemstack.getCount();
				if (itemstack.is(ItemTags.create(ResourceLocation.parse("palamod:modded_flowers")))) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"kill @e[type=minecraft:item,distance=..5]");
					res = true;
				} else if (itemstack.is(ItemTags.create(ResourceLocation.parse("palamod:vanilla_flowers")))) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"kill @e[type=minecraft:item,distance=..5]");
					res = true;
				} else if (Blocks.GLOWSTONE.asItem() == itemstack.getItem()) {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"kill @e[type=minecraft:item,distance=..5]");
					res = true;
				}
			}
		}
		PalamodMod.queueServerWork(3, () -> {
			if (world instanceof ServerLevel _level)
				_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
						"kill @e[type=minecraft:item,distance=..5]");
			PalamodMod.queueServerWork(1, () -> {
				CauldroncraftresultProcedure.execute(world, x, y, z, itemstack);
			});
		});
	}

	private static boolean getBlockNBTLogic(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getBoolean(tag);
		return false;
	}
}
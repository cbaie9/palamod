package palamod.procedures;

import palamod.init.PalamodModBlocks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import java.util.Random;

public class RtpcommandProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double xrandom = 0;
		double zrandom = 0;
		double yrandom = 0;
		if ((entity.level().dimension()) == Level.OVERWORLD) {
			if ((world.getBlockState(new BlockPos(0, 10, 0))).getBlock() == PalamodModBlocks.NBT_BLOCK.get()) {
				if (!(3 <= new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(0, 10, 0), ("use_trp_overworld_" + entity.getStringUUID())))) {
					while (!(1 < xrandom && 1000000 >= xrandom && 1 < zrandom && 1000000 >= xrandom)) {
						xrandom = Math.abs(new Random().nextGaussian());
						zrandom = Math.abs(new Random().nextGaussian());
					}
					if (!world.isClientSide()) {
						BlockPos _bp = new BlockPos(0, 10, 0);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getPersistentData().putDouble(("use_trp_overworld_" + entity.getStringUUID()), (new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, new BlockPos(0, 10, 0), ("use_trp_overworld_" + entity.getStringUUID())) + 1));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					if (world.getBiome(BlockPos.containing(xrandom, y, zrandom)).is(TagKey.create(Registries.BIOME, new ResourceLocation("minecraft:ocean")))) {
						yrandom = world.getHeight(Heightmap.Types.OCEAN_FLOOR, (int) xrandom, (int) zrandom);
					} else {
						yrandom = world.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) xrandom, (int) zrandom);
					}
					{
						Entity _ent = entity;
						_ent.teleportTo(xrandom, yrandom, zrandom);
						if (_ent instanceof ServerPlayer _serverPlayer)
							_serverPlayer.connection.teleport(xrandom, yrandom, zrandom, _ent.getYRot(), _ent.getXRot());
					}
				} else {
					if (world instanceof ServerLevel _level)
						_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
								"tellraw @p [\"\",{\"text\":\"[ palamod ]\",\"color\":\"dark_red\"},{\"text\":\" You already used 3/3 use of /rtp on this world Get a \",\"color\":\"gold\"},{\"text\":\"legendary stone of teleportation\",\"color\":\"gold\",\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"Can be obtainable via lucky block\"}},{\"text\":\" to get unlimited\",\"color\":\"gold\"}]");
				}
			} else {
				if (world instanceof ServerLevel _level)
					_level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, _level, 4, "", Component.literal(""), _level.getServer(), null).withSuppressedOutput(),
							"tellraw @p [\"\",{\"text\":\"[ palamod ]\",\"color\":\"dark_red\"},{\"text\":\" A required service from \",\"color\":\"gold\"},{\"text\":\"/$setup\",\"color\":\"gold\",\"clickEvent\":{\"action\":\"suggest_command\",\"value\":\"/$setup\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"Execute /$setup\"}},{\"text\":\" is not installed Contact your administrator to excute this command to \\\"unlock\\\" that feature\",\"color\":\"gold\"}]");
			}
		}
	}
}

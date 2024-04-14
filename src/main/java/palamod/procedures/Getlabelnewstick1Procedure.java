package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

public class Getlabelnewstick1Procedure {
	public static String execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return "";
		if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("mode_stick_" + entity.getStringUUID())) == 1) {
			return "Speed Stick : Give a speed III effect during 10 seconds";
		} else if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("mode_stick_" + entity.getStringUUID())) == 2) {
			return "Jump Stick : Give a jump III effect during 10 seconds";
		} else if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("mode_stick_" + entity.getStringUUID())) == 3) {
			return "Hyper jump Stick : Give a jump VI effect during 10 seconds";
		} else if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("mode_stick_" + entity.getStringUUID())) == 4) {
			return "Heal Stick : Give a instant heath 2 during 1 second";
		} else if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("mode_stick_" + entity.getStringUUID())) == 5) {
			return "Damage stick : Shot 25 arrow where you look";
		} else if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("mode_stick_" + entity.getStringUUID())) == 6) {
			return "Strenght stick : Give a strenght III effect for 40 seconds";
		} else if (new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(0, 10, 0), ("mode_stick_" + entity.getStringUUID())) == 7) {
			return "Stick of gods : Give speed V for 3 secondes, strenght, saturation and regenation";
		}
		return "[ Error 7 ] : The value of description is out of bound";
	}
}

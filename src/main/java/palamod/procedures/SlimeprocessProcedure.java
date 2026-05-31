package palamod.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class SlimeprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.UP) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (1 + entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
		} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.DOWN) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() - 1), (entity.getDeltaMovement().z())));
		} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.NORTH) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() - 1)));
		} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.SOUTH) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z() + 1)));
		} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.WEST) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() - 1), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
		} else if ((getDirectionFromBlockState((world.getBlockState(BlockPos.containing(x, y, z))))) == Direction.EAST) {
			entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x() + 1), (entity.getDeltaMovement().y()), (entity.getDeltaMovement().z())));
		}
	}

	private static Direction getDirectionFromBlockState(BlockState blockState) {
		if (getPropertyByName(blockState, "facing") instanceof EnumProperty ep && ep.getValueClass() == Direction.class)
			return (Direction) blockState.getValue(ep);
		if (getPropertyByName(blockState, "axis") instanceof EnumProperty ep && ep.getValueClass() == Direction.Axis.class)
			return Direction.fromAxisAndDirection((Direction.Axis) blockState.getValue(ep), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}

	private static Property<?> getPropertyByName(BlockState state, String name) {
		for (Property<?> property : state.getProperties()) {
			if (property.getName().equals(name)) {
				return property;
			}
		}
		return null;
	}
}
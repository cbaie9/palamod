package palamod.block;

import palamod.world.teleporter.MinerdimensionTeleporter;
import palamod.world.teleporter.MinerdimensionPortalShape;

import org.slf4j.Logger;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.portal.TeleportTransition;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.border.WorldBorder;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Portal;
import net.minecraft.world.level.block.NetherPortalBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Relative;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.BlockUtil;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

import java.util.Optional;

import com.mojang.logging.LogUtils;

public class MinerdimensionPortalBlock extends NetherPortalBlock {
	private static final Logger LOGGER = LogUtils.getLogger();

	public static void portalSpawn(Level world, BlockPos pos) {
		Optional<MinerdimensionPortalShape> optional = MinerdimensionPortalShape.findEmptyPortalShape(world, pos, Direction.Axis.X);
		if (optional.isPresent()) {
			optional.get().createPortalBlocks(world);
		}
	}

	public MinerdimensionPortalBlock(BlockBehaviour.Properties properties) {
		super(properties.noCollision().randomTicks().pushReaction(PushReaction.BLOCK).strength(-1.0F).sound(SoundType.GLASS).lightLevel(s -> 7).noLootTable());
	}

	private MinerdimensionTeleporter getTeleporter(ServerLevel level) {
		return new MinerdimensionTeleporter(level);
	}

	@Override
	protected BlockState updateShape(BlockState state, LevelReader level, ScheduledTickAccess ticks, BlockPos pos, Direction directionToNeighbour, BlockPos neighbourPos, BlockState neighbourState, RandomSource random) {
		Direction.Axis updateAxis = directionToNeighbour.getAxis();
		Direction.Axis axis = state.getValue(AXIS);
		boolean wrongAxis = axis != updateAxis && updateAxis.isHorizontal();
		return !wrongAxis && !neighbourState.is(this) && !MinerdimensionPortalShape.findAnyShape(level, pos, axis).isComplete()
				? Blocks.AIR.defaultBlockState()
				: super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
	}

	@Override
	@Nullable
	public TeleportTransition getPortalDestination(ServerLevel currentLevel, Entity entity, BlockPos portalEntryPos) {
		ResourceKey<Level> newDimension = currentLevel.dimension() == ResourceKey.create(Registries.DIMENSION, Identifier.parse("palamod:minerdimension"))
				? Level.OVERWORLD
				: ResourceKey.create(Registries.DIMENSION, Identifier.parse("palamod:minerdimension"));
		ServerLevel newLevel = currentLevel.getServer().getLevel(newDimension);
		if (newLevel == null) {
			return null;
		} else {
			boolean toNether = newLevel.dimension() == ResourceKey.create(Registries.DIMENSION, Identifier.parse("palamod:minerdimension"));
			WorldBorder newWorldBorder = newLevel.getWorldBorder();
			double teleportationScale = DimensionType.getTeleportationScale(currentLevel.dimensionType(), newLevel.dimensionType());
			BlockPos approximateExitPos = newWorldBorder.clampToBounds(entity.getX() * teleportationScale, entity.getY(), entity.getZ() * teleportationScale);
			return this.getExitPortal(newLevel, entity, portalEntryPos, approximateExitPos, toNether, newWorldBorder);
		}
	}

	@Nullable
	private TeleportTransition getExitPortal(ServerLevel newLevel, Entity entity, BlockPos portalEntryPos, BlockPos approximateExitPos, boolean toNether, WorldBorder worldBorder) {
		Optional<BlockPos> exitPortalPos = getTeleporter(newLevel).findClosestPortalPosition(approximateExitPos, toNether, worldBorder);
		BlockUtil.FoundRectangle exitPortal;
		TeleportTransition.PostTeleportTransition post;
		if (exitPortalPos.isPresent()) {
			BlockPos pos = exitPortalPos.get();
			BlockState portalState = newLevel.getBlockState(pos);
			exitPortal = BlockUtil.getLargestRectangleAround(pos, portalState.getValue(BlockStateProperties.HORIZONTAL_AXIS), 21, Direction.Axis.Y, 21, blockPos -> newLevel.getBlockState(blockPos) == portalState);
			post = TeleportTransition.PLAY_PORTAL_SOUND.then(e -> e.placePortalTicket(pos));
		} else {
			Direction.Axis sourcePortalAxis = entity.level().getBlockState(portalEntryPos).getOptionalValue(AXIS).orElse(Direction.Axis.X);
			Optional<BlockUtil.FoundRectangle> createdExit = getTeleporter(newLevel).createPortal(approximateExitPos, sourcePortalAxis);
			if (createdExit.isEmpty()) {
				LOGGER.error("Unable to create a portal, likely target out of worldborder");
				return null;
			}
			exitPortal = createdExit.get();
			post = TeleportTransition.PLAY_PORTAL_SOUND.then(TeleportTransition.PLACE_PORTAL_TICKET);
		}
		return getDimensionTransitionFromExit(entity, portalEntryPos, exitPortal, newLevel, post);
	}

	private static TeleportTransition getDimensionTransitionFromExit(Entity entity, BlockPos portalEntryPos, BlockUtil.FoundRectangle exitPortal, ServerLevel newLevel, TeleportTransition.PostTeleportTransition postTeleportTransition) {
		BlockState blockState = entity.level().getBlockState(portalEntryPos);
		Direction.Axis axis;
		Vec3 offset;
		if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS)) {
			axis = blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS);
			BlockUtil.FoundRectangle portalArea = BlockUtil.getLargestRectangleAround(portalEntryPos, axis, 21, Direction.Axis.Y, 21, pos -> entity.level().getBlockState(pos) == blockState);
			offset = entity.getRelativePortalPosition(axis, portalArea);
		} else {
			axis = Direction.Axis.X;
			offset = new Vec3(0.5, 0.0, 0.0);
		}
		return createDimensionTransition(newLevel, exitPortal, axis, offset, entity, postTeleportTransition);
	}

	private static TeleportTransition createDimensionTransition(ServerLevel newLevel, BlockUtil.FoundRectangle foundRectangle, Direction.Axis portalAxis, Vec3 offset, Entity entity, TeleportTransition.PostTeleportTransition postTeleportTransition) {
		BlockPos bottomLeft = foundRectangle.minCorner;
		BlockState blockState = newLevel.getBlockState(bottomLeft);
		Direction.Axis axis = blockState.getOptionalValue(BlockStateProperties.HORIZONTAL_AXIS).orElse(Direction.Axis.X);
		double width = foundRectangle.axis1Size;
		double height = foundRectangle.axis2Size;
		EntityDimensions dimensions = entity.getDimensions(entity.getPose());
		int outputRotation = portalAxis == axis ? 0 : 90;
		double offsetRight = dimensions.width() / 2.0 + (width - dimensions.width()) * offset.x();
		double offsetUp = (height - dimensions.height()) * offset.y();
		double offsetForward = 0.5 + offset.z();
		boolean xAligned = axis == Direction.Axis.X;
		Vec3 targetPos = new Vec3(bottomLeft.getX() + (xAligned ? offsetRight : offsetForward), bottomLeft.getY() + offsetUp, bottomLeft.getZ() + (xAligned ? offsetForward : offsetRight));
		Vec3 collisionFreePos = MinerdimensionPortalShape.findCollisionFreePosition(targetPos, newLevel, entity, dimensions);
		return new TeleportTransition(newLevel, collisionFreePos, Vec3.ZERO, outputRotation, 0.0F, Relative.union(Relative.DELTA, Relative.ROTATION), postTeleportTransition);
	}

	@Override
	public int getPortalTransitionTime(ServerLevel world, Entity entity) {
		return 0;
	}

	@Override
	public Portal.Transition getLocalTransition() {
		return Portal.Transition.NONE;
	}

	@Override
	public void randomTick(BlockState blockstate, ServerLevel world, BlockPos pos, RandomSource random) {
	}

	@Override
	public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
		for (int i = 0; i < 4; i++) {
			double px = pos.getX() + random.nextFloat();
			double py = pos.getY() + random.nextFloat();
			double pz = pos.getZ() + random.nextFloat();
			double vx = (random.nextFloat() - 0.5) / 2.;
			double vy = (random.nextFloat() - 0.5) / 2.;
			double vz = (random.nextFloat() - 0.5) / 2.;
			int j = random.nextInt(4) - 1;
			if (world.getBlockState(pos.west()).getBlock() != this && world.getBlockState(pos.east()).getBlock() != this) {
				px = pos.getX() + 0.5 + 0.25 * j;
				vx = random.nextFloat() * 2 * j;
			} else {
				pz = pos.getZ() + 0.5 + 0.25 * j;
				vz = random.nextFloat() * 2 * j;
			}
			world.addParticle(ParticleTypes.PORTAL, px, py, pz, vx, vy, vz);
		}
		if (random.nextInt(110) == 0)
			world.playLocalSound(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, BuiltInRegistries.SOUND_EVENT.getValue(Identifier.parse("block.portal.ambient")), SoundSource.BLOCKS, 0.5f, random.nextFloat() * 0.4f + 0.8f, false);
	}
}
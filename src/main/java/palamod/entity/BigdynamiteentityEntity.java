
package palamod.entity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.nbt.Tag;
import net.minecraft.network.syncher.EntityDataAccessor;

public class BigdynamiteentityEntity extends Creeper {

	public BigdynamiteentityEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(PalamodModEntities.BIGDYNAMITEENTITY.get(), world);
	}

	public BigdynamiteentityEntity(EntityType<BigdynamiteentityEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 0;
		setNoAi(true);

		setPersistenceRequired();

		this.setPathfindingMalus(BlockPathTypes.WATER, 0);
		this.moveControl = new MoveControl(this) {
			@Override
			public void tick() {
				if (BigdynamiteentityEntity.this.isInWater())
					BigdynamiteentityEntity.this.setDeltaMovement(BigdynamiteentityEntity.this.getDeltaMovement().add(0, 0.005, 0));

				if (this.operation == MoveControl.Operation.MOVE_TO && !BigdynamiteentityEntity.this.getNavigation().isDone()) {
					double dx = this.wantedX - BigdynamiteentityEntity.this.getX();
					double dy = this.wantedY - BigdynamiteentityEntity.this.getY();
					double dz = this.wantedZ - BigdynamiteentityEntity.this.getZ();

					float f = (float) (Mth.atan2(dz, dx) * (double) (180 / Math.PI)) - 90;
					float f1 = (float) (this.speedModifier * BigdynamiteentityEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

					BigdynamiteentityEntity.this.setYRot(this.rotlerp(BigdynamiteentityEntity.this.getYRot(), f, 10));
					BigdynamiteentityEntity.this.yBodyRot = BigdynamiteentityEntity.this.getYRot();
					BigdynamiteentityEntity.this.yHeadRot = BigdynamiteentityEntity.this.getYRot();

					if (BigdynamiteentityEntity.this.isInWater()) {
						BigdynamiteentityEntity.this.setSpeed((float) BigdynamiteentityEntity.this.getAttribute(Attributes.MOVEMENT_SPEED).getValue());

						float f2 = -(float) (Mth.atan2(dy, (float) Math.sqrt(dx * dx + dz * dz)) * (180 / Math.PI));
						f2 = Mth.clamp(Mth.wrapDegrees(f2), -85, 85);
						BigdynamiteentityEntity.this.setXRot(this.rotlerp(BigdynamiteentityEntity.this.getXRot(), f2, 5));
						float f3 = Mth.cos(BigdynamiteentityEntity.this.getXRot() * (float) (Math.PI / 180.0));

						BigdynamiteentityEntity.this.setZza(f3 * f1);
						BigdynamiteentityEntity.this.setYya((float) (f1 * dy));
					} else {
						BigdynamiteentityEntity.this.setSpeed(f1 * 0.05F);
					}
				} else {
					BigdynamiteentityEntity.this.setSpeed(0);
					BigdynamiteentityEntity.this.setYya(0);
					BigdynamiteentityEntity.this.setZza(0);
				}
			}
		};

	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected PathNavigation createNavigation(Level world) {
		return new WaterBoundPathNavigation(this, world);
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.getDirectEntity() instanceof Player)
			return false;
		if (damagesource.getDirectEntity() instanceof ThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud)
			return false;
		if (damagesource.is(DamageTypes.FALL))
			return false;
		if (damagesource.is(DamageTypes.CACTUS))
			return false;
		if (damagesource.is(DamageTypes.DROWN))
			return false;
		if (damagesource.is(DamageTypes.LIGHTNING_BOLT))
			return false;
		if (damagesource.is(DamageTypes.EXPLOSION) || damagesource.is(DamageTypes.PLAYER_EXPLOSION))
			return false;
		if (damagesource.is(DamageTypes.TRIDENT))
			return false;
		if (damagesource.is(DamageTypes.FALLING_ANVIL))
			return false;
		if (damagesource.is(DamageTypes.DRAGON_BREATH))
			return false;
		if (damagesource.is(DamageTypes.WITHER) || damagesource.is(DamageTypes.WITHER_SKULL))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean ignoreExplosion() {
		return true;
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, @Nullable SpawnGroupData livingdata, @Nullable CompoundTag tag) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata, tag);
		BigdynaboomProcedure.execute(world, this);
		return retval;
	}

	@Override
	public boolean checkSpawnObstruction(LevelReader world) {
		return world.isUnobstructed(this);
	}

	@Override
	public boolean canBreatheUnderwater() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return true;
	}

	public static void init() {

	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);

		builder = builder.add(ForgeMod.SWIM_SPEED.get(), 0.3);

		return builder;
	}

}

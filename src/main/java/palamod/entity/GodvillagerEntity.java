package palamod.entity;

import palamod.world.inventory.GodvillagerguiMenu;

import palamod.init.PalamodModEntities;

import net.neoforged.neoforge.items.wrapper.EntityHandsInvWrapper;
import net.neoforged.neoforge.items.wrapper.EntityArmorInvWrapper;
import net.neoforged.neoforge.items.wrapper.CombinedInvWrapper;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.common.NeoForgeMod;

import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.projectile.AbstractThrownPotion;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.*;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;

import io.netty.buffer.Unpooled;

public class GodvillagerEntity extends Villager {
	public static final EntityDataAccessor<Boolean> DATA_trade_used = SynchedEntityData.defineId(GodvillagerEntity.class, EntityDataSerializers.BOOLEAN);

	public GodvillagerEntity(EntityType<GodvillagerEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setCustomName(Component.literal("God Villager"));
		setCustomNameVisible(true);
		setPersistenceRequired();
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_trade_used, false);
	}

	@Override
	protected Component getTypeName() {
		return this.getType().getDescription();
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(3, new FloatGoal(this));
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, (float) 6));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, ServerPlayer.class, (float) 6));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractArrow)
			return false;
		if (damagesource.getDirectEntity() instanceof Player)
			return false;
		if (damagesource.getDirectEntity() instanceof AbstractThrownPotion || damagesource.getDirectEntity() instanceof AreaEffectCloud || damagesource.typeHolder().is(NeoForgeMod.POISON_DAMAGE))
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
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public boolean ignoreExplosion(Explosion explosion) {
		return true;
	}

	private final ItemStackHandler inventory = new ItemStackHandler(4) {
		@Override
		public int getSlotLimit(int slot) {
			return 64;
		}
	};
	private final CombinedInvWrapper combined = new CombinedInvWrapper(inventory, new EntityHandsInvWrapper(this), new EntityArmorInvWrapper(this));

	public CombinedInvWrapper getCombinedInventory() {
		return combined;
	}

	@Override
	protected void dropEquipment(ServerLevel serverLevel) {
		super.dropEquipment(serverLevel);
		for (int i = 0; i < inventory.getSlots(); ++i) {
			ItemStack itemstack = inventory.getStackInSlot(i);
			if (!itemstack.isEmpty() && !EnchantmentHelper.has(itemstack, EnchantmentEffectComponents.PREVENT_EQUIPMENT_DROP)) {
				this.spawnAtLocation(serverLevel, itemstack);
			}
		}
	}

	@Override
	public void addAdditionalSaveData(ValueOutput valueOutput) {
		super.addAdditionalSaveData(valueOutput);
		valueOutput.putBoolean("Datatrade_used", this.entityData.get(DATA_trade_used));
		inventory.serialize(valueOutput.child("InventoryCustom"));
	}

	@Override
	public void readAdditionalSaveData(ValueInput valueInput) {
		super.readAdditionalSaveData(valueInput);
		this.entityData.set(DATA_trade_used, valueInput.getBooleanOr("Datatrade_used", false));
		valueInput.child("InventoryCustom").ifPresent(input -> inventory.deserialize(input));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.SUCCESS;
		if (sourceentity instanceof ServerPlayer serverPlayer) {
			serverPlayer.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("God villager");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
					packetBuffer.writeBlockPos(sourceentity.blockPosition());
					packetBuffer.writeByte(0);
					packetBuffer.writeVarInt(GodvillagerEntity.this.getId());
					return new GodvillagerguiMenu(id, inventory, packetBuffer);
				}
			}, buf -> {
				buf.writeBlockPos(sourceentity.blockPosition());
				buf.writeByte(0);
				buf.writeVarInt(this.getId());
			});
		}
		super.mobInteract(sourceentity, hand);
		return retval;
	}

	@Override
	public Villager getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		GodvillagerEntity retval = PalamodModEntities.GODVILLAGER.get().create(serverWorld, EntitySpawnReason.BREEDING);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, null);
		return retval;
	}

	@Override
	public boolean canDrownInFluidType(FluidType type) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	@Override
	public boolean isPushedByFluid() {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		return false;
	}

	@Override
	public boolean isPushable() {
		return false;
	}

	@Override
	protected void doPush(Entity entityIn) {
	}

	@Override
	protected void pushEntities() {
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}
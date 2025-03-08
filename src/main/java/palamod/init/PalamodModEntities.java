
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.entity.SwitcharrowEntity;
import palamod.entity.PrimedwithertntEntity;
import palamod.entity.PrimedspongetntEntity;
import palamod.entity.PrimedmagictntEntity;
import palamod.entity.PrimedendiumtntEntity;
import palamod.entity.PrimedbigtntEntity;
import palamod.entity.PaladiumgolemEntity;
import palamod.entity.PaladiumdynamiteEntity;
import palamod.entity.GodvillagerEntity;
import palamod.entity.EndiumdynamiteEntity;
import palamod.entity.BigdynamiteentityEntity;

import palamod.PalamodMod;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.registries.Registries;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PalamodModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, PalamodMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<PaladiumdynamiteEntity>> PALADIUMDYNAMITE = register("paladiumdynamite",
			EntityType.Builder.<PaladiumdynamiteEntity>of(PaladiumdynamiteEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<EndiumdynamiteEntity>> ENDIUMDYNAMITE = register("endiumdynamite",
			EntityType.Builder.<EndiumdynamiteEntity>of(EndiumdynamiteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BigdynamiteentityEntity>> BIGDYNAMITEENTITY = register("bigdynamiteentity",
			EntityType.Builder.<BigdynamiteentityEntity>of(BigdynamiteentityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PaladiumgolemEntity>> PALADIUMGOLEM = register("paladiumgolem",
			EntityType.Builder.<PaladiumgolemEntity>of(PaladiumgolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.sized(1.2f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrimedspongetntEntity>> PRIMEDSPONGETNT = register("primedspongetnt",
			EntityType.Builder.<PrimedspongetntEntity>of(PrimedspongetntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrimedwithertntEntity>> PRIMEDWITHERTNT = register("primedwithertnt",
			EntityType.Builder.<PrimedwithertntEntity>of(PrimedwithertntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrimedmagictntEntity>> PRIMEDMAGICTNT = register("primedmagictnt",
			EntityType.Builder.<PrimedmagictntEntity>of(PrimedmagictntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrimedbigtntEntity>> PRIMEDBIGTNT = register("primedbigtnt",
			EntityType.Builder.<PrimedbigtntEntity>of(PrimedbigtntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<PrimedendiumtntEntity>> PRIMEDENDIUMTNT = register("primedendiumtnt",
			EntityType.Builder.<PrimedendiumtntEntity>of(PrimedendiumtntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(1f, 1f));
	public static final DeferredHolder<EntityType<?>, EntityType<SwitcharrowEntity>> SWITCHARROW = register("switcharrow",
			EntityType.Builder.<SwitcharrowEntity>of(SwitcharrowEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GodvillagerEntity>> GODVILLAGER = register("godvillager",
			EntityType.Builder.<GodvillagerEntity>of(GodvillagerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6f, 1.95f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public static void registerCapabilities(RegisterCapabilitiesEvent event) {
		event.registerEntity(Capabilities.ItemHandler.ENTITY, PALADIUMGOLEM.get(), (living, context) -> living.getCombinedInventory());
		event.registerEntity(Capabilities.ItemHandler.ENTITY, GODVILLAGER.get(), (living, context) -> living.getCombinedInventory());
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		PaladiumdynamiteEntity.init(event);
		EndiumdynamiteEntity.init(event);
		BigdynamiteentityEntity.init(event);
		PaladiumgolemEntity.init(event);
		PrimedspongetntEntity.init(event);
		PrimedwithertntEntity.init(event);
		PrimedmagictntEntity.init(event);
		PrimedbigtntEntity.init(event);
		PrimedendiumtntEntity.init(event);
		GodvillagerEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(PALADIUMDYNAMITE.get(), PaladiumdynamiteEntity.createAttributes().build());
		event.put(ENDIUMDYNAMITE.get(), EndiumdynamiteEntity.createAttributes().build());
		event.put(BIGDYNAMITEENTITY.get(), BigdynamiteentityEntity.createAttributes().build());
		event.put(PALADIUMGOLEM.get(), PaladiumgolemEntity.createAttributes().build());
		event.put(PRIMEDSPONGETNT.get(), PrimedspongetntEntity.createAttributes().build());
		event.put(PRIMEDWITHERTNT.get(), PrimedwithertntEntity.createAttributes().build());
		event.put(PRIMEDMAGICTNT.get(), PrimedmagictntEntity.createAttributes().build());
		event.put(PRIMEDBIGTNT.get(), PrimedbigtntEntity.createAttributes().build());
		event.put(PRIMEDENDIUMTNT.get(), PrimedendiumtntEntity.createAttributes().build());
		event.put(GODVILLAGER.get(), GodvillagerEntity.createAttributes().build());
	}
}

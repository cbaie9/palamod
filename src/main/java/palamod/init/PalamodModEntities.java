
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import palamod.entity.PrimedwithertntEntity;
import palamod.entity.PrimedspongetntEntity;
import palamod.entity.PrimedmagictntEntity;
import palamod.entity.PrimedendiumtntEntity;
import palamod.entity.PrimedbigtntEntity;
import palamod.entity.PaladiumgolemEntity;
import palamod.entity.PaladiumdynamiteEntity;
import palamod.entity.EndiumdynamiteEntity;
import palamod.entity.BigdynamiteentityEntity;

import palamod.PalamodMod;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PalamodModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, PalamodMod.MODID);
	public static final RegistryObject<EntityType<PaladiumgolemEntity>> PALADIUMGOLEM = register("paladiumgolem",
			EntityType.Builder.<PaladiumgolemEntity>of(PaladiumgolemEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PaladiumgolemEntity::new)

					.sized(1.2f, 1.8f));
	public static final RegistryObject<EntityType<PaladiumdynamiteEntity>> PALADIUMDYNAMITE = register("paladiumdynamite", EntityType.Builder.<PaladiumdynamiteEntity>of(PaladiumdynamiteEntity::new, MobCategory.MISC)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PaladiumdynamiteEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<EndiumdynamiteEntity>> ENDIUMDYNAMITE = register("endiumdynamite", EntityType.Builder.<EndiumdynamiteEntity>of(EndiumdynamiteEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(EndiumdynamiteEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<BigdynamiteentityEntity>> BIGDYNAMITEENTITY = register("bigdynamiteentity", EntityType.Builder.<BigdynamiteentityEntity>of(BigdynamiteentityEntity::new, MobCategory.MONSTER)
			.setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(BigdynamiteentityEntity::new).fireImmune().sized(0.6f, 1.8f));
	public static final RegistryObject<EntityType<PrimedspongetntEntity>> PRIMEDSPONGETNT = register("primedspongetnt", EntityType.Builder.<PrimedspongetntEntity>of(PrimedspongetntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrimedspongetntEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<PrimedwithertntEntity>> PRIMEDWITHERTNT = register("primedwithertnt", EntityType.Builder.<PrimedwithertntEntity>of(PrimedwithertntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrimedwithertntEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<PrimedmagictntEntity>> PRIMEDMAGICTNT = register("primedmagictnt", EntityType.Builder.<PrimedmagictntEntity>of(PrimedmagictntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrimedmagictntEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<PrimedbigtntEntity>> PRIMEDBIGTNT = register("primedbigtnt", EntityType.Builder.<PrimedbigtntEntity>of(PrimedbigtntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrimedbigtntEntity::new).fireImmune().sized(1f, 1f));
	public static final RegistryObject<EntityType<PrimedendiumtntEntity>> PRIMEDENDIUMTNT = register("primedendiumtnt", EntityType.Builder.<PrimedendiumtntEntity>of(PrimedendiumtntEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true)
			.setTrackingRange(64).setUpdateInterval(3).setCustomClientFactory(PrimedendiumtntEntity::new).fireImmune().sized(1f, 1f));

	private static <T extends Entity> RegistryObject<EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(registryname));
	}

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			PaladiumgolemEntity.init();
			PaladiumdynamiteEntity.init();
			EndiumdynamiteEntity.init();
			BigdynamiteentityEntity.init();
			PrimedspongetntEntity.init();
			PrimedwithertntEntity.init();
			PrimedmagictntEntity.init();
			PrimedbigtntEntity.init();
			PrimedendiumtntEntity.init();
		});
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(PALADIUMGOLEM.get(), PaladiumgolemEntity.createAttributes().build());
		event.put(PALADIUMDYNAMITE.get(), PaladiumdynamiteEntity.createAttributes().build());
		event.put(ENDIUMDYNAMITE.get(), EndiumdynamiteEntity.createAttributes().build());
		event.put(BIGDYNAMITEENTITY.get(), BigdynamiteentityEntity.createAttributes().build());
		event.put(PRIMEDSPONGETNT.get(), PrimedspongetntEntity.createAttributes().build());
		event.put(PRIMEDWITHERTNT.get(), PrimedwithertntEntity.createAttributes().build());
		event.put(PRIMEDMAGICTNT.get(), PrimedmagictntEntity.createAttributes().build());
		event.put(PRIMEDBIGTNT.get(), PrimedbigtntEntity.createAttributes().build());
		event.put(PRIMEDENDIUMTNT.get(), PrimedendiumtntEntity.createAttributes().build());
	}
}

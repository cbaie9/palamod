package palamod.world.features;

import palamod.world.features.configurations.StructureFeatureConfiguration;

import palamod.PalamodMod;

@Mod.EventBusSubscriber
public class StructureFeature extends Feature<StructureFeatureConfiguration> {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, PalamodMod.MODID);
	public static final RegistryObject<Feature<?>> STRUCTURE_FEATURE = REGISTRY.register("structure_feature", () -> new StructureFeature(StructureFeatureConfiguration.CODEC));

	public StructureFeature(Codec<StructureFeatureConfiguration> codec) {
		super(codec);
	}

	public boolean place(FeaturePlaceContext<StructureFeatureConfiguration> context) {
		RandomSource random = context.random();
		WorldGenLevel worldGenLevel = context.level();
		StructureFeatureConfiguration config = context.config();
		Rotation rotation = config.randomRotation() ? Rotation.getRandom(random) : Rotation.NONE;
		Mirror mirror = config.randomMirror() ? Mirror.values()[random.nextInt(2)] : Mirror.NONE;
		BlockPos placePos = context.origin().offset(config.offset());
		// Load the structure template
		StructureTemplateManager structureManager = worldGenLevel.getLevel().getServer().getStructureManager();
		StructureTemplate template = structureManager.getOrCreate(config.structure());
		StructurePlaceSettings placeSettings = (new StructurePlaceSettings()).setRotation(rotation).setMirror(mirror).setRandom(random).setIgnoreEntities(false)
				.addProcessor(new BlockIgnoreProcessor(config.ignoredBlocks().stream().map(Holder::get).toList()));
		template.placeInWorld(worldGenLevel, placePos, placePos, placeSettings, random, 4);
		return true;
	}
}

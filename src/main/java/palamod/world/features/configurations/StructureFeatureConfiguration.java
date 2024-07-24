package palamod.world.features.configurations;

public record StructureFeatureConfiguration(ResourceLocation structure, boolean randomRotation, boolean randomMirror, HolderSet<Block> ignoredBlocks, Vec3i offset) implements FeatureConfiguration {
	public static final Codec<StructureFeatureConfiguration> CODEC = RecordCodecBuilder.create(builder -> {
		return builder.group(ResourceLocation.CODEC.fieldOf("structure").forGetter(config -> {
			return config.structure;
		}), Codec.BOOL.fieldOf("random_rotation").orElse(false).forGetter(config -> {
			return config.randomRotation;
		}), Codec.BOOL.fieldOf("random_mirror").orElse(false).forGetter(config -> {
			return config.randomMirror;
		}), RegistryCodecs.homogeneousList(Registries.BLOCK).fieldOf("ignored_blocks").forGetter(config -> {
			return config.ignoredBlocks;
		}), Vec3i.offsetCodec(48).optionalFieldOf("offset", Vec3i.ZERO).forGetter(config -> {
			return config.offset;
		})).apply(builder, StructureFeatureConfiguration::new);
	});
}

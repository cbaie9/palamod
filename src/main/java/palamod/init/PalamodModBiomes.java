
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import java.util.List;
import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;

@Mod.EventBusSubscriber
public class PalamodModBiomes {
	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		MinecraftServer server = event.getServer();
		Registry<DimensionType> dimensionTypeRegistry = server.registryAccess().registryOrThrow(Registries.DIMENSION_TYPE);
		Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().registryOrThrow(Registries.LEVEL_STEM);
		Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registries.BIOME);
		for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
			DimensionType dimensionType = levelStem.type().value();
			if (dimensionType == dimensionTypeRegistry.getOrThrow(BuiltinDimensionTypes.OVERWORLD)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.45f, 0.196f), Climate.Parameter.span(0.1f, 0.3f), Climate.Parameter.span(-0.11f, 0.55f), Climate.Parameter.span(-0.5f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1.0780185268f, 0.5f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "forestender")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.45f, 0.196f), Climate.Parameter.span(0.1f, 0.3f), Climate.Parameter.span(-0.11f, 0.55f), Climate.Parameter.span(-0.5f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1.0780185268f, 0.5f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "forestender")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(0.31f, 0.71f), Climate.Parameter.span(0.6f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.4336056483f, 0.8336056483f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "roofedforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(0.31f, 0.71f), Climate.Parameter.span(0.6f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.4336056483f, 0.8336056483f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "roofedforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(0.31f, 0.71f), Climate.Parameter.span(0.6f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.2813142361f, 0.6813142361f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "frozenforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(0.31f, 0.71f), Climate.Parameter.span(0.6f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.2813142361f, 0.6813142361f), 0), biomeRegistry.getHolderOrThrow(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "frozenforest")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				// Inject surface rules
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					NoiseGeneratorSettings noiseGeneratorSettings = noiseGenerator.settings.value();
					SurfaceRules.RuleSource currentRuleSource = noiseGeneratorSettings.surfaceRule();
					if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
						List<SurfaceRules.RuleSource> surfaceRules = new ArrayList<>(sequenceRuleSource.sequence());
						addSurfaceRule(surfaceRules, 1,
								preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "forestender")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(), Blocks.GRAVEL.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "roofedforest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.GRAVEL.defaultBlockState()));
						addSurfaceRule(surfaceRules, 1, preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, new ResourceLocation("palamod", "frozenforest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
								Blocks.GRAVEL.defaultBlockState()));
						NoiseGeneratorSettings moddedNoiseGeneratorSettings = new NoiseGeneratorSettings(noiseGeneratorSettings.noiseSettings(), noiseGeneratorSettings.defaultBlock(), noiseGeneratorSettings.defaultFluid(),
								noiseGeneratorSettings.noiseRouter(), SurfaceRules.sequence(surfaceRules.toArray(SurfaceRules.RuleSource[]::new)), noiseGeneratorSettings.spawnTarget(), noiseGeneratorSettings.seaLevel(),
								noiseGeneratorSettings.disableMobGeneration(), noiseGeneratorSettings.aquifersEnabled(), noiseGeneratorSettings.oreVeinsEnabled(), noiseGeneratorSettings.useLegacyRandomSource());
						noiseGenerator.settings = new Holder.Direct<>(moddedNoiseGeneratorSettings);
					}
				}
			}
		}
	}

	private static SurfaceRules.RuleSource preliminarySurfaceRule(ResourceKey<Biome> biomeKey, BlockState groundBlock, BlockState undergroundBlock, BlockState underwaterBlock) {
		return SurfaceRules.ifTrue(SurfaceRules.isBiome(biomeKey),
				SurfaceRules.ifTrue(SurfaceRules.abovePreliminarySurface(),
						SurfaceRules.sequence(
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
										SurfaceRules.sequence(SurfaceRules.ifTrue(SurfaceRules.waterBlockCheck(-1, 0), SurfaceRules.state(groundBlock)), SurfaceRules.state(underwaterBlock))),
								SurfaceRules.ifTrue(SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR), SurfaceRules.state(undergroundBlock)))));
	}

	private static void addParameterPoint(List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters, Pair<Climate.ParameterPoint, Holder<Biome>> point) {
		if (!parameters.contains(point))
			parameters.add(point);
	}

	private static void addSurfaceRule(List<SurfaceRules.RuleSource> surfaceRules, int index, SurfaceRules.RuleSource rule) {
		if (!surfaceRules.contains(rule))
			surfaceRules.add(index, rule);
	}
}

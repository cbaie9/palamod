/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package palamod.init;

import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.FeatureSorter;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.server.MinecraftServer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.Registry;
import net.minecraft.core.Holder;

import java.util.List;
import java.util.ArrayList;

import com.mojang.datafixers.util.Pair;

import com.google.common.base.Suppliers;

@EventBusSubscriber
public class PalamodModBiomes {
	@SubscribeEvent
	public static void onServerAboutToStart(ServerAboutToStartEvent event) {
		MinecraftServer server = event.getServer();
		Registry<LevelStem> levelStemTypeRegistry = server.registryAccess().lookupOrThrow(Registries.LEVEL_STEM);
		Registry<Biome> biomeRegistry = server.registryAccess().lookupOrThrow(Registries.BIOME);
		for (LevelStem levelStem : levelStemTypeRegistry.stream().toList()) {
			Holder<DimensionType> dimensionType = levelStem.type();
			if (dimensionType.is(BuiltinDimensionTypes.OVERWORLD)) {
				ChunkGenerator chunkGenerator = levelStem.generator();
				// Inject biomes to biome source
				if (chunkGenerator.getBiomeSource() instanceof MultiNoiseBiomeSource noiseSource) {
					List<Pair<Climate.ParameterPoint, Holder<Biome>>> parameters = new ArrayList<>(noiseSource.parameters().values());
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.45f, 0.196f), Climate.Parameter.span(0.1f, 0.3f), Climate.Parameter.span(-0.11f, 0.55f), Climate.Parameter.span(-0.5f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(-1.0780185268f, 0.5f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "forestender")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.45f, 0.196f), Climate.Parameter.span(0.1f, 0.3f), Climate.Parameter.span(-0.11f, 0.55f), Climate.Parameter.span(-0.5f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(-1.0780185268f, 0.5f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "forestender")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(0.31f, 0.71f), Climate.Parameter.span(0.6f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.4336056483f, 0.8336056483f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "roofedforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(0.31f, 0.71f), Climate.Parameter.span(0.6f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.4336056483f, 0.8336056483f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "roofedforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(0.31f, 0.71f), Climate.Parameter.span(0.6f, 1f),
							Climate.Parameter.point(0.0f), Climate.Parameter.span(0.2813142361f, 0.6813142361f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "frozenforest")))));
					addParameterPoint(parameters, new Pair<>(new Climate.ParameterPoint(Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(-0.2f, 0.2f), Climate.Parameter.span(0.31f, 0.71f), Climate.Parameter.span(0.6f, 1f),
							Climate.Parameter.point(1.0f), Climate.Parameter.span(0.2813142361f, 0.6813142361f), 0), biomeRegistry.getOrThrow(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "frozenforest")))));
					chunkGenerator.biomeSource = MultiNoiseBiomeSource.createFromList(new Climate.ParameterList<>(parameters));
					chunkGenerator.featuresPerStep = Suppliers
							.memoize(() -> FeatureSorter.buildFeaturesPerStep(List.copyOf(chunkGenerator.biomeSource.possibleBiomes()), biome -> chunkGenerator.generationSettingsGetter.apply(biome).features(), true));
				}
				if (chunkGenerator instanceof NoiseBasedChunkGenerator noiseGenerator) {
					((PalamodModNoiseGeneratorSettings) (Object) noiseGenerator.settings.value()).setpalamodDimensionTypeReference(dimensionType);
				}
			}
		}
	}

	public static SurfaceRules.RuleSource adaptSurfaceRule(SurfaceRules.RuleSource currentRuleSource, Holder<DimensionType> dimensionType) {
		if (dimensionType.is(BuiltinDimensionTypes.OVERWORLD))
			return injectOverworldSurfaceRules(currentRuleSource);
		return currentRuleSource;
	}

	private static SurfaceRules.RuleSource injectOverworldSurfaceRules(SurfaceRules.RuleSource currentRuleSource) {
		List<SurfaceRules.RuleSource> customSurfaceRules = new ArrayList<>();
		customSurfaceRules.add(preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "forestender")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
				Blocks.GRAVEL.defaultBlockState()));
		customSurfaceRules.add(preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "roofedforest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
				Blocks.GRAVEL.defaultBlockState()));
		customSurfaceRules.add(preliminarySurfaceRule(ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath("palamod", "frozenforest")), Blocks.GRASS_BLOCK.defaultBlockState(), Blocks.DIRT.defaultBlockState(),
				Blocks.GRAVEL.defaultBlockState()));
		if (currentRuleSource instanceof SurfaceRules.SequenceRuleSource sequenceRuleSource) {
			customSurfaceRules.addAll(sequenceRuleSource.sequence());
			return SurfaceRules.sequence(customSurfaceRules.toArray(SurfaceRules.RuleSource[]::new));
		} else {
			customSurfaceRules.add(currentRuleSource);
			return SurfaceRules.sequence(customSurfaceRules.toArray(SurfaceRules.RuleSource[]::new));
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

	public interface PalamodModNoiseGeneratorSettings {
		void setpalamodDimensionTypeReference(Holder<DimensionType> dimensionType);
	}
}
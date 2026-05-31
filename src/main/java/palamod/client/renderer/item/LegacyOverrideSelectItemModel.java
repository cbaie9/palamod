package palamod.client.renderer.item;

import net.neoforged.neoforge.client.event.RegisterItemModelsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.resources.model.ResolvableModel;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperty;
import net.minecraft.client.renderer.item.properties.numeric.RangeSelectItemModelProperties;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperty;
import net.minecraft.client.renderer.item.properties.conditional.ConditionalItemModelProperties;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.item.ItemModels;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.item.ItemModel;
import net.minecraft.client.multiplayer.ClientLevel;

import javax.annotation.Nullable;

import java.util.List;

import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.Codec;
import com.mojang.datafixers.util.Either;

@EventBusSubscriber(Dist.CLIENT)
public class LegacyOverrideSelectItemModel implements ItemModel {
	private final ModelOverride[] overrides;
	private final ItemModel[] models;
	private final ItemModel fallback;

	private LegacyOverrideSelectItemModel(ModelOverride[] overrides, ItemModel[] models, ItemModel fallback) {
		this.overrides = overrides;
		this.models = models;
		this.fallback = fallback;
	}

	@Override
	public void update(ItemStackRenderState renderState, ItemStack itemStack, ItemModelResolver modelResolver, ItemDisplayContext displayContext, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed) {
		ItemModel model = fallback;
		for (int i = overrides.length - 1; i >= 0; i--) {
			if (overrides[i].test(itemStack, level, entity, seed, displayContext)) {
				model = models[i];
				break;
			}
		}
		model.update(renderState, itemStack, modelResolver, displayContext, level, entity, seed);
	}

	public record FloatEntry(RangeSelectItemModelProperty property, float value) implements PredicateEntry {
		public static final Codec<LegacyOverrideSelectItemModel.FloatEntry> CODEC = RecordCodecBuilder.create(instance -> instance
				.group(RangeSelectItemModelProperties.MAP_CODEC.fieldOf("property").forGetter(LegacyOverrideSelectItemModel.FloatEntry::property), Codec.FLOAT.fieldOf("value").forGetter(LegacyOverrideSelectItemModel.FloatEntry::value))
				.apply(instance, LegacyOverrideSelectItemModel.FloatEntry::new));

		@Override
		public boolean test(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, ItemDisplayContext displayContext) {
			return property.get(itemStack, level, entity, seed) >= value;
		}
	}

	public record BoolEntry(ConditionalItemModelProperty property, boolean value) implements PredicateEntry {
		public static final Codec<LegacyOverrideSelectItemModel.BoolEntry> CODEC = RecordCodecBuilder.create(instance -> instance
				.group(ConditionalItemModelProperties.MAP_CODEC.fieldOf("property").forGetter(LegacyOverrideSelectItemModel.BoolEntry::property), Codec.BOOL.fieldOf("value").forGetter(LegacyOverrideSelectItemModel.BoolEntry::value))
				.apply(instance, LegacyOverrideSelectItemModel.BoolEntry::new));

		@Override
		public boolean test(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, ItemDisplayContext displayContext) {
			return property.get(itemStack, level, entity, seed, displayContext) || !value;
		}
	}

	public interface PredicateEntry {
		Codec<LegacyOverrideSelectItemModel.PredicateEntry> CODEC = Codec.either(LegacyOverrideSelectItemModel.FloatEntry.CODEC, LegacyOverrideSelectItemModel.BoolEntry.CODEC).xmap(Either::unwrap, predicate -> {
			if (predicate instanceof LegacyOverrideSelectItemModel.FloatEntry floatPredicate)
				return Either.left(floatPredicate);
			else if (predicate instanceof LegacyOverrideSelectItemModel.BoolEntry boolPredicate)
				return Either.right(boolPredicate);
			throw new UnsupportedOperationException();
		});

		boolean test(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, ItemDisplayContext displayContext);
	}

	public record ModelOverride(List<PredicateEntry> predicate, ItemModel.Unbaked model) {
		public static final Codec<LegacyOverrideSelectItemModel.ModelOverride> CODEC = RecordCodecBuilder
				.create(instance -> instance.group(LegacyOverrideSelectItemModel.PredicateEntry.CODEC.listOf().fieldOf("predicate").forGetter(LegacyOverrideSelectItemModel.ModelOverride::predicate),
						ItemModels.CODEC.fieldOf("model").forGetter(LegacyOverrideSelectItemModel.ModelOverride::model)).apply(instance, LegacyOverrideSelectItemModel.ModelOverride::new));

		public boolean test(ItemStack itemStack, @Nullable ClientLevel level, @Nullable LivingEntity entity, int seed, ItemDisplayContext displayContext) {
			boolean flag = true;
			for (PredicateEntry entry : predicate)
				flag &= entry.test(itemStack, level, entity, seed, displayContext);
			return flag;
		}
	}

	public record Unbaked(List<LegacyOverrideSelectItemModel.ModelOverride> overrides, ItemModel.Unbaked fallback) implements ItemModel.Unbaked {
		public static final MapCodec<LegacyOverrideSelectItemModel.Unbaked> MAP_CODEC = RecordCodecBuilder
				.mapCodec(instance -> instance.group(LegacyOverrideSelectItemModel.ModelOverride.CODEC.listOf().fieldOf("overrides").forGetter(LegacyOverrideSelectItemModel.Unbaked::overrides),
						ItemModels.CODEC.fieldOf("fallback").forGetter(LegacyOverrideSelectItemModel.Unbaked::fallback)).apply(instance, LegacyOverrideSelectItemModel.Unbaked::new));

		@Override
		public MapCodec<LegacyOverrideSelectItemModel.Unbaked> type() {
			return MAP_CODEC;
		}

		@Override
		public ItemModel bake(ItemModel.BakingContext bakingContext) {
			ItemModel[] models = new ItemModel[overrides.size()];
			for (int i = 0; i < overrides.size(); i++)
				models[i] = overrides.get(i).model.bake(bakingContext);
			return new LegacyOverrideSelectItemModel(overrides.toArray(LegacyOverrideSelectItemModel.ModelOverride[]::new), models, fallback.bake(bakingContext));
		}

		@Override
		public void resolveDependencies(ResolvableModel.Resolver resolver) {
			fallback.resolveDependencies(resolver);
			overrides.forEach(override -> override.model.resolveDependencies(resolver));
		}
	}

	@SubscribeEvent
	public static void registerItemModelTypes(RegisterItemModelsEvent event) {
		event.register(ResourceLocation.parse("palamod:legacy_overrides"), LegacyOverrideSelectItemModel.Unbaked.MAP_CODEC);
	}
}
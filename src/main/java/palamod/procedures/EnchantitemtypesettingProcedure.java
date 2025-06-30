package palamod.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;

public class EnchantitemtypesettingProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z, ItemStack item_input) {
		ItemStack input_book = ItemStack.EMPTY;
		input_book = item_input.copy();
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smelt") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt"))),
					(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smelt"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "hammer_fortune") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:hammer_fortune"))),
					(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "hammer_fortune"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "speed") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:speed"))),
					(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "speed"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "big_hole") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:bighole"))),
					(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "big_hole"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "auto_smelt_potg") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:autosmeltpotg"))),
					(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "auto_smelt_potg"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "charged") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:chargedenchant"))),
					(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "charged"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "botteled") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:botteled"))),
					(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "botteled"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "one_more_upgrade") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:onemoreupgradeenchant"))),
					(int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "one_more_upgrade"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "aqua_affinity") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.AQUA_AFFINITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "aqua_affinity"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "bane_arthropods") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BANE_OF_ARTHROPODS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "bane_arthropods"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "binding_curse") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BINDING_CURSE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "binding_curse"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "breach") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BREACH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "breach"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blast_protection") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.BLAST_PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "blast_protection"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "channeling") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.CHANNELING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "channeling"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "density") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DENSITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "density"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "depth_strider") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.DEPTH_STRIDER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "depth_strider"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "efficiency") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.EFFICIENCY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "efficiency"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feather_falling") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FEATHER_FALLING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "feather_falling"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fire_aspect") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FIRE_ASPECT), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fire_aspect"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flame") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FLAME), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "flame"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fortune") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "fortune"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frost_walker") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FROST_WALKER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "frost_walker"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "impaling") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.IMPALING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "impaling"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "infinity") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.INFINITY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "infinity"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "knockback") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.KNOCKBACK), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "knockback"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "looting") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOOTING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "looting"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "loyaty") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LOYALTY), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "loyaty"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "luck_of_the_sea") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LUCK_OF_THE_SEA), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "luck_of_the_sea"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lure") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.LURE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "lure"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "mending") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MENDING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "mending"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "multishot") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.MULTISHOT), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "multishot"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "piercing") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PIERCING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "piercing"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "power") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.POWER), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "power"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "projectile_protection") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROJECTILE_PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "projectile_protection"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "protection") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PROTECTION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "protection"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "punch") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.PUNCH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "punch"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "quick_charge") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.QUICK_CHARGE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "quick_charge"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "respiration") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RESPIRATION), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "respiration"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "riptide") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.RIPTIDE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "riptide"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sharpness") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SHARPNESS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sharpness"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "silk_touch") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SILK_TOUCH), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "silk_touch"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smite") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SMITE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "smite"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul_speed") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SOUL_SPEED), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "soul_speed"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sweeping") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWEEPING_EDGE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "sweeping"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "swift_sneak") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.SWIFT_SNEAK), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "swift_sneak"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "thorns") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.THORNS), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "thorns"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "unbreaking") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.UNBREAKING), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "unbreaking"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "vanishing_curse") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.VANISHING_CURSE), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "vanishing_curse"));
		}
		if (getBlockNBTNumber(world, BlockPos.containing(x, y, z), "wind_burst") > 0) {
			input_book.enchant(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.WIND_BURST), (int) getBlockNBTNumber(world, BlockPos.containing(x, y, z), "wind_burst"));
		}
		return input_book;
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}

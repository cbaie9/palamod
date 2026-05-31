package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.common.extensions.ILevelExtension;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.Identifier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class PalamachineprocessgetrecipeProcedure {
	public static ItemStack execute(LevelAccessor world, double x, double y, double z) {
		ItemStack output = ItemStack.EMPTY;
		if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.HEAL_ORB.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.TITANE_BLOCK.get().asItem()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.HEAL_STICK.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.TITANE_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.HEAL_STICK.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.COMPRESSED_AMETHYST.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.SPEED_ORB.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.COMPRESSED_TITANE.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.TITANE_STICK.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.TITANE_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.COMPRESSED_AMETHYST.get()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.SPEED_STICK.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.TITANE_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.SPEED_STICK.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PALADIUM_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.STRENGH_ORB.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.TITANE_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.TITANE_BLOCK.get().asItem()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.STRENGHT_STICK.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.TITANE_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.STRENGHT_STICK.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_STICK.get()
				&& new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))))
						.is(ItemTags.create(Identifier.parse("palamod:slimepad")))
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.JUMP_ORB.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.TITANE_STICK.get()
				&& new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))))
						.is(ItemTags.create(Identifier.parse("palamod:slimepad")))
				&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.TITANE_STICK.get()
						&& new ItemStack(
								BuiltInRegistries.ITEM.getValue(Identifier.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))))
								.is(ItemTags.create(Identifier.parse("palamod:slimepad")))
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.JUMP_STICK.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.TITANE_STICK.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.JUMP_STICK.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.HEAL_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.STRENGHT_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.SPEED_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.FINDIUM.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.STICK_OF_GODS.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.STICK_OF_GODS.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.AMETHYST_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.PALADIUM_SPIKE.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.TITANE_SWORD.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.AMETHYST_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_SPIKE.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.AMETHYST_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.AMETHYST_STICK.get()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.DAMAGE_STICK.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.AMETHYST_STICK.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_SPIKE.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.DAMAGE_STICK.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.JUMP_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.JUMP_ORB.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.JUMP_STICK.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| new ItemStack(BuiltInRegistries.ITEM.getValue(Identifier.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))))
						.is(ItemTags.create(Identifier.parse("palamod:slimepad")))
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_CORE.get()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.HYPERJUMP_STICK.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_CORE.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.HEAL_STICK.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.HYPERJUMP_STICK.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (BuiltInRegistries.ITEM.getValue(
						Identifier.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.SMALL_RING.get()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem())
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.SMALL_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.SMALL_RING.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PALADIUM_PARTICLE.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.MEDIUM_RING.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_PARTICLE.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.MEDIUM_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.MEDIUM_RING.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
						&& BuiltInRegistries.ITEM.getValue(
								Identifier.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.BIG_RING.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.BIG_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.ENDIUM_FRAGMENT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.ENDIUM_FRAGMENT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.MEDIUM_RING.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.ENDIUM_FRAGMENT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.ENDIUM_FRAGMENT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.ENDIUM_FRAGMENT.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.ENDIUM_SMALL_RING.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.ENDIUM_FRAGMENT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.ENDIUM_SMALL_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.FINDIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.ENDIUM_SMALL_RING.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.ENDIUM_NUGGET.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.COMPRESSED_ENDIUM.get()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.ENDIUM_MEDIUM_RING.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.ENDIUM_MEDIUM_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.ENDIUM_NUGGET.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.ENDIUM_MEDIUM_RING.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.ENDIUM_NUGGET.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.COMPRESSED_ENDIUM.get()
						&& BuiltInRegistries.ITEM.getValue(Identifier
								.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.ENDIUM_BIG_RING.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.COMPRESSED_PALADIUM.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.COMPRESSED_ENDIUM.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.ENDIUM_BIG_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
				&& (BuiltInRegistries.ITEM
						.getValue(Identifier.parse(
								((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()
						|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem())
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem() && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy())
						.getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
				&& itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_PARTICLE.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
						&& BuiltInRegistries.ITEM.getValue(Identifier.parse(
								((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.GREEN_PALADIUM_MEDIUM_RING
										.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_PARTICLE.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.COMPRESSED_GREEN_PALADUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0
				|| (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem()
						&& BuiltInRegistries.ITEM.getValue(Identifier.parse(
								((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.GREEN_PALADIUM_BIG_RING.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.GREEN_PALADIUM_INGOT.get()
						&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModBlocks.PALADIUM_GREEN_BLOCK.get().asItem() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.GREEN_PALADIUM_BIG_RING.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get()
				&& BuiltInRegistries.ITEM.getValue(
						Identifier.parse(((BuiltInRegistries.ITEM.getKey((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem()).toString())).toLowerCase(java.util.Locale.ENGLISH))) == PalamodModItems.EXTRACTOR_ITEM.get()
				&& 1 < (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getDamageValue() && (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == Items.WATER_BUCKET
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.PALADIUM_INGOT.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.EXTRACTOR_ITEM.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.FINDIUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.FINDIUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.UNCLAIM_FINDER.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.FINDIUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.FINDIUM.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.UNCLAIM_FINDER_ORANGE.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModItems.FINDIUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.PALADIUM_CORE.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.UNCLAIM_FINDER_ORANGE.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModItems.FINDIUM.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.PALADIUM_CORE.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.UNCLAIM_FINDER_RED.get()).copy();
		} else if ((itemFromBlockInventory(world, BlockPos.containing(x, y, z), 0).copy()).getItem() == PalamodModBlocks.FINDIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 1).copy()).getItem() == PalamodModItems.UNCLAIM_FINDER_RED.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 2).copy()).getItem() == PalamodModItems.BIG_RING.get()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 3).copy()).getItem() == PalamodModBlocks.FINDIUM_BLOCK.get().asItem()
				&& (itemFromBlockInventory(world, BlockPos.containing(x, y, z), 4).copy()).getItem() == PalamodModItems.UNCLAIM_FINDER_RED.get() && itemFromBlockInventory(world, BlockPos.containing(x, y, z), 5).getCount() == 0) {
			output = new ItemStack(PalamodModItems.UNCLAIM_FINDER_BLUE.get()).copy();
		} else {
			output = new ItemStack(Blocks.BARRIER).copy();
		}
		return output;
	}

	private static ItemStack itemFromBlockInventory(LevelAccessor world, BlockPos pos, int slot) {
		if (world instanceof ILevelExtension ext) {
			ResourceHandler<ItemResource> itemHandler = ext.getCapability(Capabilities.Item.BLOCK, pos, null);
			if (itemHandler != null)
				return ItemUtil.getStack(itemHandler, slot);
		}
		return ItemStack.EMPTY;
	}
}
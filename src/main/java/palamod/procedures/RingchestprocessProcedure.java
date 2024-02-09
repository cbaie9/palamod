package palamod.procedures;

import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;

public class RingchestprocessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		double version = 0;
		double nloop = 0;
		double nloop2 = 0;
		boolean ring_ok = false;
		boolean loop1 = false;
		boolean loop2 = false;
		boolean loop3 = false;
		version = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "setlocal_chestver");
		nloop = 0;
		nloop2 = 12;
		loop1 = false;
		loop2 = false;
		loop3 = false;
		if (version == 3) {
			for (int index0 = 0; index0 < 4; index0++) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.BIG_RING.get()) {
					for (int index1 = 0; index1 < 11; index1++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(new ResourceLocation("palamod:repairable")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
											.getDamageValue() - 1));
							{
								ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						}
						nloop = nloop + 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.ENDIUM_SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.ENDIUM_MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.ENDIUM_BIG_RING.get()) {
					for (int index2 = 0; index2 < 11; index2++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(new ResourceLocation("palamod:repairable_endium")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
											.getDamageValue() - 1));
							{
								ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						}
						nloop = nloop + 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.GREEN_PALADIUM_BIG_RING.get()) {
					for (int index3 = 0; index3 < 11; index3++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(new ResourceLocation("palamod:repairable_green")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
											.getDamageValue() - 1));
							{
								ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						}
						nloop = nloop + 1;
					}
				}
				if (loop1) {
					nloop2 = 111;
				} else {
					if (loop2) {
						nloop2 = 110;
						loop1 = true;
					} else {
						if (loop3) {
							nloop2 = 12;
							loop2 = true;
						} else {
							nloop2 = 13;
							loop3 = true;
						}
					}
				}
			}
		} else if (version == 2) {
			for (int index4 = 0; index4 < 2; index4++) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.BIG_RING.get()) {
					for (int index5 = 0; index5 < 11; index5++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(new ResourceLocation("palamod:repairable")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
											.getDamageValue() - 1));
							{
								ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						}
						nloop = nloop + 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.ENDIUM_SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.ENDIUM_MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.ENDIUM_BIG_RING.get()) {
					for (int index6 = 0; index6 < 11; index6++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(new ResourceLocation("palamod:repairable_endium")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
											.getDamageValue() - 1));
							{
								ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						}
						nloop = nloop + 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.GREEN_PALADIUM_BIG_RING.get()) {
					for (int index7 = 0; index7 < 11; index7++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(new ResourceLocation("palamod:repairable_green")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
									.setDamageValue((int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
											.getDamageValue() - 1));
							{
								ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
								if (_ist.hurt(1, RandomSource.create(), null)) {
									_ist.shrink(1);
									_ist.setDamageValue(0);
								}
							}
						}
						nloop = nloop + 1;
					}
				}
				nloop2 = 13;
			}
		} else if (version == 1) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.SMALL_RING
					.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.MEDIUM_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.BIG_RING.get()) {
				for (int index8 = 0; index8 < 11; index8++) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(new ResourceLocation("palamod:repairable")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).setDamageValue(
								(int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue()
										- 1));
						{
							ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
					nloop = nloop + 1;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
					.getItem() == PalamodModItems.ENDIUM_SMALL_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.ENDIUM_MEDIUM_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.ENDIUM_BIG_RING.get()) {
				for (int index9 = 0; index9 < 11; index9++) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(new ResourceLocation("palamod:repairable_endium")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).setDamageValue(
								(int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue()
										- 1));
						{
							ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
					nloop = nloop + 1;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
					.getItem() == PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.GREEN_PALADIUM_BIG_RING.get()) {
				for (int index10 = 0; index10 < 11; index10++) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(new ResourceLocation("palamod:repairable_green")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).setDamageValue(
								(int) ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop)).getItem() : ItemStack.EMPTY).getDamageValue()
										- 1));
						{
							ItemStack _ist = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get((int) nloop2)).getItem() : ItemStack.EMPTY);
							if (_ist.hurt(1, RandomSource.create(), null)) {
								_ist.shrink(1);
								_ist.setDamageValue(0);
							}
						}
					}
					nloop = nloop + 1;
				}
			}
		}
	}
}

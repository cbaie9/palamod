package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

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
		version = getBlockNBTNumber(world, BlockPos.containing(x, y, z), "setlocal_chestver");
		nloop = 0;
		nloop2 = 12;
		loop1 = false;
		loop2 = false;
		loop3 = false;
		if (version == 3) {
			for (int index1102 = 0; index1102 < 4; index1102++) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu1 ? _menu1.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu3 ? _menu3.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.MEDIUM_RING
								.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.BIG_RING
								.get()) {
					for (int index1103 = 0; index1103 < 11; index1103++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu7 ? _menu7.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("palamod:repairable")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu13 ? _menu13.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu11 ? _menu11.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
							if (world instanceof ServerLevel _level) {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
										_stkprov -> {
										});
							}
						}
						nloop = nloop + 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu17 ? _menu17.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.ENDIUM_SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.ENDIUM_MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu21 ? _menu21.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.ENDIUM_BIG_RING.get()) {
					for (int index1104 = 0; index1104 < 11; index1104++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu23 ? _menu23.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("palamod:repairable_endium")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu27 ? _menu27.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
							if (world instanceof ServerLevel _level) {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu31 ? _menu31.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
										_stkprov -> {
										});
							}
						}
						nloop = nloop + 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu33 ? _menu33.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu35 ? _menu35.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu37 ? _menu37.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.GREEN_PALADIUM_BIG_RING.get()) {
					for (int index1105 = 0; index1105 < 11; index1105++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu39 ? _menu39.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("palamod:repairable_green")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu41 ? _menu41.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu45 ? _menu45.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu43 ? _menu43.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
							if (world instanceof ServerLevel _level) {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu47 ? _menu47.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
										_stkprov -> {
										});
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
			for (int index1106 = 0; index1106 < 2; index1106++) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu49 ? _menu49.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu51 ? _menu51.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu53 ? _menu53.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.BIG_RING
								.get()) {
					for (int index1107 = 0; index1107 < 11; index1107++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu55 ? _menu55.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("palamod:repairable")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu57 ? _menu57.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu61 ? _menu61.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu59 ? _menu59.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
							if (world instanceof ServerLevel _level) {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu63 ? _menu63.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
										_stkprov -> {
										});
							}
						}
						nloop = nloop + 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu65 ? _menu65.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.ENDIUM_SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu67 ? _menu67.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.ENDIUM_MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu69 ? _menu69.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.ENDIUM_BIG_RING.get()) {
					for (int index1108 = 0; index1108 < 11; index1108++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu71 ? _menu71.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("palamod:repairable_endium")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu73 ? _menu73.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu77 ? _menu77.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu75 ? _menu75.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
							if (world instanceof ServerLevel _level) {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu79 ? _menu79.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
										_stkprov -> {
										});
							}
						}
						nloop = nloop + 1;
					}
				} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu81 ? _menu81.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
						.getItem() == PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu83 ? _menu83.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()
						|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu85 ? _menu85.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
								.getItem() == PalamodModItems.GREEN_PALADIUM_BIG_RING.get()) {
					for (int index1109 = 0; index1109 < 11; index1109++) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu87 ? _menu87.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
								.is(ItemTags.create(ResourceLocation.parse("palamod:repairable_green")))
								&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu89 ? _menu89.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu93 ? _menu93.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
									(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu91 ? _menu91.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
							if (world instanceof ServerLevel _level) {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu95 ? _menu95.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
										_stkprov -> {
										});
							}
						}
						nloop = nloop + 1;
					}
				}
				nloop2 = 13;
			}
		} else if (version == 1) {
			if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu97 ? _menu97.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.SMALL_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu99 ? _menu99.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.MEDIUM_RING
							.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu101 ? _menu101.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).getItem() == PalamodModItems.BIG_RING
							.get()) {
				for (int index1110 = 0; index1110 < 11; index1110++) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu103 ? _menu103.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("palamod:repairable")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu105 ? _menu105.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu109 ? _menu109.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu107 ? _menu107.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
						if (world instanceof ServerLevel _level) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu111 ? _menu111.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
									_stkprov -> {
									});
						}
					}
					nloop = nloop + 1;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu113 ? _menu113.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
					.getItem() == PalamodModItems.ENDIUM_SMALL_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu115 ? _menu115.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.ENDIUM_MEDIUM_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu117 ? _menu117.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.ENDIUM_BIG_RING.get()) {
				for (int index1111 = 0; index1111 < 11; index1111++) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu119 ? _menu119.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("palamod:repairable_endium")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu121 ? _menu121.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu125 ? _menu125.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu123 ? _menu123.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
						if (world instanceof ServerLevel _level) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu127 ? _menu127.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
									_stkprov -> {
									});
						}
					}
					nloop = nloop + 1;
				}
			} else if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu129 ? _menu129.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
					.getItem() == PalamodModItems.GREEN_PALADIUM_SMALL_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu131 ? _menu131.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.GREEN_PALADIUM_MEDIUM_RING.get()
					|| (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu133 ? _menu133.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY)
							.getItem() == PalamodModItems.GREEN_PALADIUM_BIG_RING.get()) {
				for (int index1112 = 0; index1112 < 11; index1112++) {
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu135 ? _menu135.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY)
							.is(ItemTags.create(ResourceLocation.parse("palamod:repairable_green")))
							&& (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu137 ? _menu137.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() > 0) {
						(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu141 ? _menu141.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).setDamageValue(
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu139 ? _menu139.getSlots().get((int) nloop).getItem() : ItemStack.EMPTY).getDamageValue() - 1);
						if (world instanceof ServerLevel _level) {
							(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PalamodModMenus.MenuAccessor _menu143 ? _menu143.getSlots().get((int) nloop2).getItem() : ItemStack.EMPTY).hurtAndBreak(1, _level, null,
									_stkprov -> {
									});
						}
					}
					nloop = nloop + 1;
				}
			}
		}
	}

	private static double getBlockNBTNumber(LevelAccessor world, BlockPos pos, String tag) {
		BlockEntity blockEntity = world.getBlockEntity(pos);
		if (blockEntity != null)
			return blockEntity.getPersistentData().getDouble(tag);
		return -1;
	}
}
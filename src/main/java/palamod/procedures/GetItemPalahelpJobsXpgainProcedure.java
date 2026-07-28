package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import palamod.PalamodMod;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;

public class GetItemPalahelpJobsXpgainProcedure {
	public static ItemStack execute(LevelAccessor world, Entity entity, double slot) {
		if (entity == null)
			return ItemStack.EMPTY;
		double index = 0;
		String jobs = "";
		String xp_mode = "";
		String errorReason = "";
		ItemStack output = ItemStack.EMPTY;
		boolean errorDump = false;
		output = new ItemStack(PalamodModItems.LUCKY_BETA.get()).copy();
		if (!world.isClientSide()) {
			index = slot + entity.getPersistentData().getDouble("indexSlider");
			xp_mode = entity.getPersistentData().getString("xp_mode");
			jobs = entity.getPersistentData().getString("jobs_mode");
			errorReason = "Undefined Reason";
			if ((jobs).equals("farmer")) {
				if ((xp_mode).equals("grow")) {
					if (index == 0) {
						output = new ItemStack(Items.WHEAT).copy();
					} else if (index == 1) {
						output = new ItemStack(Items.POTATO).copy();
					} else if (index == 2) {
						output = new ItemStack(Items.CARROT).copy();
					} else if (index == 3) {
						output = new ItemStack(Blocks.MELON).copy();
					} else if (index == 4) {
						output = new ItemStack(Blocks.PUMPKIN).copy();
					} else if (index == 5) {
						output = new ItemStack(PalamodModBlocks.EGGPLANT_3.get()).copy();
					} else if (index == 6) {
						output = new ItemStack(PalamodModBlocks.CHERVIL_3.get()).copy();
					} else if (index == 7) {
						output = new ItemStack(PalamodModBlocks.KIWANO_4.get()).copy();
					} else if (index == 8) {
						output = new ItemStack(PalamodModBlocks.ORANGEBLUE_4.get()).copy();
					} else {
						errorDump = true;
						errorReason = "Out of limit index";
					}
				} else if ((xp_mode).equals("craft")) {
					if (index == 0) {
						output = new ItemStack(Items.BREAD).copy();
					} else if (index == 1) {
						output = new ItemStack(Items.PUMPKIN_PIE).copy();
					} else if (index <= 5 && index >= 2) {
						output = new ItemStack(PalamodModItems.LUCKY_BETA.get()).copy();
					} else {
						errorDump = true;
						errorReason = "Out of limit index";
					}
				} else {
					errorDump = true;
					errorReason = "Wrong xp_mode defined";
				}
			} else if ((jobs).equals("miner")) {
				if ((xp_mode).equals("mine")) {
					if (index == 0) {
						output = new ItemStack(Blocks.STONE).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(((("%1/%2/%3".replace("%3", new ItemStack(Blocks.ANDESITE).getDisplayName().getString())).replace("%2", new ItemStack(Blocks.DIORITE).getDisplayName().getString()))
								.replace("%1", new ItemStack(Blocks.GRANITE).getDisplayName().getString()))));
					} else if (index == 1) {
						output = new ItemStack(Blocks.COAL_ORE).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(((Component.translatable("palamod.procedure.jobsxpgain.variant").getString()).replace("%1", new ItemStack(Items.COAL).getDisplayName().getString()))));
					} else if (index == 2) {
						output = new ItemStack(Blocks.NETHER_QUARTZ_ORE).copy();
					} else if (index == 3) {
						output = new ItemStack(Blocks.OBSIDIAN).copy();
					} else if (index == 4) {
						output = new ItemStack(Blocks.REDSTONE_ORE).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(((Component.translatable("palamod.procedure.jobsxpgain.variant").getString()).replace("%1", new ItemStack(Blocks.REDSTONE_ORE).getDisplayName().getString()))));
					} else if (index == 5) {
						output = new ItemStack(Blocks.EMERALD_ORE).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(((Component.translatable("palamod.procedure.jobsxpgain.variant").getString()).replace("%1", new ItemStack(Blocks.EMERALD_ORE).getDisplayName().getString()))));
					} else if (index == 6) {
						output = new ItemStack(Blocks.DIAMOND_ORE).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(((Component.translatable("palamod.procedure.jobsxpgain.variant").getString()).replace("%1", new ItemStack(Items.DIAMOND).getDisplayName().getString()))));
					} else {
						errorDump = true;
						errorReason = "Out of limit index";
					}
				} else if ((xp_mode).equals("smelt")) {
					if (index == 0) {
						output = new ItemStack(Items.NETHER_BRICK).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(
								(((Component.translatable("palamod.procedure.jobsxpgain.smeltvariant").getString()).replace("%2", new ItemStack(Blocks.NETHERRACK).getDisplayName().getString())).replace("%1", output.getDisplayName().getString()))));
					} else if (index == 1) {
						output = new ItemStack(Items.CHARCOAL).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(
								(((Component.translatable("palamod.procedure.jobsxpgain.smeltvariant").getString()).replace("%2", new ItemStack(Blocks.OAK_LOG).getDisplayName().getString())).replace("%1", output.getDisplayName().getString()))));
					} else if (index == 2) {
						output = new ItemStack(Items.IRON_INGOT).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(
								(((Component.translatable("palamod.procedure.jobsxpgain.smeltvariant").getString()).replace("%2", new ItemStack(Items.RAW_IRON).getDisplayName().getString())).replace("%1", output.getDisplayName().getString()))));
					} else if (index == 3) {
						output = new ItemStack(Items.GOLD_INGOT).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal(((((Component.translatable("palamod.procedure.jobsxpgain.smeltvariantore").getString()).replace("%3", new ItemStack(Blocks.GOLD_ORE).getDisplayName().getString()))
								.replace("%2", new ItemStack(Items.RAW_GOLD).getDisplayName().getString())).replace("%1", output.getDisplayName().getString()))));
					} else if (index == 4) {
						output = new ItemStack(PalamodModItems.AMETHYST_INGOT.get()).copy();
						output.set(DataComponents.CUSTOM_NAME,
								Component.literal(((((Component.translatable("palamod.procedure.jobsxpgain.smeltvariantore").getString()).replace("%3", new ItemStack(PalamodModBlocks.AMETHYST_ORE.get()).getDisplayName().getString())).replace("%2",
										new ItemStack(PalamodModItems.AMETHYST_RAW_ORE.get()).getDisplayName().getString())).replace("%1", output.getDisplayName().getString()))));
					} else if (index == 5) {
						output = new ItemStack(PalamodModItems.TITANE_INGOT.get()).copy();
						output.set(DataComponents.CUSTOM_NAME,
								Component.literal(((((Component.translatable("palamod.procedure.jobsxpgain.smeltvariantore").getString()).replace("%3", new ItemStack(PalamodModBlocks.TITANE_ORE.get()).getDisplayName().getString())).replace("%2",
										new ItemStack(PalamodModItems.TITANE_RAW_ORE.get()).getDisplayName().getString())).replace("%1", output.getDisplayName().getString()))));
					} else if (index == 6) {
						output = new ItemStack(PalamodModItems.PALADIUM_INGOT.get()).copy();
						output.set(DataComponents.CUSTOM_NAME,
								Component.literal(((((Component.translatable("palamod.procedure.jobsxpgain.smeltvariantore").getString()).replace("%3", new ItemStack(PalamodModBlocks.PALADIUM_ORE.get()).getDisplayName().getString())).replace("%2",
										new ItemStack(PalamodModItems.PALADIUM_RAW_ORE.get()).getDisplayName().getString())).replace("%1", output.getDisplayName().getString()))));
					} else {
						errorDump = true;
						errorReason = "Out of limit index";
					}
				} else {
					errorDump = true;
					errorReason = "Wrong xp_mode defined";
				}
			} else if ((jobs).equals("hunter")) {
				if ((xp_mode).equals("kill")) {
					if (index == 0) {
						output = new ItemStack(Items.COW_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME,
								Component.literal((((((((("%1/%2/%3/%4/%5/%6/%7/%8".replaceAll("%8", Component.translatable("entity.minecraft.squid").getString())).replaceAll("%7", Component.translatable("entity.minecraft.horse").getString()))
										.replaceAll("%6", Component.translatable("entity.minecraft.glow_squid").getString())).replaceAll("%5", Component.translatable("entity.minecraft.rabbit").getString()))
										.replaceAll("%4", Component.translatable("entity.minecraft.cow").getString())).replaceAll("%3", Component.translatable("entity.minecraft.sheep").getString()))
										.replaceAll("%2", Component.translatable("entity.minecraft.chicken").getString())).replaceAll("%1", Component.translatable("entity.minecraft.pig").getString()))));
					} else if (index == 1) {
						output = new ItemStack(Items.CREEPER_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("\tentity.minecraft.creeper").getString())));
					} else if (index == 2) {
						output = new ItemStack(Items.WITHER_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("\tentity.minecraft.wither").getString())));
					} else if (index == 3) {
						output = new ItemStack(Items.SNOW_GOLEM_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("entity.minecraft.snow_golem").getString())));
					} else if (index == 4) {
						output = new ItemStack(Items.ZOMBIE_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("entity.minecraft.zombie").getString())));
					} else if (index == 5) {
						output = new ItemStack(Items.SKELETON_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("entity.minecraft.skeleton").getString())));
					} else if (index == 6) {
						output = new ItemStack(Items.SPIDER_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("entity.minecraft.spider").getString())));
					} else if (index == 7) {
						output = new ItemStack(Items.BLAZE_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("entity.minecraft.blaze").getString())));
					} else if (index == 8) {
						output = new ItemStack(Items.WITCH_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("entity.minecraft.witch").getString())));
					} else if (index == 9) {
						output = new ItemStack(Items.CAVE_SPIDER_SPAWN_EGG).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("entity.minecraft.cave_spider").getString())));
					} else {
						errorDump = true;
						errorReason = "Out of limit index";
					}
				} else if ((xp_mode).equals("smelt")) {
					if (index == 0) {
						output = new ItemStack(Items.COOKED_BEEF).copy();
					} else if (index == 1) {
						output = new ItemStack(Items.COOKED_CHICKEN).copy();
					} else if (index == 2) {
						output = new ItemStack(Items.COOKED_PORKCHOP).copy();
					} else if (index == 3) {
						output = new ItemStack(Items.COOKED_MUTTON).copy();
					} else if (index == 4) {
						output = new ItemStack(Items.COOKED_COD).copy();
					} else if (index == 5) {
						output = new ItemStack(Items.COOKED_SALMON).copy();
					} else {
						errorDump = true;
						errorReason = "Out of limit index";
					}
				} else {
					errorDump = true;
					errorReason = "Wrong xp_mode defined";
				}
			} else if ((jobs).equals("alchi")) {
				if ((xp_mode).equals("craft")) {
					if (index == 0) {
						output = new ItemStack(PalamodModItems.FLASK.get()).copy();
					} else if (index == 1) {
						output = new ItemStack(PalamodModBlocks.EXTRACTOR.get()).copy();
					} else if (index == 2) {
						output = new ItemStack(PalamodModBlocks.GLUEBALL_RED.get()).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("palamod.procedure.jobsxpgain.t1glueball").getString())));
					} else if (index == 3) {
						output = new ItemStack(PalamodModBlocks.GLUEBALL_RED.get()).copy();
						output.set(DataComponents.CUSTOM_NAME, Component.literal((Component.translatable("palamod.procedure.jobsxpgain.t2glueball").getString())));
					} else if (index == 4 || index == 5) {
						output = new ItemStack(PalamodModItems.LUCKY_BETA.get()).copy();
					} else {
						errorDump = true;
						errorReason = "Out of limit index";
					}
				} else if ((xp_mode).equals("break")) {
					if (index == 0) {
						output = new ItemStack(PalamodModBlocks.JACARANDA_LOG.get()).copy();
					} else if (index == 1) {
						output = new ItemStack(PalamodModBlocks.JUDEECERCIS_LOG.get()).copy();
					} else if (index == 2) {
						output = new ItemStack(PalamodModBlocks.ERABLE_LOG.get()).copy();
					} else if (index == 3) {
						output = new ItemStack(PalamodModBlocks.OSTRYA_WOOD_LOG.get()).copy();
					} else if (index == 4 || index == 5) {
						output = new ItemStack(PalamodModItems.LUCKY_BETA.get()).copy();
					} else {
						errorDump = true;
						errorReason = "Out of limit index";
					}
				} else {
					errorDump = true;
					errorReason = "Wrong xp_mode defined";
				}
			} else {
				errorDump = true;
				errorReason = "Wrong jobs argument";
			}
			if (errorDump) {
				PalamodMod.LOGGER.error((((("[GetItemPalahelpJobsXpGain] : Reason %4 ; dump -> slot : %1, jobs_mode -> %2, xp_mode -> %3".replace("%4", errorReason)).replace("%3", xp_mode)).replace("%2", jobs)).replace("%1", "" + index)));
			}
		} else {
			PalamodMod.LOGGER.info("[GetItemPalahelpJobsXpGain] : Ignore try on client side");
		}
		return output;
	}
}
package palamod.procedures;

import palamod.world.inventory.AnalyserresultMenu;

import palamod.network.PalamodModVariables;

import palamod.PalamodMod;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.tags.BlockTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import io.netty.buffer.Unpooled;

public class AnalyserdendProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		boolean aready_iden = false;
		double ores = 0;
		double stone = 0;
		double air = 0;
		double yloop = 0;
		double bedrock = 0;
		double wool = 0;
		double logs = 0;
		double shulkers = 0;
		double cobblestone = 0;
		double planks = 0;
		double anvil = 0;
		double chest = 0;
		double xloop = 0;
		double zloop = 0;
		double proc1id = 0;
		double endstone = 0;
		double dirt = 0;
		double clay = 0;
		double grass = 0;
		if (entity instanceof Player _player)
			_player.getCooldowns().addCooldown(itemstack.getItem(), 100);
		proc1id = Mth.nextInt(RandomSource.create(), 1, 999955);
		PalamodMod.LOGGER.debug(("[ Palamod ] " + entity + " use Chunk analyser ( status proc1 ) id proc1 : " + proc1id));
		aready_iden = false;
		ores = 0;
		stone = 0;
		air = 0;
		bedrock = 0;
		wool = 0;
		logs = 0;
		shulkers = 0;
		cobblestone = 0;
		planks = 0;
		anvil = 0;
		chest = 0;
		yloop = 0;
		endstone = 0;
		xloop = x - 8;
		zloop = z - 8;
		PalamodMod.LOGGER.debug(("[ Palamod ] proc1 :" + proc1id + "( staus proc2an )" + "( server may lag )"));
		int horizontalRadiusSphere = (int) 200 - 1;
		int verticalRadiusSphere = (int) 320 - 1;
		int yIterationsSphere = verticalRadiusSphere;
		for (int i = -yIterationsSphere; i <= yIterationsSphere; i++) {
			for (int xi = -horizontalRadiusSphere; xi <= horizontalRadiusSphere; xi++) {
				for (int zi = -horizontalRadiusSphere; zi <= horizontalRadiusSphere; zi++) {
					double distanceSq = (xi * xi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere) + (i * i) / (double) (verticalRadiusSphere * verticalRadiusSphere)
							+ (zi * zi) / (double) (horizontalRadiusSphere * horizontalRadiusSphere);
					if (distanceSq <= 1.0) {
						if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("forge:ores"))) || aready_iden) {
							ores = ores + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.BEDROCK || aready_iden) {
							bedrock = bedrock + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.AIR || (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.CAVE_AIR
								|| (world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.VOID_AIR || aready_iden) {
							air = air + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.GRASS_BLOCK || aready_iden) {
							grass = grass + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.MAGENTA_SHULKER_BOX || aready_iden) {
							shulkers = cobblestone + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("minecraft:anvil"))) || aready_iden) {
							anvil = anvil + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("forge:planks"))) || aready_iden) {
							planks = planks + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("minecraft:anvil"))) || aready_iden) {
							anvil = anvil + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("minecraft:wool"))) || aready_iden) {
							wool = wool + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("minecraft:logs"))) || aready_iden) {
							logs = logs + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("minecraft:planks"))) || aready_iden) {
							planks = planks + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("forge:cobblestone"))) || aready_iden) {
							cobblestone = cobblestone + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).is(BlockTags.create(new ResourceLocation("forge:chests"))) || aready_iden) {
							chest = chest + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.END_STONE || aready_iden) {
							endstone = endstone + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.DIRT || aready_iden) {
							dirt = dirt + 1;
						} else if ((world.getBlockState(BlockPos.containing(x + xi, y + i, z + zi))).getBlock() == Blocks.CLAY || aready_iden) {
							clay = clay + 1;
						}
						aready_iden = false;
						yloop = yloop + 1;
					}
				}
			}
		}
		PalamodMod.LOGGER.debug(("[ Palamod ] proc1 :" + proc1id + "( staus proc2result )" + "( server may lag )"));
		entity.getPersistentData().putDouble("analy_ores", ores);
		entity.getPersistentData().putDouble("analy_stone", stone);
		entity.getPersistentData().putDouble("analy_air", air);
		entity.getPersistentData().putDouble("analy_bedrock", bedrock);
		entity.getPersistentData().putDouble("analy_wool", wool);
		entity.getPersistentData().putDouble("analy_logs", logs);
		entity.getPersistentData().putDouble("analy_shulker", shulkers);
		entity.getPersistentData().putDouble("analy_cobble", cobblestone);
		entity.getPersistentData().putDouble("analy_planks", planks);
		entity.getPersistentData().putDouble("analy_anvil", anvil);
		entity.getPersistentData().putDouble("analy_chest", chest);
		entity.getPersistentData().putDouble("analy_endstone", endstone);
		entity.getPersistentData().putDouble("analy_dirt", dirt);
		entity.getPersistentData().putDouble("analy_clay", clay);
		PalamodModVariables.analy_ores = ores;
		PalamodModVariables.analy_dirt = dirt;
		PalamodModVariables.analy_stone = stone;
		PalamodModVariables.analy_endstone = endstone;
		PalamodModVariables.analy_clay = clay;
		PalamodModVariables.analy_cobble = cobblestone;
		PalamodModVariables.analy_logs = logs;
		PalamodModVariables.analy_planks = planks;
		PalamodModVariables.analy_bedrock = bedrock;
		PalamodModVariables.analy_wool = wool;
		PalamodModVariables.analy_chest = chest;
		PalamodModVariables.analy_shulker = shulkers;
		PalamodModVariables.analy_air = air;
		if (entity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Analyserresult");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new AnalyserresultMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
	}
}

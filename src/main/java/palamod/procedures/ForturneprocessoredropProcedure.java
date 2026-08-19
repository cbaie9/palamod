package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.BlockPos;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

@EventBusSubscriber
public class ForturneprocessoredropProcedure {
	@SubscribeEvent
	public static void onBlockBreak(BlockEvent.BreakEvent event) {
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		execute(null, world, x, y, z, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		BlockState block_ore = Blocks.AIR.defaultBlockState();
		ItemStack drop = ItemStack.EMPTY;
		if ((!((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).is(ItemTags.create(ResourceLocation.parse("palamod:hammer_smt"))))
				|| !((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)
						.getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(ResourceKey.create(Registries.ENCHANTMENT, ResourceLocation.parse("palamod:smelt")))) != 0))
				&& !(getEntityGameType(entity) == GameType.CREATIVE)) {
			if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.PALADIUM_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_PALADIUM_ORE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_PALADIUM_ORE.get()) {
				drop = new ItemStack(PalamodModItems.PALADIUM_RAW_ORE.get()).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.TITANE_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_TITANE_ORE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_TITANE_ORE.get()) {
				drop = new ItemStack(PalamodModItems.TITANE_RAW_ORE.get()).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.AMETHYST_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_AMETHYST_ORE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_AMETHYST_ORE.get()) {
				drop = new ItemStack(PalamodModItems.AMETHYST_RAW_ORE.get()).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.PALADIUM_GREEN_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_GREEN_PALADIUM_ORE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_GREEN_PALADIUM_ORE.get()) {
				drop = new ItemStack(PalamodModItems.GREEN_PALADIUM_RAW_ORE.get()).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.FINDIUM_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_FINDIUM_ORE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_FINDIUM_ORE.get()) {
				drop = new ItemStack(PalamodModItems.FINDIUM.get()).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.ENDIUM_NUGGET_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_ENDIUM_NUGGET_ORE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_ENDIUM_NUGGET_ORE.get()) {
				drop = new ItemStack(PalamodModItems.ENDIUM_NUGGET.get()).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_COAL_ORE.get()) {
				drop = new ItemStack(Items.COAL).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_IRON_ORE.get()) {
				drop = new ItemStack(Items.RAW_IRON).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_DIAMOND_ORE.get()) {
				drop = new ItemStack(Items.DIAMOND).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_GOLD_ORE.get()) {
				drop = new ItemStack(Items.RAW_GOLD).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_REDSTONE_ORE.get()) {
				drop = new ItemStack(Items.REDSTONE).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_LAPIS_LAZULIS_ORE.get()) {
				drop = new ItemStack(Items.LAPIS_LAZULI).copy();
			} else if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.SOFTENED_TRIXIUM_ORE.get() || (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.TRIXIUM_ORE.get()
					|| (world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PalamodModBlocks.DEEPSLATE_TRIXIUM_ORE.get()) {
				drop = new ItemStack(PalamodModItems.TRIXIUM.get()).copy();
			} else {
				drop = new ItemStack(Blocks.BEDROCK).copy();
			}
			if (!(drop.getItem() == Blocks.BEDROCK.asItem())) {
				for (int _i1 = 0; _i1 < (int) GetFortuneBonusAmountProcedure
						.execute((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getEnchantmentLevel(world.registryAccess().lookupOrThrow(Registries.ENCHANTMENT).getOrThrow(Enchantments.FORTUNE))); _i1++) {
					if (world instanceof ServerLevel _level) {
						ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, drop);
						entityToSpawn.setPickUpDelay(0);
						_level.addFreshEntity(entityToSpawn);
					}
				}
			}
		}
	}

	private static GameType getEntityGameType(Entity entity) {
		if (entity instanceof ServerPlayer serverPlayer) {
			return serverPlayer.gameMode.getGameModeForPlayer();
		} else if (entity instanceof Player player && player.level().isClientSide()) {
			PlayerInfo playerInfo = Minecraft.getInstance().getConnection().getPlayerInfo(player.getGameProfile().getId());
			if (playerInfo != null)
				return playerInfo.getGameMode();
		}
		return null;
	}
}
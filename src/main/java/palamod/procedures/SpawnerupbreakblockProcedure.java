package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.event.level.BlockEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import javax.annotation.Nullable;

@EventBusSubscriber
public class SpawnerupbreakblockProcedure {
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
		String data = "";
		ItemStack spawner_item = ItemStack.EMPTY;
		boolean passsetup = false;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.CAVERNE_HAMMER.get() && Blocks.SPAWNER == (world.getBlockState(BlockPos.containing(x, y, z))).getBlock()) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModBlocks.EMPTY_SPAWNER.get().asItem()) {
				spawner_item = new ItemStack(PalamodModItems.EMPTY_SPAWNER_ITEM.get()).copy();
				passsetup = true;
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == PalamodModItems.EMPTY_SPAWNER_ITEM.get()) {
				spawner_item = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
			}
			data = executeCommandGetResult(world, new Vec3(x, y, z), "data get block ~ ~ ~ SpawnData.entity");
			if (data.contains("witch") && (passsetup || (spawner_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("spawner_type")).equals("witch"))) {
				{
					final String _tagName = "spawner_type";
					final String _tagValue = "witch";
					CustomData.update(DataComponents.CUSTOM_DATA, spawner_item, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "soul";
					final double _tagValue = (spawner_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("souls") + 0);
					CustomData.update(DataComponents.CUSTOM_DATA, spawner_item, tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if (data.contains("zombie") && (passsetup || (spawner_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("spawner_type")).equals("zombie"))) {
				{
					final String _tagName = "spawner_type";
					final String _tagValue = "zombie";
					CustomData.update(DataComponents.CUSTOM_DATA, spawner_item, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "soul";
					final double _tagValue = (spawner_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("souls") + 0);
					CustomData.update(DataComponents.CUSTOM_DATA, spawner_item, tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if (data.contains("skeleton") && (passsetup || (spawner_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("spawner_type")).equals("creeper"))) {
				{
					final String _tagName = "spawner_type";
					final String _tagValue = "skeleton";
					CustomData.update(DataComponents.CUSTOM_DATA, spawner_item, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "soul";
					final double _tagValue = (spawner_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("souls") + 0);
					CustomData.update(DataComponents.CUSTOM_DATA, spawner_item, tag -> tag.putDouble(_tagName, _tagValue));
				}
			} else if (data.contains("creeper") && (passsetup || (spawner_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("spawner_type")).equals("creeper"))) {
				{
					final String _tagName = "spawner_type";
					final String _tagValue = "creeper";
					CustomData.update(DataComponents.CUSTOM_DATA, spawner_item, tag -> tag.putString(_tagName, _tagValue));
				}
				{
					final String _tagName = "soul";
					final double _tagValue = (spawner_item.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("souls") + 0);
					CustomData.update(DataComponents.CUSTOM_DATA, spawner_item, tag -> tag.putDouble(_tagName, _tagValue));
				}
			}
			if (entity instanceof LivingEntity _entity) {
				ItemStack _setstack26 = spawner_item.copy();
				_setstack26.setCount(1);
				_entity.setItemInHand(InteractionHand.OFF_HAND, _setstack26);
				if (_entity instanceof Player _player)
					_player.getInventory().setChanged();
			}
		}
	}

	private static String executeCommandGetResult(LevelAccessor world, Vec3 pos, String command) {
		StringBuilder result = new StringBuilder();
		if (world instanceof ServerLevel level) {
			CommandSource dataConsumer = new CommandSource() {
				@Override
				public void sendSystemMessage(Component message) {
					result.append(message.getString());
				}

				@Override
				public boolean acceptsSuccess() {
					return true;
				}

				@Override
				public boolean acceptsFailure() {
					return true;
				}

				@Override
				public boolean shouldInformAdmins() {
					return false;
				}
			};
			level.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(dataConsumer, pos, Vec2.ZERO, level, 4, "", Component.literal(""), level.getServer(), null), command);
		}
		return result.toString();
	}
}
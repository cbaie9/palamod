package palamod.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

public class MvprocessProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		while (itemstack.getDamageValue() > 0) {
			itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") - 1));
			itemstack.setDamageValue((int) (0 - itemstack.getDamageValue()));
			itemstack.setHoverName(Component.literal((Component.translatable("item.palamod.minage_voidstone").getString() + " - " + Component.translatable("palamod.procedure.minagevoidstone_repair").getString() + " - "
					+ Math.round(itemstack.getOrCreateTag().getDouble("voidstone_count")))));
		}
		for (int index1 = 0; index1 < 64; index1++) {
			if (itemstack.getOrCreateTag().getBoolean("powered") == true) {
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.SMOOTH_STONE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.SMOOTH_STONE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.DEEPSLATE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.DEEPSLATE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.COBBLED_DEEPSLATE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.COBBLED_DEEPSLATE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.STONE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.STONE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.COBBLESTONE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.COBBLESTONE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.GRANITE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.GRANITE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.DIORITE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.DIORITE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.ANDESITE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.ANDESITE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BLACKSTONE)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.BLACKSTONE);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BASALT)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.BASALT);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.NETHERRACK)) : false) {
					itemstack.getOrCreateTag().putDouble("voidstone_count", (itemstack.getOrCreateTag().getDouble("voidstone_count") + 1));
					if (entity instanceof Player _player) {
						ItemStack _stktoremove = new ItemStack(Blocks.NETHERRACK);
						_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
					}
				}
				if ((entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.STONE)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.COBBLESTONE)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.GRANITE)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.DIORITE)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.ANDESITE)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BLACKSTONE)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.BASALT)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.COBBLED_DEEPSLATE)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.DEEPSLATE)) : false)
						|| (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(Blocks.NETHERRACK)) : false)) {
					continue;
				} else {
					break;
				}
			}
		}
		itemstack.setHoverName(Component.literal((Component.translatable("item.palamod.minage_voidstone").getString() + " - " + Math.round(itemstack.getOrCreateTag().getDouble("voidstone_count")))));
		if (itemstack.getOrCreateTag().getDouble("cooldown") > 0) {
			itemstack.getOrCreateTag().putDouble("cooldown", (itemstack.getOrCreateTag().getDouble("cooldown") - 1));
		}
	}
}

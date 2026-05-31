package palamod.world.inventory;

import palamod.init.PalamodModMenus;

import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.neoforged.neoforge.transfer.item.VanillaContainerWrapper;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.capabilities.Capabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.Container;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import java.util.function.Supplier;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class ArmorpalahelpguiMenu extends AbstractContainerMenu implements PalamodModMenus.MenuAccessor {
	public final Map<String, Object> menuState = new HashMap<>() {
		@Override
		public Object put(String key, Object value) {
			if (!this.containsKey(key) && this.size() >= 103)
				return null;
			return super.put(key, value);
		}
	};
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private ResourceHandler<ItemResource> internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public ArmorpalahelpguiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(PalamodModMenus.ARMORPALAHELPGUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStacksResourceHandler(32);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				ResourceHandler<ItemResource> cap = itemstack.getCapability(Capabilities.Item.ITEM, ItemAccess.forPlayerSlot(this.entity, hand == 0 ? this.entity.getInventory().getSelectedSlot() : Inventory.SLOT_OFFHAND));
				if (cap != null) {
					this.internal = cap;
					this.bound = true;
				}
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null) {
					ResourceHandler<ItemResource> cap = boundEntity.getCapability(Capabilities.Item.ENTITY);
					if (cap != null) {
						this.internal = cap;
						this.bound = true;
					}
				}
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity instanceof BaseContainerBlockEntity baseContainerBlockEntity) {
					this.internal = VanillaContainerWrapper.of(baseContainerBlockEntity);
					this.bound = true;
				}
			}
		}
		this.customSlots.put(0, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 0, 13, 30) {
			private final int slot = 0;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(1, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 1, 13, 50) {
			private final int slot = 1;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(2, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 2, 13, 70) {
			private final int slot = 2;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(3, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 3, 13, 90) {
			private final int slot = 3;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}

			@Override
			public boolean mayPlace(ItemStack itemstack) {
				return false;
			}
		}));
		this.customSlots.put(4, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 4, 81, 30) {
			private final int slot = 4;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(5, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 5, 81, 50) {
			private final int slot = 5;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(6, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 6, 81, 70) {
			private final int slot = 6;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(7, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 7, 81, 90) {
			private final int slot = 7;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(8, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 8, 149, 30) {
			private final int slot = 8;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(9, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 9, 149, 50) {
			private final int slot = 9;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(10, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 10, 149, 70) {
			private final int slot = 10;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(11, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 11, 149, 90) {
			private final int slot = 11;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(12, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 12, 217, 30) {
			private final int slot = 12;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(13, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 13, 217, 50) {
			private final int slot = 13;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(14, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 14, 217, 70) {
			private final int slot = 14;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(15, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 15, 217, 90) {
			private final int slot = 15;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(16, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 16, 13, 119) {
			private final int slot = 16;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(17, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 17, 13, 139) {
			private final int slot = 17;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(18, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 18, 13, 159) {
			private final int slot = 18;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(19, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 19, 13, 179) {
			private final int slot = 19;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(20, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 20, 81, 119) {
			private final int slot = 20;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(21, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 21, 81, 139) {
			private final int slot = 21;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(22, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 22, 81, 159) {
			private final int slot = 22;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(23, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 23, 81, 179) {
			private final int slot = 23;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(24, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 24, 149, 119) {
			private final int slot = 24;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(25, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 25, 149, 139) {
			private final int slot = 25;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(26, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 26, 149, 159) {
			private final int slot = 26;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(27, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 27, 149, 179) {
			private final int slot = 27;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(28, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 28, 217, 119) {
			private final int slot = 28;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(29, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 29, 217, 139) {
			private final int slot = 29;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(30, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 30, 217, 159) {
			private final int slot = 30;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		this.customSlots.put(31, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 31, 217, 179) {
			private final int slot = 31;
			private int x = ArmorpalahelpguiMenu.this.x;
			private int y = ArmorpalahelpguiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return false;
			}
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 1062 + 8 + sj * 18, 17 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 1062 + 8 + si * 18, 17 + 142));
	}

	private void setItemInSlot(int index, ItemResource resource, int amount) {
		if (internal instanceof ItemStacksResourceHandler handler) {
			handler.set(index, resource, amount);
		} else if (boundBlockEntity instanceof Container container) {
			container.setItem(index, resource.toStack(Math.max(0, amount)));
		} else {
			try (var tx = Transaction.openRoot()) {
				if (!internal.getResource(index).isEmpty())
					internal.extract(index, internal.getResource(index), internal.getAmountAsInt(index), tx);
				if (!resource.isEmpty() && amount > 0)
					internal.insert(index, resource, amount, tx);
				tx.commit();
			}
		}
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 32) {
				if (!this.moveItemStackTo(itemstack1, 32, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 32, false)) {
				if (index < 32 + 27) {
					if (!this.moveItemStackTo(itemstack1, 32 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 32, 32 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty()) {
				slot.setByPlayer(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override
	protected boolean moveItemStackTo(ItemStack itemStack, int startSlot, int endSlot, boolean backwards) {
		boolean anythingChanged = false;
		int destSlot = startSlot;
		if (backwards) {
			destSlot = endSlot - 1;
		}
		if (itemStack.isStackable()) {
			while (!itemStack.isEmpty() && (backwards ? destSlot >= startSlot : destSlot < endSlot)) {
				Slot slot = this.slots.get(destSlot);
				ItemStack target = slot.getItem();
				if (slot.mayPlace(target) && !target.isEmpty() && ItemStack.isSameItemSameComponents(itemStack, target)) {
					int totalStack = target.getCount() + itemStack.getCount();
					int maxStackSize = slot.getMaxStackSize(target);
					if (totalStack <= maxStackSize) {
						itemStack.setCount(0);
						target.setCount(totalStack);
						slot.set(target);
						anythingChanged = true;
					} else if (target.getCount() < maxStackSize) {
						itemStack.shrink(maxStackSize - target.getCount());
						target.setCount(maxStackSize);
						slot.set(target);
						anythingChanged = true;
					}
				}
				if (backwards) {
					destSlot--;
				} else {
					destSlot++;
				}
			}
		}
		if (!itemStack.isEmpty()) {
			if (backwards) {
				destSlot = endSlot - 1;
			} else {
				destSlot = startSlot;
			}
			while (backwards ? destSlot >= startSlot : destSlot < endSlot) {
				Slot slotx = this.slots.get(destSlot);
				ItemStack targetx = slotx.getItem();
				if (targetx.isEmpty() && slotx.mayPlace(itemStack)) {
					int maxStackSize = slotx.getMaxStackSize(itemStack);
					slotx.setByPlayer(itemStack.split(Math.min(itemStack.getCount(), maxStackSize)));
					slotx.setChanged();
					anythingChanged = true;
					break;
				}
				if (backwards) {
					destSlot--;
				} else {
					destSlot++;
				}
			}
		}
		return anythingChanged;
	}

	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.size(); ++j) {
					if (j == 0)
						continue;
					if (j == 1)
						continue;
					if (j == 2)
						continue;
					if (j == 3)
						continue;
					if (j == 5)
						continue;
					if (j == 6)
						continue;
					if (j == 7)
						continue;
					if (j == 8)
						continue;
					if (j == 9)
						continue;
					if (j == 10)
						continue;
					if (j == 11)
						continue;
					if (j == 12)
						continue;
					if (j == 13)
						continue;
					if (j == 14)
						continue;
					if (j == 15)
						continue;
					if (j == 16)
						continue;
					if (j == 17)
						continue;
					if (j == 18)
						continue;
					if (j == 20)
						continue;
					if (j == 21)
						continue;
					if (j == 22)
						continue;
					if (j == 23)
						continue;
					if (j == 24)
						continue;
					if (j == 25)
						continue;
					if (j == 26)
						continue;
					if (j == 27)
						continue;
					if (j == 28)
						continue;
					if (j == 29)
						continue;
					if (j == 30)
						continue;
					if (j == 31)
						continue;
					playerIn.drop(ItemUtil.getStack(internal, j), false);
					setItemInSlot(j, ItemResource.EMPTY, 0);
				}
			} else {
				for (int i = 0; i < internal.size(); ++i) {
					if (i == 0)
						continue;
					if (i == 1)
						continue;
					if (i == 2)
						continue;
					if (i == 3)
						continue;
					if (i == 5)
						continue;
					if (i == 6)
						continue;
					if (i == 7)
						continue;
					if (i == 8)
						continue;
					if (i == 9)
						continue;
					if (i == 10)
						continue;
					if (i == 11)
						continue;
					if (i == 12)
						continue;
					if (i == 13)
						continue;
					if (i == 14)
						continue;
					if (i == 15)
						continue;
					if (i == 16)
						continue;
					if (i == 17)
						continue;
					if (i == 18)
						continue;
					if (i == 20)
						continue;
					if (i == 21)
						continue;
					if (i == 22)
						continue;
					if (i == 23)
						continue;
					if (i == 24)
						continue;
					if (i == 25)
						continue;
					if (i == 26)
						continue;
					if (i == 27)
						continue;
					if (i == 28)
						continue;
					if (i == 29)
						continue;
					if (i == 30)
						continue;
					if (i == 31)
						continue;
					playerIn.getInventory().placeItemBackInInventory(ItemUtil.getStack(internal, i));
					setItemInSlot(i, ItemResource.EMPTY, 0);
				}
			}
		}
	}

	@Override
	public Map<Integer, Slot> getSlots() {
		return Collections.unmodifiableMap(customSlots);
	}

	@Override
	public Map<String, Object> getMenuState() {
		return menuState;
	}
}
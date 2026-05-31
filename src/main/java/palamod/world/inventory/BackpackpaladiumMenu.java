package palamod.world.inventory;

import palamod.procedures.Lasecu2conbackpackguiProcedure;
import palamod.procedures.BackpackwriteitemProcedure;

import palamod.init.PalamodModMenus;

import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.neoforged.neoforge.transfer.item.VanillaContainerWrapper;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

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

@EventBusSubscriber
public class BackpackpaladiumMenu extends AbstractContainerMenu implements PalamodModMenus.MenuAccessor {
	public final Map<String, Object> menuState = new HashMap<>() {
		@Override
		public Object put(String key, Object value) {
			if (!this.containsKey(key) && this.size() >= 58)
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

	public BackpackpaladiumMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(PalamodModMenus.BACKPACKPALADIUM.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStacksResourceHandler(55);
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
		this.customSlots.put(0, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 0, 10, 15) {
			private final int slot = 0;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(1, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 1, 28, 15) {
			private final int slot = 1;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(2, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 2, 46, 15) {
			private final int slot = 2;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(3, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 3, 64, 15) {
			private final int slot = 3;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(4, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 4, 82, 15) {
			private final int slot = 4;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(5, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 5, 100, 15) {
			private final int slot = 5;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(6, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 6, 118, 15) {
			private final int slot = 6;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(7, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 7, 136, 15) {
			private final int slot = 7;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(8, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 8, 154, 15) {
			private final int slot = 8;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(9, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 9, 172, 15) {
			private final int slot = 9;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(10, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 10, 190, 15) {
			private final int slot = 10;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(11, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 11, 10, 33) {
			private final int slot = 11;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(12, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 12, 28, 33) {
			private final int slot = 12;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(13, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 13, 46, 33) {
			private final int slot = 13;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(14, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 14, 64, 33) {
			private final int slot = 14;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(15, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 15, 82, 33) {
			private final int slot = 15;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(16, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 16, 100, 33) {
			private final int slot = 16;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(17, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 17, 118, 33) {
			private final int slot = 17;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(18, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 18, 136, 33) {
			private final int slot = 18;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(19, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 19, 154, 33) {
			private final int slot = 19;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(20, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 20, 172, 33) {
			private final int slot = 20;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(21, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 21, 190, 33) {
			private final int slot = 21;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(22, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 22, 10, 51) {
			private final int slot = 22;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(23, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 23, 28, 51) {
			private final int slot = 23;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(24, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 24, 46, 51) {
			private final int slot = 24;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(25, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 25, 64, 51) {
			private final int slot = 25;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(26, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 26, 82, 51) {
			private final int slot = 26;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(27, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 27, 100, 51) {
			private final int slot = 27;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(28, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 28, 118, 51) {
			private final int slot = 28;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(29, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 29, 136, 51) {
			private final int slot = 29;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(30, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 30, 154, 51) {
			private final int slot = 30;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(31, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 31, 172, 51) {
			private final int slot = 31;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(32, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 32, 190, 51) {
			private final int slot = 32;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(33, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 33, 10, 69) {
			private final int slot = 33;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(34, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 34, 28, 69) {
			private final int slot = 34;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(35, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 35, 46, 69) {
			private final int slot = 35;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(36, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 36, 64, 69) {
			private final int slot = 36;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(37, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 37, 82, 69) {
			private final int slot = 37;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(38, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 38, 100, 69) {
			private final int slot = 38;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(39, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 39, 118, 69) {
			private final int slot = 39;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(40, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 40, 136, 69) {
			private final int slot = 40;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(41, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 41, 154, 69) {
			private final int slot = 41;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(42, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 42, 172, 69) {
			private final int slot = 42;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(43, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 43, 190, 69) {
			private final int slot = 43;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(44, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 44, 10, 87) {
			private final int slot = 44;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(45, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 45, 28, 87) {
			private final int slot = 45;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(46, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 46, 46, 87) {
			private final int slot = 46;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(47, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 47, 64, 87) {
			private final int slot = 47;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(48, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 48, 82, 87) {
			private final int slot = 48;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(49, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 49, 100, 87) {
			private final int slot = 49;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(50, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 50, 118, 87) {
			private final int slot = 50;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(51, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 51, 136, 87) {
			private final int slot = 51;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(52, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 52, 154, 87) {
			private final int slot = 52;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(53, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 53, 172, 87) {
			private final int slot = 53;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		this.customSlots.put(54, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 54, 190, 87) {
			private final int slot = 54;
			private int x = BackpackpaladiumMenu.this.x;
			private int y = BackpackpaladiumMenu.this.y;
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 20 + 8 + sj * 18, 35 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 20 + 8 + si * 18, 35 + 142));
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
			if (index < 55) {
				if (!this.moveItemStackTo(itemstack1, 55, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 55, false)) {
				if (index < 55 + 27) {
					if (!this.moveItemStackTo(itemstack1, 55 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 55, 55 + 27, false))
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
		BackpackwriteitemProcedure.execute(world, entity);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.size(); ++j) {
					playerIn.drop(ItemUtil.getStack(internal, j), false);
					setItemInSlot(j, ItemResource.EMPTY, 0);
				}
			} else {
				for (int i = 0; i < internal.size(); ++i) {
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

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player entity = event.getEntity();
		if (entity.containerMenu instanceof BackpackpaladiumMenu menu) {
			Level world = menu.world;
			double x = menu.x;
			double y = menu.y;
			double z = menu.z;
			Lasecu2conbackpackguiProcedure.execute(world, entity);
		}
	}
}
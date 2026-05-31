package palamod.world.inventory;

import palamod.procedures.PaladiumchestguiQuandLeGUIEstFermeProcedure;
import palamod.procedures.PaladiumchestLorsDunClicDroitSurLeBlocProcedure;

import palamod.network.PaladiumchestguiSlotMessage;

import palamod.init.PalamodModMenus;

import net.neoforged.neoforge.transfer.transaction.Transaction;
import net.neoforged.neoforge.transfer.item.VanillaContainerWrapper;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;
import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemStacksResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.access.ItemAccess;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.event.entity.player.PlayerContainerEvent;
import net.neoforged.neoforge.client.network.ClientPacketDistributor;
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
public class PaladiumchestguiMenu extends AbstractContainerMenu implements PalamodModMenus.MenuAccessor {
	public final Map<String, Object> menuState = new HashMap<>() {
		@Override
		public Object put(String key, Object value) {
			if (!this.containsKey(key) && this.size() >= 120)
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

	public PaladiumchestguiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(PalamodModMenus.PALADIUMCHESTGUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStacksResourceHandler(112);
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
		this.customSlots.put(0, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 0, 32, 4) {
			private final int slot = 0;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(0, 0, 0);
			}
		}));
		this.customSlots.put(1, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 1, 50, 4) {
			private final int slot = 1;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(1, 0, 0);
			}
		}));
		this.customSlots.put(2, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 2, 68, 4) {
			private final int slot = 2;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(2, 0, 0);
			}
		}));
		this.customSlots.put(3, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 3, 86, 4) {
			private final int slot = 3;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(3, 0, 0);
			}
		}));
		this.customSlots.put(4, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 4, 122, 4) {
			private final int slot = 4;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(4, 0, 0);
			}
		}));
		this.customSlots.put(5, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 5, 104, 4) {
			private final int slot = 5;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(5, 0, 0);
			}
		}));
		this.customSlots.put(6, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 6, 140, 4) {
			private final int slot = 6;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(6, 0, 0);
			}
		}));
		this.customSlots.put(7, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 7, 158, 4) {
			private final int slot = 7;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(7, 0, 0);
			}
		}));
		this.customSlots.put(8, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 8, 176, 4) {
			private final int slot = 8;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(8, 0, 0);
			}
		}));
		this.customSlots.put(9, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 9, 194, 4) {
			private final int slot = 9;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(9, 0, 0);
			}
		}));
		this.customSlots.put(10, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 10, 212, 4) {
			private final int slot = 10;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(10, 0, 0);
			}
		}));
		this.customSlots.put(11, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 11, 230, 4) {
			private final int slot = 11;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(11, 0, 0);
			}
		}));
		this.customSlots.put(14, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 14, 32, 22) {
			private final int slot = 14;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(15, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 15, 50, 22) {
			private final int slot = 15;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(16, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 16, 68, 22) {
			private final int slot = 16;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(17, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 17, 86, 22) {
			private final int slot = 17;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(18, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 18, 104, 22) {
			private final int slot = 18;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(19, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 19, 122, 22) {
			private final int slot = 19;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(20, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 20, 140, 22) {
			private final int slot = 20;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(21, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 21, 158, 22) {
			private final int slot = 21;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(22, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 22, 176, 22) {
			private final int slot = 22;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(23, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 23, 194, 22) {
			private final int slot = 23;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(24, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 24, 212, 22) {
			private final int slot = 24;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(25, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 25, 230, 22) {
			private final int slot = 25;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(26, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 26, 32, 40) {
			private final int slot = 26;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(27, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 27, 50, 40) {
			private final int slot = 27;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(28, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 28, 68, 40) {
			private final int slot = 28;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(29, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 29, 86, 40) {
			private final int slot = 29;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(30, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 30, 104, 40) {
			private final int slot = 30;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(31, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 31, 122, 40) {
			private final int slot = 31;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(32, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 32, 140, 40) {
			private final int slot = 32;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(33, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 33, 158, 40) {
			private final int slot = 33;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(34, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 34, 176, 40) {
			private final int slot = 34;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(35, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 35, 194, 40) {
			private final int slot = 35;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(36, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 36, 212, 40) {
			private final int slot = 36;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(37, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 37, 230, 40) {
			private final int slot = 37;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(38, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 38, 32, 58) {
			private final int slot = 38;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(39, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 39, 50, 58) {
			private final int slot = 39;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(40, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 40, 68, 58) {
			private final int slot = 40;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(41, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 41, 86, 58) {
			private final int slot = 41;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(42, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 42, 104, 58) {
			private final int slot = 42;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(43, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 43, 122, 58) {
			private final int slot = 43;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(44, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 44, 140, 58) {
			private final int slot = 44;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(45, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 45, 158, 58) {
			private final int slot = 45;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(46, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 46, 176, 58) {
			private final int slot = 46;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(47, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 47, 194, 58) {
			private final int slot = 47;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(48, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 48, 212, 58) {
			private final int slot = 48;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(49, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 49, 230, 58) {
			private final int slot = 49;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(50, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 50, 32, 76) {
			private final int slot = 50;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(51, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 51, 50, 76) {
			private final int slot = 51;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(52, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 52, 68, 76) {
			private final int slot = 52;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(53, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 53, 86, 76) {
			private final int slot = 53;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(54, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 54, 104, 76) {
			private final int slot = 54;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(55, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 55, 122, 76) {
			private final int slot = 55;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(56, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 56, 140, 76) {
			private final int slot = 56;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(57, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 57, 158, 76) {
			private final int slot = 57;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(58, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 58, 176, 76) {
			private final int slot = 58;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(59, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 59, 194, 76) {
			private final int slot = 59;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(60, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 60, 212, 76) {
			private final int slot = 60;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(61, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 61, 230, 76) {
			private final int slot = 61;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(62, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 62, 32, 94) {
			private final int slot = 62;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(63, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 63, 50, 94) {
			private final int slot = 63;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(64, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 64, 68, 94) {
			private final int slot = 64;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(65, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 65, 86, 94) {
			private final int slot = 65;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(66, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 66, 104, 94) {
			private final int slot = 66;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(67, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 67, 122, 94) {
			private final int slot = 67;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(68, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 68, 140, 94) {
			private final int slot = 68;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(69, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 69, 158, 94) {
			private final int slot = 69;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(70, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 70, 176, 94) {
			private final int slot = 70;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(71, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 71, 194, 94) {
			private final int slot = 71;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(72, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 72, 212, 94) {
			private final int slot = 72;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(73, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 73, 230, 94) {
			private final int slot = 73;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(74, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 74, 32, 112) {
			private final int slot = 74;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(75, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 75, 50, 112) {
			private final int slot = 75;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(76, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 76, 68, 112) {
			private final int slot = 76;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(77, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 77, 86, 112) {
			private final int slot = 77;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(78, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 78, 104, 112) {
			private final int slot = 78;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(79, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 79, 122, 112) {
			private final int slot = 79;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(80, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 80, 140, 112) {
			private final int slot = 80;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(81, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 81, 158, 112) {
			private final int slot = 81;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(82, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 82, 176, 112) {
			private final int slot = 82;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(83, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 83, 194, 112) {
			private final int slot = 83;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(84, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 84, 212, 112) {
			private final int slot = 84;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(85, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 85, 230, 112) {
			private final int slot = 85;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(86, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 86, 14, 76) {
			private final int slot = 86;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(87, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 87, 14, 22) {
			private final int slot = 87;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(88, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 88, 14, 40) {
			private final int slot = 88;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(89, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 89, 14, 58) {
			private final int slot = 89;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(90, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 90, 14, 94) {
			private final int slot = 90;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(91, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 91, 14, 112) {
			private final int slot = 91;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(92, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 92, 248, 22) {
			private final int slot = 92;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(93, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 93, 248, 40) {
			private final int slot = 93;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(94, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 94, 248, 58) {
			private final int slot = 94;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(95, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 95, 248, 76) {
			private final int slot = 95;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(96, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 96, 248, 94) {
			private final int slot = 96;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(97, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 97, 248, 112) {
			private final int slot = 97;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(98, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 98, 266, 22) {
			private final int slot = 98;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(99, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 99, 266, 40) {
			private final int slot = 99;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(100, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 100, 266, 58) {
			private final int slot = 100;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(101, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 101, 266, 76) {
			private final int slot = 101;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(102, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 102, 266, 94) {
			private final int slot = 102;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(103, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 103, 266, 112) {
			private final int slot = 103;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(104, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 104, 284, 22) {
			private final int slot = 104;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(105, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 105, 284, 40) {
			private final int slot = 105;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(106, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 106, 284, 58) {
			private final int slot = 106;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(107, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 107, 284, 76) {
			private final int slot = 107;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(108, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 108, 284, 94) {
			private final int slot = 108;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(109, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 109, 284, 112) {
			private final int slot = 109;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;

			@Override
			protected void setStackCopy(ItemStack stack) {
				super.setStackCopy(stack);
				slotChanged(109, 0, 0);
			}
		}));
		this.customSlots.put(110, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 110, 270, 163) {
			private final int slot = 110;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(111, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 111, 270, 181) {
			private final int slot = 111;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(12, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 12, 252, 163) {
			private final int slot = 12;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		this.customSlots.put(13, this.addSlot(new ResourceHandlerSlot(internal, this::setItemInSlot, 13, 252, 181) {
			private final int slot = 13;
			private int x = PaladiumchestguiMenu.this.x;
			private int y = PaladiumchestguiMenu.this.y;
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 65 + 8 + sj * 18, 60 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 65 + 8 + si * 18, 60 + 142));
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
			if (index < 112) {
				if (!this.moveItemStackTo(itemstack1, 112, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 112, false)) {
				if (index < 112 + 27) {
					if (!this.moveItemStackTo(itemstack1, 112 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 112, 112 + 27, false))
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
		PaladiumchestguiQuandLeGUIEstFermeProcedure.execute(world, x, y, z, entity);
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

	private void slotChanged(int slotid, int ctype, int meta) {
		if (this.world != null && this.world.isClientSide()) {
			ClientPacketDistributor.sendToServer(new PaladiumchestguiSlotMessage(slotid, x, y, z, ctype, meta));
			PaladiumchestguiSlotMessage.handleSlotAction(entity, slotid, ctype, meta, x, y, z);
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
	public static void onContainerOpen(PlayerContainerEvent.Open event) {
		Player entity = event.getEntity();
		if (event.getContainer() instanceof PaladiumchestguiMenu menu) {
			Level world = menu.world;
			double x = menu.x;
			double y = menu.y;
			double z = menu.z;
			PaladiumchestLorsDunClicDroitSurLeBlocProcedure.execute(world, x, y, z, entity);
		}
	}
}
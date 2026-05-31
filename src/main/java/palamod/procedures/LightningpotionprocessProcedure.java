package palamod.procedures;

import palamod.init.PalamodModItems;

import net.neoforged.neoforge.transfer.item.ItemUtil;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.event.entity.EntityStruckByLightningEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import javax.annotation.Nullable;

@EventBusSubscriber
public class LightningpotionprocessProcedure {
	@SubscribeEvent
	public static void onEntityStruckByLightning(EntityStruckByLightningEvent event) {
		execute(event, event.getEntity().level(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((Items.GOLDEN_HELMET == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()
				|| Items.IRON_HELMET == (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem()) && (entity instanceof Player || entity instanceof ServerPlayer)) {
			if (entity.getCapability(Capabilities.Item.ENTITY, null) instanceof ResourceHandler<ItemResource> _resourceHandler) {
				for (int _idx = 0; _idx < _resourceHandler.size(); _idx++) {
					ItemStack itemstackiterator = ItemUtil.getStack(_resourceHandler, _idx);
					if (Items.GLASS_BOTTLE == itemstackiterator.getItem()) {
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Items.GLASS_BOTTLE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
						if (entity instanceof Player _player) {
							ItemStack _setstack = new ItemStack(PalamodModItems.LIGHTNING_POTION.get()).copy();
							_setstack.setCount(1);
							_player.getInventory().placeItemBackInInventory(_setstack);
						}
						(entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
								.setDamageValue((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getDamageValue() + 1);
					}
				}
			}
		}
	}
}
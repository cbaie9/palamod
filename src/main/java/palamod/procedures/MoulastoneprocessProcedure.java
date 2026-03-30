package palamod.procedures;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class MoulastoneprocessProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		File jobs = new File("");
		File money = new File("");
		double count = 0;
		double lvl = 0;
		double money_old = 0;
		money = new File((FMLPaths.GAMEDIR.get().toString() + "/serverconfig/palamod/money/"), File.separator + (entity.getUUID().toString() + ".json"));
		if (money.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(money));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					money_old = main.get("money").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (itemstack.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getBooleanOr("powered", false) == true) {
<<<<<<< Updated upstream
				for (int index0 = 0; index0 < 64; index0++) {
					if (hasEntityInInventory(entity, new ItemStack(Blocks.DEEPSLATE))) {
						count = count + 0.15;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.DEEPSLATE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
=======
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
					for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("palamod:cobblebreakable"))) || itemstackiterator.is(ItemTags.create(ResourceLocation.parse("c:stone")))) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = itemstackiterator;
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
							}
							count = count + 0.15;
>>>>>>> Stashed changes
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.COBBLED_DEEPSLATE))) {
						count = count + 0.1;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.COBBLED_DEEPSLATE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.STONE))) {
						count = count + 0.15;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.STONE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.COBBLESTONE))) {
						count = count + 0.1;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.COBBLESTONE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.GRANITE))) {
						count = count + 0.125;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.GRANITE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.DIORITE))) {
						count = count + 0.125;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.DIORITE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.ANDESITE))) {
						count = count + 0.125;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.ANDESITE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.BLACKSTONE))) {
						count = count + 0.5;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.BLACKSTONE);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.BASALT))) {
						count = count + 0.5;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.BASALT);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.NETHERRACK))) {
						count = count + 0.125;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.NETHERRACK);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.SOUL_SOIL))) {
						count = count + 0.5;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.SOUL_SOIL);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.SOUL_SAND))) {
						count = count + 0.5;
						if (entity instanceof Player _player) {
							ItemStack _stktoremove = new ItemStack(Blocks.SOUL_SAND);
							_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
						}
					}
					if (hasEntityInInventory(entity, new ItemStack(Blocks.STONE)) || hasEntityInInventory(entity, new ItemStack(Blocks.COBBLESTONE)) || hasEntityInInventory(entity, new ItemStack(Blocks.GRANITE))
							|| hasEntityInInventory(entity, new ItemStack(Blocks.DIORITE)) || hasEntityInInventory(entity, new ItemStack(Blocks.ANDESITE)) || hasEntityInInventory(entity, new ItemStack(Blocks.BLACKSTONE))
							|| hasEntityInInventory(entity, new ItemStack(Blocks.BASALT)) || hasEntityInInventory(entity, new ItemStack(Blocks.COBBLED_DEEPSLATE)) || hasEntityInInventory(entity, new ItemStack(Blocks.DEEPSLATE))
							|| hasEntityInInventory(entity, new ItemStack(Blocks.SOUL_SAND)) || hasEntityInInventory(entity, new ItemStack(Blocks.SOUL_SOIL)) || hasEntityInInventory(entity, new ItemStack(Blocks.NETHERRACK))) {
						continue;
					} else {
						break;
					}
				}
				main.addProperty("money", (money_old + count));
				{
					com.google.gson.Gson mainGSONBuilderVariable = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
					try {
						FileWriter fileWriter = new FileWriter(money);
						fileWriter.write(mainGSONBuilderVariable.toJson(main));
						fileWriter.close();
					} catch (IOException exception) {
						exception.printStackTrace();
					}
				}
			}
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}
package palamod.procedures;

import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.component.DataComponents;

import java.io.IOException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

public class MoulastoneprocessProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
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
				if (entity.getCapability(Capabilities.ItemHandler.ENTITY, null) instanceof IItemHandlerModifiable _modHandlerIter) {
					for (int _idx = 0; _idx < _modHandlerIter.getSlots(); _idx++) {
						ItemStack itemstackiterator = _modHandlerIter.getStackInSlot(_idx).copy();
						if (itemstackiterator.is(ItemTags.create(ResourceLocation.parse("palamod:cobblebreakable"))) || itemstackiterator.is(ItemTags.create(ResourceLocation.parse("c:stone")))) {
							if (entity instanceof Player _player) {
								ItemStack _stktoremove = itemstackiterator;
								_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), itemstackiterator.getCount(), _player.inventoryMenu.getCraftSlots());
							}
							count = count + 0.15;
						}
						if (hasEntityInInventory(entity, new ItemStack(Blocks.STONE)) || hasEntityInInventory(entity, new ItemStack(Blocks.COBBLESTONE)) || hasEntityInInventory(entity, new ItemStack(Blocks.GRANITE))
								|| hasEntityInInventory(entity, new ItemStack(Blocks.DIORITE)) || hasEntityInInventory(entity, new ItemStack(Blocks.ANDESITE)) || hasEntityInInventory(entity, new ItemStack(Blocks.BLACKSTONE))
								|| hasEntityInInventory(entity, new ItemStack(Blocks.BASALT)) || hasEntityInInventory(entity, new ItemStack(Blocks.COBBLED_DEEPSLATE)) || hasEntityInInventory(entity, new ItemStack(Blocks.DEEPSLATE))
								|| hasEntityInInventory(entity, new ItemStack(Blocks.SOUL_SAND)) || hasEntityInInventory(entity, new ItemStack(Blocks.SOUL_SOIL)) || hasEntityInInventory(entity, new ItemStack(Blocks.TUFF))
								|| hasEntityInInventory(entity, new ItemStack(Blocks.NETHERRACK))) {
							continue;
						} else {
							break;
						}
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
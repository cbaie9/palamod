package palamod.procedures;

import palamod.world.inventory.BackpacktitaneMenu;
import palamod.world.inventory.BackpackpaladiumMenu;
import palamod.world.inventory.BackpackendiumMenu;
import palamod.world.inventory.BackpackamethystguiMenu;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModGameRules;

import net.neoforged.neoforge.server.ServerLifecycleHooks;
import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import java.io.IOException;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;

import io.netty.buffer.Unpooled;

public class OpenbackpackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		com.google.gson.JsonObject main_jobs = new com.google.gson.JsonObject();
		File backpack_backup = new File("");
		File backpack = new File("");
		File jobs = new File("");
		File backpack_titane = new File("");
		File backpack_endium = new File("");
		File backpack_paladium = new File("");
		boolean is_lunching = false;
		double i2 = 0;
		double i = 0;
		double ifull_backup = 0;
		double checksum_now = 0;
		double lvl = 0;
		backpack_backup = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\"
				+ (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName()) + "\\backpack\\" + entity.getUUID().toString()),
				File.separator + "backup.json");
		jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\saves\\" + (world.isClientSide() ? Minecraft.getInstance().getSingleplayerServer().getWorldData().getLevelName() : ServerLifecycleHooks.getCurrentServer().getWorldData().getLevelName())
				+ "\\jobs\\" + entity.getUUID().toString()), File.separator + "jobs.json");
		if (jobs.exists()) {
			{
				try {
					BufferedReader bufferedReader = new BufferedReader(new FileReader(jobs));
					StringBuilder jsonstringbuilder = new StringBuilder();
					String line;
					while ((line = bufferedReader.readLine()) != null) {
						jsonstringbuilder.append(line);
					}
					bufferedReader.close();
					main_jobs = new com.google.gson.Gson().fromJson(jsonstringbuilder.toString(), com.google.gson.JsonObject.class);
					lvl = main_jobs.get("lvl_farmer").getAsDouble();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (PalamodModItems.AMETHYST_BACKPACK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				if (35 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDUSE)) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Backpackamethystgui");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new BackpackamethystguiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
					is_lunching = true;
					BackpackloaditemProcedure.execute(world, entity);
				} else {
					is_lunching = false;
					MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
				}
			} else if (PalamodModItems.TITANE_BACKPACK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				if (53 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDUSE)) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Backpacktitane");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new BackpacktitaneMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
					BackpackloaditemProcedure.execute(world, entity);
					is_lunching = true;
				} else {
					is_lunching = false;
					MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
				}
			} else if (PalamodModItems.PALADUM_BACKPACK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				if (70 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDUSE)) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Backpackpaladium");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new BackpackpaladiumMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
					BackpackloaditemProcedure.execute(world, entity);
					is_lunching = true;
				} else {
					is_lunching = false;
					MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
				}
			} else if (PalamodModItems.ENDIUM_BACKPACK.get() == (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem()) {
				if (100 <= lvl || !world.getLevelData().getGameRules().getBoolean(PalamodModGameRules.LOCKEDUSE)) {
					if (entity instanceof ServerPlayer _ent) {
						BlockPos _bpos = BlockPos.containing(x, y, z);
						_ent.openMenu(new MenuProvider() {
							@Override
							public Component getDisplayName() {
								return Component.literal("Backpackendium");
							}

							@Override
							public boolean shouldTriggerClientSideContainerClosingOnOpen() {
								return false;
							}

							@Override
							public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
								return new BackpackendiumMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
					BackpackloaditemProcedure.execute(world, entity);
					is_lunching = true;
				} else {
					is_lunching = false;
					MsgdonthavetherequiredlvlProcedure.execute(world, x, y, z, entity);
				}
			} else {
				is_lunching = false;
			}
		}
	}
}

package palamod.procedures;

import palamod.PalamodMod;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.zip.ZipInputStream;
import java.util.zip.ZipEntry;
import java.util.Calendar;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;
import java.io.BufferedOutputStream;

public class BackuploadconfigProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double lvl = 0;
		File jobs = new File("");
		if (entity.hasPermissions(4)) {
			jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\backup\\palamod\\config\\backup-" + new java.text.SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) + ".zip"));
			try {
				new Object() {
					public static void unzipFile(File fileToUnzip, String destDir) throws IOException {
						File _dir = new File(destDir);
						if (!_dir.exists())
							_dir.mkdirs();
						try (ZipInputStream _zipIn = new ZipInputStream(new FileInputStream(fileToUnzip))) {
							ZipEntry _entry = _zipIn.getNextEntry();
							while (_entry != null) {
								String filePath = destDir + File.separator + _entry.getName();
								if (!_entry.isDirectory())
									extractFile(_zipIn, filePath);
								else
									new File(filePath).mkdirs();
								_zipIn.closeEntry();
								_entry = _zipIn.getNextEntry();
							}
						}
					}

					private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
						try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
							byte[] bytesIn = new byte[4096];
							int read;
							while ((read = zipIn.read(bytesIn)) != -1)
								bos.write(bytesIn, 0, read);
						}
					}
				}.unzipFile(jobs, (FMLPaths.GAMEDIR.get().toString() + "\\serverconfig\\palamod\\"));
			} catch (IOException e) {
				PalamodMod.LOGGER.error(e);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("The configuration had been loaded into the server ; Wrongfull configuration can cause mod to malfunction" + FMLPaths.GAMEDIR.get().toString() + "\\backup\\palamod\\config\\backup-"
						+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) + ".zip")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You do not have the required permission to do that command, please call your administrator if you want go further"), false);
		}
	}
}

package palamod.procedures;

import palamod.PalamodMod;

import net.neoforged.fml.loading.FMLPaths;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import java.util.zip.ZipOutputStream;
import java.util.zip.ZipEntry;
import java.util.Calendar;

import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.File;

public class BackupconfigProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		com.google.gson.JsonObject main = new com.google.gson.JsonObject();
		double lvl = 0;
		File jobs = new File("");
		if (entity.hasPermissions(4)) {
			jobs = new File((FMLPaths.GAMEDIR.get().toString() + "\\serverconfig\\palamod\\"));
			if (jobs.exists() && jobs.isDirectory()) {
				try {
					FileOutputStream _fos = new FileOutputStream((FMLPaths.GAMEDIR.get().toString() + "\\backup\\palamod\\config\\backup-" + new java.text.SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) + ".zip"));
					ZipOutputStream _zipOut = new ZipOutputStream(_fos);
					new Object() {
						public static void zipFile(File fileToZip, String fileName, ZipOutputStream zipOut) throws IOException {
							if (fileToZip.isHidden())
								return;
							if (fileToZip.isDirectory()) {
								if (fileName.endsWith("/")) {
									zipOut.putNextEntry(new ZipEntry(fileName));
									zipOut.closeEntry();
								} else {
									zipOut.putNextEntry(new ZipEntry(fileName + "/"));
									zipOut.closeEntry();
								}
								File[] children = fileToZip.listFiles();
								for (File childFile : children)
									zipFile(childFile, fileName + "/" + childFile.getName(), zipOut);
								return;
							}
							FileInputStream fis = new FileInputStream(fileToZip);
							ZipEntry zipEntry = new ZipEntry(fileName);
							zipOut.putNextEntry(zipEntry);
							byte[] bytes = new byte[1024];
							int length;
							while ((length = fis.read(bytes)) >= 0)
								zipOut.write(bytes, 0, length);
							fis.close();
						}
					}.zipFile(jobs, jobs.getName(), _zipOut);
					_zipOut.close();
					_fos.close();
				} catch (IOException e) {
					PalamodMod.LOGGER.error(e);
				}
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal(("The configuration had been archived at the following location on the server :" + FMLPaths.GAMEDIR.get().toString() + "\\backup\\palamod\\config\\backup-"
						+ new java.text.SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()) + ".zip")), false);
		} else {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("You do not have the required permission to do that command, please call your administrator if you want go further"), false);
		}
	}
}

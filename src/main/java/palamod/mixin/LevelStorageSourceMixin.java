package palamod.mixin;

import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.nbt.NbtAccounter;

@Mixin(LevelStorageSource.class)
public class LevelStorageSourceMixin {
	@ModifyArg(method = "readExistingSavedData", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/NbtIo;readCompressed(Ljava/nio/file/Path;Lnet/minecraft/nbt/NbtAccounter;)Lnet/minecraft/nbt/CompoundTag;"), index = 1)
	private static NbtAccounter increaseSavedDataQuota(NbtAccounter originalAccounter) {
		return NbtAccounter.uncompressedQuota();
	}
}
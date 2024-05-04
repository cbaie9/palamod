package palamod.procedures;

import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import java.util.HashMap;

public class PhonecodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmluckyphone"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("palamod:achmluckyphone"));
				AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
				if (!_ap.isDone()) {
					for (String criteria : _ap.getRemainingCriteria())
						_player.getAdvancements().award(_adv, criteria);
				}
			}
		}
		if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("cbaie9")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("cb9")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("4009")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModBlocks.FAKE_PALADIUM_ORE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			entity.hurt(new DamageSource(world.registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolderOrThrow(DamageTypes.GENERIC)), 1);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Combocircle")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("CombocircleZ")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Combocircle123")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("CombocircleZ123")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("msg @s an cheater has been detected"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("reset.gamemode")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("reset.gamemode has been succesful executed You now in gamemode survival"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Wolfen")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("wolfen")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("cloclo")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Blocks.LIGHTNING_ROD).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Claud fran\u00E7ois vibes"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("jojo")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("wlf")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("jojo_xd30")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_SWORD.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("msg @p Jojo veut la mort de quelqu'un ici"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("fufu")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("fufuBS1")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("BS1")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Rejoins le serveur communautaire https://discord.gg/3J772jpRt2"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Hat")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("hat")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("HAT")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_2_HELMET.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Voila un chapeau Monsieur"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Arthurninja69800")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("arthurninja69800")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Arthurninja")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_PICKAXE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Eh ben maintenant tu peux aller miner des chose et se sera positif"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("help")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("/?")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("dir")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Paladium system program"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("dir : M:/"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Textures"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Crafts"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Codeultracheats2235.txt"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("open Codeultracheats2235.txt")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Paladium system program"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("dir : M:/Codeultracheats2235.txt"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("text file : Le code du cheats est "), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("0259.cf42214"), false);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("0259.cf42214")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Cheats Activated"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.LEGENDARY_STONE_POWER.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			new ItemStack(PalamodModItems.LEGENDARY_STONE_POWER.get()).setHoverName(Component.literal("Legudary diorite of unPower"));
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("alo")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("allo")) {
			if (Math.random() < 0.5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("a l'huile"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("a hopital"), false);
			}
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("zelda")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("1.0 vibes"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
				_setstack.setCount((int) ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() * 2));
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("NoHit")) {
			if (entity instanceof Player _player) {
				_player.getAbilities().invulnerable = false;
				_player.onUpdateAbilities();
			}
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Vid20513")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("discord_64Bg")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Merci de soutenir le mod"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(10);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("Cat")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("cat")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("CAT")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Miaou.....Ronron~"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Oh tiens un chat"), false);
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = EntityType.CAT.spawn(_level, BlockPos.containing(x, y, z), MobSpawnType.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			world.addParticle(ParticleTypes.HAPPY_VILLAGER, x, y, z, 0, 1, 0);
		} else if ((guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("punk")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("fac")
				|| (guistate.containsKey("text:cheat_code_secret") ? ((EditBox) guistate.get("text:cheat_code_secret")).getValue() : "").contains("punkastik")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Rejoins le serveur de la PunkAstik https://discord.gg[censored bc fdp]"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("( c'est ma fac )"), false);
		}
	}
}

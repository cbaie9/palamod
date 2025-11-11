package palamod.procedures;

import palamod.init.PalamodModMenus;
import palamod.init.PalamodModItems;
import palamod.init.PalamodModBlocks;

import net.neoforged.neoforge.items.ItemHandlerHelper;

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
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.AdvancementHolder;

public class PhonecodeProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof ServerPlayer _plr0 && _plr0.level() instanceof ServerLevel && _plr0.getAdvancements().getOrStartProgress(_plr0.server.getAdvancements().get(ResourceLocation.parse("palamod:achmluckyphone"))).isDone())) {
			if (entity instanceof ServerPlayer _player) {
				AdvancementHolder _adv = _player.server.getAdvancements().get(ResourceLocation.parse("palamod:achmluckyphone"));
				if (_adv != null) {
					AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
					if (!_ap.isDone()) {
						for (String criteria : _ap.getRemainingCriteria())
							_player.getAdvancements().award(_adv, criteria);
					}
				}
			}
		}
		if (((entity instanceof Player _entity2 && _entity2.containerMenu instanceof PalamodModMenus.MenuAccessor _menu2) ? _menu2.getMenuState(0, "cheat_code_secret", "") : "").contains("cbaie9")
				|| ((entity instanceof Player _entity3 && _entity3.containerMenu instanceof PalamodModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "cheat_code_secret", "") : "").contains("cb9")
				|| ((entity instanceof Player _entity4 && _entity4.containerMenu instanceof PalamodModMenus.MenuAccessor _menu4) ? _menu4.getMenuState(0, "cheat_code_secret", "") : "").contains("4009")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModBlocks.FAKE_PALADIUM_ORE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			entity.hurt(new DamageSource(world.holderOrThrow(DamageTypes.GENERIC)), 1);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if (((entity instanceof Player _entity9 && _entity9.containerMenu instanceof PalamodModMenus.MenuAccessor _menu9) ? _menu9.getMenuState(0, "cheat_code_secret", "") : "").contains("Combocircle")
				|| ((entity instanceof Player _entity10 && _entity10.containerMenu instanceof PalamodModMenus.MenuAccessor _menu10) ? _menu10.getMenuState(0, "cheat_code_secret", "") : "").contains("CombocircleZ")
				|| ((entity instanceof Player _entity11 && _entity11.containerMenu instanceof PalamodModMenus.MenuAccessor _menu11) ? _menu11.getMenuState(0, "cheat_code_secret", "") : "").contains("Combocircle123")
				|| ((entity instanceof Player _entity12 && _entity12.containerMenu instanceof PalamodModMenus.MenuAccessor _menu12) ? _menu12.getMenuState(0, "cheat_code_secret", "") : "").contains("CombocircleZ123")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.ADVENTURE);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("msg @s an cheater has been detected"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if (((entity instanceof Player _entity16 && _entity16.containerMenu instanceof PalamodModMenus.MenuAccessor _menu16) ? _menu16.getMenuState(0, "cheat_code_secret", "") : "").contains("reset.gamemode")) {
			if (entity instanceof ServerPlayer _player)
				_player.setGameMode(GameType.SURVIVAL);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("reset.gamemode has been succesful executed You now in gamemode survival"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if (((entity instanceof Player _entity20 && _entity20.containerMenu instanceof PalamodModMenus.MenuAccessor _menu20) ? _menu20.getMenuState(0, "cheat_code_secret", "") : "").contains("Wolfen")
				|| ((entity instanceof Player _entity21 && _entity21.containerMenu instanceof PalamodModMenus.MenuAccessor _menu21) ? _menu21.getMenuState(0, "cheat_code_secret", "") : "").contains("wolfen")
				|| ((entity instanceof Player _entity22 && _entity22.containerMenu instanceof PalamodModMenus.MenuAccessor _menu22) ? _menu22.getMenuState(0, "cheat_code_secret", "") : "").contains("cloclo")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(Blocks.LIGHTNING_ROD).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Claud fran\u00E7ois vibes"), false);
			if (entity instanceof Player _player)
				_player.closeContainer();
		} else if (((entity instanceof Player _entity26 && _entity26.containerMenu instanceof PalamodModMenus.MenuAccessor _menu26) ? _menu26.getMenuState(0, "cheat_code_secret", "") : "").contains("jojo")
				|| ((entity instanceof Player _entity27 && _entity27.containerMenu instanceof PalamodModMenus.MenuAccessor _menu27) ? _menu27.getMenuState(0, "cheat_code_secret", "") : "").contains("wlf")
				|| ((entity instanceof Player _entity28 && _entity28.containerMenu instanceof PalamodModMenus.MenuAccessor _menu28) ? _menu28.getMenuState(0, "cheat_code_secret", "") : "").contains("jojo_xd30")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_SWORD.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("msg @p Jojo veut la mort de quelqu'un ici"), false);
		} else if (((entity instanceof Player _entity31 && _entity31.containerMenu instanceof PalamodModMenus.MenuAccessor _menu31) ? _menu31.getMenuState(0, "cheat_code_secret", "") : "").contains("fufu")
				|| ((entity instanceof Player _entity32 && _entity32.containerMenu instanceof PalamodModMenus.MenuAccessor _menu32) ? _menu32.getMenuState(0, "cheat_code_secret", "") : "").contains("fufuBS1")
				|| ((entity instanceof Player _entity33 && _entity33.containerMenu instanceof PalamodModMenus.MenuAccessor _menu33) ? _menu33.getMenuState(0, "cheat_code_secret", "") : "").contains("BS1")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Rejoins le serveur communautaire https://discord.gg/3J772jpRt2"), false);
		} else if (((entity instanceof Player _entity35 && _entity35.containerMenu instanceof PalamodModMenus.MenuAccessor _menu35) ? _menu35.getMenuState(0, "cheat_code_secret", "") : "").contains("Hat")
				|| ((entity instanceof Player _entity36 && _entity36.containerMenu instanceof PalamodModMenus.MenuAccessor _menu36) ? _menu36.getMenuState(0, "cheat_code_secret", "") : "").contains("hat")
				|| ((entity instanceof Player _entity37 && _entity37.containerMenu instanceof PalamodModMenus.MenuAccessor _menu37) ? _menu37.getMenuState(0, "cheat_code_secret", "") : "").contains("HAT")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUMARMORCUSTOM_2_HELMET.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Voila un chapeau Monsieur"), false);
		} else if (((entity instanceof Player _entity40 && _entity40.containerMenu instanceof PalamodModMenus.MenuAccessor _menu40) ? _menu40.getMenuState(0, "cheat_code_secret", "") : "").contains("Arthurninja69800")
				|| ((entity instanceof Player _entity41 && _entity41.containerMenu instanceof PalamodModMenus.MenuAccessor _menu41) ? _menu41.getMenuState(0, "cheat_code_secret", "") : "").contains("arthurninja69800")
				|| ((entity instanceof Player _entity42 && _entity42.containerMenu instanceof PalamodModMenus.MenuAccessor _menu42) ? _menu42.getMenuState(0, "cheat_code_secret", "") : "").contains("Arthurninja")) {
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.PALADIUM_PICKAXE.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Eh ben maintenant tu peux aller miner des chose et se sera positif"), false);
		} else if (((entity instanceof Player _entity45 && _entity45.containerMenu instanceof PalamodModMenus.MenuAccessor _menu45) ? _menu45.getMenuState(0, "cheat_code_secret", "") : "").contains("help")
				|| ((entity instanceof Player _entity46 && _entity46.containerMenu instanceof PalamodModMenus.MenuAccessor _menu46) ? _menu46.getMenuState(0, "cheat_code_secret", "") : "").contains("/?")
				|| ((entity instanceof Player _entity47 && _entity47.containerMenu instanceof PalamodModMenus.MenuAccessor _menu47) ? _menu47.getMenuState(0, "cheat_code_secret", "") : "").contains("dir")) {
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
		} else if (((entity instanceof Player _entity53 && _entity53.containerMenu instanceof PalamodModMenus.MenuAccessor _menu53) ? _menu53.getMenuState(0, "cheat_code_secret", "") : "").contains("open Codeultracheats2235.txt")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Paladium system program"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("dir : M:/Codeultracheats2235.txt"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("text file : Le code du cheats est "), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("0259.cf42214"), false);
		} else if (((entity instanceof Player _entity58 && _entity58.containerMenu instanceof PalamodModMenus.MenuAccessor _menu58) ? _menu58.getMenuState(0, "cheat_code_secret", "") : "").contains("0259.cf42214")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Cheats Activated"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = new ItemStack(PalamodModItems.LEGENDARY_STONE_POWER.get()).copy();
				_setstack.setCount(1);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
			new ItemStack(PalamodModItems.LEGENDARY_STONE_POWER.get()).set(DataComponents.CUSTOM_NAME, Component.literal("Legudary diorite  of unPower"));
		} else if (((entity instanceof Player _entity62 && _entity62.containerMenu instanceof PalamodModMenus.MenuAccessor _menu62) ? _menu62.getMenuState(0, "cheat_code_secret", "") : "").contains("alo")
				|| ((entity instanceof Player _entity63 && _entity63.containerMenu instanceof PalamodModMenus.MenuAccessor _menu63) ? _menu63.getMenuState(0, "cheat_code_secret", "") : "").contains("allo")) {
			if (Math.random() < 0.5) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("a l'huile"), false);
			} else {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("a hopital"), false);
			}
		} else if (((entity instanceof Player _entity66 && _entity66.containerMenu instanceof PalamodModMenus.MenuAccessor _menu66) ? _menu66.getMenuState(0, "cheat_code_secret", "") : "").contains("zelda")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("1.0 vibes"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
				_setstack.setCount((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getCount() * 2);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (((entity instanceof Player _entity72 && _entity72.containerMenu instanceof PalamodModMenus.MenuAccessor _menu72) ? _menu72.getMenuState(0, "cheat_code_secret", "") : "").contains("NoHit")) {
			if (entity instanceof Player _player) {
				_player.getAbilities().invulnerable = false;
				_player.onUpdateAbilities();
			}
		} else if (((entity instanceof Player _entity74 && _entity74.containerMenu instanceof PalamodModMenus.MenuAccessor _menu74) ? _menu74.getMenuState(0, "cheat_code_secret", "") : "").contains("Vid20513")
				|| ((entity instanceof Player _entity75 && _entity75.containerMenu instanceof PalamodModMenus.MenuAccessor _menu75) ? _menu75.getMenuState(0, "cheat_code_secret", "") : "").contains("discord_64Bg")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Merci de soutenir le mod"), false);
			if (entity instanceof Player _player) {
				ItemStack _setstack = (entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).copy();
				_setstack.setCount(10);
				ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
			}
		} else if (((entity instanceof Player _entity79 && _entity79.containerMenu instanceof PalamodModMenus.MenuAccessor _menu79) ? _menu79.getMenuState(0, "cheat_code_secret", "") : "").contains("Cat")
				|| ((entity instanceof Player _entity80 && _entity80.containerMenu instanceof PalamodModMenus.MenuAccessor _menu80) ? _menu80.getMenuState(0, "cheat_code_secret", "") : "").contains("cat")
				|| ((entity instanceof Player _entity81 && _entity81.containerMenu instanceof PalamodModMenus.MenuAccessor _menu81) ? _menu81.getMenuState(0, "cheat_code_secret", "") : "").contains("CAT")) {
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
		} else if (((entity instanceof Player _entity86 && _entity86.containerMenu instanceof PalamodModMenus.MenuAccessor _menu86) ? _menu86.getMenuState(0, "cheat_code_secret", "") : "").contains("punk")
				|| ((entity instanceof Player _entity87 && _entity87.containerMenu instanceof PalamodModMenus.MenuAccessor _menu87) ? _menu87.getMenuState(0, "cheat_code_secret", "") : "").contains("fac")
				|| ((entity instanceof Player _entity88 && _entity88.containerMenu instanceof PalamodModMenus.MenuAccessor _menu88) ? _menu88.getMenuState(0, "cheat_code_secret", "") : "").contains("punkastik")) {
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Rejoins le serveur de la PunkAstik https://discord.gg[censored bc fdp]"), false);
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("( c'est plus ma fac )"), false);
		}
	}
}
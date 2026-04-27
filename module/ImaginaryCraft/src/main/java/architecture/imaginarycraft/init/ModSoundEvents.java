package architecture.imaginarycraft.init;

import architecture.imaginarycraft.core.ImaginaryCraft;
import architecture.imaginarycraft.datagen.i18n.ZhCn;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class MobSoundEvents {
	public static final DeferredRegister<SoundEvent> REGISTRY = ImaginaryCraft.modRegister(BuiltInRegistries.SOUND_EVENT);

	public static final DeferredHolder<SoundEvent, SoundEvent> SOLEMN_LAMENT_WEAPON_ATTACK_BLACK = registerForHolder(
		"solemn_lament_weapon_attack_black", "圣宣-黑：射击", "item.solemn_lament_weapon.attack.black");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOLEMN_LAMENT_WEAPON_ATTACK_WHITE = registerForHolder(
		"solemn_lament_weapon_attack_white", "圣宣-白：射击", "item.solemn_lament_weapon.attack.white");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOLEMN_LAMENT_WEAPON_STONGATTACK_BLACK = registerForHolder(
		"solemn_lament_weapon_stongattack_black", "圣宣-黑：特殊射击", "item.solemn_lament_weapon.stongattack.black");
	public static final DeferredHolder<SoundEvent, SoundEvent> SOLEMN_LAMENT_WEAPON_STONGATTACK_WHITE = registerForHolder(
		"solemn_lament_weapon_stongattack_white", "圣宣-白：特殊射击", "item.solemn_lament_weapon.stongattack.white");
	public static final DeferredHolder<SoundEvent, SoundEvent> VIOLET_NOON_DOWN = registerForHolder(
		"violet_noon_down", "“请给我们爱！！！”：下砸", "entity.violet.grant_us_love.down");
	public static final DeferredHolder<SoundEvent, SoundEvent> VIOLET_NOON_ATK = registerForHolder(
		"violet_noon_atk", "“请给我们爱！！！”：攻击", "entity.violet.grant_us_love.atk");
	public static final DeferredHolder<SoundEvent, SoundEvent> VIOLET_NOON_idle = registerForHolder(
		"violet_noon_idle", "“请给我们爱！！！”：触手蠕动", "entity.violet.grant_us_love.idle");
	public static final DeferredHolder<SoundEvent, SoundEvent> VIOLET_NOON_DEATH = registerForHolder(
		"violet_noon_death", "“请给我们爱！！！”：死亡", "entity.violet.grant_us_love.death");
	public static final DeferredHolder<SoundEvent, SoundEvent> VIOLET_DAWN_WALK = registerForHolder(
		"violet_dawn_walk", "“紫罗兰黎明”：蠕动", "entity.violet.fruit_of_understanding.walk");
	public static final DeferredHolder<SoundEvent, SoundEvent> VIOLET_DAWN_SUICIDE = registerForHolder(
		"violet_dawn_suicide", "“紫罗兰黎明”：自爆", "entity.violet.fruit_of_understanding.suicide");
	public static final DeferredHolder<SoundEvent, SoundEvent> VIOLET_DAWN_DEAD = registerForHolder(
		"violet_dawn_dead", "“紫罗兰黎明”：死亡", "entity.violet.fruit_of_understanding.dead");

	private static DeferredHolder<SoundEvent, SoundEvent> registerForHolder(String id, String zhName, String location) {
		DeferredHolder<SoundEvent, SoundEvent> register = MobSoundEvents.REGISTRY.register(id, () -> SoundEvent.createVariableRangeEvent(ImaginaryCraft.modRl(location)));
		ZhCn.addI18nSoundEventText(zhName, register);
		return register;
	}
}

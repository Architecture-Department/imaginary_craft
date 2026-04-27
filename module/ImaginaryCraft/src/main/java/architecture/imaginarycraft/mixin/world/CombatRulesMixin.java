package architecture.imaginarycraft.mixin.world;

import architecture.goldenboughs_lib.init.tag.LibDamageTypeTags;
import net.minecraft.world.damagesource.CombatRules;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CombatRules.class)
public abstract class CombatRulesMixin {
	@Inject(method = "getDamageAfterAbsorb", at = @At("HEAD"), cancellable = true)
	private static void imaginarycraft$getDamageAfterAbsorb(LivingEntity entity, float damage, DamageSource damageSource, float armorValue, float armorToughness, CallbackInfoReturnable<Float> cir) {
		if (damageSource.is(LibDamageTypeTags.EROSION) ||
			damageSource.is(LibDamageTypeTags.SPIRIT) ||
			damageSource.is(LibDamageTypeTags.THE_SOUL)) {
			cir.setReturnValue(damage);
		}
	}
}

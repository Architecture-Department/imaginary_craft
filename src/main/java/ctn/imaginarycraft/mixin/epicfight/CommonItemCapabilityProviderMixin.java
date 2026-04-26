package ctn.imaginarycraft.mixin.epicfight;

import ctn.imaginarycraft.core.registry.epicfight.ItemRegistry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import yesman.epicfight.world.capabilities.provider.CommonItemCapabilityProvider;

@Mixin(CommonItemCapabilityProvider.class)
public abstract class CommonItemCapabilityProviderMixin {
	@Inject(method = "registerWeaponTypesByClass", at = @At("RETURN"))
	private void registerWeaponTypes(CallbackInfo ci) {
		ItemRegistry.registerWeaponTypes();
	}
}

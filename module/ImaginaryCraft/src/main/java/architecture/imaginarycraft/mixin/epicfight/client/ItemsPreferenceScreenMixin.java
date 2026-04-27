package architecture.imaginarycraft.mixin.epicfight.client;

import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import architecture.goldenboughs_lib.api.world.item.IRemoteEgoWeaponItem;
import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import yesman.epicfight.client.gui.screen.config.ItemsPreferenceScreen;

@Mixin(ItemsPreferenceScreen.class)
public abstract class ItemsPreferenceScreenMixin {
	/**
	 * 用于相关史诗战斗的武器相关的判断
	 */
	@ModifyExpressionValue(method = "judgeItemPreference", at = @At(value = "INVOKE", target = "Ljava/util/Set;contains(Ljava/lang/Object;)Z", ordinal = 0))
	private static boolean imaginarycraft$judgeItemPreference(boolean original, @Local(name = "item") Item item) {
		return original || item instanceof IMeleeEgoWeaponItem || item instanceof IRemoteEgoWeaponItem;
	}
}

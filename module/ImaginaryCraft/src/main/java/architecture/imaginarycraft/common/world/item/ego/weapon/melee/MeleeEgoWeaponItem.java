package architecture.imaginarycraft.common.world.item.ego.weapon.melee;

import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import architecture.imaginarycraft.common.world.item.ego.weapon.EgoWeaponItem;

public abstract class MeleeEgoWeaponItem extends EgoWeaponItem implements IMeleeEgoWeaponItem {

	public MeleeEgoWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder) {
		super(itemProperties, egoWeaponBuilder);
	}
}

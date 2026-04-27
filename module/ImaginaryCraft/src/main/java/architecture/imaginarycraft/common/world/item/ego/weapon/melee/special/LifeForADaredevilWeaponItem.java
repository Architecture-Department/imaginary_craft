package architecture.imaginarycraft.common.world.item.ego.weapon.melee.special;

import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import architecture.imaginarycraft.common.world.item.ego.weapon.melee.MeleeEgoWeaponGeoItem;
import software.bernie.geckolib.model.GeoModel;

public class LifeForADaredevilWeaponItem extends MeleeEgoWeaponGeoItem {

	public LifeForADaredevilWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, GeoModel<MeleeEgoWeaponGeoItem> geoModel, GeoModel<MeleeEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public LifeForADaredevilWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, String modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}
}

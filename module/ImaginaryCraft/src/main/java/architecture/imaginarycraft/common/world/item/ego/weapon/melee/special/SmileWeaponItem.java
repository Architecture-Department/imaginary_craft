package architecture.imaginarycraft.common.world.item.ego.weapon.melee.special;

import architecture.goldenboughs_lib.api.world.item.IMeleeEgoWeaponItem;
import architecture.imaginarycraft.common.world.item.ego.weapon.melee.MeleeEgoWeaponGeoItem;
import software.bernie.geckolib.model.GeoModel;

public class SmileWeaponItem extends MeleeEgoWeaponGeoItem {

	public SmileWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, GeoModel<MeleeEgoWeaponGeoItem> geoModel, GeoModel<MeleeEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public SmileWeaponItem(Properties itemProperties, IMeleeEgoWeaponItem.Builder egoWeaponBuilder, String modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}
}

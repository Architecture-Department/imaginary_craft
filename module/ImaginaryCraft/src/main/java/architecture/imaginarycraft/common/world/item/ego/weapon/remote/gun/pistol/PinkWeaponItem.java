package architecture.imaginarycraft.common.world.item.ego.weapon.remote.gun.pistol;

import architecture.imaginarycraft.common.world.item.ego.weapon.remote.RemoteEgoWeaponGeoItem;
import architecture.imaginarycraft.common.world.item.ego.weapon.remote.gun.GunEgoWeaponItem;
import software.bernie.geckolib.model.GeoModel;

public class PinkWeaponItem extends GunEgoWeaponItem {

	public PinkWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, GeoModel<RemoteEgoWeaponGeoItem> geoModel, GeoModel<RemoteEgoWeaponGeoItem> guiModel) {
		super(itemProperties, egoWeaponBuilder, geoModel, guiModel);
	}

	public PinkWeaponItem(Properties itemProperties, Builder egoWeaponBuilder, String modPath) {
		super(itemProperties, egoWeaponBuilder, modPath);
	}
}

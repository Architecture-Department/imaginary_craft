package architecture.imaginarycraft.mixed.client;

import architecture.goldenboughs_lib.api.NoMixinException;
import yesman.epicfight.api.client.animation.property.TrailInfo;
import yesman.epicfight.client.renderer.patched.item.RenderItemBase;
import yesman.epicfight.world.capabilities.entitypatch.LivingEntityPatch;

public interface IRenderItemBase {
	static IRenderItemBase of(RenderItemBase obj) {
		return (IRenderItemBase) obj;
	}

	default TrailInfo imaginarycraft$getTrailInfoProvider(LivingEntityPatch<?> livingEntityPatch) {
		throw new NoMixinException();
	}
}

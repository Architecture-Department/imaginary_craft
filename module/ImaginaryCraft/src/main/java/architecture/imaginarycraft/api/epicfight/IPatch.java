package architecture.imaginarycraft.api.epicfight;

import yesman.epicfight.world.capabilities.entitypatch.EntityPatch;

public interface IPatch<T extends EntityPatch<?>> {
	T getPatch();
}

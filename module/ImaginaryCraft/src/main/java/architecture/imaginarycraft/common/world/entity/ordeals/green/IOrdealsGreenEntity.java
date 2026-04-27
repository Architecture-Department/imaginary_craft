package architecture.imaginarycraft.common.world.entity.ordeals.green;

import architecture.goldenboughs_lib.api.world.entity.ai.CampHurtByTargetGoal;
import architecture.goldenboughs_lib.init.tag.LibEntityTags;
import architecture.imaginarycraft.common.world.entity.ordeals.IOrdealsEntity;
import net.minecraft.world.entity.Entity;

public interface IOrdealsGreenEntity extends IOrdealsEntity {
	@Override
	default boolean isCamp(Entity entity) {
		return IOrdealsEntity.super.isCamp(entity) || getMob().getType().is(LibEntityTags.ORDEALS_GREEN);
	}

	@Override
	default void registerGoals() {
		IOrdealsEntity.super.registerGoals();
		getTargetSelector().addGoal(1, new CampHurtByTargetGoal(getMob(), IOrdealsGreenEntity.class));
	}
}

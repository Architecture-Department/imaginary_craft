package architecture.imaginarycraft.common.world.entity.ordeals.violet;

import architecture.goldenboughs_lib.api.world.entity.ai.CampHurtByTargetGoal;
import architecture.goldenboughs_lib.init.tag.LibEntityTags;
import architecture.imaginarycraft.common.world.entity.ordeals.IOrdealsEntity;
import net.minecraft.world.entity.Entity;

public interface IOrdealsVioletEntity extends IOrdealsEntity {
	@Override
	default boolean isCamp(Entity entity) {
		return IOrdealsEntity.super.isCamp(entity) || entity.getType().is(LibEntityTags.ORDEALS_VIOLET);
	}

	@Override
	default void registerGoals() {
		IOrdealsEntity.super.registerGoals();
		getTargetSelector().addGoal(2, new CampHurtByTargetGoal(getMob(), IOrdealsVioletEntity.class));
	}
}

package architecture.imaginarycraft.common.world.entity.ordeals.violet;

import architecture.imaginarycraft.api.world.entity.ai.CampHurtByTargetGoal;
import architecture.imaginarycraft.common.world.entity.ordeals.IOrdealsEntity;
import architecture.imaginarycraft.init.tag.ModEntityTags;
import net.minecraft.world.entity.Entity;

public interface IOrdealsVioletEntity extends IOrdealsEntity {
	@Override
	default boolean isCamp(Entity entity) {
		return IOrdealsEntity.super.isCamp(entity) || entity.getType().is(ModEntityTags.ORDEALS_VIOLET);
	}

	@Override
	default void registerGoals() {
		IOrdealsEntity.super.registerGoals();
		getTargetSelector().addGoal(2, new CampHurtByTargetGoal(getMob(), IOrdealsVioletEntity.class));
	}
}

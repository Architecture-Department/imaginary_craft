package architecture.imaginarycraft.api.world.entity;

import architecture.imaginarycraft.api.world.entity.ai.behavior.BTRoot;
import net.minecraft.world.entity.Mob;

public interface IBehaviorTreeMob<T extends Mob> {
	BTRoot<T> createBehaviorTree();
}

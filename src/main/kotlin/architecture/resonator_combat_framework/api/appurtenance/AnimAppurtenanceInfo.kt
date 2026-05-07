package architecture.resonator_combat_framework.api.appurtenance

import cn.solarmoon.spark_core.animation.IAnimatable
import cn.solarmoon.spark_core.animation.anim.AnimController
import cn.solarmoon.spark_core.animation.model.ModelController
import cn.solarmoon.spark_core.animation.model.ModelIndex
import cn.solarmoon.spark_core.event.BoneUpdateEvent
import cn.solarmoon.spark_core.physics.PhysicsHost
import cn.solarmoon.spark_core.physics.body.attachToBone
import cn.solarmoon.spark_core.util.toRadians
import com.jme3.bullet.collision.PhysicsCollisionObject
import com.jme3.bullet.objects.PhysicsRigidBody
import net.minecraft.world.entity.Entity
import net.minecraft.world.level.Level
import org.joml.Matrix4f
import kotlin.math.PI

open class AnimAppurtenanceInfo<T>(
	owner: T,
	physicsCollisions: LinkedHashMap<String, PhysicsCollisionObject>,
	override val defaultModelIndex: ModelIndex,
	override val animController: AnimController,
	override val modelController: ModelController,
	override val variables: MutableMap<String, Any>
) : AppurtenanceInfo<T>(owner, physicsCollisions),
	IAnimatable<AnimAppurtenanceInfo<T>> where T : Entity, T : IAnimatable<*>, T : PhysicsHost {

	override val animatable: AnimAppurtenanceInfo<T> = this
	override val animLevel: Level? = owner.animLevel

	override fun addPhysicsCollision(name: String, body: PhysicsRigidBody) {
		physicsCollisions[name] = body
		body.attachToBone(animatable, name)
	}

	override fun getWorldPositionMatrix(partialTicks: Number): Matrix4f {
		return Matrix4f()
			.translate(owner.getPosition(partialTicks.toFloat()).toVector3f())
			.rotateY(PI.toFloat() - owner.getPreciseBodyRotation(partialTicks.toFloat()).toRadians())
	}

	override fun onBoneUpdate(event: BoneUpdateEvent) {
	}
}

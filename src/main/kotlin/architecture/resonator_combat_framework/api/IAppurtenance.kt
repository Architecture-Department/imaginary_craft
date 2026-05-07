package architecture.resonator_combat_framework.api

import cn.solarmoon.spark_core.physics.PhysicsHost
import com.jme3.bullet.collision.PhysicsCollisionObject
import net.minecraft.world.entity.Entity

interface IAppurtenance {
	fun <T> add(entity: T) where T : Entity, T : PhysicsHost {
		entity.allPhysicsBodies.putAll(physicsBodies.mapValues { (_, info) -> info.body }.toMutableMap())
	}

	var physicsBodies: MutableMap<String, AppurtenanceInfo>

	fun <T> remove(entity: T) where T : Entity, T : PhysicsHost

	open class AppurtenanceInfo(
		var body: PhysicsCollisionObject
	) {
		fun <T> tick() where T : Entity, T : PhysicsHost {

		}
	}

	open class BonesAppurtenanceInfo(
		var boneName: String,
		body: PhysicsCollisionObject
	) : AppurtenanceInfo(body)
}
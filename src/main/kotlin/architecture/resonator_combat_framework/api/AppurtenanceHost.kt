package architecture.resonator_combat_framework.api

import architecture.resonator_combat_framework.api.appurtenance.AnimAppurtenanceInfo
import architecture.resonator_combat_framework.api.appurtenance.AppurtenanceInfo
import cn.solarmoon.spark_core.event.BoneUpdateEvent

interface AppurtenanceHost {
	val physicsBodies: MutableMap<String, AppurtenanceInfo<*>>

	fun allTick() {
		physicsBodies.values.forEach {
			it.tick()
		}
	}

	fun allAnimTick() {
		physicsBodies.values.forEach {
			if (it !is AnimAppurtenanceInfo) return
			it.animController.tick()
		}
	}

	fun allStopAllAnimation() {
		physicsBodies.values.forEach {
			if (it !is AnimAppurtenanceInfo) return
			it.animController.stopAllAnimation()
		}
	}

	fun allOnBoneUpdate(event: BoneUpdateEvent) {
		physicsBodies.values.forEach {
			if (it !is AnimAppurtenanceInfo) return
			it.onBoneUpdate(event)
		}
	}

	fun allPhysTick() {
		physicsBodies.values.forEach {
			if (it !is AnimAppurtenanceInfo) return
			it.animController.physTick()
		}
	}
}
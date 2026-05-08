package architecture.resonator_combat_framework.api

import net.minecraft.nbt.CompoundTag
import net.minecraft.world.entity.Entity
import net.minecraft.world.item.ItemStack

interface IAppurtenanceExecute {
	fun add(entity: Entity, itemStack: ItemStack, nbt: CompoundTag = CompoundTag())
	fun add(entity: Entity, itemStack: ItemStack) {
		add(entity, itemStack, CompoundTag())
	}

	fun remove(entity: Entity, itemStack: ItemStack, nbt: CompoundTag = CompoundTag())
	fun remove(entity: Entity, itemStack: ItemStack) {
		remove(entity, itemStack, CompoundTag())
	}
}
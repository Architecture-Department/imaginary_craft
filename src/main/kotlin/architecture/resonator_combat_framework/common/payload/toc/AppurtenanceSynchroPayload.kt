package architecture.resonator_combat_framework.common.payload.toc

import architecture.goldenboughs_lib.common.payload.api.ToClientPayload
import io.netty.buffer.ByteBuf
import net.minecraft.nbt.CompoundTag
import net.minecraft.network.codec.ByteBufCodecs
import net.minecraft.network.codec.StreamCodec
import net.minecraft.world.entity.player.Player

abstract class AppurtenanceSynchroPayload(
	var entityId: Int,
	val executeType: Byte,
	val nbt: CompoundTag = CompoundTag()
) : ToClientPayload {

	abstract override fun work(player: Player)

	companion object {
		@JvmStatic
		val COMPOUND_TAG_STREAM_CODEC: StreamCodec<ByteBuf, CompoundTag> = ByteBufCodecs.fromCodec(CompoundTag.CODEC)
	}
}

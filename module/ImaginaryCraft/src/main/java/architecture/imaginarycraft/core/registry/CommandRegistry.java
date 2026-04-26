package architecture.imaginarycraft.core.registry;

import architecture.imaginarycraft.common.command.RationalityCommands;
import architecture.imaginarycraft.core.ImaginaryCraft;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.RegisterCommandsEvent;

/**
 * 指令事件
 */
@EventBusSubscriber(modid = ImaginaryCraft.ID)
public final class CommandRegistry {
	@SubscribeEvent
	public static void registry(RegisterCommandsEvent event) {
		CommandDispatcher<CommandSourceStack> dispatcher = event.getDispatcher();
		RationalityCommands.processRationality(dispatcher);
	}
}

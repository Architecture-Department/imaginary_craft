package architecture.imaginarycraft.core;

import architecture.imaginarycraft.core.registry.CurioRegistry;
import architecture.imaginarycraft.core.registry.epicfight.EntityTypeRegistry;
import architecture.imaginarycraft.init.MobSoundEvents;
import architecture.imaginarycraft.init.epicfight.ModArmatures;
import architecture.imaginarycraft.init.epicfight.ModEntieyConditions;
import architecture.imaginarycraft.init.epicfight.ModMeshes;
import architecture.imaginarycraft.init.world.ModColliders;
import architecture.imaginarycraft.init.world.ModCreativeModeTabs;
import architecture.imaginarycraft.init.world.entity.ModEntityDataSerializers;
import architecture.imaginarycraft.init.world.entity.ModEntityTypes;
import architecture.imaginarycraft.init.world.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

@Mod(ImaginaryCraft.ID)
public final class ImaginaryCraft {
	public static final String ID = "imaginarycraft";
	public static final String NAME = "ImaginaryCraft";
	public static final Logger LOGGER = LogManager.getLogger(ID);

	public ImaginaryCraft(IEventBus eventBus, ModContainer container) {
		ModEpicjightEventHooks.listenerRegister();

		ModArmatures.init();
		ModMeshes.init();
		ModColliders.init();

		ModEntityDataSerializers.REGISTRY.register(eventBus);
		MobSoundEvents.REGISTRY.register(eventBus);

		ModEntieyConditions.REGISTRY.register(eventBus);
		ModItems.init(eventBus);
		ModEntityTypes.init(eventBus);

		ModCreativeModeTabs.REGISTRY.register(eventBus);
		CurioRegistry.registry();
		EntityTypeRegistry.register();
	}

	@Contract("_ -> new")
	public static @NotNull ResourceLocation modRl(final String name) {
		return ResourceLocation.fromNamespaceAndPath(ID, name);
	}

	@Contract(pure = true)
	public static @NotNull String modRlText(final String name) {
		return ID + ":" + name;
	}

	public static <T> @NotNull DeferredRegister<T> modRegister(Registry<T> registry) {
		return DeferredRegister.create(registry, ID);
	}

	public static <T> @NotNull DeferredRegister<T> modRegister(ResourceKey<Registry<T>> registry) {
		return DeferredRegister.create(registry, ID);
	}
}

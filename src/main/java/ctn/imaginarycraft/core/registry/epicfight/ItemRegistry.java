package ctn.imaginarycraft.core.registry.epicfight;

import ctn.imaginarycraft.api.epicfight.capabilities.MobBuilderEntrys;
import ctn.imaginarycraft.api.epicfight.capabilities.ModExCapDataSets;
import ctn.imaginarycraft.api.epicfight.capabilities.ModMovesets;
import ctn.imaginarycraft.core.ImaginaryCraft;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import yesman.epicfight.api.event.EpicFightEventHooks;
import yesman.epicfight.api.event.types.registry.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.api.ex_cap.modules.core.data.BuilderEntry;
import yesman.epicfight.api.ex_cap.modules.core.events.*;
import yesman.epicfight.api.ex_cap.modules.core.managers.BuilderManager;
import yesman.epicfight.world.capabilities.EpicFightCapabilities;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapabilityPresets;

import java.util.Set;
import java.util.function.Function;

public final class ItemRegistry {
	static void register() {
		EpicFightEventHooks.Registry.EX_CAP_DATA_CREATION.registerEvent(ItemRegistry::registerData, 1);
		EpicFightEventHooks.Registry.EX_CAP_BUILDER_CREATION.registerEvent(ItemRegistry::registerExCapBuilders, 1);
		EpicFightEventHooks.Registry.EX_CAP_CONDITIONAL_REGISTRATION.registerEvent(ItemRegistry::registerConditionals, 1);
		EpicFightEventHooks.Registry.EX_CAP_MOVESET_REGISTRY.registerEvent(ItemRegistry::registerExCapMovesets, 1);
		EpicFightEventHooks.Registry.EX_CAP_DATA_POPULATION.registerEvent(ItemRegistry::registerExCapMethods, 1);
		EpicFightEventHooks.Registry.WEAPON_CAPABILITY_PRESET.registerEvent(ItemRegistry::registerWeaponCapabilities, 1);
	}

	public static void registerWeaponTypes() {

//		register(ImaginaryCraftConstants.GUN, MobBuilderEntrys.GUN);
//		register(ImaginaryCraftConstants.PISTOL, MobBuilderEntrys.PISTOL);
//		register(ImaginaryCraftConstants.RIFLE, MobBuilderEntrys.RIFLE);
//		register(ImaginaryCraftConstants.CANNON, MobBuilderEntrys.CANNON);
//		register(ImaginaryCraftConstants.CROSSBOW, Builders.CROSSBOW);
//		register(ImaginaryCraftConstants.BOW, Builders.BOW);
//		register(ImaginaryCraftConstants.KNIFE, Builders.DAGGER);
//		register(ImaginaryCraftConstants.HAMMER, MobBuilderEntrys.HAMMER);
//		register(ImaginaryCraftConstants.FIST, Builders.FIST);
//		register(ImaginaryCraftConstants.SPEAR, Builders.SPEAR);
//		register(ImaginaryCraftConstants.AXE, Builders.AXE);
//		register(ImaginaryCraftConstants.MACE, MobBuilderEntrys.MACE);
//		register(ImaginaryCraftConstants.SWORDS, Builders.SWORD);
//		register(EgoWeaponItems.RED_EYES_TACHI, Builders.TACHI);
//		register(EgoWeaponItems.LIFE_FOR_A_DAREDEVIL, Builders.TACHI);
//		register(EgoWeaponItems.COMPREHENSION_TETH, Builders.GREATSWORD);
//		register(EgoWeaponItems.COMPREHENSION_HE, Builders.GREATSWORD);
	}

	private static void registerExCapMethods(ExCapabilityBuilderPopulationEvent event) {
		event.registerData(MobBuilderEntrys.HAMMER.id(), ModExCapDataSets.HAMMER.id());
		event.registerData(MobBuilderEntrys.MACE.id(), ModExCapDataSets.MACE.id());
		event.registerData(MobBuilderEntrys.CANNON.id(), ModExCapDataSets.CANNON.id());
		event.registerData(MobBuilderEntrys.GUN.id(), ModExCapDataSets.GUN.id());
		event.registerData(MobBuilderEntrys.PISTOL.id(), ModExCapDataSets.PISTOL.id());
		event.registerData(MobBuilderEntrys.RIFLE.id(), ModExCapDataSets.RIFLE.id());
	}

	private static void registerData(ExCapDataRegistrationEvent event) {
		event.addData(
			ModExCapDataSets.HAMMER,
			ModExCapDataSets.MACE,
			ModExCapDataSets.CANNON,
			ModExCapDataSets.GUN,
			ModExCapDataSets.PISTOL,
			ModExCapDataSets.RIFLE
		);
	}

	private static void registerExCapBuilders(ExCapBuilderCreationEvent event) {
		event.addBuilder(
			MobBuilderEntrys.HAMMER,
			MobBuilderEntrys.MACE,
			MobBuilderEntrys.CANNON,
			MobBuilderEntrys.GUN,
			MobBuilderEntrys.PISTOL,
			MobBuilderEntrys.RIFLE
		);
	}

	private static void registerConditionals(ConditionalRegistryEvent event) {
		event.addConditional(
//			ModMainConditionals.HAMMER,
		);
	}

	private static void registerExCapMovesets(ExCapMovesetRegistryEvent event) {
		event.addMoveSet(
			ModMovesets.HAMMER,
			ModMovesets.MACE,
			ModMovesets.CANNON,
			ModMovesets.GUN,
			ModMovesets.PISTOL,
			ModMovesets.RIFLE
		);
	}

	private static void registerWeaponCapabilities(WeaponCapabilityPresetRegistryEvent event) {
//		BuilderManager.acceptExport(event);
	}

	private static void register(Set<DeferredItem<? extends Item>> items, BuilderEntry builderEntry) {
		register(items, (item) -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(builderEntry.id()), item));
	}

	private static void register(Set<DeferredItem<? extends Item>> items, Function<Item, ? extends CapabilityItem.Builder<?>> builder) {
		for (DeferredItem<? extends Item> item : items) {
			register(item, builder);
		}
	}

	private static void register(DeferredItem<? extends Item> item, Function<Item, ? extends CapabilityItem.Builder<?>> builder) {
		register(item.get(), builder);
	}

	private static void register(DeferredItem<? extends Item> item, BuilderEntry builderEntry) {
		register(item.get(), (item1) -> WeaponCapabilityPresets.exCapRegistration(BuilderManager.getEntry(builderEntry.id()), item1));
	}

	private static void register(Item item1, Function<Item, ? extends CapabilityItem.Builder<?>> builder) {
		CapabilityItem capability = builder.apply(item1).build();
		if (capability == null) {
			ImaginaryCraft.LOGGER.warn("Failed to build weapon capability for item: {}, skipping registration", item1.getDescriptionId());
			return;
		}

		EpicFightCapabilities.ITEM_CAPABILITY_PROVIDER.put(item1, capability);
	}
}

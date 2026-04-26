package architecture.imaginarycraft.datagen.tag;

import architecture.imaginarycraft.common.world.entity.ordeals.IOrdealsEntity;
import architecture.imaginarycraft.core.ImaginaryCraft;
import architecture.imaginarycraft.init.tag.ModEntityTags;
import architecture.imaginarycraft.init.world.entity.OrdealsEntityTypes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

@SuppressWarnings("unchecked")
public final class DatagenEntityTag extends EntityTypeTagsProvider {
	public DatagenEntityTag(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, provider, ImaginaryCraft.ID, existingFileHelper);
	}

	private static EntityType<?>[] getArray(Collection<DeferredHolder<EntityType<?>, ? extends EntityType<?>>> entries, Class<? extends IOrdealsEntity> clazz) {
		return entries.stream()
			.filter(entityType -> clazz.isInstance(entityType.get()))
			.map(DeferredHolder::get)
			.toArray(EntityType[]::new);
	}

	@Override
	protected void addTags(final HolderLookup.Provider provider) {
		tag(ModEntityTags.ORDEALS_VIOLET).add(
			OrdealsEntityTypes.GRANT_US_LOVE.get(),
			OrdealsEntityTypes.FRUIT_OF_UNDERSTANDING.get());
		tag(ModEntityTags.ORDEALS_AMBER)/*.add()*/;
		tag(ModEntityTags.ORDEALS_GREEN)/*.add()*/;
		tag(ModEntityTags.ORDEALS_CRIMSON)/*.add()*/;
		tag(ModEntityTags.ORDEALS).addTags(ModEntityTags.ORDEALS_VIOLET, ModEntityTags.ORDEALS_AMBER, ModEntityTags.ORDEALS_GREEN, ModEntityTags.ORDEALS_CRIMSON);
	}
}

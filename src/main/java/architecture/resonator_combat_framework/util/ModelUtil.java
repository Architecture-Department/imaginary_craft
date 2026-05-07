package architecture.resonator_combat_framework.util;

import architecture.goldenboughs_lib.client.model.GeoModelExpand;
import architecture.resonator_combat_framework.core.Rcf;
import architecture.resonator_combat_framework.core.RcfConstants;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.model.GeoModel;

public final class ModelUtil {
	/**
	 * 模型构建器 - 使用建造者模式创建 GeoModel
	 */
	public static class ModelBuilder<T extends GeoAnimatable> {
		private final String id;
		private final String moduleName;
		private final String namespace;
		private String path;

		public ModelBuilder(String id) {
			this.id = id;
			this.moduleName = id;
			this.namespace = id;
		}

		public ModelBuilder(String id, String moduleName) {
			this.id = id;
			this.moduleName = moduleName;
			this.namespace = id;
		}

		public ModelBuilder(String id, String moduleName, String namespace) {
			this.id = id;
			this.moduleName = moduleName;
			this.namespace = namespace;
		}

		/**
		 * 设置路径
		 */
		public ModelBuilder<T> path(String path) {
			this.path = path;
			return this;
		}

		/**
		 * 设置饰品路径（自动添加 curio/ 前缀）
		 */
		public ModelBuilder<T> curioPath(String path) {
			this.path = "curio/" + path;
			return this;
		}

		/**
		 * 设置物品路径（自动添加 item/ 前缀）
		 */
		public ModelBuilder<T> itemPath(String path) {
			this.path = "item/" + path;
			return this;
		}

		/**
		 * 设置实体路径（自动添加 entity/ 前缀）
		 */
		public ModelBuilder<T> entityPath(String path) {
			this.path = "entity/" + path;
			return this;
		}

		/**
		 * 设置护甲路径（自动添加 armor/ 前缀）
		 */
		public ModelBuilder<T> armorPath(String path) {
			this.path = "armor/" + path;
			return this;
		}

		/**
		 * 构建 GeoModel
		 */
		public GeoModel<T> build() {
			if (namespace == null) {
				throw new IllegalStateException("Namespace must be set before building");
			}
			if (path == null) {
				throw new IllegalStateException("Path must be set before building");
			}

			return new GeoModelExpand<>(getModelsRl(), getTexturePath(), getAnimationsRl());
		}

		public ResourceLocation getTexturePath() {
			return GeoModelExpand.texturePath(ResourceLocation.fromNamespaceAndPath(id, path));
		}

		public ResourceLocation getModelsRl() {
			return Rcf.getSparkModuleRl(id, moduleName, namespace, RcfConstants.MODELS, path);
		}

		public ResourceLocation getAnimationsRl() {
			return Rcf.getSparkModuleRl(id, moduleName, namespace, RcfConstants.ANIMATIONS, path);
		}
	}
}

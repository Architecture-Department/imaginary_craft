package architecture.imaginarycraft.client.renderer.entity;

import architecture.imaginarycraft.api.client.renderer.entity.EmptyMobRenderer;
import architecture.imaginarycraft.api.client.renderer.entity.ModPatchedLivingEntityRenderer;
import architecture.imaginarycraft.client.animmodels.mesh.GrantUsLoveMesh;
import architecture.imaginarycraft.client.model.entity.EmptyEntityModel;
import architecture.imaginarycraft.client.model.entity.ModGeoEntityModel;
import architecture.imaginarycraft.client.renderer.renderlayer.GlowmaskModelRenderPatchedLayer;
import architecture.imaginarycraft.common.world.entity.ordeals.violet.GrantUsLove;
import architecture.imaginarycraft.common.world.entity.ordeals.violet.GrantUsLovePatch;
import architecture.imaginarycraft.init.epicfight.ModMeshes;
import architecture.imaginarycraft.init.world.entity.OrdealsEntityTypes;
import architecture.imaginarycraft.util.ModUtils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.model.Armature;

// TODO 死亡之后光芒变暗
public class GrantUsLovePatchRenderer extends ModPatchedLivingEntityRenderer<GrantUsLove, GrantUsLovePatch, EmptyEntityModel<GrantUsLove>, EmptyMobRenderer<GrantUsLove>, GrantUsLoveMesh> {
	private static final ResourceLocation GLOWMASK_TEXTURE = ModGeoEntityModel.getTexturePath("grant_us_love_glowmask");
	private final float[] glowmaskValue = {1f};

	public GrantUsLovePatchRenderer(EntityRendererProvider.Context context) {
		super(context, OrdealsEntityTypes.GRANT_US_LOVE.get(), ModMeshes.GRANT_US_LOVE);
		addCustomLayer((mesh) -> new GlowmaskModelRenderPatchedLayer<>(mesh, GLOWMASK_TEXTURE, this.glowmaskValue));
	}

	@Override
	public void render(GrantUsLove entity, GrantUsLovePatch entitypatch, EmptyMobRenderer<GrantUsLove> renderer, MultiBufferSource buffer, PoseStack poseStack, int packedLight, float partialTicks) {
		this.glowmaskValue[0] = ModUtils.calculateSineCycle(0.9f, 2f, 4.0f);
		super.render(entity, entitypatch, renderer, buffer, poseStack, packedLight, partialTicks);
	}

	@Override
	public void mulPoseStack(PoseStack poseStack, Armature armature, GrantUsLove entity, GrantUsLovePatch entitypatch, float partialTicks) {
		super.mulPoseStack(poseStack, armature, entity, entitypatch, partialTicks);
	}
}

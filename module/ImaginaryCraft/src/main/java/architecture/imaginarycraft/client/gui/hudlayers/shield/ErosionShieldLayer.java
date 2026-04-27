package architecture.imaginarycraft.client.gui.hudlayers.shield;

import architecture.goldenboughs_lib.init.LibMobEffects;
import architecture.imaginarycraft.core.ImaginaryCraft;
import net.minecraft.resources.ResourceLocation;

public class ErosionShieldLayer extends ShieldBarLayer {
	protected static final ResourceLocation TEXTURE = ImaginaryCraft.modRl("hud_bar/shield/erosion_shield_bar");
	protected static final ResourceLocation BOTTOM_TEXTURE = ImaginaryCraft.modRl("hud_bar/shield/erosion_shield_bar_bottom");
	protected static final ResourceLocation LIGHT_TEXTURE = ImaginaryCraft.modRl("hud_bar/shield/erosion_shield_bar_light");

	public ErosionShieldLayer() {
		super(TEXTURE, BOTTOM_TEXTURE, LIGHT_TEXTURE, LibMobEffects.EROSION_ABSORPTION_SHIELD);
	}
}

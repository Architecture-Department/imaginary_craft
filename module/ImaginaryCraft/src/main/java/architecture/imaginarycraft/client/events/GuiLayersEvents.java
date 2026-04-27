package architecture.imaginarycraft.client.events;

import architecture.goldenboughs_lib.util.GunWeaponUtil;
import architecture.imaginarycraft.client.ModGuiLayers;
import architecture.imaginarycraft.core.ImaginaryCraft;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RenderGuiLayerEvent;
import net.neoforged.neoforge.client.gui.VanillaGuiLayers;

@EventBusSubscriber(modid = ImaginaryCraft.ID, value = Dist.CLIENT)
public final class GuiLayersEvents {
	@SubscribeEvent
	public static void renderGuiLayerEventPre(RenderGuiLayerEvent.Pre event) {
		ResourceLocation name = event.getName();
		Minecraft instance = Minecraft.getInstance();

		// 关闭原版的血条
		if (name.equals(VanillaGuiLayers.PLAYER_HEALTH)) {
			if (architecture.goldenboughs_lib.config.LibConfig.CLIENT.enableNewHealthBar.get()) {
				event.setCanceled(true);
			}
			return;
		}

		if (name.equals(ModGuiLayers.SCREEN_FILTER)) {
			if (!architecture.goldenboughs_lib.config.LibConfig.CLIENT.enableLowRationalityFilter.get()) {
				event.setCanceled(true);
			}
			return;
		}

		if (name.equals(ModGuiLayers.LC_DAMAGE_SCREEN_FILTER)) {
			if (!architecture.goldenboughs_lib.config.LibConfig.CLIENT.enableLcColorDamageFilter.get()) {
				event.setCanceled(true);
			}
			return;
		}

		if (name.equals(ModGuiLayers.GUN_CHARGE_UP_HUD_LAYER_CROSSHAIR) || name.equals(ModGuiLayers.GUN_CHARGE_UP_HUD_LAYER_HOTBAR)) {
			switch (instance.options.attackIndicator().get()) {
				case CROSSHAIR -> {
					if (name.equals(ModGuiLayers.GUN_CHARGE_UP_HUD_LAYER_HOTBAR)) {
						event.setCanceled(true);
					}
				}
				case HOTBAR -> {
					if (name.equals(ModGuiLayers.GUN_CHARGE_UP_HUD_LAYER_CROSSHAIR)) {
						event.setCanceled(true);
					}
				}
				default -> {
					event.setCanceled(true);
					return;
				}
			}
			if (instance.player != null && !GunWeaponUtil.is(instance.player)) {
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public static void renderGuiLayerEventPost(RenderGuiLayerEvent.Post event) {

	}
}

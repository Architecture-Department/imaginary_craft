package architecture.imaginarycraft.core.registry.client;

import architecture.goldenboughs_lib.api.client.particle.DyeingMagicCircleParticle;
import architecture.goldenboughs_lib.api.client.particle.LcDamageIconParticle;
import architecture.goldenboughs_lib.api.client.particle.magicbullet.MagicBulletMagicCircleParticle;
import architecture.goldenboughs_lib.api.client.particle.solemnlament.ButterflyParticle;
import architecture.goldenboughs_lib.api.client.particle.text.DamageTextParticle;
import architecture.goldenboughs_lib.api.client.particle.text.TextParticleProvider;
import architecture.goldenboughs_lib.init.LibParticleTypes;
import architecture.imaginarycraft.core.ImaginaryCraft;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = ImaginaryCraft.ID, value = Dist.CLIENT)
public final class ParticleProvidersRegistry {
	@SubscribeEvent
	public static void registry(RegisterParticleProvidersEvent event) {
		event.registerSpecial(LibParticleTypes.TEXT.get(), new TextParticleProvider());
		event.registerSpecial(LibParticleTypes.DAMAGE_TEXT.get(), new DamageTextParticle.Provider());
		event.registerSpriteSet(LibParticleTypes.LC_DAMAGE_ICON.get(), LcDamageIconParticle.Provider::new);
		event.registerSpriteSet(LibParticleTypes.DYEING_MAGIC_CIRCLE.get(), DyeingMagicCircleParticle.Provider::new);
		event.registerSpriteSet(LibParticleTypes.MAGIC_BULLET_MAGIC_CIRCLE.get(), MagicBulletMagicCircleParticle.Provider::new);
		event.registerSpriteSet(LibParticleTypes.SOLEMN_LAMENT_BUTTERFLY_BLACK.get(), ButterflyParticle.Provider::new);
		event.registerSpriteSet(LibParticleTypes.SOLEMN_LAMENT_BUTTERFLY_WHITE.get(), ButterflyParticle.Provider::new);
	}
}

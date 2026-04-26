package architecture.imaginarycraft.core.registry.client;

import architecture.imaginarycraft.client.particle.DyeingMagicCircleParticle;
import architecture.imaginarycraft.client.particle.LcDamageIconParticle;
import architecture.imaginarycraft.client.particle.magicbullet.MagicBulletMagicCircleParticle;
import architecture.imaginarycraft.client.particle.solemnlament.ButterflyParticle;
import architecture.imaginarycraft.client.particle.text.DamageTextParticle;
import architecture.imaginarycraft.client.particle.text.TextParticleProvider;
import architecture.imaginarycraft.core.ImaginaryCraft;
import architecture.imaginarycraft.init.world.ModParticleTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;

@EventBusSubscriber(modid = ImaginaryCraft.ID, value = Dist.CLIENT)
public final class ParticleProvidersRegistry {
	@SubscribeEvent
	public static void registry(RegisterParticleProvidersEvent event) {
		event.registerSpecial(ModParticleTypes.TEXT.get(), new TextParticleProvider());
		event.registerSpecial(ModParticleTypes.DAMAGE_TEXT.get(), new DamageTextParticle.Provider());
		event.registerSpriteSet(ModParticleTypes.LC_DAMAGE_ICON.get(), LcDamageIconParticle.Provider::new);
		event.registerSpriteSet(ModParticleTypes.DYEING_MAGIC_CIRCLE.get(), DyeingMagicCircleParticle.Provider::new);
		event.registerSpriteSet(ModParticleTypes.MAGIC_BULLET_MAGIC_CIRCLE.get(), MagicBulletMagicCircleParticle.Provider::new);
		event.registerSpriteSet(ModParticleTypes.SOLEMN_LAMENT_BUTTERFLY_BLACK.get(), ButterflyParticle.Provider::new);
		event.registerSpriteSet(ModParticleTypes.SOLEMN_LAMENT_BUTTERFLY_WHITE.get(), ButterflyParticle.Provider::new);
	}
}

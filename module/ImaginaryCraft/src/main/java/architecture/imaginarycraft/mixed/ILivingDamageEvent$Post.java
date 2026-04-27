package architecture.imaginarycraft.mixed;

import architecture.goldenboughs_lib.api.NoMixinException;
import net.neoforged.neoforge.common.damagesource.DamageContainer;
import net.neoforged.neoforge.event.entity.living.LivingDamageEvent;

public interface ILivingDamageEvent$Post {
	static ILivingDamageEvent$Post of(LivingDamageEvent.Post obj) {
		return (ILivingDamageEvent$Post) obj;
	}

	default DamageContainer imaginaryCraft$getDamageContainer() {
		throw new NoMixinException();
	}
}

package architecture.imaginarycraft.mixed.client;

import architecture.imaginarycraft.api.NoMixinException;
import net.minecraft.client.KeyMapping;

public interface IKeyMapping {
	static IKeyMapping of(KeyMapping obj) {
		return obj;
	}

	default int imaginarycraft$getClickCount() {
		throw new NoMixinException();
	}
}

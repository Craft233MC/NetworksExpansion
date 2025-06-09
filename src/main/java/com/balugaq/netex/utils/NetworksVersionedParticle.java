package com.balugaq.netex.utils;

import com.balugaq.netex.api.enums.MinecraftVersion;
import io.github.sefiraat.networks.Networks;
import java.lang.reflect.Field;
import javax.annotation.Nonnull;
import lombok.experimental.UtilityClass;
import org.bukkit.Particle;

@UtilityClass
public class NetworksVersionedParticle {
    public static final @Nonnull Particle DUST;
    public static final @Nonnull Particle EXPLOSION;
    public static final @Nonnull Particle SMOKE;

    static {
        MinecraftVersion version = Networks.getInstance().getMCVersion();
        DUST = version.isAtLeast(MinecraftVersion.MC1_20_5) ? Particle.DUST : getKey("REDSTONE");
        EXPLOSION = version.isAtLeast(MinecraftVersion.MC1_20_5) ? Particle.EXPLOSION : getKey("EXPLOSION_LARGE");
        SMOKE = version.isAtLeast(MinecraftVersion.MC1_20_5) ? Particle.SMOKE : getKey("SMOKE_NORMAL");
    }

    @Nonnull
    private static Particle getKey(@Nonnull String key) {
        try {
            Field field = Particle.class.getDeclaredField(key);
            return (Particle) field.get(null);
        } catch (Exception ignored) {
            //noinspection DataFlowIssue
            return null;
        }
    }
}

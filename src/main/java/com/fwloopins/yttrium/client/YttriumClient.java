package com.fwloopins.yttrium.client;

import com.fwloopins.yttrium.client.config.YttriumConfig;
import com.fwloopins.yttrium.client.config.ConfigScreen;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YttriumClient implements ClientModInitializer {
    private static final Logger LOGGER = LoggerFactory.getLogger("Yttrium");
    private static YttriumConfig config = null;

    @Override
    public void onInitializeClient() {
        init();
        tick();

        logInfo("Yttrium initialised");
    }

    private void init() {
        AutoConfig.register(YttriumConfig.class, GsonConfigSerializer::new);
        config = AutoConfig.getConfigHolder(YttriumConfig.class).getConfig();

        ConfigScreen.createConfigKeybind();
    }

    private void tick() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ConfigScreen.configScreenTick(client);
        });
    }

    public static void logInfo(String msg) {
        LOGGER.info("[Yttrium] " + msg);
    }

    public static void logError(String msg) {
        LOGGER.error("[Yttrium] " + msg);
    }

    public static YttriumConfig getConfig() {
        return config;
    }
}

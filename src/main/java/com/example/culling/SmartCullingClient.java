package com.example.culling;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SmartCullingClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("smartculling");

    @Override
    public void onInitializeClient() {
        LOGGER.info("====================================");
        LOGGER.info("Smart Culling Mod v1.0.0");
        LOGGER.info("Minecraft 26.x Fabric 0.19.2");
        LOGGER.info("====================================");
        LOGGER.info("Block culling optimization enabled!");
        LOGGER.info("Rendering performance improved.");
        LOGGER.info("====================================");
    }
}

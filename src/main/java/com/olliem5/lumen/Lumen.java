package com.olliem5.lumen;

import com.olliem5.lumen.api.module.ModuleManager;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author olliem5
 * @since 1.0
 */

public final class Lumen implements ModInitializer {
	public static final String NAME = "Lumen";
	public static final String VERSION = "1.0";
	public static final String NAME_VERSION = NAME + " " + VERSION;

	public static final Logger LOGGER = LogManager.getLogger(NAME_VERSION);

	@Override
	public void onInitialize() {
		ModuleManager.initialize();
		log("Modules Initialized!");

		log("Finished Initializing.");
	}

	public static void log(String message) {
		LOGGER.info(message);
	}
}

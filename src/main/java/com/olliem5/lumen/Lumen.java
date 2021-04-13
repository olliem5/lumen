package com.olliem5.lumen;

import com.olliem5.lumen.api.module.ModuleManager;
import com.olliem5.lumen.impl.gui.navbar.NavbarElementManager;
import com.olliem5.lumen.impl.gui.window.WindowManager;
import com.olliem5.pace.handler.EventHandler;
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
	public static final EventHandler EVENT_HANDLER = new EventHandler();

	@Override
	public void onInitialize() {
		ModuleManager.initialize();
		EVENT_HANDLER.register(new ModuleManager());
		log("Modules Initialized!");

		NavbarElementManager.initialize();
		WindowManager.initialize();
		log("GUI Initialized!");

		log("Finished Initializing.");
	}

	public static void log(String message) {
		LOGGER.info(message);
	}
}

package net.mosus.grunglecraft;

import net.fabricmc.api.ModInitializer;

import net.mosus.grunglecraft.block.ModBlocks;
import net.mosus.grunglecraft.item.ModItemGroups;
import net.mosus.grunglecraft.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Grunglecraft implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "grunglecraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModItems.registerModItems();
		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();
		LOGGER.info("I am grungling");
	}
}
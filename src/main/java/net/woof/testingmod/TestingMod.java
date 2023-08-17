package net.woof.testingmod;

import net.fabricmc.api.ModInitializer;

import net.woof.testingmod.block.ModBlocks;
import net.woof.testingmod.effect.ModEffects;
import net.woof.testingmod.item.ModItemGroups;
import net.woof.testingmod.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestingMod implements ModInitializer {

	public static final String MOD_ID = "testingmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

        ModItemGroups.registerItemGroups();
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
        ModEffects.registerModEffects();
	}
}
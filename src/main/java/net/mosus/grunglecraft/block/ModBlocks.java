package net.mosus.grunglecraft.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.SlimeBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.mosus.grunglecraft.Grunglecraft;

public class ModBlocks {
    public static final Block GRUNGLE_ORE = registerBlock("grungle_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_ORE)));
    public static final Block DEEPSLATE_GRUNGLE_ORE = registerBlock("deepslate_grungle_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.DEEPSLATE_DIAMOND_ORE)));

    public static final Block GRUNGLE_BLOCK = registerBlock("grungle_block",
            new Block(FabricBlockSettings.copyOf(Blocks.SLIME_BLOCK).nonOpaque().strength(1.25F, 4.2F)));

    public static final Block HELL_NAW_BLOCK = registerBlock("hell_naw_block",
            new HellNahBlock(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Grunglecraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(Grunglecraft.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        Grunglecraft.LOGGER.info("Register grungle blocks ong");
    }
}

package net.mosus.grunglecraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.mosus.grunglecraft.Grunglecraft;
import net.mosus.grunglecraft.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup GRUNGLE_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Grunglecraft.MOD_ID, "grungle"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.grungle"))
                    .icon(() -> new ItemStack(ModItems.GRUNGLESTAFF)).entries((displayContext, entries) -> {
                        //Add Items
                        entries.add(ModItems.GRUNGLESTAFF);
                        entries.add(ModItems.GRUNGLEORB);
                        entries.add(ModItems.GRUNGLEDUST);
                        entries.add(ModItems.GRUNGLESHARD);
                        entries.add(ModItems.SCRINGLEROD);
                        entries.add(ModItems.SCRINGLECHARGE);
                        entries.add(ModItems.GRUNGLECHARGE);
                        // Add Blocks
                        entries.add(ModBlocks.GRUNGLE_ORE);
                        entries.add(ModBlocks.DEEPSLATE_GRUNGLE_ORE);
                        entries.add(ModBlocks.GRUNGLE_BLOCK);
                    }).build());

    public static void registerItemGroups() {
        Grunglecraft.LOGGER.info("Registering Grungle Item Group");
    }
}

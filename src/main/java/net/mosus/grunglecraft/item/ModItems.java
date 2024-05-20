package net.mosus.grunglecraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mosus.grunglecraft.Grunglecraft;

public class ModItems {

    // ITEM TEMPLATE
    // public static final Item [ITEMNAME] = registerItem("[item_id]", new Item(new Item.Settings()));
    public static final Item GRUNGLESTAFF = registerItem("grungle_staff", new Item(new Item.Settings()));
    public static final Item GRUNGLEORB = registerItem("grungle_orb", new Item(new Item.Settings()));
    public static final Item GRUNGLEDUST = registerItem("grungle_dust", new Item(new Item.Settings()));
    public static final Item GRUNGLESHARD = registerItem("grungle_shard", new Item(new Item.Settings()));
    public static final Item SCRINGLEROD = registerItem("scringle_rod", new Item(new Item.Settings()));
    public static final Item SCRINGLECHARGE = registerItem("scringle_charge", new ScringleChargeItem(new Item.Settings()));
    public static final Item GRUNGLECHARGE = registerItem("grungle_charge", new GrungleChargeItem(new Item.Settings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(GRUNGLESTAFF);
        entries.add(GRUNGLEORB);
    }

    private static Item registerItem(String name, Item item) {

        return Registry.register(Registries.ITEM, new Identifier(Grunglecraft.MOD_ID, name), item);
    }

    public static void registerModItems() {

        Grunglecraft.LOGGER.info("Registering grunglecraft items");

        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItems::addItemsToIngredientItemGroup);
        //ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}

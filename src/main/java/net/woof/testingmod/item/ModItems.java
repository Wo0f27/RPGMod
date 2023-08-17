package net.woof.testingmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.woof.testingmod.TestingMod;
import net.woof.testingmod.item.custom.BloodlettersLamentItem;
import net.woof.testingmod.item.custom.DragonSlayerSpearItem;

public class ModItems {


    public static final Item TITANIUM = registerItem("titanium",
            new Item(new FabricItemSettings()));
    public static final Item ALUMINUM = registerItem("aluminum",
            new Item(new FabricItemSettings()));
    public static final Item BLOODLETTERS_LAMENT = registerItem("bloodletters_lament",
            new BloodlettersLamentItem(ToolMaterials.DIAMOND, 8, 1f, new FabricItemSettings()));
    public static final Item DRAGON_SLAYER_SPEAR = registerItem("dragon_slayer_spear",
            new DragonSlayerSpearItem(ToolMaterials.DIAMOND, 10, 3, new FabricItemSettings()));


    public static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {

        entries.add(TITANIUM);
        entries.add(ALUMINUM);
    }


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(TestingMod.MOD_ID,
                name), item);
    }

    public static void registerModItems(){
        TestingMod.LOGGER.info("Registering items for " + TestingMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}

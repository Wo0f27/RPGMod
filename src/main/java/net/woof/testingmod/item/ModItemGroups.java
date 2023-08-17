package net.woof.testingmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.woof.testingmod.TestingMod;
import net.woof.testingmod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup METALS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestingMod.MOD_ID, "metals"), FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.metals"))
                    .icon(() -> new ItemStack(ModItems.TITANIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.TITANIUM);
                        entries.add(ModItems.ALUMINUM);
                        entries.add(Items.IRON_INGOT);
                        entries.add(Items.GOLD_INGOT);
                        entries.add(ModBlocks.TITANIUM_BLOCK);

                    }).build());
    public static final ItemGroup MOD_WEAPONS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestingMod.MOD_ID, "mod_weapons"), FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.mod_weapons"))
                    .icon(() -> new ItemStack(ModItems.TITANIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.BLOODLETTERS_LAMENT);
                        entries.add(ModItems.DRAGON_SLAYER_SPEAR);


                    }).build());

    public static void registerItemGroups(){
        TestingMod.LOGGER.info("Registering Item Groups for " + TestingMod.MOD_ID);
    }
}

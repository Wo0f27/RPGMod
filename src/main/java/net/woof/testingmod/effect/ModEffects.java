package net.woof.testingmod.effect;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.woof.testingmod.TestingMod;
import net.woof.testingmod.item.ModItems;


public class ModEffects {
    public static final StatusEffect BLEED = registerEffect("bleed", new BleedEffect(StatusEffectCategory.HARMFUL, 10303293));
    public static final StatusEffect STUN = registerEffect("stun", new StunEffect(StatusEffectCategory.HARMFUL, 12221440)) ;


    public static StatusEffect registerEffect(String name, StatusEffect effect){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(TestingMod.MOD_ID, name), effect);

    }
    public static void registerModEffects(){
        TestingMod.LOGGER.info("Registering effects for " + TestingMod.MOD_ID);

    }

}

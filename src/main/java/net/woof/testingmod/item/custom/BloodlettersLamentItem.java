package net.woof.testingmod.item.custom;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.woof.testingmod.effect.ModEffects;

public class BloodlettersLamentItem extends SwordItem {

    private int addition;

    public BloodlettersLamentItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.addition = addition;
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int amplifier = 0;
            if (target.hasStatusEffect(ModEffects.BLEED))
                amplifier = target.getStatusEffect(ModEffects.BLEED).getAmplifier() + 1;
            target.addStatusEffect(new StatusEffectInstance(ModEffects.BLEED, 300 + addition * 20, amplifier > 2 ? 2 : amplifier, false, false, true));
            target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 3, false, true));
        return super.postHit(stack, target, attacker);
    }
}

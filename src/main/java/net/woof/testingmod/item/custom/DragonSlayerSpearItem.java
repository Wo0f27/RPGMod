package net.woof.testingmod.item.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.*;
import net.minecraft.entity.projectile.PersistentProjectileEntity;

import java.util.function.Supplier;


public class DragonSlayerSpearItem extends SwordItem {
    private int addition;



    public DragonSlayerSpearItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
        this.addition = addition;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int amplifier = 0;
        if (target.hasStatusEffect(StatusEffects.WEAKNESS))
            amplifier = target.getStatusEffect(StatusEffects.INSTANT_DAMAGE).getAmplifier() + 1;
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 300 + addition * 20, amplifier > 2 ? 2 : amplifier, false, false, true));
        target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 600, 3, false, true));
        return super.postHit(stack, target, attacker);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);
        PlayerEntity player = (PlayerEntity) entity;
        int amplifier = 2;
        ((PlayerEntity) entity).addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 600 + addition*20, amplifier>2?2:amplifier, false, false , true));
    }


}

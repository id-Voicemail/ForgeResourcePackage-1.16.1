package com.idtech.entity;

import com.google.common.collect.Sets;
import com.idtech.Utils;
import com.idtech.item.LightningArrowItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.PotionUtils;
import net.minecraft.potion.Potions;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;


/*
This is the entity for a lightning arrow.

We will spawn one for these when a lightning arrow is use as ammo.
 */

public class LightningArrowEntity extends AbstractArrowEntity {

    // Simple constructor that has a world and a shooter
    public LightningArrowEntity(World world, LivingEntity livingEntity) {
        super(EntityType.ARROW, livingEntity, world);
    }

    // this function is called when picking up a missed arrow. We set this so if a lightning arrow is shot a lightning arrow is returned.
    protected ItemStack getArrowStack() {
        return new ItemStack(LightningArrowItem.INSTANCE);
    }

    // this function is called when the arrow impacts a mob or block. this is where we can change an arrows behaviour. for this arrow we will strike lightning.
    @Override
    protected void onImpact(RayTraceResult p_70227_1_) {
        BlockPos pos = new BlockPos(this.getPositionVec());
        Utils.strikeLightning(this.getEntityWorld(), pos);
        super.onImpact(p_70227_1_);
    }
}

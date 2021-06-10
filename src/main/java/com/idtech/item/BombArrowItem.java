package com.idtech.item;

import com.idtech.entity.BombArrowEntity;
import com.idtech.entity.LightningArrowEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

// Important to extend ArrowItem
public class BombArrowItem extends ArrowItem {

    // classic item setup
    private static Properties properties = new Properties().group(ItemGroup.MISC);
    public static Item INSTANCE = new BombArrowItem(properties).setRegistryName("bombarrow");;

    //constructor
    public BombArrowItem(Properties properties){
        super(properties);
    }

    // this function is called when the bow creates an arrow entity by consuming this item
    // we will change the created entity to our custom arrow entity
    @Override
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        BombArrowEntity arrowentity = new BombArrowEntity(worldIn, shooter);
        return arrowentity;
    }
}

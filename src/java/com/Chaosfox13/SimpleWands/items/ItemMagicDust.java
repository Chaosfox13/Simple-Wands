package com.Chaosfox13.SimpleWands.items;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class ItemMagicDust extends ItemSW {

	public ItemMagicDust(String unlocalizedName) 
	{
		super(unlocalizedName);
		
	}
	  public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		if (!playerIn.capabilities.isCreativeMode)
        {
            --stack.stackSize;
            
        }

		 if (worldIn != null)
	        {
	            double posX = playerIn.posX;
	            double posY = playerIn.posY+1;
	            double posZ = playerIn.posZ;
	            float f = 1.0F;
	            float f1 = f * 0.6F + 0.4F;
	            float f2 = f * f * 0.7F - 0.5F;
	            float f3 = f * f * 0.6F - 0.7F;

	            for (int l = 0; l < 8; ++l)
	            {
	                worldIn.spawnParticle(EnumParticleTypes.VILLAGER_HAPPY, posX + Math.random() - Math.random(), posY + Math.random() - Math.random(), posZ + Math.random() - Math.random(), f1, f2, f3);
	            }
	        }


		return stack;
		
	}

}

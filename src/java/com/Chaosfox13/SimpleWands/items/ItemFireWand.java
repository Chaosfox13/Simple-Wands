package com.Chaosfox13.SimpleWands.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemFireWand extends ItemWandTemplate
{

	public ItemFireWand(String unlocalizedName) {
		super(unlocalizedName);
	}
	public ItemStack onItemRightClick(ItemStack wand, World world,EntityPlayer player)
	{
		if(!isInitialized(wand))
		{
			this.initialize(wand);
		}
		int castType=getShort("castType", wand);
		switch(castType){
			case 1: castType = 1;
				break;
			default: castType =0;
				break;		
		}
		return wand;
	}
	public boolean onItemUse(ItemStack wand, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if(!isInitialized(wand))
		{
			this.initialize(wand);
		}
		int castType=getShort("castType", wand);
		switch(castType){
			case 1: castType = 1;
				ignition( wand,  player, world, pos, side,hitX, hitY, hitZ);
				return true;
			default: castType=0;
				return false;
		}
	}
	private boolean ignition(ItemStack wand, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX,float hitY, float hitZ)
	{
		// taken from the minecraft flint and steel code
		pos = pos.offset(side);

        if (!player.canPlayerEdit(pos, side, wand))
        {
            return false;
        }
        else
        {
            if (world.isAirBlock(pos))
            {
                world.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
                world.setBlockState(pos, Blocks.fire.getDefaultState());
            }

            wand.damageItem(1, player);
            return true;
        }
	}
	@Override
	protected void initialize(ItemStack wand){
		super.initialize(wand);
		setShort("castType", wand, 1);
	}
	
}

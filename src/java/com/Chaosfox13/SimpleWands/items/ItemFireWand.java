package com.Chaosfox13.SimpleWands.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemFireWand extends ItemWandTemplate
{

	private IInventory inventory;
	private int slot;
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
		if (!player.canPlayerEdit(pos, side, wand))
        {
            return false;
        }
        else
        {
        	int castType=getShort("castType", wand);
			switch(castType){
				case 1: castType = 1;
					ignition( wand,  player, world, pos, side,hitX, hitY, hitZ);
					return true;
				default: castType=0;
					return false;
			}
        }
	}
	private int calculateCost(ItemStack wand)
	{
		return 1;
		/*
		int cost;
		int castType=getShort("castType", wand);
		switch(castType){
			case 1: castType = 1;
				cost=getShort("radius", wand);
				return cost;
			default: castType=0;
				return 1;
		}
		*/
	}
	private int findTheCiboreum(IInventory inventory)
	{
		//return 5;
		
		ItemStack ciboreum = new ItemStack(SWItems.ciboreum, 1, 0);
		for (int slot = 0; slot < inventory.getSizeInventory(); slot++) {
			ItemStack stack = inventory.getStackInSlot(slot);
			if (stack == null) 
			{
				continue;
			}
			if (!inventory.getStackInSlot(slot).isItemEqual(ciboreum)) 
			{
				continue;
			}
			return slot;
		}
		return 1;
		
	}
	/*
	private boolean findTheCiboreumAndDraw(IInventory inventory, ItemStack wand)
	{
		ItemStack ciboreum = new ItemStack(SWItems.ciboreum, 1, 0);
		for (int slot = 0; slot < inventory.getSizeInventory(); slot++) {
			ItemStack stack = inventory.getStackInSlot(slot);
			
			if (stack == null) 
			{
				continue;
			}
			
			if (inventory.getStackInSlot(slot).isItemEqual(ciboreum)) 
			{
				if (getShort("itemQuantity",stack)>=calculateCost(wand))
				{
					int currentDU = getShort("itemQuantity",stack);
					setShort("itemQuantity",stack,currentDU-calculateCost(wand));
					return true;
				}
			}
		}
		return false;
	}
	*/
	private boolean ignition(ItemStack wand, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX,float hitY, float hitZ)
	{
		// taken bits and pieces from the minecraft flint and steel code
		 IInventory inventory= playerIn.inventory;
		 pos = pos.offset(side);
		/*
		 int ciboreumSlot=findTheCiboreum(inventory, wand);
	     if (ciboreumSlot==-1){return false;}
	     ItemStack ciboreum=inventory.getStackInSlot(ciboreumSlot);
	     if(getShort("itemQuantity",ciboreum)<calculateCost(wand)){return false;}
	     setShort("itemQuantity",ciboreum,getShort("itemQuantity",ciboreum)-calculateCost(wand));
        */
		 int ciboreumSlot=findTheCiboreum(inventory);
		 
	     //ItemStack ciboreum=inventory.getStackInSlot(ciboreumSlot);
	     //int newValue = getShort("itemQuantity",ciboreum)-calculateCost(wand);
	     //setShort("itemQuantity",ciboreum, newValue);
	     
	     if (worldIn.isAirBlock(pos))
         {
             worldIn.playSoundEffect((double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
             worldIn.setBlockState(pos, Blocks.fire.getDefaultState());
         }
	  

         return true;
	}
	public void addInformation(ItemStack ist, EntityPlayer player, List infoList, boolean par4)
	{
		infoList.add(""+findTheCiboreum(player.inventory));
	}
	@Override
	protected void initialize(ItemStack wand){
		super.initialize(wand);
		setShort("castType", wand, 1);
		//setShort("radius", wand, 1);
	}

}

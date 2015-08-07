package com.Chaosfox13.SimpleWands.items;

import com.Chaosfox13.SimpleWands.SimpleWands;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemSW extends Item 
{
	public ItemSW(String unlocalizedName)
	{
		super();
		
	    this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(SimpleWands.tabSimpleWands);
	}
}

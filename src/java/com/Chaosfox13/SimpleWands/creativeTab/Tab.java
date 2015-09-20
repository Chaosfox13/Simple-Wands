package com.Chaosfox13.SimpleWands.creativeTab;

import com.Chaosfox13.SimpleWands.items.SWItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class Tab extends CreativeTabs
{

	public Tab(int index, String label) {
		super(index, label);
		
	}

	@Override
	public Item getTabIconItem() {
		return SWItems.ciboreum;
	}
	
}

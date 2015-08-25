package com.Chaosfox13.SimpleWands.items;

import net.minecraft.item.ItemStack;

public abstract class ItemWandTemplate extends ItemSW {

	public ItemWandTemplate(String unlocalizedName) 
	{
		super(unlocalizedName);
		this.setMaxStackSize(1);
	}
	
	protected void initialize(ItemStack wand)
	{
		setBoolean("initialized", wand, true);
		//setString("castType",wand,"default");
	}
	protected boolean isInitialized(ItemStack wand)
	{
		return getBoolean("initialized", wand);
	}
	
}

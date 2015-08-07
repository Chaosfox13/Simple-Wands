package com.Chaosfox13.SimpleWands.proxy;

import com.Chaosfox13.SimpleWands.blocks.SWBlocks;
import com.Chaosfox13.SimpleWands.crafting.SWCrafting;
import com.Chaosfox13.SimpleWands.items.SWItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	 
	    public void preInit(FMLPreInitializationEvent e) 
	    {	       
	    	SWItems.createItems();
	    	SWBlocks.createBlocks();
	    }

	    public void init(FMLInitializationEvent e) 
	    {
	    	SWCrafting.initCrafting();
	    }

	    public void postInit(FMLPostInitializationEvent e) 
	    {
	    }
}

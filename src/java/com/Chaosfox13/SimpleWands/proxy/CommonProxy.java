package com.Chaosfox13.SimpleWands.proxy;

import com.Chaosfox13.SimpleWands.items.SWItems;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy 
{
	 
	    public void preInit(FMLPreInitializationEvent e) 
	    {	       
	    	SWItems.createItems();
	    }

	    public void init(FMLInitializationEvent e) 
	    {  
	    }

	    public void postInit(FMLPostInitializationEvent e) 
	    {
	    }
}
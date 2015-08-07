package com.Chaosfox13.SimpleWands.proxy;

import com.Chaosfox13.SimpleWands.client.render.items.ItemRenderRegister;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy
{
		@Override
	    public void preInit(FMLPreInitializationEvent e) {
	        super.preInit(e);
	    }

	    @Override
	    public void init(FMLInitializationEvent e) {
	        super.init(e);
	        ItemRenderRegister.registerItemRenderer(); 
	        System.out.println("Is this the real life?");
	    }

	    @Override
	    public void postInit(FMLPostInitializationEvent e) {
	        super.postInit(e);
	    }
}
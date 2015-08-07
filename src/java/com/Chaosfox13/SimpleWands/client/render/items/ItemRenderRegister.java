package com.Chaosfox13.SimpleWands.client.render.items;

import com.Chaosfox13.SimpleWands.items.SWItems;
import com.Chaosfox13.SimpleWands.reference.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class ItemRenderRegister 
{
    public static void registerItemRenderer() 
    {
    	reg(SWItems.magicDust);
    	reg(SWItems.magicStick);
    	// Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SWItems.magicDust, 0, new ModelResourceLocation("SimpleWands:magicDust", "inventory"));
    	//ModelResourceLocation res = new ModelResourceLocation("SimpleWands:magic_dust", "inventory");
    	//Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(SWItems.magicDust, 0, res);
    }
    public static void reg(Item item)
    {
        Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
        .register(item, 0, new ModelResourceLocation(Reference.MOD_ID.toLowerCase()+ ":" + item.getUnlocalizedName().substring(5), "inventory"));
    }
}

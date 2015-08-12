package com.Chaosfox13.SimpleWands.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class SWItems
{
	public static ItemSW magicDust= new ItemMagicDust("magic_dust");
	public static Item magicStick= new ItemMagicStick("magic_stick");
	public static Item ciboreum= new ItemCiboreum("ciboreum");
	
	public static void createItems() 
	{
		GameRegistry.registerItem(magicDust, "magic_dust");
		GameRegistry.registerItem(magicStick, "magic_stick");
		GameRegistry.registerItem(ciboreum , "ciboreum");
    }
}

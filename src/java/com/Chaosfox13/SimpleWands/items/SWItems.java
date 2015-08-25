package com.Chaosfox13.SimpleWands.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class SWItems
{
	public static ItemSW magicDust= new ItemMagicDust("magic_dust");
	public static ItemSW magicStick= new ItemMagicStick("magic_stick");
	public static ItemSW ciboreum= new ItemCiboreum("ciboreum");
	public static ItemSW testyStick= new TestyStick("test");
	public static ItemSW fireWand= new ItemFireWand("fire_wand");
	public static void createItems() 
	{
		GameRegistry.registerItem(magicDust, "magic_dust");
		GameRegistry.registerItem(magicStick, "magic_stick");
		GameRegistry.registerItem(ciboreum , "ciboreum");
		GameRegistry.registerItem(testyStick, "test");
		GameRegistry.registerItem( fireWand, "fire_wand");
    }
}

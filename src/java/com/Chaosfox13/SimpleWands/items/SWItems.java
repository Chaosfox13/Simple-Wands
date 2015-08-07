package com.Chaosfox13.SimpleWands.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public final class SWItems
{
	public static Item magicDust;
	public static Item  magicStick;
	
	public static void createItems() 
	{
		GameRegistry.registerItem(magicDust = new ItemSW("magic_dust"), "magic_dust");
		GameRegistry.registerItem(magicStick = new ItemSW("magic_stick"), "magic_stick");
    }
}

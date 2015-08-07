package com.Chaosfox13.SimpleWands.crafting;

import com.Chaosfox13.SimpleWands.items.SWItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SWCrafting 
{
	public static void initCrafting() 
	{
		GameRegistry.addShapelessRecipe(new ItemStack(SWItems.magicStick), new Object[] {Items.stick,Items.stick, SWItems.magicDust});

	}
}

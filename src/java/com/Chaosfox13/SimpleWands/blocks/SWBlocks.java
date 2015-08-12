package com.Chaosfox13.SimpleWands.blocks;
import com.Chaosfox13.SimpleWands.blocks.BlockSW;
import com.Chaosfox13.SimpleWands.items.SWItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class SWBlocks 
{
	public static Block etherOre;
	public static void createBlocks()
	{
		GameRegistry.registerBlock(etherOre=new OreSW("ether_ore", Material.rock, 2.0f, 10.0f, SWItems.magicDust, 0, 1, 1).setLightLevel(.2f),"ether_ore");
	}
}

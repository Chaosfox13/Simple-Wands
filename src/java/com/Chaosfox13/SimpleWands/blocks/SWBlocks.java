package com.Chaosfox13.SimpleWands.blocks;
import com.Chaosfox13.SimpleWands.blocks.BlockSW;

import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;
public class SWBlocks 
{
	public static Block etherOre;
	public static void createBlocks()
	{
		GameRegistry.registerBlock(etherOre=new BlockSW("ether_ore").setLightLevel(.2f),"ether_ore");
	}
}

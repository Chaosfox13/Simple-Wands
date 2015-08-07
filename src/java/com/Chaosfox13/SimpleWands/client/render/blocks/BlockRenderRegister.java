package com.Chaosfox13.SimpleWands.client.render.blocks;

import com.Chaosfox13.SimpleWands.blocks.SWBlocks;
import com.Chaosfox13.SimpleWands.reference.Reference;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class BlockRenderRegister 
{
	public static void registerBlockRenders()
	{
		reg(SWBlocks.etherOre);
	}
	public static void reg(Block block) 
	{
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher()
	    .register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(Reference.MOD_ID.toLowerCase() + ":" + block.getUnlocalizedName().substring(5), "inventory"));
	}
}

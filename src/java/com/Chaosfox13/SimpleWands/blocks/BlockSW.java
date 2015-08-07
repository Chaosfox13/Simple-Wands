package com.Chaosfox13.SimpleWands.blocks;

import com.Chaosfox13.SimpleWands.SimpleWands;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockSW extends Block
{

	public BlockSW(String unlocalizedName, Material material, float hardness, float resistance) {
        super(material);
        this.setUnlocalizedName(unlocalizedName);
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.setHardness(hardness);
        this.setResistance(resistance);
        this.setCreativeTab(SimpleWands.tabSimpleWands);
    }

    public BlockSW(String unlocalizedName, float hardness, float resistance) {
        this(unlocalizedName, Material.rock, hardness, resistance);
        this.setCreativeTab(SimpleWands.tabSimpleWands);
    }

    public BlockSW(String unlocalizedName) {
        this(unlocalizedName, 2.0f, 10.0f);
        this.setCreativeTab(SimpleWands.tabSimpleWands);
    }

}

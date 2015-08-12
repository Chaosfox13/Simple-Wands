package com.Chaosfox13.SimpleWands.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class OreSW extends BlockSW {
	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	public OreSW(String unlocalizedName, Material material, float hardness, float resistance, Item item, int meta, int least, int most) 
	{
		super(unlocalizedName, material, hardness, resistance);
		this.drop=item;
        this.meta=meta;
        this.least_quantity=least;
        this.most_quantity=most;
        this.setHarvestLevel("pick", 1);
	}
	@Override
	public Item getItemDropped(IBlockState blockstate, Random random, int fortune) {
		return this.drop;
	}

	@Override
	public int damageDropped(IBlockState blockstate) {
		return this.meta;
	}

	@Override
	public int quantityDropped(IBlockState blockstate, int fortune, Random random) {
		if (this.least_quantity >= this.most_quantity)
			return this.least_quantity;
		return this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	}
}

package com.Chaosfox13.SimpleWands.items;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class TestyStick extends ItemSW {

	public TestyStick(String unlocalizedName) 
	{
		super(unlocalizedName);
		this.setMaxDamage(100);
	}
	@Override
	public void onUpdate(ItemStack ist, World world, Entity e, int i, boolean f) {
		super.onUpdate(ist, world, e, i, f);
		ist.setItemDamage(50);
		
	}
}

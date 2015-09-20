package com.Chaosfox13.SimpleWands.items;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.nbt.NBTTagCompound;

public class ItemCiboreum extends ItemSW {
	private ItemStack DEFAULT_TARGET_ITEM;
    
	public ItemCiboreum(String unlocalizedName) 
	{
		super(unlocalizedName);
		this.setMaxDamage(1000);
		this.setMaxStackSize(1);
		canRepair=false;
		this.DEFAULT_TARGET_ITEM = new ItemStack(SWItems.magicDust, 1, 0);
		
	}
	
	protected void updateItemDamage(ItemStack item) 
	{
		int capacity = getCapacity(item);
		int quantity = getQuantity(item);
		int damageValue = quantity;
		item.setItemDamage((int)damageValue);
	}
	protected int getCapacity(ItemStack item)
	{
		return getShort("capacity",item);
	}
	public void addInformation(ItemStack ist, EntityPlayer player, List infoList, boolean par4) {
		infoList.add("Total Storage:"+getCapacity(ist)+"dU");
		infoList.add("Storing:"+getQuantity(ist)+"dU");
		if (isActive(ist)) {
			infoList.add("Active");
		}
	}
	protected void setCapacity(ItemStack ist, int i) {
		setShort("capacity", ist, (short)i);
		updateItemDamage(ist);
	}
	public int getQuantity(ItemStack item)
	{
		return getShort("itemQuantity",item);
	}
	public void setQuantity(ItemStack ist, int i) {
		setShort("itemQuantity", ist, (short)i);
		updateItemDamage(ist);
	}
	public void lowerQuantity(ItemStack stuff, int amount)
	{
		setQuantity(stuff, getQuantity(stuff)-amount);
	}
	protected boolean findAndRemove(IInventory inventory, ItemStack item) {
		for (int slot = 0; slot < inventory.getSizeInventory(); slot++) {
			ItemStack stack = inventory.getStackInSlot(slot);
			if (stack == null) {
				continue;
			}
			if (inventory.getStackInSlot(slot).isItemEqual(item)) {
				inventory.decrStackSize(slot, 1);
				return true;
			}
		}
		return false;
	}
	protected void absorbTargetItem(ItemStack ist, IInventory inventory) {
		int temp = this.getQuantity(ist);
		ItemStack target = DEFAULT_TARGET_ITEM;
		if (target == null) return;
		if (this.getMaxDamage()==this.getDamage(ist)) return;
		if (findAndRemove(inventory, target)) {
			this.setQuantity(ist,temp + 10);
		}
	}

	

	@Override
	public void onUpdate(ItemStack ist, World world, Entity e, int i, boolean f) {
		super.onUpdate(ist, world, e, i, f);
		if (!isInitialized(ist)) {
			initialize(ist, DEFAULT_TARGET_ITEM);
		}
		updateItemDamage(ist);
		if (world.isRemote) return;
		EntityPlayer player = null;
		if (e instanceof EntityPlayer) {
			player = (EntityPlayer)e;
		}
		if (player == null) return;
		if (!isActive(ist)) return;
		if (!(this.getQuantity(ist)<this.getCapacity(ist))) return;
		absorbTargetItem(ist, player.inventory);
		
	}

	protected boolean isActive(ItemStack ist) {
		return getBoolean("isActive", ist);
	}
	protected boolean isInitialized(ItemStack ist) {
		return getBoolean("initialized", ist);
	}
	protected void initialize(ItemStack ist, ItemStack target) {
		setCapacity(ist, 1000);
		setBoolean("initialized", ist, true);
	}
	protected void setIsActive(ItemStack ist, boolean b) {
		setBoolean("isActive", ist, b);
	}

	public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
	{
		if (this.isActive(stack)==true){
			this.setIsActive(stack, false);
		}
		else {
			this.setIsActive(stack, true);
		}
		return stack;
	}
	

}

package com.Chaosfox13.SimpleWands.items;

import com.Chaosfox13.SimpleWands.SimpleWands;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ItemSW extends Item 
{
	public ItemSW(String unlocalizedName)
	{
		super();
		
	    this.setUnlocalizedName(unlocalizedName);
	    this.setCreativeTab(SimpleWands.tabSimpleWands);
	}
	
	// NBT Management
	// Numbers
	public int getShort(String s, ItemStack ist) {
		if (ist.getTagCompound() == null) {
			ist.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound tagCompound = ist.getTagCompound();
		if (tagCompound.getShort(s) == 0) {
			tagCompound.setShort(s, (short)0);
		}
		return tagCompound.getShort(s);}
	public void setShort(String s, ItemStack ist, int i) {
		if (ist.getTagCompound() == null) {
			ist.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound tagCompound = ist.getTagCompound();
		tagCompound.setShort(s, (short)i);}
	//Booleans
	public boolean getBoolean(String s, ItemStack ist) {
		if (ist.getTagCompound() == null) {
			ist.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound tagCompound = ist.getTagCompound();
		if (tagCompound.getBoolean(s) == false) {
			tagCompound.setBoolean(s, false);
		}
		return tagCompound.getBoolean(s);}
	public void setBoolean(String s, ItemStack ist, boolean b) {
		if (ist.getTagCompound() == null) {
			ist.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound tagCompound = ist.getTagCompound();
		tagCompound.setBoolean(s, b);
	}
	//Strings
	public String getString(String tag,ItemStack target){
		if (target.getTagCompound() == null) {
			target.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound tagCompound = target.getTagCompound();
		if (tagCompound.getString(tag) == "") {
			tagCompound.setString(tag, "default");
		}
		return tagCompound.getString(tag);}
	public void setString(String tag, ItemStack target, String value) {
		if (target.getTagCompound() == null) {
			target.setTagCompound(new NBTTagCompound());
		}
		NBTTagCompound tagCompound = target.getTagCompound();
		tagCompound.setString(tag, value);
	}
	//end of NBT managers
}

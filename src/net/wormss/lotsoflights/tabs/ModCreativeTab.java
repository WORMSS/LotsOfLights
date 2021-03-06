package net.wormss.lotsoflights.tabs;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

class ModCreativeTab extends CreativeTabs
{
	int itemId = 1;
	
	ModCreativeTab(int id, String label)
	{
		super(id, label);
	}
	
	public ModCreativeTab setTabIconItemIndex(int value)
	{
		itemId = value;
		return this;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public int getTabIconItemIndex()
	{
		return itemId;
	}
	
}

package net.wormss.lotsoflights.tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.wormss.lotsoflights.data.ModReferences;

class ModCreativeTab extends CreativeTabs
{
	int itemId = 1;
	
	ModCreativeTab(int id, String label)
	{
		super(id, ModReferences.PREFIX_LANG + label);
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

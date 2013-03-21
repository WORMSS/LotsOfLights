package net.wormss.lotsoflights.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.proxy.CommonProxy;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItem extends Item
{
	public ModItem(int id, int iconIndex)
	{
		super(id);
		
		setIconIndex(iconIndex);
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
	}

	public ModItem setItemName(String internalName, String humanName)
	{
		setItemName(internalName);
		LanguageRegistry.addName(this, humanName);
		return this;
	}
	
	@Override
	public Item setItemName(String internalName)
	{
		return super.setItemName(ModReferences.PREFIX_ITEM + internalName);
	}

}

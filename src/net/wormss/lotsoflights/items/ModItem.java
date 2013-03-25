package net.wormss.lotsoflights.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.wormss.lotsoflights.data.ModReferences;
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
	
	@Override
	public Item setItemName(String internalName)
	{
		return super.setItemName(ModReferences.PREFIX_LANG + internalName);
	}

}

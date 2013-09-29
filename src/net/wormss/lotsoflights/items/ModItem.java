package net.wormss.lotsoflights.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;

public class ModItem extends Item
{
	public ModItem(int id)
	{
		super(id);

		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
	}

}

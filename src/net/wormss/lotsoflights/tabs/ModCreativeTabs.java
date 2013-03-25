package net.wormss.lotsoflights.tabs;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.wormss.lotsoflights.data.ModReferences;

public class ModCreativeTabs
{
	public static CreativeTabs lights;

	public static void register()
	{
		lights = new ModCreativeTab(CreativeTabs.getNextID(), ModReferences.NAME_TAB_LIGHTS)
			.setTabIconItemIndex(Block.torchWood.blockID);
	}
	
}

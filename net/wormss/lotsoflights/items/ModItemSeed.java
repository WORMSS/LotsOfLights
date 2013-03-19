package net.wormss.lotsoflights.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;
import net.wormss.lotsoflights.proxy.CommonProxy;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItemSeed extends ItemSeeds
{
	public ModItemSeed(int id, int iconIndex, int cropID)
	{
		this(id, iconIndex, cropID, Block.tilledField.blockID);
	}
	
	public ModItemSeed(int id, int iconIndex, int cropID, int soilBlockID)
	{
		super(id, cropID, soilBlockID);
		setIconIndex(iconIndex);
	}

	public ModItemSeed setItemName(String internalName, String humanName)
	{
		setItemName(internalName);
		LanguageRegistry.addName(this, humanName);
		return this;
	}
	
	@Override
	public String getTextureFile()
	{
		return CommonProxy.ITEMS_PNG;
	}
}

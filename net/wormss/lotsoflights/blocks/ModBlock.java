package net.wormss.lotsoflights.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.proxy.CommonProxy;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock extends Block
{
	public ModBlock(int id, int iconIndex, Material material)
	{
		super(id, iconIndex, material);
	}
	
	public ModBlock setBlockName(String internalName, String humanName)
	{
		setBlockName(internalName);
		LanguageRegistry.addName(this, humanName);
		return this;
	}
	
	@Override
	public Block setBlockName(String internalName)
	{
		return super.setBlockName(ModReferences.BLOCK_PREFIX + internalName);
	}
	
	@Override
	public String getTextureFile()
	{
		return CommonProxy.BLOCK_PNG;
	}

}

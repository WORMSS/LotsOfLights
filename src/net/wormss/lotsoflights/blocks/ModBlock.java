package net.wormss.lotsoflights.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.proxy.CommonProxy;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlock extends Block
{
	public ModBlock(int id, int iconIndex, Material material)
	{
		super(id, iconIndex, material);
	}
	
	public ModBlock(int id, Material material)
	{
		super(id, material);
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
		return super.setBlockName(ModReferences.PREFIX_BLOCK + internalName);
	}
	
	@Override
	public String getTextureFile()
	{
		return ModReferences.TEXTURE_BLOCKS;
	}

}

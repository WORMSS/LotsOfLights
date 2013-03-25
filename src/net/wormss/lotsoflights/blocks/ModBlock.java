package net.wormss.lotsoflights.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.data.ModReferences;
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
	
	@Override
	public Block setBlockName(String internalName)
	{
		return super.setBlockName(ModReferences.PREFIX_LANG + internalName);
	}

}

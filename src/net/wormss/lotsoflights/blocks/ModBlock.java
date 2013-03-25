package net.wormss.lotsoflights.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.render.ModRenderBlocks;

public class ModBlock extends Block
{
	protected String _internalName;
	
	public ModBlock(int id, int iconIndex, Material material)
	{
		super(id, iconIndex, material);
	}
	
	public ModBlock(int id, Material material)
	{
		super(id, material);
	}
	
	public ModBlock setBlockBounds(double minX, double minY, double minZ, double maxX, double maxY, double maxZ)
	{
		super.setBlockBounds((float)minX, (float)minY, (float)minZ, (float)maxX, (float)maxY, (float)maxZ);
		return this;
	}
	
	@Override
	public ModBlock setBlockName(String internalName)
	{
		_internalName = internalName;
		
		if ( !ModRenderBlocks.ids.containsKey(_internalName) )
		{
			ModRenderBlocks.ids.put(_internalName, 0);
		}
		
		super.setBlockName(ModReferences.PREFIX_LANG + internalName);
		return this;
	}
	
	public ModBlock setTextureFile(String texture)
	{
		super.setTextureFile(texture);
		return this;
	}
	
	@Override
	public int getRenderType()
	{
		return ModRenderBlocks.ids.get(_internalName);
	}

}

package net.wormss.lotsoflights.blocks;

import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.render.RenderBlockPole;

public class ModBlockPole extends ModBlock
{
	public ModBlockPole(int id, Material material)
	{
		super(id, material);
		setBlockBounds(.41F, 0, .41F, 0.59F, 1, 0.59F);
	}
	
	@Override
	public int getRenderType()
	{
		return RenderBlockPole.renderID;
	}
	
	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public String getTextureFile()
	{
		return ModReferences.TEXTURE_POLE;
	}
	
}

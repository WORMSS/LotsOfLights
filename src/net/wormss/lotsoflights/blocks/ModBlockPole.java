package net.wormss.lotsoflights.blocks;

import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.render.RenderBlockPole;

public class ModBlockPole extends ModBlock
{
	public ModBlockPole(int id, Material material)
	{
		super(id, material);
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
	
}

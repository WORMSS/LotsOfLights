package net.wormss.lotsoflights.blocks;

import net.minecraft.block.material.Material;

public class ModBlockPole extends ModBlock
{
	public ModBlockPole(int id, Material material)
	{
		super(id, material);
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

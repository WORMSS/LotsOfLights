package net.wormss.lotsoflights.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.render.RenderBlockTorch1;

public class ModBlockTorch1 extends ModBlock
{
	public ModBlockTorch1(int id, int iconIndex, Material material)
	{
		super(id, iconIndex, material);
	}
	
	@Override
	public int getRenderType()
	{
		return RenderBlockTorch1.renderID;
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

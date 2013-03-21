package net.wormss.lotsoflights.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockTorch1 implements ISimpleBlockRenderingHandler
{
	public static int renderID;
	
	public RenderBlockTorch1()
	{
		
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		int metadata;
		
		metadata = world.getBlockMetadata(x, y, z);
		RenderHelper.setup(x, y, z);
		
		RenderHelper.tessUV(RenderBlockTorch1Data.north);
		RenderHelper.tessUV(RenderBlockTorch1Data.east);
		RenderHelper.tessUV(RenderBlockTorch1Data.south);
		RenderHelper.tessUV(RenderBlockTorch1Data.west);
		RenderHelper.tessUV(RenderBlockTorch1Data.bottom);
		
		if ( metadata != 1 )
		{
			RenderHelper.setBrightness(0);
		}
		RenderHelper.tessUV(RenderBlockTorch1Data.northGlass);
		RenderHelper.tessUV(RenderBlockTorch1Data.eastGlass);
		RenderHelper.tessUV(RenderBlockTorch1Data.southGlass);
		RenderHelper.tessUV(RenderBlockTorch1Data.westGlass);
		
		return true;
	}
	
	
	
	@Override
	public boolean shouldRender3DInInventory()
	{
		return false;
	}
	
	@Override
	public int getRenderId()
	{
		return renderID;
	}
	
}
package net.wormss.lotsoflights.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.wormss.utils.Trace;
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
		TessellatorWrapper.setPosition(x, y, z);
		TessellatorWrapper.setBrightness(1);
		Trace.normal(this, "Torch1");
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.north);
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.east);
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.south);
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.west);
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.bottom);

		if ( world.getBlockMetadata(x, y, z) != 1 )
		{
			TessellatorWrapper.setBrightness(0);
		}
		
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.northGlass);
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.eastGlass);
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.southGlass);
		TessellatorWrapper.tessUV(RenderBlockTorch1Data.westGlass);
		
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
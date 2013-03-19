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
		RenderHelper.setup(x, y, z, block.getBlockTexture(world, x, y, z, 0));
		
		RenderHelper.tessUV(DataTorch1.north);
		RenderHelper.tessUV(DataTorch1.east);
		RenderHelper.tessUV(DataTorch1.south);
		RenderHelper.tessUV(DataTorch1.west);
		
		RenderHelper.tessUV(DataTorch1.bottom);
		
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
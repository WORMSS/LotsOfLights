package net.wormss.lotsoflights.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class RenderBlockPole implements ISimpleBlockRenderingHandler
{
	
	public static int renderID;

	public RenderBlockPole() { }
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer)
	{
		
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		TessellatorWrapper.setPosition(x, y, z);
		TessellatorWrapper.setBrightness(1);
		
		TessellatorWrapper.tessUV(RenderBlockPoleData.north);
		TessellatorWrapper.tessUV(RenderBlockPoleData.east);
		TessellatorWrapper.tessUV(RenderBlockPoleData.south);
		TessellatorWrapper.tessUV(RenderBlockPoleData.west);
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory()
	{
		return true;
	}
	
	@Override
	public int getRenderId()
	{
		return renderID;
	}
	
}

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
		
		TessellatorWrapper.setColour(0x0, 0xF, 0xF);
		TessellatorWrapper.tess(RenderBlockPoleData.north);
		TessellatorWrapper.tess(RenderBlockPoleData.east);
		TessellatorWrapper.tess(RenderBlockPoleData.south);
		TessellatorWrapper.tess(RenderBlockPoleData.west);
		
		return true;
	}
	
	@Override
	public boolean shouldRender3DInInventory()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public int getRenderId()
	{
		// TODO Auto-generated method stub
		return 0;
	}
	
}

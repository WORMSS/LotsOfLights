package net.wormss.lotsoflights.render;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.wormss.lotsoflights.blocks.ModBlock;
import net.wormss.lotsoflights.blocks.ModBlockLamp;
import net.wormss.lotsoflights.blocks.ModBlockPole;
import net.wormss.lotsoflights.data.R;
import net.wormss.utils.Trace;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ModRenderBlocks implements ISimpleBlockRenderingHandler
{
	public static final Map<String, Integer> ids = new HashMap<String,Integer>();
	
	public static final ModRenderBlocks instance = new ModRenderBlocks();
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		TessellatorWrapper.setPosition(0, 0, 0);
		TessellatorWrapper.setBrightness(1);
		TessellatorWrapper.setIconPool(((ModBlock)block).getIconPool());
		TessellatorWrapper.start();
		
		if ( modelId == ids.get(R.NAME.VICTORIAN_LAMP) )
		{
			renderVictorianLamp(metadata);
		}
		else if ( modelId == ids.get(R.NAME.VICTORIAN_POLE ) )
		{
			renderPole();
		}
		
		TessellatorWrapper.draw();
		
		renderer.clearOverrideBlockTexture();
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		TessellatorWrapper.setPosition(x, y, z);
		TessellatorWrapper.setBrightness(1);
		TessellatorWrapper.resetBugFix();
		
		Trace.normal(this, "Rendering", modelId, ids);
		TessellatorWrapper.setIconPool(((ModBlock)block).getIconPool());
		
		if ( modelId == ids.get(R.NAME.VICTORIAN_LAMP) )
		{
			renderVictorianLamp(world.getBlockMetadata(x, y, z));
		}
		else if ( modelId == ids.get(R.NAME.VICTORIAN_POLE) )
		{
			renderPole();
		}
		else if ( modelId == ids.get(R.NAME.PLATFORM_SIDE_LAMP) )
		{
			renderPlatformSide(world.getBlockMetadata(x, y, z));
		}
		else
		{
			renderer.renderStandardBlock(block, x, y, z);
		}
		return true; 
	}
	
	private void renderPlatformSide(int metadata)
	{
		Data_SubwaySideLamp.init();
		TessellatorWrapper.setTexturePool(metadata == 1 ? Data_SubwaySideLamp.texturesOn : Data_SubwaySideLamp.texturesOff);
		TessellatorWrapper.render(Data_SubwaySideLamp.obj);
	}

	private void renderSubwaySideLamp()
	{
		Data_SubwaySideLamp.init();
		TessellatorWrapper.render(Data_SubwaySideLamp.obj);
	}

	private void renderVictorianLamp(int metadata)
	{
		Data_VictorianLamp.init();
		TessellatorWrapper.setTexturePool(metadata == 1 ? Data_VictorianLamp.texturesOn : Data_VictorianLamp.texturesOff);
		TessellatorWrapper.render(Data_VictorianLamp.obj);
	}
	
	private void renderPole()
	{
		Data_Pole.init();
		TessellatorWrapper.setTexturePool(Data_Pole.textures);
		TessellatorWrapper.render(Data_Pole.obj);
	}
	
	@Override
	public boolean shouldRender3DInInventory()
	{
		return false;
	}
	
	@Override
	public int getRenderId()
	{
		return 0;
	}
	
}

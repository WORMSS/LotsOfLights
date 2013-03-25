package net.wormss.lotsoflights.render;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;
import net.wormss.lotsoflights.data.ModReferences;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class ModRenderBlocks implements ISimpleBlockRenderingHandler
{
	public static final Map<String, Integer> ids = new HashMap<String,Integer>();
	
	private static ModRenderBlocks _instance; 
	public static ModRenderBlocks instance()
	{
		if ( _instance == null )
		{
			_instance = new ModRenderBlocks();
		}
		
		return _instance;
	}
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
	{
		
	}
	
	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
	{
		TessellatorWrapper.setPosition(x, y, z);
		TessellatorWrapper.setBrightness(1);
		
		if ( modelId == ids.get(ModReferences.NAME_LAMP_1) )
		{
			return renderLamp1(world.getBlockMetadata(x, y, z));
		}
		if ( modelId == ids.get(ModReferences.NAME_POLE ) )
		{
			return renderPole();
		}
		
		
		return true;
	}
	
	private boolean renderLamp1(int metadata)
	{
		TessellatorWrapper.tessUV(Data_Lamp1.north);
		TessellatorWrapper.tessUV(Data_Lamp1.east);
		TessellatorWrapper.tessUV(Data_Lamp1.south);
		TessellatorWrapper.tessUV(Data_Lamp1.west);
		TessellatorWrapper.tessUV(Data_Lamp1.bottom);
		
		if ( metadata != 1 )
		{
			TessellatorWrapper.setBrightness(0);
		}
		
		TessellatorWrapper.tessUV(Data_Lamp1.northGlass);
		TessellatorWrapper.tessUV(Data_Lamp1.eastGlass);
		TessellatorWrapper.tessUV(Data_Lamp1.southGlass);
		TessellatorWrapper.tessUV(Data_Lamp1.westGlass);
		return true;
	}
	
	private boolean renderPole()
	{
		TessellatorWrapper.tessUV(Data_Pole.north);
		TessellatorWrapper.tessUV(Data_Pole.east);
		TessellatorWrapper.tessUV(Data_Pole.south);
		TessellatorWrapper.tessUV(Data_Pole.west);
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
		return 0;
	}
	
}

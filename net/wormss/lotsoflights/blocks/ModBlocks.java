package net.wormss.lotsoflights.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.data.ModReferences;
import cpw.mods.fml.common.registry.GameRegistry;


final public class ModBlocks
{
	public static Block torch1;
	
	public static final Map<String, Integer> ids = new HashMap<String,Integer>(){{
		put(ModReferences.NAME_TORCH_1, 500);
	}};


	private static boolean created;
	public static void create()
	{
		torch1 = new ModBlockTorch1(ids.get(ModReferences.NAME_TORCH_1), 1, Material.circuits)
			.setBlockName(ModReferences.NAME_TORCH_1, "Torch 1")
			.setLightValue(1.0F);
		
		
		
		
		created = true;
	}
	
	public static void register()
	{
		if (!created)
		{
			create();
		}
		
		GameRegistry.registerBlock(torch1, torch1.getBlockName());
	} 
}
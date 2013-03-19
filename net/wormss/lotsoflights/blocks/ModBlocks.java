package net.wormss.lotsoflights.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;


final public class ModBlocks
{
	private static boolean created;
	public static Block torch1;
	
	public static void createBlocks()
	{
		torch1 = new ModBlockTorch1(500, 1, Material.circuits)
			.setBlockName("torch1", "Torch 1")
			.setLightValue(1.0F);
		
		
		
		
		created = true;
	}
	
	public static void register()
	{
		if (!created)
		{
			createBlocks();
		}
		
		GameRegistry.registerBlock(torch1, torch1.getBlockName());
	} 
}
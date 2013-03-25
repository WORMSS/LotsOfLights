package net.wormss.lotsoflights.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.tabs.ModCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;


final public class ModBlocks
{
	public static final Map<String, Integer> ids = new HashMap<String,Integer>(){{
		put(ModReferences.NAME_LAMP_1, 500);
		put(ModReferences.NAME_POLE, 501);
	}};
	
	public static Block torch1;
	public static Block pole;
	
	public static void register()
	{
		torch1 = new ModBlockLamp(ids.get(ModReferences.NAME_LAMP_1), Material.circuits)
			.setBlockName(ModReferences.NAME_LAMP_1)
			.setTextureFile(ModReferences.TEXTURE_LAMP1);
		
		pole = new ModBlockPole(ids.get(ModReferences.NAME_POLE), Material.iron)
			.setBlockName(ModReferences.NAME_POLE)
			.setTextureFile(ModReferences.TEXTURE_POLE)
			.setBlockBounds(.41, 0, .41, 0.59, 1, 0.59)
			.setCreativeTab(ModCreativeTabs.lights);
		
		GameRegistry.registerBlock(torch1, torch1.getBlockName());
		GameRegistry.registerBlock(pole, pole.getBlockName());
	} 
}
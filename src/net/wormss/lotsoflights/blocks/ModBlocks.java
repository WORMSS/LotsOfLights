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
		put(ModReferences.NAME_VICTORIAN_LAMP, 500);
		put(ModReferences.NAME_POLE, 501);
		put(ModReferences.NAME_SUBWAY_SIDE_LAMP, 502);
	}};
	
	public static Block victorian;
	public static Block subwaySide;
	public static Block pole;
	
	public static void register()
	{
		victorian = new ModBlockLamp(ids.get(ModReferences.NAME_VICTORIAN_LAMP), Material.circuits)
			.setUnlocalizedName(ModReferences.NAME_VICTORIAN_LAMP);
		
		subwaySide = new ModBlockLamp(ids.get(ModReferences.NAME_SUBWAY_SIDE_LAMP), Material.circuits)
			.setUnlocalizedName(ModReferences.NAME_SUBWAY_SIDE_LAMP);
		
		pole = new ModBlockPole(ids.get(ModReferences.NAME_POLE), Material.iron)
			.setUnlocalizedName(ModReferences.NAME_POLE)
			.setBlockBounds(.41, 0, .41, 0.59, 1, 0.59)
			.setCreativeTab(ModCreativeTabs.lights);
		
		GameRegistry.registerBlock(victorian, victorian.getUnlocalizedName());
		GameRegistry.registerBlock(pole, pole.getUnlocalizedName());
		GameRegistry.registerBlock(subwaySide, subwaySide.getLocalizedName());
	} 
}
package net.wormss.lotsoflights.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.wormss.lotsoflights.data.R;
import net.wormss.lotsoflights.tabs.ModCreativeTabs;
import cpw.mods.fml.common.registry.GameRegistry;


final public class ModBlocks
{
	public static final Map<String, Integer> ids = new HashMap<String,Integer>(){{
		put(R.NAME.VICTORIAN_LAMP, 500);
		put(R.NAME.VICTORIAN_POLE, 501);
		put(R.NAME.PLATFORM_SIDE_LAMP, 502);
	}};
	
	public static Block victorian;
	public static Block subwaySide;
	public static Block pole;
	
	public static void register()
	{
		victorian = new ModBlockLamp(ids.get(R.NAME.VICTORIAN_LAMP), Material.circuits)
			.setUnlocalizedName(R.NAME.VICTORIAN_LAMP)
			.addIconName("Side", "Bottom", "Top");
		
		subwaySide = new ModBlockLamp(ids.get(R.NAME.PLATFORM_SIDE_LAMP), Material.circuits)
			.setUnlocalizedName(R.NAME.PLATFORM_SIDE_LAMP)
			.addIconName("Front", "Side");
		
		pole = new ModBlockPole(ids.get(R.NAME.VICTORIAN_POLE), Material.iron)
			.setUnlocalizedName(R.NAME.VICTORIAN_POLE)
			.addIconName("Side", "Cap")
			.setBlockBounds(.41, 0, .41, 0.59, 1, 0.59)
			.setCreativeTab(ModCreativeTabs.lights);
		
		GameRegistry.registerBlock(victorian, victorian.getUnlocalizedName());
		GameRegistry.registerBlock(pole, pole.getUnlocalizedName());
		GameRegistry.registerBlock(subwaySide, subwaySide.getLocalizedName());
	} 
}
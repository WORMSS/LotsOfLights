package net.wormss.lotsoflights.data;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.wormss.lotsoflights.blocks.ModBlocks;
import net.wormss.lotsoflights.data.ModReferences;

public class ModConfiguration
{
	static Configuration config;
	public static void init(File configDir)
	{
		config = new Configuration(new File(configDir.getAbsolutePath() + "\\" + ModReferences.ID + ".cfg"));
		try
		{
			config.load();
			getBlock(ModReferences.NAME_VICTORIAN_LAMP);
			getBlock(ModReferences.NAME_VICTORIAN_POLE);
			getBlock(ModReferences.NAME_PLATFORM_SIDE_LAMP);
		}
		finally
		{
			config.save();
		}
	}
	
	private static void getBlock(String name)
	{
		int value = ModBlocks.ids.get(name);
		value = config.getBlock(name, value).getInt(value);
		ModBlocks.ids.put(name, value);
	}
}
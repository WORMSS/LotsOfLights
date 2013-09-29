package net.wormss.lotsoflights.data;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.wormss.lotsoflights.blocks.ModBlocks;
import net.wormss.lotsoflights.data.R;

public class ModConfiguration
{
	static Configuration config;
	public static void init(File configDir)
	{
		config = new Configuration(new File(configDir.getAbsolutePath() + "\\" + R.MOD.ID + ".cfg"));
		try
		{
			config.load();
			getBlock(R.NAME.VICTORIAN_LAMP);
			getBlock(R.NAME.VICTORIAN_POLE);
			getBlock(R.NAME.PLATFORM_SIDE_LAMP);
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
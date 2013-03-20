package net.wormss.lotsoflights.data;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.wormss.lotsoflights.blocks.ModBlocks;
import net.wormss.utils.Trace;

public class ModConfiguration
{
	static Configuration config;
	public static void init(File configDir)
	{
		String configPath = configDir.getAbsolutePath() + "\\" + ModReferences.ID + ".cfg";
		File configFile = new File(configPath);
		
		config = new Configuration(configFile);
		
		try
		{
			config.load();
			
			getBlock(ModReferences.NAME_TORCH_1);
			
		}
		catch ( Exception err )
		{
			Trace.normal(ModConfiguration.class,  err.getStackTrace().toString());
		}
		finally
		{
			config.save();
		}
	}
	
	private static void getBlock(String name)
	{
		int value;
		value = ModBlocks.ids.get(name);
		value = config.getBlock(name, value).getInt(value);
		ModBlocks.ids.put(name, value);
	}
}
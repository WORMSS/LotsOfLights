package net.wormss.lotsoflights.items;

import java.util.HashMap;
import java.util.Map;


public class ModItems
{
	public static final Map<String, Integer> ids = new HashMap<String,Integer>(){{
		
	}};


	private static boolean created;
	public static void create()
	{
		
		created = true;
	}
	
	public static void register()
	{
		if (!created)
		{
			create();
		}
	} 
}

package net.wormss.lotsoflights.render;

import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.model.WavefrontObjReader;

class Data_SubwaySideLamp
{
	public static final UVSet[] texturesOn = new UVSet[]{
		new UVRect("Front1", "Front", 0, 0, 1, 1/6),
		new UVRect("Front2", "Front", 1/6, 0, 1, 1/6),
		new UVRect("Front3", "Front", 2/6, 0, 1, 1/6),
		new UVRect("Front4", "Front", 3/6, 0, 1, 1/6),
		new UVRect("Front5", "Front", 4/6, 0, 1, 1/6),
		new UVRect("Front6", "Front", 5/6, 0, 1, 1/6),
		new UVRect("Side", "Side")
	};
	public static final UVSet[] texturesOff = new UVSet[]{
		new UVRect("Front1", "Front", 0, 0, 1, 1/6),
		new UVRect("Front2", "Front", 1/6, 0, 1, 1/6),
		new UVRect("Front3", "Front", 2/6, 0, 1, 1/6),
		new UVRect("Front4", "Front", 3/6, 0, 1, 1/6),
		new UVRect("Front5", "Front", 4/6, 0, 1, 1/6),
		new UVRect("Front6", "Front", 5/6, 0, 1, 1/6),
		new UVRect("Side", "Side")
	};
	
	public static WavefrontObjReader obj;
	
	static void init()
	{
		if ( obj != null )
		{
			return;
		}
		obj = new WavefrontObjReader(ModReferences.OBJ_PLATFORM_SIDE_LAMP);
	}
}

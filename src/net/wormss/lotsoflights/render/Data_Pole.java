package net.wormss.lotsoflights.render;

import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.model.WavefrontObjReader;

class Data_Pole
{
	public static UVSet[] textures = new UVSet[]{
		new UVRect("Side", "Side"),
		new UVRect("Cap", "Cap")
	};
	
	public static WavefrontObjReader obj;
	
	public static void init()
	{
		if ( obj == null )
		{
			obj = new WavefrontObjReader(ModReferences.OBJ_VICTORIAN_POLE);
		}
	}
	
	
}

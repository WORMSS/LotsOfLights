package net.wormss.lotsoflights.render;

import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.model.WavefrontObjReader;

final class Data_VictorianLamp
{
	public static final UVSet[] texturesOn = new UVSet[]{
		new UVRect("Bottom", "Bottom"),
		new UVRect("Side", "Side"),
		new UVRect("Top", "Top")
	};
	
	public static final UVSet[] texturesOff = new UVSet[]{
		new UVRect("Bottom", "Bottom"),
		new UVRect("Side", "Side"),
		new UVRect("Top", "Top")
	};

	public static WavefrontObjReader obj;
	
	public static void init()
	{
		if ( obj == null )
		{
			obj = new WavefrontObjReader(ModReferences.OBJ_VICTORIAN_LAMP);
		}
	}
}
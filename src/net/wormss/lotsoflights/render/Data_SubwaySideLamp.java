package net.wormss.lotsoflights.render;

class Data_SubwaySideLamp
{
	private static UVSet defaultUV = new UVRect(0, 0, 1/3, 1);
	private static UVSet dipUV		= new UVRect(1/3, 0, 1/3, 1);
	private static UVSet glassUV	= new UVRect(2/3, 0, 1/3, 1);
	
	static PanelCollection north;
	
	static void init()
	{
		if ( north != null )
		{
			return;
		}
		
		north = ObjReader.read("/mods/PlatformSideLights.obj",
			new UVLink("Default", defaultUV),
			new UVLink("Dip", dipUV),
			new UVLink("Glass", glassUV));
	}
}

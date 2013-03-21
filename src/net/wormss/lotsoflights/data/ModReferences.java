package net.wormss.lotsoflights.data;

public final class ModReferences
{
	// Setup of the Mod
	public static final String	NAME			= "Lots of Lights";
	public static final String	ID				= "net.wormss.lotsoflights";
	public static final String	VERSION			= "1.4.7.0";
	
	// Setup of Proxies
	public static final String	PROXY_COMMON	= "net.wormss.lotsoflights.proxy.CommonProxy";
	public static final String	PROXY_CLIENT	= "net.wormss.lotsoflights.proxy.ClientProxy";
	
	// Setup Interal references
	public static final String	PREFIX_BLOCK	= "modLotsOfLightsBlock";
	public static final String	PREFIX_ITEM		= "modLotsOfLightsItem";
	
	// Setup Internal names
	public static final String	NAME_TORCH_1	= "torch1";
	public static final String	NAME_POLE		= "pole";
	
	// Setup of Textures
	private static final String	TR				= "/mods/" + ID + "/textures/";
	private static final String	TR_B			= TR + "blocks/";
	public static final String	TEXTURE_BLOCKS	= TR_B + "blocks.png";
	public static final String	TEXTURE_TORCH1	= TR_B + NAME_TORCH_1 + ".png";
}

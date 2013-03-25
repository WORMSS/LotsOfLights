package net.wormss.lotsoflights.data;

public final class ModReferences
{
	// Setup of the Mod
	public static final String	NAME	= "Lots of Lights";
	public static final String	ID		= "net.wormss.lotsoflights";
	public static final String	VERSION	= "1.4.7.0";
	
	// Setup of Proxies
	public static final String	PROXY_COMMON	= ID + ".proxy.CommonProxy";
	public static final String	PROXY_CLIENT	= ID + ".proxy.ClientProxy";
	
	// Setup Interal references
	public static final String	PREFIX_LANG		= "lol.";
	
	// Setup Internal names
	public static final String	NAME_LAMP_1		= "lamp1";
	public static final String	NAME_POLE		= "pole";
	public static final String	NAME_TAB_LIGHTS	= "lights";
	
	// Setup of Resources
	private static final String RES				= "/mods/" + ID + "/";
	private static final String	RES_TEX			= RES + "textures/";
	private static final String	RES_TEX_B		= RES_TEX + "blocks/";
	private static final String RES_TEX_I		= RES_TEX + "items/";
	
	public static final String	LANG_FOLDER		= RES + "lang/";
	public static final String	TEXTURE_LAMP1	= RES_TEX_B + NAME_LAMP_1 + ".png";
	public static final String	TEXTURE_POLE	= RES_TEX_B + NAME_POLE + ".png";
	
}

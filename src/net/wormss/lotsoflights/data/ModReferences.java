package net.wormss.lotsoflights.data;

import java.io.InputStream;

public final class ModReferences
{
	// Setup of the Mod
	public static final String	NAME	= "Lots of Lights";
	public static final String	ID		= "net.wormss.lotsoflights";
	public static final String	VERSION	= "1.5.1.0";
	
	// Setup of Proxies
	public static final String	PROXY_COMMON	= ID + ".proxy.CommonProxy";
	public static final String	PROXY_CLIENT	= ID + ".proxy.ClientProxy";
	
	// Setup Internal names
	public static final String	NAME_VICTORIAN_LAMP		= "lol.victorianLamp";
	public static final String	NAME_VICTORIAN_POLE		= "lol.victorianPole";
	public static final String	NAME_PLATFORM_SIDE_LAMP	= "lol.platformSideLamp";
	
	// Setup Creative Tab
	public static final String	TAB_LIGHTS			= "lol.lights";
	
	// Setup of Resources
	private static final String RES				= "/mods/" + ID + "/";
	public static final String	LANG_FOLDER		= RES + "lang/";
	
	// Setup of Wavefront Objects
	private static final String	OBJ_EXTENSION	= ".obj";
	public static final	InputStream	OBJ_VICTORIAN_LAMP		= ModReferences.class.getResourceAsStream(NAME_VICTORIAN_LAMP + OBJ_EXTENSION);
	public static final InputStream	OBJ_VICTORIAN_POLE		= ModReferences.class.getResourceAsStream(NAME_VICTORIAN_POLE + OBJ_EXTENSION);
	public static final InputStream	OBJ_PLATFORM_SIDE_LAMP	= ModReferences.class.getResourceAsStream(NAME_PLATFORM_SIDE_LAMP + OBJ_EXTENSION);
}

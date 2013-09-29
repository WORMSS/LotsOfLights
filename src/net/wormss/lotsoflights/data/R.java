package net.wormss.lotsoflights.data;

import java.io.InputStream;

public final class R
{
	public static final class MOD
	{
		// Setup of the Mod
		public static final String	NAME	= "Lots of Lights";
		public static final String	ID		= "net.wormss.lotsoflights";
		public static final String	VERSION	= "1.6.4.0";
		private static final String	ABBREVIATION = "lol.";
	}
	
	public static final class PROXY
	{
		// Setup of Proxies
		public static final String	COMMON	= MOD.ID + ".proxy.CommonProxy";
		public static final String	CLIENT	= MOD.ID + ".proxy.ClientProxy";
	}
	
	public static final class NAME
	{
		// Setup Internal names
		public static final String	VICTORIAN_LAMP		= MOD.ABBREVIATION + "victorianLamp";
		public static final String	VICTORIAN_POLE		= MOD.ABBREVIATION + "victorianPole";
		public static final String	PLATFORM_SIDE_LAMP	= MOD.ABBREVIATION + "platformSideLamp";
	}
	
	public static final class TAB
	{
		// Setup Creative Tab
		public static final String	LIGHTS	= MOD.ABBREVIATION + "lights";
	}
	
	public static final class FOLDER
	{
		// Setup of Resources
		private static final String ROOT	= "/assets/" + MOD.ID + "/";
		public static final String	MODEL	= ROOT + "models/";
	}
	
	public static final class OBJ
	{
		// Setup of Wavefront Objects
		private static final String	EXTENSION			= ".obj";
		public static final	String	VICTORIAN_LAMP		= FOLDER.MODEL + NAME.VICTORIAN_LAMP + EXTENSION;
		public static final String	VICTORIAN_POLE		= FOLDER.MODEL + NAME.VICTORIAN_POLE + EXTENSION;
		public static final String	PLATFORM_SIDE_LAMP	= FOLDER.MODEL + NAME.PLATFORM_SIDE_LAMP + EXTENSION;
	}
}

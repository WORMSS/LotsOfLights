package net.wormss.lotsoflights.data;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModLanguage
{
	/*
		"cs_CZ", "cy_GB", "de_DE", "es_ES", "fi_FI", "fr_FR", "it_IT", "ja_JP", "la_IT", "nl_NL",
		"no_NO", "pl_PL", "pt_BR", "pt_PT", "ru_RU", "sr_RS", "sv_SE", "tr_TR", "zh_CN", "zh_TW"
	*/
	private static final String[] locales = {"en_US"};
	
	public static void register()
	{
		for (String locale : locales)
		{
			LanguageRegistry.instance().loadLocalization(fileName(locale), locale, true);
		}
	}
	
	private static String fileName(String locale)
	{
		return ModReferences.LANG_FOLDER + locale + ".xml";
	}
}

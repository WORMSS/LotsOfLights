package net.wormss.lotsoflights;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.wormss.lotsoflights.blocks.ModBlocks;
import net.wormss.lotsoflights.data.ModConfiguration;
import net.wormss.lotsoflights.data.ModLanguage;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.items.ModItems;
import net.wormss.lotsoflights.proxy.CommonProxy;
import net.wormss.lotsoflights.tabs.ModCreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModReferences.ID, name = ModReferences.NAME, version = ModReferences.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LotsOfLights
{
	@Instance(ModReferences.ID)
	public static LotsOfLights	instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = ModReferences.PROXY_CLIENT, serverSide = ModReferences.PROXY_COMMON)
	public static CommonProxy	proxy;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent __e)
	{
		ModConfiguration.init(__e.getModConfigurationDirectory());
		
		ModLanguage.register();
		
		ModCreativeTabs.register();
		ModBlocks.register();
		ModItems.register();
	}
	
	@Init
	public void init(FMLInitializationEvent __e)
	{
		proxy.registerRenderers();
		
		_addDebugRecipes();
		_addRecipies();
	}

	private void _addRecipies()
	{
		ItemStack sLight1	= new ItemStack(ModBlocks.torch1, 64);
		ItemStack sPole		= new ItemStack(ModBlocks.pole, 64);
		
		GameRegistry.addRecipe(sLight1, "AA", 'A', Block.dirt);
		GameRegistry.addRecipe(sPole, "A", "A", "A", 'A', Block.dirt);
	}

	private void _addDebugRecipes()
	{
		ItemStack sMoreDirt = new ItemStack(Block.dirt, 64);
		ItemStack sFlint	= new ItemStack(Item.flintAndSteel);
		ItemStack sBench	= new ItemStack(Block.workbench);
		ItemStack sTorches	= new ItemStack(Block.torchWood, 64);
		
		try
		{
			GameRegistry.addRecipe(sMoreDirt,	"A", 'A', Block.dirt);
			GameRegistry.addRecipe(sFlint,		"AA", "A ", 'A', Block.dirt);
			GameRegistry.addRecipe(sBench,		"AA", "AA", 'A', Block.dirt);
			GameRegistry.addRecipe(sTorches,	"A","A", 'A', Block.dirt);
		}
		catch ( Exception __err)
		{
			
		}

	}

}

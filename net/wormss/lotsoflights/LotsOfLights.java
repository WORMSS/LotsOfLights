package net.wormss.lotsoflights;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.wormss.lotsoflights.blocks.ModBlocks;
import net.wormss.lotsoflights.data.ModConfiguration;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.items.ModItems;
import net.wormss.lotsoflights.proxy.CommonProxy;
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
	}
	
	@Init
	public void init(FMLInitializationEvent __e)
	{
		proxy.registerRenderers();
		
		ModBlocks.register();
		ModItems.register();
		
		_addDebugRecipes();
		_addRecipies();
	}

	private void _addRecipies()
	{
		ItemStack sLight1 = new ItemStack(ModBlocks.torch1, 64);
		
		GameRegistry.addRecipe(sLight1, "AA", 'A', Block.dirt);
	}

	private void _addDebugRecipes()
	{
		ItemStack sMoreDirt = new ItemStack(Block.dirt, 64);
		
		try
		{
			GameRegistry.addRecipe(sMoreDirt,	"A", 'A', Block.dirt);
		}
		catch ( Exception __err)
		{
			
		}

	}

}

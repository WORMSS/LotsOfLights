package net.wormss.lotsoflights;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.items.ModItems;
import net.wormss.lotsoflights.proxy.CommonProxy;
import net.wormss.lotsoflights.blocks.ModBlocks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

//,dependencies = "after:IC2"
@Mod(modid = ModReferences.ID, name = ModReferences.NAME, version = ModReferences.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class LotsOfLights
{
	@Instance(ModReferences.ID)
	public static LotsOfLights	instance;

	// Says where the client and server 'proxy' code is loaded.
	@SidedProxy(clientSide = ModReferences.CLIENT_PROXY, serverSide = ModReferences.COMMON_PROXY)
	public static CommonProxy	proxy;
	
	@Init
	public void init(FMLInitializationEvent __e)
	{
		proxy.registerRenderers();
		
		ModBlocks.register();
		
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

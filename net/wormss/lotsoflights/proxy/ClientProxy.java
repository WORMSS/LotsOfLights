package net.wormss.lotsoflights.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import net.wormss.lotsoflights.render.RenderBlockTorch1;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		MinecraftForgeClient.preloadTexture(ITEMS_PNG);
		MinecraftForgeClient.preloadTexture(BLOCK_PNG);
		
		RenderBlockTorch1.renderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBlockTorch1());
	}

}

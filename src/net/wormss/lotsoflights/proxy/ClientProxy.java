package net.wormss.lotsoflights.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.render.RenderBlockTorch1;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		MinecraftForgeClient.preloadTexture(ModReferences.TEXTURE_BLOCKS);
		MinecraftForgeClient.preloadTexture(ModReferences.TEXTURE_TORCH1);
		
		RenderBlockTorch1.renderID = RenderingRegistry.getNextAvailableRenderId();
		RenderingRegistry.registerBlockHandler(new RenderBlockTorch1());
	}

}

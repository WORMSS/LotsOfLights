package net.wormss.lotsoflights.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.render.ModRenderBlocks;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		MinecraftForgeClient.preloadTexture(ModReferences.TEXTURE_LAMP1);
		MinecraftForgeClient.preloadTexture(ModReferences.TEXTURE_POLE);
		
		_setupBlockRender(ModReferences.NAME_LAMP_1);
		_setupBlockRender(ModReferences.NAME_POLE);
	}
	
	private void _setupBlockRender(String name)
	{
		ModRenderBlocks.ids.put(name, RenderingRegistry.getNextAvailableRenderId());
		RenderingRegistry.registerBlockHandler(ModRenderBlocks.ids.get(name), ModRenderBlocks.instance());
	}

}

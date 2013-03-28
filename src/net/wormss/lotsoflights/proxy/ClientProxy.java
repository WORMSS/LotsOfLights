package net.wormss.lotsoflights.proxy;

import net.wormss.lotsoflights.data.ModReferences;
import net.wormss.lotsoflights.render.ModRenderBlocks;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		_setupBlockRender(ModReferences.NAME_VICTORIAN_LAMP);
		_setupBlockRender(ModReferences.NAME_POLE);
	}
	
	private void _setupBlockRender(String name)
	{
		int id = RenderingRegistry.getNextAvailableRenderId();
		ModRenderBlocks.ids.put(name, id);
		RenderingRegistry.registerBlockHandler(id, ModRenderBlocks.instance);
	}

}

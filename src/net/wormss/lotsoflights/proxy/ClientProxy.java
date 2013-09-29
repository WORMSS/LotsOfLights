package net.wormss.lotsoflights.proxy;

import net.wormss.lotsoflights.data.R;
import net.wormss.lotsoflights.render.ModRenderBlocks;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	@Override
	public void registerRenderers()
	{
		_setupBlockRender(R.NAME.VICTORIAN_LAMP);
		_setupBlockRender(R.NAME.VICTORIAN_POLE);
		_setupBlockRender(R.NAME.PLATFORM_SIDE_LAMP);
	}
	
	private void _setupBlockRender(String name)
	{
		/*int id = RenderingRegistry.getNextAvailableRenderId();
		ModRenderBlocks.ids.put(name, id);
		RenderingRegistry.registerBlockHandler(id, ModRenderBlocks.instance);*/
	}

}

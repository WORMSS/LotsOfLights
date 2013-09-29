package net.wormss.lotsoflights.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.wormss.lotsoflights.data.R;
import net.wormss.lotsoflights.render.ModRenderBlocks;
import net.wormss.utils.Trace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ModBlock extends Block
{
	private final Map<String, Icon> iconPool = new HashMap<String, Icon>();
	
	public ModBlock(int id, Material material)
	{
		super(id, material);
	}
	
	public ModBlock setBlockBounds(double minX, double minY, double minZ, double maxX, double maxY, double maxZ)
	{
		super.setBlockBounds((float)minX, (float)minY, (float)minZ, (float)maxX, (float)maxY, (float)maxZ);
		return this;
	}
	
	@Override
	public ModBlock setUnlocalizedName(String name)
	{
		super.setUnlocalizedName(name);
		
		if ( !ModRenderBlocks.ids.containsKey(name) )
		{
			ModRenderBlocks.ids.put(name, 0);
		}
		
		return this;
	}
	
	/*@Override
	public int getRenderType()
	{
		return ModRenderBlocks.ids.get(getUnlocalizedName());
	}*/
	
	public String getUnlocalizedName2()
	{
		return getUnlocalizedName().replace("tile.", "");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(R.MOD.ID + ":" + getUnlocalizedName2());
		
		/*for ( String key : iconPool.keySet() )
		{
			iconPool.put(key, iconRegister.registerIcon(R.MOD.ID + ":" + getUnlocalizedName2() + "_" + key));
		}*/
	}
	
	/**
	 * Adds icons to the pool ready for registerIcons to fill them. Must be filled out before registry.
	 * @param name Name to match icon with. Multiple can be added at once.
	 * @return the instance for chaining.
	 */
	public ModBlock addIconName(String... name)
	{
		for ( String s : name )
		{
			iconPool.put(s, null);
		}
		return this;
	}
	
	/**
	 * Retrieve the pool of icons created via the "addIconName" during the registerIcon phase
	 * @return returns the iconPool. Pool may be blank.
	 */
	public Map<String, Icon> getIconPool()
	{
		return iconPool;
	}
}

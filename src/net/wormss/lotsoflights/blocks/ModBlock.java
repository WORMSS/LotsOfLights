package net.wormss.lotsoflights.blocks;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.wormss.lotsoflights.data.ModReferences;
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
	
	@Override
	public int getRenderType()
	{
		return ModRenderBlocks.ids.get(getUnlocalizedName2());
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister)
	{
		blockIcon = iconRegister.registerIcon(ModReferences.ID + ":" + getUnlocalizedName2());
		
		for ( String key : iconPool.keySet() )
		{
			iconPool.put(key, iconRegister.registerIcon(ModReferences.ID + ":" + getUnlocalizedName2() + "_" + key));
		}
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
	 * Returns the Icon related to the names added by addIconName.
	 * @param name The name related to the icon.
	 * @return The icon related to the name, if called before registerIcon, null will be returned. If name invalid, blockIcon will be returned. 
	 */
	public Map<String, Icon> getIconPool()
	{
		return iconPool;
	}
}
